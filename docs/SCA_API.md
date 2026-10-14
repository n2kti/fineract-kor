# [SCA] API명세서

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

## SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-provider/src/main/java/org/apache/fineract/commands/api/AuditsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/commands/api/MakercheckersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/api/HookApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/audits` | `AuditsApiResource.retrieveAuditEntries` |
| `GET` | `/v1/audits/{auditId}` | `AuditsApiResource.retrieveAuditEntry` |
| `GET` | `/v1/audits/searchtemplate` | `AuditsApiResource.retrieveAuditSearchTemplate` |
| `GET` | `/v1/makercheckers` | `MakercheckersApiResource.retrieveCommands` |
| `GET` | `/v1/makercheckers/searchtemplate` | `MakercheckersApiResource.retrieveAuditSearchTemplate` |
| `POST` | `/v1/makercheckers/{auditId}` | `MakercheckersApiResource.approveMakerCheckerEntry` |
| `DELETE` | `/v1/makercheckers/{auditId}` | `MakercheckersApiResource.deleteMakerCheckerEntry` |
| `GET` | `/v1/hooks` | `HookApiResource.retrieveHooks` |
| `GET` | `/v1/hooks/{hookId}` | `HookApiResource.retrieveHook` |
| `GET` | `/v1/hooks/template` | `HookApiResource.template` |
| `POST` | `/v1/hooks` | `HookApiResource.createHook` |
| `PUT` | `/v1/hooks/{hookId}` | `HookApiResource.updateHook` |
| `DELETE` | `/v1/hooks/{hookId}` | `HookApiResource.deleteHook` |

### `GET /v1/audits` - AuditsApiResource.retrieveAuditEntries
- **설명**: `AuditsApiResource`의 `retrieveAuditEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/audits/{auditId}` - AuditsApiResource.retrieveAuditEntry
- **설명**: `AuditsApiResource`의 `retrieveAuditEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/audits/searchtemplate` - AuditsApiResource.retrieveAuditSearchTemplate
- **설명**: `AuditsApiResource`의 `retrieveAuditSearchTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/makercheckers` - MakercheckersApiResource.retrieveCommands
- **설명**: `MakercheckersApiResource`의 `retrieveCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/makercheckers/searchtemplate` - MakercheckersApiResource.retrieveAuditSearchTemplate
- **설명**: `MakercheckersApiResource`의 `retrieveAuditSearchTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/makercheckers/{auditId}` - MakercheckersApiResource.approveMakerCheckerEntry
- **설명**: `MakercheckersApiResource`의 `approveMakerCheckerEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/makercheckers/{auditId}` - MakercheckersApiResource.deleteMakerCheckerEntry
- **설명**: `MakercheckersApiResource`의 `deleteMakerCheckerEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/hooks` - HookApiResource.retrieveHooks
- **설명**: `HookApiResource`의 `retrieveHooks` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/hooks/{hookId}` - HookApiResource.retrieveHook
- **설명**: `HookApiResource`의 `retrieveHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/hooks/template` - HookApiResource.template
- **설명**: `HookApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/hooks` - HookApiResource.createHook
- **설명**: `HookApiResource`의 `createHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/hooks/{hookId}` - HookApiResource.updateHook
- **설명**: `HookApiResource`의 `updateHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/hooks/{hookId}` - HookApiResource.deleteHook
- **설명**: `HookApiResource`의 `deleteHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/commands/api/AuditsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/commands/api/MakercheckersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/api/HookApiResource.java`
