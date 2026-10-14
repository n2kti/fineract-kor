# [WCO] 콜그래프

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

## WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

### 운전자금 한도위반 계좌 사후조치 실행 흐름

> 공유: WCL, SYB

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (WcBreachActionFormComponent)
    participant API as WorkingCapitalLoanDelinquencyActionApiResource
    participant WriteService as DelinquencyWritePlatformService
    participant DB as m_loan_delinquency_tag_history / m_loan

    UI->>API: POST /v1/loans/{loanId}/delinquency-actions (action: FREEZE_DRAWDOWN)
    API->>WriteService: applyDelinquencyAction(loanId, JsonCommand)
    WriteService->>DB: INSERT INTO m_loan_delinquency_tag_history
    WriteService->>DB: UPDATE m_loan SET loan_sub_status_id = 100 (Blocked)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

### 운전자금 COB 마감 Catch-up 및 계좌 락 해제 흐름

> 공유: SYB, WCL

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (WcLoanCobCatchupComponent)
    participant API as WorkingCapitalLoanCOBCatchUpApiResource
    participant LockService as LoanAccountLockService
    participant COBRunner as LoanCOBCatchUpService
    participant DB as m_loan_account_locks

    UI->>API: POST /v1/working-capital-loans/cob-catchup
    API->>LockService: acquireLocks(loanIds)
    LockService->>DB: INSERT INTO m_loan_account_locks (lock_owner, lock_time)
    API->>COBRunner: runCatchUp(loanIds)
    COBRunner-->>API: CatchUp Finished
    API->>LockService: releaseLocks(loanIds)
    LockService->>DB: DELETE FROM m_loan_account_locks
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
