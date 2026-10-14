# [SY] API명세서 (시스템운영)

> 소분류 3개 롤업.


---

## [SYC] API명세서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

### SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodeValuesApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/DatatablesApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/codes` - CodesApiResource.retrieveCodes
- **설명**: `CodesApiResource`의 `retrieveCodes` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/codes` - CodesApiResource.createCode
- **설명**: `CodesApiResource`의 `createCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/{codeId}` - CodesApiResource.retrieveCode
- **설명**: `CodesApiResource`의 `retrieveCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/name/{codeName}` - CodesApiResource.retrieveCodeByName
- **설명**: `CodesApiResource`의 `retrieveCodeByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/codes/{codeId}` - CodesApiResource.updateCode
- **설명**: `CodesApiResource`의 `updateCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/codes/{codeId}` - CodesApiResource.deleteCode
- **설명**: `CodesApiResource`의 `deleteCode` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/{codeId}/codevalues` - CodeValuesApiResource.retrieveAllCodeValues
- **설명**: `CodeValuesApiResource`의 `retrieveAllCodeValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.retrieveCodeValue
- **설명**: `CodeValuesApiResource`의 `retrieveCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/codes/{codeId}/codevalues` - CodeValuesApiResource.createCodeValue
- **설명**: `CodeValuesApiResource`의 `createCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.updateCodeValue
- **설명**: `CodeValuesApiResource`의 `updateCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/codes/{codeId}/codevalues/{codeValueId}` - CodeValuesApiResource.deleteCodeValue
- **설명**: `CodeValuesApiResource`의 `deleteCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/name/{codeName}/codevalues` - CodeValuesApiResource.retrieveAllCodeValues
- **설명**: `CodeValuesApiResource`의 `retrieveAllCodeValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.retrieveCodeValue
- **설명**: `CodeValuesApiResource`의 `retrieveCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/codes/name/{codeName}/codevalues` - CodeValuesApiResource.createCodeValue
- **설명**: `CodeValuesApiResource`의 `createCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.updateCodeValue
- **설명**: `CodeValuesApiResource`의 `updateCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/codes/name/{codeName}/codevalues/{codeValueId}` - CodeValuesApiResource.deleteCodeValue
- **설명**: `CodeValuesApiResource`의 `deleteCodeValue` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/datatables` - DatatablesApiResource.getDatatables
- **설명**: `DatatablesApiResource`의 `getDatatables` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/datatables` - DatatablesApiResource.createDatatable
- **설명**: `DatatablesApiResource`의 `createDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/datatables/{datatableName}` - DatatablesApiResource.updateDatatable
- **설명**: `DatatablesApiResource`의 `updateDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/datatables/{datatableName}` - DatatablesApiResource.deleteDatatable
- **설명**: `DatatablesApiResource`의 `deleteDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/datatables/register/{datatable}/{apptable}` - DatatablesApiResource.registerDatatable
- **설명**: `DatatablesApiResource`의 `registerDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/datatables/deregister/{datatable}` - DatatablesApiResource.deregisterDatatable
- **설명**: `DatatablesApiResource`의 `deregisterDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/datatables/{datatable}` - DatatablesApiResource.getDatatable
- **설명**: `DatatablesApiResource`의 `getDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/datatables/{datatable}/query` - DatatablesApiResource.queryValues
- **설명**: `DatatablesApiResource`의 `queryValues` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/datatables/{datatable}/query` - DatatablesApiResource.advancedQuery
- **설명**: `DatatablesApiResource`의 `advancedQuery` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.getDatatable
- **설명**: `DatatablesApiResource`의 `getDatatable` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.getDatatableManyEntry
- **설명**: `DatatablesApiResource`의 `getDatatableManyEntry` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `datatable` (PathParam): `String` 타입 식별자/필터
  - `apptableId` (PathParam): `Long` 타입 식별자/필터
  - `datatableId` (PathParam): `Long` 타입 식별자/필터
  - `order` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.createDatatableEntry
- **설명**: `DatatablesApiResource`의 `createDatatableEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.updateDatatableEntryOnetoOne
- **설명**: `DatatablesApiResource`의 `updateDatatableEntryOnetoOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.updateDatatableEntryOneToMany
- **설명**: `DatatablesApiResource`의 `updateDatatableEntryOneToMany` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/datatables/{datatable}/{apptableId}` - DatatablesApiResource.deleteDatatableEntries
- **설명**: `DatatablesApiResource`의 `deleteDatatableEntries` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/datatables/{datatable}/{apptableId}/{datatableId}` - DatatablesApiResource.deleteDatatableEntry
- **설명**: `DatatablesApiResource`의 `deleteDatatableEntry` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/GlobalConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/InternalConfigurationsApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/ExternalServicesConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/organisation/holiday/api/HolidaysApiResource.java`

