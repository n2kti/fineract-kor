# [AC] API명세서 (회계결산)

> 소분류 3개 롤업.


---

## [ACC] API명세서

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

### ACC-001 계정과목표(COA) 관리

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#glaccountsapire`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/glaccounts` | `GLAccountsApiResource.retrieveAllAccounts` |
| `POST` | `/v1/glaccounts` | `GLAccountsApiResource.createGLAccount` |
| `GET` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.retreiveAccount` |
| `PUT` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.updateGLAccount` |
| `DELETE` | `/v1/glaccounts/{glAccountId}` | `GLAccountsApiResource.deleteGLAccount` |

#### `GET /v1/glaccounts` - GLAccountsApiResource.retrieveAllAccounts
- **설명**: `GLAccountsApiResource`의 `retrieveAllAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `type` (QueryParam): `Integer` 타입 식별자/필터
  - `usage` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/glaccounts` - GLAccountsApiResource.createGLAccount
- **설명**: `GLAccountsApiResource`의 `createGLAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.retreiveAccount
- **설명**: `GLAccountsApiResource`의 `retreiveAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.updateGLAccount
- **설명**: `GLAccountsApiResource`의 `updateGLAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/glaccounts/{glAccountId}` - GLAccountsApiResource.deleteGLAccount
- **설명**: `GLAccountsApiResource`의 `deleteGLAccount` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glAccountId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/journalentries` - JournalEntriesApiResource.retrieveAll
- **설명**: `JournalEntriesApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/journalentries/{journalEntryId}` - JournalEntriesApiResource.retrieveJournalEntryById
- **설명**: `JournalEntriesApiResource`의 `retrieveJournalEntryById` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/journalentries` - JournalEntriesApiResource.createGLJournalEntry
- **설명**: `JournalEntriesApiResource`의 `createGLJournalEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/journalentries/{transactionId}` - JournalEntriesApiResource.createReversalJournalEntry
- **설명**: `JournalEntriesApiResource`의 `createReversalJournalEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/journalentries/provisioning` - JournalEntriesApiResource.retrieveJournalEntries
- **설명**: `JournalEntriesApiResource`의 `retrieveJournalEntries` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `entryId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/journalentries/openingbalance` - JournalEntriesApiResource.retrieveOpeningBalance
- **설명**: `JournalEntriesApiResource`의 `retrieveOpeningBalance` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `currencyCode` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/journalentries/downloadtemplate` - JournalEntriesApiResource.getJournalEntriesTemplate
- **설명**: `JournalEntriesApiResource`의 `getJournalEntriesTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/journalentries/uploadtemplate` - JournalEntriesApiResource.postJournalEntriesTemplate
- **설명**: `JournalEntriesApiResource`의 `postJournalEntriesTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### ACC-003 기초잔액 등록

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#glclosuresapire`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/glclosures` | `GLClosuresApiResource.retrieveAllClosures` |
| `POST` | `/v1/glclosures` | `GLClosuresApiResource.createGLClosure` |
| `GET` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.retreiveClosure` |
| `PUT` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.updateGLClosure` |
| `DELETE` | `/v1/glclosures/{glClosureId}` | `GLClosuresApiResource.deleteGLClosure` |

#### `GET /v1/glclosures` - GLClosuresApiResource.retrieveAllClosures
- **설명**: `GLClosuresApiResource`의 `retrieveAllClosures` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/glclosures` - GLClosuresApiResource.createGLClosure
- **설명**: `GLClosuresApiResource`의 `createGLClosure` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/glclosures/{glClosureId}` - GLClosuresApiResource.retreiveClosure
- **설명**: `GLClosuresApiResource`의 `retreiveClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/glclosures/{glClosureId}` - GLClosuresApiResource.updateGLClosure
- **설명**: `GLClosuresApiResource`의 `updateGLClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/glclosures/{glClosureId}` - GLClosuresApiResource.deleteGLClosure
- **설명**: `GLClosuresApiResource`의 `deleteGLClosure` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `glClosureId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/accounting/journalentry/api/JournalEntriesApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`

