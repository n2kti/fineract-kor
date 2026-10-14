# [CLG] API명세서

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

## CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/CentersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsLevelApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/groups/template` | `GroupsApiResource.retrieveTemplate` |
| `GET` | `/v1/groups` | `GroupsApiResource.retrieveAll` |
| `GET` | `/v1/groups/{groupId}` | `GroupsApiResource.retrieveOne` |
| `POST` | `/v1/groups` | `GroupsApiResource.create` |
| `POST` | `/v1/groups/{groupId}/command/unassign_staff` | `GroupsApiResource.unassignLoanOfficer` |
| `PUT` | `/v1/groups/{groupId}` | `GroupsApiResource.update` |
| `DELETE` | `/v1/groups/{groupId}` | `GroupsApiResource.delete` |
| `POST` | `/v1/groups/{groupId}` | `GroupsApiResource.activateOrGenerateCollectionSheet` |
| `GET` | `/v1/groups/{groupId}/accounts` | `GroupsApiResource.retrieveAccounts` |
| `GET` | `/v1/groups/downloadtemplate` | `GroupsApiResource.getGroupsTemplate` |
| `POST` | `/v1/groups/uploadtemplate` | `GroupsApiResource.postGroupTemplate` |
| `GET` | `/v1/groups/{groupId}/glimaccounts` | `GroupsApiResource.retrieveglimAccounts` |
| `GET` | `/v1/groups/{groupId}/gsimaccounts` | `GroupsApiResource.retrieveGsimAccounts` |
| `GET` | `/v1/centers/template` | `CentersApiResource.retrieveTemplate` |
| `GET` | `/v1/centers` | `CentersApiResource.retrieveAll` |
| `GET` | `/v1/centers/{centerId}` | `CentersApiResource.retrieveOne` |
| `POST` | `/v1/centers` | `CentersApiResource.create` |
| `PUT` | `/v1/centers/{centerId}` | `CentersApiResource.update` |
| `DELETE` | `/v1/centers/{centerId}` | `CentersApiResource.delete` |
| `POST` | `/v1/centers/{centerId}` | `CentersApiResource.activate` |
| `GET` | `/v1/centers/{centerId}/accounts` | `CentersApiResource.retrieveGroupAccount` |
| `GET` | `/v1/centers/downloadtemplate` | `CentersApiResource.getCentersTemplate` |
| `POST` | `/v1/centers/uploadtemplate` | `CentersApiResource.postCentersTemplate` |
| `GET` | `/v1/grouplevels` | `GroupsLevelApiResource.retrieveAllGroups` |

### `GET /v1/groups/template` - GroupsApiResource.retrieveTemplate
- **설명**: `GroupsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups` - GroupsApiResource.retrieveAll
- **설명**: `GroupsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups/{groupId}` - GroupsApiResource.retrieveOne
- **설명**: `GroupsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/groups` - GroupsApiResource.create
- **설명**: `GroupsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/groups/{groupId}/command/unassign_staff` - GroupsApiResource.unassignLoanOfficer
- **설명**: `GroupsApiResource`의 `unassignLoanOfficer` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/groups/{groupId}` - GroupsApiResource.update
- **설명**: `GroupsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/groups/{groupId}` - GroupsApiResource.delete
- **설명**: `GroupsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/groups/{groupId}` - GroupsApiResource.activateOrGenerateCollectionSheet
- **설명**: `GroupsApiResource`의 `activateOrGenerateCollectionSheet` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups/{groupId}/accounts` - GroupsApiResource.retrieveAccounts
- **설명**: `GroupsApiResource`의 `retrieveAccounts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups/downloadtemplate` - GroupsApiResource.getGroupsTemplate
- **설명**: `GroupsApiResource`의 `getGroupsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/groups/uploadtemplate` - GroupsApiResource.postGroupTemplate
- **설명**: `GroupsApiResource`의 `postGroupTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups/{groupId}/glimaccounts` - GroupsApiResource.retrieveglimAccounts
- **설명**: `GroupsApiResource`의 `retrieveglimAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `groupId` (PathParam): `Long` 타입 식별자/필터
  - `parentLoanAccountNo` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/groups/{groupId}/gsimaccounts` - GroupsApiResource.retrieveGsimAccounts
- **설명**: `GroupsApiResource`의 `retrieveGsimAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `groupId` (PathParam): `Long` 타입 식별자/필터
  - `parentGSIMAccountNo` (QueryParam): `String` 타입 식별자/필터
  - `parentGSIMId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/centers/template` - CentersApiResource.retrieveTemplate
- **설명**: `CentersApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/centers` - CentersApiResource.retrieveAll
- **설명**: `CentersApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/centers/{centerId}` - CentersApiResource.retrieveOne
- **설명**: `CentersApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/centers` - CentersApiResource.create
- **설명**: `CentersApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/centers/{centerId}` - CentersApiResource.update
- **설명**: `CentersApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/centers/{centerId}` - CentersApiResource.delete
- **설명**: `CentersApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/centers/{centerId}` - CentersApiResource.activate
- **설명**: `CentersApiResource`의 `activate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/centers/{centerId}/accounts` - CentersApiResource.retrieveGroupAccount
- **설명**: `CentersApiResource`의 `retrieveGroupAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/centers/downloadtemplate` - CentersApiResource.getCentersTemplate
- **설명**: `CentersApiResource`의 `getCentersTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/centers/uploadtemplate` - CentersApiResource.postCentersTemplate
- **설명**: `CentersApiResource`의 `postCentersTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/grouplevels` - GroupsLevelApiResource.retrieveAllGroups
- **설명**: `GroupsLevelApiResource`의 `retrieveAllGroups` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/CentersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsLevelApiResource.java`
