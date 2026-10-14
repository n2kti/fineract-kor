# [FN-004] 상환스케줄 API 명세서

## 1. 개요 및 엔드포인트 목록

본 문서는 `FN-004-상환스케줄` 화면에서 사용하는 대출 상환 계획(스케줄) 사전 시뮬레이션 계산, 대출 계약 조건 변동(Term Variations) 반영 스케줄 재산출, 확정 스케줄 조회, 미래 예상 스케줄 및 과거 스케줄 변경 이력 조회를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_repayment_schedule`, `m_loan_repayment_schedule_history`, `m_loan_amortization_allocation_mapping`, `m_loan_progressive_model`, `m_loan_recalculation_details`, `m_loan_interest_recalculation_additional_details` (참조: [data-model.md](/specs/FN-004-상환스케줄/data-model.md))

### 엔드포인트 요약표

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

## 2. API 상세 명세

### 2.1 대출 신청 전 상환 스케줄 사전 계산 (`POST /v1/loans?command=calculateLoanSchedule`)
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

### 2.2 대출 조건 변동 스케줄 계산 및 반영 (`LoanScheduleApiResource`)
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

### 2.3 확정 스케줄 및 과거 이력 조회 (`GET /v1/loans/{loanId}?associations=...`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource`
* **메서드명**: `public String retrieveLoan(@PathParam("loanId") final Long loanId, @DefaultValue("all") @QueryParam("fields") final String fields, @Context final UriInfo uriInfo)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:778`)
* **권한 체크**: `this.context.authenticatedUser().validateHasReadPermission("LOAN")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:782`)
* **파라미터 조합**:
  * `associations=repaymentSchedule`: 현재 활성화된 회차별 상환 스케줄 데이터 반환
  * `associations=futureSchedule`: 이자 재계산 적용 시 향후 변동될 예상 스케줄 반환
  * `associations=repaymentScheduleHistory`: 재조정/재산출 전 과거 스케줄 이력(`m_loan_repayment_schedule_history`) 반환

---

## 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 7개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 스케줄 계산 커맨드, 변동 조건 파라미터 및 권한 소스 확인 완료)
