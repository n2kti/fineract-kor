# [SC] API명세서 (보안승인)

> 소분류 2개 롤업.


---

## [SCU] API명세서

> 화면 3개 롤업(소분류 SCU, 대분류 SC - 사용자 및 권한 관리).

### SCU-001 사용자 계정 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/UsersApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/users` | `UsersApiResource.retrieveAll` |
| `GET` | `/v1/users/{userId}` | `UsersApiResource.retrieveOne` |
| `GET` | `/v1/users/template` | `UsersApiResource.template` |
| `POST` | `/v1/users` | `UsersApiResource.create` |
| `PUT` | `/v1/users/{userId}` | `UsersApiResource.update` |
| `POST` | `/v1/users/{userId}/pwd` | `UsersApiResource.changePassword` |
| `DELETE` | `/v1/users/{userId}` | `UsersApiResource.delete` |
| `GET` | `/v1/users/downloadtemplate` | `UsersApiResource.getUserTemplate` |
| `POST` | `/v1/users/uploadtemplate` | `UsersApiResource.postUsersTemplate` |

#### `GET /v1/users` - UsersApiResource.retrieveAll
- **설명**: `UsersApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/users/{userId}` - UsersApiResource.retrieveOne
- **설명**: `UsersApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/users/template` - UsersApiResource.template
- **설명**: `UsersApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/users` - UsersApiResource.create
- **설명**: `UsersApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/users/{userId}` - UsersApiResource.update
- **설명**: `UsersApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/users/{userId}/pwd` - UsersApiResource.changePassword
- **설명**: `UsersApiResource`의 `changePassword` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/users/{userId}` - UsersApiResource.delete
- **설명**: `UsersApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/users/downloadtemplate` - UsersApiResource.getUserTemplate
- **설명**: `UsersApiResource`의 `getUserTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/users/uploadtemplate` - UsersApiResource.postUsersTemplate
- **설명**: `UsersApiResource`의 `postUsersTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### SCU-002 역할 및 권한 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/RolesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/useradministration/api/PermissionsApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/roles` | `RolesApiResource.retrieveAllRoles` |
| `POST` | `/v1/roles` | `RolesApiResource.createRole` |
| `GET` | `/v1/roles/{roleId}` | `RolesApiResource.retrieveRole` |
| `POST` | `/v1/roles/{roleId}` | `RolesApiResource.actionsOnRoles` |
| `PUT` | `/v1/roles/{roleId}` | `RolesApiResource.updateRole` |
| `GET` | `/v1/roles/{roleId}/permissions` | `RolesApiResource.retrieveRolePermissions` |
| `PUT` | `/v1/roles/{roleId}/permissions` | `RolesApiResource.updateRolePermissions` |
| `DELETE` | `/v1/roles/{roleId}` | `RolesApiResource.deleteRole` |
| `GET` | `/v1/permissions` | `PermissionsApiResource.retrieveAllPermissions` |
| `PUT` | `/v1/permissions` | `PermissionsApiResource.updatePermissionsDetails` |

#### `GET /v1/roles` - RolesApiResource.retrieveAllRoles
- **설명**: `RolesApiResource`의 `retrieveAllRoles` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/roles` - RolesApiResource.createRole
- **설명**: `RolesApiResource`의 `createRole` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/roles/{roleId}` - RolesApiResource.retrieveRole
- **설명**: `RolesApiResource`의 `retrieveRole` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/roles/{roleId}` - RolesApiResource.actionsOnRoles
- **설명**: `RolesApiResource`의 `actionsOnRoles` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/roles/{roleId}` - RolesApiResource.updateRole
- **설명**: `RolesApiResource`의 `updateRole` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/roles/{roleId}/permissions` - RolesApiResource.retrieveRolePermissions
- **설명**: `RolesApiResource`의 `retrieveRolePermissions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/roles/{roleId}/permissions` - RolesApiResource.updateRolePermissions
- **설명**: `RolesApiResource`의 `updateRolePermissions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/roles/{roleId}` - RolesApiResource.deleteRole
- **설명**: `RolesApiResource`의 `deleteRole` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/permissions` - PermissionsApiResource.retrieveAllPermissions
- **설명**: `PermissionsApiResource`의 `retrieveAllPermissions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/permissions` - PermissionsApiResource.updatePermissionsDetails
- **설명**: `PermissionsApiResource`의 `updatePermissionsDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### SCU-003 보안 정책 및 2단계 인증

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/PasswordPreferencesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/useradministration/api/ForgotPasswordApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/template` | `PasswordPreferencesApiResource.retrieve` |
| `PUT` | `/v1/template` | `PasswordPreferencesApiResource.update` |
| `GET` | `/v1/template/template` | `PasswordPreferencesApiResource.template` |
| `POST` | `/v1/password/forgot` | `ForgotPasswordApiResource.forgotPassword` |

#### `GET /v1/template` - PasswordPreferencesApiResource.retrieve
- **설명**: `PasswordPreferencesApiResource`의 `retrieve` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/template` - PasswordPreferencesApiResource.update
- **설명**: `PasswordPreferencesApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/template/template` - PasswordPreferencesApiResource.template
- **설명**: `PasswordPreferencesApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/password/forgot` - ForgotPasswordApiResource.forgotPassword
- **설명**: `ForgotPasswordApiResource`의 `forgotPassword` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/ForgotPasswordApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/PasswordPreferencesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/PermissionsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/RolesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/api/UsersApiResource.java`

---

## [SCA] API명세서

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

### SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-provider/src/main/java/org/apache/fineract/commands/api/AuditsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/commands/api/MakercheckersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/api/HookApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/audits` - AuditsApiResource.retrieveAuditEntries
- **설명**: `AuditsApiResource`의 `retrieveAuditEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/audits/{auditId}` - AuditsApiResource.retrieveAuditEntry
- **설명**: `AuditsApiResource`의 `retrieveAuditEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/audits/searchtemplate` - AuditsApiResource.retrieveAuditSearchTemplate
- **설명**: `AuditsApiResource`의 `retrieveAuditSearchTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/makercheckers` - MakercheckersApiResource.retrieveCommands
- **설명**: `MakercheckersApiResource`의 `retrieveCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/makercheckers/searchtemplate` - MakercheckersApiResource.retrieveAuditSearchTemplate
- **설명**: `MakercheckersApiResource`의 `retrieveAuditSearchTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/makercheckers/{auditId}` - MakercheckersApiResource.approveMakerCheckerEntry
- **설명**: `MakercheckersApiResource`의 `approveMakerCheckerEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/makercheckers/{auditId}` - MakercheckersApiResource.deleteMakerCheckerEntry
- **설명**: `MakercheckersApiResource`의 `deleteMakerCheckerEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/hooks` - HookApiResource.retrieveHooks
- **설명**: `HookApiResource`의 `retrieveHooks` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/hooks/{hookId}` - HookApiResource.retrieveHook
- **설명**: `HookApiResource`의 `retrieveHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/hooks/template` - HookApiResource.template
- **설명**: `HookApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/hooks` - HookApiResource.createHook
- **설명**: `HookApiResource`의 `createHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/hooks/{hookId}` - HookApiResource.updateHook
- **설명**: `HookApiResource`의 `updateHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/hooks/{hookId}` - HookApiResource.deleteHook
- **설명**: `HookApiResource`의 `deleteHook` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/commands/api/AuditsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/commands/api/MakercheckersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/hooks/api/HookApiResource.java`
