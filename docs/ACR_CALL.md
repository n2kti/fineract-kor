# [ACR] 콜그래프

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

## ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`

### 회계 분개 규칙 및 금융활동 매핑 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/rule/`
