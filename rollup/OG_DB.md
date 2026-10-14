# [OG] DB명세서 (조직관리)

> 소분류 2개 롤업.


---

## [OGB] DB명세서

> 화면 3개 롤업(소분류 OGB, 대분류 OG - 지점 및 직원 관리).

### OGB-001 지점(Office) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_office` | 본점/지점 계층 구조 트리 및 지점 기본 정보 (개설일자, 지점명, 외부ID) |

#### `m_office` - 본점/지점 계층 구조 트리 및 지점 기본 정보 (개설일자, 지점명, 외부ID)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `parent_id` | BIGINT | NULL | parent 참조 식별자 (FK) |
| `hierarchy` | VARCHAR(100) | NULL | hierarchy 필드 |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `opening_date` | date | NOT NULL | opening_date 관련 일자 |

### OGB-002 직원(Staff) 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/staff/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_staff` | 직원 인적사항, 소속 지점, 여신/수신 담당자(Loan Officer) 여부 및 재직상태 |
| `m_staff_assignment_history` | 고객/그룹에 대한 담당 직원 배정 및 변경 이력 |

#### `m_staff` - 직원 인적사항, 소속 지점, 여신/수신 담당자(Loan Officer) 여부 및 재직상태
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `is_loan_officer` | boolean | NOT NULL | loan_officer 여부 플래그 (Boolean) |
| `office_id` | BIGINT | NULL | 지점 식별자 (FK: m_office.id) |
| `firstname` | VARCHAR(50) | NULL | firstname 필드 |
| `lastname` | VARCHAR(50) | NULL | lastname 필드 |
| `display_name` | VARCHAR(102) | NOT NULL | display_name 필드 |
| `mobile_no` | VARCHAR(50) | NULL | mobile_no 필드 |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |
| `organisational_role_enum` | SMALLINT | NULL | organisational_role 유형 구분 Enum 코드 |
| `organisational_role_parent_staff_id` | BIGINT | NULL | organisational_role_parent_staff 참조 식별자 (FK) |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `joining_date` | date | NULL | joining_date 관련 일자 |
| `image_id` | BIGINT | NULL | image 참조 식별자 (FK) |
| `email_address` | VARCHAR(150) | NULL | email_address 필드 |

#### `m_staff_assignment_history` - 고객/그룹에 대한 담당 직원 배정 및 변경 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `centre_id` | BIGINT | NULL | centre 참조 식별자 (FK) |
| `staff_id` | BIGINT | NOT NULL | 직원 식별자 (FK: m_staff.id) |
| `start_date` | date | NOT NULL | start_date 관련 일자 |
| `end_date` | date | NULL | end_date 관련 일자 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |

### OGB-003 지점간 거래 및 포트폴리오 요약

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_office_transaction` | 본지점간 자금 이동 및 거래 내역 |

#### `m_office_transaction` - 본지점간 자금 이동 및 거래 내역
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `from_office_id` | BIGINT | NULL | from_office 참조 식별자 (FK) |
| `to_office_id` | BIGINT | NULL | to_office 참조 식별자 (FK) |
| `currency_code` | VARCHAR(3) | NOT NULL | 통화 코드 (ISO-4217) |
| `currency_digits` | INT | NOT NULL | currency_digits 필드 |
| `transaction_amount` | DECIMAL(19, 6) | NOT NULL | transaction_amount 필드 |
| `transaction_date` | date | NOT NULL | transaction_date 관련 일자 |
| `description` | VARCHAR(100) | NULL | 상세 설명 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/office/`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/office/domain/OfficeTransaction.java`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/staff/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`

---

## [OGC] DB명세서

> 화면 1개 롤업(소분류 OGC, 대분류 OG - 통화 및 조직 공통설정).

### OGC-001 통화·자금원·계좌체계

> 원본: `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`

#### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_organisation_currency` | 조직에서 취급 허용된 통화 목록 및 소수점 자리수 |
| `m_currency` | ISO-4217 표준 통화 코드 및 기호 마스터 |
| `m_fund` | 대출 자금원(Fund) 마스터 |
| `m_payment_type` | 결제 수단(현금, 계좌이체, 어음, 카드 등) 마스터 |
| `c_account_number_format` | 지점/상품별 고객번호 및 계좌번호 채번 포맷 규칙 |

#### `m_organisation_currency` - 조직에서 취급 허용된 통화 목록 및 소수점 자리수
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(3) | NOT NULL | code 필드 |
| `decimal_places` | SMALLINT | NOT NULL | decimal_places 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `display_symbol` | VARCHAR(10) | NULL | display_symbol 필드 |
| `internationalized_name_code` | VARCHAR(50) | NOT NULL | internationalized_name_code 필드 |

#### `m_currency` - ISO-4217 표준 통화 코드 및 기호 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `code` | VARCHAR(3) | NOT NULL | code 필드 |
| `decimal_places` | SMALLINT | NOT NULL | decimal_places 필드 |
| `currency_multiplesof` | SMALLINT | NULL | currency_multiplesof 필드 |
| `display_symbol` | VARCHAR(10) | NULL | display_symbol 필드 |
| `name` | VARCHAR(50) | NOT NULL | 명칭 / 이름 |
| `internationalized_name_code` | VARCHAR(50) | NOT NULL | internationalized_name_code 필드 |

#### `m_fund` - 대출 자금원(Fund) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(255) | NULL | 명칭 / 이름 |
| `external_id` | VARCHAR(100) | NULL | external 참조 식별자 (FK) |

#### `m_payment_type` - 결제 수단(현금, 계좌이체, 어음, 카드 등) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_name` | VARCHAR(100) | NULL | code_name 필드 |
| `is_system_defined` | boolean | NOT NULL | system_defined 여부 플래그 (Boolean) |
| `value` | VARCHAR(100) | NULL | value 필드 |
| `description` | VARCHAR(500) | NULL | 상세 설명 |
| `is_cash_payment` | boolean | NULL | cash_payment 여부 플래그 (Boolean) |
| `order_position` | INT | NOT NULL | order_position 필드 |

#### `c_account_number_format` - 지점/상품별 고객번호 및 계좌번호 채번 포맷 규칙
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `account_type_enum` | SMALLINT | NOT NULL | account_type 유형 구분 Enum 코드 |
| `prefix_type_enum` | SMALLINT | NULL | prefix_type 유형 구분 Enum 코드 |
| `prefix_character` | VARCHAR(50) | NULL | prefix_character 필드 |

### 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/organisation/monetary/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0052_loan_transaction_chargeback.xml`
