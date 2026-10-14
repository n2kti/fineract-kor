# [FN] 요구사항정의서

> 화면 4개 롤업(중분류 FN, 대분류 FN). 화면 단위 원본은 `specs/<화면>/spec.md`.

## FN-002 대출신청및승인

> 원본: `FN-002-대출신청및승인/spec.md`

## [FN-002] 대출신청및승인 명세서

### 기능 개요 및 목표
- **FR-001**: 고객(Client) 또는 그룹(Group) 기반 대출 신청서(Loan Application) 접수 및 계좌 번호 발급 기능 (근거: `LoansApiResource.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 대출 신청 건에 대한 대출 심사역(Loan Officer) 배정 및 변경 이력 추적 기능 (근거: `LoanOfficerAssignmentHistory.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-003**: 대출 승인(Approval) 처리 및 승인 금액(Approved Amount) 변경 이력 기록 기능 (근거: `LoanApprovedAmountHistory.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 대출 신청, 승인, 반려, 취소 등 대출 계좌 상태 전이 이력 추적 기능 (근거: `LoanStatusChangeHistory.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-005**: 대출 모집인(Loan Originator) 등록 및 대출 계좌와의 연계 매핑 관리 기능 (근거: `LoanOriginator.java, LoanOriginatorMapping.java`)
- **FR-006**: COB(Close of Business) 및 트랜잭션 동시성 처리를 위한 대출 계좌 단위 락(Lock) 관리 기능 (근거: `LoanAccountLock.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

### 하지 말아야 할 것
- 승인(Approved) 상태가 아닌 대출에 대한 대출금 지급(Disbursement) 실행 금지 (근거: Loan.java)
- 필수 차주(Client/Group) 정보 또는 상품(Product) 정의가 누락된 대출 신청서 제출 불가 (근거: LoanApplicationWritePlatformServiceJpaRepositoryImpl.java)

### 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan`
- `m_loan_approved_amount_history`
- `m_loan_status_change_history`
- `m_loan_officer_assignment_history`
- `m_loan_originator`
- `m_loan_originator_mapping`
- `m_loan_account_locks`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-002-대출신청및승인/data-model.md) 를 참조한다.

### 완료 기준
- **SC-001**: 대출 신청서 제출 시 `m_loan` 테이블에 `SUBMITTED_AND_PENDING_APPROVAL` 상태로 데이터가 정상 생성된다. (근거: `LoansApiResource.java`)
- **SC-002**: 대출 승인 API 호출 시 승인 상태로 전환되며 `m_loan_approved_amount_history`에 승인 정보가 적재된다. (근거: `LoanApprovedAmountHistory.java`)

### 근거
* [`specs/FN-002-대출신청및승인/data-model.md`](/specs/FN-002-대출신청및승인/data-model.md) (`FN-002-대출신청및승인/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java`)
* [`backend/fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java`](/backend/fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java) (`fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java`)

---

## FN-003 대출실행및지급

> 원본: `FN-003-대출실행및지급/spec.md`

## [FN-003] 대출실행및지급 명세서

### 기능 개요 및 목표
- **FR-001**: 대출금 일시 지급 및 분할 지급(Tranche/Multi-disbursement) 실행 기능 (근거: `LoansApiResource.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 트랜치 분할 실행 시 트랜치별 지급 수수료(Tranche Charges / Disbursement Charges) 계산 및 부과 기능 (근거: `LoanTrancheCharge.java, LoanTrancheDisbursementCharge.java`)
- **FR-003**: 대출 담보(Collateral) 정보 등록 및 담보 관리 평가 시스템 연동 기능 (근거: `LoanCollateral.java, LoanCollateralManagement.java`)
- **FR-004**: 금리 인하 지원을 위한 제휴사 수수료(Merchant Buy-Down Fee) 잔액 및 상각 관리 기능 (근거: `LoanBuyDownFeeBalance.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-005**: 대출 실행 시 원금에 가산되는 자본화 수익(Capitalized Income) 잔액 관리 기능 (근거: `LoanCapitalizedIncomeBalance.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

### 하지 말아야 할 것
- 승인된 대출 금액을 초과하는 대출금 지급 실행 금지 (근거: Loan.java)
- 대출 승인 일자보다 과거 시점으로의 대출 지급 실행 불가 (근거: LoanWritePlatformServiceJpaRepositoryImpl.java)

### 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_disbursement_detail`
- `m_loan_tranche_charges`
- `m_loan_tranche_disbursement_charge`
- `m_loan_collateral`
- `m_loan_collateral_management`
- `m_loan_buy_down_fee_balance`
- `m_loan_capitalized_income_balance`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-003-대출실행및지급/data-model.md) 를 참조한다.

### 완료 기준
- **SC-001**: 대출 지급 처리 시 `m_loan` 상태가 `ACTIVE`로 전환되고 `m_loan_disbursement_detail`에 지급 내역이 생성된다. (근거: `LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **SC-002**: 분할 실행(Tranche) 시 설정된 지급 수수료가 자동으로 계산되어 상환 계획에 가산된다. (근거: `LoanTrancheDisbursementCharge.java`)

### 근거
* [`specs/FN-003-대출실행및지급/data-model.md`](/specs/FN-003-대출실행및지급/data-model.md) (`FN-003-대출실행및지급/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java`)

---

## FN-004 상환스케줄

> 원본: `FN-004-상환스케줄/spec.md`

## [FN-004] 상환스케줄 명세서

### 기능 개요 및 목표
- **FR-001**: 원리금 균등, 원금 균등, 만기 일시상환 등 상환 방식별 회차 상환 계획(스케줄) 계산 및 생성 기능 (근거: `LoanScheduleCalculationPlatformServiceImpl.java, LoanRepaymentScheduleInstallment.java`)
- **FR-002**: 조기상환 및 금리 변경 등에 따른 이자 재계산(Interest Recalculation) 및 스케줄 갱신 기능 (근거: `LoanInterestRecalculationDetails.java, LoanScheduleCalculationPlatformServiceImpl.java`)
- **FR-003**: 상환 스케줄 재산출/조정 시 과거 스케줄 이력 보관 기능 (근거: `LoanRepaymentScheduleHistory.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 점진적 상환 모델(Progressive Loan Model) 산출 데이터 저장 및 모델 버전 관리 기능 (근거: `ProgressiveLoanModel.java, ProgressiveLoanModelRepository.java`)
- **FR-005**: 회차별 원리금 상각(Amortization) 배분 매핑 정보 관리 기능 (근거: `LoanAmortizationAllocationMapping.java, LoanScheduleAssembler.java`)

### 하지 말아야 할 것
- 이미 상환 완료된 과거 회차의 원금 및 이자 금액에 대한 소급 수정 금지 (근거: LoanRepaymentScheduleInstallment.java)
- 영업일 및 공휴일 규칙을 위반한 상환 만기일 산출 금지 (근거: LoanScheduleCalculationPlatformServiceImpl.java)

### 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_repayment_schedule`
- `m_loan_repayment_schedule_history`
- `m_loan_amortization_allocation_mapping`
- `m_loan_progressive_model`
- `m_loan_recalculation_details`
- `m_loan_interest_recalculation_additional_details`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-004-상환스케줄/data-model.md) 를 참조한다.

### 완료 기준
- **SC-001**: 대출 스케줄 계산 API 호출 시 각 회차별 원금, 이자, 수수료의 합이 대출 총액과 정확히 일치한다. (근거: `LoanScheduleCalculationPlatformServiceImpl.java`)
- **SC-002**: 이자 재계산 실행 시 이전 스케줄이 이력 테이블(`m_loan_repayment_schedule_history`)로 백업되고 새 스케줄이 반영된다. (근거: `LoanRepaymentScheduleHistory.java`)

### 근거
* [`specs/FN-004-상환스케줄/data-model.md`](/specs/FN-004-상환스케줄/data-model.md) (`FN-004-상환스케줄/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java`)
* [`backend/fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java`](/backend/fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java) (`fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java`)

---

## FN-006 연체및채권

> 원본: `FN-006-연체및채권/spec.md`

## [FN-006] 연체및채권 명세서

### 기능 개요 및 목표
- **FR-001**: 납기일 경과 대출에 대한 연체 일수(Days in Arrears) 계산 및 연체 구간(Delinquency Range/Bucket) 분류 기능 (근거: `DelinquencyWritePlatformServiceImpl.java, DelinquencyReadPlatformServiceImpl.java`)
- **FR-002**: 대출 계좌 및 상환 회차별 연체 등급 태그 이력 관리 기능 (근거: `LoanDelinquencyTagHistory.java, LoanInstallmentDelinquencyTag.java`)
- **FR-003**: 연체 대출에 대한 채권 관리 조치(Delinquency Action: 일시 정지, 재개 등) 등록 및 실행 기능 (근거: `LoanDelinquencyAction.java, DelinquencyWritePlatformServiceImpl.java`)
- **FR-004**: 연체 회차별 연체료(Overdue Installment Charge / Penalty) 자동 계산 및 부과 기능 (근거: `LoanOverdueInstallmentCharge.java, LoanChargeWritePlatformServiceImpl.java`)
- **FR-005**: 연체 구간에 따른 대손충당금(Loan Loss Provisioning) 적립률 산출 및 분개 데이터 생성 기능 (근거: `LoanProductProvisioningEntry.java, LoanProductProvisionCriteria.java`)

### 하지 말아야 할 것
- 연체 일시 정지(Pause) 상태인 대출에 대한 신규 연체 태그 전이 및 연체료 자동 가산 금지 (근거: LoanDelinquencyAction.java)
- 정상 납부 완료된 상환 회차에 대한 소급 연체료 부과 금지 (근거: LoanOverdueInstallmentCharge.java)

### 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_delinquency_action`
- `m_loan_delinquency_tag_history`
- `m_loan_installment_delinquency_tag`
- `m_loan_overdue_installment_charge`
- `m_loanproduct_provisioning_mapping`
- `m_loanproduct_provisioning_entry`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-006-연체및채권/data-model.md) 를 참조한다.

### 완료 기준
- **SC-001**: COB 배치 실행 시 연체 일수에 해당하는 연체 구간 태그가 `m_loan_delinquency_tag_history`에 정확히 반영된다. (근거: `DelinquencyWritePlatformServiceImpl.java`)
- **SC-002**: 연체 조치(Pause) 등록 시 설정된 기간 동안 연체 등급 산정이 유예된다. (근거: `LoanDelinquencyAction.java`)

### 근거
* [`specs/FN-006-연체및채권/data-model.md`](/specs/FN-006-연체및채권/data-model.md) (`FN-006-연체및채권/data-model.md`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java`)
