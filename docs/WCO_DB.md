# [WCO] DB명세서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

## WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_delinquency_tag_history` | 운전자금 한도위반/연체 태그 부여 및 사후조치 이력 |

### `m_loan_delinquency_tag_history` - 운전자금 한도위반/연체 태그 부여 및 사후조치 이력
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `delinquency_range_id` | BIGINT | NOT NULL | delinquency_range 참조 식별자 (FK) |
| `loan_id` | BIGINT | NOT NULL | loan 참조 식별자 (FK) |
| `addedon_date` | DATE | NOT NULL | addedon_date 관련 일자 |
| `liftedon_date` | DATE | NULL | liftedon_date 관련 일자 |
| `created_by` | BIGINT | NOT NULL | created_by 필드 |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 생성 일시 (UTC) |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |
| `last_modified_by` | BIGINT | NOT NULL | last_modified_by 필드 |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NOT NULL | 최종 수정 일시 (UTC) |

## WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-provider/src/main/java/org/apache/fineract/cob/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_loan_account_locks` | 일마감(COB) 및 동시성 제어를 위한 계좌 잠금(Lock) 엔티티 |
| `m_batch_business_steps` | 마감 배치 단계별 비즈니스 스텝 구성 |

### `m_loan_account_locks` - 일마감(COB) 및 동시성 제어를 위한 계좌 잠금(Lock) 엔티티
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `loan_id` | BIGINT | PK, NOT NULL | loan 참조 식별자 (FK) |
| `lock_placed_on_cob_business_date` | DATE | NULL | lock_placed_on_cob_business_date 관련 일자 |
| `stacktrace` | VARCHAR(255) | NULL | stacktrace 필드 |
| `lock_placed_on` | timestamp | NOT NULL | lock_placed_on 필드 |
| `lock_owner` | VARCHAR(100) | NOT NULL | lock_owner 필드 |
| `error` | VARCHAR(255) | NULL | error 필드 |
| `version` | BIGINT | NOT NULL | 낙관적 락 버전 |

### `m_batch_business_steps` - 마감 배치 단계별 비즈니스 스텝 구성
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `job_name` | VARCHAR(100) | NOT NULL | 배치 작업명 |
| `step_name` | VARCHAR(100) | NOT NULL | step_name 필드 |
| `step_order` | SMALLINT | NOT NULL | step_order 필드 |

## 근거
- `fineract-provider/src/main/java/org/apache/fineract/cob/`
- `fineract-provider/src/main/java/org/apache/fineract/cob/domain/LoanAccountLock.java`
- `fineract-provider/src/main/java/org/apache/fineract/portfolio/delinquency/`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0022_add_batch_business_step_configuration_table.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0029_add_delinquency_buckets.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0039_add_loan_account_locks.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0048_rework_loan_account_locks.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0086_add_cob_business_date_to_loan_account_locks.xml`
