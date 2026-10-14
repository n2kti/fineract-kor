# [PDL] 콜그래프

> 화면 2개 롤업(소분류 PDL, 대분류 PD - 대출 상품 설정).

## PDL-001 대출 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`

### 대출 상품 생성 및 회계 매핑 등록 흐름
> 공유: ACR, ACC, WCP

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (LoanProductFormComponent)
    participant API as LoanProductsApiResource
    participant WriteService as LoanProductWritePlatformService
    participant AccMapping as ProductToGLAccountMappingWritePlatformService
    participant DB as m_product_loan / acc_product_mapping

    UI->>API: POST /v1/loanproducts (상품조건, GL계정 매핑)
    API->>WriteService: createLoanProduct(JsonCommand)
    WriteService->>DB: INSERT INTO m_product_loan
    WriteService->>AccMapping: createProductToGLAccountMapping(productId, accountingData)
    AccMapping->>DB: INSERT INTO acc_product_mapping (원금, 이자, 수수료 GL 계정)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## PDL-002 대출 상품 믹스 및 모집인

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`

### 대출 상품 믹스 규칙 정의 흐름
> 공유: LNA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ProductMixComponent)
    participant API as ProductMixApiResource
    participant WriteService as ProductMixWritePlatformService
    participant DB as m_product_mix

    UI->>API: POST /v1/loanproducts/{productId}/productmix (restrictedProductIds)
    API->>WriteService: createProductMix(productId, JsonCommand)
    WriteService->>DB: INSERT INTO m_product_mix (product_id, restricted_product_id)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`
