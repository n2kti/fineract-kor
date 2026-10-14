# [FN] API명세서

> 화면 4개 롤업(중분류 FN, 대분류 FN). 화면 단위 원본은 `specs/<화면>/api-spec.md`.

## FN-002 대출신청및승인

> 원본: `FN-002-대출신청및승인/api-spec.md`

## [FN-002] 대출신청및승인 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `FN-002-대출신청및승인` 화면에서 사용하는 차주 대출 신청서 접수, 심사역 배정, 대출 승인/반려/취소 상태 전이, 대출 모집인(Originator) 연계 및 시점별 원장 조회를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan`, `m_loan_approved_amount_history`, `m_loan_status_change_history`, `m_loan_officer_assignment_history`, `m_loan_originator`, `m_loan_originator_mapping`, `m_loan_account_locks` (참조: [data-model.md](/specs/FN-002-대출신청및승인/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/loans` | 대출 신청서 제출 (`m_loan` 생성) | `LoansApiResource` | `calculateLoanScheduleOrSubmitLoanApplication` |
| `GET` | `/v1/loans` | 대출 계좌 목록 조회 | `LoansApiResource` | `retrieveAll` |
| `GET` | `/v1/loans/template` | 대출 신청용 템플릿 기본값 조회 | `LoansApiResource` | `template` |
| `GET` | `/v1/loans/{loanId}` | 대출 계좌 상세 원장 조회 | `LoansApiResource` | `retrieveLoan` |
| `PUT` | `/v1/loans/{loanId}` | 대출 신청서 수정 (신청 상태) | `LoansApiResource` | `modifyLoanApplication` |
| `DELETE` | `/v1/loans/{loanId}` | 대출 신청서 삭제 (신청 상태) | `LoansApiResource` | `deleteLoanApplication` |
| `POST` | `/v1/loans/{loanId}?command=approve` | 대출 신청 승인 처리 (`m_loan_approved_amount_history` 적재) | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=reject` | 대출 신청 반려(Reject) 처리 | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=withdrawnByApplicant` | 대출 신청 차주 자진 취소(Withdraw) 처리 | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=assignLoanOfficer` | 대출 담당 심사역 배정 (`m_loan_officer_assignment_history` 적재) | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=unassignLoanOfficer` | 대출 담당 심사역 배정 해제 | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loan-originators` | 대출 모집인(Originator) 신규 등록 (`m_loan_originator`) | `LoanOriginatorApiResource` | `createLoanOriginator` |
| `GET` | `/v1/loan-originators` | 대출 모집인 전체 목록 조회 | `LoanOriginatorApiResource` | `retrieveAllLoanOriginators` |
| `GET` | `/v1/loan-originators/{originatorId}` | 대출 모집인 상세 정보 조회 | `LoanOriginatorApiResource` | `retrieveLoanOriginator` |
| `PUT` | `/v1/loan-originators/{originatorId}` | 대출 모집인 정보 수정 | `LoanOriginatorApiResource` | `updateLoanOriginator` |
| `DELETE` | `/v1/loan-originators/{originatorId}` | 대출 모집인 삭제 | `LoanOriginatorApiResource` | `deleteLoanOriginator` |
| `GET` | `/v1/loans/{loanId}/originators` | 특정 대출 계좌의 대출 모집인 매핑 조회 | `LoanOriginatorsApiResource` | `getLoanOriginators` |
| `POST` | `/v1/loans/{loanId}/originators/{originatorId}` | 대출 계좌-모집인 매핑 등록 (`m_loan_originator_mapping`) | `LoanOriginatorsApiResource` | `createLoanOriginatorMapping` |
| `DELETE` | `/v1/loans/{loanId}/originators/{originatorId}` | 대출 계좌-모집인 매핑 해제 | `LoanOriginatorsApiResource` | `deleteLoanOriginatorMapping` |
| `GET` | `/v1/loans/at-date/{loanId}` | 특정 기준일 시점(Point-in-Time) 대출 원장 조회 | `LoansPointInTimeApiResource` | `getLoanDataAtDate` |

---

### 2. API 상세 명세

#### 2.1 대출 신청서 제출 (`POST /v1/loans`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
* **메서드명**: `public String calculateLoanScheduleOrSubmitLoanApplication(@QueryParam("command") final String commandParam, @Context final UriInfo uriInfo, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:566`)
* **JAX-RS 어노테이션**:
  * `@Path("/v1/loans")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
  * `@Consumes({ MediaType.APPLICATION_JSON })` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:557`)
  * `@Produces({ MediaType.APPLICATION_JSON })` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:558`)
