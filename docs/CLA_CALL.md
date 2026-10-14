# [CLA] 콜그래프

> 화면 2개 롤업(소분류 CLA, 대분류 CL - 고객 관리).

## CLA-001 고객 목록 및 검색

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

### 고객 목록 조회 및 검색 흐름
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

## CLA-002 고객 등록 및 상세정보

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`

### 신규 고객 등록 및 유효성 검증 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/`
