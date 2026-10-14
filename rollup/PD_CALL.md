# [PD] 콜그래프 (상품설정)

> 소분류 3개 롤업.


---

## [PDL] 콜그래프

> 화면 2개 롤업(소분류 PDL, 대분류 PD - 대출 상품 설정).

### PDL-001 대출 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`

#### 대출 상품 생성 및 회계 매핑 등록 흐름
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

### PDL-002 대출 상품 믹스 및 모집인

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`

#### 대출 상품 믹스 규칙 정의 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/productmix/`

---

## [PDS] 콜그래프

> 화면 2개 롤업(소분류 PDS, 대분류 PD - 수신 및 주식 상품 설정).

### PDS-001 예적금 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`

#### 예적금 상품 생성 흐름
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

### PDS-002 주식 상품 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`

#### 주식 상품 및 시가 등록 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/product/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareproducts/`

---

## [PDR] 콜그래프

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

### PDR-001 금리·수수료·세무 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`

#### 금리 차트 및 수수료 규정 등록 흐름
> 공유: PDL, PDS, LNA, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (RateFormComponent)
    participant API as InterestRateChartsApiResource
    participant Cmd as InterestRateChartCreateCommand
    participant DB as m_interest_rate_chart / m_interest_rate_slab / m_charge

    UI->>API: POST /v1/interestratecharts (차트명, 슬랩구간)
    API->>Cmd: dispatcher.dispatch(command)
    Cmd->>DB: INSERT INTO m_interest_rate_chart
    Cmd->>DB: INSERT INTO m_interest_rate_slab (기간/금액별 금리)
    Cmd-->>API: InterestRateChartCreateResponse
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`