* **권한 체크**: `CREATE_LOAN` (신청서 등록 시 서비스 계층에서 검증) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java:293`)
* **요청 필드 (`PostLoansRequest`)**:
  * `clientId` (Long, 조건부 필수): 차주 고객 식별자 (`m_client(id)`)
  * `groupId` (Long, 조건부 필수): 차주 그룹 식별자 (`m_group(id)`)
  * `productId` (Long, 필수): 대출 상품 식별자 (`m_product_loan(id)`)
  * `principal` (BigDecimal, 필수): 신청 대출 원금 (`principal_amount_proposed`)
  * `loanTermFrequency` (Integer, 필수): 대출 기간
  * `loanTermFrequencyType` (Integer, 필수): 기간 단위 (2: 월, 3: 년)
  * `numberOfRepayments` (Integer, 필수): 상환 회차 수
  * `repaymentEvery` (Integer, 필수): 상환 주기
  * `repaymentFrequencyType` (Integer, 필수): 상환 주기 단위
  * `interestRatePerPeriod` (BigDecimal, 필수): 적용 약정 금리
  * `amortizationType` (Integer, 필수): 원리금 균등(1) / 원금 균등(0)
  * `interestType` (Integer, 필수): 고정 잔액(0) / 잔액 체감(1)
  * `interestCalculationPeriodType` (Integer, 필수): 이자 산출 주기
  * `transactionProcessingStrategyCode` (String, 필수): 거래 처리 전략 코드
  * `expectedDisbursementDate` (String, 필수): 지급 예정 일자 (형식: `dd MMMM yyyy`)
  * `submittedOnDate` (String, 필수): 신청 접수 일자 (`submittedon_date`)
  * `loanOfficerId` (Long, 선택): 배정할 대출 심사역 식별자 (`m_staff(id)`)
  *(근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResourceSwagger.java:43-200`)*
* **응답 필드 (`PostLoansResponse`)**:
  * `loanId` (Long): 생성된 대출 계좌 식별자 (`m_loan.id`)
  * `resourceId` (Long): 대출 계좌 식별자
  * `officeId` (Long): 관할 영업점 식별자
  * `clientId` (Long): 차주 식별자
  *(근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResourceSwagger.java:995-1010`)*

---

#### 2.2 대출 계좌 상세 원장 조회 (`GET /v1/loans/{loanId}`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource`
* **메서드명**: `public String retrieveLoan(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:778`)
* **JAX-RS 어노테이션**:
  * `@GET` `@Path("{loanId}")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:771-772`)
* **권한 체크**: `this.context.authenticatedUser().validateHasReadPermission(RESOURCE_NAME_FOR_PERMISSIONS)` (`READ_LOAN`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:782`)
* **응답 필드 (`GetLoansLoanIdResponse`)**:
  * `id` (Long): 대출 계좌 ID
  * `accountNo` (String): 대출 계좌 번호
  * `status` (LoanStatusEnumData): 상태 (`SUBMITTED_AND_PENDING_APPROVAL`, `APPROVED`, `ACTIVE`, `CLOSED_OBLIGATIONS_MET` 등)
  * `summary` (LoanSummaryData): 잔액, 원금, 이자, 수수료, 연체료 집계치
  * `timeline` (LoanTimelineData): `submittedOnDate`, `approvedOnDate`, `expectedDisbursementDate`, `actualDisbursementDate`

---

#### 2.3 대출 승인/반려/취소/심사역배정 상태 전이 (`POST /v1/loans/{loanId}?command=...`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource`
* **메서드명**: `public String stateTransitions(@PathParam("loanId") final Long loanId, @QueryParam("command") final String commandParam, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1320`)
* **JAX-RS 어노테이션**:
  * `@POST` `@Path("{loanId}")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1309-1310`)
