# [TRT] API명세서

> 화면 1개 롤업(소분류 TRT, 대분류 TR - 창구 및 출납원 운영).

## TRT-001 창구 및 출납원 운영

> 원본: `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#tellersapiresou, fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm#cashiersapireso`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/tellers` | `TellerApiResource.getTellers` |
| `POST` | `/v1/tellers` | `TellerApiResource.createTeller` |
| `GET` | `/v1/tellers/{tellerId}` | `TellerApiResource.findTeller` |
| `PUT` | `/v1/tellers/{tellerId}` | `TellerApiResource.updateTeller` |
| `DELETE` | `/v1/tellers/{tellerId}` | `TellerApiResource.deleteTeller` |
| `GET` | `/v1/tellers/{tellerId}/cashiers` | `CashierApiResource.getCashiersForTeller` |
| `POST` | `/v1/tellers/{tellerId}/cashiers` | `CashierApiResource.createCashier` |
| `GET` | `/v1/tellers/{tellerId}/cashiers/{cashierId}` | `CashierApiResource.findCashier` |
| `POST` | `/v1/tellers/{tellerId}/cashiers/{cashierId}/allocate` | `CashierApiResource.allocateCashToCashier` |
| `POST` | `/v1/tellers/{tellerId}/cashiers/{cashierId}/settle` | `CashierApiResource.settleCashFromCashier` |

### `GET /v1/tellers` - TellerApiResource.getTellers
- **설명**: `TellerApiResource`의 `getTellers` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `officeId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/tellers` - TellerApiResource.createTeller
- **설명**: `TellerApiResource`의 `createTeller` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/tellers/{tellerId}` - TellerApiResource.findTeller
- **설명**: `TellerApiResource`의 `findTeller` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/tellers/{tellerId}` - TellerApiResource.updateTeller
- **설명**: `TellerApiResource`의 `updateTeller` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/tellers/{tellerId}` - TellerApiResource.deleteTeller
- **설명**: `TellerApiResource`의 `deleteTeller` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/tellers/{tellerId}/cashiers` - CashierApiResource.getCashiersForTeller
- **설명**: `CashierApiResource`의 `getCashiersForTeller` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/tellers/{tellerId}/cashiers` - CashierApiResource.createCashier
- **설명**: `CashierApiResource`의 `createCashier` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/tellers/{tellerId}/cashiers/{cashierId}` - CashierApiResource.findCashier
- **설명**: `CashierApiResource`의 `findCashier` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
  - `cashierId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/tellers/{tellerId}/cashiers/{cashierId}/allocate` - CashierApiResource.allocateCashToCashier
- **설명**: `CashierApiResource`의 `allocateCashToCashier` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
  - `cashierId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/tellers/{tellerId}/cashiers/{cashierId}/settle` - CashierApiResource.settleCashFromCashier
- **설명**: `CashierApiResource`의 `settleCashFromCashier` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `tellerId` (PathParam): `Long` 타입 식별자/필터
  - `cashierId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/resources/static/legacy-docs/apiLive.htm`
