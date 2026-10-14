# [PD] DB명세서 (상품설정)

> 소분류 3개 롤업.


---

## [PDL] DB명세서

> 화면 2개 롤업(소분류 PDL, 대분류 PD - 대출 상품 설정).

### PDL-001 대출 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_loan` | 대출 상품 마스터 (대출한도, 금리범위, 상환주기, 연체이자율, 회계매핑 등 80개 컬럼) |
| `m_product_loan_charge` | 대출 상품에 기본 부과되는 수수료 매핑 |
| `m_product_loan_configurable_attributes` | 대출 실행시 재정의 가능한 설정 항목 플래그 |
| `m_product_loan_floating_rates` | 변동금리 연동 대출 상품 금리 마진 설정 |
| `m_product_loan_recalculation_details` | 이자 재계산 및 복리 적용 규칙 설정 |

#### `m_product_loan` - 대출 상품 마스터 (대출한도, 금리범위, 상환주기, 연체이자율, 회계매핑 등 80개 컬럼)
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

#### `m_product_loan_charge` - 대출 상품에 기본 부과되는 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `product_loan_id` | BIGINT | PK, NOT NULL | product_loan 참조 식별자 (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

#### `m_product_loan_configurable_attributes` - 대출 실행시 재정의 가능한 설정 항목 플래그
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

#### `m_product_loan_floating_rates` - 변동금리 연동 대출 상품 금리 마진 설정
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

#### `m_product_loan_recalculation_details` - 이자 재계산 및 복리 적용 규칙 설정
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

### PDL-002 대출 상품 믹스 및 모집인

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_product_mix` | 대출 상품 간 동시 취급 제한/허용 규칙 (Product Mix) |
| `m_product_loan_variations_borrower_cycle` | 고객의 대출 이용 회차(Cycle)별 한도/금리 차등 적용 규칙 |
| `m_product_loan_variable_installment_config` | 가변 분할상환 허용 한도 설정 |

#### `m_product_mix` - 대출 상품 간 동시 취급 제한/허용 규칙 (Product Mix)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `restricted_product_id` | BIGINT | NOT NULL | restricted_product 참조 식별자 (FK) |

#### `m_product_loan_variations_borrower_cycle` - 고객의 대출 이용 회차(Cycle)별 한도/금리 차등 적용 규칙
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

#### `m_product_loan_variable_installment_config` - 가변 분할상환 허용 한도 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_product_id` | BIGINT | NOT NULL | loan_product 참조 식별자 (FK) |
| `minimum_gap` | INT | NOT NULL | minimum_gap 필드 |
| `maximum_gap` | INT | NOT NULL | maximum_gap 필드 |

### 근거
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

---

## [PDS] DB명세서

> 화면 2개 롤업(소분류 PDS, 대분류 PD - 수신 및 주식 상품 설정).

### PDS-001 예적금 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_savings_product` | 보통/정기/적금 예금 상품 마스터 (약정이자율, 복리계산주기, 최소잔액요건 등) |
| `m_savings_product_charge` | 예금 상품 부과 수수료 매핑 |
| `m_deposit_product_term_and_preclosure` | 정기예금 상품 만기 및 중도해지 기본 약관 |
| `m_deposit_product_recurring_detail` | 정기적금 상품 불입 주기 및 금액 범위 설정 |
| `m_deposit_product_interest_rate_chart` | 예금 상품별 적용 금리 차트 매핑 |

