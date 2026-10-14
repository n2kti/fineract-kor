# [TR] DB명세서 (이체창구)

> 소분류 2개 롤업.


---

## [TRA] DB명세서

> 화면 2개 롤업(소분류 TRA, 대분류 TR - 계좌이체 및 자동이체).

### TRA-001 계좌간 이체

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/AccountTransfersWritePlatformServiceImpl.java`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_account_transfer_details` | 출금계좌(From)와 입금계좌(To) 간 계좌이체 연계 마스터 |
| `m_account_transfer_transaction` | 계좌이체 실행 거래 내역 (출금거래 ID, 입금거래 ID 매핑) |

#### `m_account_transfer_details` - 출금계좌(From)와 입금계좌(To) 간 계좌이체 연계 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `from_office_id` | BIGINT | NOT NULL | from_office 참조 식별자 (FK) |
| `to_office_id` | BIGINT | NOT NULL | to_office 참조 식별자 (FK) |
| `from_client_id` | BIGINT | NULL | from_client 참조 식별자 (FK) |
| `to_client_id` | BIGINT | NULL | to_client 참조 식별자 (FK) |
| `from_savings_account_id` | BIGINT | NULL | from_savings_account 참조 식별자 (FK) |
| `to_savings_account_id` | BIGINT | NULL | to_savings_account 참조 식별자 (FK) |
| `from_loan_account_id` | BIGINT | NULL | from_loan_account 참조 식별자 (FK) |
| `to_loan_account_id` | BIGINT | NULL | to_loan_account 참조 식별자 (FK) |
| `transfer_type` | SMALLINT | NULL | transfer_type 필드 |

#### `m_account_transfer_transaction` - 계좌이체 실행 거래 내역 (출금거래 ID, 입금거래 ID 매핑)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_transfer_details_id` | BIGINT | NOT NULL | account_transfer_details 참조 식별자 (FK) |
| `from_savings_transaction_id` | BIGINT | NULL | from_savings_transaction 참조 식별자 (FK) |
| `from_loan_transaction_id` | BIGINT | NULL | from_loan_transaction 참조 식별자 (FK) |
| `to_savings_transaction_id` | BIGINT | NULL | to_savings_transaction 참조 식별자 (FK) |
| `to_loan_transaction_id` | BIGINT | NULL | to_loan_transaction 참조 식별자 (FK) |
| `is_reversed` | boolean | NOT NULL | reversed 여부 플래그 (Boolean) |
| `transaction_date` | date | NOT NULL | transaction_date 관련 일자 |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217) |
| `currency_digits` | SMALLINT | NOT NULL | currency_digits 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | 거래/설정 금액 |
| `description` | VARCHAR(200) | NOT NULL | 상세 설명 |

### TRA-002 자동이체(SI) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/StandingInstructionWritePlatformServiceImpl.java`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_account_transfer_standing_instructions` | 정기 자동이체 등록 마스터 (이체 주기, 이체 금액, 유효기간) |
| `m_account_transfer_standing_instructions_history` | 자동이체 배치 실행 이력 및 성공/실패 상태 |

#### `m_account_transfer_standing_instructions` - 정기 자동이체 등록 마스터 (이체 주기, 이체 금액, 유효기간)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(250) | NOT NULL | 명칭 / 이름 |
| `account_transfer_details_id` | BIGINT | NOT NULL | account_transfer_details 참조 식별자 (FK) |
| `priority` | TINYINT | NOT NULL | priority 필드 |
| `status` | TINYINT | NOT NULL | status 필드 |
| `instruction_type` | TINYINT | NOT NULL | instruction_type 필드 |
| `amount` | DECIMAL(19, 6) | NULL | 거래/설정 금액 |
| `valid_from` | date | NOT NULL | 유효 시작일자 |
| `valid_till` | date | NULL | valid_till 필드 |
| `recurrence_type` | TINYINT | NOT NULL | recurrence_type 필드 |
| `recurrence_frequency` | SMALLINT | NULL | recurrence_frequency 필드 |
| `recurrence_interval` | SMALLINT | NULL | recurrence_interval 필드 |
| `recurrence_on_day` | SMALLINT | NULL | recurrence_on_day 필드 |
| `recurrence_on_month` | SMALLINT | NULL | recurrence_on_month 필드 |
| `last_run_date` | date | NULL | last_run_date 관련 일자 |

