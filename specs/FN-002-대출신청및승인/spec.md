# [FN-002] 대출신청및승인 명세서

## 기능 개요 및 목표
- **FR-001**: 고객(Client) 또는 그룹(Group) 기반 대출 신청서(Loan Application) 접수 및 계좌 번호 발급 기능 (근거: `LoansApiResource.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 대출 신청 건에 대한 대출 심사역(Loan Officer) 배정 및 변경 이력 추적 기능 (근거: `LoanOfficerAssignmentHistory.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-003**: 대출 승인(Approval) 처리 및 승인 금액(Approved Amount) 변경 이력 기록 기능 (근거: `LoanApprovedAmountHistory.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 대출 신청, 승인, 반려, 취소 등 대출 계좌 상태 전이 이력 추적 기능 (근거: `LoanStatusChangeHistory.java, LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-005**: 대출 모집인(Loan Originator) 등록 및 대출 계좌와의 연계 매핑 관리 기능 (근거: `LoanOriginator.java, LoanOriginatorMapping.java`)
- **FR-006**: COB(Close of Business) 및 트랜잭션 동시성 처리를 위한 대출 계좌 단위 락(Lock) 관리 기능 (근거: `LoanAccountLock.java, LoanWritePlatformServiceJpaRepositoryImpl.java`)

## 하지 말아야 할 것
- 승인(Approved) 상태가 아닌 대출에 대한 대출금 지급(Disbursement) 실행 금지 (근거: Loan.java)
- 필수 차주(Client/Group) 정보 또는 상품(Product) 정의가 누락된 대출 신청서 제출 불가 (근거: LoanApplicationWritePlatformServiceJpaRepositoryImpl.java)

## 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan`
- `m_loan_approved_amount_history`
- `m_loan_status_change_history`
- `m_loan_officer_assignment_history`
- `m_loan_originator`
- `m_loan_originator_mapping`
- `m_loan_account_locks`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/FN-002-대출신청및승인/data-model.md) 를 참조한다.

## 완료 기준
- **SC-001**: 대출 신청서 제출 시 `m_loan` 테이블에 `SUBMITTED_AND_PENDING_APPROVAL` 상태로 데이터가 정상 생성된다. (근거: `LoansApiResource.java`)
- **SC-002**: 대출 승인 API 호출 시 승인 상태로 전환되며 `m_loan_approved_amount_history`에 승인 정보가 적재된다. (근거: `LoanApprovedAmountHistory.java`)

## 근거
* [`specs/FN-002-대출신청및승인/data-model.md`](/specs/FN-002-대출신청및승인/data-model.md) (`FN-002-대출신청및승인/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/service/LoanApplicationWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/Loan.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanApprovedAmountHistory.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanaccount/domain/LoanStatusChangeHistory.java`)
* [`backend/fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java`](/backend/fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java) (`fineract-loan-origination/src/main/java/org/apache/fineract/portfolio/loanorigination/domain/LoanOriginator.java`)