#### 엔드포인트 목록
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

#### `GET /v1/configurations` - GlobalConfigurationApiResource.retrieveConfiguration
- **설명**: `GlobalConfigurationApiResource`의 `retrieveConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/configurations/{configId}` - GlobalConfigurationApiResource.retrieveOne
- **설명**: `GlobalConfigurationApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/configurations/name/{name}` - GlobalConfigurationApiResource.retrieveOneByName
- **설명**: `GlobalConfigurationApiResource`의 `retrieveOneByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/configurations/{configId}` - GlobalConfigurationApiResource.updateConfiguration
- **설명**: `GlobalConfigurationApiResource`의 `updateConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/configurations/name/{configName}` - GlobalConfigurationApiResource.updateConfigurationByName
- **설명**: `GlobalConfigurationApiResource`의 `updateConfigurationByName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/internal/configurations/name/{configName}/value/{configValue}` - InternalConfigurationsApiResource.updateGlobalConfiguration
- **설명**: `InternalConfigurationsApiResource`의 `updateGlobalConfiguration` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `configName` (PathParam): `String` 타입 식별자/필터
  - `configValue` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/externalservice/{servicename}` - ExternalServicesConfigurationApiResource.retrieveOne
- **설명**: `ExternalServicesConfigurationApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/externalservice/{servicename}` - ExternalServicesConfigurationApiResource.updateExternalServiceProperties
- **설명**: `ExternalServicesConfigurationApiResource`의 `updateExternalServiceProperties` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/holidays` - HolidaysApiResource.createNewHoliday
- **설명**: `HolidaysApiResource`의 `createNewHoliday` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/holidays/{holidayId}` - HolidaysApiResource.handleCommands
- **설명**: `HolidaysApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/holidays/{holidayId}` - HolidaysApiResource.retrieveOne
- **설명**: `HolidaysApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/holidays/{holidayId}` - HolidaysApiResource.update
- **설명**: `HolidaysApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/holidays/{holidayId}` - HolidaysApiResource.delete
- **설명**: `HolidaysApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/holidays` - HolidaysApiResource.retrieveAllHolidays
- **설명**: `HolidaysApiResource`의 `retrieveAllHolidays` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/holidays/template` - HolidaysApiResource.retrieveRepaymentScheduleUpdationTyeOptions
- **설명**: `HolidaysApiResource`의 `retrieveRepaymentScheduleUpdationTyeOptions` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodeValuesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/api/CodesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/ExternalServicesConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/GlobalConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/api/InternalConfigurationsApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/dataqueries/api/DatatablesApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/holiday/api/HolidaysApiResource.java`

---

## [SYB] API명세서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

### SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerJobApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/InlineJobApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveAll` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveOne` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveByShortName` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveHistory` |
| `GET` | `/v1/jobs` | `SchedulerJobApiResource.retrieveHistoryByShortName` |
| `POST` | `/v1/jobs` | `SchedulerJobApiResource.executeJob` |
| `POST` | `/v1/jobs` | `SchedulerJobApiResource.executeJobByShortName` |
| `PUT` | `/v1/jobs` | `SchedulerJobApiResource.updateJobDetail` |
| `PUT` | `/v1/jobs` | `SchedulerJobApiResource.updateJobDetailByShortName` |
| `POST` | `/v1/jobs/{jobName}/inline` | `InlineJobApiResource.executeInlineJob` |
| `GET` | `/v1/scheduler` | `SchedulerApiResource.retrieveStatus` |
| `POST` | `/v1/scheduler` | `SchedulerApiResource.changeSchedulerStatus` |

#### `GET /v1/jobs` - SchedulerJobApiResource.retrieveAll
- **설명**: `SchedulerJobApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs` - SchedulerJobApiResource.retrieveOne
- **설명**: `SchedulerJobApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs` - SchedulerJobApiResource.retrieveByShortName
- **설명**: `SchedulerJobApiResource`의 `retrieveByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs` - SchedulerJobApiResource.retrieveHistory
- **설명**: `SchedulerJobApiResource`의 `retrieveHistory` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs` - SchedulerJobApiResource.retrieveHistoryByShortName
- **설명**: `SchedulerJobApiResource`의 `retrieveHistoryByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/jobs` - SchedulerJobApiResource.executeJob
- **설명**: `SchedulerJobApiResource`의 `executeJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/jobs` - SchedulerJobApiResource.executeJobByShortName
- **설명**: `SchedulerJobApiResource`의 `executeJobByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/jobs` - SchedulerJobApiResource.updateJobDetail
- **설명**: `SchedulerJobApiResource`의 `updateJobDetail` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/jobs` - SchedulerJobApiResource.updateJobDetailByShortName
- **설명**: `SchedulerJobApiResource`의 `updateJobDetailByShortName` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/jobs/{jobName}/inline` - InlineJobApiResource.executeInlineJob
- **설명**: `InlineJobApiResource`의 `executeInlineJob` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/scheduler` - SchedulerApiResource.retrieveStatus
- **설명**: `SchedulerApiResource`의 `retrieveStatus` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/scheduler` - SchedulerApiResource.changeSchedulerStatus
- **설명**: `SchedulerApiResource`의 `changeSchedulerStatus` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanCOBCatchUpApiResource.java, fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/loans/oldest-cob-closed` | `LoanCOBCatchUpApiResource.getOldestCOBProcessedLoan` |
| `POST` | `/v1/loans/catch-up` | `LoanCOBCatchUpApiResource.executeLoanCOBCatchUp` |
| `GET` | `/v1/loans/is-catch-up-running` | `LoanCOBCatchUpApiResource.isCatchUpRunning` |
| `GET` | `/v1/jobs/names` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs` |
| `GET` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep` |
| `PUT` | `/v1/jobs/{jobName}/steps` | `ConfigureBusinessStepApiResource.updateJobBusinessStepConfig` |
| `GET` | `/v1/jobs/{jobName}/available-steps` | `ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep` |

#### `GET /v1/loans/oldest-cob-closed` - LoanCOBCatchUpApiResource.getOldestCOBProcessedLoan
- **설명**: `LoanCOBCatchUpApiResource`의 `getOldestCOBProcessedLoan` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/loans/catch-up` - LoanCOBCatchUpApiResource.executeLoanCOBCatchUp
- **설명**: `LoanCOBCatchUpApiResource`의 `executeLoanCOBCatchUp` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/loans/is-catch-up-running` - LoanCOBCatchUpApiResource.isCatchUpRunning
- **설명**: `LoanCOBCatchUpApiResource`의 `isCatchUpRunning` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/names` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessJobs
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessJobs` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.retrieveAllConfiguredBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllConfiguredBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/jobs/{jobName}/steps` - ConfigureBusinessStepApiResource.updateJobBusinessStepConfig
- **설명**: `ConfigureBusinessStepApiResource`의 `updateJobBusinessStepConfig` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/jobs/{jobName}/available-steps` - ConfigureBusinessStepApiResource.retrieveAllAvailableBusinessStep
- **설명**: `ConfigureBusinessStepApiResource`의 `retrieveAllAvailableBusinessStep` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/ConfigureBusinessStepApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/cob/api/LoanCOBCatchUpApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/InlineJobApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/jobs/api/SchedulerJobApiResource.java`