#### `m_account_transfer_standing_instructions_history` - 자동이체 배치 실행 이력 및 성공/실패 상태
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `standing_instruction_id` | BIGINT | NOT NULL | standing_instruction 참조 식별자 (FK) |
| `status` | VARCHAR(20) | NOT NULL | status 필드 |
| `execution_time` | datetime | NOT NULL | execution_time 필드 |
| `amount` | DECIMAL(19, 6) | NOT NULL | 거래/설정 금액 |
| `error_log` | VARCHAR(500) | NULL | error_log 필드 |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/domain/AccountTransferDetails.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/domain/AccountTransferTransaction.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/AccountTransfersWritePlatformServiceImpl.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/account/service/StandingInstructionWritePlatformServiceImpl.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`

---

## [TRT] DB명세서

> 화면 1개 롤업(소분류 TRT, 대분류 TR - 창구 및 출납원 운영).

### TRT-001 창구 및 출납원 운영

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_tellers` | 지점 창구(Teller / 금고) 기본 마스터 (소속 지점, 상태, 유효기간) |
| `m_cashiers` | 창구에 배정된 출납원(Cashier) 및 배정 기간 |
| `m_cashier_transactions` | 출납원 시재 할당(Allocate), 정산 회수(Settle), 입출금 거래 원장 |

#### `m_tellers` - 지점 창구(Teller / 금고) 기본 마스터 (소속 지점, 상태, 유효기간)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `office_id` | BIGINT | NOT NULL | 지점 식별자 (FK: m_office.id) |
| `debit_account_id` | BIGINT | NULL | debit_account 참조 식별자 (FK) |
| `credit_account_id` | BIGINT | NULL | credit_account 참조 식별자 (FK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `description` | VARCHAR(100) | NULL | 상세 설명 |
| `valid_from` | date | NULL | 유효 시작일자 |
| `valid_to` | date | NULL | 유효 종료일자 |
| `state` | SMALLINT | NULL | state 필드 |

#### `m_cashiers` - 창구에 배정된 출납원(Cashier) 및 배정 기간
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `staff_id` | BIGINT | NULL | 직원 식별자 (FK: m_staff.id) |
| `teller_id` | BIGINT | NULL | teller 참조 식별자 (FK) |
| `description` | VARCHAR(100) | NULL | 상세 설명 |
| `start_date` | date | NULL | start_date 관련 일자 |
| `end_date` | date | NULL | end_date 관련 일자 |
| `start_time` | VARCHAR(10) | NULL | start_time 필드 |
| `end_time` | VARCHAR(10) | NULL | end_time 필드 |
| `full_day` | boolean | NULL | full_day 필드 |

#### `m_cashier_transactions` - 출납원 시재 할당(Allocate), 정산 회수(Settle), 입출금 거래 원장
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `cashier_id` | BIGINT | NOT NULL | cashier 참조 식별자 (FK) |
| `txn_type` | SMALLINT | NOT NULL | txn_type 필드 |
| `txn_amount` | DECIMAL(19, 6) | NOT NULL | txn_amount 필드 |
| `txn_date` | date | NOT NULL | txn_date 관련 일자 |
| `created_date` | datetime | NOT NULL | 생성 일시 |
| `entity_type` | VARCHAR(50) | NULL | entity_type 필드 |
| `entity_id` | BIGINT | NULL | entity 참조 식별자 (FK) |
| `txn_note` | VARCHAR(200) | NULL | txn_note 필드 |
| `currency_code` | VARCHAR(3) | NULL | 통화 코드 (ISO-4217) |

### 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