* **지원 커맨드 및 권한 체크**:
  1. `command=approve` (대출 승인): 권한 `APPROVE_LOAN` (요청 본문: `approvedOnDate`, `approvedLoanAmount`, `expectedDisbursementDate`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1329`)
  2. `command=reject` (대출 반려): 권한 `REJECT_LOAN` (요청 본문: `rejectedOnDate`, `note`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1335`)
  3. `command=withdrawnByApplicant` (차주 자진 취소): 권한 `WITHDRAW_LOAN` (요청 본문: `withdrawnOnDate`, `note`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1339`)
  4. `command=assignLoanOfficer` (대출 심사역 배정): 권한 `UPDATELOANOFFICER_LOAN` (요청 본문: `toLoanOfficerId`, `assignmentDate`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1359`)
  5. `command=unassignLoanOfficer` (심사역 배정 해제): 권한 `REMOVELOANOFFICER_LOAN` (요청 본문: `unassignedDate`) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1363`)
* **응답 필드 (`PostLoansLoanIdResponse`)**: `loanId`, `resourceId`, `changes`

---

#### 2.4 대출 모집인(Loan Originator) 관리 (`LoanOriginatorApiResource` / `LoanOriginatorsApiResource`)
* **자바 클래스**:
  * `org.apache.fineract.portfolio.loanorigination.api.LoanOriginatorApiResource` (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorApiResource.java:51`)
  * `org.apache.fineract.portfolio.loanorigination.api.LoanOriginatorsApiResource` (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorsApiResource.java:51`)
* **엔드포인트**:
  * `POST /v1/loan-originators` (createLoanOriginator): 모집인 등록 (`name`, `originatorType`, `channelType`) (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorApiResource.java:62`)
  * `GET /v1/loan-originators` (retrieveAllLoanOriginators): 모집인 목록 조회 (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorApiResource.java:75`)
  * `GET /v1/loan-originators/{originatorId}` (retrieveLoanOriginator): 모집인 상세 조회 (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorApiResource.java:99`)
  * `POST /v1/loans/{loanId}/originators/{originatorId}` (createLoanOriginatorMapping): 대출 계좌-모집인 매핑 등록 (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorsApiResource.java:103`)
  * `DELETE /v1/loans/{loanId}/originators/{originatorId}` (deleteLoanOriginatorMapping): 매핑 해제 (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorsApiResource.java:190`)
* **권한 체크**: `READ_LOAN`, `CREATE_LOAN` 등 연관 권한 위임 (근거: `fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/api/LoanOriginatorsApiResource.java:68,106,193`)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 20개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 상태 전이 커맨드, 모집인 매핑 및 권한 확인 완료)

---

## FN-003 대출실행및지급

> 원본: `FN-003-대출실행및지급/api-spec.md`

## [FN-003] 대출실행및지급 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `FN-003-대출실행및지급` 화면에서 사용하는 대출금 지급(Disbursement), 분할 실행(Tranche), 저축 계좌 직접 이체, 실행 취소(Undo Disbursal), 담보(Collateral) 관리 및 가용 지급 한도 조정을 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_disbursement_detail`, `m_loan_tranche_charges`, `m_loan_tranche_disbursement_charge`, `m_loan_collateral`, `m_loan_collateral_management`, `m_loan_buy_down_fee_balance`, `m_loan_capitalized_income_balance` (참조: [data-model.md](/specs/FN-003-대출실행및지급/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/loans/{loanId}?command=disburse` | 대출금 지급(실행) 처리 (`m_loan_disbursement_detail` 생성) | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=disburseToSavings` | 연결된 저축 계좌로 대출금 직접 지급/이체 실행 | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=disburseWithoutAutoDownPayment` | 계약금 자동 차감 없이 대출금 전액 지급 실행 | `LoansApiResource` | `stateTransitions` |
| `POST` | `/v1/loans/{loanId}?command=undodisbursal` | 대출금 지급 실행 취소(원복 및 계좌 상태 Approval로 복귀) | `LoansApiResource` | `stateTransitions` |
| `PUT` | `/v1/loans/{loanId}/available-disbursement-amount` | 대출 가용 지급 한도 금액 수정 | `LoansApiResource` | `updateAvailableDisbursementAmount` |
| `GET` | `/v1/loans/{loanId}/disbursements/{disbursementId}` | 특정 트랜치(분할 지급) 상세 정보 조회 | `LoanDisbursementDetailApiResource` | `retriveDetail` |
| `PUT` | `/v1/loans/{loanId}/disbursements/{disbursementId}` | 특정 트랜치 분할 지급 일자 및 원금 금액 변경 | `LoanDisbursementDetailApiResource` | `updateDisbursementDateAndAmount` |
| `PUT` | `/v1/loans/{loanId}/disbursements/editDisbursements` | 복수 트랜치 분할 지급 계획 일괄 편집/추가/삭제 | `LoanDisbursementDetailApiResource` | `addAndDeleteDisbursementDetails` |
| `GET` | `/v1/loan-collateral-management/{collateralId}` | 대출 담보 상세 정보 조회 (`m_loan_collateral_management`) | `LoanCollateralManagementApiResource` | `getLoanCollateralManagementData` |
| `DELETE` | `/v1/loan-collateral-management/{id}` | 대출 담보 설정 해제/삭제 | `LoanCollateralManagementApiResource` | `deleteLoanCollateralManagement` |

