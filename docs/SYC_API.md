# [SYC] API명세서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

## SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodeValuesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/DatatablesApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/codes` | `CodesApiResource.retrieveCodes` |
| `POST` | `/v1/codes` | `CodesApiResource.createCode` |
| `GET` | `/v1/codes/{codeId}` | `CodesApiResource.retrieveCode` |
| `GET` | `/v1/codes/name/{codeName}` | `CodesApiResource.retrieveCodeByName` |
| `PUT` | `/v1/codes/{codeId}` | `CodesApiResource.updateCode` |
| `DELETE` | `/v1/codes/{codeId}` | `CodesApiResource.deleteCode` |
| `GET` | `/v1/codes/{codeId}/codevalues` | `CodeValuesApiResource.retrieveAllCodeValues` |
| `GET` | `/v1/codes/{codeId}/codevalues/{codeValueId}` | `CodeValuesApiResource.retrieveCodeValue` |
| `POST` | `/v1/codes/{codeId}/codevalues` | `CodeValuesApiResource.createCodeValue` |
| `PUT` | `/v1/codes/{codeId}/codevalues/{codeValueId}` | `CodeValuesApiResource.updateCodeValue` |
| `DELETE` | `/v1/codes/{codeId}/codevalues/{codeValueId}` | `CodeValuesApiResource.deleteCodeValue` |
| `GET` | `/v1/codes/name/{codeName}/codevalues` | `CodeValuesApiResource.retrieveAllCodeValues` |
| `GET` | `/v1/codes/name/{codeName}/codevalues/{codeValueId}` | `CodeValuesApiResource.retrieveCodeValue` |
| `POST` | `/v1/codes/name/{codeName}/codevalues` | `CodeValuesApiResource.createCodeValue` |
| `PUT` | `/v1/codes/name/{codeName}/codevalues/{codeValueId}` | `CodeValuesApiResource.updateCodeValue` |
| `DELETE` | `/v1/codes/name/{codeName}/codevalues/{codeValueId}` | `CodeValuesApiResource.deleteCodeValue` |
| `GET` | `/v1/datatables` | `DatatablesApiResource.getDatatables` |
| `POST` | `/v1/datatables` | `DatatablesApiResource.createDatatable` |
| `PUT` | `/v1/datatables/{datatableName}` | `DatatablesApiResource.updateDatatable` |
| `DELETE` | `/v1/datatables/{datatableName}` | `DatatablesApiResource.deleteDatatable` |
| `POST` | `/v1/datatables/register/{datatable}/{apptable}` | `DatatablesApiResource.registerDatatable` |
| `POST` | `/v1/datatables/deregister/{datatable}` | `DatatablesApiResource.deregisterDatatable` |
| `GET` | `/v1/datatables/{datatable}` | `DatatablesApiResource.getDatatable` |
| `GET` | `/v1/datatables/{datatable}/query` | `DatatablesApiResource.queryValues` |
| `POST` | `/v1/datatables/{datatable}/query` | `DatatablesApiResource.advancedQuery` |
| `GET` | `/v1/datatables/{datatable}/{apptableId}` | `DatatablesApiResource.getDatatable` |
| `GET` | `/v1/datatables/{datatable}/{apptableId}/{datatableId}` | `DatatablesApiResource.getDatatableManyEntry` |
| `POST` | `/v1/datatables/{datatable}/{apptableId}` | `DatatablesApiResource.createDatatableEntry` |
| `PUT` | `/v1/datatables/{datatable}/{apptableId}` | `DatatablesApiResource.updateDatatableEntryOnetoOne` |
| `PUT` | `/v1/datatables/{datatable}/{apptableId}/{datatableId}` | `DatatablesApiResource.updateDatatableEntryOneToMany` |
| `DELETE` | `/v1/datatables/{datatable}/{apptableId}` | `DatatablesApiResource.deleteDatatableEntries` |
| `DELETE` | `/v1/datatables/{datatable}/{apptableId}/{datatableId}` | `DatatablesApiResource.deleteDatatableEntry` |

