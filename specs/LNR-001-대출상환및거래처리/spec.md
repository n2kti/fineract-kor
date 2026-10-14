# [LNR-001] 대출 상환 및 거래 처리 명세서

## 기능 개요 및 목표
- **FR-001**: 대출 원리금 상환(Repayment), 조기상환(Prepay), 이자 납입 거래 처리 기능 (근거: `LoanTransactionsApiResource.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 대출별 상환금 배분 규칙(Payment Allocation Rule)에 따른 연체료->수수료->이자->원금 순차 충당 처리 기능 (근거: `LoanPaymentAllocationRule.java, LoanTransactionToRepaymentScheduleMapping.java`)
- **FR-003**: 대출 수수료(Charge) 부과, 납부 처리 및 세금(Tax) 상세 분리 기록 기능 (근거: `LoanChargeWritePlatformServiceImpl.java, LoanChargePaidBy.java, LoanChargeTaxDetails.java`)
- **FR-004**: 상환 거래 취소/역분개(Undo/Reverse Transaction) 및 거래 간 상관관계(Relation) 추적 기능 (근거: `LoanTransactionRelation.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-005**: 초과 납입금(Overpayment) 발생 시 크레딧 배분 규칙에 따른 잔액 관리 기능 (근거: `LoanCreditAllocationRule.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

## 하지 말아야 할 것
- 이미 취소(Reversed) 처리된 거래에 대한 중복 취소 불가 (근거: LoanTransaction.java)
- 대출 잔액이 남아있는 상태에서 상환 완료로 오분류하여 계좌를 임의 종결 처리하는 행위 금지 (근거: LoanWritePlatformServiceJpaRepositoryImpl.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_transaction`
- `m_loan_transaction_relation`
- `m_loan_transaction_repayment_schedule_mapping`
- `m_loan_payment_allocation_rule`
- `m_loan_credit_allocation_rule`
- `m_loan_charge`
- `m_loan_charge_paid_by`
- `m_loan_charge_tax_details`
- `m_loan_installment_charge`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/LNR-001-대출상환및거래처리/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: 상환 거래 실행 시 `m_loan_transaction`에 기록되고 상환 스케줄 매핑 테이블에 회차별 충당액이 정상 반영된다. (근거: `LoanTransactionsApiResource.java`)
- **SC-002**: 거래 취소 요청 시 해당 거래의 `is_reversed` 플래그가 true로 변경되고 원리금 잔액이 이전 상태로 복구된다. (근거: `LoanTransactionRelation.java`)

## 근거
* [`specs/LNR-001-대출상환및거래처리/data-model.md`](/specs/LNR-001-대출상환및거래처리/data-model.md) (`LNR-001-대출상환및거래처리/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoanTransactionsApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanChargeWritePlatformServiceImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanChargeWritePlatformServiceImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanChargeWritePlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTransaction.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTransaction.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTransaction.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanPaymentAllocationRule.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanPaymentAllocationRule.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanPaymentAllocationRule.java`)
