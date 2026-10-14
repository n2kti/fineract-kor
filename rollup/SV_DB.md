# [SV] DB명세서 (수신관리)

> 소분류 4개 롤업.


---

## [SVA] DB명세서

> 화면 2개 롤업(소분류 SVA, 대분류 SV - 보통예금 계좌).

### SVA-001 보통예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_savings_account` | 보통/정기/적금 예금 계좌 핵심 마스터 엔티티 (잔액, 이자계산방식, 상태 등 70개 컬럼) |
| `m_savings_account_transaction` | 예금 입금, 출금, 이자지급, 수수료징수 등 모든 수신 거래 원장 |
| `m_deposit_account_on_hold_transaction` | 예금 지급보류(Hold) 및 질권 설정 거래 내역 |

#### `m_savings_account` - 보통/정기/적금 예금 계좌 핵심 마스터 엔티티 (잔액, 이자계산방식, 상태 등 70개 컬럼)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `reason_for_block` | VARCHAR(256) | NULL | reason_for_block 필드 |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `max_allowed_lien_limit` | DECIMAL(19, 6) | NULL | max_allowed_lien_limit 필드 |
| `is_lien_allowed` | boolean | NOT NULL | lien_allowed 여부 플래그 (Boolean) |
| `account_no` | VARCHAR(20) | NOT NULL | 계좌 번호 |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `client_id` | BIGINT | NULL | 고객 ID (FK: m_client.id) |
| `group_id` | BIGINT | NULL | 그룹 ID (FK: m_group.id) |
| `gsim_id` | BIGINT | NULL | gsim 참조 식별자 (FK) |
| `product_id` | BIGINT | NULL | 상품 ID (FK) |
| `field_officer_id` | BIGINT | NULL | field_officer 참조 식별자 (FK) |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `sub_status_enum` | SMALLINT | NOT NULL | sub_status 유형 구분 Enum 코드 |
| `account_type_enum` | SMALLINT | NOT NULL | account_type 유형 구분 Enum 코드 |
| `deposit_type_enum` | SMALLINT | NOT NULL | deposit_type 유형 구분 Enum 코드 |
| `submittedon_date` | date | NOT NULL | 접수일자 |
| `submittedon_userid` | BIGINT | NULL | 접수자 ID |
| `approvedon_date` | date | NULL | 승인일자 |
| `approvedon_userid` | BIGINT | NULL | 승인자 ID |
| `rejectedon_date` | date | NULL | rejectedon_date 일자 |
| `rejectedon_userid` | BIGINT | NULL | rejectedon_userid 필드 |
| `withdrawnon_date` | date | NULL | withdrawnon_date 일자 |
| `withdrawnon_userid` | BIGINT | NULL | withdrawnon_userid 필드 |
| `activatedon_date` | date | NULL | activatedon_date 일자 |
| `activatedon_userid` | BIGINT | NULL | 활성화 승인자 ID |
| `closedon_date` | date | NULL | 계좌 종결일자 |
| `closedon_userid` | BIGINT | NULL | 종결자 ID |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `nominal_annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | nominal_annual_interest_rate 이자율/비율 |
| `interest_compounding_period_enum` | SMALLINT | NOT NULL | interest_compounding_period 유형 구분 Enum 코드 |
| `interest_posting_period_enum` | SMALLINT | NOT NULL | interest_posting_period 유형 구분 Enum 코드 |
| `interest_calculation_type_enum` | SMALLINT | NOT NULL | interest_calculation_type 유형 구분 Enum 코드 |
| `interest_calculation_days_in_year_type_enum` | SMALLINT | NOT NULL | interest_calculation_days_in_year_type 유형 구분 Enum 코드 |
| `min_required_opening_balance` | DECIMAL(19, 6) | NULL | min_required_opening_balance 필드 |
| `lockin_period_frequency` | DECIMAL(19, 6) | NULL | lockin_period_frequency 필드 |
| `lockin_period_frequency_enum` | SMALLINT | NULL | lockin_period_frequency 유형 구분 Enum 코드 |
| `withdrawal_fee_for_transfer` | boolean | NULL | withdrawal_fee_for_transfer 필드 |
| `allow_overdraft` | boolean | NOT NULL | allow_overdraft 필드 |
| `overdraft_limit` | DECIMAL(19, 6) | NULL | overdraft_limit 필드 |
| `nominal_annual_interest_rate_overdraft` | DECIMAL(19, 6) | NULL | nominal_annual_interest_rate_overdraft 이자율/비율 |
| `min_overdraft_for_interest_calculation` | DECIMAL(19, 6) | NULL | min_overdraft_for_interest_calculation 필드 |
| `lockedin_until_date_derived` | date | NULL | lockedin_until_date 자동 집계/산출 필드 |
| `total_deposits_derived` | DECIMAL(19, 6) | NULL | total_deposits 자동 집계/산출 필드 |
| `total_withdrawals_derived` | DECIMAL(19, 6) | NULL | total_withdrawals 자동 집계/산출 필드 |
| `total_withdrawal_fees_derived` | DECIMAL(19, 6) | NULL | total_withdrawal_fees 자동 집계/산출 필드 |
| `total_fees_charge_derived` | DECIMAL(19, 6) | NULL | total_fees_charge 자동 집계/산출 필드 |
| `total_penalty_charge_derived` | DECIMAL(19, 6) | NULL | total_penalty_charge 자동 집계/산출 필드 |
| `total_annual_fees_derived` | DECIMAL(19, 6) | NULL | total_annual_fees 자동 집계/산출 필드 |
| `total_interest_earned_derived` | DECIMAL(19, 6) | NULL | total_interest_earned 자동 집계/산출 필드 |
| `total_interest_posted_derived` | DECIMAL(19, 6) | NULL | total_interest_posted 자동 집계/산출 필드 |
| `total_overdraft_interest_derived` | DECIMAL(19, 6) | NULL | total_overdraft_interest 자동 집계/산출 필드 |
| `total_withhold_tax_derived` | DECIMAL(19, 6) | NULL | total_withhold_tax 자동 집계/산출 필드 |
| `account_balance_derived` | DECIMAL(19, 6) | NOT NULL | account_balance 자동 집계/산출 필드 |
| `min_required_balance` | DECIMAL(19, 6) | NULL | min_required_balance 필드 |
| `enforce_min_required_balance` | boolean | NOT NULL | enforce_min_required_balance 필드 |
| `min_balance_for_interest_calculation` | DECIMAL(19, 6) | NULL | min_balance_for_interest_calculation 필드 |
| `start_interest_calculation_date` | date | NULL | start_interest_calculation_date 일자 |
| `on_hold_funds_derived` | DECIMAL(19, 6) | NULL | on_hold_funds 자동 집계/산출 필드 |
| `version` | INT | NOT NULL | 낙관적 락 버전 |
| `withhold_tax` | boolean | NOT NULL | withhold_tax 필드 |
| `tax_group_id` | BIGINT | NULL | tax_group 참조 식별자 (FK) |
| `last_interest_calculation_date` | date | NULL | last_interest_calculation_date 일자 |
| `total_savings_amount_on_hold` | DECIMAL(19, 6) | NULL | total_savings_amount_on_hold 금액 |
| `interest_posted_till_date` | date | NULL | interest_posted_till_date 일자 |
| `activation_date` | DATE | NULL | 활성화 일자 |
| `nominal_interest_rate_per_period` | decimal(19 | NULL | 약정 이자율 |
| `nominal_interest_rate_period_frequency_enum` | SMALLINT | NOT NULL | nominal_interest_rate_period_frequency 유형 구분 Enum 코드 |
| `annual_nominal_interest_rate` | decimal(19 | NULL | 연환산 명목 이자율 |
| `interest_period_enum` | SMALLINT | NOT NULL | interest_period 유형 구분 Enum 코드 |

#### `m_savings_account_transaction` - 예금 입금, 출금, 이자지급, 수수료징수 등 모든 수신 거래 원장
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `reason_for_block` | VARCHAR(256) | NULL | reason_for_block 필드 |
| `original_transaction_id` | BIGINT | NULL | original_transaction 참조 식별자 (FK) |
| `is_reversal` | BOOLEAN | NOT NULL | reversal 여부 플래그 (Boolean) |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `is_lien_transaction` | boolean | NOT NULL | lien_transaction 여부 플래그 (Boolean) |
| `submitted_on_date` | DATE | NOT NULL | submitted_on_date 일자 |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `payment_detail_id` | BIGINT | NULL | payment_detail 참조 식별자 (FK) |
| `transaction_type_enum` | SMALLINT | NOT NULL | transaction_type 유형 구분 Enum 코드 |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `transaction_date` | date | NOT NULL | transaction_date 일자 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `overdraft_amount_derived` | DECIMAL(19, 6) | NULL | overdraft_amount 자동 집계/산출 필드 |
| `balance_end_date_derived` | date | NULL | balance_end_date 자동 집계/산출 필드 |
| `balance_number_of_days_derived` | INT | NULL | balance_number_of_days 자동 집계/산출 필드 |
| `running_balance_derived` | DECIMAL(19, 6) | NULL | running_balance 자동 집계/산출 필드 |
| `cumulative_balance_derived` | DECIMAL(19, 6) | NULL | cumulative_balance 자동 집계/산출 필드 |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `appuser_id` | BIGINT | NULL | appuser 참조 식별자 (FK) |
| `is_manual` | boolean | NULL | manual 여부 플래그 (Boolean) |
| `release_id_of_hold_amount` | BIGINT | NULL | release_id_of_hold_amount 금액 |
| `is_loan_disbursement` | boolean | NULL | loan_disbursement 여부 플래그 (Boolean) |
| `ref_no` | VARCHAR(128) | NULL | ref_no 필드 |

#### `m_deposit_account_on_hold_transaction` - 예금 지급보류(Hold) 및 질권 설정 거래 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `transaction_type_enum` | SMALLINT | NOT NULL | transaction_type 유형 구분 Enum 코드 |
| `transaction_date` | date | NOT NULL | transaction_date 일자 |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `created_date` | datetime | NOT NULL | 생성 일시 |

### SVA-002 예금 수수료 및 거래 이력

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_savings_account_charge` | 예금 계좌에 부과된 수수료/관리비 마스터 |
| `m_savings_account_charge_paid_by` | 수수료 납부 거래 매핑 |
| `m_savings_officer_assignment_history` | 예금 계좌 담당 직원 배정 이력 |
| `m_savings_account_transaction_tax_details` | 예금 이자소득세 등 원천징수 세금 상세 내역 |

