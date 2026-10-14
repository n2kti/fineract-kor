# [PDL] DB명세서

> 화면 2개 롤업(소분류 PDL, 대분류 PD - 대출 상품 설정).

## PDL-001 대출 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_loan` | 대출 상품 마스터 (대출한도, 금리범위, 상환주기, 연체이자율, 회계매핑 등 80개 컬럼) |
| `m_product_loan_charge` | 대출 상품에 기본 부과되는 수수료 매핑 |
| `m_product_loan_configurable_attributes` | 대출 실행시 재정의 가능한 설정 항목 플래그 |
| `m_product_loan_floating_rates` | 변동금리 연동 대출 상품 금리 마진 설정 |
| `m_product_loan_recalculation_details` | 이자 재계산 및 복리 적용 규칙 설정 |

### `m_product_loan` - 대출 상품 마스터 (대출한도, 금리범위, 상환주기, 연체이자율, 회계매핑 등 80개 컬럼)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `days_in_year_custom_strategy` | VARCHAR(100) | NULL | days_in_year_custom_strategy 이자율/비율 |
| `enable_buy_down_fee` | boolean | NOT NULL | enable_buy_down_fee 필드 |
| `buy_down_fee_calculation_type` | VARCHAR(100) | NULL | buy_down_fee_calculation_type 필드 |
| `buy_down_fee_strategy` | VARCHAR(100) | NULL | buy_down_fee_strategy 이자율/비율 |
| `buy_down_fee_income_type` | VARCHAR(100) | NULL | buy_down_fee_income_type 필드 |
| `allow_full_term_for_tranche` | boolean | NOT NULL | allow_full_term_for_tranche 필드 |
| `enable_down_payment` | boolean | NOT NULL | enable_down_payment 필드 |
| `disbursed_amount_percentage_for_down_payment` | DECIMAL(9, 6) | NULL | disbursed_amount_percentage_for_down_payment 금액 |
| `enable_accrual_activity_posting` | boolean | NOT NULL | enable_accrual_activity_posting 필드 |
| `due_days_for_repayment_event` | INT | NULL | due_days_for_repayment_event 필드 |
| `overdue_days_for_repayment_event` | INT | NULL | overdue_days_for_repayment_event 필드 |
| `delinquency_bucket_id` | BIGINT | NULL | delinquency_bucket 참조 식별자 (FK) |
| `enable_installment_level_delinquency` | boolean | NOT NULL | enable_installment_level_delinquency 필드 |
| `capitalized_income_type` | VARCHAR(10) | NULL | capitalized_income_type 필드 |
| `enable_income_capitalization` | boolean | NOT NULL | enable_income_capitalization 필드 |
| `capitalized_income_calculation_type` | VARCHAR(100) | NULL | capitalized_income_calculation_type 필드 |
| `capitalized_income_strategy` | VARCHAR(100) | NULL | capitalized_income_strategy 이자율/비율 |
| `allow_approved_disbursed_amounts_over_applied` | BOOLEAN | NOT NULL | allow_approved_disbursed_amounts_over_applied 금액 |
| `over_applied_calculation_type` | VARCHAR(10) | NULL | over_applied_calculation_type 필드 |
| `over_applied_number` | INT | NULL | over_applied_number 필드 |
| `loan_transaction_strategy_code` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_code 이자율/비율 |
| `loan_transaction_strategy_name` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_name 이자율/비율 |
| `disallow_expected_disbursements` | BOOLEAN | NOT NULL | disallow_expected_disbursements 필드 |
| `short_name` | VARCHAR(4) | NOT NULL | short_name 필드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `principal_amount` | DECIMAL(19, 6) | NULL | 원금 / 대출 신청금액 |
| `min_principal_amount` | DECIMAL(19, 6) | NULL | min_principal_amount 금액 |
| `max_principal_amount` | DECIMAL(19, 6) | NULL | max_principal_amount 금액 |
| `arrearstolerance_amount` | DECIMAL(19, 6) | NULL | arrearstolerance_amount 금액 |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `description` | VARCHAR(500) | NULL | description 필드 |
| `fund_id` | BIGINT | NULL | 자금원 ID (FK: m_fund.id) |
| `is_linked_to_floating_interest_rates` | boolean | NOT NULL | linked_to_floating_interest_rates 여부 플래그 (Boolean) |
| `allow_variabe_installments` | boolean | NOT NULL | allow_variabe_installments 필드 |
| `nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | 약정 이자율 |
| `min_nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | min_nominal_interest_rate_per_period 이자율/비율 |
| `max_nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | max_nominal_interest_rate_per_period 이자율/비율 |
| `interest_period_frequency_enum` | SMALLINT | NULL | interest_period_frequency 유형 구분 Enum 코드 |
| `annual_nominal_interest_rate` | DECIMAL(19, 6) | NULL | 연환산 명목 이자율 |
| `interest_method_enum` | SMALLINT | NOT NULL | 이자 계산 방식 (0:원리금균등, 1:단리/플랫 등) |
| `interest_calculated_in_period_enum` | SMALLINT | NOT NULL | 이자 기산 주기 (1:일할, 2:월할) |
| `allow_partial_period_interest_calcualtion` | boolean | NOT NULL | allow_partial_period_interest_calcualtion 필드 |
| `repay_every` | SMALLINT | NOT NULL | repay_every 필드 |
| `repayment_period_frequency_enum` | SMALLINT | NOT NULL | 상환 주기 단위 (0:일, 1:주, 2:월) |
| `number_of_repayments` | SMALLINT | NOT NULL | 총 상환 횟수 |
| `min_number_of_repayments` | SMALLINT | NULL | min_number_of_repayments 필드 |
| `max_number_of_repayments` | SMALLINT | NULL | max_number_of_repayments 필드 |
| `grace_on_principal_periods` | SMALLINT | NULL | grace_on_principal_periods 필드 |
| `recurring_moratorium_principal_periods` | SMALLINT | NULL | recurring_moratorium_principal_periods 필드 |
| `grace_on_interest_periods` | SMALLINT | NULL | grace_on_interest_periods 필드 |
| `grace_interest_free_periods` | SMALLINT | NULL | grace_interest_free_periods 필드 |
| `amortization_method_enum` | SMALLINT | NOT NULL | amortization_method 유형 구분 Enum 코드 |
| `accounting_type` | SMALLINT | NOT NULL | accounting_type 필드 |
| `loan_transaction_strategy_id` | BIGINT | NULL | loan_transaction_strategy 참조 식별자 (FK) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `include_in_borrower_cycle` | boolean | NOT NULL | include_in_borrower_cycle 필드 |
| `use_borrower_cycle` | boolean | NOT NULL | use_borrower_cycle 필드 |
| `start_date` | date | NULL | start_date 일자 |
| `close_date` | date | NULL | close_date 일자 |
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
| `can_define_fixed_emi_amount` | boolean | NOT NULL | can_define_fixed_emi_amount 금액 |
| `instalment_amount_in_multiples_of` | DECIMAL(19, 6) | NULL | instalment_amount_in_multiples_of 금액 |
| `can_use_for_topup` | boolean | NOT NULL | can_use_for_topup 필드 |
| `sync_expected_with_disbursement_date` | boolean | NULL | sync_expected_with_disbursement_date 일자 |
| `is_equal_amortization` | boolean | NOT NULL | equal_amortization 여부 플래그 (Boolean) |
| `fixed_principal_percentage_per_installment` | DECIMAL(5, 2) | NULL | fixed_principal_percentage_per_installment 이자율/비율 |

### `m_product_loan_charge` - 대출 상품에 기본 부과되는 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `product_loan_id` | BIGINT | PK, NOT NULL | product_loan 참조 식별자 (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

### `m_product_loan_configurable_attributes` - 대출 실행시 재정의 가능한 설정 항목 플래그
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_product_id` | BIGINT | NOT NULL | loan_product 참조 식별자 (FK) |
| `amortization_method_enum` | boolean | NOT NULL | amortization_method 유형 구분 Enum 코드 |
| `interest_method_enum` | boolean | NOT NULL | 이자 계산 방식 (0:원리금균등, 1:단리/플랫 등) |
| `loan_transaction_strategy_id` | boolean | NOT NULL | loan_transaction_strategy 참조 식별자 (FK) |
| `interest_calculated_in_period_enum` | boolean | NOT NULL | 이자 기산 주기 (1:일할, 2:월할) |
| `arrearstolerance_amount` | boolean | NOT NULL | arrearstolerance_amount 금액 |
| `repay_every` | boolean | NOT NULL | repay_every 필드 |
| `moratorium` | boolean | NOT NULL | moratorium 필드 |
| `grace_on_arrears_ageing` | boolean | NOT NULL | grace_on_arrears_ageing 필드 |