---

## [ACR] API명세서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

### ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#accountingrules, fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#financialactivi`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/accountingrules` | `AccountingRuleApiResource.retrieveAllRules` |
| `POST` | `/v1/accountingrules` | `AccountingRuleApiResource.createRule` |
| `GET` | `/v1/accountingrules/{accountingRuleId}` | `AccountingRuleApiResource.retreiveRule` |
| `PUT` | `/v1/accountingrules/{accountingRuleId}` | `AccountingRuleApiResource.updateRule` |
| `DELETE` | `/v1/accountingrules/{accountingRuleId}` | `AccountingRuleApiResource.deleteRule` |
| `GET` | `/v1/financialactivitymappings` | `FinancialActivityAccountsApiResource.retrieveAll` |
| `POST` | `/v1/financialactivitymappings` | `FinancialActivityAccountsApiResource.create` |
| `GET` | `/v1/financialactivitymappings/{mappingId}` | `FinancialActivityAccountsApiResource.retrieveOne` |
| `PUT` | `/v1/financialactivitymappings/{mappingId}` | `FinancialActivityAccountsApiResource.update` |
| `DELETE` | `/v1/financialactivitymappings/{mappingId}` | `FinancialActivityAccountsApiResource.delete` |

#### `GET /v1/accountingrules` - AccountingRuleApiResource.retrieveAllRules
- **설명**: `AccountingRuleApiResource`의 `retrieveAllRules` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/accountingrules` - AccountingRuleApiResource.createRule
- **설명**: `AccountingRuleApiResource`의 `createRule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.retreiveRule
- **설명**: `AccountingRuleApiResource`의 `retreiveRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.updateRule
- **설명**: `AccountingRuleApiResource`의 `updateRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.deleteRule
- **설명**: `AccountingRuleApiResource`의 `deleteRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/financialactivitymappings` - FinancialActivityAccountsApiResource.retrieveAll
- **설명**: `FinancialActivityAccountsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/financialactivitymappings` - FinancialActivityAccountsApiResource.create
- **설명**: `FinancialActivityAccountsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.retrieveOne
- **설명**: `FinancialActivityAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.update
- **설명**: `FinancialActivityAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.delete
- **설명**: `FinancialActivityAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`

---

## [ACP] API명세서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

### ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#provisioningent, fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/provisioningentries` - ProvisioningEntriesApiResource.retrieveAllProvisioningEntries
- **설명**: `ProvisioningEntriesApiResource`의 `retrieveAllProvisioningEntries` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/provisioningentries` - ProvisioningEntriesApiResource.createProvisioningEntries
- **설명**: `ProvisioningEntriesApiResource`의 `createProvisioningEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/provisioningentries/{entryId}` - ProvisioningEntriesApiResource.retrieveProvisioningEntry
- **설명**: `ProvisioningEntriesApiResource`의 `retrieveProvisioningEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entryId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/provisioningentries/{entryId}?command=createjournalentry` - ProvisioningEntriesApiResource.modifyProvisioningEntry
- **설명**: `ProvisioningEntriesApiResource`의 `modifyProvisioningEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entryId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/provisioningcriteria/template` - ProvisioningCriteriaApiResource.retrieveTemplate
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.retrieveProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/provisioningcriteria` - ProvisioningCriteriaApiResource.retrieveAllProvisioningCriterias
- **설명**: `ProvisioningCriteriaApiResource`의 `retrieveAllProvisioningCriterias` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/provisioningcriteria` - ProvisioningCriteriaApiResource.createProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `createProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.updateProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `updateProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/provisioningcriteria/{criteriaId}` - ProvisioningCriteriaApiResource.deleteProvisioningCriteria
- **설명**: `ProvisioningCriteriaApiResource`의 `deleteProvisioningCriteria` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
