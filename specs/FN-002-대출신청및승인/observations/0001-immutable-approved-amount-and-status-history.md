# [현상관찰-0001] 불변 승인 금액 및 대출 상태 전이 이력 분리 추적 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
은행 및 금융 규제 기관은 대출 신청 금액, 심사역 승인 금액, 최종 실행 금액의 차이 및 심사 승인 상태 전이 과정의 완전한 감사 추적(Audit Trail)을 요구한다. 메인 테이블의 컬럼을 덮어쓰는 방식으로는 과거 이력을 재구성할 수 없다.

## 관찰된 구현
1. `m_loan` 기본 원장과 별개로 `m_loan_approved_amount_history`와 `m_loan_status_change_history`를 불변(Append-only) 테이블로 설계한다.
2. 승인 금액 변경 또는 상태 전이 이벤트 발생 시 도메인 이벤트 리스너를 통해 이력 레코드를 자동으로 적재한다.
- **배제한 대안**: `m_loan` 테이블에 `approved_amount`, `previous_status` 등 단일 컬럼만 두고 최신 값으로 UPDATE하는 방식 (다단계 승인 및 변경 이력 추적이 불가능하여 배제함).

## 영향
• 장점: 금융 감사 및 규제 준수 요건을 100% 충족하며 시점별 승인 이력을 정확히 조회할 수 있다.
• 제약 및 영향: 대출 승인 프로세스 진행 시 복수의 INSERT 트랜잭션이 발생한다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1021_add_loan_status_change_history.xml`
