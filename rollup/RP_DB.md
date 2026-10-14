# [RP] DB명세서 (보고서통계)

> 소분류 2개 롤업.


---

## [RPR] DB명세서

> 화면 2개 롤업(소분류 RPR, 대분류 RP - 보고서 및 조회).

### RPR-001 보고서 조회 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `stretchy_report` | 보고서 템플릿 마스터 (보고서명, SQL 쿼리, 카테고리, UI표시여부) |
| `stretchy_report_parameter` | 보고서와 검색 파라미터 간 매핑 |
| `stretchy_parameter` | 보고서 파라미터(지점, 일자, 통화 등) 정의 |

#### `stretchy_report` - 보고서 템플릿 마스터 (보고서명, SQL 쿼리, 카테고리, UI표시여부)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `report_id` | INT | PK, NOT NULL | report 참조 식별자 (FK) |
| `report_name` | VARCHAR(100) | NOT NULL | report_name 필드 |
| `report_type` | VARCHAR(20) | NOT NULL | report_type 필드 |
| `report_subtype` | VARCHAR(20) | NULL | report_subtype 필드 |
| `report_category` | VARCHAR(45) | NULL | report_category 필드 |
| `report_sql` | TEXT | NULL | report_sql 필드 |
| `description` | TEXT | NULL | 상세 설명 |
| `core_report` | boolean | NULL | core_report 필드 |
| `use_report` | boolean | NULL | use_report 필드 |
| `self_service_user_report` | boolean | NOT NULL | self_service_user_report 필드 |

#### `stretchy_report_parameter` - 보고서와 검색 파라미터 간 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `report_id` | INT | NOT NULL | report 참조 식별자 (FK) |
| `parameter_id` | INT | NOT NULL | parameter 참조 식별자 (FK) |
| `report_parameter_name` | VARCHAR(45) | NULL | report_parameter_name 필드 |

#### `stretchy_parameter` - 보고서 파라미터(지점, 일자, 통화 등) 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `parameter_id` | INT | PK, NOT NULL | parameter 참조 식별자 (FK) |
| `parameter_name` | VARCHAR(45) | NOT NULL | parameter_name 필드 |
| `parameter_variable` | VARCHAR(45) | NULL | parameter_variable 필드 |
| `parameter_label` | VARCHAR(45) | NOT NULL | parameter_label 필드 |
| `parameter_displayType` | VARCHAR(45) | NOT NULL | parameter_displayType 필드 |
| `parameter_FormatType` | VARCHAR(10) | NOT NULL | parameter_FormatType 필드 |
| `parameter_default` | VARCHAR(45) | NOT NULL | parameter_default 필드 |
| `special` | VARCHAR(1) | NULL | special 필드 |
| `selectOne` | VARCHAR(1) | NULL | selectOne 필드 |
| `selectAll` | VARCHAR(1) | NULL | selectAll 필드 |
| `parameter_sql` | TEXT | NULL | parameter_sql 필드 |
| `parent_id` | INT | NULL | parent 참조 식별자 (FK) |
| `parent_parameter_id` | INT | NULL | parent_parameter 참조 식별자 (FK) |
| `INDEX` | `fk_stretchy_parameter_0001_idx` | NULL | INDEX 필드 |

