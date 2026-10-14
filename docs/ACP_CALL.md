# [ACP] 콜그래프

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

## ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`

### 대손충당금 자동 산출 및 분개 전표 기표 흐름

> 공유: ACC, PDL

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ProvisioningEntriesListComponent)
    participant API as ProvisioningEntriesApiResource
    participant WriteService as ProvisioningEntriesWritePlatformService
    participant JournalWriter as JournalEntryWritePlatformService
    participant DB as m_provisioning_history / m_loanproduct_provisioning_entry / acc_gl_journal_entry

    UI->>API: POST /v1/provisioningentries (date, createjournalentry: true)
    API->>WriteService: createProvisioningEntries(JsonCommand)
    WriteService->>DB: INSERT INTO m_provisioning_history
    WriteService->>DB: INSERT INTO m_loanproduct_provisioning_entry
    opt 분개 전표 자동 생성 옵션
        WriteService->>JournalWriter: createProvisioningJournalEntries(...)
        JournalWriter->>DB: INSERT INTO acc_gl_journal_entry (대손상각비 / 대손충당금)
    end
    WriteService-->>API: CommandProcessingResult (entryId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`
