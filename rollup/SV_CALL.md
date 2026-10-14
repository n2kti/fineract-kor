# [SV] 콜그래프 (수신관리)

> 소분류 4개 롤업.


---

## [SVA] 콜그래프

> 화면 2개 롤업(소분류 SVA, 대분류 SV - 보통예금 계좌).

### SVA-001 보통예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 보통예금 계좌 개설 및 입출금 거래 흐름
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

### SVA-002 예금 수수료 및 거래 이력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 예금 거래 내역 조회 및 수수료 부과 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

---

## [SVF] 콜그래프

> 화면 1개 롤업(소분류 SVF, 대분류 SV - 정기예금 계좌).

### SVF-001 정기예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 정기예금 계좌 개설 및 만기 약정 처리 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

---

## [SVR] 콜그래프

> 화면 1개 롤업(소분류 SVR, 대분류 SV - 정기적금 계좌).

### SVR-001 정기적금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 정기적금 계좌 개설 및 월 불입금 처리 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

---

## [SVS] 콜그래프

> 화면 1개 롤업(소분류 SVS, 대분류 SV - 주식 계좌).

### SVS-001 주식 계좌 및 배당 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`

#### 주식(출자금) 계좌 개설 및 배당금 지급 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`
