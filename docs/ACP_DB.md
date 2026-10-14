# [ACP] DB명세서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

## ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_gl_closure` | 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자 |
| `m_provisioning_criteria` | 대출 상품별/연체 구간별 대손충당금 설정 기준 마스터 |
| `m_provisioning_criteria_definition` | 충당금 기준별 충당 비율 및 연체 범위 정의 |
| `m_provision_category` | 자산건전성 분류 카테고리 (정상, 요주의, 고정, 회수의문, 추정손실) |
| `m_loanproduct_provisioning_entry` | 대출 상품별 대손충당금 산출 결과 및 분개 전표 연결 |
| `m_provisioning_history` | 대손충당금 산출 배치 실행 이력 |

### `acc_gl_closure` - 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `office_id` | BIGINT | NOT NULL | 지점 식별자 (FK: m_office.id) |
| `closing_date` | date | NOT NULL | 마감 일자 |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `comments` | VARCHAR(500) | NULL | comments 필드 |

### `m_provisioning_criteria` - 대출 상품별/연체 구간별 대손충당금 설정 기준 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `criteria_name` | VARCHAR(200) | NOT NULL | criteria_name 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

### `m_provisioning_criteria_definition` - 충당금 기준별 충당 비율 및 연체 범위 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `criteria_id` | BIGINT | NOT NULL | criteria 참조 식별자 (FK) |
| `category_id` | BIGINT | NOT NULL | category 참조 식별자 (FK) |
| `min_age` | BIGINT | NOT NULL | min_age 필드 |
| `max_age` | BIGINT | NOT NULL | max_age 필드 |
| `provision_percentage` | DECIMAL(5, 2) | NOT NULL | provision_percentage 필드 |
| `liability_account` | BIGINT | NULL | liability_account 필드 |
| `expense_account` | BIGINT | NULL | expense_account 필드 |

### `m_provision_category` - 자산건전성 분류 카테고리 (정상, 요주의, 고정, 회수의문, 추정손실)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `category_name` | VARCHAR(100) | NOT NULL | category_name 필드 |
| `description` | VARCHAR(300) | NULL | 상세 설명 |

### `m_loanproduct_provisioning_entry` - 대출 상품별 대손충당금 산출 결과 및 분개 전표 연결
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `history_id` | BIGINT | NOT NULL | history 참조 식별자 (FK) |
| `criteria_id` | BIGINT | NOT NULL | criteria 참조 식별자 (FK) |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217) |
| `office_id` | BIGINT | NOT NULL | 지점 식별자 (FK: m_office.id) |
| `product_id` | BIGINT | NOT NULL | product 참조 식별자 (FK) |
| `category_id` | BIGINT | NOT NULL | category 참조 식별자 (FK) |
| `overdue_in_days` | BIGINT | NULL | overdue_in_days 필드 |
| `reseve_amount` | DECIMAL(20, 6) | NULL | reseve_amount 필드 |
| `liability_account` | BIGINT | NULL | liability_account 필드 |
| `expense_account` | BIGINT | NULL | expense_account 필드 |

### `m_provisioning_history` - 대손충당금 산출 배치 실행 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `journal_entry_created` | boolean | NULL | journal_entry_created 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | date | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | date | NULL | 최종 수정 일시 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/domain/LoanProductProvisioningEntry.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/domain/ProvisioningEntry.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/domain/ProvisioningCriteriaDefinition.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
