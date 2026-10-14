# [현상관찰-0001] 금융 거래 불변성 보장을 위한 역분개(Undo/Reversal) 및 거래 관계 추적 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
코어뱅킹 회계 원칙상 한 번 기록된 금융 트랜잭션은 절대 물리적으로 삭제(DELETE)되거나 수정되어서는 안 된다. 잘못 입력된 상환 거래는 반대 분개(Reversal)를 통해 상쇄되어야 하며, 원거래와 취소 거래 간의 연결 고리가 보존되어야 한다.

## 관찰된 구현
1. `m_loan_transaction` 테이블에 `is_reversed` 불리언 플래그를 두고, 거래 취소 시 원거래를 `is_reversed=true`로 마킹한다.
2. 원거래와 상쇄/조정 거래 간의 매핑을 `m_loan_transaction_relation` 테이블에 `from_loan_transaction_id`, `to_loan_transaction_id`, `relation_type`으로 명시적 기록한다.
- **배제한 대안**: 오입력된 거래 레코드를 DB에서 직접 `DELETE`하거나 `amount`를 0으로 UPDATE하는 방식 (회계 감사 및 원장 불일치를 초래하므로 절대 금지).

## 영향
• 장점: 원장 데이터의 회계적 불변성과 완전성이 보장되며, 모든 정정 거래의 인과관계를 추적할 수 있다.
• 제약 및 영향: 잔액 및 거래 내역 조회 시 항상 `is_reversed = false` 조건을 명시해야 한다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTransaction.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTransactionRelation.java`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
