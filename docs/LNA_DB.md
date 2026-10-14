# [LNA] DB명세서

> 화면 2개 롤업(소분류 LNA, 대분류 LN - 대출 계좌 관리).

## LNA-001 대출 계좌 목록 및 상세

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan` | 대출 계좌 핵심 마스터 엔티티 (신청금액, 약정금리, 잔액, 상태 등 140개 컬럼) |
| `m_loan_arrears_aging` | 대출 연체 일수 및 구간별 연체금액 에이징 분석 데이터 |
| `m_loan_repayment_schedule` | 회차별 대출 원리금 상환 일정표 (원금, 이자, 수수료, 연체료 잔액) |

### `m_loan` - 대출 계좌 핵심 마스터 엔티티 (신청금액, 약정금리, 잔액, 상태 등 140개 컬럼)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `days_in_year_custom_strategy` | VARCHAR(100) | NULL | days_in_year_custom_strategy 이자율/비율 |
| `enable_buy_down_fee` | boolean | NOT NULL | enable_buy_down_fee 필드 |
| `buy_down_fee_calculation_type` | VARCHAR(100) | NULL | buy_down_fee_calculation_type 필드 |
| `buy_down_fee_strategy` | VARCHAR(100) | NULL | buy_down_fee_strategy 이자율/비율 |
| `buy_down_fee_income_type` | VARCHAR(100) | NULL | buy_down_fee_income_type 필드 |
| `allow_full_term_for_tranche` | boolean | NOT NULL | allow_full_term_for_tranche 필드 |
| `enable_down_payment` | boolean | NOT NULL | enable_down_payment 필드 |
| `disbursed_amount_percentage_for_down_payment` | DECIMAL(9, 6) | NULL | disbursed_amount_percentage_for_down_payment 금액 |
| `capitalized_income_derived` | DECIMAL(19, 6) | NOT NULL | capitalized_income 자동 집계/산출 필드 |
| `capitalized_income_adjustment_derived` | DECIMAL(19, 6) | NOT NULL | capitalized_income_adjustment 자동 집계/산출 필드 |
| `total_principal_derived` | DECIMAL(19, 6) | NOT NULL | total_principal 자동 집계/산출 필드 |
| `is_fraud` | boolean | NOT NULL | fraud 여부 플래그 (Boolean) |
| `principal_adjustments_derived` | DECIMAL(19, 6) | NOT NULL | principal_adjustments 자동 집계/산출 필드 |
| `enable_accrual_activity_posting` | boolean | NOT NULL | enable_accrual_activity_posting 필드 |
| `enable_installment_level_delinquency` | boolean | NOT NULL | enable_installment_level_delinquency 필드 |
| `capitalized_income_type` | VARCHAR(10) | NULL | capitalized_income_type 필드 |
| `enable_income_capitalization` | boolean | NOT NULL | enable_income_capitalization 필드 |
| `capitalized_income_calculation_type` | VARCHAR(100) | NULL | capitalized_income_calculation_type 필드 |
| `capitalized_income_strategy` | VARCHAR(100) | NULL | capitalized_income_strategy 이자율/비율 |
| `repayment_start_date_type_enum` | SMALLINT | NULL | repayment_start_date_type 유형 구분 Enum 코드 |
| `overpaidon_date` | date | NULL | overpaidon_date 일자 |
| `is_charged_off` | boolean | NOT NULL | charged_off 여부 플래그 (Boolean) |
| `charged_off_on_date` | date | NULL | charged_off_on_date 일자 |
| `charge_off_reason_cv_id` | BIGINT | NULL | charge_off_reason_cv 참조 식별자 (FK) |
| `charged_off_by_userid` | BIGINT | NULL | charged_off_by_userid 필드 |
| `last_closed_business_date` | DATE | NULL | last_closed_business_date 일자 |
| `loan_transaction_strategy_code` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_code 이자율/비율 |
| `loan_transaction_strategy_name` | VARCHAR(100) | NOT NULL | loan_transaction_strategy_name 이자율/비율 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `account_no` | VARCHAR(20) | NOT NULL | 계좌 번호 |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `client_id` | BIGINT | NULL | 고객 ID (FK: m_client.id) |
| `group_id` | BIGINT | NULL | 그룹 ID (FK: m_group.id) |
| `glim_id` | BIGINT | NULL | glim 참조 식별자 (FK) |
| `product_id` | BIGINT | NULL | 상품 ID (FK) |
| `fund_id` | BIGINT | NULL | 자금원 ID (FK: m_fund.id) |
| `loan_officer_id` | BIGINT | NULL | 대출 담당자 ID |
| `loanpurpose_cv_id` | INT | NULL | loanpurpose_cv 참조 식별자 (FK) |
| `loan_status_id` | SMALLINT | NOT NULL | 대출 상태 코드 (100:접수, 200:승인, 300:실행, 600:완제 등) |
| `loan_type_enum` | SMALLINT | NOT NULL | 대출 유형 (1:개인, 2:그룹, 3:GLIM) |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `principal_amount_proposed` | DECIMAL(19, 6) | NOT NULL | principal_amount_proposed 금액 |
| `principal_amount` | DECIMAL(19, 6) | NOT NULL | 원금 / 대출 신청금액 |
| `approved_principal` | DECIMAL(19, 6) | NOT NULL | 승인 원금 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NOT NULL | 실지급액 (수수료/선취이자 공제 후) |
| `arrearstolerance_amount` | DECIMAL(19, 6) | NULL | arrearstolerance_amount 금액 |
| `is_floating_interest_rate` | boolean | NULL | floating_interest_rate 여부 플래그 (Boolean) |
| `interest_rate_differential` | DECIMAL(19, 6) | NULL | interest_rate_differential 이자율/비율 |
| `nominal_interest_rate_per_period` | DECIMAL(19, 6) | NULL | 약정 이자율 |
| `interest_period_frequency_enum` | SMALLINT | NULL | interest_period_frequency 유형 구분 Enum 코드 |
| `annual_nominal_interest_rate` | DECIMAL(19, 6) | NULL | 연환산 명목 이자율 |
| `interest_method_enum` | SMALLINT | NOT NULL | 이자 계산 방식 (0:원리금균등, 1:단리/플랫 등) |
| `interest_calculated_in_period_enum` | SMALLINT | NOT NULL | 이자 기산 주기 (1:일할, 2:월할) |
| `allow_partial_period_interest_calcualtion` | boolean | NOT NULL | allow_partial_period_interest_calcualtion 필드 |
| `term_frequency` | SMALLINT | NOT NULL | 상환 총 기간 |
| `term_period_frequency_enum` | SMALLINT | NOT NULL | 기간 주기 단위 (0:일, 1:주, 2:월, 3:년) |
| `repay_every` | SMALLINT | NOT NULL | repay_every 필드 |
| `repayment_period_frequency_enum` | SMALLINT | NOT NULL | 상환 주기 단위 (0:일, 1:주, 2:월) |
| `number_of_repayments` | SMALLINT | NOT NULL | 총 상환 횟수 |
| `grace_on_principal_periods` | SMALLINT | NULL | grace_on_principal_periods 필드 |
| `recurring_moratorium_principal_periods` | SMALLINT | NULL | recurring_moratorium_principal_periods 필드 |
| `grace_on_interest_periods` | SMALLINT | NULL | grace_on_interest_periods 필드 |
| `grace_interest_free_periods` | SMALLINT | NULL | grace_interest_free_periods 필드 |
| `amortization_method_enum` | SMALLINT | NOT NULL | amortization_method 유형 구분 Enum 코드 |
| `submittedon_date` | date | NULL | 접수일자 |
| `submittedon_userid` | BIGINT | NULL | 접수자 ID |
| `approvedon_date` | date | NULL | 승인일자 |
| `approvedon_userid` | BIGINT | NULL | 승인자 ID |
| `expected_disbursedon_date` | date | NULL | 실행 예정일자 |
| `expected_firstrepaymenton_date` | date | NULL | expected_firstrepaymenton_date 일자 |
| `interest_calculated_from_date` | date | NULL | interest_calculated_from_date 일자 |
| `disbursedon_date` | date | NULL | 실제 실행일자 |
| `disbursedon_userid` | BIGINT | NULL | 실행자 ID |
| `expected_maturedon_date` | date | NULL | expected_maturedon_date 일자 |
| `maturedon_date` | date | NULL | maturedon_date 일자 |
| `closedon_date` | date | NULL | 계좌 종결일자 |
| `closedon_userid` | BIGINT | NULL | 종결자 ID |
| `total_charges_due_at_disbursement_derived` | DECIMAL(19, 6) | NULL | 실행시 부과 수수료 합계 |
| `principal_disbursed_derived` | DECIMAL(19, 6) | NOT NULL | 원금 실행 누적액 |
| `principal_repaid_derived` | DECIMAL(19, 6) | NOT NULL | 원금 상환 누적액 |
| `principal_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | 원금 대손상각 누적액 |
| `principal_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | 원금 잔액 |
| `interest_charged_derived` | DECIMAL(19, 6) | NOT NULL | 부과 이자 누적액 |
| `interest_repaid_derived` | DECIMAL(19, 6) | NOT NULL | 상환 이자 누적액 |
| `interest_waived_derived` | DECIMAL(19, 6) | NOT NULL | 감면 이자 누적액 |
| `interest_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | 상각 이자 누적액 |
| `interest_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | 이자 잔액 |
| `fee_charges_charged_derived` | DECIMAL(19, 6) | NOT NULL | 부과 수수료 누적액 |
| `fee_charges_repaid_derived` | DECIMAL(19, 6) | NOT NULL | 상환 수수료 누적액 |
| `fee_charges_waived_derived` | DECIMAL(19, 6) | NOT NULL | 감면 수수료 누적액 |
| `fee_charges_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | 상각 수수료 누적액 |
| `fee_charges_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | 수수료 잔액 |
| `penalty_charges_charged_derived` | DECIMAL(19, 6) | NOT NULL | 부과 연체료 누적액 |
| `penalty_charges_repaid_derived` | DECIMAL(19, 6) | NOT NULL | 상환 연체료 누적액 |
| `penalty_charges_waived_derived` | DECIMAL(19, 6) | NOT NULL | 감면 연체료 누적액 |
| `penalty_charges_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | 상각 연체료 누적액 |
| `penalty_charges_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | 연체료 잔액 |
| `total_expected_repayment_derived` | DECIMAL(19, 6) | NOT NULL | 총 상환 예정액 합계 |
| `total_repayment_derived` | DECIMAL(19, 6) | NOT NULL | 총 상환 완료액 합계 |
| `total_expected_costofloan_derived` | DECIMAL(19, 6) | NOT NULL | total_expected_costofloan 자동 집계/산출 필드 |
| `total_costofloan_derived` | DECIMAL(19, 6) | NOT NULL | total_costofloan 자동 집계/산출 필드 |
| `total_waived_derived` | DECIMAL(19, 6) | NOT NULL | total_waived 자동 집계/산출 필드 |
| `total_writtenoff_derived` | DECIMAL(19, 6) | NOT NULL | total_writtenoff 자동 집계/산출 필드 |
| `total_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | 총 미상환 잔액 합계 |
| `total_overpaid_derived` | DECIMAL(19, 6) | NULL | total_overpaid 자동 집계/산출 필드 |
| `rejectedon_date` | date | NULL | rejectedon_date 일자 |
| `rejectedon_userid` | BIGINT | NULL | rejectedon_userid 필드 |
| `rescheduledon_date` | date | NULL | rescheduledon_date 일자 |
| `rescheduledon_userid` | BIGINT | NULL | rescheduledon_userid 필드 |
| `withdrawnon_date` | date | NULL | withdrawnon_date 일자 |
| `withdrawnon_userid` | BIGINT | NULL | withdrawnon_userid 필드 |
| `writtenoffon_date` | date | NULL | writtenoffon_date 일자 |
| `loan_transaction_strategy_id` | BIGINT | NULL | loan_transaction_strategy 참조 식별자 (FK) |
| `sync_disbursement_with_meeting` | boolean | NULL | sync_disbursement_with_meeting 필드 |
| `loan_counter` | SMALLINT | NULL | loan_counter 필드 |
| `loan_product_counter` | SMALLINT | NULL | loan_product_counter 필드 |
| `fixed_emi_amount` | DECIMAL(19, 6) | NULL | fixed_emi_amount 금액 |
| `max_outstanding_loan_balance` | DECIMAL(19, 6) | NULL | max_outstanding_loan_balance 필드 |
| `grace_on_arrears_ageing` | SMALLINT | NULL | grace_on_arrears_ageing 필드 |
| `is_npa` | boolean | NOT NULL | npa 여부 플래그 (Boolean) |
| `total_recovered_derived` | DECIMAL(19, 6) | NULL | total_recovered 자동 집계/산출 필드 |
| `accrued_till` | date | NULL | accrued_till 필드 |
| `interest_recalcualated_on` | date | NULL | interest_recalcualated_on 필드 |
| `days_in_month_enum` | SMALLINT | NOT NULL | days_in_month 유형 구분 Enum 코드 |
| `days_in_year_enum` | SMALLINT | NOT NULL | days_in_year 유형 구분 Enum 코드 |
| `interest_recalculation_enabled` | boolean | NOT NULL | interest_recalculation_enabled 필드 |
| `guarantee_amount_derived` | DECIMAL(19, 6) | NULL | guarantee_amount 자동 집계/산출 필드 |
| `create_standing_instruction_at_disbursement` | boolean | NULL | create_standing_instruction_at_disbursement 필드 |
| `version` | INT | NOT NULL | 낙관적 락 버전 |
| `writeoff_reason_cv_id` | INT | NULL | writeoff_reason_cv 참조 식별자 (FK) |
| `loan_sub_status_id` | SMALLINT | NULL | loan_sub_status 참조 식별자 (FK) |
| `is_topup` | boolean | NOT NULL | topup 여부 플래그 (Boolean) |
| `is_equal_amortization` | boolean | NOT NULL | equal_amortization 여부 플래그 (Boolean) |
| `fixed_principal_percentage_per_installment` | DECIMAL(5, 2) | NULL | fixed_principal_percentage_per_installment 이자율/비율 |

