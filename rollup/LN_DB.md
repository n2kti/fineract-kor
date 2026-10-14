# [LN] DB명세서 (여신관리)

> 소분류 3개 롤업.


---

## [LNA] DB명세서

> 화면 2개 롤업(소분류 LNA, 대분류 LN - 대출 계좌 관리).

### LNA-001 대출 계좌 목록 및 상세

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan` | 대출 계좌 핵심 마스터 엔티티 (신청금액, 약정금리, 잔액, 상태 등 140개 컬럼) |
| `m_loan_arrears_aging` | 대출 연체 일수 및 구간별 연체금액 에이징 분석 데이터 |
| `m_loan_repayment_schedule` | 회차별 대출 원리금 상환 일정표 (원금, 이자, 수수료, 연체료 잔액) |

#### `m_loan` - 대출 계좌 핵심 마스터 엔티티 (신청금액, 약정금리, 잔액, 상태 등 140개 컬럼)
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

#### `m_loan_arrears_aging` - 대출 연체 일수 및 구간별 연체금액 에이징 분석 데이터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `loan_id` | BIGINT | PK, NOT NULL | loan 참조 식별자 (FK) |
| `principal_overdue_derived` | DECIMAL(19, 6) | NOT NULL | principal_overdue 자동 집계/산출 필드 |
| `interest_overdue_derived` | DECIMAL(19, 6) | NOT NULL | interest_overdue 자동 집계/산출 필드 |
| `fee_charges_overdue_derived` | DECIMAL(19, 6) | NOT NULL | fee_charges_overdue 자동 집계/산출 필드 |
| `penalty_charges_overdue_derived` | DECIMAL(19, 6) | NOT NULL | penalty_charges_overdue 자동 집계/산출 필드 |
| `total_overdue_derived` | DECIMAL(19, 6) | NOT NULL | total_overdue 자동 집계/산출 필드 |
| `overdue_since_date_derived` | date | NULL | overdue_since_date 자동 집계/산출 필드 |

#### `m_loan_repayment_schedule` - 회차별 대출 원리금 상환 일정표 (원금, 이자, 수수료, 연체료 잔액)
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

### LNA-002 대출 신청 및 실행

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_disbursement_detail` | 분할 대출 실행(Tranche) 예정 및 실제 지급 상세 |
| `m_loan_term_variations` | 대출 거치기간, 변동금리 적용 등 조건 변경 이력 |
| `m_loan_repayment_schedule_history` | 스케줄 재계산 전 백업된 과거 상환 일정표 이력 |
| `m_loan_approved_amount_history` | 대출 심사 승인금액 변경 이력 |
| `m_loan_topup` | 기존 대출 대환(Top-up) 추가 대출 연결 정보 |

#### `m_loan_disbursement_detail` - 분할 대출 실행(Tranche) 예정 및 실제 지급 상세
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `expected_disburse_date` | datetime | NOT NULL | expected_disburse_date 일자 |
| `disbursedon_date` | datetime | NULL | 실제 실행일자 |
| `principal` | DECIMAL(19, 6) | NOT NULL | principal 필드 |
| `net_disbursal_amount` | DECIMAL(19, 6) | NULL | 실지급액 (수수료/선취이자 공제 후) |

#### `m_loan_term_variations` - 대출 거치기간, 변동금리 적용 등 조건 변경 이력
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

#### `m_loan_repayment_schedule_history` - 스케줄 재계산 전 백업된 과거 상환 일정표 이력
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

#### `m_loan_approved_amount_history` - 대출 심사 승인금액 변경 이력
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

#### `m_loan_topup` - 기존 대출 대환(Top-up) 추가 대출 연결 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `closure_loan_id` | BIGINT | NOT NULL | closure_loan 참조 식별자 (FK) |
| `account_transfer_details_id` | BIGINT | NULL | account_transfer_details 참조 식별자 (FK) |
| `topup_amount` | DECIMAL(19, 6) | NULL | topup_amount 금액 |

### 근거
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

---

## [LNR] DB명세서

> 화면 2개 롤업(소분류 LNR, 대분류 LN - 대출 상환 및 재조정).

### LNR-001 대출 상환 및 거래 처리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_transaction` | 대출 원리금 상환, 실행, 감면, 대손상각 등 모든 금융 거래 원장 |
| `m_loan_transaction_repayment_schedule_mapping` | 특정 거래(상환)가 상환스케줄의 어느 회차 원금/이자에 충당(충당전략)되었는지 N:M 매핑 |
| `m_loan_transaction_relation` | 역분개/거래취소 시 원거래와 취소거래 간 2방향 연결 추적 |
| `m_loan_overdue_installment_charge` | 연체 발생 회차별 연체료 부과/계산 데이터 |

#### `m_loan_transaction` - 대출 원리금 상환, 실행, 감면, 대손상각 등 모든 금융 거래 원장
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

