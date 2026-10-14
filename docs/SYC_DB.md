# [SYC] DB명세서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

## SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_code` | 시스템 공통 코드 그룹 마스터 |
| `m_code_value` | 코드 그룹에 속한 개별 코드값(Code Value) 및 표시 순서 |

### `m_code` - 시스템 공통 코드 그룹 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_name` | VARCHAR(100) | NULL | code_name 필드 |
| `is_system_defined` | boolean | NOT NULL | system_defined 여부 플래그 (Boolean) |

### `m_code_value` - 코드 그룹에 속한 개별 코드값(Code Value) 및 표시 순서
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `code_id` | INT | NOT NULL | code 참조 식별자 (FK) |
| `code_value` | VARCHAR(100) | NULL | code_value 필드 |
| `code_description` | VARCHAR(500) | NULL | code_description 필드 |
| `order_position` | INT | NOT NULL | order_position 필드 |
| `code_score` | INT | NULL | code_score 필드 |
| `is_active` | boolean | NOT NULL | 활성화 여부 (Boolean) |
| `is_mandatory` | boolean | NOT NULL | mandatory 여부 플래그 (Boolean) |

## SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `c_configuration` | 시스템 전역 환경 파라미터 (다중지점여부, 회계적용여부 등) |
| `c_external_service` | 외부 서비스 연동 설정 (S3, SMTP 등) |
| `m_business_date` | 지점별/시스템 현재 영업일자(Business Date) |
| `m_holiday` | 공휴일 마스터 |
| `m_working_days` | 영업일(월~금) 및 휴일 상환 처리 규칙 설정 |

### `c_configuration` - 시스템 전역 환경 파라미터 (다중지점여부, 회계적용여부 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |
| `value` | INT | NULL | value 필드 |
| `date_value` | date | NULL | date_value 필드 |
| `string_value` | VARCHAR(100) | NULL | string_value 필드 |
| `enabled` | boolean | NOT NULL | enabled 필드 |
| `is_trap_door` | boolean | NOT NULL | trap_door 여부 플래그 (Boolean) |
| `description` | VARCHAR(300) | NULL | 상세 설명 |

### `c_external_service` - 외부 서비스 연동 설정 (S3, SMTP 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NULL | 명칭 / 이름 |

### `m_business_date` - 지점별/시스템 현재 영업일자(Business Date)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `type` | VARCHAR(100) | NOT NULL | type 필드 |
| `date` | DATE | NOT NULL | date 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `created_date` | DATETIME  | NULL | 생성 일시 |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `lastmodified_date` | DATETIME | NULL | 최종 수정 일시 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |

### `m_holiday` - 공휴일 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `from_date` | datetime | NOT NULL | from_date 관련 일자 |
| `to_date` | datetime | NOT NULL | to_date 관련 일자 |
| `repayments_rescheduled_to` | datetime | NULL | repayments_rescheduled_to 필드 |
| `status_enum` | INT | NOT NULL | 상태 구분 Enum 코드 |
| `processed` | boolean | NOT NULL | processed 필드 |
| `description` | VARCHAR(100) | NULL | 상세 설명 |
| `rescheduling_type` | INT | NOT NULL | rescheduling_type 필드 |

### `m_working_days` - 영업일(월~금) 및 휴일 상환 처리 규칙 설정
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `repayment_rescheduling_enum` | SMALLINT | NULL | repayment_rescheduling 유형 구분 Enum 코드 |
| `extend_term_daily_repayments` | boolean | NULL | extend_term_daily_repayments 필드 |
| `extend_term_holiday_repayment` | boolean | NOT NULL | extend_term_holiday_repayment 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/codes/`
- `fineract-provider/src/main/java/org/apache/fineract/infrastructure/configuration/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0015_add_business_date.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0030_add_audit_entries_to_business_date.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
