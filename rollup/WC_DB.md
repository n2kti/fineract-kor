# [WC] DB명세서 (운전자금)

> 소분류 3개 롤업.


---

## [WCL] DB명세서

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

### WCL-001 운전자금 대출 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan` | 운전자금 대출 계좌 마스터 (대출한도, 실행잔액, 연체상태) |
| `m_loan_disbursement_detail` | 운전자금 분할 인출(Drawdown) 실행 상세 |
| `m_loan_repayment_schedule` | 운전자금 원리금 상환 일정 및 회수 스케줄 |

#### `m_loan` - 운전자금 대출 계좌 마스터 (대출한도, 실행잔액, 연체상태)
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

#### `m_loan_disbursement_detail` - 운전자금 분할 인출(Drawdown) 실행 상세
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `expected_disburse_date` | datetime | NOT NULL | expected_disburse_date 관련 일자 |
| `disbursedon_date` | datetime | NULL | disbursedon_date 관련 일자 |
| `principal` | DECIMAL(19, 6) | NOT NULL | principal 필드 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NULL | net_disbursal_amount 필드 |

#### `m_loan_repayment_schedule` - 운전자금 원리금 상환 일정 및 회수 스케줄
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

### 근거
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

---

## [WCP] DB명세서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

### WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_loan` | 운전자금 대출 상품 설정 (신용공여한도, 금리체계, 회계매핑) |
| `m_delinquency_bucket` | 연체 구간(Delinquency Bucket) 및 한도위반 감지 규칙 마스터 |
| `m_delinquency_range` | 연체 일수/한도초과율 범위 구간(Range) 정의 |

