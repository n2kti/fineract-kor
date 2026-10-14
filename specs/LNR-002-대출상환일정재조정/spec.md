# [LNR-002] 대출 상환일정 재조정 명세서

## 기능 개요 및 목표
- **FR-001**: 차주 상환 일정 재조정(Reschedule) 신청서 접수, 심사 및 승인/반려 처리 기능 (근거: `RescheduleLoansApiResource.java, LoanRescheduleRequestWritePlatformServiceImpl.java`)
- **FR-002**: 재조정 승인에 따른 만기 연장, 이자율 변경, 거치 기간 등 계약 조건 변경(Term Variations) 적용 기능 (근거: `LoanTermVariations.java, LoanRescheduleRequestWritePlatformServiceImpl.java`)
- **FR-003**: 연체 대출 정상화를 위한 만기 재설정 및 연체 일수 초기화(Re-Age) 파라미터 구성 기능 (근거: `LoanReAgeParameter.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 대출 잔액 재상각(Re-Amortization) 처리 및 상환 스케줄 재산출 기능 (근거: `LoanReAmortizationParameter.java, LoanScheduleCalculationPlatformServiceImpl.java`)
- **FR-005**: 기존 대출 잔액 상환을 동반한 추가 대출(Top-up) 신청 및 실행 처리 기능 (근거: `LoanTopupDetails.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

## 하지 말아야 할 것
- 승인되지 않은 재조정 신청 건에 대한 상환 스케줄 임의 반영 금지 (근거: LoanRescheduleRequest.java)
- 이미 종결(Closed)되거나 완제된 대출 계좌에 대한 재조정 및 Top-up 신청 불가 (근거: LoanRescheduleRequestWritePlatformServiceImpl.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_reschedule_request`
- `m_loan_reschedule_request_term_variations_mapping`
- `m_loan_reage_parameter`
- `m_loan_reamortization_parameter`
- `m_loan_term_variations`
- `m_loan_topup`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/LNR-002-대출상환일정재조정/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: 재조정 신청 승인 시 `m_loan_reschedule_request` 상태가 승인으로 전이되고 변경된 조건이 스케줄에 즉시 반영된다. (근거: `LoanRescheduleRequestWritePlatformServiceImpl.java`)
- **SC-002**: Re-Age / Re-Amortization 실행 시 관련 파라미터 테이블에 이력이 보관되고 스케줄이 정상 재조정된다. (근거: `LoanReAgeParameter.java, LoanReAmortizationParameter.java`)

## 근거
* [`specs/LNR-002-대출상환일정재조정/data-model.md`](/specs/LNR-002-대출상환일정재조정/data-model.md) (`LNR-002-대출상환일정재조정/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/api/RescheduleLoansApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/api/RescheduleLoansApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/api/RescheduleLoansApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/service/LoanRescheduleRequestWritePlatformServiceImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/service/LoanRescheduleRequestWritePlatformServiceImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/service/LoanRescheduleRequestWritePlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/domain/LoanRescheduleRequest.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/domain/LoanRescheduleRequest.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/domain/LoanRescheduleRequest.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reaging/LoanReAgeParameter.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reaging/LoanReAgeParameter.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reaging/LoanReAgeParameter.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reamortization/LoanReAmortizationParameter.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reamortization/LoanReAmortizationParameter.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/reamortization/LoanReAmortizationParameter.java`)
