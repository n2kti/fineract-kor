# [FN-006] 연체및채권 명세서

## 기능 개요 및 목표
- **FR-001**: 납기일 경과 대출에 대한 연체 일수(Days in Arrears) 계산 및 연체 구간(Delinquency Range/Bucket) 분류 기능 (근거: `DelinquencyWritePlatformServiceImpl.java, DelinquencyReadPlatformServiceImpl.java`)
- **FR-002**: 대출 계좌 및 상환 회차별 연체 등급 태그 이력 관리 기능 (근거: `LoanDelinquencyTagHistory.java, LoanInstallmentDelinquencyTag.java`)
- **FR-003**: 연체 대출에 대한 채권 관리 조치(Delinquency Action: 일시 정지, 재개 등) 등록 및 실행 기능 (근거: `LoanDelinquencyAction.java, DelinquencyWritePlatformServiceImpl.java`)
- **FR-004**: 연체 회차별 연체료(Overdue Installment Charge / Penalty) 자동 계산 및 부과 기능 (근거: `LoanOverdueInstallmentCharge.java, LoanChargeWritePlatformServiceImpl.java`)
- **FR-005**: 연체 구간에 따른 대손충당금(Loan Loss Provisioning) 적립률 산출 및 분개 데이터 생성 기능 (근거: `LoanProductProvisioningEntry.java, LoanProductProvisionCriteria.java`)

## 하지 말아야 할 것
- 연체 일시 정지(Pause) 상태인 대출에 대한 신규 연체 태그 전이 및 연체료 자동 가산 금지 (근거: LoanDelinquencyAction.java)
- 정상 납부 완료된 상환 회차에 대한 소급 연체료 부과 금지 (근거: LoanOverdueInstallmentCharge.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_delinquency_action`
- `m_loan_delinquency_tag_history`
- `m_loan_installment_delinquency_tag`
- `m_loan_overdue_installment_charge`
- `m_loanproduct_provisioning_mapping`
- `m_loanproduct_provisioning_entry`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-006-연체및채권/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: COB 배치 실행 시 연체 일수에 해당하는 연체 구간 태그가 `m_loan_delinquency_tag_history`에 정확히 반영된다. (근거: `DelinquencyWritePlatformServiceImpl.java`)
- **SC-002**: 연체 조치(Pause) 등록 시 설정된 기간 동안 연체 등급 산정이 유예된다. (근거: `LoanDelinquencyAction.java`)

## 근거
* [`specs/FN-006-연체및채권/data-model.md`](/specs/FN-006-연체및채권/data-model.md) (`FN-006-연체및채권/data-model.md`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyWritePlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/service/DelinquencyReadPlatformServiceImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyAction.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanDelinquencyTagHistory.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/domain/LoanInstallmentDelinquencyTag.java`)
