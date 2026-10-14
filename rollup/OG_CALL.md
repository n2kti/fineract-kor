# [OG] 콜그래프 (조직관리)

> 소분류 2개 롤업.


---

## [OGB] 콜그래프

> 화면 1개 롤업(소분류 OGB, 대분류 OG - 지점 및 직원 관리).

### OGB-001 지점(Office) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`

#### 신규 지점 등록 및 계층 생성 흐름

> 공유: SCU, TRT

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (OfficeFormComponent)
    participant API as OfficesApiResource
    participant WriteService as OfficeWritePlatformService
    participant Repo as OfficeRepository
    participant DB as m_office

    UI->>API: POST /v1/offices (name, parentId, openingDate)
    API->>WriteService: createOffice(JsonCommand)
    WriteService->>Repo: save(OfficeEntity)
    Repo->>DB: INSERT INTO m_office (name, parent_id, hierarchy)
    WriteService-->>API: CommandProcessingResult (officeId)
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`

---

## [OGC] 콜그래프

> 화면 1개 롤업(소분류 OGC, 대분류 OG - 통화 및 조직 공통설정).

### OGC-001 통화·자금원·계좌체계

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`

#### 조직 통화 및 결제수단 설정 흐름

> 공유: ACC, PDL, PDS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (CurrenciesComponent)
    participant API as CurrenciesApiResource
    participant WriteService as CurrencyWritePlatformService
    participant DB as m_organisation_currency

    UI->>API: PUT /v1/currencies (currencies: ['USD', 'KRW', 'EUR'])
    API->>WriteService: updateCurrencies(JsonCommand)
    WriteService->>DB: DELETE FROM m_organisation_currency
    WriteService->>DB: INSERT INTO m_organisation_currency (code, decimal_places)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`
