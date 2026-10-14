# [SYI] API명세서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

## SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/api/BulkImportApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/sms/api/SmsCampaignApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailCampaignApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/entityaccess/api/FineractEntityApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/imports` | `BulkImportApiResource.retrieveImportDocuments` |
| `GET` | `/v1/imports/getOutputTemplateLocation` | `BulkImportApiResource.retriveOutputTemplateLocation` |
| `GET` | `/v1/imports/downloadOutputTemplate` | `BulkImportApiResource.getOutputTemplate` |
| `GET` | `/v1/smscampaigns/template` | `SmsCampaignApiResource.template` |
| `POST` | `/v1/smscampaigns` | `SmsCampaignApiResource.createCampaign` |
| `GET` | `/v1/smscampaigns/{resourceId}` | `SmsCampaignApiResource.retrieveCampaign` |
| `GET` | `/v1/smscampaigns` | `SmsCampaignApiResource.retrieveAllEmails` |
| `PUT` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.updateCampaign` |
| `POST` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.handleCommands` |
| `POST` | `/v1/smscampaigns/preview` | `SmsCampaignApiResource.preview` |
| `DELETE` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.delete` |
| `GET` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.retrieveOneCampaign` |
| `GET` | `/v1/email/campaign` | `EmailCampaignApiResource.retrieveAllCampaign` |
| `POST` | `/v1/email/campaign` | `EmailCampaignApiResource.createCampaign` |
| `PUT` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.updateCampaign` |
| `POST` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.activate` |
| `POST` | `/v1/email/campaign/preview` | `EmailCampaignApiResource.preview` |
| `GET` | `/v1/email/campaign/template` | `EmailCampaignApiResource.template` |
| `GET` | `/v1/email/campaign/template/{resourceId}` | `EmailCampaignApiResource.retrieveOneTemplate` |
| `DELETE` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.delete` |
| `GET` | `/v1/email` | `EmailApiResource.retrieveAllEmails` |
| `GET` | `/v1/email/pendingEmail` | `EmailApiResource.retrievePendingEmail` |
| `GET` | `/v1/email/sentEmail` | `EmailApiResource.retrieveSentEmail` |
| `GET` | `/v1/email/messageByStatus` | `EmailApiResource.retrieveAllEmailByStatus` |
| `GET` | `/v1/email/failedEmail` | `EmailApiResource.retrieveFailedEmail` |
| `POST` | `/v1/email` | `EmailApiResource.create` |
| `GET` | `/v1/email/{resourceId}` | `EmailApiResource.retrieveOne` |
| `PUT` | `/v1/email/{resourceId}` | `EmailApiResource.update` |
| `DELETE` | `/v1/email/{resourceId}` | `EmailApiResource.delete` |
| `GET` | `/v1/email/configuration` | `EmailConfigurationApiResource.retrieveAll` |
| `PUT` | `/v1/email/configuration` | `EmailConfigurationApiResource.updateConfiguration` |
| `GET` | `/v1/entitytoentitymapping` | `FineractEntityApiResource.retrieveAll` |
| `GET` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.retrieveOne` |
| `GET` | `/v1/entitytoentitymapping/{mapId}/{fromId}/{toId}` | `FineractEntityApiResource.getEntityToEntityMappings` |
| `POST` | `/v1/entitytoentitymapping/{relId}` | `FineractEntityApiResource.createMap` |
| `PUT` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.updateMap` |
| `DELETE` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.delete` |

