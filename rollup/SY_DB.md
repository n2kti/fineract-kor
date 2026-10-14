# [SY] DB명세서 (시스템운영)

> 소분류 3개 롤업.


---

## [SYC] DB명세서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

### SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_code` | 시스템 공통 코드 그룹 마스터 |
| `m_code_value` | 코드 그룹에 속한 개별 코드값(Code Value) 및 표시 순서 |

#### `m_code` - 시스템 공통 코드 그룹 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_name` | VARCHAR(100) | NULL | code_name 필드 |
| `is_system_defined` | boolean | NOT NULL | system_defined 여부 플래그 (Boolean) |

#### `m_code_value` - 코드 그룹에 속한 개별 코드값(Code Value) 및 표시 순서
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_id` | INT | NOT NULL | code 참조 식별자 (FK) |
| `code_value` | VARCHAR(100) | NULL | code_value 필드 |
| `code_description` | VARCHAR(500) | NULL | code_description 필드 |
| `order_position` | INT | NOT NULL | order_position 필드 |
| `code_score` | INT | NULL | code_score 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `is_mandatory` | boolean | NOT NULL | mandatory 여부 플래그 (Boolean) |

### SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `c_configuration` | 시스템 전역 환경 파라미터 (다중지점여부, 회계적용여부 등) |
| `c_external_service` | 외부 서비스 연동 설정 (S3, SMTP 등) |
| `m_business_date` | 지점별/시스템 현재 영업일자(Business Date) |
| `m_holiday` | 공휴일 마스터 |
| `m_working_days` | 영업일(월~금) 및 휴일 상환 처리 규칙 설정 |

#### `c_configuration` - 시스템 전역 환경 파라미터 (다중지점여부, 회계적용여부 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `value` | INT | NULL | value 필드 |
| `date_value` | date | NULL | date_value 필드 |
| `string_value` | VARCHAR(100) | NULL | string_value 필드 |
| `enabled` | boolean | NOT NULL | enabled 필드 |
| `is_trap_door` | boolean | NOT NULL | trap_door 여부 플래그 (Boolean) |
| `description` | VARCHAR(300) | NULL | 상세 설명 |

#### `c_external_service` - 외부 서비스 연동 설정 (S3, SMTP 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |

#### `m_business_date` - 지점별/시스템 현재 영업일자(Business Date)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `type` | VARCHAR(100) | NOT NULL | type 필드 |
| `date` | DATE | NOT NULL | date 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | DATETIME  | NULL | 생성 일시 |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | DATETIME | NULL | 최종 수정 일시 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |

#### `m_holiday` - 공휴일 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `from_date` | datetime | NOT NULL | from_date 관련 일자 |
| `to_date` | datetime | NOT NULL | to_date 관련 일자 |
| `repayments_rescheduled_to` | datetime | NULL | repayments_rescheduled_to 필드 |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `processed` | boolean | NOT NULL | processed 필드 |
| `description` | VARCHAR(100) | NULL | 상세 설명 |
| `rescheduling_type` | INT | NOT NULL | rescheduling_type 필드 |

#### `m_working_days` - 영업일(월~금) 및 휴일 상환 처리 규칙 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `repayment_rescheduling_enum` | SMALLINT | NULL | repayment_rescheduling 유형 구분 Enum 코드 |
| `extend_term_daily_repayments` | boolean | NULL | extend_term_daily_repayments 필드 |
| `extend_term_holiday_repayment` | boolean | NOT NULL | extend_term_holiday_repayment 필드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0015_add_business_date.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0030_add_audit_entries_to_business_date.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`

---

## [SYB] DB명세서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

### SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `job` | 스케줄러 배치 작업 정의 (작업명, 크론표현식, 활성화여부) |
| `job_run_history` | 배치 작업 실행 이력 (시작시간, 종료시간, 성공/실패 상태, 오류메시지) |
| `job_parameters` | 배치 작업 실행 파라미터 |

