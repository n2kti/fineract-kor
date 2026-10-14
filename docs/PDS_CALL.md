# [PDS] 콜그래프

> 화면 2개 롤업(소분류 PDS, 대분류 PD - 수신 및 주식 상품 설정).

## PDS-001 예적금 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`

### 예적금 상품 생성 흐름
> 공유: SVF, SVR, PDR

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (SavingsProductFormComponent)
    participant API as SavingsProductsApiResource
    participant WriteService as SavingsProductWritePlatformService
    participant DB as m_savings_product / m_deposit_product_term_and_preclosure

    UI->>API: POST /v1/savingsproducts (약정이율, 이자지급주기)
    API->>WriteService: createSavingsProduct(JsonCommand)
    WriteService->>DB: INSERT INTO m_savings_product
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## PDS-002 주식 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`

### 주식 상품 및 시가 등록 흐름
> 공유: SVS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ShareProductFormComponent)
    participant API as ProductsApiResource
    participant WriteService as ShareProductWritePlatformService
    participant DB as m_share_product / m_share_product_market_price

    UI->>API: POST /v1/products/share (액면가, 총발행주수)
    API->>WriteService: createShareProduct(JsonCommand)
    WriteService->>DB: INSERT INTO m_share_product
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`
