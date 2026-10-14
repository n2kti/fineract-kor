# [LNR] API명세서

> 화면 2개 롤업(중분류 LNR, 대분류 LN). 화면 단위 원본은 `specs/<화면>/api-spec.md`.

## LNR-001 대출상환및거래처리

> 원본: `LNR-001-대출상환및거래처리/api-spec.md`

## [LNR-001] 상환거래 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `LNR-001-대출상환및거래처리` 화면에서 사용하는 대출 원리금 상환(Repayment), 조기상환(Prepay), 이자 면제(Waive), 대손 상각(Write-off), 환급(Refund), 거래 취소/역분개(Undo/Reverse), 수수료(Charge) 부과/납부/면제 및 이자 유예(Interest Pause) 처리를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_transaction`, `m_loan_transaction_relation`, `m_loan_transaction_repayment_schedule_mapping`, `m_loan_payment_allocation_rule`, `m_loan_credit_allocation_rule`, `m_loan_charge`, `m_loan_charge_paid_by`, `m_loan_charge_tax_details`, `m_loan_installment_charge` (참조: [data-model.md](/specs/LNR-001-대출상환및거래처리/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/loans/{loanId}/transactions?command=repayment` | 대출 원리금 상환 거래 실행 (`m_loan_transaction` 적재) | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=prepayLoan` | 대출 조기 전액/일부 상환 거래 실행 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=waiveinterest` | 대출 이자 면제(Waive) 거래 실행 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=writeoff` | 대출 채권 대손 상각(Write-Off) 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=close` | 대출 완제 정상 종결 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=refundByCash` | 초과 납입금 현금 환급 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=creditBalanceRefund` | 크레딧 잔액 환급 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=chargeRefund` | 대출 수수료 환급 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=recoverypayment` | 상각 후 회수금(Recovery) 입금 처리 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `GET` | `/v1/loans/{loanId}/transactions/{transactionId}` | 특정 거래 상세 내역 및 스케줄 충당 매핑 조회 | `LoanTransactionsApiResource` | `retrieveTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions/{transactionId}?command=undo` | 거래 취소/역분개 (`is_reversed=true`, 원장 원복) | `LoanTransactionsApiResource` | `adjustLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions/{transactionId}?command=chargeback` | 상환 거래 차지백(Chargeback) 처리 | `LoanTransactionsApiResource` | `adjustLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions/{transactionId}?command=adjust` | 거래 일자 및 금액 사후 조정 | `LoanTransactionsApiResource` | `adjustLoanTransaction` |
| `GET` | `/v1/loans/{loanId}/charges` | 대출에 부과된 수수료 목록 조회 (`m_loan_charge`) | `LoanChargesApiResource` | `retrieveAllLoanCharges` |
| `POST` | `/v1/loans/{loanId}/charges` | 대출 수수료 신규 부과 등록 | `LoanChargesApiResource` | `executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/{loanChargeId}?command=pay` | 부과된 대출 수수료 납부 처리 | `LoanChargesApiResource` | `executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/{loanChargeId}?command=waive` | 부과된 대출 수수료 면제 처리 | `LoanChargesApiResource` | `executeLoanCharge` |
| `POST` | `/v1/loans/{loanId}/charges/{loanChargeId}?command=adjustment` | 수수료 금액 조정 | `LoanChargesApiResource` | `executeLoanCharge` |
| `GET` | `/v1/loans/{loanId}/interest-pauses` | 대출 이자 납입 일시정지(Pause) 이력 조회 | `LoanInterestPauseApiResource` | `retrieveInterestPauses` |
| `POST` | `/v1/loans/{loanId}/interest-pauses` | 대출 이자 납입 일시정지 기간 신규 등록 | `LoanInterestPauseApiResource` | `createInterestPause` |
| `DELETE` | `/v1/loans/{loanId}/interest-pauses/{variationId}` | 대출 이자 납입 일시정지 설정 해제 | `LoanInterestPauseApiResource` | `retrieveInterestPausesByExternalId` |

---

### 2. API 상세 명세

#### 2.1 대출 거래 실행 (`POST /v1/loans/{loanId}/transactions?command=...`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanTransactionsApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:85`)
* **메서드명**: `public String executeLoanTransaction(@PathParam("loanId") final Long loanId, @QueryParam("command") final String commandParam, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:303`)
* **JAX-RS 어노테이션**:
  * `@POST` `@Path("/v1/loans/{loanId}/transactions")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:85,296`)
  * `@Consumes({ MediaType.APPLICATION_JSON })` / `@Produces({ MediaType.APPLICATION_JSON })`
