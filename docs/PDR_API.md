# [PDR] API명세서

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

## PDR-001 금리·수수료·세무 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/interestratechart/api/InterestRateChartsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/portfolio/interestratechart/api/InterestRateChartSlabsApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/interestratecharts/template` | `InterestRateChartsApiResource.template` |
| `GET` | `/v1/interestratecharts` | `InterestRateChartsApiResource.retrieveAll` |
| `GET` | `/v1/interestratecharts/{chartId}` | `InterestRateChartsApiResource.retrieveOne` |
| `POST` | `/v1/interestratecharts` | `InterestRateChartsApiResource.create` |
| `PUT` | `/v1/interestratecharts/{chartId}` | `InterestRateChartsApiResource.update` |
| `DELETE` | `/v1/interestratecharts/{chartId}` | `InterestRateChartsApiResource.delete` |
| `GET` | `/v1/interestratecharts/{chartId}/chartslabs/template` | `InterestRateChartSlabsApiResource.template` |
| `GET` | `/v1/interestratecharts/{chartId}/chartslabs` | `InterestRateChartSlabsApiResource.retrieveAll` |
| `GET` | `/v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` | `InterestRateChartSlabsApiResource.retrieveOne` |
| `POST` | `/v1/interestratecharts/{chartId}/chartslabs` | `InterestRateChartSlabsApiResource.create` |
| `PUT` | `/v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` | `InterestRateChartSlabsApiResource.update` |
| `DELETE` | `/v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` | `InterestRateChartSlabsApiResource.delete` |

### `GET /v1/interestratecharts/template` - InterestRateChartsApiResource.template
- **설명**: `InterestRateChartsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/interestratecharts` - InterestRateChartsApiResource.retrieveAll
- **설명**: `InterestRateChartsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `productId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/interestratecharts/{chartId}` - InterestRateChartsApiResource.retrieveOne
- **설명**: `InterestRateChartsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
  - `associations` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/interestratecharts` - InterestRateChartsApiResource.create
- **설명**: `InterestRateChartsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/interestratecharts/{chartId}` - InterestRateChartsApiResource.update
- **설명**: `InterestRateChartsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/interestratecharts/{chartId}` - InterestRateChartsApiResource.delete
- **설명**: `InterestRateChartsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/interestratecharts/{chartId}/chartslabs/template` - InterestRateChartSlabsApiResource.template
- **설명**: `InterestRateChartSlabsApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/interestratecharts/{chartId}/chartslabs` - InterestRateChartSlabsApiResource.retrieveAll
- **설명**: `InterestRateChartSlabsApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` - InterestRateChartSlabsApiResource.retrieveOne
- **설명**: `InterestRateChartSlabsApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
  - `chartSlabId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/interestratecharts/{chartId}/chartslabs` - InterestRateChartSlabsApiResource.create
- **설명**: `InterestRateChartSlabsApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` - InterestRateChartSlabsApiResource.update
- **설명**: `InterestRateChartSlabsApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
  - `chartSlabId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/interestratecharts/{chartId}/chartslabs/{chartSlabId}` - InterestRateChartSlabsApiResource.delete
- **설명**: `InterestRateChartSlabsApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `chartId` (PathParam): `Long` 타입 식별자/필터
  - `chartSlabId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/interestratechart/api/InterestRateChartSlabsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/interestratechart/api/InterestRateChartsApiResource.java`