#### `m_product_loan` - 운전자금 대출 상품 설정 (신용공여한도, 금리체계, 회계매핑)
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
| `enable_accrual_activity_posting` | boolean | NOT NULL | enable_accrual_activity_posting 필드 |
| `due_days_for_repayment_event` | INT | NULL | due_days_for_repayment_event 필드 |
| `overdue_days_for_repayment_event` | INT | NULL | overdue_days_for_repayment_event 필드 |
| `delinquency_bucket_id` | BIGINT | NULL | delinquency_bucket 참조 식별자 (FK) |
| `enable_installment_level_delinquency` | boolean | NOT NULL | enable_installment_level_delinquency 필드 |
| `capitalized_income_type` | VARCHAR(10) | NULL | capitalized_income_type 필드 |
| `enable_income_capitalization` | boolean | NOT NULL | enable_income_capitalization 필드 |
| `capitalized_income_calculation_type` | VARCHAR(100) | NULL | capitalized_income_calculation_type 필드 |
| `capitalized_income_strategy` | VARCHAR(100) | NULL | capitalized_income_strategy 필드 |
| `allow_approved_disbursed_amounts_over_applied` | BOOLEAN | NOT NULL | allow_approved_disbursed_amounts_over_applied 필드 |
| `over_applied_calculation_type` | VARCHAR(10) | NULL | over_applied_calculation_type 필드 |
| `over_applied_number` | INT | NULL | over_applied_number 필드 |
| `loan_transaction_strategy_code` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_code 필드 |
| `loan_transaction_strategy_name` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_name 필드 |
| `disallow_expected_disbursements` | BOOLEAN | NOT NULL | disallow_expected_disbursements 필드 |
| `short_name` | VARCHAR(4) | NOT NULL | short_name 필드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `principal_amount` | DECIMAL(19, 6) | NULL | principal_amount 필드 |
| `min_principal_amount` | DECIMAL(19, 6) | NULL | min_principal_amount 필드 |
| `max_principal_amount` | DECIMAL(19, 6) | NULL | max_principal_amount 필드 |
| `arrearstolerance_amount` | DECIMAL(19, 6) | NULL | arrearstolerance_amount 필드 |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `description` | VARCHAR(500) | NULL | 상세 설명 |
| `fund_id` | BIGINT | NULL | fund 참조 식별자 (FK) |
| `is_linked_to_floating_interest_rates` | boolean | NOT NULL | linked_to_floating_interest_rates 여부 플래그 (Boolean) |
| `allow_variabe_installments` | boolean | NOT NULL | allow_variabe_installments 필드 |
| `nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | nominal_interest_rate_per_period 필드 |
| `min_nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | min_nominal_interest_rate_per_period 필드 |
| `max_nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | max_nominal_interest_rate_per_period 필드 |
| `interest_period_frequency_enum` | SMALLINT | NULL | interest_period_frequency 유형 구분 Enum 코드 |
| `annual_nominal_interest_rate` | DECIMAL(19, 6) | NULL | annual_nominal_interest_rate 필드 |
| `interest_method_enum` | SMALLINT | NOT NULL | interest_method 유형 구분 Enum 코드 |
| `interest_calculated_in_period_enum` | SMALLINT | NOT NULL | interest_calculated_in_period 유형 구분 Enum 코드 |
| `allow_partial_period_interest_calcualtion` | boolean | NOT NULL | allow_partial_period_interest_calcualtion 필드 |
| `repay_every` | SMALLINT | NOT NULL | repay_every 필드 |
| `repayment_period_frequency_enum` | SMALLINT | NOT NULL | repayment_period_frequency 유형 구분 Enum 코드 |
| `number_of_repayments` | SMALLINT | NOT NULL | number_of_repayments 필드 |
| `min_number_of_repayments` | SMALLINT | NULL | min_number_of_repayments 필드 |
| `max_number_of_repayments` | SMALLINT | NULL | max_number_of_repayments 필드 |
| `grace_on_principal_periods` | SMALLINT | NULL | grace_on_principal_periods 필드 |
| `recurring_moratorium_principal_periods` | SMALLINT | NULL | recurring_moratorium_principal_periods 필드 |
| `grace_on_interest_periods` | SMALLINT | NULL | grace_on_interest_periods 필드 |
| `grace_interest_free_periods` | SMALLINT | NULL | grace_interest_free_periods 필드 |
| `amortization_method_enum` | SMALLINT | NOT NULL | amortization_method 유형 구분 Enum 코드 |
| `accounting_type` | SMALLINT | NOT NULL | accounting_type 필드 |
| `loan_transaction_strategy_id` | BIGINT | NULL | loan_transaction_strategy 참조 식별자 (FK) |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |
| `include_in_borrower_cycle` | boolean | NOT NULL | include_in_borrower_cycle 필드 |
| `use_borrower_cycle` | boolean | NOT NULL | use_borrower_cycle 필드 |
| `start_date` | date | NULL | start_date 관련 일자 |
| `close_date` | date | NULL | close_date 관련 일자 |
| `allow_multiple_disbursals` | boolean | NOT NULL | allow_multiple_disbursals 필드 |
| `max_disbursals` | INT | NULL | max_disbursals 필드 |
| `max_outstanding_loan_balance` | DECIMAL(19, 6) | NULL | max_outstanding_loan_balance 필드 |
| `grace_on_arrears_ageing` | SMALLINT | NULL | grace_on_arrears_ageing 필드 |
| `overdue_days_for_npa` | SMALLINT | NULL | overdue_days_for_npa 필드 |
| `days_in_month_enum` | SMALLINT | NOT NULL | days_in_month 유형 구분 Enum 코드 |
| `days_in_year_enum` | SMALLINT | NOT NULL | days_in_year 유형 구분 Enum 코드 |
| `interest_recalculation_enabled` | boolean | NOT NULL | interest_recalculation_enabled 필드 |
| `min_days_between_disbursal_and_first_repayment` | INT | NULL | min_days_between_disbursal_and_first_repayment 필드 |
| `hold_guarantee_funds` | boolean | NOT NULL | hold_guarantee_funds 필드 |
| `principal_threshold_for_last_installment` | DECIMAL(5, 2) | NOT NULL | principal_threshold_for_last_installment 필드 |
| `account_moves_out_of_npa_only_on_arrears_completion` | boolean | NOT NULL | account_moves_out_of_npa_only_on_arrears_completion 필드 |
| `can_define_fixed_emi_amount` | boolean | NOT NULL | can_define_fixed_emi_amount 필드 |
| `instalment_amount_in_multiples_of` | DECIMAL(19, 6) | NULL | instalment_amount_in_multiples_of 필드 |
| `can_use_for_topup` | boolean | NOT NULL | can_use_for_topup 필드 |
| `sync_expected_with_disbursement_date` | boolean | NULL | sync_expected_with_disbursement_date 관련 일자 |
| `is_equal_amortization` | boolean | NOT NULL | equal_amortization 여부 플래그 (Boolean) |
| `fixed_principal_percentage_per_installment` | DECIMAL(5, 2) | NULL | fixed_principal_percentage_per_installment 필드 |

#### `m_delinquency_bucket` - 연체 구간(Delinquency Bucket) 및 한도위반 감지 규칙 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

#### `m_delinquency_range` - 연체 일수/한도초과율 범위 구간(Range) 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `classification` | VARCHAR(100) | NOT NULL | classification 필드 |
| `min_age_days` | BIGINT | NOT NULL | min_age_days 필드 |
| `max_age_days` | BIGINT | NULL | max_age_days 필드 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0006_product_loan_disallow_expected_disbursements.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0007_product_loan_higher_than_applied_loan_amount_management.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0064_refactor_loan_transaction_strategy.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0104_loan_product_add_repayment_overdue_days_config.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0119_add_loan_product_down_payment_configuration.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0126_add_loan_product_installment_level_delinquency.xml`

