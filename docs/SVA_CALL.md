# [SVA] 콜그래프

> 화면 2개 롤업(소분류 SVA, 대분류 SV - 보통예금 계좌).

## SVA-001 보통예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 보통예금 계좌 개설 및 입출금 거래 흐름
> 공유: SVF, SVR, TRA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (SavingsAccountViewComponent)
    participant API as SavingsAccountsApiResource
    participant WriteService as SavingsAccountWritePlatformService
    participant Repo as SavingsAccountRepository
    participant DB as m_savings_account / m_savings_account_transaction

    UI->>API: POST /v1/savingsaccounts (개설 JSON)
    API->>WriteService: createSavingsAccount(JsonCommand)
    WriteService->>Repo: save(SavingsAccountEntity)
    Repo->>DB: INSERT INTO m_savings_account
    WriteService-->>API: CommandProcessingResult (savingsId)
    API-->>UI: 200 OK

    UI->>API: POST /v1/savingsaccounts/{savingsId}/transactions?command=deposit
    API->>WriteService: makeDeposit(savingsId, JsonCommand)
    WriteService->>DB: INSERT INTO m_savings_account_transaction
    WriteService->>DB: UPDATE m_savings_account SET account_balance_derived = ...
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## SVA-002 예금 수수료 및 거래 이력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 예금 거래 내역 조회 및 수수료 부과 흐름
> 공유: PDR, TRA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (SavingsAccountTransactionFormComponent)
    participant API as SavingsAccountTransactionsApiResource
    participant ReadService as SavingsAccountReadPlatformService
    participant DB as m_savings_account_transaction / m_savings_account_charge

    UI->>API: GET /v1/savingsaccounts/{savingsId}/transactions
    API->>ReadService: retrieveAllTransactions(savingsId)
    ReadService->>DB: SELECT * FROM m_savings_account_transaction WHERE savings_account_id = ?
    DB-->>ReadService: Transaction Records
    ReadService-->>API: SavingsAccountTransactionData List
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`