---

### 2. API 상세 명세

#### 2.1 대출금 지급 및 실행 상태 전이 (`POST /v1/loans/{loanId}?command=disburse|disburseToSavings|undodisbursal`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
* **메서드명**: `public String stateTransitions(@PathParam("loanId") final Long loanId, @QueryParam("command") final String commandParam, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1320`)
* **JAX-RS 어노테이션**:
  * `@POST` `@Path("{loanId}")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:1309-1310`)
* **커맨드별 처리 및 권한**:
  1. `command=disburse` (대출금 지급):
     * 권한: `DISBURSE_LOAN` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java:652`)
     * 요청 필드: `actualDisbursementDate` (지급 실행일), `transactionAmount` (지급 원금), `paymentTypeId` (지급 수단), `note` (비고)
  2. `command=disburseToSavings` (저축 계좌 직접 지급):
     * 권한: `DISBURSETOSAVINGS_LOAN` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java:710`)
  3. `command=undodisbursal` (지급 취소/원복):
     * 권한: `UNDODISBURSAL_LOAN` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java:820`)
     * 요청 필드: `note` (취소 사유)
* **응답 필드 (`PostLoansLoanIdResponse`)**: `loanId`, `resourceId`, `changes` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResourceSwagger.java:1015-1025`)

---

#### 2.2 트랜치 분할 지급 상세 관리 (`LoanDisbursementDetailApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanDisbursementDetailApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:49`)
* **기본 경로**: `@Path("/v1/loans/{loanId}/disbursements")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:51`)
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/disbursements/{disbursementId}` (retriveDetail):
    * 메서드: `public String retriveDetail(@PathParam("loanId") final Long loanId, @PathParam("disbursementId") final Long disbursementId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:97`)
    * 권한: `this.context.authenticatedUser().validateHasReadPermission("LOAN")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:100`)
  * `PUT /v1/loans/{loanId}/disbursements/{disbursementId}` (updateDisbursementDateAndAmount):
    * 메서드: `public String updateDisbursementDateAndAmount(@PathParam("loanId") final Long loanId, @PathParam("disbursementId") final Long disbursementId, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:70`)
    * 권한: `UPDATE_DISBURSEMENT` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java:950`)
    * 요청 필드: `expectedDisbursementDate` (지급 예정일), `principal` (해당 트랜치 금액)
  * `PUT /v1/loans/{loanId}/disbursements/editDisbursements` (addAndDeleteDisbursementDetails):
    * 메서드: `public String addAndDeleteDisbursementDetails(@PathParam("loanId") final Long loanId, final String apiRequestBodyAsJson)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanDisbursementDetailApiResource.java:83`)
    * 권한: `UPDATE_DISBURSEMENT` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java:962`)
    * 요청 필드: `disbursementData` (트랜치 목록 Array: `id`, `expectedDisbursementDate`, `principal`)

---

#### 2.3 대출 담보 관리 (`LoanCollateralManagementApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.collateralmanagement.api.LoanCollateralManagementApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:41`)
* **기본 경로**: `@Path("/v1/loan-collateral-management")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:43`)
* **엔드포인트**:
  * `GET /v1/loan-collateral-management/{collateralId}` (getLoanCollateralManagementData):
    * 메서드: `public String getLoanCollateralManagementData(@PathParam("collateralId") final Long collateralId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:70`)
    * 권한: `this.context.authenticatedUser().validateHasReadPermission("COLLATERAL")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:74`)
  * `DELETE /v1/loan-collateral-management/{id}` (deleteLoanCollateralManagement):
    * 메서드: `public String deleteLoanCollateralManagement(@PathParam("id") final Long id)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:56`)
    * 권한: `DELETE_COLLATERAL` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collateralmanagement/api/LoanCollateralManagementApiResource.java:60`)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 10개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 지급/취소 커맨드, 트랜치 및 담보 관리 API 소스 확인 완료)