---

## [WCO] DB명세서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

### WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_delinquency_tag_history` | 운전자금 한도위반/연체 태그 부여 및 사후조치 이력 |

#### `m_loan_delinquency_tag_history` - 운전자금 한도위반/연체 태그 부여 및 사후조치 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `delinquency_range_id` | BIGINT | NOT NULL | delinquency_range 참조 식별자 (FK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `addedon_date` | DATE | NOT NULL | addedon_date 관련 일자 |
| `liftedon_date` | DATE | NULL | liftedon_date 관련 일자 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

### WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_account_locks` | 일마감(COB) 및 동시성 제어를 위한 계좌 잠금(Lock) 엔티티 |
| `m_batch_business_steps` | 마감 배치 단계별 비즈니스 스텝 구성 |

#### `m_loan_account_locks` - 일마감(COB) 및 동시성 제어를 위한 계좌 잠금(Lock) 엔티티
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `loan_id` | BIGINT | PK, NOT NULL | loan 참조 식별자 (FK) |
| `lock_placed_on_cob_business_date` | DATE | NULL | lock_placed_on_cob_business_date 관련 일자 |
| `stacktrace` | VARCHAR(255) | NULL | stacktrace 필드 |
| `lock_placed_on` | timestamp | NOT NULL | lock_placed_on 필드 |
| `lock_owner` | VARCHAR(100) | NOT NULL | lock_owner 필드 |
| `error` | VARCHAR(255) | NULL | error 필드 |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |

#### `m_batch_business_steps` - 마감 배치 단계별 비즈니스 스텝 구성
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_name` | VARCHAR(100) | NOT NULL | 배치 작업명 |
| `step_name` | VARCHAR(100) | NOT NULL | step_name 필드 |
| `step_order` | SMALLINT | NOT NULL | step_order 필드 |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/cob/domain/LoanAccountLock.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0022_add_batch_business_step_configuration_table.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0039_add_loan_account_locks.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0048_rework_loan_account_locks.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0086_add_cob_business_date_to_loan_account_locks.xml`