### `GET /v1/codes` - CodesApiResource.retrieveCodes
- **설명**: `CodesApiResource`의 `retrieveCodes` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/codes` - CodesApiResource.createCode
- **설명**: `CodesApiResource`의 `createCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/{codeId}` - CodesApiResource.retrieveCode
- **설명**: `CodesApiResource`의 `retrieveCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/name/{codeName}` - CodesApiResource.retrieveCodeByName
- **설명**: `CodesApiResource`의 `retrieveCodeByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/codes/{codeId}` - CodesApiResource.updateCode
- **설명**: `CodesApiResource`의 `updateCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/codes/{codeId}` - CodesApiResource.deleteCode
- **설명**: `CodesApiResource`의 `deleteCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/{codeId}/codevalues` - CodeValuesApiResource.retrieveAllCodeValues
- **설명**: `CodeValuesApiResource`의 `retrieveAllCodeValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.retrieveCodeValue
- **설명**: `CodeValuesApiResource`의 `retrieveCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/codes/{codeId}/codevalues` - CodeValuesApiResource.createCodeValue
- **설명**: `CodeValuesApiResource`의 `createCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.updateCodeValue
- **설명**: `CodeValuesApiResource`의 `updateCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.deleteCodeValue
- **설명**: `CodeValuesApiResource`의 `deleteCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/name/{codeName}/codevalues` - CodeValuesApiResource.retrieveAllCodeValues
- **설명**: `CodeValuesApiResource`의 `retrieveAllCodeValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.retrieveCodeValue
- **설명**: `CodeValuesApiResource`의 `retrieveCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/codes/name/{codeName}/codevalues` - CodeValuesApiResource.createCodeValue
- **설명**: `CodeValuesApiResource`의 `createCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.updateCodeValue
- **설명**: `CodeValuesApiResource`의 `updateCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.deleteCodeValue
- **설명**: `CodeValuesApiResource`의 `deleteCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/datatables` - DatatablesApiResource.getDatatables
- **설명**: `DatatablesApiResource`의 `getDatatables` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/datatables` - DatatablesApiResource.createDatatable
- **설명**: `DatatablesApiResource`의 `createDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/datatables/{datatableName}` - DatatablesApiResource.updateDatatable
- **설명**: `DatatablesApiResource`의 `updateDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/datatables/{datatableName}` - DatatablesApiResource.deleteDatatable
- **설명**: `DatatablesApiResource`의 `deleteDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/datatables/register/{datatable}/{apptable}` - DatatablesApiResource.registerDatatable
- **설명**: `DatatablesApiResource`의 `registerDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/datatables/deregister/{datatable}` - DatatablesApiResource.deregisterDatatable
- **설명**: `DatatablesApiResource`의 `deregisterDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/datatables/{datatable}` - DatatablesApiResource.getDatatable
- **설명**: `DatatablesApiResource`의 `getDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/datatables/{datatable}/query` - DatatablesApiResource.queryValues
- **설명**: `DatatablesApiResource`의 `queryValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/datatables/{datatable}/query` - DatatablesApiResource.advancedQuery
- **설명**: `DatatablesApiResource`의 `advancedQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.getDatatable
- **설명**: `DatatablesApiResource`의 `getDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.getDatatableManyEntry
- **설명**: `DatatablesApiResource`의 `getDatatableManyEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `datatable` (PathParam): `String` 타입 식별자/필터
  - `apptableId` (PathParam): `Long` 타입 식별자/필터
  - `datatableId` (PathParam): `Long` 타입 식별자/필터
  - `order` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.createDatatableEntry
- **설명**: `DatatablesApiResource`의 `createDatatableEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.updateDatatableEntryOnetoOne
- **설명**: `DatatablesApiResource`의 `updateDatatableEntryOnetoOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.updateDatatableEntryOneToMany
- **설명**: `DatatablesApiResource`의 `updateDatatableEntryOneToMany` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.deleteDatatableEntries
- **설명**: `DatatablesApiResource`의 `deleteDatatableEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.deleteDatatableEntry
- **설명**: `DatatablesApiResource`의 `deleteDatatableEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/GlobalConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/InternalConfigurationsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/ExternalServicesConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/organisation/holiday/api/HolidaysApiResource.java`

### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/configurations` | `GlobalConfigurationApiResource.retrieveConfiguration` |
| `GET` | `/v1/configurations/{configId}` | `GlobalConfigurationApiResource.retrieveOne` |
| `GET` | `/v1/configurations/name/{name}` | `GlobalConfigurationApiResource.retrieveOneByName` |
| `PUT` | `/v1/configurations/{configId}` | `GlobalConfigurationApiResource.updateConfiguration` |
| `PUT` | `/v1/configurations/name/{configName}` | `GlobalConfigurationApiResource.updateConfigurationByName` |
| `PUT` | `/v1/internal/configurations/name/{configName}/value/{configValue}` | `InternalConfigurationsApiResource.updateGlobalConfiguration` |
| `GET` | `/v1/externalservice/{servicename}` | `ExternalServicesConfigurationApiResource.retrieveOne` |
| `PUT` | `/v1/externalservice/{servicename}` | `ExternalServicesConfigurationApiResource.updateExternalServiceProperties` |
| `POST` | `/v1/holidays` | `HolidaysApiResource.createNewHoliday` |
| `POST` | `/v1/holidays/{holidayId}` | `HolidaysApiResource.handleCommands` |
| `GET` | `/v1/holidays/{holidayId}` | `HolidaysApiResource.retrieveOne` |
| `PUT` | `/v1/holidays/{holidayId}` | `HolidaysApiResource.update` |
| `DELETE` | `/v1/holidays/{holidayId}` | `HolidaysApiResource.delete` |
| `GET` | `/v1/holidays` | `HolidaysApiResource.retrieveAllHolidays` |
| `GET` | `/v1/holidays/template` | `HolidaysApiResource.retrieveRepaymentScheduleUpdationTyeOptions` |

### `GET /v1/configurations` - GlobalConfigurationApiResource.retrieveConfiguration
- **설명**: `GlobalConfigurationApiResource`의 `retrieveConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/configurations/{configId}` - GlobalConfigurationApiResource.retrieveOne
- **설명**: `GlobalConfigurationApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/configurations/name/{name}` - GlobalConfigurationApiResource.retrieveOneByName
- **설명**: `GlobalConfigurationApiResource`의 `retrieveOneByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/configurations/{configId}` - GlobalConfigurationApiResource.updateConfiguration
- **설명**: `GlobalConfigurationApiResource`의 `updateConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/configurations/name/{configName}` - GlobalConfigurationApiResource.updateConfigurationByName
- **설명**: `GlobalConfigurationApiResource`의 `updateConfigurationByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/internal/configurations/name/{configName}/value/{configValue}` - InternalConfigurationsApiResource.updateGlobalConfiguration
- **설명**: `InternalConfigurationsApiResource`의 `updateGlobalConfiguration` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `configName` (PathParam): `String` 타입 식별자/필터
  - `configValue` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/externalservice/{servicename}` - ExternalServicesConfigurationApiResource.retrieveOne
- **설명**: `ExternalServicesConfigurationApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/externalservice/{servicename}` - ExternalServicesConfigurationApiResource.updateExternalServiceProperties
- **설명**: `ExternalServicesConfigurationApiResource`의 `updateExternalServiceProperties` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/holidays` - HolidaysApiResource.createNewHoliday
- **설명**: `HolidaysApiResource`의 `createNewHoliday` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `POST /v1/holidays/{holidayId}` - HolidaysApiResource.handleCommands
- **설명**: `HolidaysApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/holidays/{holidayId}` - HolidaysApiResource.retrieveOne
- **설명**: `HolidaysApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `PUT /v1/holidays/{holidayId}` - HolidaysApiResource.update
- **설명**: `HolidaysApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `DELETE /v1/holidays/{holidayId}` - HolidaysApiResource.delete
- **설명**: `HolidaysApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/holidays` - HolidaysApiResource.retrieveAllHolidays
- **설명**: `HolidaysApiResource`의 `retrieveAllHolidays` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### `GET /v1/holidays/template` - HolidaysApiResource.retrieveRepaymentScheduleUpdationTyeOptions
- **설명**: `HolidaysApiResource`의 `retrieveRepaymentScheduleUpdationTyeOptions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodeValuesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/ExternalServicesConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/GlobalConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/InternalConfigurationsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/DatatablesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/holiday/api/HolidaysApiResource.java`