---

## FN-004 상환스케줄

> 원본: `FN-004-상환스케줄/api-spec.md`

## [FN-004] 상환스케줄 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `FN-004-상환스케줄` 화면에서 사용하는 대출 상환 계획(스케줄) 사전 시뮬레이션 계산, 대출 계약 조건 변동(Term Variations) 반영 스케줄 재산출, 확정 스케줄 조회, 미래 예상 스케줄 및 과거 스케줄 변경 이력 조회를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_repayment_schedule`, `m_loan_repayment_schedule_history`, `m_loan_amortization_allocation_mapping`, `m_loan_progressive_model`, `m_loan_recalculation_details`, `m_loan_interest_recalculation_additional_details` (참조: [data-model.md](/specs/FN-004-상환스케줄/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/loans?command=calculateLoanSchedule` | 대출 신청 전 상환 스케줄 사전 시뮬레이션 계산 | `LoansApiResource` | `calculateLoanScheduleOrSubmitLoanApplication` |
| `POST` | `/v1/loans/{loanId}/schedule?command=calculateLoanSchedule` | 기존 대출 조건 변경에 따른 상환 스케줄 재계산 시뮬레이션 | `LoanScheduleApiResource` | `calculateLoanScheduleOrSubmitVariableSchedule` |
| `POST` | `/v1/loans/{loanId}/schedule?command=addVariations` | 대출 조건 변동(금리/유예 등) 예외 스케줄 확정 반영 | `LoanScheduleApiResource` | `calculateLoanScheduleOrSubmitVariableSchedule` |
| `POST` | `/v1/loans/{loanId}/schedule?command=deleteVariations` | 설정된 대출 변동 예외 스케줄 삭제 및 원복 | `LoanScheduleApiResource` | `calculateLoanScheduleOrSubmitVariableSchedule` |
| `GET` | `/v1/loans/{loanId}?associations=repaymentSchedule` | 대출 계좌의 회차별 확정 상환 스케줄 조회 (`m_loan_repayment_schedule`) | `LoansApiResource` | `retrieveLoan` |
| `GET` | `/v1/loans/{loanId}?associations=futureSchedule` | 이자 재계산(Recalculation) 적용 미래 예상 스케줄 조회 | `LoansApiResource` | `retrieveLoan` |
| `GET` | `/v1/loans/{loanId}?associations=repaymentScheduleHistory` | 스케줄 변경 전 과거 상환 스케줄 이력 조회 (`m_loan_repayment_schedule_history`) | `LoansApiResource` | `retrieveLoan` |

---

### 2. API 상세 명세

#### 2.1 대출 신청 전 상환 스케줄 사전 계산 (`POST /v1/loans?command=calculateLoanSchedule`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
* **메서드명**: `public String calculateLoanScheduleOrSubmitLoanApplication(@QueryParam("command") final String commandParam, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:566`)
* **JAX-RS 어노테이션**:
  * `@POST` `@Path("/v1/loans")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180,555`)
  * `@Consumes({ MediaType.APPLICATION_JSON })` / `@Produces({ MediaType.APPLICATION_JSON })`
