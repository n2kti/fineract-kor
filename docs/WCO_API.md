# [WCO] API명세서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

## WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/WorkingCapitalLoanCOBCatchUpApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanAccountLockApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/working-capital-loans/oldest-cob-closed` | `WorkingCapitalLoanCOBCatchUpApiResource.getOldestCOBProcessedLoan` |
| `POST` | `/v1/working-capital-loans/catch-up` | `WorkingCapitalLoanCOBCatchUpApiResource.executeLoanCOBCatchUp` |
| `GET` | `/v1/working-capital-loans/is-catch-up-running` | `WorkingCapitalLoanCOBCatchUpApiResource.isCatchUpRunning` |
| `GET` | `/v1/loans/locked` | `LoanAccountLockApiResource.retrieveLockedAccounts` |

### `GET /v1/working-capital-loans/oldest-cob-closed` - WorkingCapitalLoanCOBCatchUpApiResource.getOldestCOBProcessedLoan
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `getOldestCOBProcessedLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/working-capital-loans/catch-up` - WorkingCapitalLoanCOBCatchUpApiResource.executeLoanCOBCatchUp
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `executeLoanCOBCatchUp` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/working-capital-loans/is-catch-up-running` - WorkingCapitalLoanCOBCatchUpApiResource.isCatchUpRunning
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `isCatchUpRunning` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/locked` - LoanAccountLockApiResource.retrieveLockedAccounts
- **설명**: `LoanAccountLockApiResource`의 `retrieveLockedAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `page` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/InternalLoanAccountLockApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/internal/loans/{loanId}/place-lock/{lockOwner}` | `InternalLoanAccountLockApiResource.placeLockOnLoanAccount` |
| `GET` | `/v1/jobs/names` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs` |
| `GET` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep` |
| `PUT` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.updateJobBusinessStepConfig` |
| `GET` | `/v1/jobs/{jobName}/available-steps` | `ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep` |

### `POST /v1/internal/loans/{loanId}/place-lock/{lockOwner}` - InternalLoanAccountLockApiResource.placeLockOnLoanAccount
- **설명**: `InternalLoanAccountLockApiResource`의 `placeLockOnLoanAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `lockOwner` (PathParam): `String` 타입 식별자/필터
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
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/InternalLoanAccountLockApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanAccountLockApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/WorkingCapitalLoanCOBCatchUpApiResource.java`
