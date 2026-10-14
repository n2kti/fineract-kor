# [SVA] API명세서

> 화면 2개 롤업(소분류 SVA, 대분류 SV - 보통예금 계좌).

## SVA-001 보통예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/savingsaccounts/template` | `SavingsAccountsApiResource.template` |
| `GET` | `/v1/savingsaccounts` | `SavingsAccountsApiResource.retrieveAll` |
| `POST` | `/v1/savingsaccounts` | `SavingsAccountsApiResource.submitApplication` |
| `POST` | `/v1/savingsaccounts/gsim` | `SavingsAccountsApiResource.submitGSIMApplication` |
| `GET` | `/v1/savingsaccounts/{accountId}` | `SavingsAccountsApiResource.retrieveOne` |
| `GET` | `/v1/savingsaccounts/external-id/{externalId}` | `SavingsAccountsApiResource.retrieveOne` |
| `PUT` | `/v1/savingsaccounts/{accountId}` | `SavingsAccountsApiResource.update` |
| `PUT` | `/v1/savingsaccounts/external-id/{externalId}` | `SavingsAccountsApiResource.update` |
| `PUT` | `/v1/savingsaccounts/gsim/{parentAccountId}` | `SavingsAccountsApiResource.updateGsim` |
| `POST` | `/v1/savingsaccounts/gsimcommands/{parentAccountId}` | `SavingsAccountsApiResource.handleGSIMCommands` |
| `POST` | `/v1/savingsaccounts/{accountId}` | `SavingsAccountsApiResource.handleCommands` |
| `POST` | `/v1/savingsaccounts/external-id/{externalId}` | `SavingsAccountsApiResource.handleCommands` |
| `DELETE` | `/v1/savingsaccounts/{accountId}` | `SavingsAccountsApiResource.delete` |
| `DELETE` | `/v1/savingsaccounts/external-id/{externalId}` | `SavingsAccountsApiResource.delete` |
| `GET` | `/v1/savingsaccounts/downloadtemplate` | `SavingsAccountsApiResource.getSavingsTemplate` |
| `POST` | `/v1/savingsaccounts/uploadtemplate` | `SavingsAccountsApiResource.postSavingsTemplate` |
| `GET` | `/v1/savingsaccounts/transactions/downloadtemplate` | `SavingsAccountsApiResource.getSavingsTransactionTemplate` |
| `POST` | `/v1/savingsaccounts/transactions/uploadtemplate` | `SavingsAccountsApiResource.postSavingsTransactionTemplate` |

