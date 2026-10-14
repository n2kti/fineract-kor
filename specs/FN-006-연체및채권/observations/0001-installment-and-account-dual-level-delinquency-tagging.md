# [현상관찰-0001] 대출 계좌 및 상환 회차 이중 레벨 연체 태그(Delinquency Tag) 추적 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
연체 관리는 대출 계좌 전체의 연체 구간(Delinquency Bucket: 예 30일 이하, 30~60일)뿐 아니라, 개별 상환 회차(Installment)별 최초 연체 발생일 및 연체료 부과 기준이 정밀하게 일치해야 충당금 산출 및 채권 추심이 가능하다.

## 관찰된 구현
1. 대출 계좌 단위의 연체 이력은 `m_loan_delinquency_tag_history`에 기록하고, 회차 단위 연체 상태는 `m_loan_installment_delinquency_tag`에 분리하여 이중 추적한다.
2. 일배치(COB) 실행 시 연체 구간 정의(`m_delinquency_range`)에 따라 태그를 자동 갱신하고 연체 조치(`m_loan_delinquency_action`)에 따라 유예/정지를 제어한다.
- **배제한 대안**: 연체 태그 테이블 없이 조회 시점에 매번 `duedate`와 현재 날짜의 차이(DATEDIFF)로 동적 계산하는 방식 (과거 특정 시점의 연체 등급 재현 및 충당금 이력 관리가 불가능하여 배제함).

## 영향
• 장점: 계좌 및 회차 수준에서 시점별 정확한 연체 등급과 채권 관리 상태를 즉시 조회할 수 있다.
• 제약 및 영향: 일배치(COB) 시 대량의 대출 및 회차 레코드에 대한 연체 태그 동기화 배치 작업이 필수적이다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1008_add_loan_installment_delinquency_tag.xml`
