# [OGB] 콜그래프

> 화면 1개 롤업(소분류 OGB, 대분류 OG - 지점 및 직원 관리).

## OGB-001 지점(Office) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`

### 신규 지점 등록 및 계층 생성 흐름

> 공유: SCU, TRT

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (OfficeFormComponent)
    participant API as OfficesApiResource
    participant WriteService as OfficeWritePlatformService
    participant Repo as OfficeRepository
    participant DB as m_office

    UI->>API: POST /v1/offices (name, parentId, openingDate)
    API->>WriteService: createOffice(JsonCommand)
    WriteService->>Repo: save(OfficeEntity)
    Repo->>DB: INSERT INTO m_office (name, parent_id, hierarchy)
    WriteService-->>API: CommandProcessingResult (officeId)
    API-->>UI: 200 OK
```

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`
