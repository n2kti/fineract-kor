# [TRT] DB명세서

> 화면 1개 롤업(소분류 TRT, 대분류 TR - 창구 및 출납원 운영).

## TRT-001 창구 및 출납원 운영

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_tellers` | 지점 창구(Teller / 금고) 기본 마스터 (소속 지점, 상태, 유효기간) |
| `m_cashiers` | 창구에 배정된 출납원(Cashier) 및 배정 기간 |
| `m_cashier_transactions` | 출납원 시재 할당(Allocate), 정산 회수(Settle), 입출금 거래 원장 |

### `m_tellers` - 지점 창구(Teller / 금고) 기본 마스터 (소속 지점, 상태, 유효기간)
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

### `m_cashiers` - 창구에 배정된 출납원(Cashier) 및 배정 기간
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

### `m_cashier_transactions` - 출납원 시재 할당(Allocate), 정산 회수(Settle), 입출금 거래 원장
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

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/organisation/teller/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