* **커맨드별 처리 및 권한**:
  1. `command=repayment` (원리금 상환): 권한 `REPAYMENT_LOAN` (근거: `LoanTransactionsApiResource.java:577`)
     * 요청 필드: `transactionDate` (거래일), `transactionAmount` (상환금액), `paymentTypeId` (결제수단), `note`
  2. `command=prepayLoan` (조기 전액 상환): 권한 `PREPAYMENT_LOAN` (근거: `LoanTransactionsApiResource.java:679`)
  3. `command=waiveinterest` (이자 면제): 권한 `WAIVEINTERESTPORTION_LOAN` (근거: `LoanTransactionsApiResource.java:589`)
  4. `command=writeoff` (대손 상각): 권한 `WRITEOFF_LOAN` (근거: `LoanTransactionsApiResource.java:591`)
  5. `command=close` (완제 종결): 권한 `CLOSE_LOAN` (근거: `LoanTransactionsApiResource.java:595`)
  6. `command=refundByCash` (현금 환급): 권한 `REFUNDBYCASH_LOAN` (근거: `LoanTransactionsApiResource.java:601`)
  7. `command=creditBalanceRefund` (크레딧 잔액 환급): 권한 `CREDITBALANCEREFUND_LOAN` (근거: `LoanTransactionsApiResource.java:605`)
  8. `command=recoverypayment` (회수금 입금): 권한 `RECOVERYPAYMENT_LOAN` (근거: `LoanTransactionsApiResource.java:599`)
* **응답 필드 (`PostLoansLoanIdTransactionsResponse`)**: `loanId`, `resourceId` (거래 ID), `changes`

---

#### 2.2 거래 상세 조회 및 취소/조정 (`GET/POST /v1/loans/{loanId}/transactions/{transactionId}`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanTransactionsApiResource`
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/transactions/{transactionId}` (retrieveTransaction):
    * 메서드: `public String retrieveTransaction(@PathParam("loanId") final Long loanId, @PathParam("transactionId") final Long transactionId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:237`)
    * 권한: `this.context.authenticatedUser().validateHasReadPermission("LOAN")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:240`)
    * 응답: `GetLoansLoanIdTransactionsTransactionIdResponse` (금액, 원금/이자/수수료 배분, 취소 여부 `manuallyAdjustedOrReversed`)
  * `POST /v1/loans/{loanId}/transactions/{transactionId}?command=undo` (adjustLoanTransaction):
    * 메서드: `public String adjustLoanTransaction(@PathParam("loanId") final Long loanId, @PathParam("transactionId") final Long transactionId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:369`)
    * 권한: `ADJUST_LOANTRANSACTION` / `UNDOTRANSACTION_LOAN` (근거: `LoanTransactionsApiResource.java:752`)
  * `POST /v1/loans/{loanId}/transactions/{transactionId}?command=chargeback` (adjustLoanTransaction):
    * 권한: `CHARGEBACK_LOANTRANSACTION` (근거: `LoanTransactionsApiResource.java:743`)

---

#### 2.3 대출 수수료 관리 (`LoanChargesApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanChargesApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:60`)
* **기본 경로**: `@Path("/v1/loans/{loanId}/charges")` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:60`)
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/charges` (retrieveAllLoanCharges) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:160`)
  * `POST /v1/loans/{loanId}/charges` (executeLoanCharge) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:203`)
  * `POST /v1/loans/{loanId}/charges/{loanChargeId}?command=pay` (executeLoanCharge) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:232`)
  * `POST /v1/loans/{loanId}/charges/{loanChargeId}?command=waive` (executeLoanCharge) (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanChargesApiResource.java:232`)
* **권한 체크**: `READ_LOAN`, `CREATE_LOANCHARGE`, `PAY_LOANCHARGE`, `WAIVE_LOANCHARGE` (근거: `LoanChargesApiResource.java:163,205`)

---

#### 2.4 대출 이자 납입 일시정지 (`LoanInterestPauseApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.interestpauses.api.LoanInterestPauseApiResource` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/interestpauses/api/LoanInterestPauseApiResource.java:49`)
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/interest-pauses` (retrieveInterestPauses) (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/interestpauses/api/LoanInterestPauseApiResource.java:101`)
  * `POST /v1/loans/{loanId}/interest-pauses` (createInterestPause): 시작일/종료일 지정 (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/interestpauses/api/LoanInterestPauseApiResource.java:65`)
  * `DELETE /v1/loans/{loanId}/interest-pauses/{variationId}` (retrieveInterestPausesByExternalId) (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/interestpauses/api/LoanInterestPauseApiResource.java:129`)