#### `m_savings_product` - 보통/정기/적금 예금 상품 마스터 (약정이자율, 복리계산주기, 최소잔액요건 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `max_allowed_lien_limit` | DECIMAL(19, 6) | NULL | max_allowed_lien_limit 필드 |
| `is_lien_allowed` | boolean | NOT NULL | lien_allowed 여부 플래그 (Boolean) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `short_name` | VARCHAR(4) | NOT NULL | short_name 필드 |
| `description` | VARCHAR(500) | NULL | description 필드 |
| `deposit_type_enum` | SMALLINT | NOT NULL | deposit_type 유형 구분 Enum 코드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `nominal_annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | nominal_annual_interest_rate 이자율/비율 |
| `interest_compounding_period_enum` | SMALLINT | NOT NULL | interest_compounding_period 유형 구분 Enum 코드 |
| `interest_posting_period_enum` | SMALLINT | NOT NULL | interest_posting_period 유형 구분 Enum 코드 |
| `interest_calculation_type_enum` | SMALLINT | NOT NULL | interest_calculation_type 유형 구분 Enum 코드 |
| `interest_calculation_days_in_year_type_enum` | SMALLINT | NOT NULL | interest_calculation_days_in_year_type 유형 구분 Enum 코드 |
| `min_required_opening_balance` | DECIMAL(19, 6) | NULL | min_required_opening_balance 필드 |
| `lockin_period_frequency` | DECIMAL(19, 6) | NULL | lockin_period_frequency 필드 |
| `lockin_period_frequency_enum` | SMALLINT | NULL | lockin_period_frequency 유형 구분 Enum 코드 |
| `accounting_type` | SMALLINT | NOT NULL | accounting_type 필드 |
| `withdrawal_fee_amount` | DECIMAL(19, 6) | NULL | withdrawal_fee_amount 금액 |
| `withdrawal_fee_type_enum` | SMALLINT | NULL | withdrawal_fee_type 유형 구분 Enum 코드 |
| `withdrawal_fee_for_transfer` | boolean | NULL | withdrawal_fee_for_transfer 필드 |
| `allow_overdraft` | boolean | NOT NULL | allow_overdraft 필드 |
| `overdraft_limit` | DECIMAL(19, 6) | NULL | overdraft_limit 필드 |
| `nominal_annual_interest_rate_overdraft` | DECIMAL(19, 6) | NULL | nominal_annual_interest_rate_overdraft 이자율/비율 |
| `min_overdraft_for_interest_calculation` | DECIMAL(19, 6) | NULL | min_overdraft_for_interest_calculation 필드 |
| `min_required_balance` | DECIMAL(19, 6) | NULL | min_required_balance 필드 |
| `enforce_min_required_balance` | boolean | NOT NULL | enforce_min_required_balance 필드 |
| `min_balance_for_interest_calculation` | DECIMAL(19, 6) | NULL | min_balance_for_interest_calculation 필드 |
| `withhold_tax` | boolean | NOT NULL | withhold_tax 필드 |
| `tax_group_id` | BIGINT | NULL | tax_group 참조 식별자 (FK) |
| `is_dormancy_tracking_active` | boolean | NULL | dormancy_tracking_active 여부 플래그 (Boolean) |
| `days_to_inactive` | INT | NULL | days_to_inactive 필드 |
| `days_to_dormancy` | INT | NULL | days_to_dormancy 필드 |
| `days_to_escheat` | INT | NULL | days_to_escheat 필드 |
| `nominal_interest_rate_per_period` | decimal(19 | NULL | 약정 이자율 |
| `nominal_interest_rate_period_frequency_enum` | SMALLINT | NOT NULL | nominal_interest_rate_period_frequency 유형 구분 Enum 코드 |
| `interest_period_enum` | SMALLINT | NOT NULL | interest_period 유형 구분 Enum 코드 |

#### `m_savings_product_charge` - 예금 상품 부과 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `savings_product_id` | BIGINT | PK, NOT NULL | savings_product 참조 식별자 (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

#### `m_deposit_product_term_and_preclosure` - 정기예금 상품 만기 및 중도해지 기본 약관
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_product_id` | BIGINT | NOT NULL | savings_product 참조 식별자 (FK) |
| `min_deposit_term` | INT | NULL | min_deposit_term 필드 |
| `max_deposit_term` | INT | NULL | max_deposit_term 필드 |
| `min_deposit_term_type_enum` | SMALLINT | NULL | min_deposit_term_type 유형 구분 Enum 코드 |
| `max_deposit_term_type_enum` | SMALLINT | NULL | max_deposit_term_type 유형 구분 Enum 코드 |
| `in_multiples_of_deposit_term` | INT | NULL | in_multiples_of_deposit_term 필드 |
| `in_multiples_of_deposit_term_type_enum` | SMALLINT | NULL | in_multiples_of_deposit_term_type 유형 구분 Enum 코드 |
| `pre_closure_penal_applicable` | boolean | NULL | pre_closure_penal_applicable 필드 |
| `pre_closure_penal_interest` | DECIMAL(19, 6) | NULL | pre_closure_penal_interest 필드 |
| `pre_closure_penal_interest_on_enum` | SMALLINT | NULL | pre_closure_penal_interest_on 유형 구분 Enum 코드 |
| `min_deposit_amount` | DECIMAL(19, 6) | NULL | min_deposit_amount 금액 |
| `max_deposit_amount` | DECIMAL(19, 6) | NULL | max_deposit_amount 금액 |
| `deposit_amount` | DECIMAL(19, 6) | NULL | deposit_amount 금액 |

#### `m_deposit_product_recurring_detail` - 정기적금 상품 불입 주기 및 금액 범위 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_product_id` | BIGINT | NOT NULL | savings_product 참조 식별자 (FK) |
| `is_mandatory` | boolean | NOT NULL | mandatory 여부 플래그 (Boolean) |
| `allow_withdrawal` | boolean | NOT NULL | allow_withdrawal 필드 |
| `adjust_advance_towards_future_payments` | boolean | NOT NULL | adjust_advance_towards_future_payments 필드 |

