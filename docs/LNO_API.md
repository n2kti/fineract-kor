# [LNO] API명세서

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

## LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/api/GuarantorsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/CollateralManagementApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/guarantors/template` | `GuarantorsApiResource.newGuarantorTemplate` |
| `GET` | `/v1/loans/{loanId}/guarantors` | `GuarantorsApiResource.retrieveGuarantorDetails` |
| `GET` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.retrieveGuarantorDetails` |
| `POST` | `/v1/loans/{loanId}/guarantors` | `GuarantorsApiResource.createGuarantor` |
| `PUT` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.updateGuarantor` |
| `DELETE` | `/v1/loans/{loanId}/guarantors/{guarantorId}` | `GuarantorsApiResource.deleteGuarantor` |
| `GET` | `/v1/loans/{loanId}/guarantors/accounts/template` | `GuarantorsApiResource.accountsTemplate` |
| `GET` | `/v1/loans/{loanId}/guarantors/downloadtemplate` | `GuarantorsApiResource.getGuarantorTemplate` |
| `POST` | `/v1/loans/{loanId}/guarantors/uploadtemplate` | `GuarantorsApiResource.postGuarantorTemplate` |
| `POST` | `/v1/collateral-management` | `CollateralManagementApiResource.createCollateral` |
| `GET` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.getCollateral` |
| `GET` | `/v1/collateral-management` | `CollateralManagementApiResource.getAllCollaterals` |
| `GET` | `/v1/collateral-management/template` | `CollateralManagementApiResource.getCollateralTemplate` |
| `PUT` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.updateCollateral` |
| `DELETE` | `/v1/collateral-management/{collateralId}` | `CollateralManagementApiResource.deleteCollateral` |

### `GET /v1/loans/{loanId}/guarantors/template` - GuarantorsApiResource.newGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `newGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/guarantors` - GuarantorsApiResource.retrieveGuarantorDetails
- **설명**: `GuarantorsApiResource`의 `retrieveGuarantorDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.retrieveGuarantorDetails
- **설명**: `GuarantorsApiResource`의 `retrieveGuarantorDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/guarantors` - GuarantorsApiResource.createGuarantor
- **설명**: `GuarantorsApiResource`의 `createGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.updateGuarantor
- **설명**: `GuarantorsApiResource`의 `updateGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/loans/{loanId}/guarantors/{guarantorId}` - GuarantorsApiResource.deleteGuarantor
- **설명**: `GuarantorsApiResource`의 `deleteGuarantor` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorId` (PathParam): `Long` 타입 식별자/필터
  - `guarantorFundingId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/guarantors/accounts/template` - GuarantorsApiResource.accountsTemplate
- **설명**: `GuarantorsApiResource`의 `accountsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (QueryParam): `Long` 타입 식별자/필터
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/guarantors/downloadtemplate` - GuarantorsApiResource.getGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `getGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/guarantors/uploadtemplate` - GuarantorsApiResource.postGuarantorTemplate
- **설명**: `GuarantorsApiResource`의 `postGuarantorTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `loanId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/collateral-management` - CollateralManagementApiResource.createCollateral
- **설명**: `CollateralManagementApiResource`의 `createCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.getCollateral
- **설명**: `CollateralManagementApiResource`의 `getCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/collateral-management` - CollateralManagementApiResource.getAllCollaterals
- **설명**: `CollateralManagementApiResource`의 `getAllCollaterals` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/collateral-management/template` - CollateralManagementApiResource.getCollateralTemplate
- **설명**: `CollateralManagementApiResource`의 `getCollateralTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.updateCollateral
- **설명**: `CollateralManagementApiResource`의 `updateCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/collateral-management/{collateralId}` - CollateralManagementApiResource.deleteCollateral
- **설명**: `CollateralManagementApiResource`의 `deleteCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/BulkLoansApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/pointintime/LoansPointInTimeApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/{loanId}/charges` | `LoanChargesApiResource.retrieveAllLoanCharges` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges` | `LoanChargesApiResource.retrieveAllLoanCharges` |
| `GET` | `/v1/loans/{loanId}/charges/template` | `LoanChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/template` | `LoanChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `GET` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.retrieveLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.executeLoanCharge` |
| `POST` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.executeLoanCharge` |
| `PUT` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.updateLoanCharge` |
| `PUT` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.updateLoanCharge` |
| `DELETE` | `/v1/loans/{loanId}/charges/{loanChargeId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `DELETE` | `/v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` | `LoanChargesApiResource.deleteLoanCharge` |
| `GET` | `/v1/loans/loanreassignment/template` | `BulkLoansApiResource.loanReassignmentTemplate` |
| `POST` | `/v1/loans/loanreassignment` | `BulkLoansApiResource.loanReassignment` |
| `GET` | `/v1/loans/at-date/{loanId}` | `LoansPointInTimeApiResource.retrieveLoanPointInTime` |
| `GET` | `/v1/loans/at-date/external-id/{loanExternalId}` | `LoansPointInTimeApiResource.retrieveLoanPointInTimeByExternalId` |
| `POST` | `/v1/loans/at-date/search` | `LoansPointInTimeApiResource.retrieveLoansPointInTime` |
| `POST` | `/v1/loans/at-date/search/external-id` | `LoansPointInTimeApiResource.retrieveLoansPointInTimeByExternalIds` |

### `GET /v1/loans/{loanId}/charges` - LoanChargesApiResource.retrieveAllLoanCharges
- **설명**: `LoanChargesApiResource`의 `retrieveAllLoanCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/charges` - LoanChargesApiResource.retrieveAllLoanCharges
- **설명**: `LoanChargesApiResource`의 `retrieveAllLoanCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/charges/template` - LoanChargesApiResource.retrieveTemplate
- **설명**: `LoanChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/charges/template` - LoanChargesApiResource.retrieveTemplate
- **설명**: `LoanChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.retrieveLoanCharge
- **설명**: `LoanChargesApiResource`의 `retrieveLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/charges` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/charges` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.executeLoanCharge
- **설명**: `LoanChargesApiResource`의 `executeLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.updateLoanCharge
- **설명**: `LoanChargesApiResource`의 `updateLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/loans/{loanId}/charges/{loanChargeId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/loans/{loanId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/loans/external-id/{loanExternalId}/charges/{loanChargeId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/loans/external-id/{loanExternalId}/charges/external-id/{loanChargeExternalId}` - LoanChargesApiResource.deleteLoanCharge
- **설명**: `LoanChargesApiResource`의 `deleteLoanCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/loanreassignment/template` - BulkLoansApiResource.loanReassignmentTemplate
- **설명**: `BulkLoansApiResource`의 `loanReassignmentTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/loanreassignment` - BulkLoansApiResource.loanReassignment
- **설명**: `BulkLoansApiResource`의 `loanReassignment` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/at-date/{loanId}` - LoansPointInTimeApiResource.retrieveLoanPointInTime
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoanPointInTime` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/loans/at-date/external-id/{loanExternalId}` - LoansPointInTimeApiResource.retrieveLoanPointInTimeByExternalId
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoanPointInTimeByExternalId` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/at-date/search` - LoansPointInTimeApiResource.retrieveLoansPointInTime
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoansPointInTime` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/loans/at-date/search/external-id` - LoansPointInTimeApiResource.retrieveLoansPointInTimeByExternalIds
- **설명**: `LoansPointInTimeApiResource`의 `retrieveLoansPointInTimeByExternalIds` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/CollateralManagementApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/BulkLoansApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/pointintime/LoansPointInTimeApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/api/GuarantorsApiResource.java`
