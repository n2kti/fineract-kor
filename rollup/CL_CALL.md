# [CL] 콜그래프 (고객관리)

> 소분류 3개 롤업.


---

## [CLA] 콜그래프

> 화면 2개 롤업(소분류 CLA, 대분류 CL - 고객 관리).

### CLA-001 고객 목록 및 검색

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

#### 고객 목록 조회 및 검색 흐름
> 공유: CLG, CLS, LNA, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ClientsListComponent)
    participant API as ClientsApiResource
    participant ReadService as ClientReadPlatformService
    participant Repo as ClientRepositoryWrapper
    participant DB as m_client / m_office

    UI->>API: GET /v1/clients?offset=0&limit=15&displayName=...
    API->>ReadService: retrieveAll(SearchParameters)
    ReadService->>Repo: queryClients(sql, params)
    Repo->>DB: SELECT c.*, o.name as office_name FROM m_client c JOIN m_office o ...
    DB-->>Repo: ResultSet
    Repo-->>ReadService: Page<ClientData>
    ReadService-->>API: ClientData DTO List
    API-->>UI: 200 OK (Page<ClientData>)
```

### CLA-002 고객 등록 및 상세정보

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

#### 신규 고객 등록 및 유효성 검증 흐름
> 공유: CLG, SYI

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (ClientFormComponent)
    participant API as ClientsApiResource
    participant Handler as CreateClientCommandHandler
    participant WriteService as ClientWritePlatformService
    participant Repo as ClientRepository
    participant DB as m_client / m_client_identifier

    UI->>API: POST /v1/clients (JSON Body)
    API->>Handler: processCommand(CreateClientCommand)
    Handler->>WriteService: createClient(JsonCommand)
    WriteService->>WriteService: validateForCreate(command)
    WriteService->>Repo: save(ClientEntity)
    Repo->>DB: INSERT INTO m_client (account_no, firstname, lastname, ...)
    DB-->>Repo: Generated ID
    WriteService-->>API: CommandProcessingResult (clientId)
    API-->>UI: 200 OK ({ resourceId: clientId })
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

---

## [CLG] 콜그래프

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

### CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`

#### 그룹 생성 및 구성원 등록 흐름
> 공유: CLA, CLS

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (GroupViewComponent)
    participant API as GroupsApiResource
    participant WriteService as GroupingTypesWritePlatformService
    participant Repo as GroupRepository
    participant DB as m_group / m_group_client

    UI->>API: POST /v1/groups (name, officeId, clientMembers)
    API->>WriteService: createGroup(JsonCommand)
    WriteService->>Repo: save(GroupEntity)
    Repo->>DB: INSERT INTO m_group (...)
    Repo->>DB: INSERT INTO m_group_client (group_id, client_id)
    DB-->>Repo: Success
    WriteService-->>API: CommandProcessingResult (groupId)
    API-->>UI: 200 OK ({ resourceId: groupId })
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`

---

## [CLS] 콜그래프

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

### CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`

#### 일괄 수납 데이터 생성 및 전표 처리 흐름
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`
