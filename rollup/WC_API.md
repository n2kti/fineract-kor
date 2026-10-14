# [WC] API명세서 (운전자금)

> 소분류 3개 롤업.


---

## [WCL] API명세서

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

### WCL-001 운전자금 대출 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/template` | `LoansApiResource.retrieveApprovalTemplate` |
| `GET` | `/v1/loans/template` | `LoansApiResource.template` |
| `GET` | `/v1/loans/{loanId}` | `LoansApiResource.retrieveLoan` |
| `GET` | `/v1/loans` | `LoansApiResource.retrieveAll` |
| `POST` | `/v1/loans` | `LoansApiResource.calculateLoanScheduleOrSubmitLoanApplication` |
| `PUT` | `/v1/loans/{loanId}` | `LoansApiResource.modifyLoanApplication` |
| `DELETE` | `/v1/loans/{loanId}` | `LoansApiResource.deleteLoanApplication` |
| `POST` | `/v1/loans/{loanId}` | `LoansApiResource.stateTransitions` |
| `GET` | `/v1/loans/downloadtemplate` | `LoansApiResource.getLoansTemplate` |
| `GET` | `/v1/loans/glimAccount/{glimId}` | `LoansApiResource.getGlimRepaymentTemplate` |
| `POST` | `/v1/loans/glimAccount/{glimId}` | `LoansApiResource.glimStateTransitions` |
| `GET` | `/v1/loans/repayments/downloadtemplate` | `LoansApiResource.getLoanRepaymentTemplate` |
| `POST` | `/v1/loans/uploadtemplate` | `LoansApiResource.postLoanTemplate` |
| `POST` | `/v1/loans/repayments/uploadtemplate` | `LoansApiResource.postLoanRepaymentTemplate` |
| `GET` | `/v1/loans/{loanId}/delinquencytags` | `LoansApiResource.getDelinquencyTagHistory` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/template` | `LoansApiResource.retrieveApprovalTemplate` |
| `GET` | `/v1/loans/external-id/{loanExternalId}` | `LoansApiResource.retrieveLoan` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}` | `LoansApiResource.modifyLoanApplication` |
| `DELETE` | `/v1/loans/external-id/{loanExternalId}` | `LoansApiResource.deleteLoanApplication` |
| `POST` | `/v1/loans/external-id/{loanExternalId}` | `LoansApiResource.stateTransitions` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/delinquencytags` | `LoansApiResource.getDelinquencyTagHistory` |
| `GET` | `/v1/loans/{loanId}/delinquency-actions` | `LoansApiResource.getLoanDelinquencyActions` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/delinquency-actions` | `LoansApiResource.getLoanDelinquencyActions` |
| `POST` | `/v1/loans/{loanId}/delinquency-actions` | `LoansApiResource.createLoanDelinquencyAction` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/delinquency-actions` | `LoansApiResource.createLoanDelinquencyAction` |
| `PUT` | `/v1/loans/{loanId}/approved-amount` | `LoansApiResource.modifyLoanApprovedAmount` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/approved-amount` | `LoansApiResource.modifyLoanApprovedAmount` |
| `GET` | `/v1/loans/{loanId}/approved-amount` | `LoansApiResource.getLoanApprovedAmountHistory` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/approved-amount` | `LoansApiResource.getLoanApprovedAmountHistory` |
| `PUT` | `/v1/loans/{loanId}/available-disbursement-amount` | `LoansApiResource.modifyLoanAvailableDisbursementAmount` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/available-disbursement-amount` | `LoansApiResource.modifyLoanAvailableDisbursementAmount` |

