# [ACR] API명세서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

## ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#accountingrules, fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#financialactivi`

### 엔드포인트 목록
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

### `GET /v1/accountingrules` - AccountingRuleApiResource.retrieveAllRules
- **설명**: `AccountingRuleApiResource`의 `retrieveAllRules` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accountingrules` - AccountingRuleApiResource.createRule
- **설명**: `AccountingRuleApiResource`의 `createRule` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.retreiveRule
- **설명**: `AccountingRuleApiResource`의 `retreiveRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.updateRule
- **설명**: `AccountingRuleApiResource`의 `updateRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/accountingrules/{accountingRuleId}` - AccountingRuleApiResource.deleteRule
- **설명**: `AccountingRuleApiResource`의 `deleteRule` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `accountingRuleId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/financialactivitymappings` - FinancialActivityAccountsApiResource.retrieveAll
- **설명**: `FinancialActivityAccountsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/financialactivitymappings` - FinancialActivityAccountsApiResource.create
- **설명**: `FinancialActivityAccountsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.retrieveOne
- **설명**: `FinancialActivityAccountsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.update
- **설명**: `FinancialActivityAccountsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/financialactivitymappings/{mappingId}` - FinancialActivityAccountsApiResource.delete
- **설명**: `FinancialActivityAccountsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mappingId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
