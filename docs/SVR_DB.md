# [SVR] DB명세서

> 화면 1개 롤업(소분류 SVR, 대분류 SV - 정기적금 계좌).

## SVR-001 정기적금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_deposit_account_recurring_detail` | 정기적금 월 불입 약정금액, 불입주기, 자동이체 연결 정보 |
| `m_deposit_account_term_and_preclosure` | 적금 만기 약정 및 중도해지 조건 |
| `m_mandatory_savings_schedule` | 회차별 적금 의무 불입 일정표 및 입금 실적 |

### `m_deposit_account_recurring_detail` - 정기적금 월 불입 약정금액, 불입주기, 자동이체 연결 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `mandatory_recommended_deposit_amount` | DECIMAL(19, 6) | NULL | mandatory_recommended_deposit_amount 금액 |
| `is_mandatory` | boolean | NOT NULL | mandatory 여부 플래그 (Boolean) |
| `allow_withdrawal` | boolean | NOT NULL | allow_withdrawal 필드 |
| `adjust_advance_towards_future_payments` | boolean | NOT NULL | adjust_advance_towards_future_payments 필드 |
| `is_calendar_inherited` | boolean | NOT NULL | calendar_inherited 여부 플래그 (Boolean) |
| `total_overdue_amount` | DECIMAL(19, 6) | NULL | total_overdue_amount 금액 |
| `no_of_overdue_installments` | INT | NULL | no_of_overdue_installments 필드 |

### `m_deposit_account_term_and_preclosure` - 적금 만기 약정 및 중도해지 조건
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `min_deposit_term` | INT | NULL | min_deposit_term 필드 |
| `max_deposit_term` | INT | NULL | max_deposit_term 필드 |
| `min_deposit_term_type_enum` | SMALLINT | NULL | min_deposit_term_type 유형 구분 Enum 코드 |
| `max_deposit_term_type_enum` | SMALLINT | NULL | max_deposit_term_type 유형 구분 Enum 코드 |
| `in_multiples_of_deposit_term` | INT | NULL | in_multiples_of_deposit_term 필드 |
| `in_multiples_of_deposit_term_type_enum` | SMALLINT | NULL | in_multiples_of_deposit_term_type 유형 구분 Enum 코드 |
| `pre_closure_penal_applicable` | boolean | NULL | pre_closure_penal_applicable 필드 |
| `pre_closure_penal_interest` | DECIMAL(19, 6) | NULL | pre_closure_penal_interest 필드 |
| `pre_closure_penal_interest_on_enum` | SMALLINT | NULL | pre_closure_penal_interest_on 유형 구분 Enum 코드 |
| `deposit_period` | INT | NULL | deposit_period 필드 |
| `deposit_period_frequency_enum` | SMALLINT | NULL | deposit_period_frequency 유형 구분 Enum 코드 |
| `deposit_amount` | DECIMAL(19, 6) | NULL | deposit_amount 금액 |
| `maturity_amount` | DECIMAL(19, 6) | NULL | maturity_amount 금액 |
| `maturity_date` | date | NULL | maturity_date 일자 |
| `on_account_closure_enum` | SMALLINT | NULL | on_account_closure 유형 구분 Enum 코드 |
| `expected_firstdepositon_date` | date | NULL | expected_firstdepositon_date 일자 |
| `transfer_interest_to_linked_account` | boolean | NOT NULL | transfer_interest_to_linked_account 필드 |
| `transfer_to_savings_account_id` | BIGINT | NULL | transfer_to_savings_account 참조 식별자 (FK) |

### `m_mandatory_savings_schedule` - 회차별 적금 의무 불입 일정표 및 입금 실적
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `fromdate` | date | NULL | fromdate 필드 |
| `duedate` | date | NOT NULL | duedate 필드 |
| `installment` | SMALLINT | NOT NULL | installment 필드 |
| `deposit_amount` | DECIMAL(19, 6) | NULL | deposit_amount 금액 |
| `deposit_amount_completed_derived` | DECIMAL(19, 6) | NULL | deposit_amount_completed 자동 집계/산출 필드 |
| `total_paid_in_advance_derived` | DECIMAL(19, 6) | NULL | total_paid_in_advance 자동 집계/산출 필드 |
| `total_paid_late_derived` | DECIMAL(19, 6) | NULL | total_paid_late 자동 집계/산출 필드 |
| `completed_derived` | boolean | NOT NULL | completed 자동 집계/산출 필드 |
| `obligations_met_on_date` | date | NULL | obligations_met_on_date 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/domain/DepositAccountRecurringDetail.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/domain/RecurringDepositScheduleInstallment.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0128_savings_audit.xml`
