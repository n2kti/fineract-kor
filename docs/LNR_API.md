# [LNR] API명세서

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

## LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`

### 엔드포인트 목록
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

### `GET /v1/loans/{loanId}/transactions/template` - LoanTransactionsApiResource.retrieveTransactionTemplate
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions/template` - LoanTransactionsApiResource.retrieveTransactionTemplate
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.retrieveTransaction
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.retrieveTransactionByTransactionExternalId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByTransactionExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByLoanExternalIdAndTransactionId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.retrieveTransactionByLoanExternalIdAndTransactionExternalId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionByLoanExternalIdAndTransactionExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/transactions` - LoanTransactionsApiResource.retrieveTransactionsByLoanId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionsByLoanId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions` - LoanTransactionsApiResource.retrieveTransactionsByExternalLoanId
- **설명**: `LoanTransactionsApiResource`의 `retrieveTransactionsByExternalLoanId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/transactions` - LoanTransactionsApiResource.executeLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `executeLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/transactions` - LoanTransactionsApiResource.executeLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `executeLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/transactions/external-id/{externalTransactionId}` - LoanTransactionsApiResource.adjustLoanTransaction
- **설명**: `LoanTransactionsApiResource`의 `adjustLoanTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/{loanId}/transactions/{transactionId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/external-id/{loanExternalId}/transactions/{transactionId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/{loanId}/transactions/external-id/{transactionExternalId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/external-id/{loanExternalId}/transactions/external-id/{transactionExternalId}` - LoanTransactionsApiResource.undoWaiveCharge
- **설명**: `LoanTransactionsApiResource`의 `undoWaiveCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/transactions/reage-preview` - LoanTransactionsApiResource.previewReAgeSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAgeSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions/reage-preview` - LoanTransactionsApiResource.previewReAgeSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAgeSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/transactions/reamortization-preview` - LoanTransactionsApiResource.previewReAmortizationSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAmortizationSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/transactions/reamortization-preview` - LoanTransactionsApiResource.previewReAmortizationSchedule
- **설명**: `LoanTransactionsApiResource`의 `previewReAmortizationSchedule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider JAX-RS ApiResource`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`
