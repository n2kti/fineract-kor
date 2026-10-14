# [LN] 콜그래프 (여신관리)

> 소분류 3개 롤업.


---

## [LNA] 콜그래프

> 화면 2개 롤업(소분류 LNA, 대분류 LN - 대출 계좌 관리).

### LNA-001 대출 계좌 목록 및 상세

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 대출 계좌 원장 및 상환 스케줄 조회
> 공유: LNR, LNO, WCL

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (LoanViewComponent)
    participant API as LoansApiResource
    participant ReadService as LoanReadPlatformService
    participant DB as m_loan / m_loan_repayment_schedule

    UI->>API: GET /v1/loans/{loanId}?associations=all
    API->>ReadService: retrieveOne(loanId)
    ReadService->>DB: SELECT * FROM m_loan WHERE id = ?
    ReadService->>DB: SELECT * FROM m_loan_repayment_schedule WHERE loan_id = ? ORDER BY installment
    DB-->>ReadService: Loan & Schedule Records
    ReadService-->>API: LoanAccountData DTO
    API-->>UI: 200 OK (LoanAccountData JSON)
```

### LNA-002 대출 신청 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 대출 신청, 승인 및 지급 실행 흐름
> 공유: LNR, LNO, PDL, WCL

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (LoanFormComponent)
    participant API as LoansApiResource
    participant WriteService as LoanWritePlatformService
    participant ScheduleGen as LoanScheduleCalculationPlatformService
    participant Repo as LoanRepository
    participant DB as m_loan / m_loan_repayment_schedule / m_loan_disbursement_detail

    UI->>API: POST /v1/loans (신청서 JSON)
    API->>WriteService: createLoanApplication(JsonCommand)
    WriteService->>ScheduleGen: calculateSchedule(terms)
    ScheduleGen-->>WriteService: LoanScheduleModel
    WriteService->>Repo: save(LoanEntity)
    Repo->>DB: INSERT INTO m_loan, m_loan_repayment_schedule
    DB-->>Repo: loanId
    WriteService-->>API: CommandProcessingResult (loanId)
    API-->>UI: 200 OK ({ loanId })

    UI->>API: POST /v1/loans/{loanId}?command=disburse
    API->>WriteService: disburseLoan(loanId, JsonCommand)
    WriteService->>DB: UPDATE m_loan SET loan_status_id = 300 (Active)
    WriteService->>DB: INSERT INTO m_loan_disbursement_detail (...)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

---

## [LNR] 콜그래프

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

### LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 대출 상환(Repayment) 및 충당 분개 흐름
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

### LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`

#### 대출 재조정(Reschedule) 신청 및 스케줄 재계산 승인 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`

---

## [LNO] 콜그래프

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

### LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`

#### 보증인 등록 및 예금 질권 설정 흐름
> 공유: LNA, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (GuarantorFormComponent)
    participant API as GuarantorsApiResource
    participant WriteService as GuarantorWritePlatformService
    participant SavingsWrite as SavingsAccountWritePlatformService
    participant DB as m_guarantor / m_guarantor_funding_details / m_deposit_account_on_hold_transaction

    UI->>API: POST /v1/loans/{loanId}/guarantors
    API->>WriteService: createGuarantor(loanId, JsonCommand)
    WriteService->>DB: INSERT INTO m_guarantor
    opt 예금 질권 보증인 경우
        WriteService->>SavingsWrite: holdFunds(savingsId, amount)
        SavingsWrite->>DB: INSERT INTO m_deposit_account_on_hold_transaction
        WriteService->>DB: INSERT INTO m_guarantor_funding_details
    end
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 대출 담당자 일괄 재배정 흐름
> 공유: LNA, OGB

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (LoanReassignmentComponent)
    participant API as BulkLoansApiResource
    participant WriteService as LoanWritePlatformService
    participant DB as m_loan / m_loan_officer_assignment_history

    UI->>API: POST /v1/loans/loanreassignment (fromOfficerId, toOfficerId, loans[])
    API->>WriteService: bulkLoanReassignment(JsonCommand)
    loop Each Selected Loan
        WriteService->>DB: UPDATE m_loan SET loan_officer_id = toOfficerId
        WriteService->>DB: INSERT INTO m_loan_officer_assignment_history
    end
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`
