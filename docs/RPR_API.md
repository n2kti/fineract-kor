# [RPR] API명세서

> 화면 2개 롤업(소분류 RPR, 대분류 RP - 보고서 및 조회).

## RPR-001 보고서 조회 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/ReportsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/RunreportsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/reports` | `ReportsApiResource.retrieveReportList` |
| `GET` | `/v1/reports/{id}` | `ReportsApiResource.retrieveReport` |
| `GET` | `/v1/reports/template` | `ReportsApiResource.retrieveOfficeTemplate` |
| `POST` | `/v1/reports` | `ReportsApiResource.createReport` |
| `PUT` | `/v1/reports/{id}` | `ReportsApiResource.updateReport` |
| `DELETE` | `/v1/reports/{id}` | `ReportsApiResource.deleteReport` |
| `GET` | `/v1/runreports/availableExports/{reportName}` | `RunreportsApiResource.retrieveAllAvailableExports` |
| `GET` | `/v1/runreports/{reportName}` | `RunreportsApiResource.runReport` |

### `GET /v1/reports` - ReportsApiResource.retrieveReportList
- **설명**: `ReportsApiResource`의 `retrieveReportList` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/reports/{id}` - ReportsApiResource.retrieveReport
- **설명**: `ReportsApiResource`의 `retrieveReport` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/reports/template` - ReportsApiResource.retrieveOfficeTemplate
- **설명**: `ReportsApiResource`의 `retrieveOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/reports` - ReportsApiResource.createReport
- **설명**: `ReportsApiResource`의 `createReport` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/reports/{id}` - ReportsApiResource.updateReport
- **설명**: `ReportsApiResource`의 `updateReport` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/reports/{id}` - ReportsApiResource.deleteReport
- **설명**: `ReportsApiResource`의 `deleteReport` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/runreports/availableExports/{reportName}` - RunreportsApiResource.retrieveAllAvailableExports
- **설명**: `RunreportsApiResource`의 `retrieveAllAvailableExports` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/runreports/{reportName}` - RunreportsApiResource.runReport
- **설명**: `RunreportsApiResource`의 `runReport` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## RPR-002 보고서 정의 및 메일링 작업

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/reportmailingjob/api/ReportMailingJobApiResource.java, fineract-provider/src/main/java/org/apache/fineract/adhocquery/api/AdHocApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/{entityId}` | `ReportMailingJobApiResource.createReportMailingJob` |
| `PUT` | `/v1/{entityId}/{entityId}` | `ReportMailingJobApiResource.updateReportMailingJob` |
| `DELETE` | `/v1/{entityId}/{entityId}` | `ReportMailingJobApiResource.deleteReportMailingJob` |
| `GET` | `/v1/{entityId}/{entityId}` | `ReportMailingJobApiResource.retrieveReportMailingJob` |
| `GET` | `/v1/{entityId}/template` | `ReportMailingJobApiResource.retrieveReportMailingJobTemplate` |
| `GET` | `/v1/{entityId}` | `ReportMailingJobApiResource.retrieveAllReportMailingJobs` |
| `GET` | `/v1/adhocquery` | `AdHocApiResource.retrieveAll` |
| `GET` | `/v1/adhocquery/template` | `AdHocApiResource.template` |
| `POST` | `/v1/adhocquery` | `AdHocApiResource.createAdHocQuery` |
| `GET` | `/v1/adhocquery/{adHocId}` | `AdHocApiResource.retrieveAdHocQuery` |
| `PUT` | `/v1/adhocquery/{adHocId}` | `AdHocApiResource.update` |
| `DELETE` | `/v1/adhocquery/{adHocId}` | `AdHocApiResource.deleteAdHocQuery` |

### `POST /v1/{entityId}` - ReportMailingJobApiResource.createReportMailingJob
- **설명**: `ReportMailingJobApiResource`의 `createReportMailingJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/{entityId}/{entityId}` - ReportMailingJobApiResource.updateReportMailingJob
- **설명**: `ReportMailingJobApiResource`의 `updateReportMailingJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/{entityId}/{entityId}` - ReportMailingJobApiResource.deleteReportMailingJob
- **설명**: `ReportMailingJobApiResource`의 `deleteReportMailingJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/{entityId}/{entityId}` - ReportMailingJobApiResource.retrieveReportMailingJob
- **설명**: `ReportMailingJobApiResource`의 `retrieveReportMailingJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/{entityId}/template` - ReportMailingJobApiResource.retrieveReportMailingJobTemplate
- **설명**: `ReportMailingJobApiResource`의 `retrieveReportMailingJobTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/{entityId}` - ReportMailingJobApiResource.retrieveAllReportMailingJobs
- **설명**: `ReportMailingJobApiResource`의 `retrieveAllReportMailingJobs` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/adhocquery` - AdHocApiResource.retrieveAll
- **설명**: `AdHocApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/adhocquery/template` - AdHocApiResource.template
- **설명**: `AdHocApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/adhocquery` - AdHocApiResource.createAdHocQuery
- **설명**: `AdHocApiResource`의 `createAdHocQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/adhocquery/{adHocId}` - AdHocApiResource.retrieveAdHocQuery
- **설명**: `AdHocApiResource`의 `retrieveAdHocQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/adhocquery/{adHocId}` - AdHocApiResource.update
- **설명**: `AdHocApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/adhocquery/{adHocId}` - AdHocApiResource.deleteAdHocQuery
- **설명**: `AdHocApiResource`의 `deleteAdHocQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/adhocquery/api/AdHocApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/ReportsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/RunreportsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/reportmailingjob/api/ReportMailingJobApiResource.java`
