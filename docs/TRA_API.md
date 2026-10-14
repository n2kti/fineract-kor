# [TRA] API명세서

> 화면 2개 롤업(소분류 TRA, 대분류 TR - 계좌이체 및 자동이체).

## TRA-001 계좌간 이체

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/api/AccountTransfersApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/accounttransfers/template` | `AccountTransfersApiResource.template` |
| `POST` | `/v1/accounttransfers` | `AccountTransfersApiResource.create` |
| `GET` | `/v1/accounttransfers` | `AccountTransfersApiResource.retrieveAll` |
| `GET` | `/v1/accounttransfers/{transferId}` | `AccountTransfersApiResource.retrieveOne` |
| `GET` | `/v1/accounttransfers/templateRefundByTransfer` | `AccountTransfersApiResource.templateRefundByTransfer` |
| `POST` | `/v1/accounttransfers/refundByTransfer` | `AccountTransfersApiResource.templateRefundByTransferPost` |
| `POST` | `/v1/accounttransfers/{accountTransferId}` | `AccountTransfersApiResource.accountTransferOperation` |

### `GET /v1/accounttransfers/template` - AccountTransfersApiResource.template
- **설명**: `AccountTransfersApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounttransfers` - AccountTransfersApiResource.create
- **설명**: `AccountTransfersApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounttransfers` - AccountTransfersApiResource.retrieveAll
- **설명**: `AccountTransfersApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounttransfers/{transferId}` - AccountTransfersApiResource.retrieveOne
- **설명**: `AccountTransfersApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/accounttransfers/templateRefundByTransfer` - AccountTransfersApiResource.templateRefundByTransfer
- **설명**: `AccountTransfersApiResource`의 `templateRefundByTransfer` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounttransfers/refundByTransfer` - AccountTransfersApiResource.templateRefundByTransferPost
- **설명**: `AccountTransfersApiResource`의 `templateRefundByTransferPost` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/accounttransfers/{accountTransferId}` - AccountTransfersApiResource.accountTransferOperation
- **설명**: `AccountTransfersApiResource`의 `accountTransferOperation` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## TRA-002 자동이체(SI) 관리

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#standinginstruc`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/standinginstructions` | `StandingInstructionApiResource.retrieveAll` |
| `POST` | `/v1/standinginstructions` | `StandingInstructionApiResource.create` |
| `GET` | `/v1/standinginstructions/{instructionId}` | `StandingInstructionApiResource.retrieveOne` |
| `PUT` | `/v1/standinginstructions/{instructionId}` | `StandingInstructionApiResource.update` |
| `DELETE` | `/v1/standinginstructions/{instructionId}` | `StandingInstructionApiResource.delete` |

### `GET /v1/standinginstructions` - StandingInstructionApiResource.retrieveAll
- **설명**: `StandingInstructionApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `clientId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/standinginstructions` - StandingInstructionApiResource.create
- **설명**: `StandingInstructionApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/standinginstructions/{instructionId}` - StandingInstructionApiResource.retrieveOne
- **설명**: `StandingInstructionApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `instructionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/standinginstructions/{instructionId}` - StandingInstructionApiResource.update
- **설명**: `StandingInstructionApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `instructionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/standinginstructions/{instructionId}` - StandingInstructionApiResource.delete
- **설명**: `StandingInstructionApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `instructionId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/api/AccountTransfersApiResource.java`
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