### RPR-002 보고서 정의 및 메일링 작업

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/reportmailingjob/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_report_mailing_job` | 보고서 자동 메일링 스케줄 작업 마스터 |
| `m_report_mailing_job_run_history` | 보고서 메일링 발송 이력 |

#### `m_report_mailing_job` - 보고서 자동 메일링 스케줄 작업 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `description` | TEXT | NULL | 상세 설명 |
| `start_datetime` | datetime | NOT NULL | start_datetime 필드 |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `created_date` | date | NOT NULL | 생성 일시 |
| `createdby_id` | BIGINT | NOT NULL | 생성자 ID |
| `lastmodified_date` | date | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `email_recipients` | TEXT | NOT NULL | email_recipients 필드 |
| `email_subject` | VARCHAR(100) | NOT NULL | email_subject 필드 |
| `email_message` | TEXT | NOT NULL | email_message 필드 |
| `email_attachment_file_format` | VARCHAR(10) | NOT NULL | email_attachment_file_format 필드 |
| `stretchy_report_id` | INT | NOT NULL | stretchy_report 참조 식별자 (FK) |
| `stretchy_report_param_map` | TEXT | NULL | stretchy_report_param_map 필드 |
| `previous_run_datetime` | datetime | NULL | previous_run_datetime 필드 |
| `next_run_datetime` | datetime | NULL | next_run_datetime 필드 |
| `previous_run_status` | VARCHAR(10) | NULL | previous_run_status 필드 |
| `previous_run_error_log` | TEXT | NULL | previous_run_error_log 필드 |
| `previous_run_error_message` | TEXT | NULL | previous_run_error_message 필드 |
| `number_of_runs` | INT | NOT NULL | number_of_runs 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `run_as_userid` | BIGINT | NOT NULL | run_as_userid 필드 |

#### `m_report_mailing_job_run_history` - 보고서 메일링 발송 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_id` | BIGINT | NOT NULL | job 참조 식별자 (FK) |
| `start_datetime` | datetime | NOT NULL | start_datetime 필드 |
| `end_datetime` | datetime | NOT NULL | end_datetime 필드 |
| `status` | VARCHAR(10) | NOT NULL | status 필드 |
| `error_message` | TEXT | NULL | error_message 필드 |
| `error_log` | TEXT | NULL | error_log 필드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/domain/ReportParameter.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/domain/ReportParameterUsage.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/reportmailingjob/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/reportmailingjob/domain/ReportMailingJobRunHistory.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`

---

## [RPS] DB명세서

> 화면 1개 롤업(소분류 RPS, 대분류 RP - 사회성과 관리).

### RPS-001 사회성과(SPM) 지표 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/spm/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_surveys` | 사회성과 설문조사(Survey / PPI) 마스터 |
| `m_survey_questions` | 설문 문항 마스터 |
| `m_survey_responses` | 설문 문항별 선택지/답변 옵션 |
| `m_survey_scorecards` | 고객별 설문조사 응답 결과 및 산출 점수(Scorecard) |
| `ppi_likelihoods` | PPI 점수 구간별 빈곤 확률(Likelihood) 매트릭스 |

#### `m_surveys` - 사회성과 설문조사(Survey / PPI) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `a_key` | VARCHAR(32) | NOT NULL | a_key 필드 |
| `a_name` | VARCHAR(255) | NOT NULL | a_name 필드 |
| `description` | VARCHAR(4000) | NULL | 상세 설명 |
| `country_code` | VARCHAR(2) | NOT NULL | country_code 필드 |
| `valid_from` | datetime | NULL | 유효 시작일자 |
| `valid_to` | datetime | NULL | 유효 종료일자 |

#### `m_survey_questions` - 설문 문항 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `survey_id` | BIGINT | NOT NULL | survey 참조 식별자 (FK) |
| `component_key` | VARCHAR(32) | NULL | component_key 필드 |
| `a_key` | VARCHAR(32) | NOT NULL | a_key 필드 |
| `a_text` | VARCHAR(255) | NOT NULL | a_text 필드 |
| `description` | VARCHAR(4000) | NULL | 상세 설명 |
| `sequence_no` | INT | NOT NULL | sequence_no 필드 |

#### `m_survey_responses` - 설문 문항별 선택지/답변 옵션
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `question_id` | BIGINT | NOT NULL | question 참조 식별자 (FK) |
| `a_text` | VARCHAR(255) | NOT NULL | a_text 필드 |
| `a_value` | INT | NOT NULL | a_value 필드 |
| `sequence_no` | INT | NOT NULL | sequence_no 필드 |

#### `m_survey_scorecards` - 고객별 설문조사 응답 결과 및 산출 점수(Scorecard)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `survey_id` | BIGINT | NOT NULL | survey 참조 식별자 (FK) |
| `question_id` | BIGINT | NOT NULL | question 참조 식별자 (FK) |
| `response_id` | BIGINT | NOT NULL | response 참조 식별자 (FK) |
| `user_id` | BIGINT | NOT NULL | 사용자 식별자 (FK: m_appuser.id) |
| `client_id` | BIGINT | NOT NULL | client 참조 식별자 (FK) |
| `created_on` | datetime | NULL | created_on 필드 |
| `a_value` | INT | NOT NULL | a_value 필드 |

#### `ppi_likelihoods` - PPI 점수 구간별 빈곤 확률(Likelihood) 매트릭스
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(100) | NOT NULL | code 필드 |
| `name` | VARCHAR(250) | NOT NULL | 명칭 / 이름 |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/spm/`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Question.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Response.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Scorecard.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Survey.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