#### `m_savings_account_charge` - 예금 계좌에 부과된 수수료/관리비 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_by` | BIGINT | NULL | created_by 필드 |
| `last_modified_by` | BIGINT | NULL | last_modified_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `charge_id` | BIGINT | NOT NULL | charge 참조 식별자 (FK) |
| `is_penalty` | boolean | NOT NULL | penalty 여부 플래그 (Boolean) |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
| `charge_due_date` | date | NULL | charge_due_date 일자 |
| `fee_on_month` | SMALLINT | NULL | fee_on_month 필드 |
| `fee_on_day` | SMALLINT | NULL | fee_on_day 필드 |
| `fee_interval` | SMALLINT | NULL | fee_interval 필드 |
| `free_withdrawal_count` | INT | NULL | free_withdrawal_count 필드 |
| `charge_reset_date` | date | NULL | charge_reset_date 일자 |
| `charge_calculation_enum` | SMALLINT | NOT NULL | charge_calculation 유형 구분 Enum 코드 |
| `calculation_percentage` | DECIMAL(19, 6) | NULL | calculation_percentage 이자율/비율 |
| `calculation_on_amount` | DECIMAL(19, 6) | NULL | calculation_on_amount 금액 |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `amount_paid_derived` | DECIMAL(19, 6) | NULL | amount_paid 자동 집계/산출 필드 |
| `amount_waived_derived` | DECIMAL(19, 6) | NULL | amount_waived 자동 집계/산출 필드 |
| `amount_writtenoff_derived` | DECIMAL(19, 6) | NULL | amount_writtenoff 자동 집계/산출 필드 |
| `amount_outstanding_derived` | DECIMAL(19, 6) | NOT NULL | amount_outstanding 자동 집계/산출 필드 |
| `is_paid_derived` | boolean | NOT NULL | is_paid 자동 집계/산출 필드 |
| `waived` | boolean | NOT NULL | waived 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |
| `inactivated_on_date` | date | NULL | inactivated_on_date 일자 |