* **권한 체크**: `READ_LOAN` (사전 계산 조회 성격으로 읽기 권한 필요) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:576`)
* **요청 필드 (`PostLoansRequest`)**:
  * `principal` (BigDecimal, 필수): 대출 원금
  * `numberOfRepayments` (Integer, 필수): 상환 횟수
  * `repaymentEvery` (Integer, 필수): 상환 주기
  * `repaymentFrequencyType` (Integer, 필수): 상환 주기 단위 (일/주/월/년)
  * `interestRatePerPeriod` (BigDecimal, 필수): 약정 이자율
  * `interestType` (Integer, 필수): 이자 계산 방식 (0: Flat, 1: Declining Balance)
  * `amortizationType` (Integer, 필수): 상각 방식 (0: Equal Principal, 1: Equal Installments)
  * `expectedDisbursementDate` (String, 필수): 지급 예정일
  * `repaymentsStartingFromDate` (String, 선택): 첫 상환 시작일
* **응답 필드 (`LoanScheduleData` / `PostLoansResponse`)**:
  * `currency`: 통화 정보
  * `loanTermInDays`: 대출 총 일수
  * `totalPrincipalDisbursed`: 총 지급 원금
  * `totalPrincipalExpected`: 총 상환 예정 원금
  * `totalInterestCharged`: 총 부과 이자
  * `totalFeeChargesCharged`: 총 수수료
  * `totalPenaltyChargesCharged`: 총 연체료
  * `totalRepaymentExpected`: 총 상환 예정 금액
  * `periods` (Array): 회차별 상환 계획 (`period`, `dueDate`, `principalDue`, `interestDue`, `feeChargesDue`, `penaltyChargesDue`, `totalDueForPeriod`, `principalOutstanding`)

---

#### 2.2 대출 조건 변동 스케줄 계산 및 반영 (`LoanScheduleApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanScheduleApiResource` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:57`)
* **기본 경로**: `@Path("/v1/loans/{loanId}/schedule")` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:53`)
* **메서드명**: `public String calculateLoanScheduleOrSubmitVariableSchedule(@PathParam("loanId") final Long loanId, @QueryParam("command") final String commandParam, ...)` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:77`)
* **커맨드별 처리 및 권한**:
  1. `command=calculateLoanSchedule` (스케줄 시뮬레이션 계산):
     * 권한: `this.context.authenticatedUser().validateHasReadPermission("LOAN")` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:83`)
     * 반환: `LoanScheduleData` (시뮬레이션 산출 스케줄)
  2. `command=addVariations` (변동 조건 스케줄 확정 생성):
     * 권한: `SCHEDULING_LOAN` / `UPDATE_LOAN` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:90`)
     * 요청 필드: `exceptions` (Array: `modifiedInstallment`, `newDueDate`, `newInterestRate`, `principalGracePeriod` 등)
  3. `command=deleteVariations` (변동 조건 예외 삭제):
     * 권한: `UPDATE_LOAN` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanScheduleApiResource.java:92`)

---

#### 2.3 확정 스케줄 및 과거 이력 조회 (`GET /v1/loans/{loanId}?associations=...`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource`
* **메서드명**: `public String retrieveLoan(@PathParam("loanId") final Long loanId, @DefaultValue("all") @QueryParam("fields") final String fields, @Context final UriInfo uriInfo)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:778`)
* **권한 체크**: `this.context.authenticatedUser().validateHasReadPermission("LOAN")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:782`)
* **파라미터 조합**:
  * `associations=repaymentSchedule`: 현재 활성화된 회차별 상환 스케줄 데이터 반환
  * `associations=futureSchedule`: 이자 재계산 적용 시 향후 변동될 예상 스케줄 반환
  * `associations=repaymentScheduleHistory`: 재조정/재산출 전 과거 스케줄 이력(`m_loan_repayment_schedule_history`) 반환

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 7개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 스케줄 계산 커맨드, 변동 조건 파라미터 및 권한 소스 확인 완료)

---

## FN-006 연체및채권

> 원본: `FN-006-연체및채권/api-spec.md`

