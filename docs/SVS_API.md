# [SVS] API명세서

> 화면 1개 롤업(소분류 SVS, 대분류 SV - 주식 계좌).

## SVS-001 주식 계좌 및 배당 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/accounts/api/AccountsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/accounts/{type}/template` | `AccountsApiResource.template` |
| `GET` | `/v1/accounts/{type}/{accountId}` | `AccountsApiResource.retrieveAccount` |
| `GET` | `/v1/accounts/{type}` | `AccountsApiResource.retrieveAllAccounts` |
| `POST` | `/v1/accounts/{type}` | `AccountsApiResource.createAccount` |
| `POST` | `/v1/accounts/{type}/{accountId}` | `AccountsApiResource.handleCommands` |
| `PUT` | `/v1/accounts/{type}/{accountId}` | `AccountsApiResource.updateAccount` |
| `GET` | `/v1/accounts/{type}/downloadtemplate` | `AccountsApiResource.getSharedAccountsTemplate` |
| `POST` | `/v1/accounts/{type}/uploadtemplate` | `AccountsApiResource.postSharedAccountsTemplate` |

### `GET /v1/accounts/{type}/template` - AccountsApiResource.template
- **설명**: `AccountsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounts/{type}/{accountId}` - AccountsApiResource.retrieveAccount
- **설명**: `AccountsApiResource`의 `retrieveAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounts/{type}` - AccountsApiResource.retrieveAllAccounts
- **설명**: `AccountsApiResource`의 `retrieveAllAccounts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounts/{type}` - AccountsApiResource.createAccount
- **설명**: `AccountsApiResource`의 `createAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounts/{type}/{accountId}` - AccountsApiResource.handleCommands
- **설명**: `AccountsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/accounts/{type}/{accountId}` - AccountsApiResource.updateAccount
- **설명**: `AccountsApiResource`의 `updateAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounts/{type}/downloadtemplate` - AccountsApiResource.getSharedAccountsTemplate
- **설명**: `AccountsApiResource`의 `getSharedAccountsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounts/{type}/uploadtemplate` - AccountsApiResource.postSharedAccountsTemplate
- **설명**: `AccountsApiResource`의 `postSharedAccountsTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/accounts/api/AccountsApiResource.java`
