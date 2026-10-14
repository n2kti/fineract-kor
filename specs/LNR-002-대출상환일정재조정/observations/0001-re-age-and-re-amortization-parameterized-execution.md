# [현상관찰-0001] Re-Age(연체 초기화) 및 Re-Amortization(재상각) 파라미터 분리 실행 설계

> ⚠️ 본 문서는 사람이 결정한 ADR이 아니라 코드에서 역추출한 현상 설명이다.


## 상태
재구성됨 미검증


## 배경
부실 채권 정상화 지원 시 만기를 재조정하여 연체 일수를 합법적으로 초기화(Re-Age)하는 처리와, 변경된 잔액 및 금리를 바탕으로 남은 기간 동안의 원리금을 재상각(Re-Amortization)하는 처리는 회계적/수학적 알고리즘이 완전히 상이하다.

## 관찰된 구현
1. Re-Age 전용 파라미터 엔티티 `LoanReAgeParameter`(`m_loan_reage_parameter`)와 Re-Amortization 전용 파라미터 엔티티 `LoanReAmortizationParameter`(`m_loan_reamortization_parameter`)를 각각 독립 모델로 정의한다.
2. 각 조정 작업 실행 시 입력된 파라미터를 불변 데이터로 저장한 후 상환 스케줄러가 독립 엔진으로 스케줄을 재산출한다.
- **배제한 대안**: 모든 대출 조정 파라미터를 단일 비정규화 텍스트/JSON 필드에 합쳐서 저장하는 방식 (파라미터별 타입 검증 및 스케줄 재산출 엔진의 모듈화가 저해되어 배제함).

## 영향
• 장점: 대출 조정 유형별 파라미터 유효성 검증과 비즈니스 로직이 명확히 격리되어 유지보수성이 향상된다.
• 제약 및 영향: 대출 조정 처리 시 조정 유형에 따라 서로 다른 API 엔드포인트 및 서비스 핸들러를 호출해야 한다.

## 근거
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reaging/LoanReAgeParameter.java`
* `fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reamortization/LoanReAmortizationParameter.java`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1033_add_reage_reasons_for_loan.xml`
* `fineract-loan/src/main/resources/db/changelog/tenant/module/loan/parts/1034_loan_reamortization_parameters.xml`