## [FN-006] 연체및채권 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `FN-006-연체및채권` 화면에서 사용하는 연체 구간(Delinquency Range), 연체 버킷(Delinquency Bucket), 대출 계좌별 연체 태그 이력 조회, 채권 관리 조치(Delinquency Action: Pause/Resume), 연체 수동 분류 및 대손충당금(Provisioning) 기준/분개 처리를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_delinquency_action`, `m_loan_delinquency_tag_history`, `m_loan_installment_delinquency_tag`, `m_loan_overdue_installment_charge`, `m_loanproduct_provisioning_mapping`, `m_loanproduct_provisioning_entry` (참조: [data-model.md](/specs/FN-006-연체및채권/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/v1/delinquency/ranges` | 연체 구간(Delinquency Range) 목록 조회 | `DelinquencyApiResource` | `getDelinquencyRanges` |
| `POST` | `/v1/delinquency/ranges` | 연체 구간 신규 생성 | `DelinquencyApiResource` | `createDelinquencyRange` |
| `GET` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 특정 연체 구간 상세 조회 | `DelinquencyApiResource` | `getDelinquencyRange` |
| `PUT` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 연체 구간 수정 | `DelinquencyApiResource` | `updateDelinquencyRange` |
| `DELETE` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 연체 구간 삭제 | `DelinquencyApiResource` | `deleteDelinquencyRange` |
| `GET` | `/v1/delinquency/buckets` | 연체 버킷(Delinquency Bucket) 목록 조회 | `DelinquencyApiResource` | `getDelinquencyBuckets` |
| `POST` | `/v1/delinquency/buckets` | 연체 버킷 신규 생성 | `DelinquencyApiResource` | `createDelinquencyBucket` |
| `GET` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 특정 연체 버킷 상세 조회 | `DelinquencyApiResource` | `getDelinquencyBucket` |
| `PUT` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 연체 버킷 수정 | `DelinquencyApiResource` | `updateDelinquencyBucket` |
| `DELETE` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 연체 버킷 삭제 | `DelinquencyApiResource` | `deleteDelinquencyBucket` |
| `GET` | `/v1/loans/{loanId}/delinquencytags` | 대출 계좌의 연체 등급/태그 변경 이력 조회 (`m_loan_delinquency_tag_history`) | `LoansApiResource` | `getDelinquencyTagHistory` |
| `GET` | `/v1/loans/{loanId}/delinquency-actions` | 대출 계좌의 채권 조치(Pause 등) 이력 조회 (`m_loan_delinquency_action`) | `LoansApiResource` | `getLoanDelinquencyActions` |
| `POST` | `/v1/loans/{loanId}/delinquency-actions` | 대출 연체 관리 조치(Pause/Resume) 등록 | `LoansApiResource` | `createLoanDelinquencyAction` |
| `POST` | `/v1/loans/{loanId}?command=assigndelinquency` | 대출 계좌 연체 수동 분류 및 강제 지정 | `LoansApiResource` | `stateTransitions` |
| `GET` | `/v1/provisioningcriteria` | 대손충당금 설정 기준 목록 조회 (`m_loanproduct_provisioning_mapping`) | `ProvisioningCriteriaApiResource` | `retrieveAllProvisioningCriterias` |
| `POST` | `/v1/provisioningcriteria` | 대손충당금 기준 생성 및 대출상품 매핑 등록 | `ProvisioningCriteriaApiResource` | `createProvisioningCriteria` |
| `GET` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 상세 조회 | `ProvisioningCriteriaApiResource` | `retrieveTemplate` |
| `PUT` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 수정 | `ProvisioningCriteriaApiResource` | `updateProvisioningCriteria` |
| `DELETE` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 삭제 | `ProvisioningCriteriaApiResource` | `deleteProvisioningCriteria` |
| `GET` | `/v1/provisioningentries` | 대손충당금 산출 분개 목록 조회 (`m_loanproduct_provisioning_entry`) | `ProvisioningEntriesApiResource` | `retrieveAllProvisioningEntries` |
| `POST` | `/v1/provisioningentries` | 대손충당금 적립액 자동 산출 분개 생성 | `ProvisioningEntriesApiResource` | `createProvisioningEntries` |
| `POST` | `/v1/provisioningentries/{entryId}?command=journalentry` | 산출된 대손충당금 회계 분개 전표 발행 | `ProvisioningEntriesApiResource` | `createProvisioningEntries` |

