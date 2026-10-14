# [현상관찰-0001] 이자 재계산 및 스케줄 재산출 시 과거 상환 스케줄 이력 보관 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
조기상환, 만기 연장, 금리 변경 등으로 인해 상환 스케줄이 재계산될 때, 기존 스케줄을 단순히 UPDATE하면 과거 고객에게 발송된 청구서 및 시점별 원리금 계획과의 차이를 검증할 수 없다.

## 관찰된 구현
1. 활성 상환 스케줄은 `m_loan_repayment_schedule`에서 관리하고, 재산출 이벤트 발생 시 기존 스케줄 전체를 `m_loan_repayment_schedule_history` 테이블에 복사(스냅샷)한 후 신규 스케줄을 반영한다.
2. `m_loan_interest_recalculation_additional_details`를 통해 이자 재계산의 유효 일자 및 변경 사유를 보존한다.
- **배제한 대안**: 단일 스케줄 테이블 내에서 `version` 컬럼 또는 유효기간(`valid_from`, `valid_to`)으로 과거 회차를 함께 관리하는 방식 (조회 쿼리 성능 저하 및 인덱스 팽창으로 배제함).

## 영향
• 장점: 현재 유효한 상환 스케줄 조회 쿼리가 단순화되며, 언제든지 과거 시점의 스케줄을 완벽히 복원할 수 있다.
• 제약 및 영향: 스케줄 변경 빈도가 높은 대출의 경우 이력 테이블 데이터 용량이 빠르게 증가한다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleHistory.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanRepaymentScheduleInstallment.java`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
