# [SVF] DB명세서

> 화면 1개 롤업(소분류 SVF, 대분류 SV - 정기예금 계좌).

## SVF-001 정기예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_deposit_account_term_and_preclosure` | 정기예금 약정기간, 만기일자, 만기시 처리방법(자동연장, 원리금입금) 및 중도해지 페널티 약관 |
| `m_savings_account_interest_rate_chart` | 계좌별 약정 금리 차트 |
| `m_savings_account_interest_rate_slab` | 예치 기간/금액 구간별 적용 금리 슬랩 |

### `m_deposit_account_term_and_preclosure` - 정기예금 약정기간, 만기일자, 만기시 처리방법(자동연장, 원리금입금) 및 중도해지 페널티 약관
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `min_deposit_term` | INT | NULL | min_deposit_term 필드 |
| `max_deposit_term` | INT | NULL | max_deposit_term 필드 |
| `min_deposit_term_type_enum` | SMALLINT | NULL | min_deposit_term_type 유형 구분 Enum 코드 |
| `max_deposit_term_type_enum` | SMALLINT | NULL | max_deposit_term_type 유형 구분 Enum 코드 |
| `in_multiples_of_deposit_term` | INT | NULL | in_multiples_of_deposit_term 필드 |
| `in_multiples_of_deposit_term_type_enum` | SMALLINT | NULL | in_multiples_of_deposit_term_type 유형 구분 Enum 코드 |
| `pre_closure_penal_applicable` | boolean | NULL | pre_closure_penal_applicable 필드 |
| `pre_closure_penal_interest` | DECIMAL(19, 6) | NULL | pre_closure_penal_interest 필드 |
| `pre_closure_penal_interest_on_enum` | SMALLINT | NULL | pre_closure_penal_interest_on 유형 구분 Enum 코드 |
| `deposit_period` | INT | NULL | deposit_period 필드 |
| `deposit_period_frequency_enum` | SMALLINT | NULL | deposit_period_frequency 유형 구분 Enum 코드 |
| `deposit_amount` | DECIMAL(19, 6) | NULL | deposit_amount 금액 |
| `maturity_amount` | DECIMAL(19, 6) | NULL | maturity_amount 금액 |
| `maturity_date` | date | NULL | maturity_date 일자 |
| `on_account_closure_enum` | SMALLINT | NULL | on_account_closure 유형 구분 Enum 코드 |
| `expected_firstdepositon_date` | date | NULL | expected_firstdepositon_date 일자 |
| `transfer_interest_to_linked_account` | boolean | NOT NULL | transfer_interest_to_linked_account 필드 |
| `transfer_to_savings_account_id` | BIGINT | NULL | transfer_to_savings_account 참조 식별자 (FK) |

### `m_savings_account_interest_rate_chart` - 계좌별 약정 금리 차트
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `from_date` | date | NOT NULL | from_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `is_primary_grouping_by_amount` | boolean | NOT NULL | primary_grouping_by_amount 여부 플래그 (Boolean) |

### `m_savings_account_interest_rate_slab` - 예치 기간/금액 구간별 적용 금리 슬랩
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_interest_rate_chart_id` | BIGINT | NOT NULL | savings_account_interest_rate_chart 참조 식별자 (FK) |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `period_type_enum` | SMALLINT | NULL | period_type 유형 구분 Enum 코드 |
| `from_period` | INT | NULL | from_period 필드 |
| `to_period` | INT | NULL | to_period 필드 |
| `amount_range_from` | DECIMAL(19, 6) | NULL | amount_range_from 금액 |
| `amount_range_to` | DECIMAL(19, 6) | NULL | amount_range_to 금액 |
| `annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | annual_interest_rate 이자율/비율 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |

## 근거
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
