# [LNR] 콜그래프

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

## LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 대출 상환(Repayment) 및 충당 분개 흐름
> 공유: LNA, ACC, CLS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (LoanTransactionFormComponent)
    participant API as LoanTransactionsApiResource
    participant WriteService as LoanWritePlatformService
    participant Strategy as LoanPaymentAllocationRule
    participant AccPoster as LoanJournalEntryPoster
    participant DB as m_loan_transaction / m_loan_transaction_repayment_schedule_mapping / acc_gl_journal_entry

    UI->>API: POST /v1/loans/{loanId}/transactions?command=repayment
    API->>WriteService: makeLoanRepayment(loanId, JsonCommand)
    WriteService->>Strategy: allocatePayment(loan, transactionAmount)
    Strategy->>DB: UPDATE m_loan_repayment_schedule (원금/이자 충당)
    Strategy->>DB: INSERT INTO m_loan_transaction_repayment_schedule_mapping
    WriteService->>DB: INSERT INTO m_loan_transaction
    WriteService->>AccPoster: postJournalEntries(transaction)
    AccPoster->>DB: INSERT INTO acc_gl_journal_entry (현금 / 대출원금 / 이자수익)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`

### 대출 재조정(Reschedule) 신청 및 스케줄 재계산 승인 흐름
> 공유: LNA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (RescheduleFormComponent)
    participant API as RescheduleLoansApiResource
    participant WriteService as LoanRescheduleRequestWritePlatformService
    participant ScheduleGen as LoanScheduleCalculationPlatformService
    participant DB as m_loan_reschedule_request / m_loan_repayment_schedule_history / m_loan_repayment_schedule

    UI->>API: POST /v1/rescheduleloans
    API->>WriteService: createLoanRescheduleRequest(JsonCommand)
    WriteService->>DB: INSERT INTO m_loan_reschedule_request (status: 100 Pending)
    WriteService-->>API: CommandProcessingResult (requestId)
    API-->>UI: 200 OK

    UI->>API: POST /v1/rescheduleloans/{requestId}?command=approve
    API->>WriteService: approveLoanRescheduleRequest(requestId, JsonCommand)
    WriteService->>DB: INSERT INTO m_loan_repayment_schedule_history (과거 스케줄 백업)
    WriteService->>ScheduleGen: recalculateScheduleWithRescheduleTerms(...)
    ScheduleGen-->>WriteService: NewScheduleModel
    WriteService->>DB: UPDATE / REPLACE m_loan_repayment_schedule
    WriteService->>DB: UPDATE m_loan_reschedule_request SET status = 200 (Approved)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`