#### `m_loan_transaction_repayment_schedule_mapping` - 특정 거래(상환)가 상환스케줄의 어느 회차 원금/이자에 충당(충당전략)되었는지 N:M 매핑
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

#### `m_loan_transaction_relation` - 역분개/거래취소 시 원거래와 취소거래 간 2방향 연결 추적
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

#### `m_loan_overdue_installment_charge` - 연체 발생 회차별 연체료 부과/계산 데이터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_charge_id` | BIGINT | NOT NULL | loan_charge 참조 식별자 (FK) |
| `loan_schedule_id` | BIGINT | NOT NULL | loan_schedule 참조 식별자 (FK) |
| `frequency_number` | INT | NOT NULL | frequency_number 필드 |

### LNR-002 대출 상환일정 재조정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/rescheduleloan/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_reschedule_request` | 만기연장, 상환유예, 이자감면 등 대출 재조정(Reschedule) 신청 및 승인 정보 |
| `m_loan_reschedule_request_term_variations_mapping` | 재조정 신청 건과 변경 조건 파라미터 매핑 |
| `m_loan_reage_parameter` | 연체 대출 재정상화(Re-age) 파라미터 실행 정보 |

#### `m_loan_reschedule_request` - 만기연장, 상환유예, 이자감면 등 대출 재조정(Reschedule) 신청 및 승인 정보
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

#### `m_loan_reschedule_request_term_variations_mapping` - 재조정 신청 건과 변경 조건 파라미터 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_reschedule_request_id` | BIGINT | NOT NULL | loan_reschedule_request 참조 식별자 (FK) |
| `loan_term_variations_id` | BIGINT | NOT NULL | loan_term_variations 참조 식별자 (FK) |

#### `m_loan_reage_parameter` - 연체 대출 재정상화(Re-age) 파라미터 실행 정보
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

### 근거
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

---

## [LNO] DB명세서

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

### LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_collateral` | 대출 연계 부동산/동산 등 담보물 정보 |
| `m_loan_collateral_management` | 담보 관리 체계 매핑 |
| `m_guarantor` | 대출 연대보증인 인적사항 및 보증 유형(고객보증, 예금질권보증, 외부인보증) |
| `m_guarantor_funding_details` | 보증인의 예금 계좌를 질권 설정하여 담보한 상세 정보 |
| `m_guarantor_transaction` | 보증인 질권 해제 및 담보 충당 거래 내역 |

#### `m_loan_collateral` - 대출 연계 부동산/동산 등 담보물 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `type_cv_id` | INT | NOT NULL | type_cv 참조 식별자 (FK) |
| `value` | DECIMAL(19, 6) | NULL | value 필드 |
| `description` | VARCHAR(500) | NULL | description 필드 |

#### `m_loan_collateral_management` - 담보 관리 체계 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `quantity` | DECIMAL(20, 5) | NOT NULL | quantity 필드 |
| `loan_id` | BIGINT | NULL | loan 참조 식별자 (FK) |
| `client_collateral_id` | BIGINT | NULL | client_collateral 참조 식별자 (FK) |
| `is_released` | boolean | NULL | released 여부 플래그 (Boolean) |
| `transaction_id` | BIGINT | NULL | transaction 참조 식별자 (FK) |

#### `m_guarantor` - 대출 연대보증인 인적사항 및 보증 유형(고객보증, 예금질권보증, 외부인보증)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `client_reln_cv_id` | INT | NULL | client_reln_cv 참조 식별자 (FK) |
| `type_enum` | SMALLINT | NOT NULL | type 유형 구분 Enum 코드 |
| `entity_id` | BIGINT | NULL | entity 참조 식별자 (FK) |
| `firstname` | VARCHAR(50) | NULL | 이름 (First Name) |
| `lastname` | VARCHAR(50) | NULL | 성 (Last Name) |
| `dob` | date | NULL | dob 필드 |
| `address_line_1` | VARCHAR(500) | NULL | address_line_1 필드 |
| `address_line_2` | VARCHAR(500) | NULL | address_line_2 필드 |
| `city` | VARCHAR(50) | NULL | city 필드 |
| `state` | VARCHAR(50) | NULL | state 필드 |
| `country` | VARCHAR(50) | NULL | country 필드 |
| `zip` | VARCHAR(20) | NULL | zip 필드 |
| `house_phone_number` | VARCHAR(20) | NULL | house_phone_number 필드 |
| `mobile_number` | VARCHAR(20) | NULL | mobile_number 필드 |
| `comment` | VARCHAR(500) | NULL | comment 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `INDEX` | `FK_m_guarantor_m_loan` | NULL | INDEX 필드 |