---

## [SYI] API명세서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

### SYI-001 대외연계 및 알림 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/api/BulkImportApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/sms/api/SmsCampaignApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailCampaignApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailConfigurationApiResource.java, fineract-provider/src/main/java/org/apache/fineract/infrastructure/entityaccess/api/FineractEntityApiResource.java`

#### 엔드포인트 목록
| HTTP | URL 경로 | 역할 / 자원 |
| :--- | :--- | :--- |
| `GET` | `/v1/imports` | `BulkImportApiResource.retrieveImportDocuments` |
| `GET` | `/v1/imports/getOutputTemplateLocation` | `BulkImportApiResource.retriveOutputTemplateLocation` |
| `GET` | `/v1/imports/downloadOutputTemplate` | `BulkImportApiResource.getOutputTemplate` |
| `GET` | `/v1/smscampaigns/template` | `SmsCampaignApiResource.template` |
| `POST` | `/v1/smscampaigns` | `SmsCampaignApiResource.createCampaign` |
| `GET` | `/v1/smscampaigns/{resourceId}` | `SmsCampaignApiResource.retrieveCampaign` |
| `GET` | `/v1/smscampaigns` | `SmsCampaignApiResource.retrieveAllEmails` |
| `PUT` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.updateCampaign` |
| `POST` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.handleCommands` |
| `POST` | `/v1/smscampaigns/preview` | `SmsCampaignApiResource.preview` |
| `DELETE` | `/v1/smscampaigns/{campaignId}` | `SmsCampaignApiResource.delete` |
| `GET` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.retrieveOneCampaign` |
| `GET` | `/v1/email/campaign` | `EmailCampaignApiResource.retrieveAllCampaign` |
| `POST` | `/v1/email/campaign` | `EmailCampaignApiResource.createCampaign` |
| `PUT` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.updateCampaign` |
| `POST` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.activate` |
| `POST` | `/v1/email/campaign/preview` | `EmailCampaignApiResource.preview` |
| `GET` | `/v1/email/campaign/template` | `EmailCampaignApiResource.template` |
| `GET` | `/v1/email/campaign/template/{resourceId}` | `EmailCampaignApiResource.retrieveOneTemplate` |
| `DELETE` | `/v1/email/campaign/{resourceId}` | `EmailCampaignApiResource.delete` |
| `GET` | `/v1/email` | `EmailApiResource.retrieveAllEmails` |
| `GET` | `/v1/email/pendingEmail` | `EmailApiResource.retrievePendingEmail` |
| `GET` | `/v1/email/sentEmail` | `EmailApiResource.retrieveSentEmail` |
| `GET` | `/v1/email/messageByStatus` | `EmailApiResource.retrieveAllEmailByStatus` |
| `GET` | `/v1/email/failedEmail` | `EmailApiResource.retrieveFailedEmail` |
| `POST` | `/v1/email` | `EmailApiResource.create` |
| `GET` | `/v1/email/{resourceId}` | `EmailApiResource.retrieveOne` |
| `PUT` | `/v1/email/{resourceId}` | `EmailApiResource.update` |
| `DELETE` | `/v1/email/{resourceId}` | `EmailApiResource.delete` |
| `GET` | `/v1/email/configuration` | `EmailConfigurationApiResource.retrieveAll` |
| `PUT` | `/v1/email/configuration` | `EmailConfigurationApiResource.updateConfiguration` |
| `GET` | `/v1/entitytoentitymapping` | `FineractEntityApiResource.retrieveAll` |
| `GET` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.retrieveOne` |
| `GET` | `/v1/entitytoentitymapping/{mapId}/{fromId}/{toId}` | `FineractEntityApiResource.getEntityToEntityMappings` |
| `POST` | `/v1/entitytoentitymapping/{relId}` | `FineractEntityApiResource.createMap` |
| `PUT` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.updateMap` |
| `DELETE` | `/v1/entitytoentitymapping/{mapId}` | `FineractEntityApiResource.delete` |

#### `GET /v1/imports` - BulkImportApiResource.retrieveImportDocuments
- **설명**: `BulkImportApiResource`의 `retrieveImportDocuments` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `entityType` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/imports/getOutputTemplateLocation` - BulkImportApiResource.retriveOutputTemplateLocation
- **설명**: `BulkImportApiResource`의 `retriveOutputTemplateLocation` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `importDocumentId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/imports/downloadOutputTemplate` - BulkImportApiResource.getOutputTemplate
- **설명**: `BulkImportApiResource`의 `getOutputTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `importDocumentId` (QueryParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/smscampaigns/template` - SmsCampaignApiResource.template
- **설명**: `SmsCampaignApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/smscampaigns` - SmsCampaignApiResource.createCampaign
- **설명**: `SmsCampaignApiResource`의 `createCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/smscampaigns/{resourceId}` - SmsCampaignApiResource.retrieveCampaign
- **설명**: `SmsCampaignApiResource`의 `retrieveCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/smscampaigns` - SmsCampaignApiResource.retrieveAllEmails
- **설명**: `SmsCampaignApiResource`의 `retrieveAllEmails` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.updateCampaign
- **설명**: `SmsCampaignApiResource`의 `updateCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.handleCommands
- **설명**: `SmsCampaignApiResource`의 `handleCommands` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/smscampaigns/preview` - SmsCampaignApiResource.preview
- **설명**: `SmsCampaignApiResource`의 `preview` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/smscampaigns/{campaignId}` - SmsCampaignApiResource.delete
- **설명**: `SmsCampaignApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `campaignId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.retrieveOneCampaign
- **설명**: `EmailCampaignApiResource`의 `retrieveOneCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/campaign` - EmailCampaignApiResource.retrieveAllCampaign
- **설명**: `EmailCampaignApiResource`의 `retrieveAllCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/email/campaign` - EmailCampaignApiResource.createCampaign
- **설명**: `EmailCampaignApiResource`의 `createCampaign` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.updateCampaign
- **설명**: `EmailCampaignApiResource`의 `updateCampaign` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.activate
- **설명**: `EmailCampaignApiResource`의 `activate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
  - `command` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/email/campaign/preview` - EmailCampaignApiResource.preview
- **설명**: `EmailCampaignApiResource`의 `preview` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/campaign/template` - EmailCampaignApiResource.template
- **설명**: `EmailCampaignApiResource`의 `template` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/campaign/template/{resourceId}` - EmailCampaignApiResource.retrieveOneTemplate
- **설명**: `EmailCampaignApiResource`의 `retrieveOneTemplate` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/email/campaign/{resourceId}` - EmailCampaignApiResource.delete
- **설명**: `EmailCampaignApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email` - EmailApiResource.retrieveAllEmails
- **설명**: `EmailApiResource`의 `retrieveAllEmails` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/pendingEmail` - EmailApiResource.retrievePendingEmail
- **설명**: `EmailApiResource`의 `retrievePendingEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/sentEmail` - EmailApiResource.retrieveSentEmail
- **설명**: `EmailApiResource`의 `retrieveSentEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/messageByStatus` - EmailApiResource.retrieveAllEmailByStatus
- **설명**: `EmailApiResource`의 `retrieveAllEmailByStatus` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `status` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
  - `fromDate` (QueryParam): `DateParam` 타입 식별자/필터
  - `toDate` (QueryParam): `DateParam` 타입 식별자/필터
  - `locale` (QueryParam): `String` 타입 식별자/필터
  - `dateFormat` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/failedEmail` - EmailApiResource.retrieveFailedEmail
