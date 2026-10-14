# [OGC] API명세서

> 화면 1개 롤업(소분류 OGC, 대분류 OG - 통화 및 조직 공통설정).

## OGC-001 통화·자금원·계좌체계

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#currenciesapire, fineract-provider/src/main/java/org/apache/fineract/portfolio/fund/api/FundsApiResource.java, fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#paymenttypesapi, fineract-provider/src/main/java/org/apache/fineract/infrastructure/accountnumberformat/api/AccountNumberFormatsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/currencies` | `CurrenciesApiResource.retrieveCurrencies` |
| `PUT` | `/v1/currencies` | `CurrenciesApiResource.updateCurrencies` |
| `GET` | `/v1/funds` | `FundsApiResource.retrieveFunds` |
| `POST` | `/v1/funds` | `FundsApiResource.createFund` |
| `GET` | `/v1/funds/{fundId}` | `FundsApiResource.retrieveFund` |
| `PUT` | `/v1/funds/{fundId}` | `FundsApiResource.updateFund` |
| `GET` | `/v1/paymenttypes` | `PaymentTypeApiResource.getAllPaymentTypes` |
| `POST` | `/v1/paymenttypes` | `PaymentTypeApiResource.createPaymentType` |
| `GET` | `/v1/paymenttypes/{paymentTypeId}` | `PaymentTypeApiResource.getPaymentTypeById` |
| `PUT` | `/v1/paymenttypes/{paymentTypeId}` | `PaymentTypeApiResource.updatePaymentType` |
| `DELETE` | `/v1/paymenttypes/{paymentTypeId}` | `PaymentTypeApiResource.deleteCode` |
| `GET` | `/v1/template/template` | `AccountNumberFormatsApiResource.retrieveTemplate` |
| `GET` | `/v1/template` | `AccountNumberFormatsApiResource.retrieveAll` |
| `GET` | `/v1/template/{accountNumberFormatId}` | `AccountNumberFormatsApiResource.retrieveOne` |
| `POST` | `/v1/template` | `AccountNumberFormatsApiResource.create` |
| `PUT` | `/v1/template/{accountNumberFormatId}` | `AccountNumberFormatsApiResource.update` |
| `DELETE` | `/v1/template/{accountNumberFormatId}` | `AccountNumberFormatsApiResource.delete` |

### `GET /v1/currencies` - CurrenciesApiResource.retrieveCurrencies
- **설명**: `CurrenciesApiResource`의 `retrieveCurrencies` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/currencies` - CurrenciesApiResource.updateCurrencies
- **설명**: `CurrenciesApiResource`의 `updateCurrencies` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/funds` - FundsApiResource.retrieveFunds
- **설명**: `FundsApiResource`의 `retrieveFunds` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/funds` - FundsApiResource.createFund
- **설명**: `FundsApiResource`의 `createFund` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/funds/{fundId}` - FundsApiResource.retrieveFund
- **설명**: `FundsApiResource`의 `retrieveFund` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/funds/{fundId}` - FundsApiResource.updateFund
- **설명**: `FundsApiResource`의 `updateFund` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/paymenttypes` - PaymentTypeApiResource.getAllPaymentTypes
- **설명**: `PaymentTypeApiResource`의 `getAllPaymentTypes` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/paymenttypes` - PaymentTypeApiResource.createPaymentType
- **설명**: `PaymentTypeApiResource`의 `createPaymentType` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/paymenttypes/{paymentTypeId}` - PaymentTypeApiResource.getPaymentTypeById
- **설명**: `PaymentTypeApiResource`의 `getPaymentTypeById` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `paymentTypeId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/paymenttypes/{paymentTypeId}` - PaymentTypeApiResource.updatePaymentType
- **설명**: `PaymentTypeApiResource`의 `updatePaymentType` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `paymentTypeId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/paymenttypes/{paymentTypeId}` - PaymentTypeApiResource.deleteCode
- **설명**: `PaymentTypeApiResource`의 `deleteCode` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `paymentTypeId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/template/template` - AccountNumberFormatsApiResource.retrieveTemplate
- **설명**: `AccountNumberFormatsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/template` - AccountNumberFormatsApiResource.retrieveAll
- **설명**: `AccountNumberFormatsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/template/{accountNumberFormatId}` - AccountNumberFormatsApiResource.retrieveOne
- **설명**: `AccountNumberFormatsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/template` - AccountNumberFormatsApiResource.create
- **설명**: `AccountNumberFormatsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/template/{accountNumberFormatId}` - AccountNumberFormatsApiResource.update
- **설명**: `AccountNumberFormatsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/template/{accountNumberFormatId}` - AccountNumberFormatsApiResource.delete
- **설명**: `AccountNumberFormatsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/accountnumberformat/api/AccountNumberFormatsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/fund/api/FundsApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