#### `m_guarantor_funding_details` - 보증인의 예금 계좌를 질권 설정하여 담보한 상세 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `guarantor_id` | BIGINT | NOT NULL | guarantor 참조 식별자 (FK) |
| `account_associations_id` | BIGINT | NOT NULL | account_associations 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_released_derived` | DECIMAL(19, 6) | NULL | amount_released 자동 집계/산출 필드 |
| `amount_remaining_derived` | DECIMAL(19, 6) | NULL | amount_remaining 자동 집계/산출 필드 |
| `amount_transfered_derived` | DECIMAL(19, 6) | NULL | amount_transfered 자동 집계/산출 필드 |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |

#### `m_guarantor_transaction` - 보증인 질권 해제 및 담보 충당 거래 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `guarantor_fund_detail_id` | BIGINT | NOT NULL | guarantor_fund_detail 참조 식별자 (FK) |
| `loan_transaction_id` | BIGINT | NULL | loan_transaction 참조 식별자 (FK) |
| `deposit_on_hold_transaction_id` | BIGINT | NOT NULL | deposit_on_hold_transaction 참조 식별자 (FK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |

### LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_officer_assignment_history` | 대출 계좌의 담당 직원(Loan Officer) 변경 및 이관 이력 |
| `m_loan_charge` | 대출 계좌에 부과된 개별 수수료/비용 마스터 |
| `m_loan_installment_charge` | 회차별 분할 부과 수수료 매핑 |
| `m_loan_charge_paid_by` | 수수료를 납부한 대출 거래 매핑 |

#### `m_loan_officer_assignment_history` - 대출 계좌의 담당 직원(Loan Officer) 변경 및 이관 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `loan_officer_id` | BIGINT | NULL | 대출 담당자 ID |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |

#### `m_loan_charge` - 대출 계좌에 부과된 개별 수수료/비용 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `submitted_on_date` | date | NULL | submitted_on_date 일자 |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `charge_id` | BIGINT | NOT NULL | charge 참조 식별자 (FK) |
| `is_penalty` | boolean | NOT NULL | penalty 여부 플래그 (Boolean) |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `due_for_collection_as_of_date` | date | NULL | due_for_collection_as_of_date 일자 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `charge_payment_mode_enum` | SMALLINT | NOT NULL | charge_payment_mode 유형 구분 Enum 코드 |
| `calculation_percentage` | DECIMAL(19, 6) | NULL | calculation_percentage 이자율/비율 |
| `calculation_on_amount` | DECIMAL(19, 6) | NULL | calculation_on_amount 금액 |
| `charge_amount_or_percentage` | DECIMAL(19, 6) | NULL | charge_amount_or_percentage 금액 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_paid_derived` | DECIMAL(19, 6) | NULL | amount_paid 자동 집계/산출 필드 |
| `amount_waived_derived` | DECIMAL(19, 6) | NULL | amount_waived 자동 집계/산출 필드 |
| `amount_writtenoff_derived` | DECIMAL(19, 6) | NULL | amount_writtenoff 자동 집계/산출 필드 |
| `amount_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | amount_outstanding 자동 집계/산출 필드 |
| `is_paid_derived` | boolean | NOT NULL | is_paid 자동 집계/산출 필드 |
| `waived` | boolean | NOT NULL | waived 필드 |
| `min_cap` | DECIMAL(19, 6) | NULL | min_cap 필드 |
| `max_cap` | DECIMAL(19, 6) | NULL | max_cap 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |

#### `m_loan_installment_charge` - 회차별 분할 부과 수수료 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_charge_id` | BIGINT | NOT NULL | loan_charge 참조 식별자 (FK) |
| `loan_schedule_id` | BIGINT | NOT NULL | loan_schedule 참조 식별자 (FK) |
| `due_date` | date | NULL | due_date 일자 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_paid_derived` | DECIMAL(19, 6) | NULL | amount_paid 자동 집계/산출 필드 |
| `amount_waived_derived` | DECIMAL(19, 6) | NULL | amount_waived 자동 집계/산출 필드 |
| `amount_writtenoff_derived` | DECIMAL(19, 6) | NULL | amount_writtenoff 자동 집계/산출 필드 |
| `amount_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | amount_outstanding 자동 집계/산출 필드 |
| `is_paid_derived` | boolean | NOT NULL | is_paid 자동 집계/산출 필드 |
| `waived` | boolean | NOT NULL | waived 필드 |
| `amount_through_charge_payment` | DECIMAL(19, 6) | NULL | amount_through_charge_payment 금액 |

#### `m_loan_charge_paid_by` - 수수료를 납부한 대출 거래 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_transaction_id` | BIGINT | NOT NULL | loan_transaction 참조 식별자 (FK) |
| `loan_charge_id` | BIGINT | NOT NULL | loan_charge 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `installment_number` | SMALLINT | NULL | installment_number 필드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/Guarantor.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/GuarantorFundingDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/GuarantorFundingTransaction.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0008_loan_charge_add_external_id.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0055_add_submitted_on_date_to_loan_charge.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