* **권한 체크**: `READ_LOAN`, `UPDATE_LOAN` (근거: `LoanInterestPauseApiResource.java:68,103`)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 21개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 상환/취소/환급 커맨드, 수수료 및 이자정지 API 소스 확인 완료)

---

## LNR-002 대출상환일정재조정

> 원본: `LNR-002-대출상환일정재조정/api-spec.md`

## [LNR-002] 대출조정및재조정 API 명세서

### 1. 개요 및 엔드포인트 목록

본 문서는 `LNR-002-대출상환일정재조정` 화면에서 사용하는 대출 상환일정 재조정(Reschedule) 신청서 접수, 심사 및 승인/반려, 조건 변경 시뮬레이션 미리보기(Preview), 연체 일수 초기화/정상화(Re-Age), 대출 잔액 재상각(Re-Amortization) 거래 처리를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_reschedule_request`, `m_loan_reschedule_request_term_variations_mapping`, `m_loan_reage_parameter`, `m_loan_reamortization_parameter`, `m_loan_term_variations`, `m_loan_topup` (참조: [data-model.md](/specs/LNR-002-대출상환일정재조정/data-model.md))

#### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `POST` | `/v1/rescheduleloans` | 대출 상환 일정 재조정(Reschedule) 신청서 접수 (`m_loan_reschedule_request`) | `RescheduleLoansApiResource` | `createLoanRescheduleRequest` |
| `GET` | `/v1/rescheduleloans` | 대출 재조정 신청서 전체 목록 조회 | `RescheduleLoansApiResource` | `retrieveAllRescheduleRequest` |
| `GET` | `/v1/rescheduleloans/template` | 대출 재조정 신청 템플릿(사유 코드 등) 조회 | `RescheduleLoansApiResource` | `retrieveTemplate` |
| `GET` | `/v1/rescheduleloans/{scheduleId}` | 대출 재조정 신청서 상세 정보 조회 | `RescheduleLoansApiResource` | `readLoanRescheduleRequest` |
| `GET` | `/v1/rescheduleloans/{scheduleId}?command=previewLoanReschedule` | 재조정 승인 시 예상되는 상환 스케줄 시뮬레이션 미리보기 | `RescheduleLoansApiResource` | `readLoanRescheduleRequest` |
| `POST` | `/v1/rescheduleloans/{scheduleId}?command=approve` | 대출 재조정 신청 승인 처리 및 상환 스케줄 갱신 | `RescheduleLoansApiResource` | `updateLoanRescheduleRequest` |
| `POST` | `/v1/rescheduleloans/{scheduleId}?command=reject` | 대출 재조정 신청 반려(Reject) 처리 | `RescheduleLoansApiResource` | `updateLoanRescheduleRequest` |
| `POST` | `/v1/loans/{loanId}/transactions?command=reage` | 연체 일수 정상화(Re-Age) 거래 실행 (`m_loan_reage_parameter` 적재) | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=undoReage` | Re-Age 거래 취소(Undo) 및 이전 연체 상태 복구 | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=reamortize` | 대출 잔액 재상각(Re-Amortization) 거래 실행 (`m_loan_reamortization_parameter` 적재) | `LoanTransactionsApiResource` | `executeLoanTransaction` |
| `POST` | `/v1/loans/{loanId}/transactions?command=undoReamortize` | Re-Amortization 거래 취소(Undo) 및 이전 스케줄 복구 | `LoanTransactionsApiResource` | `executeLoanTransaction` |

---

### 2. API 상세 명세

#### 2.1 대출 재조정 신청 및 심사 (`RescheduleLoansApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.rescheduleloan.api.RescheduleLoansApiResource` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/api/RescheduleLoansApiResource.java:64`)
* **기본 경로**: `@Path("/v1/rescheduleloans")` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/api/RescheduleLoansApiResource.java:60`)
* **엔드포인트 상세**:
  1. `POST /v1/rescheduleloans` (createLoanRescheduleRequest):
     * 메서드: `public String createLoanRescheduleRequest(final String apiRequestBodyAsJson)` (근거: `RescheduleLoansApiResource.java:122`)
     * 권한: `CREATE_RESCHEDULELOAN` (근거: `RescheduleLoansApiResource.java:124`)
     * 요청 필드 (`PostRescheduleLoansRequest`):
       * `loanId` (Long, 필수): 대상 대출 계좌 식별자
       * `rescheduleFromDate` (String, 필수): 재조정 적용 시작일 (`dd MMMM yyyy`)
       * `rescheduledOnDate` (String, 필수): 재조정 신청일
       * `rescheduleReasonId` (Long, 필수): 재조정 사유 코드 식별자 (`m_code_value.id`)
       * `rescheduleReasonComment` (String, 선택): 사유 상세 설명
       * `recalculateInterest` (Boolean, 선택): 이자 재계산 여부
       * `adjustedDueDate` (String, 선택): 변경 만기일
       * `graceOnPrincipal` (Integer, 선택): 원금 거치 기간
       * `graceOnInterest` (Integer, 선택): 이자 거치 기간
       * `extraTerms` (Integer, 선택): 추가 연장 회차
       * `newInterestRate` (BigDecimal, 선택): 변경 약정 금리
     * 응답 필드: `resourceId` (생성된 `m_loan_reschedule_request.id`)
  2. `GET /v1/rescheduleloans/{scheduleId}?command=previewLoanReschedule` (readLoanRescheduleRequest):
     * 메서드: `public String readLoanRescheduleRequest(..., @QueryParam("command") final String command)` (근거: `RescheduleLoansApiResource.java:97`)
     * 권한: `platformSecurityContext.authenticatedUser().validateHasReadPermission("RESCHEDULELOAN")` (근거: `RescheduleLoansApiResource.java:99`)
     * 반환: `LoanScheduleData` (재조정 조건이 반영된 가상 상환 스케줄)
  3. `POST /v1/rescheduleloans/{scheduleId}?command=approve` (updateLoanRescheduleRequest):
     * 메서드: `public String updateLoanRescheduleRequest(@PathParam("scheduleId") final Long scheduleId, @QueryParam("command") final String command, ...)` (근거: `RescheduleLoansApiResource.java:139`)
     * 권한: `APPROVE_RESCHEDULELOAN` (근거: `RescheduleLoansApiResource.java:144`)
     * 요청 필드: `approvedOnDate` (승인 일자)
  4. `POST /v1/rescheduleloans/{scheduleId}?command=reject` (updateLoanRescheduleRequest):
     * 권한: `REJECT_RESCHEDULELOAN` (근거: `RescheduleLoansApiResource.java:149`)
     * 요청 필드: `rejectedOnDate` (반려 일자)

---

#### 2.2 Re-Age 및 Re-Amortization 거래 실행 (`LoanTransactionsApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoanTransactionsApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java:85`)
* **엔드포인트**:
  * `POST /v1/loans/{loanId}/transactions?command=reage` (executeLoanTransaction):
    * 메서드: `public String executeLoanTransaction(...)` (근거: `LoanTransactionsApiResource.java:303,613`)
    * 권한: `REAGE_LOAN` (근거: `LoanTransactionsApiResource.java:614`)
    * 요청 필드: `startDate`, `numberOfInstallments`, `frequency`, `frequencyNumber`, `reAgeReasonCodeValueId`, `interestHandlingType` (`DEFAULT`, `WAIVE`, `CAPITALIZE`)
    * 연계 DB: `m_loan_reage_parameter` 적재 및 연체 일수(Arrears Ageing) 초기화
  * `POST /v1/loans/{loanId}/transactions?command=undoReage` (executeLoanTransaction):
    * 권한: `UNDOREAGE_LOAN` (근거: `LoanTransactionsApiResource.java:615-616`)
  * `POST /v1/loans/{loanId}/transactions?command=reamortize` (executeLoanTransaction):
    * 메서드: `public String executeLoanTransaction(...)` (근거: `LoanTransactionsApiResource.java:303,617`)
    * 권한: `REAMORTIZE_LOAN` (근거: `LoanTransactionsApiResource.java:618`)
    * 요청 필드: `reAmortizationReasonCodeValueId`, `interestHandlingType`
    * 연계 DB: `m_loan_reamortization_parameter` 적재 및 잔액 기준 상환 스케줄 재상각
  * `POST /v1/loans/{loanId}/transactions?command=undoReamortize` (executeLoanTransaction):
    * 권한: `UNDOREAMORTIZE_LOAN` (근거: `LoanTransactionsApiResource.java:619-620`)

---

### 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 11개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 재조정 신청/승인/반려/프리뷰, Re-Age, Re-Amortization API 소스 확인 완료)
