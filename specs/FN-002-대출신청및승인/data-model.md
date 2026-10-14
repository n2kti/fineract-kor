# [FN-002] DB 명세서

## 테이블 목록

| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan` | 대출 계좌의 기본 정보 및 원장(신청, 승인, 상태 등 핵심 엔티티) |
| `m_loan_approved_amount_history` | 대출 승인 금액 변경 이력 관리 |
| `m_loan_status_change_history` | 대출 계좌의 상태 전이(신청->승인->실행->종결 등) 이력 추적 |
| `m_loan_officer_assignment_history` | 대출 담당 대출심사역(Loan Officer) 배정 및 변경 이력 |
| `m_loan_originator` | 대출 모집인/대출 중개 기관 정보 관리 |
| `m_loan_originator_mapping` | 대출 계좌와 대출 모집인 간의 매핑 관계 |
| `m_loan_account_locks` | 대출 계좌 단위의 동시성 제어 및 트랜잭션 잠금 관리 |

## `m_loan` - 대출 계좌의 기본 정보 및 원장(신청, 승인, 상태 등 핵심 엔티티)

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan`의 고유 식별자 (PK) |
| `account_no` | VARCHAR(20) | NOT NULL, UNIQUE | 대출 계좌 고유 번호 |
| `external_id` | VARCHAR(100) | UNIQUE | 연계된 external 식별자 (FK) |
| `client_id` | BIGINT | DEFAULT NULL, FK -> m_client(id), RESTRICT | 연계된 client 식별자 (FK) |
| `group_id` | BIGINT | DEFAULT NULL, FK -> m_group(id), RESTRICT | 연계된 group 식별자 (FK) |
| `glim_id` | BIGINT | DEFAULT NULL, FK -> glim_accounts(id), RESTRICT | 연계된 glim 식별자 (FK) |
| `product_id` | BIGINT | DEFAULT NULL, FK -> m_product_loan(id), RESTRICT | 연계된 product 식별자 (FK) |
| `fund_id` | BIGINT | DEFAULT NULL, FK -> m_fund(id), RESTRICT | 연계된 fund 식별자 (FK) |
| `loan_officer_id` | BIGINT | DEFAULT NULL, FK -> m_staff(id), RESTRICT | 연계된 loan_officer 식별자 (FK) |
| `loanpurpose_cv_id` | INT | DEFAULT NULL, FK -> m_code_value(id), RESTRICT | 연계된 loanpurpose_cv 식별자 (FK) |
| `loan_status_id` | SMALLINT | NOT NULL | 연계된 loan_status 식별자 (FK) |
| `loan_type_enum` | SMALLINT | NOT NULL | loan_type_enum 속성값 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 속성값 |
| `currency_multiplesof` | SMALLINT | DEFAULT NULL | currency_multiplesof 속성값 |
| `principal_amount_proposed` | DECIMAL(19, 6) | NOT NULL | 대출 원금 관련 금액 |
| `principal_amount` | DECIMAL(19, 6) | NOT NULL | 대출 원금 관련 금액 |
| `approved_principal` | DECIMAL(19, 6) | NOT NULL | approved_principal 속성값 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NOT NULL | 해당 항목 금액/잔액 |
| `arrearstolerance_amount` | DECIMAL(19, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `is_floating_interest_rate` | boolean | DEFAULT false | is_floating_interest_rate 속성값 |
| `interest_rate_differential` | DECIMAL(19, 6) | DEFAULT 0.000000 | interest_rate_differential 속성값 |
| `nominal_interest_rate_per_period` | DECIMAL(19, 6) | DEFAULT NULL | nominal_interest_rate_per_period 속성값 |
| `interest_period_frequency_enum` | SMALLINT | DEFAULT NULL | interest_period_frequency_enum 속성값 |
| `annual_nominal_interest_rate` | DECIMAL(19, 6) | DEFAULT NULL | annual_nominal_interest_rate 속성값 |
| `interest_method_enum` | SMALLINT | NOT NULL | interest_method_enum 속성값 |
| `interest_calculated_in_period_enum` | SMALLINT | DEFAULT 1, NOT NULL | interest_calculated_in_period_enum 속성값 |
| `allow_partial_period_interest_calcualtion` | boolean | DEFAULT false, NOT NULL | allow_partial_period_interest_calcualtion 속성값 |
| `term_frequency` | SMALLINT | DEFAULT 0, NOT NULL | term_frequency 속성값 |
| `term_period_frequency_enum` | SMALLINT | DEFAULT 2, NOT NULL | term_period_frequency_enum 속성값 |
| `repay_every` | SMALLINT | NOT NULL | repay_every 속성값 |
| `repayment_period_frequency_enum` | SMALLINT | NOT NULL | repayment_period_frequency_enum 속성값 |
| `number_of_repayments` | SMALLINT | NOT NULL | number_of_repayments 속성값 |
| `grace_on_principal_periods` | SMALLINT | DEFAULT NULL | grace_on_principal_periods 속성값 |
| `recurring_moratorium_principal_periods` | SMALLINT | DEFAULT NULL | recurring_moratorium_principal_periods 속성값 |
| `grace_on_interest_periods` | SMALLINT | DEFAULT NULL | grace_on_interest_periods 속성값 |
| `grace_interest_free_periods` | SMALLINT | DEFAULT NULL | grace_interest_free_periods 속성값 |
| `amortization_method_enum` | SMALLINT | NOT NULL | amortization_method_enum 속성값 |
| `submittedon_date` | date | DEFAULT NULL | 신청/접수 일자 |
| `submittedon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | submittedon_userid 속성값 |
| `approvedon_date` | date | DEFAULT NULL | 승인 일자 |
| `approvedon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | approvedon_userid 속성값 |
| `expected_disbursedon_date` | date | DEFAULT NULL | 지급/실행 일자 |
| `expected_firstrepaymenton_date` | date | DEFAULT NULL | expected_firstrepaymenton_date 속성값 |
| `interest_calculated_from_date` | date | DEFAULT NULL | 시작 일자 |
| `disbursedon_date` | date | DEFAULT NULL | 지급/실행 일자 |
| `disbursedon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | disbursedon_userid 속성값 |
| `expected_maturedon_date` | date | DEFAULT NULL | expected_maturedon_date 속성값 |
| `maturedon_date` | date | DEFAULT NULL | maturedon_date 속성값 |
| `closedon_date` | date | DEFAULT NULL | 종결 일자 |
| `closedon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | closedon_userid 속성값 |
| `total_charges_due_at_disbursement_derived` | DECIMAL(19, 6) | DEFAULT NULL | total_charges_due_at_disbursement_derived 속성값 |
| `principal_disbursed_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 대출 원금 관련 금액 |
| `principal_repaid_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | principal_repaid_derived 속성값 |
| `principal_writtenoff_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | principal_writtenoff_derived 속성값 |
| `principal_outstanding_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | principal_outstanding_derived 속성값 |
| `interest_charged_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 이자 관련 금액 |
| `interest_repaid_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | interest_repaid_derived 속성값 |
| `interest_waived_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | interest_waived_derived 속성값 |
| `interest_writtenoff_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | interest_writtenoff_derived 속성값 |
| `interest_outstanding_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | interest_outstanding_derived 속성값 |
| `fee_charges_charged_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 수수료 관련 금액 |
| `fee_charges_repaid_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 수수료 관련 금액 |
| `fee_charges_waived_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 수수료 관련 금액 |
| `fee_charges_writtenoff_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 수수료 관련 금액 |
| `fee_charges_outstanding_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 수수료 관련 금액 |
| `penalty_charges_charged_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 연체료/과징금 금액 |
| `penalty_charges_repaid_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 연체료/과징금 금액 |
| `penalty_charges_waived_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 연체료/과징금 금액 |
| `penalty_charges_writtenoff_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 연체료/과징금 금액 |
| `penalty_charges_outstanding_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | 연체료/과징금 금액 |
| `total_expected_repayment_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_expected_repayment_derived 속성값 |
| `total_repayment_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_repayment_derived 속성값 |
| `total_expected_costofloan_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_expected_costofloan_derived 속성값 |
| `total_costofloan_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_costofloan_derived 속성값 |
| `total_waived_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_waived_derived 속성값 |
| `total_writtenoff_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_writtenoff_derived 속성값 |
| `total_outstanding_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_outstanding_derived 속성값 |
| `total_overpaid_derived` | DECIMAL(19, 6) | DEFAULT NULL | total_overpaid_derived 속성값 |
| `rejectedon_date` | date | DEFAULT NULL | rejectedon_date 속성값 |
| `rejectedon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | rejectedon_userid 속성값 |
| `rescheduledon_date` | date | DEFAULT NULL | rescheduledon_date 속성값 |
| `rescheduledon_userid` | BIGINT | DEFAULT NULL | rescheduledon_userid 속성값 |
| `withdrawnon_date` | date | DEFAULT NULL | withdrawnon_date 속성값 |
| `withdrawnon_userid` | BIGINT | DEFAULT NULL, FK -> m_appuser(id), RESTRICT | withdrawnon_userid 속성값 |
| `writtenoffon_date` | date | DEFAULT NULL | writtenoffon_date 속성값 |
| `loan_transaction_strategy_id` | BIGINT | DEFAULT NULL, FK -> ref_loan_transaction_processing_strategy(id), RESTRICT | 연계된 loan_transaction_strategy 식별자 (FK) |
| `sync_disbursement_with_meeting` | boolean | DEFAULT NULL | sync_disbursement_with_meeting 속성값 |
| `loan_counter` | SMALLINT | DEFAULT NULL | loan_counter 속성값 |
| `loan_product_counter` | SMALLINT | DEFAULT NULL | loan_product_counter 속성값 |
| `fixed_emi_amount` | DECIMAL(19, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `max_outstanding_loan_balance` | DECIMAL(19, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `grace_on_arrears_ageing` | SMALLINT | DEFAULT NULL | grace_on_arrears_ageing 속성값 |
| `is_npa` | boolean | DEFAULT false, NOT NULL | is_npa 속성값 |
| `total_recovered_derived` | DECIMAL(19, 6) | DEFAULT NULL | total_recovered_derived 속성값 |
| `accrued_till` | date | DEFAULT NULL | accrued_till 속성값 |
| `interest_recalcualated_on` | date | DEFAULT NULL | interest_recalcualated_on 속성값 |
| `days_in_month_enum` | SMALLINT | DEFAULT 1, NOT NULL | days_in_month_enum 속성값 |
| `days_in_year_enum` | SMALLINT | DEFAULT 1, NOT NULL | days_in_year_enum 속성값 |
| `interest_recalculation_enabled` | boolean | DEFAULT false, NOT NULL | interest_recalculation_enabled 속성값 |
| `guarantee_amount_derived` | DECIMAL(19, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `create_standing_instruction_at_disbursement` | boolean | DEFAULT NULL | create_standing_instruction_at_disbursement 속성값 |
| `version` | INT | DEFAULT 1, NOT NULL | 낙관적 락 엔티티 버전 번호 |
| `writeoff_reason_cv_id` | INT | DEFAULT NULL, FK -> m_code_value(id), RESTRICT | 연계된 writeoff_reason_cv 식별자 (FK) |
| `loan_sub_status_id` | SMALLINT | DEFAULT NULL | 연계된 loan_sub_status 식별자 (FK) |
| `is_topup` | boolean | DEFAULT false, NOT NULL | is_topup 속성값 |
| `is_equal_amortization` | boolean | DEFAULT false, NOT NULL | is_equal_amortization 속성값 |
| `fixed_principal_percentage_per_installment` | DECIMAL(5, 2) | DEFAULT NULL | 상환 회차 번호 |
| `enable_auto_repayment_for_down_payment` | boolean | DEFAULT false, NOT NULL | enable_auto_repayment_for_down_payment 속성값 |
| `disable_schedule_extension_for_down_payment` | boolean | DEFAULT false, NOT NULL | disable_schedule_extension_for_down_payment 속성값 |
| `loan_schedule_type` | varchar(20) | DEFAULT CUMULATIVE, NOT NULL | loan_schedule_type 속성값 |
| `loan_schedule_processing_type` | varchar(20) | DEFAULT HORIZONTAL, NOT NULL | loan_schedule_processing_type 속성값 |
| `fee_adjustments_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | fee_adjustments_derived 속성값 |
| `penalty_adjustments_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | penalty_adjustments_derived 속성값 |
| `fixed_length` | SMALLINT | NULL | fixed_length 속성값 |
| `supported_interest_refund_types` | TEXT | NULL | supported_interest_refund_types 속성값 |
| `charge_off_behaviour` | varchar(20) | DEFAULT REGULAR | charge_off_behaviour 속성값 |
| `interest_recognition_on_disbursement_date` | boolean | DEFAULT false, NOT NULL | interest_recognition_on_disbursement_date 속성값 |
| `installment_amount_in_multiples_of` | DECIMAL(19, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `is_merchant_buy_down_fee` | boolean | DEFAULT true, NOT NULL | is_merchant_buy_down_fee 속성값 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 레코드 생성 일시 |
| `created_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 레코드 최종 수정 일시 |
| `principal_adjustments_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | principal_adjustments_derived 속성값 |
| `is_fraud` | boolean | DEFAULT false, NOT NULL | is_fraud 속성값 |
| `loan_transaction_strategy_code` | VARCHAR(100) | DEFAULT -, NOT NULL | loan_transaction_strategy_code 속성값 |
| `loan_transaction_strategy_name` | VARCHAR(100) | DEFAULT -, NOT NULL | 명칭/이름 |
| `last_closed_business_date` | DATE | NULL | last_closed_business_date 속성값 |
| `overpaidon_date` | date | NULL | overpaidon_date 속성값 |
| `is_charged_off` | boolean | DEFAULT false, NOT NULL | is_charged_off 속성값 |
| `charged_off_on_date` | date | DEFAULT NULL | charged_off_on_date 속성값 |
| `charge_off_reason_cv_id` | BIGINT | DEFAULT NULL | 연계된 charge_off_reason_cv 식별자 (FK) |
| `charged_off_by_userid` | BIGINT | DEFAULT NULL | charged_off_by_userid 속성값 |
| `enable_down_payment` | boolean | DEFAULT false, NOT NULL | enable_down_payment 속성값 |
| `disbursed_amount_percentage_for_down_payment` | DECIMAL(9, 6) | DEFAULT NULL | 해당 항목 금액/잔액 |
| `enable_installment_level_delinquency` | boolean | DEFAULT false, NOT NULL | 상환 회차 번호 |
| `enable_accrual_activity_posting` | boolean | DEFAULT false, NOT NULL | enable_accrual_activity_posting 속성값 |
| `days_in_year_custom_strategy` | VARCHAR(100) | NULL | days_in_year_custom_strategy 속성값 |
| `enable_income_capitalization` | boolean | DEFAULT false, NOT NULL | enable_income_capitalization 속성값 |
| `capitalized_income_calculation_type` | VARCHAR(100) | NULL | capitalized_income_calculation_type 속성값 |
| `capitalized_income_strategy` | VARCHAR(100) | NULL | capitalized_income_strategy 속성값 |
| `capitalized_income_type` | VARCHAR(10) | NULL | capitalized_income_type 속성값 |
| `capitalized_income_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | capitalized_income_derived 속성값 |
| `capitalized_income_adjustment_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | capitalized_income_adjustment_derived 속성값 |
| `total_principal_derived` | DECIMAL(19, 6) | DEFAULT 0.000000, NOT NULL | total_principal_derived 속성값 |
| `enable_buy_down_fee` | boolean | DEFAULT false, NOT NULL | enable_buy_down_fee 속성값 |
| `buy_down_fee_calculation_type` | VARCHAR(100) | NULL | buy_down_fee_calculation_type 속성값 |
| `buy_down_fee_strategy` | VARCHAR(100) | NULL | buy_down_fee_strategy 속성값 |
| `buy_down_fee_income_type` | VARCHAR(100) | NULL | buy_down_fee_income_type 속성값 |
| `allow_full_term_for_tranche` | boolean | DEFAULT false, NOT NULL | allow_full_term_for_tranche 속성값 |
| `repayment_start_date_type_enum` | SMALLINT | NULL | repayment_start_date_type_enum 속성값 |

## `m_loan_approved_amount_history` - 대출 승인 금액 변경 이력 관리

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_approved_amount_history`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `new_approved_amount` | DECIMAL(19, 6) | NOT NULL | 해당 항목 금액/잔액 |
| `old_approved_amount` | DECIMAL(19, 6) | NOT NULL | 해당 항목 금액/잔액 |
| `created_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `created_on_utc` | timestamp with time zone | NULL | 레코드 생성 일시 |
| `last_modified_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `last_modified_on_utc` | timestamp with time zone | NULL | 레코드 최종 수정 일시 |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_approved_amount_history`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `new_approved_amount` | DECIMAL(19, 6) | NOT NULL | 해당 항목 금액/잔액 |
| `old_approved_amount` | DECIMAL(19, 6) | NOT NULL | 해당 항목 금액/잔액 |
| `created_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `created_on_utc` | DATETIME | NULL | 레코드 생성 일시 |
| `last_modified_by` | BIGINT | FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `last_modified_on_utc` | DATETIME | NULL | 레코드 최종 수정 일시 |

## `m_loan_status_change_history` - 대출 계좌의 상태 전이(신청->승인->실행->종결 등) 이력 추적

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_status_change_history`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | 연계된 loan 식별자 (FK) |
| `status_code` | VARCHAR(255) | NOT NULL | status_code 속성값 |
| `status_change_business_date` | date | NOT NULL | status_change_business_date 속성값 |
| `created_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 생성 일시 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 최종 수정 일시 |

## `m_loan_officer_assignment_history` - 대출 담당 대출심사역(Loan Officer) 배정 및 변경 이력

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_officer_assignment_history`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `loan_officer_id` | BIGINT | DEFAULT NULL, FK -> m_staff(id), RESTRICT | 연계된 loan_officer 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 속성값 |
| `end_date` | date | DEFAULT NULL | end_date 속성값 |
| `createdby_id` | BIGINT | DEFAULT NULL | 연계된 createdby 식별자 (FK) |
| `created_date` | datetime | DEFAULT NULL | 레코드 생성 일시 |
| `lastmodified_date` | datetime | DEFAULT NULL | 레코드 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | DEFAULT NULL | 연계된 lastmodifiedby 식별자 (FK) |

## `m_loan_originator` - 대출 모집인/대출 중개 기관 정보 관리

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_originator`의 고유 식별자 (PK) |
| `external_id` | VARCHAR(100) | NOT NULL, UNIQUE | 연계된 external 식별자 (FK) |
| `name` | VARCHAR(255) | NULL | 명칭/이름 |
| `status` | VARCHAR(20) | NOT NULL | 상태 구분 코드 |
| `originator_type_cv_id` | INT | FK -> m_code_value(id), RESTRICT | 연계된 originator_type_cv 식별자 (FK) |
| `channel_type_cv_id` | INT | FK -> m_code_value(id), RESTRICT | 연계된 channel_type_cv 식별자 (FK) |
| `created_on_utc` | DATETIME | NOT NULL | 레코드 생성 일시 |
| `created_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_on_utc` | DATETIME | NOT NULL | 레코드 최종 수정 일시 |
| `last_modified_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_originator`의 고유 식별자 (PK) |
| `external_id` | VARCHAR(100) | NOT NULL, UNIQUE | 연계된 external 식별자 (FK) |
| `name` | VARCHAR(255) | NULL | 명칭/이름 |
| `status` | VARCHAR(20) | NOT NULL | 상태 구분 코드 |
| `originator_type_cv_id` | INT | FK -> m_code_value(id), RESTRICT | 연계된 originator_type_cv 식별자 (FK) |
| `channel_type_cv_id` | INT | FK -> m_code_value(id), RESTRICT | 연계된 channel_type_cv 식별자 (FK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 생성 일시 |
| `created_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 최종 수정 일시 |
| `last_modified_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |

## `m_loan_originator_mapping` - 대출 계좌와 대출 모집인 간의 매핑 관계

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_originator_mapping`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `originator_id` | BIGINT | NOT NULL, FK -> m_loan_originator(id), RESTRICT | 연계된 originator 식별자 (FK) |
| `created_on_utc` | DATETIME | NOT NULL | 레코드 생성 일시 |
| `created_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_on_utc` | DATETIME | NOT NULL | 레코드 최종 수정 일시 |
| `last_modified_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |
| `id` | BIGINT | AUTO_INCREMENT, PK, NOT NULL | `m_loan_originator_mapping`의 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `originator_id` | BIGINT | NOT NULL, FK -> m_loan_originator(id), RESTRICT | 연계된 originator 식별자 (FK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 생성 일시 |
| `created_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 생성자 ID |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 레코드 최종 수정 일시 |
| `last_modified_by` | BIGINT | NOT NULL, FK -> m_appuser(id), RESTRICT | 레코드 최종 수정자 ID |

## `m_loan_account_locks` - 대출 계좌 단위의 동시성 제어 및 트랜잭션 잠금 관리

| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `loan_id` | BIGINT | PK, NOT NULL, FK -> m_loan(id), RESTRICT | 연계된 loan 식별자 (FK) |
| `lock_owner` | VARCHAR(100) | NOT NULL | lock_owner 속성값 |
| `lock_placed_on` | timestamp | NOT NULL | lock_placed_on 속성값 |
| `error` | VARCHAR(255) | NULL | error 속성값 |
| `stacktrace` | VARCHAR(255) | NULL | stacktrace 속성값 |
| `version` | BIGINT | NOT NULL | 낙관적 락 엔티티 버전 번호 |
| `lock_placed_on_cob_business_date` | DATE | NULL | lock_placed_on_cob_business_date 속성값 |

## 관계도

```mermaid
erDiagram
    m_loan ||--o{ m_loan_approved_amount_history : tracks_approval
    m_loan ||--o{ m_loan_status_change_history : tracks_status
    m_loan ||--o{ m_loan_officer_assignment_history : assigns_officer
    m_loan ||--o{ m_loan_originator_mapping : mapped_to
    m_loan_originator ||--o{ m_loan_originator_mapping : originates
    m_loan ||--o{ m_loan_account_locks : locked_by

    m_loan {
        BIGINT id PK
        VARCHAR account_no UK
        BIGINT client_id FK
        BIGINT product_id FK
        INTEGER loan_status_id
        DECIMAL principal_amount
        DATE submittedon_date
        DATE approvedon_date
        DATE expected_disbursedon_date
    }

    m_loan_approved_amount_history {
        BIGINT id PK
        BIGINT loan_id FK
        DECIMAL approved_amount
    }

    m_loan_status_change_history {
        BIGINT id PK
        BIGINT loan_id FK
        INTEGER status_id
    }

    m_loan_officer_assignment_history {
        BIGINT id PK
        BIGINT loan_id FK
        BIGINT loan_officer_id FK
    }

    m_loan_originator {
        BIGINT id PK
        VARCHAR external_id UK
        VARCHAR name
    }

    m_loan_originator_mapping {
        BIGINT id PK
        BIGINT loan_id FK
        BIGINT loan_originator_id FK
    }

    m_loan_account_locks {
        BIGINT loan_id PK
        VARCHAR lock_owner
    }
```

## 근거
* `fineract-loan-origination/src/main/resources/db/changelog/tenant/module/loanorigination/parts/0001_initial_schema.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1003_add_loan_product_auto_repayment_down_payment_configuration.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1007_add_loan_product_schedule_extension_for_down_payment_configuration.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1010_introduce_loan_schedule_type_configuration.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1012_introduce_loan_schedule_processing_type_configuration.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1017_add_fee_and_penalty_adjustments_to_loan.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1019_add_fixed_length.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1021_add_loan_status_change_history.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1022_add_interest_refund_support.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1023_add_charge_off_behaviour.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1026_add_interest_recognition_flag.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1029_add_installment_amount_in_multiples_of_to_loan.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1031_loan_merchant_buy_down_fee.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0020_add_audit_entries.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0039_add_loan_account_locks.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0048_rework_loan_account_locks.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0057_add_principal_adjustments_to_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0062_add_fraud_attribute_to_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0064_refactor_loan_transaction_strategy.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0074_add_last_cob_business_date_column_to_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0077_add_overpaid_date_for_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0079_add_charge_off_details_to_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0086_add_cob_business_date_to_loan_account_locks.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0119_add_loan_product_down_payment_configuration.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0126_add_loan_product_installment_level_delinquency.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0142_add_accrual_activity_transaction.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0170_days_in_year_custom_strategy.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0171_loan_capitalized_income.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0174_loan_product_add_capitalized_income_type.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0178_add_principal_from_capitalized_income_to_loan_summary.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0185_loan_buy_down_fee.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0192_create_loan_approved_amount_history.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0207_add_allow_full_term_for_tranche.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0232_add_repayment_start_date_to_loan.xml`
* `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
