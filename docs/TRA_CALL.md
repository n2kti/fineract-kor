# [TRA] 콜그래프

> 화면 2개 롤업(소분류 TRA, 대분류 TR - 계좌이체 및 자동이체).

## TRA-001 계좌간 이체

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/AccountTransfersWritePlatformServiceImpl.java`

### 계좌간 즉시 이체 실행 흐름

> 공유: SVA, LNA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (AccountTransferFormComponent)
    participant API as AccountTransfersApiResource
    participant WriteService as AccountTransfersWritePlatformService
    participant SavingsWrite as SavingsAccountWritePlatformService
    participant LoanWrite as LoanWritePlatformService
    participant DB as m_account_transfer_details / m_account_transfer_transaction / m_savings_account_transaction

    UI->>API: POST /v1/accounttransfers (fromAccount, toAccount, amount)
    API->>WriteService: transferFunds(JsonCommand)
    WriteService->>SavingsWrite: makeWithdrawal(fromAccountId, amount)
    SavingsWrite->>DB: INSERT INTO m_savings_account_transaction (출금)
    alt 입금계좌가 예금인 경우
        WriteService->>SavingsWrite: makeDeposit(toAccountId, amount)
        SavingsWrite->>DB: INSERT INTO m_savings_account_transaction (입금)
    else 입금계좌가 대출인 경우
        WriteService->>LoanWrite: makeLoanRepayment(toAccountId, amount)
        LoanWrite->>DB: INSERT INTO m_loan_transaction (상환)
    end
    WriteService->>DB: INSERT INTO m_account_transfer_details, m_account_transfer_transaction
    WriteService-->>API: CommandProcessingResult (transferId)
    API-->>UI: 200 OK
```

## TRA-002 자동이체(SI) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/StandingInstructionWritePlatformServiceImpl.java`

### 정기 자동이체 등록 및 스케줄러 실행 흐름

> 공유: SYB, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (StandingInstructionFormComponent)
    participant API as StandingInstructionApiResource
    participant WriteService as StandingInstructionWritePlatformService
    participant DB as m_account_transfer_standing_instructions

    UI->>API: POST /v1/standinginstructions (fromAccount, toAccount, frequency, amount)
    API->>WriteService: create(JsonCommand)
    WriteService->>DB: INSERT INTO m_account_transfer_standing_instructions
    WriteService-->>API: CommandProcessingResult (instructionId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/AccountTransfersWritePlatformServiceImpl.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/StandingInstructionWritePlatformServiceImpl.java`
