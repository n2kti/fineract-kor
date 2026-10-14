# [ACC] API명세서

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

## ACC-001 계정과목표(COA) 관리

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#glaccountsapire`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/glaccounts` | `GLAccountsApiResource.retrieveAllAccounts` |
| `POST` | `/v1/glaccounts` | `GLAccountsApiResource.createGLAccount` |
| `GET` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.retreiveAccount` |
| `PUT` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.updateGLAccount` |
| `DELETE` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.deleteGLAccount` |

### `GET /v1/glaccounts` - GLAccountsApiResource.retrieveAllAccounts
- **설명**: `GLAccountsApiResource`의 `retrieveAllAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `type` (QueryParam): `Integer` 타입 식별자/필터
  - `usage` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/glaccounts` - GLAccountsApiResource.createGLAccount
- **설명**: `GLAccountsApiResource`의 `createGLAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.retreiveAccount
- **설명**: `GLAccountsApiResource`의 `retreiveAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.updateGLAccount
- **설명**: `GLAccountsApiResource`의 `updateGLAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.deleteGLAccount
- **설명**: `GLAccountsApiResource`의 `deleteGLAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/journalentries` | `JournalEntriesApiResource.retrieveAll` |
| `GET` | `/v1/journalentries/{journalEntryId}` | `JournalEntriesApiResource.retrieveJournalEntryById` |
| `POST` | `/v1/journalentries` | `JournalEntriesApiResource.createGLJournalEntry` |
| `POST` | `/v1/journalentries/{transactionId}` | `JournalEntriesApiResource.createReversalJournalEntry` |
| `GET` | `/v1/journalentries/provisioning` | `JournalEntriesApiResource.retrieveJournalEntries` |
| `GET` | `/v1/journalentries/openingbalance` | `JournalEntriesApiResource.retrieveOpeningBalance` |
| `GET` | `/v1/journalentries/downloadtemplate` | `JournalEntriesApiResource.getJournalEntriesTemplate` |
| `POST` | `/v1/journalentries/uploadtemplate` | `JournalEntriesApiResource.postJournalEntriesTemplate` |

### `GET /v1/journalentries` - JournalEntriesApiResource.retrieveAll
- **설명**: `JournalEntriesApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/journalentries/{journalEntryId}` - JournalEntriesApiResource.retrieveJournalEntryById
- **설명**: `JournalEntriesApiResource`의 `retrieveJournalEntryById` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/journalentries` - JournalEntriesApiResource.createGLJournalEntry
- **설명**: `JournalEntriesApiResource`의 `createGLJournalEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/journalentries/{transactionId}` - JournalEntriesApiResource.createReversalJournalEntry
- **설명**: `JournalEntriesApiResource`의 `createReversalJournalEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/journalentries/provisioning` - JournalEntriesApiResource.retrieveJournalEntries
- **설명**: `JournalEntriesApiResource`의 `retrieveJournalEntries` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `entryId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/journalentries/openingbalance` - JournalEntriesApiResource.retrieveOpeningBalance
- **설명**: `JournalEntriesApiResource`의 `retrieveOpeningBalance` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `currencyCode` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/journalentries/downloadtemplate` - JournalEntriesApiResource.getJournalEntriesTemplate
- **설명**: `JournalEntriesApiResource`의 `getJournalEntriesTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/journalentries/uploadtemplate` - JournalEntriesApiResource.postJournalEntriesTemplate
- **설명**: `JournalEntriesApiResource`의 `postJournalEntriesTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## ACC-003 기초잔액 등록

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#glclosuresapire`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/glclosures` | `GLClosuresApiResource.retrieveAllClosures` |
| `POST` | `/v1/glclosures` | `GLClosuresApiResource.createGLClosure` |
| `GET` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.retreiveClosure` |
| `PUT` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.updateGLClosure` |
| `DELETE` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.deleteGLClosure` |

### `GET /v1/glclosures` - GLClosuresApiResource.retrieveAllClosures
- **설명**: `GLClosuresApiResource`의 `retrieveAllClosures` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/glclosures` - GLClosuresApiResource.createGLClosure
- **설명**: `GLClosuresApiResource`의 `createGLClosure` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/glclosures/{glClosureId}` - GLClosuresApiResource.retreiveClosure
- **설명**: `GLClosuresApiResource`의 `retreiveClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/glclosures/{glClosureId}` - GLClosuresApiResource.updateGLClosure
- **설명**: `GLClosuresApiResource`의 `updateGLClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/glclosures/{glClosureId}` - GLClosuresApiResource.deleteGLClosure
- **설명**: `GLClosuresApiResource`의 `deleteGLClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
