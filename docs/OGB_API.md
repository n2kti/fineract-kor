# [OGB] API명세서

> 화면 3개 롤업(소분류 OGB, 대분류 OG - 지점 및 직원 관리).

## OGB-001 지점(Office) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/api/OfficesApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/offices` | `OfficesApiResource.retrieveOffices` |
| `GET` | `/v1/offices/template` | `OfficesApiResource.retrieveOfficeTemplate` |
| `POST` | `/v1/offices` | `OfficesApiResource.createOffice` |
| `GET` | `/v1/offices/{officeId}` | `OfficesApiResource.retrieveOffice` |
| `GET` | `/v1/offices/external-id/{externalId}` | `OfficesApiResource` |
| `PUT` | `/v1/offices/{officeId}` | `OfficesApiResource.updateOffice` |
| `PUT` | `/v1/offices/external-id/{externalId}` | `OfficesApiResource` |
| `GET` | `/v1/offices/downloadtemplate` | `OfficesApiResource.getOfficeTemplate` |
| `POST` | `/v1/offices/uploadtemplate` | `OfficesApiResource.postOfficeTemplate` |

### `GET /v1/offices` - OfficesApiResource.retrieveOffices
- **설명**: `OfficesApiResource`의 `retrieveOffices` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/template` - OfficesApiResource.retrieveOfficeTemplate
- **설명**: `OfficesApiResource`의 `retrieveOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/offices` - OfficesApiResource.createOffice
- **설명**: `OfficesApiResource`의 `createOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/{officeId}` - OfficesApiResource.retrieveOffice
- **설명**: `OfficesApiResource`의 `retrieveOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/external-id/{externalId}` - OfficesApiResource
- **설명**: `OfficesApiResource`의 `retrieveOfficeByExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/offices/{officeId}` - OfficesApiResource.updateOffice
- **설명**: `OfficesApiResource`의 `updateOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/offices/external-id/{externalId}` - OfficesApiResource
- **설명**: `OfficesApiResource`의 `retrieveOfficeByExternalId` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/downloadtemplate` - OfficesApiResource.getOfficeTemplate
- **설명**: `OfficesApiResource`의 `getOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/offices/uploadtemplate` - OfficesApiResource.postOfficeTemplate
- **설명**: `OfficesApiResource`의 `postOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## OGB-002 직원(Staff) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/staff/api/StaffApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/staff` | `StaffApiResource.retrieveAll` |
| `GET` | `/v1/staff/{staffId}` | `StaffApiResource.retrieveOne` |
| `GET` | `/v1/staff/downloadtemplate` | `StaffApiResource.getTemplate` |
| `POST` | `/v1/staff` | `StaffApiResource.createStaff` |
| `PUT` | `/v1/staff/{staffId}` | `StaffApiResource.updateStaff` |
| `POST` | `/v1/staff/uploadtemplate` | `StaffApiResource.postTemplate` |

### `GET /v1/staff` - StaffApiResource.retrieveAll
- **설명**: `StaffApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/staff/{staffId}` - StaffApiResource.retrieveOne
- **설명**: `StaffApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/staff/downloadtemplate` - StaffApiResource.getTemplate
- **설명**: `StaffApiResource`의 `getTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/staff` - StaffApiResource.createStaff
- **설명**: `StaffApiResource`의 `createStaff` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/staff/{staffId}` - StaffApiResource.updateStaff
- **설명**: `StaffApiResource`의 `updateStaff` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/staff/uploadtemplate` - StaffApiResource.postTemplate
- **설명**: `StaffApiResource`의 `postTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## OGB-003 지점간 거래 및 포트폴리오 요약

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/api/OfficesApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/offices` | `OfficesApiResource.retrieveOffices` |
| `GET` | `/v1/offices/template` | `OfficesApiResource.retrieveOfficeTemplate` |
| `POST` | `/v1/offices` | `OfficesApiResource.createOffice` |
| `GET` | `/v1/offices/{officeId}` | `OfficesApiResource.retrieveOffice` |
| `GET` | `/v1/offices/external-id/{externalId}` | `OfficesApiResource` |
| `PUT` | `/v1/offices/{officeId}` | `OfficesApiResource.updateOffice` |
| `PUT` | `/v1/offices/external-id/{externalId}` | `OfficesApiResource` |
| `GET` | `/v1/offices/downloadtemplate` | `OfficesApiResource.getOfficeTemplate` |
| `POST` | `/v1/offices/uploadtemplate` | `OfficesApiResource.postOfficeTemplate` |

### `GET /v1/offices` - OfficesApiResource.retrieveOffices
- **설명**: `OfficesApiResource`의 `retrieveOffices` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/template` - OfficesApiResource.retrieveOfficeTemplate
- **설명**: `OfficesApiResource`의 `retrieveOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/offices` - OfficesApiResource.createOffice
- **설명**: `OfficesApiResource`의 `createOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/{officeId}` - OfficesApiResource.retrieveOffice
- **설명**: `OfficesApiResource`의 `retrieveOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/external-id/{externalId}` - OfficesApiResource
- **설명**: `OfficesApiResource`의 `retrieveOfficeByExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/offices/{officeId}` - OfficesApiResource.updateOffice
- **설명**: `OfficesApiResource`의 `updateOffice` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/offices/external-id/{externalId}` - OfficesApiResource
- **설명**: `OfficesApiResource`의 `retrieveOfficeByExternalId` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/offices/downloadtemplate` - OfficesApiResource.getOfficeTemplate
- **설명**: `OfficesApiResource`의 `getOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/offices/uploadtemplate` - OfficesApiResource.postOfficeTemplate
- **설명**: `OfficesApiResource`의 `postOfficeTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/office/api/OfficesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/staff/api/StaffApiResource.java`
