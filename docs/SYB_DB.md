# [SYB] DB명세서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

## SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `job` | 스케줄러 배치 작업 정의 (작업명, 크론표현식, 활성화여부) |
| `job_run_history` | 배치 작업 실행 이력 (시작시간, 종료시간, 성공/실패 상태, 오류메시지) |
| `job_parameters` | 배치 작업 실행 파라미터 |

### `job` - 스케줄러 배치 작업 정의 (작업명, 크론표현식, 활성화여부)
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

### `job_run_history` - 배치 작업 실행 이력 (시작시간, 종료시간, 성공/실패 상태, 오류메시지)
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

### `job_parameters` - 배치 작업 실행 파라미터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_id` | BIGINT | NOT NULL | job 참조 식별자 (FK) |
| `parameter_name` | VARCHAR(100) | NOT NULL | parameter_name 필드 |
| `parameter_value` | INT | NOT NULL | parameter_value 필드 |

## SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_batch_business_steps` | COB 일마감 비즈니스 스텝 순서 및 활성화 설정 |
| `m_loan_delinquency_tag_history` | COB 마감 시 산출된 대출 연체 구간 태깅 이력 |

### `m_batch_business_steps` - COB 일마감 비즈니스 스텝 순서 및 활성화 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_name` | VARCHAR(100) | NOT NULL | 배치 작업명 |
| `step_name` | VARCHAR(100) | NOT NULL | step_name 필드 |
| `step_order` | SMALLINT | NOT NULL | step_order 필드 |

### `m_loan_delinquency_tag_history` - COB 마감 시 산출된 대출 연체 구간 태깅 이력
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/domain/JobParameter.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/domain/ScheduledJobRunHistory.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0022_add_batch_business_step_configuration_table.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0145_job_short_name.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
