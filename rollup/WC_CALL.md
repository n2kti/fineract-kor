# [WC] 콜그래프 (운전자금)

> 소분류 3개 롤업.


---

## [WCL] 콜그래프

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

### WCL-001 운전자금 대출 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 운전자금 대출 신청 및 분할 인출(Drawdown) 흐름

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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

---

## [WCP] 콜그래프

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

### WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

#### 한도위반(Breach) 감지 버킷 설정 흐름

> 공유: PDL, SYB

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (WcBreachFormComponent)
    participant API as DelinquencyApiResource
    participant WriteService as DelinquencyWritePlatformService
    participant DB as m_delinquency_bucket / m_delinquency_range

    UI->>API: POST /v1/delinquency/buckets (버킷명, 범위 목록)
    API->>WriteService: createDelinquencyBucket(JsonCommand)
    WriteService->>DB: INSERT INTO m_delinquency_bucket
    loop Each Delinquency Range
        WriteService->>DB: INSERT INTO m_delinquency_range
    end
    WriteService-->>API: CommandProcessingResult (bucketId)
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

---

## [WCO] 콜그래프

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

### WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

#### 운전자금 한도위반 계좌 사후조치 실행 흐름

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

### WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

#### 운전자금 COB 마감 Catch-up 및 계좌 락 해제 흐름

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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
