# [CL] API명세서 (고객관리)

> 소분류 3개 롤업.


---

## [CLA] API명세서

> 화면 2개 롤업(소분류 CLA, 대분류 CL - 고객 관리).

### CLA-001 고객 목록 및 검색

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientsApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/clients/template` | `ClientsApiResource.retrieveTemplate` |
| `GET` | `/v1/clients` | `ClientsApiResource.retrieveAll` |
| `GET` | `/v1/clients/{clientId}` | `ClientsApiResource.retrieveOne` |
| `POST` | `/v1/clients` | `ClientsApiResource.create` |
| `PUT` | `/v1/clients/{clientId}` | `ClientsApiResource.update` |
| `DELETE` | `/v1/clients/{clientId}` | `ClientsApiResource.delete` |
| `POST` | `/v1/clients/{clientId}` | `ClientsApiResource.activate` |
| `GET` | `/v1/clients/{clientId}/accounts` | `ClientsApiResource.retrieveAssociatedAccounts` |
| `GET` | `/v1/clients/downloadtemplate` | `ClientsApiResource.getClientTemplate` |
| `POST` | `/v1/clients/uploadtemplate` | `ClientsApiResource.postClientTemplate` |
| `GET` | `/v1/clients/{clientId}/obligeedetails` | `ClientsApiResource.retrieveObligeeDetails` |
| `GET` | `/v1/clients/{clientId}/transferproposaldate` | `ClientsApiResource.retrieveTransferTemplate` |
| `GET` | `/v1/clients/external-id/{externalId}` | `ClientsApiResource.retrieveOne` |
| `GET` | `/v1/clients/external-id/{externalId}/accounts` | `ClientsApiResource.retrieveAssociatedAccounts` |
| `PUT` | `/v1/clients/external-id/{externalId}` | `ClientsApiResource.update` |
| `POST` | `/v1/clients/external-id/{externalId}` | `ClientsApiResource.applyCommand` |
| `DELETE` | `/v1/clients/external-id/{externalId}` | `ClientsApiResource.delete` |
| `GET` | `/v1/clients/external-id/{externalId}/obligeedetails` | `ClientsApiResource.retrieveObligeeDetails` |
| `GET` | `/v1/clients/external-id/{externalId}/transferproposaldate` | `ClientsApiResource.retrieveTransferTemplate` |

#### `GET /v1/clients/template` - ClientsApiResource.retrieveTemplate
- **설명**: `ClientsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients` - ClientsApiResource.retrieveAll
- **설명**: `ClientsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `legalForm` (QueryParam): `Integer` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}` - ClientsApiResource.retrieveOne
- **설명**: `ClientsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients` - ClientsApiResource.create
- **설명**: `ClientsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/clients/{clientId}` - ClientsApiResource.update
- **설명**: `ClientsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/{clientId}` - ClientsApiResource.delete
- **설명**: `ClientsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}` - ClientsApiResource.activate
- **설명**: `ClientsApiResource`의 `activate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/accounts` - ClientsApiResource.retrieveAssociatedAccounts
- **설명**: `ClientsApiResource`의 `retrieveAssociatedAccounts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/downloadtemplate` - ClientsApiResource.getClientTemplate
- **설명**: `ClientsApiResource`의 `getClientTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `legalFormType` (QueryParam): `String` 타입 식별자/필터
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/uploadtemplate` - ClientsApiResource.postClientTemplate
- **설명**: `ClientsApiResource`의 `postClientTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `legalFormType` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/obligeedetails` - ClientsApiResource.retrieveObligeeDetails
- **설명**: `ClientsApiResource`의 `retrieveObligeeDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/transferproposaldate` - ClientsApiResource.retrieveTransferTemplate
- **설명**: `ClientsApiResource`의 `retrieveTransferTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{externalId}` - ClientsApiResource.retrieveOne
- **설명**: `ClientsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{externalId}/accounts` - ClientsApiResource.retrieveAssociatedAccounts
- **설명**: `ClientsApiResource`의 `retrieveAssociatedAccounts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/clients/external-id/{externalId}` - ClientsApiResource.update
- **설명**: `ClientsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/external-id/{externalId}` - ClientsApiResource.applyCommand
- **설명**: `ClientsApiResource`의 `applyCommand` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/external-id/{externalId}` - ClientsApiResource.delete
- **설명**: `ClientsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{externalId}/obligeedetails` - ClientsApiResource.retrieveObligeeDetails
- **설명**: `ClientsApiResource`의 `retrieveObligeeDetails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{externalId}/transferproposaldate` - ClientsApiResource.retrieveTransferTemplate
- **설명**: `ClientsApiResource`의 `retrieveTransferTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `externalId` (PathParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### CLA-002 고객 등록 및 상세정보

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientIdentifiersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientFamilyMembersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientAddressApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientChargesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientTransactionsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/ClientCollateralManagementApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/clients/{clientId}/identifiers` | `ClientIdentifiersApiResource.retrieveAllClientIdentifiers` |
| `GET` | `/v1/clients/{clientId}/identifiers/template` | `ClientIdentifiersApiResource.newClientIdentifierDetails` |
| `POST` | `/v1/clients/{clientId}/identifiers` | `ClientIdentifiersApiResource.createClientIdentifier` |
| `GET` | `/v1/clients/{clientId}/identifiers/{identifierId}` | `ClientIdentifiersApiResource.retrieveClientIdentifiers` |
| `PUT` | `/v1/clients/{clientId}/identifiers/{identifierId}` | `ClientIdentifiersApiResource.updateClientIdentifer` |
| `DELETE` | `/v1/clients/{clientId}/identifiers/{identifierId}` | `ClientIdentifiersApiResource.deleteClientIdentifier` |
| `GET` | `/v1/clients/{clientId}/familymembers/{familyMemberId}` | `ClientFamilyMembersApiResource.getFamilyMember` |
| `GET` | `/v1/clients/{clientId}/familymembers` | `ClientFamilyMembersApiResource.getFamilyMembers` |
| `GET` | `/v1/clients/{clientId}/familymembers/template` | `ClientFamilyMembersApiResource.getTemplate` |
| `PUT` | `/v1/clients/{clientId}/familymembers/{familyMemberId}` | `ClientFamilyMembersApiResource.updateClientFamilyMembers` |
| `POST` | `/v1/clients/{clientId}/familymembers` | `ClientFamilyMembersApiResource.addClientFamilyMembers` |
| `DELETE` | `/v1/clients/{clientId}/familymembers/{familyMemberId}` | `ClientFamilyMembersApiResource.deleteClientFamilyMembers` |
| `GET` | `/v1/client/addresses/template` | `ClientAddressApiResource.getAddressesTemplate` |
| `POST` | `/v1/client/{clientid}/addresses` | `ClientAddressApiResource.addClientAddress` |
| `GET` | `/v1/client/{clientid}/addresses` | `ClientAddressApiResource.getAddresses` |
| `PUT` | `/v1/client/{clientid}/addresses` | `ClientAddressApiResource.updateClientAddress` |
| `GET` | `/v1/clients/{clientId}/charges` | `ClientChargesApiResource.retrieveAllClientCharges` |
| `GET` | `/v1/clients/{clientId}/charges/template` | `ClientChargesApiResource.retrieveTemplate` |
| `GET` | `/v1/clients/{clientId}/charges/{chargeId}` | `ClientChargesApiResource.retrieveClientCharge` |
| `POST` | `/v1/clients/{clientId}/charges` | `ClientChargesApiResource.applyClientCharge` |
| `POST` | `/v1/clients/{clientId}/charges/{chargeId}` | `ClientChargesApiResource.payOrWaiveClientCharge` |
| `DELETE` | `/v1/clients/{clientId}/charges/{chargeId}` | `ClientChargesApiResource.deleteClientCharge` |
| `GET` | `/v1/clients/{clientId}/transactions` | `ClientTransactionsApiResource.retrieveAllClientTransactions` |
| `GET` | `/v1/clients/{clientId}/transactions/{transactionId}` | `ClientTransactionsApiResource.retrieveClientTransaction` |
| `POST` | `/v1/clients/{clientId}/transactions/{transactionId}` | `ClientTransactionsApiResource.undoClientTransaction` |
| `GET` | `/v1/clients/external-id/{clientExternalId}/transactions` | `ClientTransactionsApiResource.retrieveAllClientTransactions` |
| `GET` | `/v1/clients/external-id/{clientExternalId}/transactions/{transactionId}` | `ClientTransactionsApiResource.retrieveClientTransaction` |
| `POST` | `/v1/clients/external-id/{clientExternalId}/transactions/{transactionId}` | `ClientTransactionsApiResource.undoClientTransaction` |
| `GET` | `/v1/clients/{clientId}/transactions/external-id/{transactionExternalId}` | `ClientTransactionsApiResource.retrieveClientTransaction` |
| `GET` | `/v1/clients/external-id/{clientExternalId}/transactions/external-id/{transactionExternalId}` | `ClientTransactionsApiResource.retrieveClientTransaction` |
| `POST` | `/v1/clients/{clientId}/transactions/external-id/{transactionExternalId}` | `ClientTransactionsApiResource.undoClientTransaction` |
| `POST` | `/v1/clients/external-id/{clientExternalId}/transactions/external-id/{transactionExternalId}` | `ClientTransactionsApiResource.undoClientTransaction` |
| `GET` | `/v1/clients/{clientId}/collaterals` | `ClientCollateralManagementApiResource.getClientCollateral` |
| `GET` | `/v1/clients/{clientId}/collaterals/{clientCollateralId}` | `ClientCollateralManagementApiResource.getClientCollateralData` |
| `GET` | `/v1/clients/{clientId}/collaterals/template` | `ClientCollateralManagementApiResource.getClientCollateralTemplate` |
| `POST` | `/v1/clients/{clientId}/collaterals` | `ClientCollateralManagementApiResource.addCollateral` |
| `PUT` | `/v1/clients/{clientId}/collaterals/{collateralId}` | `ClientCollateralManagementApiResource.updateCollateral` |
| `DELETE` | `/v1/clients/{clientId}/collaterals/{collateralId}` | `ClientCollateralManagementApiResource.deleteCollateral` |

