# [SVS] DB명세서

> 화면 1개 롤업(소분류 SVS, 대분류 SV - 주식 계좌).

## SVS-001 주식 계좌 및 배당 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_share_account` | 조합원 주식(출자금) 계좌 마스터 (보유 주식수, 취득단가, 승인상태) |
| `m_share_account_transactions` | 주식 청약(매수), 환급(매도), 유상증자 거래 원장 |
| `m_share_account_charge` | 주식 거래 관련 수수료 마스터 |
| `m_share_account_dividend_details` | 결산 배당금 배정 및 지급 내역 |

### `m_share_account` - 조합원 주식(출자금) 계좌 마스터 (보유 주식수, 취득단가, 승인상태)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_no` | VARCHAR(50) | NOT NULL | 계좌 번호 |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `total_approved_shares` | BIGINT | NULL | total_approved_shares 필드 |
| `total_pending_shares` | BIGINT | NULL | total_pending_shares 필드 |
| `submitted_date` | date | NOT NULL | submitted_date 일자 |
| `submitted_userid` | BIGINT | NULL | submitted_userid 필드 |
| `approved_date` | date | NULL | approved_date 일자 |
| `approved_userid` | BIGINT | NULL | approved_userid 필드 |
| `rejected_date` | date | NULL | rejected_date 일자 |
| `rejected_userid` | BIGINT | NULL | rejected_userid 필드 |
| `activated_date` | date | NULL | activated_date 일자 |
| `activated_userid` | BIGINT | NULL | activated_userid 필드 |
| `closed_date` | date | NULL | closed_date 일자 |
| `closed_userid` | BIGINT | NULL | closed_userid 필드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `minimum_active_period_frequency` | DECIMAL(19, 6) | NULL | minimum_active_period_frequency 필드 |
| `minimum_active_period_frequency_enum` | SMALLINT | NULL | minimum_active_period_frequency 유형 구분 Enum 코드 |
| `lockin_period_frequency` | DECIMAL(19, 6) | NULL | lockin_period_frequency 필드 |
| `lockin_period_frequency_enum` | SMALLINT | NULL | lockin_period_frequency 유형 구분 Enum 코드 |
| `allow_dividends_inactive_clients` | boolean | NULL | allow_dividends_inactive_clients 필드 |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

### `m_share_account_transactions` - 주식 청약(매수), 환급(매도), 유상증자 거래 원장
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `transaction_date` | date | NULL | transaction_date 일자 |
| `total_shares` | BIGINT | NULL | total_shares 필드 |
| `unit_price` | DECIMAL(10, 2) | NULL | unit_price 필드 |
| `amount` | DECIMAL(20, 2) | NULL | amount 금액 |
| `charge_amount` | DECIMAL(20, 2) | NULL | charge_amount 금액 |
| `amount_paid` | DECIMAL(20, 2) | NULL | amount_paid 금액 |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `type_enum` | SMALLINT | NULL | type 유형 구분 Enum 코드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |

### `m_share_account_charge` - 주식 거래 관련 수수료 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `charge_id` | BIGINT | NOT NULL | charge 참조 식별자 (FK) |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `charge_payment_mode_enum` | SMALLINT | NOT NULL | charge_payment_mode 유형 구분 Enum 코드 |
| `calculation_percentage` | DECIMAL(19, 6) | NULL | calculation_percentage 이자율/비율 |
| `calculation_on_amount` | DECIMAL(19, 6) | NULL | calculation_on_amount 금액 |
| `charge_amount_or_percentage` | DECIMAL(19, 6) | NULL | charge_amount_or_percentage 금액 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_paid_derived` | DECIMAL(19, 6) | NULL | amount_paid 자동 집계/산출 필드 |
| `amount_waived_derived` | DECIMAL(19, 6) | NULL | amount_waived 자동 집계/산출 필드 |
| `amount_writtenoff_derived` | DECIMAL(19, 6) | NULL | amount_writtenoff 자동 집계/산출 필드 |
| `amount_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | amount_outstanding 자동 집계/산출 필드 |
| `is_paid_derived` | boolean | NOT NULL | is_paid 자동 집계/산출 필드 |
| `waived` | boolean | NOT NULL | waived 필드 |
| `min_cap` | DECIMAL(19, 6) | NULL | min_cap 필드 |
| `max_cap` | DECIMAL(19, 6) | NULL | max_cap 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |

### `m_share_account_dividend_details` - 결산 배당금 배정 및 지급 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `dividend_pay_out_id` | BIGINT | NOT NULL | dividend_pay_out 참조 식별자 (FK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `status` | SMALLINT | NOT NULL | status 필드 |
| `savings_transaction_id` | BIGINT | NULL | savings_transaction 참조 식별자 (FK) |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccount.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountCharge.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountDividendDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountTransaction.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