### `m_loan_arrears_aging` - 대출 연체 일수 및 구간별 연체금액 에이징 분석 데이터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `loan_id` | BIGINT | PK, NOT NULL | loan 참조 식별자 (FK) |
| `principal_overdue_derived` | DECIMAL(19, 6) | NOT NULL | principal_overdue 자동 집계/산출 필드 |
| `interest_overdue_derived` | DECIMAL(19, 6) | NOT NULL | interest_overdue 자동 집계/산출 필드 |
| `fee_charges_overdue_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_overdue 자동 집계/산출 필드 |
| `penalty_charges_overdue_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_overdue 자동 집계/산출 필드 |
| `total_overdue_derived` | DECIMAL(19, 6) | NOT NULL | total_overdue 자동 집계/산출 필드 |
| `overdue_since_date_derived` | date | NULL | overdue_since_date 자동 집계/산출 필드 |

### `m_loan_repayment_schedule` - 회차별 대출 원리금 상환 일정표 (원금, 이자, 수수료, 연체료 잔액)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `credited_interest` | DECIMAL(19, 6) | NULL | credited_interest 필드 |
| `is_down_payment` | boolean | NOT NULL | down_payment 여부 플래그 (Boolean) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `is_additional` | boolean | NOT NULL | additional 여부 플래그 (Boolean) |
| `credits_amount` | DECIMAL(19, 6) | NULL | credits_amount 금액 |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `fromdate` | date | NULL | fromdate 필드 |
| `duedate` | date | NOT NULL | duedate 필드 |
| `installment` | SMALLINT | NOT NULL | installment 필드 |
| `principal_amount` | DECIMAL(19, 6) | NULL | 원금 / 대출 신청금액 |
| `principal_completed_derived` | DECIMAL(19, 6) | NULL | principal_completed 자동 집계/산출 필드 |
| `principal_writtenoff_derived` | DECIMAL(19, 6) | NULL | 원금 대손상각 누적액 |
| `interest_amount` | DECIMAL(19, 6) | NULL | interest_amount 금액 |
| `interest_completed_derived` | DECIMAL(19, 6) | NULL | interest_completed 자동 집계/산출 필드 |
| `interest_writtenoff_derived` | DECIMAL(19, 6) | NULL | 상각 이자 누적액 |
| `interest_waived_derived` | DECIMAL(19, 6) | NULL | 감면 이자 누적액 |
| `accrual_interest_derived` | DECIMAL(19, 6) | NULL | accrual_interest 자동 집계/산출 필드 |
| `reschedule_interest_portion` | decimal(19,6) | NULL | reschedule_interest_portion 필드 |
| `fee_charges_amount` | DECIMAL(19, 6) | NULL | fee_charges_amount 금액 |
| `fee_charges_completed_derived` | DECIMAL(19, 6) | NULL | fee_charges_completed 자동 집계/산출 필드 |
| `fee_charges_writtenoff_derived` | DECIMAL(19, 6) | NULL | 상각 수수료 누적액 |
| `fee_charges_waived_derived` | DECIMAL(19, 6) | NULL | 감면 수수료 누적액 |
| `accrual_fee_charges_derived` | DECIMAL(19, 6) | NULL | accrual_fee_charges 자동 집계/산출 필드 |
| `penalty_charges_amount` | DECIMAL(19, 6) | NULL | penalty_charges_amount 금액 |
| `penalty_charges_completed_derived` | DECIMAL(19, 6) | NULL | penalty_charges_completed 자동 집계/산출 필드 |
| `penalty_charges_writtenoff_derived` | DECIMAL(19, 6) | NULL | 상각 연체료 누적액 |
| `penalty_charges_waived_derived` | DECIMAL(19, 6) | NULL | 감면 연체료 누적액 |
| `accrual_penalty_charges_derived` | DECIMAL(19, 6) | NULL | accrual_penalty_charges 자동 집계/산출 필드 |
| `total_paid_in_advance_derived` | DECIMAL(19, 6) | NULL | total_paid_in_advance 자동 집계/산출 필드 |
| `total_paid_late_derived` | DECIMAL(19, 6) | NULL | total_paid_late 자동 집계/산출 필드 |
| `completed_derived` | boolean | NOT NULL | completed 자동 집계/산출 필드 |
| `obligations_met_on_date` | date | NULL | obligations_met_on_date 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `recalculated_interest_component` | boolean | NOT NULL | recalculated_interest_component 필드 |

