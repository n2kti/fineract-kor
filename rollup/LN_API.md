# [LN] API명세서 (여신관리)

> 소분류 3개 롤업.


---

## [LNA] API명세서

> 화면 2개 롤업(소분류 LNA, 대분류 LN - 대출 계좌 관리).

### LNA-001 대출 계좌 목록 및 상세

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

### LNA-002 대출 신청 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `PUT` | `/v1/loans/{loanId}/disbursements/{disbursementId}` | `LoanDisbursementDetailApiResource.updateDisbursementDate` |
| `PUT` | `/v1/loans/{loanId}/disbursements/editDisbursements` | `LoanDisbursementDetailApiResource.addAndDeleteDisbursementDetail` |
| `GET` | `/v1/loans/{loanId}/disbursements/{disbursementId}` | `LoanDisbursementDetailApiResource.retriveDetail` |

#### `PUT /v1/loans/{loanId}/disbursements/{disbursementId}` - LoanDisbursementDetailApiResource.updateDisbursementDate
- **설명**: `LoanDisbursementDetailApiResource`의 `updateDisbursementDate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `disbursementId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/disbursements/editDisbursements` - LoanDisbursementDetailApiResource.addAndDeleteDisbursementDetail
- **설명**: `LoanDisbursementDetailApiResource`의 `addAndDeleteDisbursementDetail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/disbursements/{disbursementId}` - LoanDisbursementDetailApiResource.retriveDetail
- **설명**: `LoanDisbursementDetailApiResource`의 `retriveDetail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `disbursementId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`

---

## [LNR] API명세서

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

### LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/transactions/template` | `LoanTransactionsApiResource.retrieveTransactionTemplate` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions/template` | `LoanTransactionsApiResource.retrieveTransactionTemplate` |
| `GET` | `/v1/loans/{loanId}/transactions/{transactionId}` | `LoanTransactionsApiResource.retrieveTransaction` |
| `GET` | `/v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` | `LoanTransactionsApiResource.retrieveTransactionByTransactionExternalId` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` | `LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionId` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` | `LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionExternalId` |
| `GET` | `/v1/loans/{loanId}/transactions` | `LoanTransactionsApiResource.retrieveTransactionsByLoanId` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions` | `LoanTransactionsApiResource.retrieveTransactionsByExternalLoanId` |
| `POST` | `/v1/loans/{loanId}/transactions` | `LoanTransactionsApiResource.executeLoanTransaction` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/transactions` | `LoanTransactionsApiResource.executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions/{transactionId}` | `LoanTransactionsApiResource.adjustLoanTransaction` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` | `LoanTransactionsApiResource.adjustLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` | `LoanTransactionsApiResource.adjustLoanTransaction` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` | `LoanTransactionsApiResource.adjustLoanTransaction` |
| `PUT` | `/v1/loans/{loanId}/transactions/{transactionId}` | `LoanTransactionsApiResource.undoWaiveCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` | `LoanTransactionsApiResource.undoWaiveCharge` |
| `PUT` | `/v1/loans/{loanId}/transactions/external-id/{transactionExternalId}` | `LoanTransactionsApiResource.undoWaiveCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/transactions/external-id/{transactionExternalId}` | `LoanTransactionsApiResource.undoWaiveCharge` |
| `GET` | `/v1/loans/{loanId}/transactions/reage-preview` | `LoanTransactionsApiResource.previewReAgeSchedule` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions/reage-preview` | `LoanTransactionsApiResource.previewReAgeSchedule` |
| `GET` | `/v1/loans/{loanId}/transactions/reamortization-preview` | `LoanTransactionsApiResource.previewReAmortizationSchedule` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/transactions/reamortization-preview` | `LoanTransactionsApiResource.previewReAmortizationSchedule` |

#### `GET /v1/loans/{loanId}/transactions/template` - LoanTransactionsApiResource.retrieveTransactionTemplate
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions/template` - LoanTransactionsApiResource.retrieveTransactionTemplate
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.retrieveTransaction
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.retrieveTransactionByTransactionExternalId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByTransactionExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByLoanExternalIdAndTransactionId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionExternalId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByLoanExternalIdAndTransactionExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/transactions` - LoanTransactionsApiResource.retrieveTransactionsByLoanId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionsByLoanId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions` - LoanTransactionsApiResource.retrieveTransactionsByExternalLoanId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionsByExternalLoanId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/transactions` - LoanTransactionsApiResource.executeLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `executeLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/transactions` - LoanTransactionsApiResource.executeLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `executeLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/transactions/external-id/{transactionExternalId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/transactions/external-id/{transactionExternalId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/transactions/reage-preview` - LoanTransactionsApiResource.previewReAgeSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAgeSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions/reage-preview` - LoanTransactionsApiResource.previewReAgeSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAgeSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/transactions/reamortization-preview` - LoanTransactionsApiResource.previewReAmortizationSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAmortizationSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/transactions/reamortization-preview` - LoanTransactionsApiResource.previewReAmortizationSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAmortizationSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider JAX-RS ApiResource`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`

---

## [LNO] API명세서

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

### LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/api/GuarantorsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/CollateralManagementApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/guarantors/template` | `GuarantorsApiResource.newGuarantorTemplate` |
| `GET` | `/v1/loans/{loanId}/guarantors` | `GuarantorsApiResource.retrieveGuarantorDetails` |
| `GET` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.retrieveGuarantorDetails` |
| `POST` | `/v1/loans/{loanId}/guarantors` | `GuarantorsApiResource.createGuarantor` |
| `PUT` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.updateGuarantor` |
| `DELETE` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.deleteGuarantor` |
| `GET` | `/v1/loans/{loanId}/guarantors/accounts/template` | `GuarantorsApiResource.accountsTemplate` |
| `GET` | `/v1/loans/{loanId}/guarantors/downloadtemplate` | `GuarantorsApiResource.getGuarantorTemplate` |
| `POST` | `/v1/loans/{loanId}/guarantors/uploadtemplate` | `GuarantorsApiResource.postGuarantorTemplate` |
| `POST` | `/v1/collateral-management` | `CollateralManagementApiResource.createCollateral` |
| `GET` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.getCollateral` |
| `GET` | `/v1/collateral-management` | `CollateralManagementApiResource.getAllCollaterals` |
| `GET` | `/v1/collateral-management/template` | `CollateralManagementApiResource.getCollateralTemplate` |
| `PUT` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.updateCollateral` |
| `DELETE` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.deleteCollateral` |

