# [WCP] API명세서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

## WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/loanproducts` | `LoanProductsApiResource.createLoanProduct` |
| `GET` | `/v1/loanproducts` | `LoanProductsApiResource.retrieveAllLoanProducts` |
| `GET` | `/v1/loanproducts/template` | `LoanProductsApiResource.retrieveTemplate` |
| `GET` | `/v1/loanproducts/{productId}` | `LoanProductsApiResource.retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/{productId}` | `LoanProductsApiResource.updateLoanProduct` |
| `GET` | `/v1/loanproducts/external-id/{externalProductId}` | `LoanProductsApiResource.retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/external-id/{externalProductId}` | `LoanProductsApiResource.updateLoanProduct` |

### `POST /v1/loanproducts` - LoanProductsApiResource.createLoanProduct
- **설명**: `LoanProductsApiResource`의 `createLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loanproducts` - LoanProductsApiResource.retrieveAllLoanProducts
- **설명**: `LoanProductsApiResource`의 `retrieveAllLoanProducts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loanproducts/template` - LoanProductsApiResource.retrieveTemplate
- **설명**: `LoanProductsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loanproducts/{productId}` - LoanProductsApiResource.retrieveLoanProductDetails
- **설명**: `LoanProductsApiResource`의 `retrieveLoanProductDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loanproducts/{productId}` - LoanProductsApiResource.updateLoanProduct
- **설명**: `LoanProductsApiResource`의 `updateLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loanproducts/external-id/{externalProductId}` - LoanProductsApiResource.retrieveLoanProductDetails
- **설명**: `LoanProductsApiResource`의 `retrieveLoanProductDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loanproducts/external-id/{externalProductId}` - LoanProductsApiResource.updateLoanProduct
- **설명**: `LoanProductsApiResource`의 `updateLoanProduct` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`