## LNA-002 대출 신청 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_disbursement_detail` | 분할 대출 실행(Tranche) 예정 및 실제 지급 상세 |
| `m_loan_term_variations` | 대출 거치기간, 변동금리 적용 등 조건 변경 이력 |
| `m_loan_repayment_schedule_history` | 스케줄 재계산 전 백업된 과거 상환 일정표 이력 |
| `m_loan_approved_amount_history` | 대출 심사 승인금액 변경 이력 |
| `m_loan_topup` | 기존 대출 대환(Top-up) 추가 대출 연결 정보 |

### `m_loan_disbursement_detail` - 분할 대출 실행(Tranche) 예정 및 실제 지급 상세
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `expected_disburse_date` | datetime | NOT NULL | expected_disburse_date 일자 |
| `disbursedon_date` | datetime | NULL | 실제 실행일자 |
| `principal` | DECIMAL(19, 6) | NOT NULL | principal 필드 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NULL | 실지급액 (수수료/선취이자 공제 후) |

### `m_loan_term_variations` - 대출 거치기간, 변동금리 적용 등 조건 변경 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `created_on_date` | TIMESTAMP | NULL | created_on_date 일자 |
| `updated_by` | BIGINT | NULL | updated_by 필드 |
| `updated_on_date` | TIMESTAMP | NULL | updated_on_date 일자 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `term_type` | SMALLINT | NOT NULL | term_type 필드 |
| `applicable_date` | date | NOT NULL | applicable_date 일자 |
| `decimal_value` | DECIMAL(19, 6) | NULL | decimal_value 필드 |
| `date_value` | date | NULL | date_value 필드 |
| `is_specific_to_installment` | boolean | NOT NULL | specific_to_installment 여부 플래그 (Boolean) |
| `applied_on_loan_status` | SMALLINT | NOT NULL | applied_on_loan_status 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `parent_id` | BIGINT | NULL | parent 참조 식별자 (FK) |

