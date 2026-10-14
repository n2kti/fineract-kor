# [SVS] 콜그래프

> 화면 1개 롤업(소분류 SVS, 대분류 SV - 주식 계좌).

## SVS-001 주식 계좌 및 배당 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`

### 주식(출자금) 계좌 개설 및 배당금 지급 흐름
> 공유: PDS, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ShareAccountViewComponent)
    participant API as AccountsApiResource
    participant WriteService as ShareAccountWritePlatformService
    participant DB as m_share_account / m_share_account_transactions / m_share_account_dividend_details

    UI->>API: POST /v1/accounts/share (주식수, 단가)
    API->>WriteService: createShareAccount(JsonCommand)
    WriteService->>DB: INSERT INTO m_share_account
    WriteService->>DB: INSERT INTO m_share_account_transactions (매수 거래)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`
