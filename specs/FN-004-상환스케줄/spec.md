# [FN-004] 상환스케줄 명세서

## 기능 개요 및 목표
- **FR-001**: 원리금 균등, 원금 균등, 만기 일시상환 등 상환 방식별 회차 상환 계획(스케줄) 계산 및 생성 기능 (근거: `LoanScheduleCalculationPlatformServiceImpl.java, LoanRepaymentScheduleInstallment.java`)
- **FR-002**: 조기상환 및 금리 변경 등에 따른 이자 재계산(Interest Recalculation) 및 스케줄 갱신 기능 (근거: `LoanInterestRecalculationDetails.java, LoanScheduleCalculationPlatformServiceImpl.java`)
- **FR-003**: 상환 스케줄 재산출/조정 시 과거 스케줄 이력 보관 기능 (근거: `LoanRepaymentScheduleHistory.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 점진적 상환 모델(Progressive Loan Model) 산출 데이터 저장 및 모델 버전 관리 기능 (근거: `ProgressiveLoanModel.java, ProgressiveLoanModelRepository.java`)
- **FR-005**: 회차별 원리금 상각(Amortization) 배분 매핑 정보 관리 기능 (근거: `LoanAmortizationAllocationMapping.java, LoanScheduleAssembler.java`)

## 하지 말아야 할 것
- 이미 상환 완료된 과거 회차의 원금 및 이자 금액에 대한 소급 수정 금지 (근거: LoanRepaymentScheduleInstallment.java)
- 영업일 및 공휴일 규칙을 위반한 상환 만기일 산출 금지 (근거: LoanScheduleCalculationPlatformServiceImpl.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_repayment_schedule`
- `m_loan_repayment_schedule_history`
- `m_loan_amortization_allocation_mapping`
- `m_loan_progressive_model`
- `m_loan_recalculation_details`
- `m_loan_interest_recalculation_additional_details`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-004-상환스케줄/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: 대출 스케줄 계산 API 호출 시 각 회차별 원금, 이자, 수수료의 합이 대출 총액과 정확히 일치한다. (근거: `LoanScheduleCalculationPlatformServiceImpl.java`)
- **SC-002**: 이자 재계산 실행 시 이전 스케줄이 이력 테이블(`m_loan_repayment_schedule_history`)로 백업되고 새 스케줄이 반영된다. (근거: `LoanRepaymentScheduleHistory.java`)

## 근거
* [`specs/FN-004-상환스케줄/data-model.md`](/specs/FN-004-상환스케줄/data-model.md) (`FN-004-상환스케줄/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleCalculationPlatformServiceImpl.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/loanschedule/service/LoanScheduleAssembler.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java`)
* [`backend/fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java`](/backend/fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java) (`fineract-progressive-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/ProgressiveLoanModel.java`)
