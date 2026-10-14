# [RP] 콜그래프 (보고서통계)

> 소분류 2개 롤업.


---

## [RPR] 콜그래프

> 화면 1개 롤업(소분류 RPR, 대분류 RP - 보고서 및 조회).

### RPR-001 보고서 조회 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/`

#### 동적 SQL 보고서 파라미터 바인딩 및 실행 흐름

> 공유: LNA, SVA, ACC

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (RunReportComponent)
    participant API as RunreportsApiResource
    participant ReadService as ReadReportingService
    participant DB as stretchy_report / OLAP Views

    UI->>API: GET /v1/runreports/{reportName}?R_officeId=1&R_startDate=...
    API->>ReadService: retrieveReport(reportName, queryParams)
    ReadService->>DB: SELECT report_sql FROM stretchy_report WHERE report_name = ?
    DB-->>ReadService: SQL Template
    ReadService->>ReadService: bindParameters(sqlTemplate, queryParams)
    ReadService->>DB: executeDynamicSQL(...)
    DB-->>ReadService: GenericResultset
    ReadService-->>API: ReportData DTO
    API-->>UI: 200 OK (Report JSON / Export Stream)
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/`

---

## [RPS] 콜그래프

> 화면 1개 롤업(소분류 RPS, 대분류 RP - 사회성과 관리).

### RPS-001 사회성과(SPM) 지표 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/spm/`

#### 고객 사회성과 설문조사(PPI) 응답 등록 및 빈곤확률 산출 흐름

> 공유: CLA

```mermaid
sequenceDiagram
    autonumber
    participant UI as Angular UI (SpmSurveysFormComponent)
    participant API as SurveyApiResource
    participant WriteService as SpmService
    participant DB as m_surveys / m_survey_scorecards / ppi_likelihoods

    UI->>API: POST /v1/surveys/{surveyName}/{clientId} (질문별 응답 JSON)
    API->>WriteService: recordScorecard(surveyName, clientId, responses)
    WriteService->>WriteService: calculateTotalScore(responses)
    WriteService->>DB: SELECT likelihood FROM ppi_likelihoods WHERE score = ?
    DB-->>WriteService: Likelihood Matrix
    WriteService->>DB: INSERT INTO m_survey_scorecards (client_id, survey_id, score, likelihood)
    WriteService-->>API: CommandProcessingResult
    API-->>UI: 200 OK
```

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/spm/`
