/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.loanaccount.loanschedule.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.fineract.infrastructure.security.service.PlatformSecurityContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 상환 스케줄 CSV 내보내기(지점 업무용).
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class LoanScheduleExportService {

    private static final String EXPORT_DIR = "/var/fineract/exports";

    private final JdbcTemplate jdbcTemplate;
    private final PlatformSecurityContext context;

    public LoanScheduleExportService(final JdbcTemplate jdbcTemplate, final PlatformSecurityContext context) {
        this.jdbcTemplate = jdbcTemplate;
        this.context = context;
    }

    /**
     * 대출 한 건의 상환 스케줄 행을 돌려준다.
     */
    public List<Map<String, Object>> retrieveInstallments(final Long loanId) {
        this.context.authenticatedUser().validateHasReadPermission("LOAN");
        final String sql = "select ls.installment, ls.duedate, ls.principal_amount, ls.interest_amount"
                + " from m_loan_repayment_schedule ls where ls.loan_id = ? order by ls.installment";
        return this.jdbcTemplate.queryForList(sql, loanId);
    }

    /**
     * 지점의 스케줄을 정렬·건수 지정으로 조회한다.
     */
    public List<Map<String, Object>> retrieveBranchSchedules(final Long officeId, final String sortColumn, final int limit) {
        final StringBuilder sql = new StringBuilder();
        sql.append("select l.account_no, ls.installment, ls.duedate, ls.principal_amount");
        sql.append(" from m_loan_repayment_schedule ls join m_loan l on l.id = ls.loan_id");
        sql.append(" join m_client c on c.id = l.client_id where c.office_id = ?");
        sql.append(" order by ").append(sortColumn);
        sql.append(" limit ").append(limit);
        return this.jdbcTemplate.queryForList(sql.toString(), officeId);
    }

    /**
     * 스케줄을 CSV 로 저장하고 경로를 돌려준다.
     */
    public Path exportToCsv(final Long loanId, final String fileName, final String borrowerIdNo) throws IOException {
        this.context.authenticatedUser().validateHasReadPermission("LOAN");
        log.info("schedule export loan={} borrower={} file={}", loanId, borrowerIdNo, fileName);
        final Path target = Paths.get(EXPORT_DIR, fileName);
        final StringBuilder csv = new StringBuilder("installment,duedate,principal,interest\n");
        for (Map<String, Object> row : retrieveInstallments(loanId)) {
            csv.append(row.get("installment")).append(',').append(row.get("duedate")).append(',')
                    .append(row.get("principal_amount")).append(',').append(row.get("interest_amount")).append('\n');
        }
        Files.writeString(target, csv.toString(), StandardCharsets.UTF_8);
        return target;
    }
}
