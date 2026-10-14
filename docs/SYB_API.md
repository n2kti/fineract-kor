# [SYB] API명세서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

## SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerJobApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/InlineJobApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveAll` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveOne` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveByShortName` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveHistory` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveHistoryByShortName` |
| `POST` | `/v1/jobs` | `SchedulerJobApiResource.executeJob` |
| `POST` | `/v1/jobs` | `SchedulerJobApiResource.executeJobByShortName` |
| `PUT` | `/v1/jobs` | `SchedulerJobApiResource.updateJobDetail` |
| `PUT` | `/v1/jobs` | `SchedulerJobApiResource.updateJobDetailByShortName` |
| `POST` | `/v1/jobs/{jobName}/inline` | `InlineJobApiResource.executeInlineJob` |
| `GET` | `/v1/scheduler` | `SchedulerApiResource.retrieveStatus` |
| `POST` | `/v1/scheduler` | `SchedulerApiResource.changeSchedulerStatus` |

### `GET /v1/jobs` - SchedulerJobApiResource.retrieveAll
- **설명**: `SchedulerJobApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs` - SchedulerJobApiResource.retrieveOne
- **설명**: `SchedulerJobApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs` - SchedulerJobApiResource.retrieveByShortName
- **설명**: `SchedulerJobApiResource`의 `retrieveByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs` - SchedulerJobApiResource.retrieveHistory
- **설명**: `SchedulerJobApiResource`의 `retrieveHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs` - SchedulerJobApiResource.retrieveHistoryByShortName
- **설명**: `SchedulerJobApiResource`의 `retrieveHistoryByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/jobs` - SchedulerJobApiResource.executeJob
- **설명**: `SchedulerJobApiResource`의 `executeJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/jobs` - SchedulerJobApiResource.executeJobByShortName
- **설명**: `SchedulerJobApiResource`의 `executeJobByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/jobs` - SchedulerJobApiResource.updateJobDetail
- **설명**: `SchedulerJobApiResource`의 `updateJobDetail` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/jobs` - SchedulerJobApiResource.updateJobDetailByShortName
- **설명**: `SchedulerJobApiResource`의 `updateJobDetailByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/jobs/{jobName}/inline` - InlineJobApiResource.executeInlineJob
- **설명**: `InlineJobApiResource`의 `executeInlineJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/scheduler` - SchedulerApiResource.retrieveStatus
- **설명**: `SchedulerApiResource`의 `retrieveStatus` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/scheduler` - SchedulerApiResource.changeSchedulerStatus
- **설명**: `SchedulerApiResource`의 `changeSchedulerStatus` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanCOBCatchUpApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/oldest-cob-closed` | `LoanCOBCatchUpApiResource.getOldestCOBProcessedLoan` |
| `POST` | `/v1/loans/catch-up` | `LoanCOBCatchUpApiResource.executeLoanCOBCatchUp` |
| `GET` | `/v1/loans/is-catch-up-running` | `LoanCOBCatchUpApiResource.isCatchUpRunning` |
| `GET` | `/v1/jobs/names` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs` |
| `GET` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep` |
| `PUT` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.updateJobBusinessStepConfig` |
| `GET` | `/v1/jobs/{jobName}/available-steps` | `ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep` |

### `GET /v1/loans/oldest-cob-closed` - LoanCOBCatchUpApiResource.getOldestCOBProcessedLoan
- **설명**: `LoanCOBCatchUpApiResource`의 `getOldestCOBProcessedLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/catch-up` - LoanCOBCatchUpApiResource.executeLoanCOBCatchUp
- **설명**: `LoanCOBCatchUpApiResource`의 `executeLoanCOBCatchUp` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/is-catch-up-running` - LoanCOBCatchUpApiResource.isCatchUpRunning
- **설명**: `LoanCOBCatchUpApiResource`의 `isCatchUpRunning` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs/names` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessJobs` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.updateJobBusinessStepConfig
- **설명**: `ConfigureBusinessStepApiResource`의 `updateJobBusinessStepConfig` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/jobs/{jobName}/available-steps` - ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllAvailableBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanCOBCatchUpApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/InlineJobApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerJobApiResource.java`
