# [RPS] DB명세서

> 화면 1개 롤업(소분류 RPS, 대분류 RP - 사회성과 관리).

## RPS-001 사회성과(SPM) 지표 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/spm/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_surveys` | 사회성과 설문조사(Survey / PPI) 마스터 |
| `m_survey_questions` | 설문 문항 마스터 |
| `m_survey_responses` | 설문 문항별 선택지/답변 옵션 |
| `m_survey_scorecards` | 고객별 설문조사 응답 결과 및 산출 점수(Scorecard) |
| `ppi_likelihoods` | PPI 점수 구간별 빈곤 확률(Likelihood) 매트릭스 |

### `m_surveys` - 사회성과 설문조사(Survey / PPI) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `a_key` | VARCHAR(32) | NOT NULL | a_key 필드 |
| `a_name` | VARCHAR(255) | NOT NULL | a_name 필드 |
| `description` | VARCHAR(4000) | NULL | 상세 설명 |
| `country_code` | VARCHAR(2) | NOT NULL | country_code 필드 |
| `valid_from` | datetime | NULL | 유효 시작일자 |
| `valid_to` | datetime | NULL | 유효 종료일자 |

### `m_survey_questions` - 설문 문항 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `survey_id` | BIGINT | NOT NULL | survey 참조 식별자 (FK) |
| `component_key` | VARCHAR(32) | NULL | component_key 필드 |
| `a_key` | VARCHAR(32) | NOT NULL | a_key 필드 |
| `a_text` | VARCHAR(255) | NOT NULL | a_text 필드 |
| `description` | VARCHAR(4000) | NULL | 상세 설명 |
| `sequence_no` | INT | NOT NULL | sequence_no 필드 |

### `m_survey_responses` - 설문 문항별 선택지/답변 옵션
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `question_id` | BIGINT | NOT NULL | question 참조 식별자 (FK) |
| `a_text` | VARCHAR(255) | NOT NULL | a_text 필드 |
| `a_value` | INT | NOT NULL | a_value 필드 |
| `sequence_no` | INT | NOT NULL | sequence_no 필드 |

### `m_survey_scorecards` - 고객별 설문조사 응답 결과 및 산출 점수(Scorecard)
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

### `ppi_likelihoods` - PPI 점수 구간별 빈곤 확률(Likelihood) 매트릭스
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(100) | NOT NULL | code 필드 |
| `name` | VARCHAR(250) | NOT NULL | 명칭 / 이름 |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/spm/`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Question.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Response.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Scorecard.java`
- `fineract-provider/src/main/java/org/apache/fineract/spm/domain/Survey.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
