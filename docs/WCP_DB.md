# [WCP] DB명세서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

## WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_loan` | 운전자금 대출 상품 설정 (신용공여한도, 금리체계, 회계매핑) |
| `m_delinquency_bucket` | 연체 구간(Delinquency Bucket) 및 한도위반 감지 규칙 마스터 |
| `m_delinquency_range` | 연체 일수/한도초과율 범위 구간(Range) 정의 |

### `m_product_loan` - 운전자금 대출 상품 설정 (신용공여한도, 금리체계, 회계매핑)
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

### `m_delinquency_bucket` - 연체 구간(Delinquency Bucket) 및 한도위반 감지 규칙 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

### `m_delinquency_range` - 연체 일수/한도초과율 범위 구간(Range) 정의
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

## 근거
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
