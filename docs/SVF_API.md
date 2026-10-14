# [SVF] API명세서

> 화면 1개 롤업(소분류 SVF, 대분류 SV - 정기예금 계좌).

## SVF-001 정기예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositAccountsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositAccountTransactionsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/fixeddepositaccounts/template` | `FixedDepositAccountsApiResource.template` |
| `GET` | `/v1/fixeddepositaccounts` | `FixedDepositAccountsApiResource.retrieveAll` |
| `POST` | `/v1/fixeddepositaccounts` | `FixedDepositAccountsApiResource.submitApplication` |
| `GET` | `/v1/fixeddepositaccounts/{accountId}` | `FixedDepositAccountsApiResource.retrieveOne` |
| `GET` | `/v1/fixeddepositaccounts/calculate-fd-interest` | `FixedDepositAccountsApiResource.calculateFixedDepositInterest` |
| `PUT` | `/v1/fixeddepositaccounts/{accountId}` | `FixedDepositAccountsApiResource.update` |
| `POST` | `/v1/fixeddepositaccounts/{accountId}` | `FixedDepositAccountsApiResource.handleCommands` |
| `DELETE` | `/v1/fixeddepositaccounts/{accountId}` | `FixedDepositAccountsApiResource.delete` |
| `GET` | `/v1/fixeddepositaccounts/{accountId}/template` | `FixedDepositAccountsApiResource.accountClosureTemplate` |
| `GET` | `/v1/fixeddepositaccounts/downloadtemplate` | `FixedDepositAccountsApiResource.getFixedDepositTemplate` |
| `POST` | `/v1/fixeddepositaccounts/uploadtemplate` | `FixedDepositAccountsApiResource.postFixedDepositTemplate` |
| `GET` | `/v1/fixeddepositaccounts/transaction/downloadtemplate` | `FixedDepositAccountsApiResource.getFixedDepositTransactionTemplate` |
| `POST` | `/v1/fixeddepositaccounts/transaction/uploadtemplate` | `FixedDepositAccountsApiResource.postFixedDepositTransactionTemplate` |
| `GET` | `/v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/template` | `FixedDepositAccountTransactionsApiResource.retrieveTemplate` |
| `GET` | `/v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions` | `FixedDepositAccountTransactionsApiResource.retrieveAll` |
| `GET` | `/v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/{transactionId}` | `FixedDepositAccountTransactionsApiResource.retrieveOne` |
| `POST` | `/v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions` | `FixedDepositAccountTransactionsApiResource.transaction` |
| `POST` | `/v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/{transactionId}` | `FixedDepositAccountTransactionsApiResource.adjustTransaction` |

### `GET /v1/fixeddepositaccounts/template` - FixedDepositAccountsApiResource.template
- **설명**: `FixedDepositAccountsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts` - FixedDepositAccountsApiResource.retrieveAll
- **설명**: `FixedDepositAccountsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts` - FixedDepositAccountsApiResource.submitApplication
- **설명**: `FixedDepositAccountsApiResource`의 `submitApplication` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/{accountId}` - FixedDepositAccountsApiResource.retrieveOne
- **설명**: `FixedDepositAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/calculate-fd-interest` - FixedDepositAccountsApiResource.calculateFixedDepositInterest
- **설명**: `FixedDepositAccountsApiResource`의 `calculateFixedDepositInterest` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/fixeddepositaccounts/{accountId}` - FixedDepositAccountsApiResource.update
- **설명**: `FixedDepositAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts/{accountId}` - FixedDepositAccountsApiResource.handleCommands
- **설명**: `FixedDepositAccountsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/fixeddepositaccounts/{accountId}` - FixedDepositAccountsApiResource.delete
- **설명**: `FixedDepositAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/{accountId}/template` - FixedDepositAccountsApiResource.accountClosureTemplate
- **설명**: `FixedDepositAccountsApiResource`의 `accountClosureTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/downloadtemplate` - FixedDepositAccountsApiResource.getFixedDepositTemplate
- **설명**: `FixedDepositAccountsApiResource`의 `getFixedDepositTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts/uploadtemplate` - FixedDepositAccountsApiResource.postFixedDepositTemplate
- **설명**: `FixedDepositAccountsApiResource`의 `postFixedDepositTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/transaction/downloadtemplate` - FixedDepositAccountsApiResource.getFixedDepositTransactionTemplate
- **설명**: `FixedDepositAccountsApiResource`의 `getFixedDepositTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts/transaction/uploadtemplate` - FixedDepositAccountsApiResource.postFixedDepositTransactionTemplate
- **설명**: `FixedDepositAccountsApiResource`의 `postFixedDepositTransactionTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/template` - FixedDepositAccountTransactionsApiResource.retrieveTemplate
- **설명**: `FixedDepositAccountTransactionsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `fixedDepositAccountId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions` - FixedDepositAccountTransactionsApiResource.retrieveAll
- **설명**: `FixedDepositAccountTransactionsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `fixedDepositAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/{transactionId}` - FixedDepositAccountTransactionsApiResource.retrieveOne
- **설명**: `FixedDepositAccountTransactionsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `fixedDepositAccountId` (PathParam): `Long` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions` - FixedDepositAccountTransactionsApiResource.transaction
- **설명**: `FixedDepositAccountTransactionsApiResource`의 `transaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `fixedDepositAccountId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositaccounts/{fixedDepositAccountId}/transactions/{transactionId}` - FixedDepositAccountTransactionsApiResource.adjustTransaction
- **설명**: `FixedDepositAccountTransactionsApiResource`의 `adjustTransaction` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `fixedDepositAccountId` (PathParam): `Long` 타입 식별자/필터
  - `transactionId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositAccountTransactionsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositAccountsApiResource.java`