#### `m_savings_account_charge_paid_by` - 수수료 납부 거래 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_transaction_id` | BIGINT | NOT NULL | savings_account_transaction 참조 식별자 (FK) |
| `savings_account_charge_id` | BIGINT | NOT NULL | savings_account_charge 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |

#### `m_savings_officer_assignment_history` - 예금 계좌 담당 직원 배정 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `savings_officer_id` | BIGINT | NULL | savings_officer 참조 식별자 (FK) |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |

#### `m_savings_account_transaction_tax_details` - 예금 이자소득세 등 원천징수 세금 상세 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_transaction_id` | BIGINT | NOT NULL | savings_transaction 참조 식별자 (FK) |
| `tax_component_id` | BIGINT | NOT NULL | tax_component 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0005_savings_transaction_reversal.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0009_hold_reason_savings_account.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0010_lien_allowed_on_savings_account_products.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0118_add_submitted_on_date_to_savings_transaction.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0128_savings_audit.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`

---

## [SVF] DB명세서

> 화면 1개 롤업(소분류 SVF, 대분류 SV - 정기예금 계좌).

### SVF-001 정기예금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_deposit_account_term_and_preclosure` | 정기예금 약정기간, 만기일자, 만기시 처리방법(자동연장, 원리금입금) 및 중도해지 페널티 약관 |
| `m_savings_account_interest_rate_chart` | 계좌별 약정 금리 차트 |
| `m_savings_account_interest_rate_slab` | 예치 기간/금액 구간별 적용 금리 슬랩 |

