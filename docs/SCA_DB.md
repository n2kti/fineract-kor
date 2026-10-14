# [SCA] DB명세서

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

## SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-provider/src/main/java/org/apache/fineract/commands/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_portfolio_command_source` | 모든 상태변경 API 요청의 감사 로그(Audit Trail) 및 Maker-Checker 결재 대기열 |
| `m_hook` | 시스템 이벤트 발생 시 외부 시스템 호출 웹훅(Hook) 마스터 |
| `m_hook_configuration` | 웹훅 연동 파라미터 및 URL 설정 |
| `m_hook_templates` | 웹훅 템플릿 정의 |

### `m_portfolio_command_source` - 모든 상태변경 API 요청의 감사 로그(Audit Trail) 및 Maker-Checker 결재 대기열
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_ip` | varchar(100) | NULL | client_ip 필드 |
| `loan_external_id` | VARCHAR(100) | NULL | loan_external 참조 식별자 (FK) |
| `made_on_date_utc` | TIMESTAMP WITH TIME ZONE | NULL | made_on_date_utc 필드 |
| `checked_on_date_utc` | TIMESTAMP WITH TIME ZONE | NULL | checked_on_date_utc 필드 |
| `resource_external_id` | VARCHAR(100) | NULL | resource_external 참조 식별자 (FK) |
| `subresource_external_id` | VARCHAR(100) | NULL | subresource_external 참조 식별자 (FK) |
| `job_name` | VARCHAR(100) | NULL | 배치 작업명 |
| `result` | TEXT | NULL | result 필드 |
| `result_status_code` | int | NULL | result_status_code 필드 |
| `is_sanitized` | boolean | NOT NULL | sanitized 여부 플래그 (Boolean) |
| `idempotency_key` | VARCHAR(50) | NULL | idempotency_key 필드 |
| `action_name` | VARCHAR(50) | NOT NULL | action_name 필드 |
| `entity_name` | VARCHAR(50) | NOT NULL | entity_name 필드 |
| `office_id` | BIGINT | NULL | 지점 식별자 (FK: m_office.id) |
| `group_id` | BIGINT | NULL | group 참조 식별자 (FK) |
| `client_id` | BIGINT | NULL | client 참조 식별자 (FK) |
| `loan_id` | BIGINT | NULL | loan 참조 식별자 (FK) |
| `savings_account_id` | BIGINT | NULL | savings_account 참조 식별자 (FK) |
| `api_get_url` | VARCHAR(100) | NOT NULL | api_get_url 필드 |
| `resource_id` | BIGINT | NULL | resource 참조 식별자 (FK) |
| `subresource_id` | BIGINT | NULL | subresource 참조 식별자 (FK) |
| `command_as_json` | TEXT | NOT NULL | command_as_json 필드 |
| `maker_id` | BIGINT | NOT NULL | maker 참조 식별자 (FK) |
| `made_on_date` | datetime | NOT NULL | made_on_date 관련 일자 |
| `checker_id` | BIGINT | NULL | checker 참조 식별자 (FK) |
| `checked_on_date` | datetime | NULL | checked_on_date 관련 일자 |
| `processing_result_enum` | SMALLINT | NOT NULL | processing_result 유형 구분 Enum 코드 |
| `product_id` | BIGINT | NULL | product 참조 식별자 (FK) |
| `transaction_id` | VARCHAR(100) | NULL | transaction 참조 식별자 (FK) |
| `creditbureau_id` | BIGINT | NULL | creditbureau 참조 식별자 (FK) |
| `organisation_creditbureau_id` | BIGINT | NULL | organisation_creditbureau 참조 식별자 (FK) |
| `status` | SMALLINT | NOT NULL | status 필드 |

### `m_hook` - 시스템 이벤트 발생 시 외부 시스템 호출 웹훅(Hook) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `template_id` | SMALLINT | NOT NULL | template 참조 식별자 (FK) |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `name` | VARCHAR(45) | NOT NULL | 명칭 / 이름 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `ugd_template_id` | BIGINT | NULL | ugd_template 참조 식별자 (FK) |

### `m_hook_configuration` - 웹훅 연동 파라미터 및 URL 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `hook_id` | BIGINT | NULL | hook 참조 식별자 (FK) |
| `field_type` | VARCHAR(45) | NOT NULL | field_type 필드 |
| `field_name` | VARCHAR(100) | NOT NULL | field_name 필드 |
| `field_value` | VARCHAR(100) | NOT NULL | field_value 필드 |

### `m_hook_templates` - 웹훅 템플릿 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | SMALLINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(45) | NOT NULL | 명칭 / 이름 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/commands/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/domain/Hook.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/domain/HookConfiguration.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/domain/HookTemplate.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0036_add_audit_entries_and_rework_command_source_datetime_fields.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0060_add_job_name_to_command_source.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0061_add_idempotency_key_to_command_source.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0071_add_external_id_support_for_loan_transaction.xml`
