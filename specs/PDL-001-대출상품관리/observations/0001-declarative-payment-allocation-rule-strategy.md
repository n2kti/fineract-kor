# [현상관찰-0001] 선언적 상환금 배분 규칙(Payment Allocation Rule) 전략 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
금융 기관 및 대출 상품마다 상환금 입금 시 충당하는 순서(예: 연체료 우선 vs 이자 우선 vs 원금 우선)와 조기상환 시 미래 회차 충당 방식이 상이하다. 이를 하드코딩할 경우 상품 추가 및 규제 변경에 대응하기 어렵다.

## 관찰된 구현
1. `m_loan_product_payment_allocation_rule` 및 `m_loan_product_credit_allocation_rule` 테이블을 통해 트랜잭션 유형별 충당 순서를 선언적 데이터로 관리한다.
2. 자바 도메인 서비스(`LoanProductPaymentAllocationRule`)가 거래 처리 시 해당 규칙을 동적으로 로드하여 충당 순서를 제어한다.
- **배제한 대안**: Java 소스 코드의 `switch-case` 또는 고정 ENUM으로 상환 충당 순서를 하드코딩하는 방식 (상품별 유연한 커스터마이징이 불가능하여 배제함).

## 영향
• 장점: 코드 수정 및 배포 없이 대출 상품 설정만으로 복잡한 상환 충당 규칙을 유연하게 구성할 수 있다.
• 제약 및 영향: 상환 거래 처리 시 배분 규칙 파싱 및 회차별 매핑 연산 비용이 추가된다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductPaymentAllocationRule.java`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1002_add_payment_allocation_rule.xml`
