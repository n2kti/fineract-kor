# [RPS] API명세서

> 화면 1개 롤업(소분류 RPS, 대분류 RP - 사회성과 관리).

## RPS-001 사회성과(SPM) 지표 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/SurveyApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/PovertyLineApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/LikelihoodApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/survey` | `SurveyApiResource.retrieveSurveys` |
| `GET` | `/v1/survey/{surveyName}` | `SurveyApiResource.retrieveSurvey` |
| `POST` | `/v1/survey/{surveyName}/{apptableId}` | `SurveyApiResource.createDatatableEntry` |
| `GET` | `/v1/survey/{surveyName}/{clientId}` | `SurveyApiResource.getClientSurveyOverview` |
| `GET` | `/v1/survey/{surveyName}/{clientId}/{entryId}` | `SurveyApiResource.getSurveyEntry` |
| `PUT` | `/v1/survey/register/{surveyName}/{apptable}` | `SurveyApiResource.register` |
| `DELETE` | `/v1/survey/{surveyName}/{clientId}/{fulfilledId}` | `SurveyApiResource.deleteDatatableEntries` |
| `GET` | `/v1/povertyLine/{ppiName}` | `PovertyLineApiResource.retrieveAll` |
| `GET` | `/v1/povertyLine/{ppiName}/{likelihoodId}` | `PovertyLineApiResource.retrieveAll` |
| `GET` | `/v1/likelihood/{ppiName}` | `LikelihoodApiResource.retrieveAll` |
| `GET` | `/v1/likelihood/{ppiName}/{likelihoodId}` | `LikelihoodApiResource.retrieve` |
| `PUT` | `/v1/likelihood/{ppiName}/{likelihoodId}` | `LikelihoodApiResource.update` |

### `GET /v1/survey` - SurveyApiResource.retrieveSurveys
- **설명**: `SurveyApiResource`의 `retrieveSurveys` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/survey/{surveyName}` - SurveyApiResource.retrieveSurvey
- **설명**: `SurveyApiResource`의 `retrieveSurvey` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/survey/{surveyName}/{apptableId}` - SurveyApiResource.createDatatableEntry
- **설명**: `SurveyApiResource`의 `createDatatableEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/survey/{surveyName}/{clientId}` - SurveyApiResource.getClientSurveyOverview
- **설명**: `SurveyApiResource`의 `getClientSurveyOverview` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `surveyName` (PathParam): `String` 타입 식별자/필터
  - `clientId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/survey/{surveyName}/{clientId}/{entryId}` - SurveyApiResource.getSurveyEntry
- **설명**: `SurveyApiResource`의 `getSurveyEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `surveyName` (PathParam): `String` 타입 식별자/필터
  - `clientId` (PathParam): `Long` 타입 식별자/필터
  - `entryId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/survey/register/{surveyName}/{apptable}` - SurveyApiResource.register
- **설명**: `SurveyApiResource`의 `register` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `surveyName` (PathParam): `String` 타입 식별자/필터
  - `apptable` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/survey/{surveyName}/{clientId}/{fulfilledId}` - SurveyApiResource.deleteDatatableEntries
- **설명**: `SurveyApiResource`의 `deleteDatatableEntries` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `surveyName` (PathParam): `String` 타입 식별자/필터
  - `clientId` (PathParam): `Long` 타입 식별자/필터
  - `fulfilledId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/povertyLine/{ppiName}` - PovertyLineApiResource.retrieveAll
- **설명**: `PovertyLineApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `ppiName` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/povertyLine/{ppiName}/{likelihoodId}` - PovertyLineApiResource.retrieveAll
- **설명**: `PovertyLineApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `ppiName` (PathParam): `String` 타입 식별자/필터
  - `likelihoodId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/likelihood/{ppiName}` - LikelihoodApiResource.retrieveAll
- **설명**: `LikelihoodApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `ppiName` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/likelihood/{ppiName}/{likelihoodId}` - LikelihoodApiResource.retrieve
- **설명**: `LikelihoodApiResource`의 `retrieve` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `likelihoodId` (PathParam): `Long` 타입 식별자/필터
  - `ppiName` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/likelihood/{ppiName}/{likelihoodId}` - LikelihoodApiResource.update
- **설명**: `LikelihoodApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `likelihoodId` (PathParam): `Long` 타입 식별자/필터
  - `ppiName` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/LikelihoodApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/PovertyLineApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/survey/api/SurveyApiResource.java`
