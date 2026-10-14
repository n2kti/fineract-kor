# [LNO] 콜그래프

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

## LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`

### 보증인 등록 및 예금 질권 설정 흐름
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

## LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 대출 담당자 일괄 재배정 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`
