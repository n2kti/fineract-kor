# [CLG] 콜그래프

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

## CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`

### 그룹 생성 및 구성원 등록 흐름
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`