#### `GET /v1/clients/{clientId}/identifiers` - ClientIdentifiersApiResource.retrieveAllClientIdentifiers
- **설명**: `ClientIdentifiersApiResource`의 `retrieveAllClientIdentifiers` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/identifiers/template` - ClientIdentifiersApiResource.newClientIdentifierDetails
- **설명**: `ClientIdentifiersApiResource`의 `newClientIdentifierDetails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/identifiers` - ClientIdentifiersApiResource.createClientIdentifier
- **설명**: `ClientIdentifiersApiResource`의 `createClientIdentifier` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/identifiers/{identifierId}` - ClientIdentifiersApiResource.retrieveClientIdentifiers
- **설명**: `ClientIdentifiersApiResource`의 `retrieveClientIdentifiers` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/clients/{clientId}/identifiers/{identifierId}` - ClientIdentifiersApiResource.updateClientIdentifer
- **설명**: `ClientIdentifiersApiResource`의 `updateClientIdentifer` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/{clientId}/identifiers/{identifierId}` - ClientIdentifiersApiResource.deleteClientIdentifier
- **설명**: `ClientIdentifiersApiResource`의 `deleteClientIdentifier` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/familymembers/{familyMemberId}` - ClientFamilyMembersApiResource.getFamilyMember
- **설명**: `ClientFamilyMembersApiResource`의 `getFamilyMember` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `familyMemberId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/familymembers` - ClientFamilyMembersApiResource.getFamilyMembers
- **설명**: `ClientFamilyMembersApiResource`의 `getFamilyMembers` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/familymembers/template` - ClientFamilyMembersApiResource.getTemplate
- **설명**: `ClientFamilyMembersApiResource`의 `getTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/clients/{clientId}/familymembers/{familyMemberId}` - ClientFamilyMembersApiResource.updateClientFamilyMembers
- **설명**: `ClientFamilyMembersApiResource`의 `updateClientFamilyMembers` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `familyMemberId` (PathParam): `long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/familymembers` - ClientFamilyMembersApiResource.addClientFamilyMembers
- **설명**: `ClientFamilyMembersApiResource`의 `addClientFamilyMembers` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (PathParam): `long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/{clientId}/familymembers/{familyMemberId}` - ClientFamilyMembersApiResource.deleteClientFamilyMembers
- **설명**: `ClientFamilyMembersApiResource`의 `deleteClientFamilyMembers` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `familyMemberId` (PathParam): `long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/client/addresses/template` - ClientAddressApiResource.getAddressesTemplate
- **설명**: `ClientAddressApiResource`의 `getAddressesTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/client/{clientid}/addresses` - ClientAddressApiResource.addClientAddress
- **설명**: `ClientAddressApiResource`의 `addClientAddress` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/client/{clientid}/addresses` - ClientAddressApiResource.getAddresses
- **설명**: `ClientAddressApiResource`의 `getAddresses` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/client/{clientid}/addresses` - ClientAddressApiResource.updateClientAddress
- **설명**: `ClientAddressApiResource`의 `updateClientAddress` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/charges` - ClientChargesApiResource.retrieveAllClientCharges
- **설명**: `ClientChargesApiResource`의 `retrieveAllClientCharges` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/charges/template` - ClientChargesApiResource.retrieveTemplate
- **설명**: `ClientChargesApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/charges/{chargeId}` - ClientChargesApiResource.retrieveClientCharge
- **설명**: `ClientChargesApiResource`의 `retrieveClientCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/charges` - ClientChargesApiResource.applyClientCharge
- **설명**: `ClientChargesApiResource`의 `applyClientCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/charges/{chargeId}` - ClientChargesApiResource.payOrWaiveClientCharge
- **설명**: `ClientChargesApiResource`의 `payOrWaiveClientCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/{clientId}/charges/{chargeId}` - ClientChargesApiResource.deleteClientCharge
- **설명**: `ClientChargesApiResource`의 `deleteClientCharge` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/transactions` - ClientTransactionsApiResource.retrieveAllClientTransactions
- **설명**: `ClientTransactionsApiResource`의 `retrieveAllClientTransactions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/transactions/{transactionId}` - ClientTransactionsApiResource.retrieveClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `retrieveClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/transactions/{transactionId}` - ClientTransactionsApiResource.undoClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `undoClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{clientExternalId}/transactions` - ClientTransactionsApiResource.retrieveAllClientTransactions
- **설명**: `ClientTransactionsApiResource`의 `retrieveAllClientTransactions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{clientExternalId}/transactions/{transactionId}` - ClientTransactionsApiResource.retrieveClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `retrieveClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/external-id/{clientExternalId}/transactions/{transactionId}` - ClientTransactionsApiResource.undoClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `undoClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/transactions/external-id/{transactionExternalId}` - ClientTransactionsApiResource.retrieveClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `retrieveClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/external-id/{clientExternalId}/transactions/external-id/{transactionExternalId}` - ClientTransactionsApiResource.retrieveClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `retrieveClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/transactions/external-id/{transactionExternalId}` - ClientTransactionsApiResource.undoClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `undoClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/external-id/{clientExternalId}/transactions/external-id/{transactionExternalId}` - ClientTransactionsApiResource.undoClientTransaction
- **설명**: `ClientTransactionsApiResource`의 `undoClientTransaction` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/collaterals` - ClientCollateralManagementApiResource.getClientCollateral
- **설명**: `ClientCollateralManagementApiResource`의 `getClientCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/collaterals/{clientCollateralId}` - ClientCollateralManagementApiResource.getClientCollateralData
- **설명**: `ClientCollateralManagementApiResource`의 `getClientCollateralData` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/clients/{clientId}/collaterals/template` - ClientCollateralManagementApiResource.getClientCollateralTemplate
- **설명**: `ClientCollateralManagementApiResource`의 `getClientCollateralTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/clients/{clientId}/collaterals` - ClientCollateralManagementApiResource.addCollateral
- **설명**: `ClientCollateralManagementApiResource`의 `addCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/clients/{clientId}/collaterals/{collateralId}` - ClientCollateralManagementApiResource.updateCollateral
- **설명**: `ClientCollateralManagementApiResource`의 `updateCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/clients/{clientId}/collaterals/{collateralId}` - ClientCollateralManagementApiResource.deleteCollateral
- **설명**: `ClientCollateralManagementApiResource`의 `deleteCollateral` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientAddressApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientChargesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientFamilyMembersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientIdentifiersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientTransactionsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/client/api/ClientsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/ClientCollateralManagementApiResource.java`

