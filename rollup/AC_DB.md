# [AC] DB명세서 (회계결산)

> 소분류 3개 롤업.


---

## [ACC] DB명세서

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

### ACC-001 계정과목표(COA) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/glaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_gl_account` | 총계정원장 계정과목표(COA) 마스터 (자산/부채/자본/수익/비용 계정 트리, GL코드) |

#### `acc_gl_account` - 총계정원장 계정과목표(COA) 마스터 (자산/부채/자본/수익/비용 계정 트리, GL코드)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(200) | NOT NULL | 명칭 / 이름 |
| `parent_id` | BIGINT | NULL | parent 참조 식별자 (FK) |
| `hierarchy` | VARCHAR(50) | NULL | hierarchy 필드 |
| `gl_code` | VARCHAR(45) | NOT NULL | gl_code 필드 |
| `disabled` | boolean | NOT NULL | disabled 필드 |
| `manual_journal_entries_allowed` | boolean | NOT NULL | manual_journal_entries_allowed 필드 |
| `account_usage` | TINYINT | NOT NULL | account_usage 필드 |
| `classification_enum` | SMALLINT | NOT NULL | classification 유형 구분 Enum 코드 |
| `tag_id` | INT | NULL | tag 참조 식별자 (FK) |
| `description` | VARCHAR(500) | NULL | description 필드 |

### ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_gl_journal_entry` | 모든 회계 거래의 차변/대변 분개 전표 원장 (거래일자, 계정ID, 차대구분, 금액) |
| `m_journal_entry_aggregation_summary` | 일자별/계정별 분개 전표 집계 요약 |

#### `acc_gl_journal_entry` - 모든 회계 거래의 차변/대변 분개 전표 원장 (거래일자, 계정ID, 차대구분, 금액)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `submitted_on_date` | DATE | NOT NULL | submitted_on_date 일자 |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `reversal_id` | BIGINT | NULL | reversal 참조 식별자 (FK) |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `transaction_id` | VARCHAR(50) | NOT NULL | transaction 참조 식별자 (FK) |
| `loan_transaction_id` | BIGINT | NULL | loan_transaction 참조 식별자 (FK) |
| `savings_transaction_id` | BIGINT | NULL | savings_transaction 참조 식별자 (FK) |
| `client_transaction_id` | BIGINT | NULL | client_transaction 참조 식별자 (FK) |
| `reversed` | boolean | NOT NULL | reversed 필드 |
| `ref_num` | VARCHAR(100) | NULL | ref_num 필드 |
| `manual_entry` | boolean | NOT NULL | manual_entry 필드 |
| `entry_date` | date | NOT NULL | entry_date 일자 |
| `type_enum` | SMALLINT | NOT NULL | type 유형 구분 Enum 코드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `description` | VARCHAR(500) | NULL | description 필드 |
| `entity_type_enum` | SMALLINT | NULL | entity_type 유형 구분 Enum 코드 |
| `entity_id` | BIGINT | NULL | entity 참조 식별자 (FK) |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NOT NULL | 최종 수정자 ID |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `lastmodified_date` | datetime | NOT NULL | 최종 수정 일시 |
| `is_running_balance_calculated` | boolean | NOT NULL | running_balance_calculated 여부 플래그 (Boolean) |
| `office_running_balance` | DECIMAL(19, 6) | NOT NULL | office_running_balance 필드 |
| `organization_running_balance` | DECIMAL(19, 6) | NOT NULL | organization_running_balance 필드 |
| `payment_details_id` | BIGINT | NULL | payment_details 참조 식별자 (FK) |
| `share_transaction_id` | BIGINT | NULL | share_transaction 참조 식별자 (FK) |
| `transaction_date` | date | NULL | transaction_date 일자 |

#### `m_journal_entry_aggregation_summary` - 일자별/계정별 분개 전표 집계 요약
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `gl_account_id` | BIGINT | NOT NULL | gl_account 참조 식별자 (FK) |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `entity_type_enum` | SMALLINT | NOT NULL | entity_type 유형 구분 Enum 코드 |
| `aggregated_on_date` | DATE | NOT NULL | aggregated_on_date 일자 |
| `submitted_on_date` | DATE | NOT NULL | submitted_on_date 일자 |
| `external_owner_id` | BIGINT | NULL | external_owner 참조 식별자 (FK) |
| `debit_amount` | DECIMAL(19, 6) | NULL | debit_amount 금액 |
| `credit_amount` | DECIMAL(19, 6) | NULL | credit_amount 금액 |
| `manual_entry` | boolean | NOT NULL | manual_entry 필드 |
| `job_execution_id` | BIGINT | NOT NULL | job_execution 참조 식별자 (FK) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `created_on_utc` | DATETIME | NULL | 생성 일시 (UTC) |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | DATETIME | NULL | 최종 수정 일시 (UTC) |
| `originator_external_ids` | VARCHAR(1000) | NULL | originator_external_ids 필드 |