### `m_product_loan_floating_rates` - 변동금리 연동 대출 상품 금리 마진 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_product_id` | BIGINT | NOT NULL | loan_product 참조 식별자 (FK) |
| `floating_rates_id` | BIGINT | NOT NULL | floating_rates 참조 식별자 (FK) |
| `interest_rate_differential` | DECIMAL(19, 6) | NOT NULL | interest_rate_differential 이자율/비율 |
| `min_differential_lending_rate` | DECIMAL(19, 6) | NOT NULL | min_differential_lending_rate 이자율/비율 |
| `default_differential_lending_rate` | DECIMAL(19, 6) | NOT NULL | default_differential_lending_rate 이자율/비율 |
| `max_differential_lending_rate` | DECIMAL(19, 6) | NOT NULL | max_differential_lending_rate 이자율/비율 |
| `is_floating_interest_rate_calculation_allowed` | boolean | NOT NULL | floating_interest_rate_calculation_allowed 여부 플래그 (Boolean) |

### `m_product_loan_recalculation_details` - 이자 재계산 및 복리 적용 규칙 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `disallow_interest_calc_on_past_due` | boolean | NOT NULL | disallow_interest_calc_on_past_due 필드 |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `compound_type_enum` | SMALLINT | NOT NULL | compound_type 유형 구분 Enum 코드 |
| `reschedule_strategy_enum` | SMALLINT | NOT NULL | reschedule_strategy 유형 구분 Enum 코드 |
| `rest_frequency_type_enum` | SMALLINT | NOT NULL | rest_frequency_type 유형 구분 Enum 코드 |
| `rest_frequency_interval` | SMALLINT | NOT NULL | rest_frequency_interval 필드 |
| `arrears_based_on_original_schedule` | boolean | NOT NULL | arrears_based_on_original_schedule 필드 |
| `pre_close_interest_calculation_strategy` | SMALLINT | NOT NULL | pre_close_interest_calculation_strategy 이자율/비율 |
| `compounding_frequency_type_enum` | SMALLINT | NULL | compounding_frequency_type 유형 구분 Enum 코드 |
| `compounding_frequency_interval` | SMALLINT | NULL | compounding_frequency_interval 필드 |
| `rest_frequency_nth_day_enum` | INT | NULL | rest_frequency_nth_day 유형 구분 Enum 코드 |
| `rest_frequency_on_day` | INT | NULL | rest_frequency_on_day 필드 |
| `rest_frequency_weekday_enum` | INT | NULL | rest_frequency_weekday 유형 구분 Enum 코드 |
| `compounding_frequency_nth_day_enum` | INT | NULL | compounding_frequency_nth_day 유형 구분 Enum 코드 |
| `compounding_frequency_on_day` | INT | NULL | compounding_frequency_on_day 필드 |
| `compounding_frequency_weekday_enum` | INT | NULL | compounding_frequency_weekday 유형 구분 Enum 코드 |
| `is_compounding_to_be_posted_as_transaction` | boolean | NOT NULL | compounding_to_be_posted_as_transaction 여부 플래그 (Boolean) |
| `allow_compounding_on_eod` | boolean | NOT NULL | allow_compounding_on_eod 필드 |

