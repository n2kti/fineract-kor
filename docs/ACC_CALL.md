# [ACC] 콜그래프

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

## ACC-001 계정과목표(COA) 관리

> 원본: `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/`

### 총계정원장(COA) 계정과목 등록 흐름
> 공유: ACR, ACP

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ChartOfAccountsComponent)
    participant API as GLAccountsApiResource
    participant WriteService as GLAccountWritePlatformService
    participant Repo as GLAccountRepository
    participant DB as acc_gl_account

    UI->>API: POST /v1/glaccounts (glCode, name, type, usage)
    API->>WriteService: createGLAccount(JsonCommand)
    WriteService->>Repo: save(GLAccount)
    Repo->>DB: INSERT INTO acc_gl_account
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

## ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/`

### 수기 분개 전표 기표 및 대차평균 검증 흐름
> 공유: ACR, LNR, TRT

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (JournalEntryFormComponent)
    participant API as JournalEntriesApiResource
    participant WriteService as JournalEntryWritePlatformService
    participant Deserializer as JournalEntryCommandFromApiJsonDeserializer
    participant Repo as JournalEntryRepository
    participant DB as acc_gl_journal_entry

    UI->>API: POST /v1/journalentries (차/대변 엔트리 목록)
    API->>WriteService: createJournalEntry(JsonCommand)
    WriteService->>Deserializer: validateForCreate(command.json())
    Deserializer-->>WriteService: Validation Passed (대차평균 일치)
    loop Each Debit/Credit Entry
        WriteService->>Repo: save(JournalEntry)
        Repo->>DB: INSERT INTO acc_gl_journal_entry (transaction_id, gl_account_id, type, amount)
    end
    WriteService-->>API: CommandProcessingResult (transactionId)
    API-->>UI: 200 OK
```

## ACC-003 기초잔액 등록

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/`

### 기초잔액 등록(Opening Balances) 처리 흐름
> 공유: ACP

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (OpeningBalancesComponent)
    participant API as JournalEntriesApiResource
    participant WriteService as JournalEntryWritePlatformService
    participant Deserializer as JournalEntryCommandFromApiJsonDeserializer
    participant Repo as JournalEntryRepository
    participant DB as acc_gl_journal_entry / acc_gl_account

    UI->>API: POST /v1/journalentries/openingbalance (officeId, openingBalances[])
    API->>WriteService: defineOpeningBalance(JsonCommand)
    WriteService->>Deserializer: validateForCreate(command.json())
    Deserializer-->>WriteService: Validation Passed
    loop Each Opening Balance Entry
        WriteService->>Repo: save(JournalEntry)
        Repo->>DB: INSERT INTO acc_gl_journal_entry (office_id, gl_account_id, amount, is_running_balance_calculated: false)
    end
    WriteService-->>API: CommandProcessingResult (officeId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/api/GLAccountsApiResource.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/service/GLAccountWritePlatformService.java`
- `fineract-core/src/main/java/org/apache/fineract/accounting/glaccount/domain/GLAccount.java`
- `fineract-core/src/main/java/org/apache/fineract/accounting/glaccount/domain/GLAccountRepository.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/service/JournalEntryWritePlatformService.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/journalentry/serialization/JournalEntryCommandFromApiJsonDeserializer.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/journalentry/domain/JournalEntryRepository.java`
