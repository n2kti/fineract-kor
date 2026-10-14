# [현상관찰-0001] 다회차 분할 지급(Multi-Tranche) 및 트랜치별 수수료 연계 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
건축 대출, 시설 자금 대출, 농업 대출 등은 사업 공정률에 따라 자금을 여러 차례에 나누어 분할 지급(Tranche)해야 하며, 각 지급 회차마다 별도의 지급 수수료가 부과되고 상환 스케줄이 재산출되어야 한다.

## 관찰된 구현
1. `m_loan_disbursement_detail` 테이블에 트랜치별 지급 예정일, 실제 지급일, 원금 금액을 개별 레코드로 관리한다.
2. 각 트랜치 지급 시점에 부과되는 수수료를 `m_loan_tranche_disbursement_charge` 테이블로 직접 연결한다.
- **배제한 대안**: 트랜치 지급마다 별도의 자식 대출 계좌(Sub-account)를 신규 개설하는 방식 (통합 한도 관리 및 고객 계좌 관리가 복잡해져 배제함).

## 영향
• 장점: 단일 대출 계좌 내에서 유연한 다회차 분할 지급 및 트랜치별 수수료/일정 통제가 가능하다.
• 제약 및 영향: 미지급 트랜치가 존재하는 동안 상환 스케줄 계산 로직이 가변 트랜치 일정을 고려해야 하므로 복잡도가 증가한다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanDisbursementDetails.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanTrancheDisbursementCharge.java`
* `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