## PDL-002 대출 상품 믹스 및 모집인

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_mix` | 대출 상품 간 동시 취급 제한/허용 규칙 (Product Mix) |
| `m_product_loan_variations_borrower_cycle` | 고객의 대출 이용 회차(Cycle)별 한도/금리 차등 적용 규칙 |
| `m_product_loan_variable_installment_config` | 가변 분할상환 허용 한도 설정 |

### `m_product_mix` - 대출 상품 간 동시 취급 제한/허용 규칙 (Product Mix)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `restricted_product_id` | BIGINT | NOT NULL | restricted_product 참조 식별자 (FK) |

### `m_product_loan_variations_borrower_cycle` - 고객의 대출 이용 회차(Cycle)별 한도/금리 차등 적용 규칙
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_product_id` | BIGINT | NOT NULL | loan_product 참조 식별자 (FK) |
| `borrower_cycle_number` | INT | NOT NULL | borrower_cycle_number 필드 |
| `value_condition` | INT | NOT NULL | value_condition 필드 |
| `param_type` | INT | NOT NULL | param_type 필드 |
| `default_value` | DECIMAL(19, 6) | NOT NULL | default_value 필드 |
| `max_value` | DECIMAL(19, 6) | NULL | max_value 필드 |
| `min_value` | DECIMAL(19, 6) | NULL | min_value 필드 |

### `m_product_loan_variable_installment_config` - 가변 분할상환 허용 한도 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_product_id` | BIGINT | NOT NULL | loan_product 참조 식별자 (FK) |
| `minimum_gap` | INT | NOT NULL | minimum_gap 필드 |
| `maximum_gap` | INT | NOT NULL | maximum_gap 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/domain/ProductMix.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0006_product_loan_disallow_expected_disbursements.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0007_product_loan_higher_than_applied_loan_amount_management.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0064_refactor_loan_transaction_strategy.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0104_loan_product_add_repayment_overdue_days_config.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0119_add_loan_product_down_payment_configuration.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0126_add_loan_product_installment_level_delinquency.xml`