### ACC-003 기초잔액 등록

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/closure/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_gl_closure` | 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자 |
| `m_journal_entry_aggregation_tracking` | 회계 집계 배치 실행 추적 |

#### `acc_gl_closure` - 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `closing_date` | date | NOT NULL | closing_date 일자 |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `comments` | VARCHAR(500) | NULL | comments 필드 |

#### `m_journal_entry_aggregation_tracking` - 회계 집계 배치 실행 추적
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `aggregated_on_date_from` | DATE | NOT NULL | aggregated_on_date_from 필드 |
| `aggregated_on_date_to` | DATE | NOT NULL | aggregated_on_date_to 필드 |
| `submitted_on_date` | DATE | NOT NULL | submitted_on_date 일자 |
| `job_execution_id` | BIGINT | NOT NULL | job_execution 참조 식별자 (FK) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `created_on_utc` | DATETIME | NULL | 생성 일시 (UTC) |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | DATETIME | NULL | 최종 수정 일시 (UTC) |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/service/aggregationjob/domain/JournalEntryAggregationTracking.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/service/aggregationjob/domain/JournalEntrySummary.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0025_add_audit_entries_to_journal_entry.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0200_add_journal_entry_aggregation_tables.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0225_add_originator_external_ids_to_aggregation_summary.xml`

---

## [ACR] DB명세서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

### ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_accounting_rule` | 정형 거래별 차변/대변 계정 사전 정의 분개 규칙 |
| `acc_rule_tags` | 회계 규칙 태그 매핑 |
| `acc_product_mapping` | 여신/수신 상품별 대출원금, 이자수익, 미수이자 등 GL 계정 자동 매핑 |
| `acc_gl_financial_activity_account` | 현금수납, 개설잔액 등 주요 금융활동과 GL 계정 매핑 |

#### `acc_accounting_rule` - 정형 거래별 차변/대변 계정 사전 정의 분개 규칙
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

#### `acc_rule_tags` - 회계 규칙 태그 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `acc_rule_id` | BIGINT | NOT NULL | acc_rule 참조 식별자 (FK) |
| `tag_id` | INT | NOT NULL | tag 참조 식별자 (FK) |
| `acc_type_enum` | SMALLINT | NOT NULL | acc_type 유형 구분 Enum 코드 |

#### `acc_product_mapping` - 여신/수신 상품별 대출원금, 이자수익, 미수이자 등 GL 계정 자동 매핑
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

#### `acc_gl_financial_activity_account` - 현금수납, 개설잔액 등 주요 금융활동과 GL 계정 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `gl_account_id` | BIGINT | NOT NULL | gl_account 참조 식별자 (FK) |
| `financial_activity_type` | SMALLINT | NOT NULL | financial_activity_type 필드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0153_add_charge_off_reason_id_to_acc_product_mapping.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0198_add_classification_id_to_acc_product_mapping.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0199_write_off_reason_mapping_loan.xml`

---

## [ACP] DB명세서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

### ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `acc_gl_closure` | 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자 |
| `m_provisioning_criteria` | 대출 상품별/연체 구간별 대손충당금 설정 기준 마스터 |
| `m_provisioning_criteria_definition` | 충당금 기준별 충당 비율 및 연체 범위 정의 |
| `m_provision_category` | 자산건전성 분류 카테고리 (정상, 요주의, 고정, 회수의문, 추정손실) |
| `m_loanproduct_provisioning_entry` | 대출 상품별 대손충당금 산출 결과 및 분개 전표 연결 |
| `m_provisioning_history` | 대손충당금 산출 배치 실행 이력 |

#### `acc_gl_closure` - 지점별/회계기간별 회계 마감(결산) 이력 및 마감일자
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

#### `m_provisioning_criteria` - 대출 상품별/연체 구간별 대손충당금 설정 기준 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `criteria_name` | VARCHAR(200) | NOT NULL | criteria_name 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

#### `m_provisioning_criteria_definition` - 충당금 기준별 충당 비율 및 연체 범위 정의
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

#### `m_provision_category` - 자산건전성 분류 카테고리 (정상, 요주의, 고정, 회수의문, 추정손실)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `category_name` | VARCHAR(100) | NOT NULL | category_name 필드 |
| `description` | VARCHAR(300) | NULL | 상세 설명 |

#### `m_loanproduct_provisioning_entry` - 대출 상품별 대손충당금 산출 결과 및 분개 전표 연결
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

#### `m_provisioning_history` - 대손충당금 산출 배치 실행 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `journal_entry_created` | boolean | NULL | journal_entry_created 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | date | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | date | NULL | 최종 수정 일시 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/domain/LoanProductProvisioningEntry.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/domain/ProvisioningEntry.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/domain/ProvisioningCriteriaDefinition.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
