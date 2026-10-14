# [SYI] 콜그래프

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

## SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`

### 엑셀 일괄 업로드(Bulk Import) 파싱 및 비동기 임포트 흐름

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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/`
