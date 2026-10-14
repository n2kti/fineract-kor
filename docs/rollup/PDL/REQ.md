# [PDL] 요구사항정의서

> 화면 1개 롤업(중분류 PDL, 대분류 PD). 화면 단위 원본은 `specs/<화면>/spec.md`.

## PDL-001 대출상품관리

> 원본: `PDL-001-대출상품관리/spec.md`

## [PDL-001] 대출 상품 관리 명세서

### 기능 개요 및 목표
- **FR-001**: 대출 상품 신규 등록 및 기본 속성(원금 한도, 이자율 방식, 상환 주기 등) 설정 기능 (근거: `LoanProductsApiResource.java, LoanProductWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-002**: 대출 상품별 상환금(Payment) 충당/배분 순서 규칙(원금/이자/수수료 등) 정의 및 관리 기능 (근거: `LoanProductPaymentAllocationRule.java, LoanProductWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-003**: 대출 상품별 크레딧(입금액) 배분 규칙(Credit Allocation Rule) 정의 및 관리 기능 (근거: `LoanProductCreditAllocationRule.java, LoanProductWritePlatformServiceJpaRepositoryImpl.java`)
- **FR-004**: 대출 상품별 대손충당금(Provisioning Criteria) 설정 및 회계 계정 매핑 기능 (근거: `LoanProductProvisionCriteria.java, LoanProductWritePlatformServiceJpaRepositoryImpl.java`)

### 하지 말아야 할 것
- 이미 활성화된 대출 계좌가 존재하는 대출 상품의 핵심 통화(Currency) 및 회계 방식(Accounting Rule) 임의 변경 금지 (근거: LoanProduct.java)
- 미지원 트랜잭션 유형에 대한 배분 규칙(Allocation Rule) 등록 금지 (근거: LoanProductPaymentAllocationRule.java)

### 데이터 모델
본 화면에서 사용하는 주요 테이블 목록:
- `m_loan_product_credit_allocation_rule`
- `m_loan_product_payment_allocation_rule`
- `m_product_loan`

> 상세 물리 스키마, 컬럼 타입, 제약조건 및 ER 다이어그램은 [data-model.md](/specs/PDL-001-대출상품관리/data-model.md) 를 참조한다.

### 완료 기준
- **SC-001**: 대출 상품 등록 API 호출 시 유효성 검증을 통과하고 상품 및 배분 규칙 테이블에 정상 저장된다. (근거: `LoanProductsApiResource.java`)
- **SC-002**: 등록된 대출 상품의 배분 규칙이 대출 계좌 생성 시 정상적으로 기본값으로 상속 및 적용된다. (근거: `LoanProductPaymentAllocationRule.java`)

### 근거
* [`specs/PDL-001-대출상품관리/data-model.md`](/specs/PDL-001-대출상품관리/data-model.md) (`PDL-001-대출상품관리/data-model.md`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/api/LoanProductsApiResource.java`)
* [`backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/service/LoanProductWritePlatformServiceJpaRepositoryImpl.java`](/backend/fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/service/LoanProductWritePlatformServiceJpaRepositoryImpl.java) (`fineract-provider/src/main/java/org/apache/fineract/portfolio/loanproduct/service/LoanProductWritePlatformServiceJpaRepositoryImpl.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProduct.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProduct.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProduct.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductPaymentAllocationRule.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductPaymentAllocationRule.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductPaymentAllocationRule.java`)
* [`backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductCreditAllocationRule.java`](/backend/fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductCreditAllocationRule.java) (`fineract-loan/src/main/java/org/apache/fineract/portfolio/loanproduct/domain/LoanProductCreditAllocationRule.java`)
