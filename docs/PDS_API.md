# [PDS] API명세서

> 화면 2개 롤업(소분류 PDS, 대분류 PD - 수신 및 주식 상품 설정).

## PDS-001 예적금 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsProductsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositProductsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositProductsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/savingsproducts` | `SavingsProductsApiResource.create` |
| `PUT` | `/v1/savingsproducts/{productId}` | `SavingsProductsApiResource.update` |
| `GET` | `/v1/savingsproducts` | `SavingsProductsApiResource.retrieveAll` |
| `GET` | `/v1/savingsproducts/{productId}` | `SavingsProductsApiResource.retrieveOne` |
| `GET` | `/v1/savingsproducts/template` | `SavingsProductsApiResource.retrieveTemplate` |
| `DELETE` | `/v1/savingsproducts/{productId}` | `SavingsProductsApiResource.delete` |
| `POST` | `/v1/fixeddepositproducts` | `FixedDepositProductsApiResource.create` |
| `PUT` | `/v1/fixeddepositproducts/{productId}` | `FixedDepositProductsApiResource.update` |
| `GET` | `/v1/fixeddepositproducts` | `FixedDepositProductsApiResource.retrieveAll` |
| `GET` | `/v1/fixeddepositproducts/{productId}` | `FixedDepositProductsApiResource.retrieveOne` |
| `GET` | `/v1/fixeddepositproducts/template` | `FixedDepositProductsApiResource.retrieveTemplate` |
| `DELETE` | `/v1/fixeddepositproducts/{productId}` | `FixedDepositProductsApiResource.delete` |
| `POST` | `/v1/recurringdepositproducts` | `RecurringDepositProductsApiResource.create` |
| `PUT` | `/v1/recurringdepositproducts/{productId}` | `RecurringDepositProductsApiResource.update` |
| `GET` | `/v1/recurringdepositproducts` | `RecurringDepositProductsApiResource.retrieveAll` |
| `GET` | `/v1/recurringdepositproducts/{productId}` | `RecurringDepositProductsApiResource.retrieveOne` |
| `GET` | `/v1/recurringdepositproducts/template` | `RecurringDepositProductsApiResource.retrieveTemplate` |
| `DELETE` | `/v1/recurringdepositproducts/{productId}` | `RecurringDepositProductsApiResource.delete` |

### `POST /v1/savingsproducts` - SavingsProductsApiResource.create
- **설명**: `SavingsProductsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/savingsproducts/{productId}` - SavingsProductsApiResource.update
- **설명**: `SavingsProductsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsproducts` - SavingsProductsApiResource.retrieveAll
- **설명**: `SavingsProductsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsproducts/{productId}` - SavingsProductsApiResource.retrieveOne
- **설명**: `SavingsProductsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/savingsproducts/template` - SavingsProductsApiResource.retrieveTemplate
- **설명**: `SavingsProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/savingsproducts/{productId}` - SavingsProductsApiResource.delete
- **설명**: `SavingsProductsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/fixeddepositproducts` - FixedDepositProductsApiResource.create
- **설명**: `FixedDepositProductsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/fixeddepositproducts/{productId}` - FixedDepositProductsApiResource.update
- **설명**: `FixedDepositProductsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositproducts` - FixedDepositProductsApiResource.retrieveAll
- **설명**: `FixedDepositProductsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositproducts/{productId}` - FixedDepositProductsApiResource.retrieveOne
- **설명**: `FixedDepositProductsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/fixeddepositproducts/template` - FixedDepositProductsApiResource.retrieveTemplate
- **설명**: `FixedDepositProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/fixeddepositproducts/{productId}` - FixedDepositProductsApiResource.delete
- **설명**: `FixedDepositProductsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/recurringdepositproducts` - RecurringDepositProductsApiResource.create
- **설명**: `RecurringDepositProductsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/recurringdepositproducts/{productId}` - RecurringDepositProductsApiResource.update
- **설명**: `RecurringDepositProductsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositproducts` - RecurringDepositProductsApiResource.retrieveAll
- **설명**: `RecurringDepositProductsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositproducts/{productId}` - RecurringDepositProductsApiResource.retrieveOne
- **설명**: `RecurringDepositProductsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/recurringdepositproducts/template` - RecurringDepositProductsApiResource.retrieveTemplate
- **설명**: `RecurringDepositProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/recurringdepositproducts/{productId}` - RecurringDepositProductsApiResource.delete
- **설명**: `RecurringDepositProductsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## PDS-002 주식 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/products/api/ProductsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/products/{type}/template` | `ProductsApiResource.retrieveTemplate` |
| `GET` | `/v1/products/{type}/{productId}` | `ProductsApiResource.retrieveProduct` |
| `GET` | `/v1/products/{type}` | `ProductsApiResource.retrieveAllProducts` |
| `POST` | `/v1/products/{type}` | `ProductsApiResource.createProduct` |
| `POST` | `/v1/products/{type}/{productId}` | `ProductsApiResource.handleCommands` |
| `PUT` | `/v1/products/{type}/{productId}` | `ProductsApiResource.updateProduct` |

### `GET /v1/products/{type}/template` - ProductsApiResource.retrieveTemplate
- **설명**: `ProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/products/{type}/{productId}` - ProductsApiResource.retrieveProduct
- **설명**: `ProductsApiResource`의 `retrieveProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/products/{type}` - ProductsApiResource.retrieveAllProducts
- **설명**: `ProductsApiResource`의 `retrieveAllProducts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/products/{type}` - ProductsApiResource.createProduct
- **설명**: `ProductsApiResource`의 `createProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/products/{type}/{productId}` - ProductsApiResource.handleCommands
- **설명**: `ProductsApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/products/{type}/{productId}` - ProductsApiResource.updateProduct
- **설명**: `ProductsApiResource`의 `updateProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/products/api/ProductsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/FixedDepositProductsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/RecurringDepositProductsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/api/SavingsProductsApiResource.java`
