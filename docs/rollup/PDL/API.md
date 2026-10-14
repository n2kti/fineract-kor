# [PDL] API명세서

> 화면 1개 롤업(중분류 PDL, 대분류 PD). 화면 단위 원본은 `specs/<화면>/api-spec.md`.

## PDL-001 대출상품관리

> 원본: `PDL-001-대출상품관리/api-spec.md`

## [PDL-001] 대출상품정의 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `PDL-001-대출상품관리` 화면에서 사용하는 대출 상품 등록, 수정, 조회 및 상품별 상환/크레딧 배분 규칙 설정을 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_product_credit_allocation_rule`, `m_loan_product_payment_allocation_rule`, `m_product_loan` (참조: [data-model.md](/specs/PDL-001-대출상품관리/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/loanproducts` | 대출 상품 신규 생성 (배분 규칙 포함) | `LoanProductsApiResource` | `createLoanProduct` |
| `GET` | `/v1/loanproducts` | 전체 대출 상품 목록 조회 | `LoanProductsApiResource` | `retrieveAllLoanProducts` |
| `GET` | `/v1/loanproducts/template` | 대출 상품 생성용 기본 템플릿 데이터 조회 | `LoanProductsApiResource` | `retrieveTemplate` |
| `GET` | `/v1/loanproducts/{productId}` | 대출 상품 상세 정보 조회 | `LoanProductsApiResource` | `retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/{productId}` | 대출 상품 정보 및 배분 규칙 수정 | `LoanProductsApiResource` | `updateLoanProduct` |
| `GET` | `/v1/loanproducts/external-id/{externalProductId}` | 외부 식별자(External ID) 기반 대출 상품 상세 조회 | `LoanProductsApiResource` | `retrieveLoanProductDetails` |
| `PUT` | `/v1/loanproducts/external-id/{externalProductId}` | 외부 식별자(External ID) 기반 대출 상품 수정 | `LoanProductsApiResource` | `updateLoanProduct` |
| `GET` | `/v1/loanproducts/{productId}/productmix` | 대출 상품 교차 제한(Product Mix) 규칙 조회 | `ProductMixApiResource` | `retrieveTemplate` |
| `POST` | `/v1/loanproducts/{productId}/productmix` | 대출 상품 교차 제한(Product Mix) 신규 등록 | `ProductMixApiResource` | `createProductMix` |
| `PUT` | `/v1/loanproducts/{productId}/productmix` | 대출 상품 교차 제한(Product Mix) 규칙 수정 | `ProductMixApiResource` | `updateProductMix` |
| `DELETE` | `/v1/loanproducts/{productId}/productmix` | 대출 상품 교차 제한(Product Mix) 규칙 삭제 | `ProductMixApiResource` | `deleteProductMix` |

---

### 2. API 상세 명세

#### 2.1 대출 상품 신규 생성 (`POST /v1/loanproducts`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanproduct.api.LoanProductsApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:62`)
* **메서드명**: `public String createLoanProduct(@Parameter(hidden = true) final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:195`)
* **JAX-RS 어노테이션**:
  * `@Path("/v1/loanproducts")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:62`)
  * `@Consumes({ MediaType.APPLICATION_JSON })` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:178`)
  * `@Produces({ MediaType.APPLICATION_JSON })` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:179`)
* **권한 체크**: `CREATE_LOANPRODUCT` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/service/LoanProductWritePlatformServiceJpaRepositoryImpl.java:231`)
* **요청 필드 (`PostLoanProductsRequest`)**:
  * `name` (String, 필수): 대출 상품명
  * `shortName` (String, 필수): 대출 상품 단축 코드 (4자 이내)
  * `currencyCode` (String, 필수): 통화 코드 (예: `KRW`, `USD`)
  * `digitsAfterDecimal` (Integer, 필수): 소수점 자릿수
  * `principal` (BigDecimal, 필수): 기본 대출 원금
  * `numberOfRepayments` (Integer, 필수): 총 상환 횟수
  * `repaymentEvery` (Integer, 필수): 상환 주기
  * `repaymentFrequencyType` (Integer, 필수): 상환 주기 단위 (0: 일, 1: 주, 2: 월, 3: 년)
  * `interestRatePerPeriod` (BigDecimal, 필수): 약정 이자율
  * `interestRateFrequencyType` (Integer, 필수): 이자율 적용 단위 (2: 월, 3: 년)
  * `amortizationType` (Integer, 필수): 상각 방식 (1: 원리금 균등, 0: 원금 균등)
  * `interestType` (Integer, 필수): 이자 계산 방식 (0: 잔액 기준 Flat, 1: 원금 잔액 기준 Declining)
  * `interestCalculationPeriodType` (Integer, 필수): 이자 산출 주기
  * `transactionProcessingStrategyCode` (String, 필수): 거래 충당 전략 코드
  * `paymentAllocation` (Array, 선택): 상품 수준 상환금 충당 규칙 (`m_loan_product_payment_allocation_rule`)
  * `creditAllocation` (Array, 선택): 상품 수준 크레딧 배분 규칙 (`m_loan_product_credit_allocation_rule`)
  *(근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResourceSwagger.java:70-205`)*
