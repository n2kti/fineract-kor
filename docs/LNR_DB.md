# [LNR] DB명세서

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

## LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_transaction` | 대출 원리금 상환, 실행, 감면, 대손상각 등 모든 금융 거래 원장 |
| `m_loan_transaction_repayment_schedule_mapping` | 특정 거래(상환)가 상환스케줄의 어느 회차 원금/이자에 충당(충당전략)되었는지 N:M 매핑 |
| `m_loan_transaction_relation` | 역분개/거래취소 시 원거래와 취소거래 간 2방향 연결 추적 |
| `m_loan_overdue_installment_charge` | 연체 발생 회차별 연체료 부과/계산 데이터 |

### `m_loan_transaction` - 대출 원리금 상환, 실행, 감면, 대손상각 등 모든 금융 거래 원장
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `charge_refund_charge_type` | VARCHAR(1) | NULL | charge_refund_charge_type 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `reversal_external_id` | VARCHAR(100) | NULL | reversal_external 참조 식별자 (FK) |
| `reversed_on_date` | date | NULL | reversed_on_date 일자 |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `payment_detail_id` | BIGINT | NULL | payment_detail 참조 식별자 (FK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `transaction_type_enum` | SMALLINT | NOT NULL | transaction_type 유형 구분 Enum 코드 |
| `transaction_date` | date | NOT NULL | transaction_date 일자 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `principal_portion_derived` | DECIMAL(19, 6) | NULL | principal_portion 자동 집계/산출 필드 |
| `interest_portion_derived` | DECIMAL(19, 6) | NULL | interest_portion 자동 집계/산출 필드 |
| `fee_charges_portion_derived` | DECIMAL(19, 6) | NULL | fee_charges_portion 자동 집계/산출 필드 |
| `penalty_charges_portion_derived` | DECIMAL(19, 6) | NULL | penalty_charges_portion 자동 집계/산출 필드 |
| `overpayment_portion_derived` | DECIMAL(19, 6) | NULL | overpayment_portion 자동 집계/산출 필드 |
| `unrecognized_income_portion` | DECIMAL(19, 6) | NULL | unrecognized_income_portion 필드 |
| `outstanding_loan_balance_derived` | DECIMAL(19, 6) | NULL | outstanding_loan_balance 자동 집계/산출 필드 |
| `submitted_on_date` | date | NOT NULL | submitted_on_date 일자 |
| `manually_adjusted_or_reversed` | boolean | NULL | manually_adjusted_or_reversed 필드 |
| `created_date` | datetime | NULL | 생성 일시 |
| `appuser_id` | BIGINT | NULL | appuser 참조 식별자 (FK) |

### `m_loan_transaction_repayment_schedule_mapping` - 특정 거래(상환)가 상환스케줄의 어느 회차 원금/이자에 충당(충당전략)되었는지 N:M 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_transaction_id` | BIGINT | NOT NULL | loan_transaction 참조 식별자 (FK) |
| `loan_repayment_schedule_id` | BIGINT | NOT NULL | loan_repayment_schedule 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `principal_portion_derived` | DECIMAL(19, 6) | NULL | principal_portion 자동 집계/산출 필드 |
| `interest_portion_derived` | DECIMAL(19, 6) | NULL | interest_portion 자동 집계/산출 필드 |
| `fee_charges_portion_derived` | DECIMAL(19, 6) | NULL | fee_charges_portion 자동 집계/산출 필드 |
| `penalty_charges_portion_derived` | DECIMAL(19, 6) | NULL | penalty_charges_portion 자동 집계/산출 필드 |

### `m_loan_transaction_relation` - 역분개/거래취소 시 원거래와 취소거래 간 2방향 연결 추적
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `to_loan_charge_id` | BIGINT | NULL | to_loan_charge 참조 식별자 (FK) |
| `from_loan_transaction_id` | BIGINT | NOT NULL | from_loan_transaction 참조 식별자 (FK) |
| `to_loan_transaction_id` | BIGINT | NOT NULL | to_loan_transaction 참조 식별자 (FK) |
| `relation_type_enum` | INT | NOT NULL | relation_type 유형 구분 Enum 코드 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

### `m_loan_overdue_installment_charge` - 연체 발생 회차별 연체료 부과/계산 데이터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_charge_id` | BIGINT | NOT NULL | loan_charge 참조 식별자 (FK) |
| `loan_schedule_id` | BIGINT | NOT NULL | loan_schedule 참조 식별자 (FK) |
| `frequency_number` | INT | NOT NULL | frequency_number 필드 |

## LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_reschedule_request` | 만기연장, 상환유예, 이자감면 등 대출 재조정(Reschedule) 신청 및 승인 정보 |
| `m_loan_reschedule_request_term_variations_mapping` | 재조정 신청 건과 변경 조건 파라미터 매핑 |
| `m_loan_reage_parameter` | 연체 대출 재정상화(Re-age) 파라미터 실행 정보 |

### `m_loan_reschedule_request` - 만기연장, 상환유예, 이자감면 등 대출 재조정(Reschedule) 신청 및 승인 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `reschedule_from_installment` | SMALLINT | NOT NULL | Rescheduling will start from this installment |
| `reschedule_from_date` | date | NOT NULL | Rescheduling will start from the installment with due date similar to this date. |
| `recalculate_interest` | boolean | NULL | If set to 1, interest will be recalculated starting from the reschedule period. |
| `reschedule_reason_cv_id` | INT | NULL | ID of code value of reason for rescheduling |
| `reschedule_reason_comment` | VARCHAR(500) | NULL | Text provided in addition to the reason code value |
| `submitted_on_date` | date | NOT NULL | submitted_on_date 일자 |
| `submitted_by_user_id` | BIGINT | NOT NULL | submitted_by_user 참조 식별자 (FK) |
| `approved_on_date` | date | NULL | approved_on_date 일자 |
| `approved_by_user_id` | BIGINT | NULL | approved_by_user 참조 식별자 (FK) |
| `rejected_on_date` | date | NULL | rejected_on_date 일자 |
| `rejected_by_user_id` | BIGINT | NULL | rejected_by_user 참조 식별자 (FK) |

### `m_loan_reschedule_request_term_variations_mapping` - 재조정 신청 건과 변경 조건 파라미터 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_reschedule_request_id` | BIGINT | NOT NULL | loan_reschedule_request 참조 식별자 (FK) |
| `loan_term_variations_id` | BIGINT | NOT NULL | loan_term_variations 참조 식별자 (FK) |

### `m_loan_reage_parameter` - 연체 대출 재정상화(Re-age) 파라미터 실행 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `frequency` | VARCHAR(100) | NOT NULL | frequency 필드 |
| `number_of_installments` | SMALLINT | NOT NULL | number_of_installments 필드 |
| `start_date` | DATE | NOT NULL | start_date 일자 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |
| `loan_transaction_id` | BIGINT | NOT NULL | loan_transaction 참조 식별자 (FK) |
| `frequency_number` | SMALLINT | NOT NULL | frequency_number 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0019_refactor_loan_transaction.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0020_add_audit_entries.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0028_add_charge_refund_charge_type_to_loan_transaction.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0038_add_reversal_data_to_loan_transaction.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0052_loan_transaction_chargeback.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0068_loan_charge_adjustment.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0136_loan_reaging_parameters.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0180_add_version_field_to_loan_transaction.xml`
