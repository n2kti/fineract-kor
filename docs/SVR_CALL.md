# [SVR] 콜그래프

> 화면 1개 롤업(소분류 SVR, 대분류 SV - 정기적금 계좌).

## SVR-001 정기적금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 정기적금 계좌 개설 및 월 불입금 처리 흐름
> 공유: SVA, PDS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (RecurringDepositAccountFormComponent)
    participant API as RecurringDepositAccountsApiResource
    participant WriteService as DepositAccountWritePlatformService
    participant DB as m_savings_account / m_deposit_account_recurring_detail / m_mandatory_savings_schedule

    UI->>API: POST /v1/recurringdepositaccounts (월 불입금, 주기)
    API->>WriteService: createRecurringDepositAccount(JsonCommand)
    WriteService->>DB: INSERT INTO m_savings_account (deposit_type_enum: 300)
    WriteService->>DB: INSERT INTO m_deposit_account_recurring_detail (월약정금액)
    WriteService->>DB: INSERT INTO m_mandatory_savings_schedule (회차별 불입스케줄)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`
