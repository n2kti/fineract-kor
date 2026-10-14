# [SVR] API명세서

> 화면 1개 롤업(소분류 SVR, 대분류 SV - 정기적금 계좌).

## SVR-001 정기적금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositAccountsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositAccountTransactionsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/recurringdepositaccounts/template` | `RecurringDepositAccountsApiResource.template` |
| `GET` | `/v1/recurringdepositaccounts` | `RecurringDepositAccountsApiResource.retrieveAll` |
| `POST` | `/v1/recurringdepositaccounts` | `RecurringDepositAccountsApiResource.submitApplication` |
| `GET` | `/v1/recurringdepositaccounts/{accountId}` | `RecurringDepositAccountsApiResource.retrieveOne` |
| `PUT` | `/v1/recurringdepositaccounts/{accountId}` | `RecurringDepositAccountsApiResource.update` |
| `POST` | `/v1/recurringdepositaccounts/{accountId}` | `RecurringDepositAccountsApiResource.handleCommands` |
| `DELETE` | `/v1/recurringdepositaccounts/{accountId}` | `RecurringDepositAccountsApiResource.delete` |
| `GET` | `/v1/recurringdepositaccounts/{accountId}/template` | `RecurringDepositAccountsApiResource.accountClosureTemplate` |
| `GET` | `/v1/recurringdepositaccounts/downloadtemplate` | `RecurringDepositAccountsApiResource.getRecurringDepositTemplate` |
| `POST` | `/v1/recurringdepositaccounts/uploadtemplate` | `RecurringDepositAccountsApiResource.postRecurringDepositTemplate` |
| `GET` | `/v1/recurringdepositaccounts/transactions/downloadtemplate` | `RecurringDepositAccountsApiResource.getRecurringDepositTransactionTemplate` |
| `POST` | `/v1/recurringdepositaccounts/transactions/uploadtemplate` | `RecurringDepositAccountsApiResource.postRecurringDepositTransactionsTemplate` |
| `GET` | `/v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/template` | `RecurringDepositAccountTransactionsApiResource.retrieveTemplate` |
| `GET` | `/v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/{transactionId}` | `RecurringDepositAccountTransactionsApiResource.retrieveOne` |
| `POST` | `/v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions` | `RecurringDepositAccountTransactionsApiResource.transaction` |
| `POST` | `/v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/{transactionId}` | `RecurringDepositAccountTransactionsApiResource.handleTransactionCommands` |

### `GET /v1/recurringdepositaccounts/template` - RecurringDepositAccountsApiResource.template
- **설명**: `RecurringDepositAccountsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts` - RecurringDepositAccountsApiResource.retrieveAll
- **설명**: `RecurringDepositAccountsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts` - RecurringDepositAccountsApiResource.submitApplication
- **설명**: `RecurringDepositAccountsApiResource`의 `submitApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/{accountId}` - RecurringDepositAccountsApiResource.retrieveOne
- **설명**: `RecurringDepositAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/recurringdepositaccounts/{accountId}` - RecurringDepositAccountsApiResource.update
- **설명**: `RecurringDepositAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts/{accountId}` - RecurringDepositAccountsApiResource.handleCommands
- **설명**: `RecurringDepositAccountsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/recurringdepositaccounts/{accountId}` - RecurringDepositAccountsApiResource.delete
- **설명**: `RecurringDepositAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/{accountId}/template` - RecurringDepositAccountsApiResource.accountClosureTemplate
- **설명**: `RecurringDepositAccountsApiResource`의 `accountClosureTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/downloadtemplate` - RecurringDepositAccountsApiResource.getRecurringDepositTemplate
- **설명**: `RecurringDepositAccountsApiResource`의 `getRecurringDepositTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts/uploadtemplate` - RecurringDepositAccountsApiResource.postRecurringDepositTemplate
- **설명**: `RecurringDepositAccountsApiResource`의 `postRecurringDepositTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/transactions/downloadtemplate` - RecurringDepositAccountsApiResource.getRecurringDepositTransactionTemplate
- **설명**: `RecurringDepositAccountsApiResource`의 `getRecurringDepositTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts/transactions/uploadtemplate` - RecurringDepositAccountsApiResource.postRecurringDepositTransactionsTemplate
- **설명**: `RecurringDepositAccountsApiResource`의 `postRecurringDepositTransactionsTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/template` - RecurringDepositAccountTransactionsApiResource.retrieveTemplate
- **설명**: `RecurringDepositAccountTransactionsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/{transactionId}` - RecurringDepositAccountTransactionsApiResource.retrieveOne
- **설명**: `RecurringDepositAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions` - RecurringDepositAccountTransactionsApiResource.transaction
- **설명**: `RecurringDepositAccountTransactionsApiResource`의 `transaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositaccounts/{recurringDepositAccountId}/transactions/{transactionId}` - RecurringDepositAccountTransactionsApiResource.handleTransactionCommands
- **설명**: `RecurringDepositAccountTransactionsApiResource`의 `handleTransactionCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositAccountTransactionsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositAccountsApiResource.java`