### `GET /v1/savingsaccounts/template` - SavingsAccountsApiResource.template
- **설명**: `SavingsAccountsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts` - SavingsAccountsApiResource.retrieveAll
- **설명**: `SavingsAccountsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `underHierarchy` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts` - SavingsAccountsApiResource.submitApplication
- **설명**: `SavingsAccountsApiResource`의 `submitApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/gsim` - SavingsAccountsApiResource.submitGSIMApplication
- **설명**: `SavingsAccountsApiResource`의 `submitGSIMApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{accountId}` - SavingsAccountsApiResource.retrieveOne
- **설명**: `SavingsAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountId` (PathParam): `Long` 타입 식별자/필터
  - `staffInSelectedOfficeOnly` (QueryParam): `boolean` 타입 식별자/필터
  - `chargeStatus` (QueryParam): `String` 타입 식별자/필터
  - `associations` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/external-id/{externalId}` - SavingsAccountsApiResource.retrieveOne
- **설명**: `SavingsAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
  - `staffInSelectedOfficeOnly` (QueryParam): `boolean` 타입 식별자/필터
  - `chargeStatus` (QueryParam): `String` 타입 식별자/필터
  - `associations` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/savingsaccounts/{accountId}` - SavingsAccountsApiResource.update
- **설명**: `SavingsAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/savingsaccounts/external-id/{externalId}` - SavingsAccountsApiResource.update
- **설명**: `SavingsAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/savingsaccounts/gsim/{parentAccountId}` - SavingsAccountsApiResource.updateGsim
- **설명**: `SavingsAccountsApiResource`의 `updateGsim` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `parentAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/gsimcommands/{parentAccountId}` - SavingsAccountsApiResource.handleGSIMCommands
- **설명**: `SavingsAccountsApiResource`의 `handleGSIMCommands` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `parentAccountId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{accountId}` - SavingsAccountsApiResource.handleCommands
- **설명**: `SavingsAccountsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/external-id/{externalId}` - SavingsAccountsApiResource.handleCommands
- **설명**: `SavingsAccountsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/savingsaccounts/{accountId}` - SavingsAccountsApiResource.delete
- **설명**: `SavingsAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/savingsaccounts/external-id/{externalId}` - SavingsAccountsApiResource.delete
- **설명**: `SavingsAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/downloadtemplate` - SavingsAccountsApiResource.getSavingsTemplate
- **설명**: `SavingsAccountsApiResource`의 `getSavingsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/uploadtemplate` - SavingsAccountsApiResource.postSavingsTemplate
- **설명**: `SavingsAccountsApiResource`의 `postSavingsTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/transactions/downloadtemplate` - SavingsAccountsApiResource.getSavingsTransactionTemplate
- **설명**: `SavingsAccountsApiResource`의 `getSavingsTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/transactions/uploadtemplate` - SavingsAccountsApiResource.postSavingsTransactionTemplate
- **설명**: `SavingsAccountsApiResource`의 `postSavingsTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## SVA-002 예금 수수료 및 거래 이력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountTransactionsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountChargesApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/savingsaccounts/{savingsId}/transactions/template` | `SavingsAccountTransactionsApiResource.retrieveTemplate` |
| `GET` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/template` | `SavingsAccountTransactionsApiResource.retrieveTemplate` |
| `GET` | `/v1/savingsaccounts/{savingsId}/transactions/{transactionId}` | `SavingsAccountTransactionsApiResource.retrieveOne` |
| `GET` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/{transactionId}` | `SavingsAccountTransactionsApiResource.retrieveOne` |
| `GET` | `/v1/savingsaccounts/{savingsId}/transactions/external-id/{transactionExternalId}` | `SavingsAccountTransactionsApiResource.retrieveOne` |
| `GET` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/external-id/{transactionExternalId}` | `SavingsAccountTransactionsApiResource.retrieveOne` |
| `GET` | `/v1/savingsaccounts/{savingsId}/transactions/search` | `SavingsAccountTransactionsApiResource.searchTransactions` |
| `GET` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/search` | `SavingsAccountTransactionsApiResource.searchTransactions` |
| `POST` | `/v1/savingsaccounts/{savingsId}/transactions/query` | `SavingsAccountTransactionsApiResource.advancedQuery` |
| `POST` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/query` | `SavingsAccountTransactionsApiResource.advancedQuery` |
| `POST` | `/v1/savingsaccounts/{savingsId}/transactions` | `SavingsAccountTransactionsApiResource.transaction` |
| `POST` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions` | `SavingsAccountTransactionsApiResource.transaction` |
| `POST` | `/v1/savingsaccounts/{savingsId}/transactions/{transactionId}` | `SavingsAccountTransactionsApiResource.adjustTransaction` |
| `POST` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/{transactionId}` | `SavingsAccountTransactionsApiResource.adjustTransaction` |
| `POST` | `/v1/savingsaccounts/{savingsId}/transactions/external-id/{transactionExternalId}` | `SavingsAccountTransactionsApiResource.adjustTransaction` |
| `POST` | `/v1/savingsaccounts/external-id/{savingsExternalId}/transactions/external-id/{transactionExternalId}` | `SavingsAccountTransactionsApiResource.adjustTransaction` |
| `GET` | `/v1/savingsaccounts/{savingsAccountId}/charges` | `SavingsAccountChargesApiResource.retrieveAllSavingsAccountCharges` |
| `GET` | `/v1/savingsaccounts/{savingsAccountId}/charges/template` | `SavingsAccountChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` | `SavingsAccountChargesApiResource.retrieveSavingsAccountCharge` |
| `POST` | `/v1/savingsaccounts/{savingsAccountId}/charges` | `SavingsAccountChargesApiResource.addSavingsAccountCharge` |
| `PUT` | `/v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` | `SavingsAccountChargesApiResource.updateSavingsAccountCharge` |
| `POST` | `/v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` | `SavingsAccountChargesApiResource.payOrWaiveSavingsAccountCharge` |
| `DELETE` | `/v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` | `SavingsAccountChargesApiResource.deleteSavingsAccountCharge` |

### `GET /v1/savingsaccounts/{savingsId}/transactions/template` - SavingsAccountTransactionsApiResource.retrieveTemplate
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/template` - SavingsAccountTransactionsApiResource.retrieveTemplate
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsId}/transactions/{transactionId}` - SavingsAccountTransactionsApiResource.retrieveOne
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/{transactionId}` - SavingsAccountTransactionsApiResource.retrieveOne
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsId}/transactions/external-id/{transactionExternalId}` - SavingsAccountTransactionsApiResource.retrieveOne
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `transactionExternalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/external-id/{transactionExternalId}` - SavingsAccountTransactionsApiResource.retrieveOne
- **설명**: `SavingsAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
  - `transactionExternalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsId}/transactions/search` - SavingsAccountTransactionsApiResource.searchTransactions
