# [CLS] 콜그래프

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

## CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`

### 일괄 수납 데이터 생성 및 전표 처리 흐름
> 공유: CLA, CLG, LNR, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (CollectionSheetComponent)
    participant API as CollectionSheetApiResource
    participant WriteService as CollectionSheetWritePlatformService
    participant LoanWrite as LoanWritePlatformService
    participant DB as m_loan_transaction / m_meeting_attendance

    UI->>API: POST /v1/collectionsheet?command=saveCollectionSheet
    API->>WriteService: saveCollectionSheet(JsonCommand)
    loop Each Client Loan Repayment
        WriteService->>LoanWrite: makeLoanRepayment(...)
        LoanWrite->>DB: INSERT INTO m_loan_transaction (...)
    end
    WriteService->>DB: INSERT INTO m_meeting_attendance (...)
    DB-->>WriteService: Batch Complete
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK ({ changes: ... })
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`
