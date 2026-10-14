# [SCU] DB명세서

> 화면 3개 롤업(소분류 SCU, 대분류 SC - 사용자 및 권한 관리).

## SCU-001 사용자 계정 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_appuser` | 백오피스 시스템 사용자 계정, 비밀번호 해시, 이메일, 계정 잠금 상태 |
| `m_appuser_role` | 사용자와 역할(Role) 간 N:M 매핑 |
| `m_appuser_previous_password` | 과거 비밀번호 변경 이력 (동일 비밀번호 재사용 방지) |

### `m_appuser` - 백오피스 시스템 사용자 계정, 비밀번호 해시, 이메일, 계정 잠금 상태
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `password_reset_required` | boolean | NOT NULL | password_reset_required 필드 |
| `failed_login_attempts` | INT | NOT NULL | failed_login_attempts 필드 |
| `is_login_retries_enabled` | BOOLEAN | NOT NULL | login_retries_enabled 여부 플래그 (Boolean) |
| `temporary_password` | VARCHAR(255) | NULL | temporary_password 필드 |
| `temporary_password_expiry_time` | TIMESTAMP WITH TIME ZONE | NULL | temporary_password_expiry_time 필드 |
| `is_password_reset_enabled` | BOOLEAN | NOT NULL | password_reset_enabled 여부 플래그 (Boolean) |
| `is_deleted` | boolean | NOT NULL | deleted 여부 플래그 (Boolean) |
| `office_id` | BIGINT | NULL | 지점 식별자 (FK: m_office.id) |
| `staff_id` | BIGINT | NULL | 직원 식별자 (FK: m_staff.id) |
| `username` | VARCHAR(100) | NOT NULL | username 필드 |
| `firstname` | VARCHAR(100) | NOT NULL | firstname 필드 |
| `lastname` | VARCHAR(100) | NOT NULL | lastname 필드 |
| `password` | VARCHAR(255) | NOT NULL | password 필드 |
| `email` | VARCHAR(100) | NOT NULL | email 필드 |
| `firsttime_login_remaining` | boolean | NOT NULL | firsttime_login_remaining 필드 |
| `nonexpired` | boolean | NOT NULL | nonexpired 필드 |
| `nonlocked` | boolean | NOT NULL | nonlocked 필드 |
| `nonexpired_credentials` | boolean | NOT NULL | nonexpired_credentials 필드 |
| `enabled` | boolean | NOT NULL | enabled 필드 |
| `last_time_password_updated` | date | NOT NULL | last_time_password_updated 필드 |
| `password_never_expires` | boolean | NOT NULL | define if the password, should be check for validity period or not |
| `is_self_service_user` | boolean | NOT NULL | self_service_user 여부 플래그 (Boolean) |
| `cannot_change_password` | boolean | NULL | cannot_change_password 필드 |

### `m_appuser_role` - 사용자와 역할(Role) 간 N:M 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `appuser_id` | BIGINT | PK, NOT NULL | appuser 참조 식별자 (FK) |
| `role_id` | BIGINT | PK, NOT NULL | role 참조 식별자 (FK) |

### `m_appuser_previous_password` - 과거 비밀번호 변경 이력 (동일 비밀번호 재사용 방지)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `user_id` | BIGINT | NOT NULL | 사용자 식별자 (FK: m_appuser.id) |
| `password` | VARCHAR(255) | NOT NULL | password 필드 |
| `removal_date` | date | NOT NULL | removal_date 관련 일자 |

## SCU-002 역할 및 권한 설정

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_role` | 사용자 역할(Role) 마스터 |
| `m_role_permission` | 역할별 부여된 메뉴 및 기능 실행 권한 매핑 |
| `m_permission` | 시스템 전체 세부 권한 코드(Action Code) 및 Maker-Checker 적용 여부 |

### `m_role` - 사용자 역할(Role) 마스터
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `name` | VARCHAR(100) | NOT NULL | 명칭 / 이름 |
| `description` | VARCHAR(500) | NOT NULL | 상세 설명 |
| `is_disabled` | boolean | NOT NULL | disabled 여부 플래그 (Boolean) |

### `m_role_permission` - 역할별 부여된 메뉴 및 기능 실행 권한 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `role_id` | BIGINT | PK, NOT NULL | role 참조 식별자 (FK) |
| `permission_id` | BIGINT | PK, NOT NULL | permission 참조 식별자 (FK) |

### `m_permission` - 시스템 전체 세부 권한 코드(Action Code) 및 Maker-Checker 적용 여부
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `grouping` | VARCHAR(45) | NULL | grouping 필드 |
| `code` | VARCHAR(100) | NOT NULL | code 필드 |
| `entity_name` | VARCHAR(100) | NULL | entity_name 필드 |
| `action_name` | VARCHAR(100) | NULL | action_name 필드 |
| `can_maker_checker` | boolean | NOT NULL | can_maker_checker 필드 |

## SCU-003 보안 정책 및 2단계 인증

> 원본: `fineract-provider/src/main/java/org/apache/fineract/useradministration/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_password_validation_policy` | 비밀번호 복잡도, 최소길이, 만료주기 보안 정책 |
| `twofactor_access_token` | 2단계 인증(2FA/OTP) 액세스 토큰 |

### `m_password_validation_policy` - 비밀번호 복잡도, 최소길이, 만료주기 보안 정책
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `regex` | TEXT | NOT NULL | regex 필드 |
| `description` | TEXT | NOT NULL | 상세 설명 |
| `active` | boolean | NOT NULL | active 필드 |
| `key` | VARCHAR(255) | NOT NULL | key 필드 |

### `twofactor_access_token` - 2단계 인증(2FA/OTP) 액세스 토큰
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `token` | VARCHAR(32) | NOT NULL | token 필드 |
| `appuser_id` | BIGINT | NOT NULL | appuser 참조 식별자 (FK) |
| `valid_from` | datetime | NOT NULL | 유효 시작일자 |
| `valid_to` | datetime | NOT NULL | 유효 종료일자 |
| `enabled` | boolean | NOT NULL | enabled 필드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/domain/AppUserPreviousPassword.java`
- `fineract-provider/src/main/java/org/apache/fineract/useradministration/domain/PasswordValidationPolicy.java`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0212_add_force_password_reset_config.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0220_add_login_retry_configuration.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0230_add_forgot_password.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/upgrades/0000_upgrade_to_1.6.xml`
