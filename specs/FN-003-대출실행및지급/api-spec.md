# [FN-003] 대출실행및지급 API 명세서

## 1. 개요 및 엔드포인트 목록

본 문서는 `FN-003-대출실행및지급` 화면에서 사용하는 대출금 지급(Disbursement), 분할 실행(Tranche), 저축 계좌 직접 이체, 실행 취소(Undo Disbursal), 담보(Collateral) 관리 및 가용 지급 한도 조정을 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_disbursement_detail`, `m_loan_tranche_charges`, `m_loan_tranche_disbursement_charge`, `m_loan_collateral`, `m_loan_collateral_management`, `m_loan_buy_down_fee_balance`, `m_loan_capitalized_income_balance` (참조: [data-model.md](/specs/FN-003-대출실행및지급/data-model.md))

### 엔드포인트 요약표

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

## 2. API 상세 명세

### 2.1 대출금 지급 및 실행 상태 전이 (`POST /v1/loans/{loanId}?command=disburse|disburseToSavings|undodisbursal`)
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

### 2.2 트랜치 분할 지급 상세 관리 (`LoanDisbursementDetailApiResource`)
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

### 2.3 대출 담보 관리 (`LoanCollateralManagementApiResource`)
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

## 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 10개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 지급/취소 커맨드, 트랜치 및 담보 관리 API 소스 확인 완료)
