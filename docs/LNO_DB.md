# [LNO] DB명세서

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

## LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_collateral` | 대출 연계 부동산/동산 등 담보물 정보 |
| `m_loan_collateral_management` | 담보 관리 체계 매핑 |
| `m_guarantor` | 대출 연대보증인 인적사항 및 보증 유형(고객보증, 예금질권보증, 외부인보증) |
| `m_guarantor_funding_details` | 보증인의 예금 계좌를 질권 설정하여 담보한 상세 정보 |
| `m_guarantor_transaction` | 보증인 질권 해제 및 담보 충당 거래 내역 |

### `m_loan_collateral` - 대출 연계 부동산/동산 등 담보물 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `type_cv_id` | INT | NOT NULL | type_cv 참조 식별자 (FK) |
| `value` | DECIMAL(19, 6) | NULL | value 필드 |
| `description` | VARCHAR(500) | NULL | description 필드 |

### `m_loan_collateral_management` - 담보 관리 체계 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `quantity` | DECIMAL(20, 5) | NOT NULL | quantity 필드 |
| `loan_id` | BIGINT | NULL | loan 참조 식별자 (FK) |
| `client_collateral_id` | BIGINT | NULL | client_collateral 참조 식별자 (FK) |
| `is_released` | boolean | NULL | released 여부 플래그 (Boolean) |
| `transaction_id` | BIGINT | NULL | transaction 참조 식별자 (FK) |

### `m_guarantor` - 대출 연대보증인 인적사항 및 보증 유형(고객보증, 예금질권보증, 외부인보증)
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

### `m_guarantor_funding_details` - 보증인의 예금 계좌를 질권 설정하여 담보한 상세 정보
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

### `m_guarantor_transaction` - 보증인 질권 해제 및 담보 충당 거래 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `guarantor_fund_detail_id` | BIGINT | NOT NULL | guarantor_fund_detail 참조 식별자 (FK) |
| `loan_transaction_id` | BIGINT | NULL | loan_transaction 참조 식별자 (FK) |
| `deposit_on_hold_transaction_id` | BIGINT | NOT NULL | deposit_on_hold_transaction 참조 식별자 (FK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |

## LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_officer_assignment_history` | 대출 계좌의 담당 직원(Loan Officer) 변경 및 이관 이력 |
| `m_loan_charge` | 대출 계좌에 부과된 개별 수수료/비용 마스터 |
| `m_loan_installment_charge` | 회차별 분할 부과 수수료 매핑 |
| `m_loan_charge_paid_by` | 수수료를 납부한 대출 거래 매핑 |

### `m_loan_officer_assignment_history` - 대출 계좌의 담당 직원(Loan Officer) 변경 및 이관 이력
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

### `m_loan_charge` - 대출 계좌에 부과된 개별 수수료/비용 마스터
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

### `m_loan_installment_charge` - 회차별 분할 부과 수수료 매핑
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

### `m_loan_charge_paid_by` - 수수료를 납부한 대출 거래 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `loan_transaction_id` | BIGINT | NOT NULL | loan_transaction 참조 식별자 (FK) |
| `loan_charge_id` | BIGINT | NOT NULL | loan_charge 참조 식별자 (FK) |
| `amount` | DECIMAL(19, 6) | NOT NULL | amount 금액 |
| `installment_number` | SMALLINT | NULL | installment_number 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/Guarantor.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/GuarantorFundingDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/loanaccount/guarantor/domain/GuarantorFundingTransaction.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0008_loan_charge_add_external_id.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0055_add_submitted_on_date_to_loan_charge.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