### `GET /v1/imports` - BulkImportApiResource.retrieveImportDocuments
- **설명**: `BulkImportApiResource`의 `retrieveImportDocuments` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entityType` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/imports/getOutputTemplateLocation` - BulkImportApiResource.retriveOutputTemplateLocation
- **설명**: `BulkImportApiResource`의 `retriveOutputTemplateLocation` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `importDocumentId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/imports/downloadOutputTemplate` - BulkImportApiResource.getOutputTemplate
- **설명**: `BulkImportApiResource`의 `getOutputTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `importDocumentId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/smscampaigns/template` - SmsCampaignApiResource.template
- **설명**: `SmsCampaignApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/smscampaigns` - SmsCampaignApiResource.createCampaign
- **설명**: `SmsCampaignApiResource`의 `createCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/smscampaigns/{resourceId}` - SmsCampaignApiResource.retrieveCampaign
- **설명**: `SmsCampaignApiResource`의 `retrieveCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/smscampaigns` - SmsCampaignApiResource.retrieveAllEmails
- **설명**: `SmsCampaignApiResource`의 `retrieveAllEmails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.updateCampaign
- **설명**: `SmsCampaignApiResource`의 `updateCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.handleCommands
- **설명**: `SmsCampaignApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/smscampaigns/preview` - SmsCampaignApiResource.preview
- **설명**: `SmsCampaignApiResource`의 `preview` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.delete
- **설명**: `SmsCampaignApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.retrieveOneCampaign
- **설명**: `EmailCampaignApiResource`의 `retrieveOneCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/campaign` - EmailCampaignApiResource.retrieveAllCampaign
- **설명**: `EmailCampaignApiResource`의 `retrieveAllCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/email/campaign` - EmailCampaignApiResource.createCampaign
- **설명**: `EmailCampaignApiResource`의 `createCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.updateCampaign
- **설명**: `EmailCampaignApiResource`의 `updateCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.activate
- **설명**: `EmailCampaignApiResource`의 `activate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/email/campaign/preview` - EmailCampaignApiResource.preview
- **설명**: `EmailCampaignApiResource`의 `preview` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/campaign/template` - EmailCampaignApiResource.template
- **설명**: `EmailCampaignApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/campaign/template/{resourceId}` - EmailCampaignApiResource.retrieveOneTemplate
- **설명**: `EmailCampaignApiResource`의 `retrieveOneTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.delete
- **설명**: `EmailCampaignApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email` - EmailApiResource.retrieveAllEmails
- **설명**: `EmailApiResource`의 `retrieveAllEmails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/pendingEmail` - EmailApiResource.retrievePendingEmail
- **설명**: `EmailApiResource`의 `retrievePendingEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/sentEmail` - EmailApiResource.retrieveSentEmail
- **설명**: `EmailApiResource`의 `retrieveSentEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/messageByStatus` - EmailApiResource.retrieveAllEmailByStatus
- **설명**: `EmailApiResource`의 `retrieveAllEmailByStatus` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `status` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
  - `fromDate` (QueryParam): `DateParam` 타입 식별자/필터
  - `toDate` (QueryParam): `DateParam` 타입 식별자/필터
  - `locale` (QueryParam): `String` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/failedEmail` - EmailApiResource.retrieveFailedEmail
- **설명**: `EmailApiResource`의 `retrieveFailedEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/email` - EmailApiResource.create
- **설명**: `EmailApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/{resourceId}` - EmailApiResource.retrieveOne
- **설명**: `EmailApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/email/{resourceId}` - EmailApiResource.update
- **설명**: `EmailApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/email/{resourceId}` - EmailApiResource.delete
- **설명**: `EmailApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/email/configuration` - EmailConfigurationApiResource.retrieveAll
- **설명**: `EmailConfigurationApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/email/configuration` - EmailConfigurationApiResource.updateConfiguration
- **설명**: `EmailConfigurationApiResource`의 `updateConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/entitytoentitymapping` - FineractEntityApiResource.retrieveAll
- **설명**: `FineractEntityApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.retrieveOne
- **설명**: `FineractEntityApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/entitytoentitymapping/{mapId}/{fromId}/{toId}` - FineractEntityApiResource.getEntityToEntityMappings
- **설명**: `FineractEntityApiResource`의 `getEntityToEntityMappings` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
  - `fromId` (PathParam): `Long` 타입 식별자/필터
  - `toId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/entitytoentitymapping/{relId}` - FineractEntityApiResource.createMap
- **설명**: `FineractEntityApiResource`의 `createMap` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `relId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.updateMap
- **설명**: `FineractEntityApiResource`의 `updateMap` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.delete
- **설명**: `FineractEntityApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/api/BulkImportApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailCampaignApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/sms/api/SmsCampaignApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/entityaccess/api/FineractEntityApiResource.java`
