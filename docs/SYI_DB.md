# [SYI] DB명세서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

## SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_import_document` | 엑셀/CSV 일괄 업로드(Bulk Import) 문서 및 처리 상태 |
| `sms_campaign` | SMS 대량 발송 캠페인 정의 |
| `sms_messages_outbound` | 발송 대상 SMS 메시지 큐 및 전송 결과 |
| `scheduled_email_campaign` | 이메일 발송 캠페인 정의 |
| `scheduled_email_messages_outbound` | 발송 대상 이메일 큐 및 전송 상태 |
| `interop_identifier` | Mojaloop 등 대외 결제 연계 식별자 매핑 |

### `m_import_document` - 엑셀/CSV 일괄 업로드(Bulk Import) 문서 및 처리 상태
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `document_id` | INT | NOT NULL | document 참조 식별자 (FK) |
| `import_time` | datetime | NOT NULL | import_time 필드 |
| `end_time` | datetime | NULL | end_time 필드 |
| `entity_type` | TINYINT | NOT NULL | entity_type 필드 |
| `completed` | boolean | NULL | completed 필드 |
| `total_records` | BIGINT | NULL | total_records 필드 |
| `success_count` | BIGINT | NULL | success_count 필드 |
| `failure_count` | BIGINT | NULL | failure_count 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |

### `sms_campaign` - SMS 대량 발송 캠페인 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `campaign_name` | VARCHAR(100) | NOT NULL | campaign_name 필드 |
| `campaign_type` | INT | NOT NULL | campaign_type 필드 |
| `campaign_trigger_type` | INT | NOT NULL | campaign_trigger_type 필드 |
| `report_id` | INT | NOT NULL | report 참조 식별자 (FK) |
| `provider_id` | BIGINT | NULL | provider 참조 식별자 (FK) |
| `param_value` | TEXT | NULL | param_value 필드 |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `message` | TEXT | NOT NULL | message 필드 |
| `submittedon_date` | date | NULL | submittedon_date 관련 일자 |
| `submittedon_userid` | BIGINT | NULL | submittedon_userid 필드 |
| `approvedon_date` | date | NULL | approvedon_date 관련 일자 |
| `approvedon_userid` | BIGINT | NULL | approvedon_userid 필드 |
| `closedon_date` | date | NULL | closedon_date 관련 일자 |
| `closedon_userid` | BIGINT | NULL | closedon_userid 필드 |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `next_trigger_date` | datetime | NULL | next_trigger_date 관련 일자 |
| `last_trigger_date` | datetime | NULL | last_trigger_date 관련 일자 |
| `recurrence_start_date` | datetime | NULL | recurrence_start_date 관련 일자 |
| `is_visible` | boolean | NULL | visible 여부 플래그 (Boolean) |
| `is_notification` | boolean | NULL | notification 여부 플래그 (Boolean) |

### `sms_messages_outbound` - 발송 대상 SMS 메시지 큐 및 전송 결과
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `group_id` | BIGINT | NULL | group 참조 식별자 (FK) |
| `client_id` | BIGINT | NULL | client 참조 식별자 (FK) |
| `staff_id` | BIGINT | NULL | 직원 식별자 (FK: m_staff.id) |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `mobile_no` | VARCHAR(50) | NULL | mobile_no 필드 |
| `message` | VARCHAR(1000) | NOT NULL | message 필드 |
| `campaign_id` | BIGINT | NULL | campaign 참조 식별자 (FK) |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |
| `submittedon_date` | date | NULL | submittedon_date 관련 일자 |
| `delivered_on_date` | datetime | NULL | delivered_on_date 관련 일자 |
| `is_notification` | boolean | NOT NULL | notification 여부 플래그 (Boolean) |

### `scheduled_email_campaign` - 이메일 발송 캠페인 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `campaign_name` | VARCHAR(100) | NOT NULL | campaign_name 필드 |
| `campaign_type` | INT | NOT NULL | campaign_type 필드 |
| `businessRule_id` | INT | NOT NULL | businessrule 참조 식별자 (FK) |
| `param_value` | TEXT | NULL | param_value 필드 |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `email_subject` | VARCHAR(100) | NOT NULL | email_subject 필드 |
| `email_message` | TEXT | NOT NULL | email_message 필드 |
| `email_attachment_file_format` | VARCHAR(10) | NULL | email_attachment_file_format 필드 |
| `stretchy_report_id` | INT | NULL | stretchy_report 참조 식별자 (FK) |
| `stretchy_report_param_map` | TEXT | NULL | stretchy_report_param_map 필드 |
| `closedon_date` | date | NULL | closedon_date 관련 일자 |
| `closedon_userid` | BIGINT | NULL | closedon_userid 필드 |
| `submittedon_date` | date | NULL | submittedon_date 관련 일자 |
| `submittedon_userid` | BIGINT | NULL | submittedon_userid 필드 |
| `approvedon_date` | date | NULL | approvedon_date 관련 일자 |
| `approvedon_userid` | BIGINT | NULL | approvedon_userid 필드 |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `next_trigger_date` | datetime | NULL | next_trigger_date 관련 일자 |
| `last_trigger_date` | datetime | NULL | last_trigger_date 관련 일자 |
| `recurrence_start_date` | datetime | NULL | recurrence_start_date 관련 일자 |
| `is_visible` | boolean | NULL | visible 여부 플래그 (Boolean) |
| `previous_run_error_log` | TEXT | NULL | previous_run_error_log 필드 |
| `previous_run_error_message` | TEXT | NULL | previous_run_error_message 필드 |
| `previous_run_status` | VARCHAR(10) | NULL | previous_run_status 필드 |

### `scheduled_email_messages_outbound` - 발송 대상 이메일 큐 및 전송 상태
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `group_id` | BIGINT | NULL | group 참조 식별자 (FK) |
| `client_id` | BIGINT | NULL | client 참조 식별자 (FK) |
| `staff_id` | BIGINT | NULL | 직원 식별자 (FK: m_staff.id) |
| `email_campaign_id` | BIGINT | NULL | email_campaign 참조 식별자 (FK) |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `email_address` | VARCHAR(50) | NOT NULL | email_address 필드 |
| `email_subject` | VARCHAR(50) | NOT NULL | email_subject 필드 |
| `message` | TEXT | NOT NULL | message 필드 |
| `campaign_name` | VARCHAR(200) | NULL | campaign_name 필드 |
| `submittedon_date` | date | NULL | submittedon_date 관련 일자 |
| `error_message` | TEXT | NULL | error_message 필드 |

### `interop_identifier` - Mojaloop 등 대외 결제 연계 식별자 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `type` | VARCHAR(32) | NOT NULL | type 필드 |
| `a_value` | VARCHAR(128) | NOT NULL | a_value 필드 |
| `sub_value_or_type` | VARCHAR(128) | NULL | sub_value_or_type 필드 |
| `created_by` | VARCHAR(32) | NOT NULL | created_by 필드 |
| `created_on` | timestamp | NOT NULL | created_on 필드 |
| `modified_by` | VARCHAR(32) | NULL | modified_by 필드 |
| `modified_on` | timestamp | NULL | modified_on 필드 |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/domain/ImportDocument.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/domain/EmailCampaign.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/domain/EmailMessage.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/sms/domain/SmsMessage.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
