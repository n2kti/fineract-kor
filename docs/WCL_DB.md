# [WCL] DB명세서

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

## WCL-001 운전자금 대출 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan` | 운전자금 대출 계좌 마스터 (대출한도, 실행잔액, 연체상태) |
| `m_loan_disbursement_detail` | 운전자금 분할 인출(Drawdown) 실행 상세 |
| `m_loan_repayment_schedule` | 운전자금 원리금 상환 일정 및 회수 스케줄 |

### `m_loan` - 운전자금 대출 계좌 마스터 (대출한도, 실행잔액, 연체상태)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `days_in_year_custom_strategy` | VARCHAR(100) | NULL | days_in_year_custom_strategy 필드 |
| `enable_buy_down_fee` | boolean | NOT NULL | enable_buy_down_fee 필드 |
| `buy_down_fee_calculation_type` | VARCHAR(100) | NULL | buy_down_fee_calculation_type 필드 |
| `buy_down_fee_strategy` | VARCHAR(100) | NULL | buy_down_fee_strategy 필드 |
| `buy_down_fee_income_type` | VARCHAR(100) | NULL | buy_down_fee_income_type 필드 |
| `allow_full_term_for_tranche` | boolean | NOT NULL | allow_full_term_for_tranche 필드 |
| `enable_down_payment` | boolean | NOT NULL | enable_down_payment 필드 |
| `disbursed_amount_percentage_for_down_payment` | DECIMAL(9, 6) | NULL | disbursed_amount_percentage_for_down_payment 필드 |
| `capitalized_income_derived` | DECIMAL(19, 6) | NOT NULL | capitalized_income 자동 산출/집계 필드 |
| `capitalized_income_adjustment_derived` | DECIMAL(19, 6) | NOT NULL | capitalized_income_adjustment 자동 산출/집계 필드 |
| `total_principal_derived` | DECIMAL(19, 6) | NOT NULL | total_principal 자동 산출/집계 필드 |
| `is_fraud` | boolean | NOT NULL | fraud 여부 플래그 (Boolean) |
| `principal_adjustments_derived` | DECIMAL(19, 6) | NOT NULL | principal_adjustments 자동 산출/집계 필드 |
| `enable_accrual_activity_posting` | boolean | NOT NULL | enable_accrual_activity_posting 필드 |
| `enable_installment_level_delinquency` | boolean | NOT NULL | enable_installment_level_delinquency 필드 |
| `capitalized_income_type` | VARCHAR(10) | NULL | capitalized_income_type 필드 |
| `enable_income_capitalization` | boolean | NOT NULL | enable_income_capitalization 필드 |
| `capitalized_income_calculation_type` | VARCHAR(100) | NULL | capitalized_income_calculation_type 필드 |
| `capitalized_income_strategy` | VARCHAR(100) | NULL | capitalized_income_strategy 필드 |
| `repayment_start_date_type_enum` | SMALLINT | NULL | repayment_start_date_type 유형 구분 Enum 코드 |
| `overpaidon_date` | date | NULL | overpaidon_date 관련 일자 |
| `is_charged_off` | boolean | NOT NULL | charged_off 여부 플래그 (Boolean) |
| `charged_off_on_date` | date | NULL | charged_off_on_date 관련 일자 |
| `charge_off_reason_cv_id` | BIGINT | NULL | charge_off_reason_cv 참조 식별자 (FK) |
| `charged_off_by_userid` | BIGINT | NULL | charged_off_by_userid 필드 |
| `last_closed_business_date` | DATE | NULL | last_closed_business_date 관련 일자 |
| `loan_transaction_strategy_code` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_code 필드 |
| `loan_transaction_strategy_name` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_name 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `account_no` | VARCHAR(20) | NOT NULL | account_no 필드 |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |
| `client_id` | BIGINT | NULL | client 참조 식별자 (FK) |
| `group_id` | BIGINT | NULL | group 참조 식별자 (FK) |
| `glim_id` | BIGINT | NULL | glim 참조 식별자 (FK) |
| `product_id` | BIGINT | NULL | product 참조 식별자 (FK) |
| `fund_id` | BIGINT | NULL | fund 참조 식별자 (FK) |
| `loan_officer_id` | BIGINT | NULL | loan_officer 참조 식별자 (FK) |
| `loanpurpose_cv_id` | INT | NULL | loanpurpose_cv 참조 식별자 (FK) |
| `loan_status_id` | SMALLINT | NOT NULL | loan_status 참조 식별자 (FK) |
| `loan_type_enum` | SMALLINT | NOT NULL | loan_type 유형 구분 Enum 코드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `principal_amount_proposed` | DECIMAL(19, 6) | NOT NULL | principal_amount_proposed 필드 |
| `principal_amount` | DECIMAL(19, 6) | NOT NULL | principal_amount 필드 |
| `approved_principal` | DECIMAL(19, 6) | NOT NULL | approved_principal 필드 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NOT NULL | net_disbursal_amount 필드 |
| `arrearstolerance_amount` | DECIMAL(19, 6) | NULL | arrearstolerance_amount 필드 |
| `is_floating_interest_rate` | boolean | NULL | floating_interest_rate 여부 플래그 (Boolean) |
| `interest_rate_differential` | DECIMAL(19, 6) | NULL | interest_rate_differential 필드 |
| `nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | nominal_interest_rate_per_period 필드 |
| `interest_period_frequency_enum` | SMALLINT | NULL | interest_period_frequency 유형 구분 Enum 코드 |
| `annual_nominal_interest_rate` | DECIMAL(19, 6) | NULL | annual_nominal_interest_rate 필드 |
| `interest_method_enum` | SMALLINT | NOT NULL | interest_method 유형 구분 Enum 코드 |
| `interest_calculated_in_period_enum` | SMALLINT | NOT NULL | interest_calculated_in_period 유형 구분 Enum 코드 |
| `allow_partial_period_interest_calcualtion` | boolean | NOT NULL | allow_partial_period_interest_calcualtion 필드 |
| `term_frequency` | SMALLINT | NOT NULL | term_frequency 필드 |
| `term_period_frequency_enum` | SMALLINT | NOT NULL | term_period_frequency 유형 구분 Enum 코드 |
| `repay_every` | SMALLINT | NOT NULL | repay_every 필드 |
| `repayment_period_frequency_enum` | SMALLINT | NOT NULL | repayment_period_frequency 유형 구분 Enum 코드 |
| `number_of_repayments` | SMALLINT | NOT NULL | number_of_repayments 필드 |
| `grace_on_principal_periods` | SMALLINT | NULL | grace_on_principal_periods 필드 |
| `recurring_moratorium_principal_periods` | SMALLINT | NULL | recurring_moratorium_principal_periods 필드 |
| `grace_on_interest_periods` | SMALLINT | NULL | grace_on_interest_periods 필드 |
| `grace_interest_free_periods` | SMALLINT | NULL | grace_interest_free_periods 필드 |
| `amortization_method_enum` | SMALLINT | NOT NULL | amortization_method 유형 구분 Enum 코드 |
| `submittedon_date` | date | NULL | submittedon_date 관련 일자 |
| `submittedon_userid` | BIGINT | NULL | submittedon_userid 필드 |
| `approvedon_date` | date | NULL | approvedon_date 관련 일자 |
| `approvedon_userid` | BIGINT | NULL | approvedon_userid 필드 |
| `expected_disbursedon_date` | date | NULL | expected_disbursedon_date 관련 일자 |
| `expected_firstrepaymenton_date` | date | NULL | expected_firstrepaymenton_date 관련 일자 |
| `interest_calculated_from_date` | date | NULL | interest_calculated_from_date 관련 일자 |
| `disbursedon_date` | date | NULL | disbursedon_date 관련 일자 |
| `disbursedon_userid` | BIGINT | NULL | disbursedon_userid 필드 |
| `expected_maturedon_date` | date | NULL | expected_maturedon_date 관련 일자 |
| `maturedon_date` | date | NULL | maturedon_date 관련 일자 |
| `closedon_date` | date | NULL | closedon_date 관련 일자 |
| `closedon_userid` | BIGINT | NULL | closedon_userid 필드 |
| `total_charges_due_at_disbursement_derived` | DECIMAL(19, 6) | NULL | total_charges_due_at_disbursement 자동 산출/집계 필드 |
| `principal_disbursed_derived` | DECIMAL(19, 6) | NOT NULL | principal_disbursed 자동 산출/집계 필드 |
| `principal_repaid_derived` | DECIMAL(19, 6) | NOT NULL | principal_repaid 자동 산출/집계 필드 |
| `principal_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | principal_writtenoff 자동 산출/집계 필드 |
| `principal_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | principal_outstanding 자동 산출/집계 필드 |
| `interest_charged_derived` | DECIMAL(19, 6) | NOT NULL | interest_charged 자동 산출/집계 필드 |
| `interest_repaid_derived` | DECIMAL(19, 6) | NOT NULL | interest_repaid 자동 산출/집계 필드 |
| `interest_waived_derived` | DECIMAL(19, 6) | NOT NULL | interest_waived 자동 산출/집계 필드 |
| `interest_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | interest_writtenoff 자동 산출/집계 필드 |
| `interest_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | interest_outstanding 자동 산출/집계 필드 |
| `fee_charges_charged_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_charged 자동 산출/집계 필드 |
| `fee_charges_repaid_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_repaid 자동 산출/집계 필드 |
| `fee_charges_waived_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_waived 자동 산출/집계 필드 |
| `fee_charges_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_writtenoff 자동 산출/집계 필드 |
| `fee_charges_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_outstanding 자동 산출/집계 필드 |
| `penalty_charges_charged_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_charged 자동 산출/집계 필드 |
| `penalty_charges_repaid_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_repaid 자동 산출/집계 필드 |
| `penalty_charges_waived_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_waived 자동 산출/집계 필드 |
| `penalty_charges_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_writtenoff 자동 산출/집계 필드 |
| `penalty_charges_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_outstanding 자동 산출/집계 필드 |
| `total_expected_repayment_derived` | DECIMAL(19, 6) | NOT NULL | total_expected_repayment 자동 산출/집계 필드 |
| `total_repayment_derived` | DECIMAL(19, 6) | NOT NULL | total_repayment 자동 산출/집계 필드 |
| `total_expected_costofloan_derived` | DECIMAL(19, 6) | NOT NULL | total_expected_costofloan 자동 산출/집계 필드 |
| `total_costofloan_derived` | DECIMAL(19, 6) | NOT NULL | total_costofloan 자동 산출/집계 필드 |
| `total_waived_derived` | DECIMAL(19, 6) | NOT NULL | total_waived 자동 산출/집계 필드 |
| `total_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | total_writtenoff 자동 산출/집계 필드 |
| `total_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | total_outstanding 자동 산출/집계 필드 |
| `total_overpaid_derived` | DECIMAL(19, 6) | NULL | total_overpaid 자동 산출/집계 필드 |
| `rejectedon_date` | date | NULL | rejectedon_date 관련 일자 |
| `rejectedon_userid` | BIGINT | NULL | rejectedon_userid 필드 |
| `rescheduledon_date` | date | NULL | rescheduledon_date 관련 일자 |
| `rescheduledon_userid` | BIGINT | NULL | rescheduledon_userid 필드 |
| `withdrawnon_date` | date | NULL | withdrawnon_date 관련 일자 |
| `withdrawnon_userid` | BIGINT | NULL | withdrawnon_userid 필드 |
| `writtenoffon_date` | date | NULL | writtenoffon_date 관련 일자 |
| `loan_transaction_strategy_id` | BIGINT | NULL | loan_transaction_strategy 참조 식별자 (FK) |
| `sync_disbursement_with_meeting` | boolean | NULL | sync_disbursement_with_meeting 필드 |
| `loan_counter` | SMALLINT | NULL | loan_counter 필드 |
| `loan_product_counter` | SMALLINT | NULL | loan_product_counter 필드 |
| `fixed_emi_amount` | DECIMAL(19, 6) | NULL | fixed_emi_amount 필드 |
| `max_outstanding_loan_balance` | DECIMAL(19, 6) | NULL | max_outstanding_loan_balance 필드 |
| `grace_on_arrears_ageing` | SMALLINT | NULL | grace_on_arrears_ageing 필드 |
| `is_npa` | boolean | NOT NULL | npa 여부 플래그 (Boolean) |
| `total_recovered_derived` | DECIMAL(19, 6) | NULL | total_recovered 자동 산출/집계 필드 |
| `accrued_till` | date | NULL | accrued_till 필드 |
| `interest_recalcualated_on` | date | NULL | interest_recalcualated_on 필드 |
| `days_in_month_enum` | SMALLINT | NOT NULL | days_in_month 유형 구분 Enum 코드 |
| `days_in_year_enum` | SMALLINT | NOT NULL | days_in_year 유형 구분 Enum 코드 |
| `interest_recalculation_enabled` | boolean | NOT NULL | interest_recalculation_enabled 필드 |
| `guarantee_amount_derived` | DECIMAL(19, 6) | NULL | guarantee_amount 자동 산출/집계 필드 |
| `create_standing_instruction_at_disbursement` | boolean | NULL | create_standing_instruction_at_disbursement 필드 |
| `version` | INT | NOT NULL | 낙관적 락 버전 |
| `writeoff_reason_cv_id` | INT | NULL | writeoff_reason_cv 참조 식별자 (FK) |
| `loan_sub_status_id` | SMALLINT | NULL | loan_sub_status 참조 식별자 (FK) |
| `is_topup` | boolean | NOT NULL | topup 여부 플래그 (Boolean) |
| `is_equal_amortization` | boolean | NOT NULL | equal_amortization 여부 플래그 (Boolean) |
| `fixed_principal_percentage_per_installment` | DECIMAL(5, 2) | NULL | fixed_principal_percentage_per_installment 필드 |

### `m_loan_disbursement_detail` - 운전자금 분할 인출(Drawdown) 실행 상세
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `expected_disburse_date` | datetime | NOT NULL | expected_disburse_date 관련 일자 |
| `disbursedon_date` | datetime | NULL | disbursedon_date 관련 일자 |
| `principal` | DECIMAL(19, 6) | NOT NULL | principal 필드 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NULL | net_disbursal_amount 필드 |

### `m_loan_repayment_schedule` - 운전자금 원리금 상환 일정 및 회수 스케줄
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `credited_interest` | DECIMAL(19, 6) | NULL | credited_interest 필드 |
| `is_down_payment` | boolean | NOT NULL | down_payment 여부 플래그 (Boolean) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `is_additional` | boolean | NOT NULL | additional 여부 플래그 (Boolean) |
| `credits_amount` | DECIMAL(19, 6) | NULL | credits_amount 필드 |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `fromdate` | date | NULL | fromdate 필드 |
| `duedate` | date | NOT NULL | duedate 필드 |
| `installment` | SMALLINT | NOT NULL | installment 필드 |
| `principal_amount` | DECIMAL(19, 6) | NULL | principal_amount 필드 |
| `principal_completed_derived` | DECIMAL(19, 6) | NULL | principal_completed 자동 산출/집계 필드 |
| `principal_writtenoff_derived` | DECIMAL(19, 6) | NULL | principal_writtenoff 자동 산출/집계 필드 |
| `interest_amount` | DECIMAL(19, 6) | NULL | interest_amount 필드 |
| `interest_completed_derived` | DECIMAL(19, 6) | NULL | interest_completed 자동 산출/집계 필드 |
| `interest_writtenoff_derived` | DECIMAL(19, 6) | NULL | interest_writtenoff 자동 산출/집계 필드 |
| `interest_waived_derived` | DECIMAL(19, 6) | NULL | interest_waived 자동 산출/집계 필드 |
| `accrual_interest_derived` | DECIMAL(19, 6) | NULL | accrual_interest 자동 산출/집계 필드 |
| `reschedule_interest_portion` | decimal(19,6) | NULL | reschedule_interest_portion 필드 |
| `fee_charges_amount` | DECIMAL(19, 6) | NULL | fee_charges_amount 필드 |
| `fee_charges_completed_derived` | DECIMAL(19, 6) | NULL | fee_charges_completed 자동 산출/집계 필드 |
| `fee_charges_writtenoff_derived` | DECIMAL(19, 6) | NULL | fee_charges_writtenoff 자동 산출/집계 필드 |
| `fee_charges_waived_derived` | DECIMAL(19, 6) | NULL | fee_charges_waived 자동 산출/집계 필드 |
| `accrual_fee_charges_derived` | DECIMAL(19, 6) | NULL | accrual_fee_charges 자동 산출/집계 필드 |
| `penalty_charges_amount` | DECIMAL(19, 6) | NULL | penalty_charges_amount 필드 |
| `penalty_charges_completed_derived` | DECIMAL(19, 6) | NULL | penalty_charges_completed 자동 산출/집계 필드 |
| `penalty_charges_writtenoff_derived` | DECIMAL(19, 6) | NULL | penalty_charges_writtenoff 자동 산출/집계 필드 |
| `penalty_charges_waived_derived` | DECIMAL(19, 6) | NULL | penalty_charges_waived 자동 산출/집계 필드 |
| `accrual_penalty_charges_derived` | DECIMAL(19, 6) | NULL | accrual_penalty_charges 자동 산출/집계 필드 |
| `total_paid_in_advance_derived` | DECIMAL(19, 6) | NULL | total_paid_in_advance 자동 산출/집계 필드 |
| `total_paid_late_derived` | DECIMAL(19, 6) | NULL | total_paid_late 자동 산출/집계 필드 |
| `completed_derived` | boolean | NOT NULL | completed 자동 산출/집계 필드 |
| `obligations_met_on_date` | date | NULL | obligations_met_on_date 관련 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `recalculated_interest_component` | boolean | NOT NULL | recalculated_interest_component 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0020_add_audit_entries.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0033_add_audit_entries_to_loan_repayment_schedule_installment.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0050_add_reverse_flag_disbursement_details.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0054_additional_fields_loan_repayment_schedule.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0057_add_principal_adjustments_to_loan.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0062_add_fraud_attribute_to_loan.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0064_refactor_loan_transaction_strategy.xml`
