# [PDR] 콜그래프

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

## PDR-001 금리·수수료·세무 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`

### 금리 차트 및 수수료 규정 등록 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/rate/`
