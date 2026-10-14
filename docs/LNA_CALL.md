# [LNA] 콜그래프

> 화면 2개 롤업(소분류 LNA, 대분류 LN - 대출 계좌 관리).

## LNA-001 대출 계좌 목록 및 상세

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 대출 계좌 원장 및 상환 스케줄 조회
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

## LNA-002 대출 신청 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 대출 신청, 승인 및 지급 실행 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