### `m_loan_repayment_schedule_history` - 스케줄 재계산 전 백업된 과거 상환 일정표 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `loan_reschedule_request_id` | BIGINT | NULL | loan_reschedule_request 참조 식별자 (FK) |
| `fromdate` | date | NULL | fromdate 필드 |
| `duedate` | date | NOT NULL | duedate 필드 |
| `installment` | SMALLINT | NOT NULL | installment 필드 |
| `principal_amount` | DECIMAL(19, 6) | NULL | 원금 / 대출 신청금액 |
| `interest_amount` | DECIMAL(19, 6) | NULL | interest_amount 금액 |
| `fee_charges_amount` | DECIMAL(19, 6) | NULL | fee_charges_amount 금액 |
| `penalty_charges_amount` | DECIMAL(19, 6) | NULL | penalty_charges_amount 금액 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `version` | INT | NOT NULL | 낙관적 락 버전 |

### `m_loan_approved_amount_history` - 대출 심사 승인금액 변경 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `new_approved_amount` | DECIMAL(19, 6) | NOT NULL | new_approved_amount 금액 |
| `old_approved_amount` | DECIMAL(19, 6) | NOT NULL | old_approved_amount 금액 |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `created_on_utc` | DATETIME | NULL | 생성 일시 (UTC) |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `last_modified_on_utc` | DATETIME | NULL | 최종 수정 일시 (UTC) |

### `m_loan_topup` - 기존 대출 대환(Top-up) 추가 대출 연결 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `closure_loan_id` | BIGINT | NOT NULL | closure_loan 참조 식별자 (FK) |
| `account_transfer_details_id` | BIGINT | NULL | account_transfer_details 참조 식별자 (FK) |
| `topup_amount` | DECIMAL(19, 6) | NULL | topup_amount 금액 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0020_add_audit_entries.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0033_add_audit_entries_to_loan_repayment_schedule_installment.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0050_add_reverse_flag_disbursement_details.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0054_additional_fields_loan_repayment_schedule.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0057_add_principal_adjustments_to_loan.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0062_add_fraud_attribute_to_loan.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0064_refactor_loan_transaction_strategy.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0074_add_last_cob_business_date_column_to_loan.xml`
