# [SY] 콜그래프 (시스템운영)

> 소분류 3개 롤업.


---

## [SYC] 콜그래프

> 화면 1개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

### SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`

#### 공통 코드값(Code Value) 추가 및 캐시 갱신 흐름

> 공유: CLA, LNA, SVA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (CodeValuesListComponent)
    participant API as CodeValuesApiResource
    participant WriteService as CodeValueWritePlatformService
    participant DB as m_code_value

    UI->>API: POST /v1/codes/{codeId}/codevalues (name, position)
    API->>WriteService: createCodeValue(codeId, JsonCommand)
    WriteService->>DB: INSERT INTO m_code_value (code_id, code_value, order_position)
    WriteService-->>API: CommandProcessingResult (codeValueId)
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`

---

## [SYB] 콜그래프

> 화면 1개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

### SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`

#### 배치 작업 즉시 실행(Run Job) 및 이력 기록 흐름

> 공유: LNA, SVA, ACP, WCO

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (SchedulerJobsListComponent)
    participant API as SchedulerJobApiResource
    participant SchedService as SchedularWritePlatformService
    participant JobRunner as SchedularWritePlatformService
    participant DB as job / job_run_history

    UI->>API: POST /v1/jobs/{jobId}?command=executeJob
    API->>SchedService: executeJob(jobId)
    SchedService->>DB: INSERT INTO job_run_history (status: RUNNING)
    SchedService->>JobRunner: execute(jobDetails)
    JobRunner-->>SchedService: Job Complete (SUCCESS / FAILED)
    SchedService->>DB: UPDATE job_run_history SET status = SUCCESS, end_time = ?
    SchedService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/`

---

## [SYI] 콜그래프

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

### SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`

#### 엑셀 일괄 업로드(Bulk Import) 파싱 및 비동기 임포트 흐름

> 공유: CLA, LNA, SVA, ACC

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (BulkImportComponent)
    participant API as BulkImportApiResource
    participant ImportService as BulkImportWorkbookService
    participant Parser as BulkImportWorkbookPopulatorService
    participant CommandDispatcher as PortfolioCommandSourceWritePlatformService
    participant DB as m_import_document

    UI->>API: POST /v1/imports/{entityType} (Multipart Excel File)
    API->>ImportService: importWorkbook(entityType, file)
    ImportService->>DB: INSERT INTO m_import_document (status: PROCESSING)
    ImportService->>Parser: parseRows(file)
    loop Each Row in Workbook
        Parser->>CommandDispatcher: dispatchCreateCommand(rowPayload)
    end
    ImportService->>DB: UPDATE m_import_document SET status = COMPLETED, total_records = ...
    ImportService-->>API: CommandProcessingResult (documentId)
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`