- **설명**: `EmailApiResource`의 `retrieveFailedEmail` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `offset` (QueryParam): `Integer` 타입 식별자/필터
  - `limit` (QueryParam): `Integer` 타입 식별자/필터
  - `orderBy` (QueryParam): `String` 타입 식별자/필터
  - `sortOrder` (QueryParam): `String` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/email` - EmailApiResource.create
- **설명**: `EmailApiResource`의 `create` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/{resourceId}` - EmailApiResource.retrieveOne
- **설명**: `EmailApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/email/{resourceId}` - EmailApiResource.update
- **설명**: `EmailApiResource`의 `update` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/email/{resourceId}` - EmailApiResource.delete
- **설명**: `EmailApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `resourceId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/email/configuration` - EmailConfigurationApiResource.retrieveAll
- **설명**: `EmailConfigurationApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/email/configuration` - EmailConfigurationApiResource.updateConfiguration
- **설명**: `EmailConfigurationApiResource`의 `updateConfiguration` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/entitytoentitymapping` - FineractEntityApiResource.retrieveAll
- **설명**: `FineractEntityApiResource`의 `retrieveAll` 엔드포인트 호출 처리.
- **파라미터**: 기본 JSON Request Body 페이로드
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.retrieveOne
- **설명**: `FineractEntityApiResource`의 `retrieveOne` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `GET /v1/entitytoentitymapping/{mapId}/{fromId}/{toId}` - FineractEntityApiResource.getEntityToEntityMappings
- **설명**: `FineractEntityApiResource`의 `getEntityToEntityMappings` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
  - `fromId` (PathParam): `Long` 타입 식별자/필터
  - `toId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `POST /v1/entitytoentitymapping/{relId}` - FineractEntityApiResource.createMap
- **설명**: `FineractEntityApiResource`의 `createMap` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `relId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `PUT /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.updateMap
- **설명**: `FineractEntityApiResource`의 `updateMap` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

#### `DELETE /v1/entitytoentitymapping/{mapId}` - FineractEntityApiResource.delete
- **설명**: `FineractEntityApiResource`의 `delete` 엔드포인트 호출 처리.
- **파라미터 목록**:
  - `mapId` (PathParam): `Long` 타입 식별자/필터
- **응답 형식**: `application/json` (Fineract Standard CommandProcessingResult / Query Result DTO)

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/bulkimport/api/BulkImportApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailCampaignApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/email/api/EmailConfigurationApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/campaigns/sms/api/SmsCampaignApiResource.java`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/entityaccess/api/FineractEntityApiResource.java`
