# [ACR] DB명세서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

## ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_accounting_rule` | 정형 거래별 차변/대변 계정 사전 정의 분개 규칙 |
| `acc_rule_tags` | 회계 규칙 태그 매핑 |
| `acc_product_mapping` | 여신/수신 상품별 대출원금, 이자수익, 미수이자 등 GL 계정 자동 매핑 |
| `acc_gl_financial_activity_account` | 현금수납, 개설잔액 등 주요 금융활동과 GL 계정 매핑 |

### `acc_accounting_rule` - 정형 거래별 차변/대변 계정 사전 정의 분개 규칙
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `office_id` | BIGINT | NULL | 지점 ID (FK: m_office.id) |
| `debit_account_id` | BIGINT | NULL | debit_account 참조 식별자 (FK) |
| `allow_multiple_debits` | boolean | NOT NULL | allow_multiple_debits 필드 |
| `credit_account_id` | BIGINT | NULL | credit_account 참조 식별자 (FK) |
| `allow_multiple_credits` | boolean | NOT NULL | allow_multiple_credits 필드 |
| `description` | VARCHAR(500) | NULL | description 필드 |
| `system_defined` | boolean | NOT NULL | system_defined 필드 |

### `acc_rule_tags` - 회계 규칙 태그 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `acc_rule_id` | BIGINT | NOT NULL | acc_rule 참조 식별자 (FK) |
| `tag_id` | INT | NOT NULL | tag 참조 식별자 (FK) |
| `acc_type_enum` | SMALLINT | NOT NULL | acc_type 유형 구분 Enum 코드 |

### `acc_product_mapping` - 여신/수신 상품별 대출원금, 이자수익, 미수이자 등 GL 계정 자동 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `capitalized_income_classification_id` | INT | NULL | capitalized_income_classification 참조 식별자 (FK) |
| `buydown_fee_classification_id` | INT | NULL | buydown_fee_classification 참조 식별자 (FK) |
| `charge_off_reason_id` | INT | NULL | charge_off_reason 참조 식별자 (FK) |
| `write_off_reason_id` | BIGINT | NULL | write_off_reason 참조 식별자 (FK) |
| `gl_account_id` | BIGINT | NULL | gl_account 참조 식별자 (FK) |
| `product_id` | BIGINT | NULL | 상품 ID (FK) |
| `product_type` | SMALLINT | NULL | product_type 필드 |
| `payment_type` | INT | NULL | payment_type 필드 |
| `charge_id` | BIGINT | NULL | charge 참조 식별자 (FK) |
| `financial_account_type` | SMALLINT | NULL | financial_account_type 필드 |

### `acc_gl_financial_activity_account` - 현금수납, 개설잔액 등 주요 금융활동과 GL 계정 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `gl_account_id` | BIGINT | NOT NULL | gl_account 참조 식별자 (FK) |
| `financial_activity_type` | SMALLINT | NOT NULL | financial_activity_type 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0153_add_charge_off_reason_id_to_acc_product_mapping.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0198_add_classification_id_to_acc_product_mapping.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0199_write_off_reason_mapping_loan.xml`