#### `m_deposit_product_interest_rate_chart` - 예금 상품별 적용 금리 차트 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `deposit_product_id` | BIGINT | NOT NULL | deposit_product 참조 식별자 (FK) |
| `interest_rate_chart_id` | BIGINT | NOT NULL | interest_rate_chart 참조 식별자 (FK) |

### PDS-002 주식 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_share_product` | 출자금/주식 상품 마스터 (1주당 액면가, 총발행한도, 1인당 최소/최대 보유주수) |
| `m_share_product_charge` | 주식 상품 수수료 매핑 |
| `m_share_product_market_price` | 일자별 주식 시가(Market Price) 평가액 이력 |
| `m_share_product_dividend_pay_out` | 상품별 배당금 지급 선언 및 결산 내역 |

#### `m_share_product` - 출자금/주식 상품 마스터 (1주당 액면가, 총발행한도, 1인당 최소/최대 보유주수)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(200) | NOT NULL | 명칭 / 이름 |
| `short_name` | VARCHAR(4) | NOT NULL | short_name 필드 |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `description` | VARCHAR(500) | NOT NULL | description 필드 |
| `start_date` | datetime | NULL | start_date 일자 |
| `end_date` | datetime | NULL | end_date 일자 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `total_shares` | BIGINT | NOT NULL | total_shares 필드 |
| `issued_shares` | BIGINT | NULL | issued_shares 필드 |
| `totalsubscribed_shares` | BIGINT | NULL | totalsubscribed_shares 필드 |
| `unit_price` | DECIMAL(10, 2) | NOT NULL | unit_price 필드 |
| `capital_amount` | DECIMAL(20, 2) | NOT NULL | capital_amount 금액 |
| `minimum_client_shares` | BIGINT | NULL | minimum_client_shares 필드 |
| `nominal_client_shares` | BIGINT | NOT NULL | nominal_client_shares 필드 |
| `maximum_client_shares` | BIGINT | NULL | maximum_client_shares 필드 |
| `minimum_active_period_frequency` | DECIMAL(19, 6) | NULL | minimum_active_period_frequency 필드 |
| `minimum_active_period_frequency_enum` | SMALLINT | NULL | minimum_active_period_frequency 유형 구분 Enum 코드 |
| `lockin_period_frequency` | DECIMAL(19, 6) | NULL | lockin_period_frequency 필드 |
| `lockin_period_frequency_enum` | SMALLINT | NULL | lockin_period_frequency 유형 구분 Enum 코드 |
| `allow_dividends_inactive_clients` | boolean | NULL | allow_dividends_inactive_clients 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `accounting_type` | SMALLINT | NOT NULL | accounting_type 필드 |

#### `m_share_product_charge` - 주식 상품 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `product_id` | BIGINT | PK, NOT NULL | 상품 ID (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

#### `m_share_product_market_price` - 일자별 주식 시가(Market Price) 평가액 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `from_date` | date | NULL | from_date 일자 |
| `share_value` | DECIMAL(10, 2) | NOT NULL | share_value 필드 |

#### `m_share_product_dividend_pay_out` - 상품별 배당금 지급 선언 및 결산 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `dividend_period_start_date` | date | NOT NULL | dividend_period_start_date 일자 |
| `dividend_period_end_date` | date | NOT NULL | dividend_period_end_date 일자 |
| `status` | SMALLINT | NOT NULL | status 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProduct.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProductDividendPayOutDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProductMarketPrice.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0010_lien_allowed_on_savings_account_products.xml`

---

## [PDR] DB명세서

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

### PDR-001 금리·수수료·세무 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_rate` | 기준금리 및 수수료율 마스터 |
| `m_floating_rates` | 시장 기준금리(CD금리, 코픽스 등) 변동금리 엔티티 |
| `m_floating_rates_periods` | 변동금리의 기간별 적용 금리값 이력 |
| `m_interest_rate_chart` | 수신/여신 금리 차트 정의 (효력시작일자, 차트명) |
| `m_interest_rate_slab` | 금리 차트 내 기간/금액 구간별 이자율 슬랩 |
| `m_charge` | 수수료 마스터 (정액, 정률, 징수시점, 계산방법 등 25개 컬럼) |
| `m_tax_group` | 원천징수 세무 그룹 (이자소득세+지방소득세 묶음) |
| `m_tax_component` | 개별 세금 구성요소 (세율, 회계계정 매핑) |
| `m_tax_group_mappings` | 세무 그룹과 세금 구성요소 간 매핑 |

#### `m_rate` - 기준금리 및 수수료율 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(250) | NOT NULL | 명칭 / 이름 |
| `percentage` | DECIMAL(10, 2) | NOT NULL | percentage 이자율/비율 |
| `active` | boolean | NULL | active 필드 |
| `product_apply` | SMALLINT | NOT NULL | product_apply 필드 |
| `created_date` | datetime | NULL | 생성 일시 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `approve_user` | BIGINT | NULL | approve_user 필드 |

