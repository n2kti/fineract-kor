# [TRT] 콜그래프

> 화면 1개 롤업(소분류 TRT, 대분류 TR - 창구 및 출납원 운영).

## TRT-001 창구 및 출납원 운영

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`

### 출납원 시재 할당 및 정산 흐름

> 공유: OGB, ACC

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (CashiersListComponent)
    participant API as CashierApiResource
    participant WriteService as TellerWritePlatformService
    participant JournalWriter as JournalEntryWritePlatformService
    participant DB as m_cashiers / m_cashier_transactions / acc_gl_journal_entry

    UI->>API: POST /v1/tellers/{tellerId}/cashiers/{cashierId}/allocate (amount, currency)
    API->>WriteService: allocateCashToCashier(tellerId, cashierId, JsonCommand)
    WriteService->>DB: INSERT INTO m_cashier_transactions (txn_type: Allocate)
    WriteService->>JournalWriter: postCashierJournalEntry(...)
    JournalWriter->>DB: INSERT INTO acc_gl_journal_entry (본지점 금고 ➔ 출납원 시재)
    WriteService-->>API: CommandProcessingResult (resourceId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`
