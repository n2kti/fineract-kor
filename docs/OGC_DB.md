# [OGC] DB명세서

> 화면 1개 롤업(소분류 OGC, 대분류 OG - 통화 및 조직 공통설정).

## OGC-001 통화·자금원·계좌체계

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_organisation_currency` | 조직에서 취급 허용된 통화 목록 및 소수점 자리수 |
| `m_currency` | ISO-4217 표준 통화 코드 및 기호 마스터 |
| `m_fund` | 대출 자금원(Fund) 마스터 |
| `m_payment_type` | 결제 수단(현금, 계좌이체, 어음, 카드 등) 마스터 |
| `c_account_number_format` | 지점/상품별 고객번호 및 계좌번호 채번 포맷 규칙 |

### `m_organisation_currency` - 조직에서 취급 허용된 통화 목록 및 소수점 자리수
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(3) | NOT NULL | code 필드 |
| `decimal_places` | SMALLINT | NOT NULL | decimal_places 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `display_symbol` | VARCHAR(10) | NULL | display_symbol 필드 |
| `internationalized_name_code` | VARCHAR(50) | NOT NULL | internationalized_name_code 필드 |

### `m_currency` - ISO-4217 표준 통화 코드 및 기호 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(3) | NOT NULL | code 필드 |
| `decimal_places` | SMALLINT | NOT NULL | decimal_places 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `display_symbol` | VARCHAR(10) | NULL | display_symbol 필드 |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `internationalized_name_code` | VARCHAR(50) | NOT NULL | internationalized_name_code 필드 |

### `m_fund` - 대출 자금원(Fund) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(255) | NULL | 명칭 / 이름 |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |

### `m_payment_type` - 결제 수단(현금, 계좌이체, 어음, 카드 등) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_name` | VARCHAR(100) | NULL | code_name 필드 |
| `is_system_defined` | boolean | NOT NULL | system_defined 여부 플래그 (Boolean) |
| `value` | VARCHAR(100) | NULL | value 필드 |
| `description` | VARCHAR(500) | NULL | 상세 설명 |
| `is_cash_payment` | boolean | NULL | cash_payment 여부 플래그 (Boolean) |
| `order_position` | INT | NOT NULL | order_position 필드 |

### `c_account_number_format` - 지점/상품별 고객번호 및 계좌번호 채번 포맷 규칙
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_type_enum` | SMALLINT | NOT NULL | account_type 유형 구분 Enum 코드 |
| `prefix_type_enum` | SMALLINT | NULL | prefix_type 유형 구분 Enum 코드 |
| `prefix_character` | VARCHAR(50) | NULL | prefix_character 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0052_loan_transaction_chargeback.xml`