#### `GET /v1/loans/{loanId}/template` - LoansApiResource.retrieveApprovalTemplate
- **설명**: `LoansApiResource`의 `retrieveApprovalTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/template` - LoansApiResource.template
- **설명**: `LoansApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}` - LoansApiResource.retrieveLoan
- **설명**: `LoansApiResource`의 `retrieveLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans` - LoansApiResource.retrieveAll
- **설명**: `LoansApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `underHierarchy` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans` - LoansApiResource.calculateLoanScheduleOrSubmitLoanApplication
- **설명**: `LoansApiResource`의 `calculateLoanScheduleOrSubmitLoanApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}` - LoansApiResource.modifyLoanApplication
- **설명**: `LoansApiResource`의 `modifyLoanApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/{loanId}` - LoansApiResource.deleteLoanApplication
- **설명**: `LoansApiResource`의 `deleteLoanApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}` - LoansApiResource.stateTransitions
- **설명**: `LoansApiResource`의 `stateTransitions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/downloadtemplate` - LoansApiResource.getLoansTemplate
- **설명**: `LoansApiResource`의 `getLoansTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/glimAccount/{glimId}` - LoansApiResource.getGlimRepaymentTemplate
- **설명**: `LoansApiResource`의 `getGlimRepaymentTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glimId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/glimAccount/{glimId}` - LoansApiResource.glimStateTransitions
- **설명**: `LoansApiResource`의 `glimStateTransitions` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glimId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/repayments/downloadtemplate` - LoansApiResource.getLoanRepaymentTemplate
- **설명**: `LoansApiResource`의 `getLoanRepaymentTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
  - `includeLookups` (QueryParam): `Boolean` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/uploadtemplate` - LoansApiResource.postLoanTemplate
- **설명**: `LoansApiResource`의 `postLoanTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/repayments/uploadtemplate` - LoansApiResource.postLoanRepaymentTemplate
- **설명**: `LoansApiResource`의 `postLoanRepaymentTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/delinquencytags` - LoansApiResource.getDelinquencyTagHistory
- **설명**: `LoansApiResource`의 `getDelinquencyTagHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/template` - LoansApiResource.retrieveApprovalTemplate
- **설명**: `LoansApiResource`의 `retrieveApprovalTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}` - LoansApiResource.retrieveLoan
- **설명**: `LoansApiResource`의 `retrieveLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}` - LoansApiResource.modifyLoanApplication
- **설명**: `LoansApiResource`의 `modifyLoanApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/external-id/{loanExternalId}` - LoansApiResource.deleteLoanApplication
- **설명**: `LoansApiResource`의 `deleteLoanApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}` - LoansApiResource.stateTransitions
- **설명**: `LoansApiResource`의 `stateTransitions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/delinquencytags` - LoansApiResource.getDelinquencyTagHistory
- **설명**: `LoansApiResource`의 `getDelinquencyTagHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/delinquency-actions` - LoansApiResource.getLoanDelinquencyActions
- **설명**: `LoansApiResource`의 `getLoanDelinquencyActions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/delinquency-actions` - LoansApiResource.getLoanDelinquencyActions
- **설명**: `LoansApiResource`의 `getLoanDelinquencyActions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/delinquency-actions` - LoansApiResource.createLoanDelinquencyAction
- **설명**: `LoansApiResource`의 `createLoanDelinquencyAction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/delinquency-actions` - LoansApiResource.createLoanDelinquencyAction
- **설명**: `LoansApiResource`의 `createLoanDelinquencyAction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/approved-amount` - LoansApiResource.modifyLoanApprovedAmount
- **설명**: `LoansApiResource`의 `modifyLoanApprovedAmount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/approved-amount` - LoansApiResource.modifyLoanApprovedAmount
- **설명**: `LoansApiResource`의 `modifyLoanApprovedAmount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/approved-amount` - LoansApiResource.getLoanApprovedAmountHistory
- **설명**: `LoansApiResource`의 `getLoanApprovedAmountHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/approved-amount` - LoansApiResource.getLoanApprovedAmountHistory
- **설명**: `LoansApiResource`의 `getLoanApprovedAmountHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/available-disbursement-amount` - LoansApiResource.modifyLoanAvailableDisbursementAmount
- **설명**: `LoansApiResource`의 `modifyLoanAvailableDisbursementAmount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/available-disbursement-amount` - LoansApiResource.modifyLoanAvailableDisbursementAmount
- **설명**: `LoansApiResource`의 `modifyLoanAvailableDisbursementAmount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`

---

## [WCP] API명세서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

### WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/loanproducts` | `LoanProductsApiResource.createLoanProduct` |
| `GET` | `/v1/loanproducts` | `LoanProductsApiResource.retrieveAllLoanProducts` |
| `GET` | `/v1/loanproducts/template` | `LoanProductsApiResource.retrieveTemplate` |
| `GET` | `/v1/loanproducts/{productId}` | `LoanProductsApiResource.retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/{productId}` | `LoanProductsApiResource.updateLoanProduct` |
| `GET` | `/v1/loanproducts/external-id/{externalProductId}` | `LoanProductsApiResource.retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/external-id/{externalProductId}` | `LoanProductsApiResource.updateLoanProduct` |

