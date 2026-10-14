# [SVF] 콜그래프

> 화면 1개 롤업(소분류 SVF, 대분류 SV - 정기예금 계좌).

## SVF-001 정기예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 정기예금 계좌 개설 및 만기 약정 처리 흐름
> 공유: SVA, PDS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (FixedDepositAccountFormComponent)
    participant API as FixedDepositAccountsApiResource
    participant WriteService as DepositAccountWritePlatformService
    participant DB as m_savings_account / m_deposit_account_term_and_preclosure

    UI->>API: POST /v1/fixeddepositaccounts (예치금액, 기간, 이율차트)
    API->>WriteService: createFixedDepositAccount(JsonCommand)
    WriteService->>DB: INSERT INTO m_savings_account (deposit_type_enum: 200)
    WriteService->>DB: INSERT INTO m_deposit_account_term_and_preclosure (약정기간, 만기일자)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`