#### `job` - 스케줄러 배치 작업 정의 (작업명, 크론표현식, 활성화여부)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `short_name` | VARCHAR(8) | NULL | short_name 필드 |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `display_name` | VARCHAR(100) | NOT NULL | display_name 필드 |
| `cron_expression` | VARCHAR(20) | NOT NULL | 크론(Cron) 스케줄 표현식 |
| `create_time` | datetime | NOT NULL | create_time 필드 |
| `task_priority` | SMALLINT | NOT NULL | task_priority 필드 |
| `group_name` | VARCHAR(50) | NULL | group_name 필드 |
| `previous_run_start_time` | datetime | NULL | previous_run_start_time 필드 |
| `next_run_time` | datetime | NULL | next_run_time 필드 |
| `job_key` | VARCHAR(500) | NULL | 배치 작업 식별키 |
| `initializing_errorlog` | TEXT | NULL | initializing_errorlog 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `currently_running` | boolean | NOT NULL | currently_running 필드 |
| `updates_allowed` | boolean | NOT NULL | updates_allowed 필드 |
| `scheduler_group` | SMALLINT | NOT NULL | scheduler_group 필드 |
| `is_misfired` | boolean | NOT NULL | misfired 여부 플래그 (Boolean) |
| `node_id` | INT | NULL | node 참조 식별자 (FK) |
| `is_mismatched_job` | boolean | NULL | mismatched_job 여부 플래그 (Boolean) |

#### `job_run_history` - 배치 작업 실행 이력 (시작시간, 종료시간, 성공/실패 상태, 오류메시지)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_id` | BIGINT | NOT NULL | job 참조 식별자 (FK) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `start_time` | datetime | NOT NULL | start_time 필드 |
| `end_time` | datetime | NOT NULL | end_time 필드 |
| `status` | VARCHAR(10) | NOT NULL | status 필드 |
| `error_message` | TEXT | NULL | error_message 필드 |
| `trigger_type` | VARCHAR(25) | NOT NULL | trigger_type 필드 |
| `error_log` | TEXT | NULL | error_log 필드 |

#### `job_parameters` - 배치 작업 실행 파라미터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_id` | BIGINT | NOT NULL | job 참조 식별자 (FK) |
| `parameter_name` | VARCHAR(100) | NOT NULL | parameter_name 필드 |
| `parameter_value` | INT | NOT NULL | parameter_value 필드 |

### SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_batch_business_steps` | COB 일마감 비즈니스 스텝 순서 및 활성화 설정 |
| `m_loan_delinquency_tag_history` | COB 마감 시 산출된 대출 연체 구간 태깅 이력 |

#### `m_batch_business_steps` - COB 일마감 비즈니스 스텝 순서 및 활성화 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_name` | VARCHAR(100) | NOT NULL | 배치 작업명 |
| `step_name` | VARCHAR(100) | NOT NULL | step_name 필드 |
| `step_order` | SMALLINT | NOT NULL | step_order 필드 |

#### `m_loan_delinquency_tag_history` - COB 마감 시 산출된 대출 연체 구간 태깅 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `delinquency_range_id` | BIGINT | NOT NULL | delinquency_range 참조 식별자 (FK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `addedon_date` | DATE | NOT NULL | addedon_date 관련 일자 |
| `liftedon_date` | DATE | NULL | liftedon_date 관련 일자 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/domain/JobParameter.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/domain/ScheduledJobRunHistory.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0022_add_batch_business_step_configuration_table.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0145_job_short_name.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`

---

## [SYI] DB명세서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

### SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_import_document` | 엑셀/CSV 일괄 업로드(Bulk Import) 문서 및 처리 상태 |
| `sms_campaign` | SMS 대량 발송 캠페인 정의 |
| `sms_messages_outbound` | 발송 대상 SMS 메시지 큐 및 전송 결과 |
| `scheduled_email_campaign` | 이메일 발송 캠페인 정의 |
| `scheduled_email_messages_outbound` | 발송 대상 이메일 큐 및 전송 상태 |
| `interop_identifier` | Mojaloop 등 대외 결제 연계 식별자 매핑 |

#### `m_import_document` - 엑셀/CSV 일괄 업로드(Bulk Import) 문서 및 처리 상태
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

#### `sms_campaign` - SMS 대량 발송 캠페인 정의
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

#### `sms_messages_outbound` - 발송 대상 SMS 메시지 큐 및 전송 결과
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

#### `scheduled_email_campaign` - 이메일 발송 캠페인 정의
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

#### `scheduled_email_messages_outbound` - 발송 대상 이메일 큐 및 전송 상태
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

#### `interop_identifier` - Mojaloop 등 대외 결제 연계 식별자 매핑
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/domain/ImportDocument.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/domain/EmailCampaign.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/domain/EmailMessage.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/sms/domain/SmsMessage.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