---

### 2. API 상세 명세

#### 2.1 연체 구간 및 버킷 관리 (`DelinquencyApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.delinquency.api.DelinquencyApiResource` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/api/DelinquencyApiResource.java:63`)
* **기본 경로**: `@Path("/v1/delinquency")` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/api/DelinquencyApiResource.java:60`)
* **엔드포인트**:
  * `GET /v1/delinquency/ranges` (getDelinquencyRanges): 연체 구간 목록 (권한: `DELINQUENCY_BUCKET` 읽기) (근거: `DelinquencyApiResource.java:77`)
  * `POST /v1/delinquency/ranges` (createDelinquencyRange): 연체 구간 등록 (`minAgeDays`, `maxAgeDays`, `classification`) (권한: `CREATE_DELINQUENCY_BUCKET`) (근거: `DelinquencyApiResource.java:101`)
  * `GET /v1/delinquency/buckets` (getDelinquencyBuckets): 연체 버킷 목록 (권한: `DELINQUENCY_BUCKET` 읽기) (근거: `DelinquencyApiResource.java:155`)
  * `POST /v1/delinquency/buckets` (createDelinquencyBucket): 연체 버킷 생성 (`ranges` 매핑) (권한: `CREATE_DELINQUENCY_BUCKET`) (근거: `DelinquencyApiResource.java:192`)

---

#### 2.2 대출 계좌 연체 태그 및 조치 관리 (`LoansApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/delinquencytags` (getDelinquencyTagHistory):
    * 메서드: `public String getDelinquencyTagHistory(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:746`)
    * 권한: `context.authenticatedUser().validateHasReadPermission("DELINQUENCY_TAGS")` (근거: `LoansApiResource.java:1392`)
    * 응답: `LoanDelinquencyTagHistoryData` 목록 (`delinquencyRange`, `addedOnDate`, `liftedOnDate`)
  * `GET /v1/loans/{loanId}/delinquency-actions` (getLoanDelinquencyActions):
    * 메서드: `public String getLoanDelinquencyActions(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:864`)
    * 권한: `context.authenticatedUser().validateHasReadPermission("DELINQUENCY_ACTION")` (근거: `LoansApiResource.java:1401`)
  * `POST /v1/loans/{loanId}/delinquency-actions` (createLoanDelinquencyAction):
    * 메서드: `public String createLoanDelinquencyAction(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:891`)
    * 권한: `context.authenticatedUser().validateHasCreatePermission("DELINQUENCY_ACTION")` (근거: `LoansApiResource.java:1412`)
    * 요청 필드: `action` (`PAUSE`, `RESUME`), `startDate`, `endDate`

---

#### 2.3 대손충당금 기준 및 분개 관리 (`ProvisioningCriteriaApiResource` / `ProvisioningEntriesApiResource`)
* **자바 클래스**:
  * `org.apache.fineract.organisation.provisioning.api.ProvisioningCriteriaApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java:55`)
  * `org.apache.fineract.accounting.provisioning.api.ProvisioningEntriesApiResource` (근거: `fineract-accounting/src/main/java/org/apache/fineract/accounting/provisioning/api/ProvisioningEntriesApiResource.java:56`)
* **엔드포인트**:
  * `POST /v1/provisioningcriteria` (createProvisioningCriteria): 대출 상품별 대손충당금 적립률 설정 (근거: `ProvisioningCriteriaApiResource.java:104`)
  * `POST /v1/provisioningentries` (createProvisioningEntries): 대손충당금 분개 데이터 산출 생성 (`date`, `createjournalentries`) (근거: `ProvisioningEntriesApiResource.java:75`)
  * `POST /v1/provisioningentries/{entryId}?command=journalentry` (createProvisioningEntries): 확정 회계 전표 발행 (근거: `ProvisioningEntriesApiResource.java:96`)
* **권한 체크**: `READ_PROVISIONINGCRITERIA`, `CREATE_PROVISIONINGCRITERIA`, `CREATE_PROVISIONINGENTRY` (서비스 계층 위임)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 22개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 연체 구간/버킷/태그, 채권 조치, 충당금 기준 및 분개 API 소스 확인 완료)