#### `m_deposit_account_term_and_preclosure` - 정기예금 약정기간, 만기일자, 만기시 처리방법(자동연장, 원리금입금) 및 중도해지 페널티 약관
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

#### `m_savings_account_interest_rate_chart` - 계좌별 약정 금리 차트
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `from_date` | date | NOT NULL | from_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `is_primary_grouping_by_amount` | boolean | NOT NULL | primary_grouping_by_amount 여부 플래그 (Boolean) |

#### `m_savings_account_interest_rate_slab` - 예치 기간/금액 구간별 적용 금리 슬랩
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `savings_account_interest_rate_chart_id` | BIGINT | NOT NULL | savings_account_interest_rate_chart 참조 식별자 (FK) |
| `description` | VARCHAR(200) | NULL | description 필드 |
| `period_type_enum` | SMALLINT | NULL | period_type 유형 구분 Enum 코드 |
| `from_period` | INT | NULL | from_period 필드 |
| `to_period` | INT | NULL | to_period 필드 |
| `amount_range_from` | DECIMAL(19, 6) | NULL | amount_range_from 금액 |
| `amount_range_to` | DECIMAL(19, 6) | NULL | amount_range_to 금액 |
| `annual_interest_rate` | DECIMAL(19, 6) | NOT NULL | annual_interest_rate 이자율/비율 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |

### 근거
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`

---

## [SVR] DB명세서

> 화면 1개 롤업(소분류 SVR, 대분류 SV - 정기적금 계좌).

### SVR-001 정기적금 계좌 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_deposit_account_recurring_detail` | 정기적금 월 불입 약정금액, 불입주기, 자동이체 연결 정보 |
| `m_deposit_account_term_and_preclosure` | 적금 만기 약정 및 중도해지 조건 |
| `m_mandatory_savings_schedule` | 회차별 적금 의무 불입 일정표 및 입금 실적 |

#### `m_deposit_account_recurring_detail` - 정기적금 월 불입 약정금액, 불입주기, 자동이체 연결 정보
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

#### `m_deposit_account_term_and_preclosure` - 적금 만기 약정 및 중도해지 조건
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