* **응답 필드 (`PostLoanProductsResponse`)**:
  * `resourceId` (Long): 생성된 대출 상품 식별자 (`loan_product_id`)
  *(근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResourceSwagger.java:498-508`)*

---

#### 2.2 전체 대출 상품 목록 조회 (`GET /v1/loanproducts`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanproduct.api.LoanProductsApiResource`
* **메서드명**: `public String retrieveAllLoanProducts(@Context final UriInfo uriInfo)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:210`)
* **JAX-RS 어노테이션**:
  * `@GET` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:204`)
  * `@Consumes({ MediaType.APPLICATION_JSON })` / `@Produces({ MediaType.APPLICATION_JSON })`
* **권한 체크**: `this.context.authenticatedUser().validateHasReadPermission(RESOURCE_NAME_FOR_PERMISSIONS)` (`READ_LOANPRODUCT`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:213`)
* **응답 필드**: `GetLoanProductsResponse` 목록 (배분 규칙, 금리, 상환 주기 등 포함) (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResourceSwagger.java:31-180`)

---

#### 2.3 대출 상품 상세 조회 (`GET /v1/loanproducts/{productId}`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanproduct.api.LoanProductsApiResource`
* **메서드명**: `public String retrieveLoanProductDetails(@PathParam("productId") final Long productId, @Context final UriInfo uriInfo)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:264`)
* **JAX-RS 어노테이션**:
  * `@GET` `@Path("{productId}")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:256-257`)
* **권한 체크**: `this.context.authenticatedUser().validateHasReadPermission(RESOURCE_NAME_FOR_PERMISSIONS)` (`READ_LOANPRODUCT`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:268`)
* **응답 필드 (`GetLoanProductsProductIdResponse`)**:
  * `id` (Long): 대출 상품 식별자
  * `name`, `shortName`, `description`: 상품 기본 정보
  * `paymentAllocationRules`: 상품에 설정된 `m_loan_product_payment_allocation_rule` 목록
  * `creditAllocationRules`: 상품에 설정된 `m_loan_product_credit_allocation_rule` 목록
  *(근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResourceSwagger.java:323-490`)*

---

#### 2.4 대출 상품 수정 (`PUT /v1/loanproducts/{productId}`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanproduct.api.LoanProductsApiResource`
* **메서드명**: `public String updateLoanProduct(@PathParam("productId") final Long productId, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:279`)
* **JAX-RS 어노테이션**:
  * `@PUT` `@Path("{productId}")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java:273-274`)
* **권한 체크**: `UPDATE_LOANPRODUCT` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/service/LoanProductWritePlatformServiceJpaRepositoryImpl.java:411`)
* **요청 필드 (`PutLoanProductsProductIdRequest`)**: 변경 대상 속성 및 `paymentAllocation`/`creditAllocation` 규칙
* **응답 필드 (`PutLoanProductsProductIdResponse`)**: `resourceId` 및 변경된 필드 Map (`changes`) (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResourceSwagger.java:515-528`)

---

#### 2.5 대출 상품 교차 제한 규칙 조회 및 등록 (`ProductMixApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanproduct.productmix.api.ProductMixApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:44`)
* **기본 경로**: `@Path("/v1/loanproducts/{productId}/productmix")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:44`)
* **엔드포인트**:
  * `GET /v1/loanproducts/{productId}/productmix` (retrieveTemplate) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:62`)
  * `POST /v1/loanproducts/{productId}/productmix` (createProductMix) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:79`)
  * `PUT /v1/loanproducts/{productId}/productmix` (updateProductMix) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:94`)
  * `DELETE /v1/loanproducts/{productId}/productmix` (deleteProductMix) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:108`)
* **권한 체크**: `READ_PRODUCTMIX`, `CREATE_PRODUCTMIX`, `UPDATE_PRODUCTMIX`, `DELETE_PRODUCTMIX` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/api/ProductMixApiResource.java:65,82,97,111`)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 11개
* **미확인 항목 수**: 0건 (모든 엔드포인트, HTTP 메서드, 클래스/메서드명, JAX-RS 어노테이션, 권한 및 요청/응답 필드 소스 확인 완료)
