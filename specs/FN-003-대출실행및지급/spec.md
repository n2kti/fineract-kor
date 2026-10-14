# [FN-003] 대출실행및지급 명세서

## 기능 개요 및 목표
- **FR-001**: 대출금 일시 지급 및 분할 지급(Tranche/Multi-disbursement) 실행 기능 (근거: `LoansApiResource.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 트랜치 분할 실행 시 트랜치별 지급 수수료(Tranche Charges / Disbursement Charges) 계산 및 부과 기능 (근거: `LoanTrancheCharge.java, LoanTrancheDisbursementCharge.java`)
- **FR-003**: 대출 담보(Collateral) 정보 등록 및 담보 관리 평가 시스템 연동 기능 (근거: `LoanCollateral.java, LoanCollateralManagement.java`)
- **FR-004**: 금리 인하 지원을 위한 제휴사 수수료(Merchant Buy-Down Fee) 잔액 및 상각 관리 기능 (근거: `LoanBuyDownFeeBalance.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-005**: 대출 실행 시 원금에 가산되는 자본화 수익(Capitalized Income) 잔액 관리 기능 (근거: `LoanCapitalizedIncomeBalance.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

## 하지 말아야 할 것
- 승인된 대출 금액을 초과하는 대출금 지급 실행 금지 (근거: Loan.java)
- 대출 승인 일자보다 과거 시점으로의 대출 지급 실행 불가 (근거: LoanWritePlatformServiceJpaRepositoryImpl.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_disbursement_detail`
- `m_loan_tranche_charges`
- `m_loan_tranche_disbursement_charge`
- `m_loan_collateral`
- `m_loan_collateral_management`
- `m_loan_buy_down_fee_balance`
- `m_loan_capitalized_income_balance`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-003-대출실행및지급/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: 대출 지급 처리 시 `m_loan` 상태가 `ACTIVE`로 전환되고 `m_loan_disbursement_detail`에 지급 내역이 생성된다. (근거: `LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **SC-002**: 분할 실행(Tranche) 시 설정된 지급 수수료가 자동으로 계산되어 상환 계획에 가산된다. (근거: `LoanTrancheDisbursementCharge.java`)

## 근거
* [`specs/FN-003-대출실행및지급/data-model.md`](/specs/FN-003-대출실행및지급/data-model.md) (`FN-003-대출실행및지급/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanCollateral.java`)
