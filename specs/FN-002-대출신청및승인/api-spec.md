# [FN-002] 대출신청및승인 API 명세서

## 1. 개요 및 엔드포인트 목록

본 문서는 `FN-002-대출신청및승인` 화면에서 사용하는 차주 대출 신청서 접수, 심사역 배정, 대출 승인/반려/취소 상태 전이, 대출 모집인(Originator) 연계 및 시점별 원장 조회를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan`, `m_loan_approved_amount_history`, `m_loan_status_change_history`, `m_loan_officer_assignment_history`, `m_loan_originator`, `m_loan_originator_mapping`, `m_loan_account_locks` (참조: [data-model.md](/specs/FN-002-대출신청및승인/data-model.md))

### 엔드포인트 요약표

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

## 2. API 상세 명세

### 2.1 대출 신청서 제출 (`POST /v1/loans`)
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

### 2.2 대출 계좌 상세 원장 조회 (`GET /v1/loans/{loanId}`)
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

### 2.3 대출 승인/반려/취소/심사역배정 상태 전이 (`POST /v1/loans/{loanId}?command=...`)
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

### 2.4 대출 모집인(Loan Originator) 관리 (`LoanOriginatorApiResource` / `LoanOriginatorsApiResource`)
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

## 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 20개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 상태 전이 커맨드, 모집인 매핑 및 권한 확인 완료)
