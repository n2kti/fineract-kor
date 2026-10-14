# [FN-006] 연체및채권 API 명세서

## 1. 개요 및 엔드포인트 목록

본 문서는 `FN-006-연체및채권` 화면에서 사용하는 연체 구간(Delinquency Range), 연체 버킷(Delinquency Bucket), 대출 계좌별 연체 태그 이력 조회, 채권 관리 조치(Delinquency Action: Pause/Resume), 연체 수동 분류 및 대손충당금(Provisioning) 기준/분개 처리를 위한 JAX-RS REST API 명세서이다.

* **연관 데이터 모델**: `m_loan_delinquency_action`, `m_loan_delinquency_tag_history`, `m_loan_installment_delinquency_tag`, `m_loan_overdue_installment_charge`, `m_loanproduct_provisioning_mapping`, `m_loanproduct_provisioning_entry` (참조: [data-model.md](/specs/FN-006-연체및채권/data-model.md))

### 엔드포인트 요약표

| HTTP 메서드 | 요청 경로 | 기능 요약 | 대상 클래스 | 대상 메서드 |
| :--- | :--- | :--- | :--- | :--- |
| `GET` | `/v1/delinquency/ranges` | 연체 구간(Delinquency Range) 목록 조회 | `DelinquencyApiResource` | `getDelinquencyRanges` |
| `POST` | `/v1/delinquency/ranges` | 연체 구간 신규 생성 | `DelinquencyApiResource` | `createDelinquencyRange` |
| `GET` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 특정 연체 구간 상세 조회 | `DelinquencyApiResource` | `getDelinquencyRange` |
| `PUT` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 연체 구간 수정 | `DelinquencyApiResource` | `updateDelinquencyRange` |
| `DELETE` | `/v1/delinquency/ranges/{delinquencyRangeId}` | 연체 구간 삭제 | `DelinquencyApiResource` | `deleteDelinquencyRange` |
| `GET` | `/v1/delinquency/buckets` | 연체 버킷(Delinquency Bucket) 목록 조회 | `DelinquencyApiResource` | `getDelinquencyBuckets` |
| `POST` | `/v1/delinquency/buckets` | 연체 버킷 신규 생성 | `DelinquencyApiResource` | `createDelinquencyBucket` |
| `GET` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 특정 연체 버킷 상세 조회 | `DelinquencyApiResource` | `getDelinquencyBucket` |
| `PUT` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 연체 버킷 수정 | `DelinquencyApiResource` | `updateDelinquencyBucket` |
| `DELETE` | `/v1/delinquency/buckets/{delinquencyBucketId}` | 연체 버킷 삭제 | `DelinquencyApiResource` | `deleteDelinquencyBucket` |
| `GET` | `/v1/loans/{loanId}/delinquencytags` | 대출 계좌의 연체 등급/태그 변경 이력 조회 (`m_loan_delinquency_tag_history`) | `LoansApiResource` | `getDelinquencyTagHistory` |
| `GET` | `/v1/loans/{loanId}/delinquency-actions` | 대출 계좌의 채권 조치(Pause 등) 이력 조회 (`m_loan_delinquency_action`) | `LoansApiResource` | `getLoanDelinquencyActions` |
| `POST` | `/v1/loans/{loanId}/delinquency-actions` | 대출 연체 관리 조치(Pause/Resume) 등록 | `LoansApiResource` | `createLoanDelinquencyAction` |
| `POST` | `/v1/loans/{loanId}?command=assigndelinquency` | 대출 계좌 연체 수동 분류 및 강제 지정 | `LoansApiResource` | `stateTransitions` |
| `GET` | `/v1/provisioningcriteria` | 대손충당금 설정 기준 목록 조회 (`m_loanproduct_provisioning_mapping`) | `ProvisioningCriteriaApiResource` | `retrieveAllProvisioningCriterias` |
| `POST` | `/v1/provisioningcriteria` | 대손충당금 기준 생성 및 대출상품 매핑 등록 | `ProvisioningCriteriaApiResource` | `createProvisioningCriteria` |
| `GET` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 상세 조회 | `ProvisioningCriteriaApiResource` | `retrieveTemplate` |
| `PUT` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 수정 | `ProvisioningCriteriaApiResource` | `updateProvisioningCriteria` |
| `DELETE` | `/v1/provisioningcriteria/{criteriaId}` | 대손충당금 기준 삭제 | `ProvisioningCriteriaApiResource` | `deleteProvisioningCriteria` |
| `GET` | `/v1/provisioningentries` | 대손충당금 산출 분개 목록 조회 (`m_loanproduct_provisioning_entry`) | `ProvisioningEntriesApiResource` | `retrieveAllProvisioningEntries` |
| `POST` | `/v1/provisioningentries` | 대손충당금 적립액 자동 산출 분개 생성 | `ProvisioningEntriesApiResource` | `createProvisioningEntries` |
| `POST` | `/v1/provisioningentries/{entryId}?command=journalentry` | 산출된 대손충당금 회계 분개 전표 발행 | `ProvisioningEntriesApiResource` | `createProvisioningEntries` |

