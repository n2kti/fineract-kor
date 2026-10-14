# [WCL] 콜그래프

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

## WCL-001 운전자금 대출 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 운전자금 대출 신청 및 분할 인출(Drawdown) 흐름

> 공유: LNA, WCP

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (WcLoanFormComponent)
    participant API as LoansApiResource
    participant WriteService as LoanWritePlatformService
    participant DB as m_loan / m_loan_disbursement_detail / m_loan_repayment_schedule

    UI->>API: POST /v1/loans (신용공여한도 내 인출 신청 JSON)
    API->>WriteService: createLoanApplication(JsonCommand)
    WriteService->>DB: INSERT INTO m_loan (loan_type_enum: Working Capital)
    WriteService-->>API: CommandProcessingResult (loanId)
    API-->>UI: 200 OK

    UI->>API: POST /v1/loans/{loanId}?command=disburse
    API->>WriteService: disburseLoan(loanId, JsonCommand)
    WriteService->>DB: INSERT INTO m_loan_disbursement_detail (인출 회차 기록)
    WriteService->>DB: UPDATE m_loan SET principal_disbursed_derived = ...
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
