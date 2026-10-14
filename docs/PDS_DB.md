# [PDS] DB명세서

> 화면 2개 롤업(소분류 PDS, 대분류 PD - 수신 및 주식 상품 설정).

## PDS-001 예적금 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_savings_product` | 보통/정기/적금 예금 상품 마스터 (약정이자율, 복리계산주기, 최소잔액요건 등) |
| `m_savings_product_charge` | 예금 상품 부과 수수료 매핑 |
| `m_deposit_product_term_and_preclosure` | 정기예금 상품 만기 및 중도해지 기본 약관 |
| `m_deposit_product_recurring_detail` | 정기적금 상품 불입 주기 및 금액 범위 설정 |
| `m_deposit_product_interest_rate_chart` | 예금 상품별 적용 금리 차트 매핑 |

### `m_savings_product` - 보통/정기/적금 예금 상품 마스터 (약정이자율, 복리계산주기, 최소잔액요건 등)
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

### `m_savings_product_charge` - 예금 상품 부과 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `savings_product_id` | BIGINT | PK, NOT NULL | savings_product 참조 식별자 (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

### `m_deposit_product_term_and_preclosure` - 정기예금 상품 만기 및 중도해지 기본 약관
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

### `m_deposit_product_recurring_detail` - 정기적금 상품 불입 주기 및 금액 범위 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_product_id` | BIGINT | NOT NULL | savings_product 참조 식별자 (FK) |
| `is_mandatory` | boolean | NOT NULL | mandatory 여부 플래그 (Boolean) |
| `allow_withdrawal` | boolean | NOT NULL | allow_withdrawal 필드 |
| `adjust_advance_towards_future_payments` | boolean | NOT NULL | adjust_advance_towards_future_payments 필드 |

### `m_deposit_product_interest_rate_chart` - 예금 상품별 적용 금리 차트 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `deposit_product_id` | BIGINT | NOT NULL | deposit_product 참조 식별자 (FK) |
| `interest_rate_chart_id` | BIGINT | NOT NULL | interest_rate_chart 참조 식별자 (FK) |

## PDS-002 주식 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_share_product` | 출자금/주식 상품 마스터 (1주당 액면가, 총발행한도, 1인당 최소/최대 보유주수) |
| `m_share_product_charge` | 주식 상품 수수료 매핑 |
| `m_share_product_market_price` | 일자별 주식 시가(Market Price) 평가액 이력 |
| `m_share_product_dividend_pay_out` | 상품별 배당금 지급 선언 및 결산 내역 |

### `m_share_product` - 출자금/주식 상품 마스터 (1주당 액면가, 총발행한도, 1인당 최소/최대 보유주수)
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

### `m_share_product_charge` - 주식 상품 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `product_id` | BIGINT | PK, NOT NULL | 상품 ID (FK) |
| `charge_id` | BIGINT | PK, NOT NULL | charge 참조 식별자 (FK) |

### `m_share_product_market_price` - 일자별 주식 시가(Market Price) 평가액 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `from_date` | date | NULL | from_date 일자 |
| `share_value` | DECIMAL(10, 2) | NOT NULL | share_value 필드 |

### `m_share_product_dividend_pay_out` - 상품별 배당금 지급 선언 및 결산 내역
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

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProduct.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProductDividendPayOutDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/domain/ShareProductMarketPrice.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0010_lien_allowed_on_savings_account_products.xml`