- **설명**: `SavingsAccountTransactionsApiResource`의 `searchTransactions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/search` - SavingsAccountTransactionsApiResource.searchTransactions
- **설명**: `SavingsAccountTransactionsApiResource`의 `searchTransactions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsId}/transactions/query` - SavingsAccountTransactionsApiResource.advancedQuery
- **설명**: `SavingsAccountTransactionsApiResource`의 `advancedQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/query` - SavingsAccountTransactionsApiResource.advancedQuery
- **설명**: `SavingsAccountTransactionsApiResource`의 `advancedQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsId}/transactions` - SavingsAccountTransactionsApiResource.transaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `transaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/external-id/{savingsExternalId}/transactions` - SavingsAccountTransactionsApiResource.transaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `transaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsId}/transactions/{transactionId}` - SavingsAccountTransactionsApiResource.adjustTransaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `adjustTransaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/{transactionId}` - SavingsAccountTransactionsApiResource.adjustTransaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `adjustTransaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsId}/transactions/external-id/{transactionExternalId}` - SavingsAccountTransactionsApiResource.adjustTransaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `adjustTransaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsId` (PathParam): `Long` 타입 식별자/필터
  - `transactionExternalId` (PathParam): `String` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/external-id/{savingsExternalId}/transactions/external-id/{transactionExternalId}` - SavingsAccountTransactionsApiResource.adjustTransaction
- **설명**: `SavingsAccountTransactionsApiResource`의 `adjustTransaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `savingsExternalId` (PathParam): `String` 타입 식별자/필터
  - `transactionExternalId` (PathParam): `String` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsAccountId}/charges` - SavingsAccountChargesApiResource.retrieveAllSavingsAccountCharges
- **설명**: `SavingsAccountChargesApiResource`의 `retrieveAllSavingsAccountCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsAccountId}/charges/template` - SavingsAccountChargesApiResource.retrieveTemplate
- **설명**: `SavingsAccountChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` - SavingsAccountChargesApiResource.retrieveSavingsAccountCharge
- **설명**: `SavingsAccountChargesApiResource`의 `retrieveSavingsAccountCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsAccountId}/charges` - SavingsAccountChargesApiResource.addSavingsAccountCharge
- **설명**: `SavingsAccountChargesApiResource`의 `addSavingsAccountCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` - SavingsAccountChargesApiResource.updateSavingsAccountCharge
- **설명**: `SavingsAccountChargesApiResource`의 `updateSavingsAccountCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` - SavingsAccountChargesApiResource.payOrWaiveSavingsAccountCharge
- **설명**: `SavingsAccountChargesApiResource`의 `payOrWaiveSavingsAccountCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/savingsaccounts/{savingsAccountId}/charges/{savingsAccountChargeId}` - SavingsAccountChargesApiResource.deleteSavingsAccountCharge
- **설명**: `SavingsAccountChargesApiResource`의 `deleteSavingsAccountCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountChargesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountTransactionsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsAccountsApiResource.java`