#### `m_floating_rates` - 시장 기준금리(CD금리, 코픽스 등) 변동금리 엔티티
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `name` | VARCHAR(200) | NOT NULL | 명칭 / 이름 |
| `is_base_lending_rate` | boolean | NOT NULL | base_lending_rate 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

#### `m_floating_rates_periods` - 변동금리의 기간별 적용 금리값 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `floating_rates_id` | BIGINT | NOT NULL | floating_rates 참조 식별자 (FK) |
| `from_date` | datetime | NOT NULL | from_date 일자 |
| `interest_rate` | DECIMAL(19, 6) | NOT NULL | interest_rate 이자율/비율 |
| `is_differential_to_base_lending_rate` | boolean | NOT NULL | differential_to_base_lending_rate 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

#### `m_interest_rate_chart` - 수신/여신 금리 차트 정의 (효력시작일자, 차트명)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `from_date` | date | NOT NULL | from_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `is_primary_grouping_by_amount` | boolean | NOT NULL | primary_grouping_by_amount 여부 플래그 (Boolean) |

#### `m_interest_rate_slab` - 금리 차트 내 기간/금액 구간별 이자율 슬랩
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `interest_rate_chart_id` | BIGINT | NOT NULL | interest_rate_chart 참조 식별자 (FK) |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `period_type_enum` | SMALLINT | NULL | period_type 유형 구분 Enum 코드 |
| `from_period` | INT | NULL | from_period 필드 |
| `to_period` | INT | NULL | to_period 필드 |
| `amount_range_from` | DECIMAL(19, 6) | NULL | amount_range_from 금액 |
| `amount_range_to` | DECIMAL(19, 6) | NULL | amount_range_to 금액 |
| `annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | annual_interest_rate 이자율/비율 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |

#### `m_charge` - 수수료 마스터 (정액, 정률, 징수시점, 계산방법 등 25개 컬럼)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `charge_applies_to_enum` | SMALLINT | NOT NULL | charge_applies_to 유형 구분 Enum 코드 |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `charge_payment_mode_enum` | SMALLINT | NULL | charge_payment_mode 유형 구분 Enum 코드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `fee_on_day` | SMALLINT | NULL | fee_on_day 필드 |
| `fee_interval` | SMALLINT | NULL | fee_interval 필드 |
| `fee_on_month` | SMALLINT | NULL | fee_on_month 필드 |
| `is_penalty` | boolean | NOT NULL | penalty 여부 플래그 (Boolean) |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `min_cap` | DECIMAL(19, 6) | NULL | min_cap 필드 |
| `max_cap` | DECIMAL(19, 6) | NULL | max_cap 필드 |
| `fee_frequency` | SMALLINT | NULL | fee_frequency 필드 |
| `is_free_withdrawal` | boolean | NOT NULL | free_withdrawal 여부 플래그 (Boolean) |
| `free_withdrawal_charge_frequency` | INT | NULL | free_withdrawal_charge_frequency 필드 |
| `restart_frequency` | INT | NULL | restart_frequency 필드 |
| `restart_frequency_enum` | INT | NULL | restart_frequency 유형 구분 Enum 코드 |
| `is_payment_type` | boolean | NULL | payment_type 여부 플래그 (Boolean) |
| `payment_type_id` | INT | NULL | payment_type 참조 식별자 (FK) |
| `income_or_liability_account_id` | BIGINT | NULL | income_or_liability_account 참조 식별자 (FK) |
| `tax_group_id` | BIGINT | NULL | tax_group 참조 식별자 (FK) |

#### `m_tax_group` - 원천징수 세무 그룹 (이자소득세+지방소득세 묶음)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

#### `m_tax_component` - 개별 세금 구성요소 (세율, 회계계정 매핑)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `percentage` | DECIMAL(19, 6) | NOT NULL | percentage 이자율/비율 |
| `debit_account_type_enum` | SMALLINT | NULL | debit_account_type 유형 구분 Enum 코드 |
| `debit_account_id` | BIGINT | NULL | debit_account 참조 식별자 (FK) |
| `credit_account_type_enum` | SMALLINT | NULL | credit_account_type 유형 구분 Enum 코드 |
| `credit_account_id` | BIGINT | NULL | credit_account 참조 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 일자 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

#### `m_tax_group_mappings` - 세무 그룹과 세금 구성요소 간 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `tax_group_id` | BIGINT | NOT NULL | tax_group 참조 식별자 (FK) |
| `tax_component_id` | BIGINT | NOT NULL | tax_component 참조 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0024_add_audit_entries.xml`