#### `POST /v1/loanproducts` - LoanProductsApiResource.createLoanProduct
- **설명**: `LoanProductsApiResource`의 `createLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loanproducts` - LoanProductsApiResource.retrieveAllLoanProducts
- **설명**: `LoanProductsApiResource`의 `retrieveAllLoanProducts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loanproducts/template` - LoanProductsApiResource.retrieveTemplate
- **설명**: `LoanProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loanproducts/{productId}` - LoanProductsApiResource.retrieveLoanProductDetails
- **설명**: `LoanProductsApiResource`의 `retrieveLoanProductDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loanproducts/{productId}` - LoanProductsApiResource.updateLoanProduct
- **설명**: `LoanProductsApiResource`의 `updateLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loanproducts/external-id/{externalProductId}` - LoanProductsApiResource.retrieveLoanProductDetails
- **설명**: `LoanProductsApiResource`의 `retrieveLoanProductDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loanproducts/external-id/{externalProductId}` - LoanProductsApiResource.updateLoanProduct
- **설명**: `LoanProductsApiResource`의 `updateLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`

---

## [WCO] API명세서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

### WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/WorkingCapitalLoanCOBCatchUpApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanAccountLockApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/working-capital-loans/oldest-cob-closed` | `WorkingCapitalLoanCOBCatchUpApiResource.getOldestCOBProcessedLoan` |
| `POST` | `/v1/working-capital-loans/catch-up` | `WorkingCapitalLoanCOBCatchUpApiResource.executeLoanCOBCatchUp` |
| `GET` | `/v1/working-capital-loans/is-catch-up-running` | `WorkingCapitalLoanCOBCatchUpApiResource.isCatchUpRunning` |
| `GET` | `/v1/loans/locked` | `LoanAccountLockApiResource.retrieveLockedAccounts` |

#### `GET /v1/working-capital-loans/oldest-cob-closed` - WorkingCapitalLoanCOBCatchUpApiResource.getOldestCOBProcessedLoan
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `getOldestCOBProcessedLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/working-capital-loans/catch-up` - WorkingCapitalLoanCOBCatchUpApiResource.executeLoanCOBCatchUp
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `executeLoanCOBCatchUp` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/working-capital-loans/is-catch-up-running` - WorkingCapitalLoanCOBCatchUpApiResource.isCatchUpRunning
- **설명**: `WorkingCapitalLoanCOBCatchUpApiResource`의 `isCatchUpRunning` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/locked` - LoanAccountLockApiResource.retrieveLockedAccounts
- **설명**: `LoanAccountLockApiResource`의 `retrieveLockedAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `page` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/InternalLoanAccountLockApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/internal/loans/{loanId}/place-lock/{lockOwner}` | `InternalLoanAccountLockApiResource.placeLockOnLoanAccount` |
| `GET` | `/v1/jobs/names` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs` |
| `GET` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep` |
| `PUT` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.updateJobBusinessStepConfig` |
| `GET` | `/v1/jobs/{jobName}/available-steps` | `ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep` |

#### `POST /v1/internal/loans/{loanId}/place-lock/{lockOwner}` - InternalLoanAccountLockApiResource.placeLockOnLoanAccount
- **설명**: `InternalLoanAccountLockApiResource`의 `placeLockOnLoanAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `lockOwner` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/names` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessJobs` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.updateJobBusinessStepConfig
- **설명**: `ConfigureBusinessStepApiResource`의 `updateJobBusinessStepConfig` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/{jobName}/available-steps` - ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllAvailableBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/InternalLoanAccountLockApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanAccountLockApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/WorkingCapitalLoanCOBCatchUpApiResource.java`
