# [SC] 콜그래프 (보안승인)

> 소분류 2개 롤업.


---

## [SCU] 콜그래프

> 화면 1개 롤업(소분류 SCU, 대분류 SC - 사용자 및 권한 관리).

### SCU-001 사용자 계정 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/`

#### 백오피스 사용자 계정 생성 및 역할 부여 흐름

> 공유: OGB, SCA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (UserFormComponent)
    participant API as UsersApiResource
    participant WriteService as AppUserWritePlatformService
    participant Encoder as PlatformPasswordEncoder
    participant DB as m_appuser / m_appuser_role

    UI->>API: POST /v1/users (username, email, password, roles[])
    API->>WriteService: createUser(JsonCommand)
    WriteService->>Encoder: encode(password)
    Encoder-->>WriteService: passwordHash
    WriteService->>DB: INSERT INTO m_appuser (username, password, office_id, staff_id)
    loop Each Assigned Role
        WriteService->>DB: INSERT INTO m_appuser_role (appuser_id, role_id)
    end
    WriteService-->>API: CommandProcessingResult (userId)
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/`

---

## [SCA] 콜그래프

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

### SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-provider/src/main/java/org/apache/fineract/commands/`

#### Maker-Checker 결재 승인 및 감사 로그 기록 흐름

> 공유: SCU, SYI

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (CheckerInboxComponent)
    participant API as MakercheckersApiResource
    participant CmdService as PortfolioCommandSourceWritePlatformService
    participant CommandDispatcher as PortfolioCommandSourceWritePlatformService
    participant HookService as HookWritePlatformService
    participant DB as m_portfolio_command_source

    UI->>API: POST /v1/makercheckers/{auditId}?command=approve
    API->>CmdService: approveEntry(auditId)
    CmdService->>CommandDispatcher: dispatchCommand(originalCommandPayload)
    CommandDispatcher-->>CmdService: Success Result
    CmdService->>DB: UPDATE m_portfolio_command_source SET checker_id = ?, checked_on_utc = ?
    CmdService->>HookService: notifyHooks(event)
    CmdService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/commands/`
