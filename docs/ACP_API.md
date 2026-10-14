# [ACP] API명세서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

## ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#provisioningent, fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/provisioningentries` | `ProvisioningEntriesApiResource.retrieveAllProvisioningEntries` |
| `POST` | `/v1/provisioningentries` | `ProvisioningEntriesApiResource.createProvisioningEntries` |
| `GET` | `/v1/provisioningentries/{entryId}` | `ProvisioningEntriesApiResource.retrieveProvisioningEntry` |
| `POST` | `/v1/provisioningentries/{entryId}?command=createjournalentry` | `ProvisioningEntriesApiResource.modifyProvisioningEntry` |
| `GET` | `/v1/provisioningcriteria/template` | `ProvisioningCriteriaApiResource.retrieveTemplate` |
| `GET` | `/v1/provisioningcriteria/{criteriaId}` | `ProvisioningCriteriaApiResource.retrieveProvisioningCriteria` |
| `GET` | `/v1/provisioningcriteria` | `ProvisioningCriteriaApiResource.retrieveAllProvisioningCriterias` |
| `POST` | `/v1/provisioningcriteria` | `ProvisioningCriteriaApiResource.createProvisioningCriteria` |
| `PUT` | `/v1/provisioningcriteria/{criteriaId}` | `ProvisioningCriteriaApiResource.updateProvisioningCriteria` |
| `DELETE` | `/v1/provisioningcriteria/{criteriaId}` | `ProvisioningCriteriaApiResource.deleteProvisioningCriteria` |

### `GET /v1/provisioningentries` - ProvisioningEntriesApiResource.retrieveAllProvisioningEntries
- **설명**: `ProvisioningEntriesApiResource`의 `retrieveAllProvisioningEntries` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/provisioningentries` - ProvisioningEntriesApiResource.createProvisioningEntries
- **설명**: `ProvisioningEntriesApiResource`의 `createProvisioningEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/provisioningentries/{entryId}` - ProvisioningEntriesApiResource.retrieveProvisioningEntry
- **설명**: `ProvisioningEntriesApiResource`의 `retrieveProvisioningEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entryId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/provisioningentries/{entryId}?command=createjournalentry` - ProvisioningEntriesApiResource.modifyProvisioningEntry
- **설명**: `ProvisioningEntriesApiResource`의 `modifyProvisioningEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entryId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/provisioningcriteria/template` - ProvisioningCriteriaApiResource.retrieveTemplate
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.retrieveProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/provisioningcriteria` - ProvisioningCriteriaApiResource.retrieveAllProvisioningCriterias
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveAllProvisioningCriterias` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/provisioningcriteria` - ProvisioningCriteriaApiResource.createProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `createProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.updateProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `updateProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.deleteProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `deleteProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
