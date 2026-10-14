# [WCP] 콜그래프

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

## WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

### 한도위반(Breach) 감지 버킷 설정 흐름

> 공유: PDL, SYB

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (WcBreachFormComponent)
    participant API as DelinquencyApiResource
    participant WriteService as DelinquencyWritePlatformService
    participant DB as m_delinquency_bucket / m_delinquency_range

    UI->>API: POST /v1/delinquency/buckets (버킷명, 범위 목록)
    API->>WriteService: createDelinquencyBucket(JsonCommand)
    WriteService->>DB: INSERT INTO m_delinquency_bucket
    loop Each Delinquency Range
        WriteService->>DB: INSERT INTO m_delinquency_range
    end
    WriteService-->>API: CommandProcessingResult (bucketId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