#### `m_mandatory_savings_schedule` - 회차별 적금 의무 불입 일정표 및 입금 실적
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

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/domain/DepositAccountRecurringDetail.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/savings/domain/RecurringDepositScheduleInstallment.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0128_savings_audit.xml`

---

## [SVS] DB명세서

> 화면 1개 롤업(소분류 SVS, 대분류 SV - 주식 계좌).

### SVS-001 주식 계좌 및 배당 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_share_account` | 조합원 주식(출자금) 계좌 마스터 (보유 주식수, 취득단가, 승인상태) |
| `m_share_account_transactions` | 주식 청약(매수), 환급(매도), 유상증자 거래 원장 |
| `m_share_account_charge` | 주식 거래 관련 수수료 마스터 |
| `m_share_account_dividend_details` | 결산 배당금 배정 및 지급 내역 |

#### `m_share_account` - 조합원 주식(출자금) 계좌 마스터 (보유 주식수, 취득단가, 승인상태)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_no` | VARCHAR(50) | NOT NULL | 계좌 번호 |
| `product_id` | BIGINT | NOT NULL | 상품 ID (FK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `total_approved_shares` | BIGINT | NULL | total_approved_shares 필드 |
| `total_pending_shares` | BIGINT | NULL | total_pending_shares 필드 |
| `submitted_date` | date | NOT NULL | submitted_date 일자 |
| `submitted_userid` | BIGINT | NULL | submitted_userid 필드 |
| `approved_date` | date | NULL | approved_date 일자 |
| `approved_userid` | BIGINT | NULL | approved_userid 필드 |
| `rejected_date` | date | NULL | rejected_date 일자 |
| `rejected_userid` | BIGINT | NULL | rejected_userid 필드 |
| `activated_date` | date | NULL | activated_date 일자 |
| `activated_userid` | BIGINT | NULL | activated_userid 필드 |
| `closed_date` | date | NULL | closed_date 일자 |
| `closed_userid` | BIGINT | NULL | closed_userid 필드 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217, 예: KRW, USD) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `savings_account_id` | BIGINT | NOT NULL | savings_account 참조 식별자 (FK) |
| `minimum_active_period_frequency` | DECIMAL(19, 6) | NULL | minimum_active_period_frequency 필드 |
| `minimum_active_period_frequency_enum` | SMALLINT | NULL | minimum_active_period_frequency 유형 구분 Enum 코드 |
| `lockin_period_frequency` | DECIMAL(19, 6) | NULL | lockin_period_frequency 필드 |
| `lockin_period_frequency_enum` | SMALLINT | NULL | lockin_period_frequency 유형 구분 Enum 코드 |
| `allow_dividends_inactive_clients` | boolean | NULL | allow_dividends_inactive_clients 필드 |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |

#### `m_share_account_transactions` - 주식 청약(매수), 환급(매도), 유상증자 거래 원장
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `transaction_date` | date | NULL | transaction_date 일자 |
| `total_shares` | BIGINT | NULL | total_shares 필드 |
| `unit_price` | DECIMAL(10, 2) | NULL | unit_price 필드 |
| `amount` | DECIMAL(20, 2) | NULL | amount 금액 |
| `charge_amount` | DECIMAL(20, 2) | NULL | charge_amount 금액 |
| `amount_paid` | DECIMAL(20, 2) | NULL | amount_paid 금액 |
| `status_enum` | SMALLINT | NOT NULL | 상태 코드 Enum |
| `type_enum` | SMALLINT | NULL | type 유형 구분 Enum 코드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 |

#### `m_share_account_charge` - 주식 거래 관련 수수료 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `charge_id` | BIGINT | NOT NULL | charge 참조 식별자 (FK) |
| `charge_time_enum` | SMALLINT | NOT NULL | charge_time 유형 구분 Enum 코드 |
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

#### `m_share_account_dividend_details` - 결산 배당금 배정 및 지급 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `dividend_pay_out_id` | BIGINT | NOT NULL | dividend_pay_out 참조 식별자 (FK) |
| `account_id` | BIGINT | NOT NULL | account 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `status` | SMALLINT | NOT NULL | status 필드 |
| `savings_transaction_id` | BIGINT | NULL | savings_transaction 참조 식별자 (FK) |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccount.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountCharge.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountDividendDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/shareaccounts/domain/ShareAccountTransaction.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