---

## [CLG] API명세서

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

### CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/CentersApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsLevelApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/groups/template` - GroupsApiResource.retrieveTemplate
- **설명**: `GroupsApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups` - GroupsApiResource.retrieveAll
- **설명**: `GroupsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups/{groupId}` - GroupsApiResource.retrieveOne
- **설명**: `GroupsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/groups` - GroupsApiResource.create
- **설명**: `GroupsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/groups/{groupId}/command/unassign_staff` - GroupsApiResource.unassignLoanOfficer
- **설명**: `GroupsApiResource`의 `unassignLoanOfficer` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/groups/{groupId}` - GroupsApiResource.update
- **설명**: `GroupsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/groups/{groupId}` - GroupsApiResource.delete
- **설명**: `GroupsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/groups/{groupId}` - GroupsApiResource.activateOrGenerateCollectionSheet
- **설명**: `GroupsApiResource`의 `activateOrGenerateCollectionSheet` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups/{groupId}/accounts` - GroupsApiResource.retrieveAccounts
- **설명**: `GroupsApiResource`의 `retrieveAccounts` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups/downloadtemplate` - GroupsApiResource.getGroupsTemplate
- **설명**: `GroupsApiResource`의 `getGroupsTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/groups/uploadtemplate` - GroupsApiResource.postGroupTemplate
- **설명**: `GroupsApiResource`의 `postGroupTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups/{groupId}/glimaccounts` - GroupsApiResource.retrieveglimAccounts
- **설명**: `GroupsApiResource`의 `retrieveglimAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `groupId` (PathParam): `Long` 타입 식별자/필터
  - `parentLoanAccountNo` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/groups/{groupId}/gsimaccounts` - GroupsApiResource.retrieveGsimAccounts
- **설명**: `GroupsApiResource`의 `retrieveGsimAccounts` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `groupId` (PathParam): `Long` 타입 식별자/필터
  - `parentGSIMAccountNo` (QueryParam): `String` 타입 식별자/필터
  - `parentGSIMId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/centers/template` - CentersApiResource.retrieveTemplate
- **설명**: `CentersApiResource`의 `retrieveTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/centers` - CentersApiResource.retrieveAll
- **설명**: `CentersApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/centers/{centerId}` - CentersApiResource.retrieveOne
- **설명**: `CentersApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/centers` - CentersApiResource.create
- **설명**: `CentersApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/centers/{centerId}` - CentersApiResource.update
- **설명**: `CentersApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/centers/{centerId}` - CentersApiResource.delete
- **설명**: `CentersApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/centers/{centerId}` - CentersApiResource.activate
- **설명**: `CentersApiResource`의 `activate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/centers/{centerId}/accounts` - CentersApiResource.retrieveGroupAccount
- **설명**: `CentersApiResource`의 `retrieveGroupAccount` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/centers/downloadtemplate` - CentersApiResource.getCentersTemplate
- **설명**: `CentersApiResource`의 `getCentersTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
  - `staffId` (QueryParam): `Long` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/centers/uploadtemplate` - CentersApiResource.postCentersTemplate
- **설명**: `CentersApiResource`의 `postCentersTemplate` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/grouplevels` - GroupsLevelApiResource.retrieveAllGroups
- **설명**: `GroupsLevelApiResource`의 `retrieveAllGroups` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/CentersApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/api/GroupsLevelApiResource.java`

---

## [CLS] API명세서

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

### CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/api/CollectionSheetApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `POST` | `/v1/collectionsheet` | `CollectionSheetApiResource.generateCollectionSheet` |

#### `POST /v1/collectionsheet` - CollectionSheetApiResource.generateCollectionSheet
- **설명**: `CollectionSheetApiResource`의 `generateCollectionSheet` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/api/CollectionSheetApiResource.java`