---

## 2. API 상세 명세

### 2.1 연체 구간 및 버킷 관리 (`DelinquencyApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.delinquency.api.DelinquencyApiResource` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/api/DelinquencyApiResource.java:63`)
* **기본 경로**: `@Path("/v1/delinquency")` (근거: `fineract-loan/src/main/java/org/apache/fineract/portfolio/delinquency/api/DelinquencyApiResource.java:60`)
* **엔드포인트**:
  * `GET /v1/delinquency/ranges` (getDelinquencyRanges): 연체 구간 목록 (권한: `DELINQUENCY_BUCKET` 읽기) (근거: `DelinquencyApiResource.java:77`)
  * `POST /v1/delinquency/ranges` (createDelinquencyRange): 연체 구간 등록 (`minAgeDays`, `maxAgeDays`, `classification`) (권한: `CREATE_DELINQUENCY_BUCKET`) (근거: `DelinquencyApiResource.java:101`)
  * `GET /v1/delinquency/buckets` (getDelinquencyBuckets): 연체 버킷 목록 (권한: `DELINQUENCY_BUCKET` 읽기) (근거: `DelinquencyApiResource.java:155`)
  * `POST /v1/delinquency/buckets` (createDelinquencyBucket): 연체 버킷 생성 (`ranges` 매핑) (권한: `CREATE_DELINQUENCY_BUCKET`) (근거: `DelinquencyApiResource.java:192`)

---

### 2.2 대출 계좌 연체 태그 및 조치 관리 (`LoansApiResource`)
* **자바 클래스**: `org.apache.fineract.portfolio.loanaccount.api.LoansApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:180`)
* **엔드포인트**:
  * `GET /v1/loans/{loanId}/delinquencytags` (getDelinquencyTagHistory):
    * 메서드: `public String getDelinquencyTagHistory(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:746`)
    * 권한: `context.authenticatedUser().validateHasReadPermission("DELINQUENCY_TAGS")` (근거: `LoansApiResource.java:1392`)
    * 응답: `LoanDelinquencyTagHistoryData` 목록 (`delinquencyRange`, `addedOnDate`, `liftedOnDate`)
  * `GET /v1/loans/{loanId}/delinquency-actions` (getLoanDelinquencyActions):
    * 메서드: `public String getLoanDelinquencyActions(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:864`)
    * 권한: `context.authenticatedUser().validateHasReadPermission("DELINQUENCY_ACTION")` (근거: `LoansApiResource.java:1401`)
  * `POST /v1/loans/{loanId}/delinquency-actions` (createLoanDelinquencyAction):
    * 메서드: `public String createLoanDelinquencyAction(@PathParam("loanId") final Long loanId, ...)` (근거: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/api/LoansApiResource.java:891`)
    * 권한: `context.authenticatedUser().validateHasCreatePermission("DELINQUENCY_ACTION")` (근거: `LoansApiResource.java:1412`)
    * 요청 필드: `action` (`PAUSE`, `RESUME`), `startDate`, `endDate`

---

### 2.3 대손충당금 기준 및 분개 관리 (`ProvisioningCriteriaApiResource` / `ProvisioningEntriesApiResource`)
* **자바 클래스**:
  * `org.apache.fineract.organisation.provisioning.api.ProvisioningCriteriaApiResource` (근거: `fineract-provider/src/main/java/org/apache/fineract/organisation/provisioning/api/ProvisioningCriteriaApiResource.java:55`)
  * `org.apache.fineract.accounting.provisioning.api.ProvisioningEntriesApiResource` (근거: `fineract-accounting/src/main/java/org/apache/fineract/accounting/provisioning/api/ProvisioningEntriesApiResource.java:56`)
* **엔드포인트**:
  * `POST /v1/provisioningcriteria` (createProvisioningCriteria): 대출 상품별 대손충당금 적립률 설정 (근거: `ProvisioningCriteriaApiResource.java:104`)
  * `POST /v1/provisioningentries` (createProvisioningEntries): 대손충당금 분개 데이터 산출 생성 (`date`, `createjournalentries`) (근거: `ProvisioningEntriesApiResource.java:75`)
  * `POST /v1/provisioningentries/{entryId}?command=journalentry` (createProvisioningEntries): 확정 회계 전표 발행 (근거: `ProvisioningEntriesApiResource.java:96`)
* **권한 체크**: `READ_PROVISIONINGCRITERIA`, `CREATE_PROVISIONINGCRITERIA`, `CREATE_PROVISIONINGENTRY` (서비스 계층 위임)

---

## 3. 미확인 항목 검증 통계

* **총 엔드포인트 수**: 22개
* **미확인 항목 수**: 0건 (모든 엔드포인트, 연체 구간/버킷/태그, 채권 조치, 충당금 기준 및 분개 API 소스 확인 완료)
