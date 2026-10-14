# [AC] 콜그래프 (회계결산)

> 소분류 3개 롤업.


---

## [ACC] 콜그래프

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

### ACC-001 계정과목표(COA) 관리

> 원본: `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/`

#### 총계정원장(COA) 계정과목 등록 흐름
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

### ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/`

#### 수기 분개 전표 기표 및 대차평균 검증 흐름
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

### ACC-003 기초잔액 등록

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/`

#### 기초잔액 등록(Opening Balances) 처리 흐름
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

### 근거
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/api/GLAccountsApiResource.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/glaccount/service/GLAccountWritePlatformService.java`
- `fineract-core/src/main/java/org/apache/fineract/accounting/glaccount/domain/GLAccount.java`
- `fineract-core/src/main/java/org/apache/fineract/accounting/glaccount/domain/GLAccountRepository.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/service/JournalEntryWritePlatformService.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/journalentry/serialization/JournalEntryCommandFromApiJsonDeserializer.java`
- `fineract-accounting/src/main/java/org/apache/fineract/accounting/journalentry/domain/JournalEntryRepository.java`

---

## [ACR] 콜그래프

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

### ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`

#### 회계 분개 규칙 및 금융활동 매핑 흐름
> 공유: ACC, PDL, PDS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (AccountingRuleFormComponent)
    participant API as AccountingRuleApiResource
    participant WriteService as AccountingRuleWritePlatformService
    participant DB as acc_accounting_rule / acc_gl_financial_activity_account

    UI->>API: POST /v1/accountingrules (규칙명, 차/대변 기본 계정)
    API->>WriteService: createAccountingRule(JsonCommand)
    WriteService->>DB: INSERT INTO acc_accounting_rule
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`

---

## [ACP] 콜그래프

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

### ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`

#### 대손충당금 자동 산출 및 분개 전표 기표 흐름

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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/provisioning/`