#### `GET /v1/loans/{loanId}/guarantors/template` - GuarantorsApiResource.newGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `newGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/guarantors` - GuarantorsApiResource.retrieveGuarantorDetails
- **설명**: `GuarantorsApiResource`의 `retrieveGuarantorDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.retrieveGuarantorDetails
- **설명**: `GuarantorsApiResource`의 `retrieveGuarantorDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/guarantors` - GuarantorsApiResource.createGuarantor
- **설명**: `GuarantorsApiResource`의 `createGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.updateGuarantor
- **설명**: `GuarantorsApiResource`의 `updateGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.deleteGuarantor
- **설명**: `GuarantorsApiResource`의 `deleteGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorFundingId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/guarantors/accounts/template` - GuarantorsApiResource.accountsTemplate
- **설명**: `GuarantorsApiResource`의 `accountsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (QueryParam): `Long` 타입 식별자/필터
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/guarantors/downloadtemplate` - GuarantorsApiResource.getGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `getGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/guarantors/uploadtemplate` - GuarantorsApiResource.postGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `postGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/collateral-management` - CollateralManagementApiResource.createCollateral
- **설명**: `CollateralManagementApiResource`의 `createCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.getCollateral
- **설명**: `CollateralManagementApiResource`의 `getCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/collateral-management` - CollateralManagementApiResource.getAllCollaterals
- **설명**: `CollateralManagementApiResource`의 `getAllCollaterals` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/collateral-management/template` - CollateralManagementApiResource.getCollateralTemplate
- **설명**: `CollateralManagementApiResource`의 `getCollateralTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.updateCollateral
- **설명**: `CollateralManagementApiResource`의 `updateCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.deleteCollateral
- **설명**: `CollateralManagementApiResource`의 `deleteCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/BulkLoansApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/pointintime/LoansPointInTimeApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/charges` | `LoanChargesApiResource.retrieveAllLoanCharges` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges` | `LoanChargesApiResource.retrieveAllLoanCharges` |
| `GET` | `/v1/loans/{loanId}/charges/template` | `LoanChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/template` | `LoanChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.executeLoanCharge` |
| `PUT` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.updateLoanCharge` |
| `DELETE` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `GET` | `/v1/loans/loanreassignment/template` | `BulkLoansApiResource.loanReassignmentTemplate` |
| `POST` | `/v1/loans/loanreassignment` | `BulkLoansApiResource.loanReassignment` |
| `GET` | `/v1/loans/at-date/{loanId}` | `LoansPointInTimeApiResource.retrieveLoanPointInTime` |
| `GET` | `/v1/loans/at-date/external-id/{loanExternalId}` | `LoansPointInTimeApiResource.retrieveLoanPointInTimeByExternalId` |
| `POST` | `/v1/loans/at-date/search` | `LoansPointInTimeApiResource.retrieveLoansPointInTime` |
| `POST` | `/v1/loans/at-date/search/external-id` | `LoansPointInTimeApiResource.retrieveLoansPointInTimeByExternalIds` |

#### `GET /v1/loans/{loanId}/charges` - LoanChargesApiResource.retrieveAllLoanCharges
- **설명**: `LoanChargesApiResource`의 `retrieveAllLoanCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/charges` - LoanChargesApiResource.retrieveAllLoanCharges
- **설명**: `LoanChargesApiResource`의 `retrieveAllLoanCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/charges/template` - LoanChargesApiResource.retrieveTemplate
- **설명**: `LoanChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/charges/template` - LoanChargesApiResource.retrieveTemplate
- **설명**: `LoanChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/charges` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/charges` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/loanreassignment/template` - BulkLoansApiResource.loanReassignmentTemplate
- **설명**: `BulkLoansApiResource`의 `loanReassignmentTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/loanreassignment` - BulkLoansApiResource.loanReassignment
- **설명**: `BulkLoansApiResource`의 `loanReassignment` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/at-date/{loanId}` - LoansPointInTimeApiResource.retrieveLoanPointInTime
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoanPointInTime` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/at-date/external-id/{loanExternalId}` - LoansPointInTimeApiResource.retrieveLoanPointInTimeByExternalId
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoanPointInTimeByExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/at-date/search` - LoansPointInTimeApiResource.retrieveLoansPointInTime
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoansPointInTime` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/at-date/search/external-id` - LoansPointInTimeApiResource.retrieveLoansPointInTimeByExternalIds
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoansPointInTimeByExternalIds` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/CollateralManagementApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/BulkLoansApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/pointintime/LoansPointInTimeApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/api/GuarantorsApiResource.java`
