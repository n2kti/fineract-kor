# [CLG] DB명세서

> 화면 1개 롤업(소분류 CLG, 대분류 CL - 그룹 및 센터 관리).

## CLG-001 그룹 및 센터 관리

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/group/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_group` | 소액금융 그룹(Group) 및 상위 센터(Center) 기본 정보 |
| `m_group_client` | 그룹과 소속 고객(구성원) 간 N:M 매핑 |
| `m_group_roles` | 그룹 내 직책(그룹장, 총무 등) 지정 정보 |
| `m_group_level` | 조직/그룹 계층 레벨 정의 |
| `m_meeting` | 그룹/센터의 정기 모임(Center Meeting) 실행 기록 |
| `m_calendar` | 정기 모임 일정 캘린더 정의(반복주기, 요일) |
| `m_calendar_instance` | 특정 그룹/센터 엔티티에 연계된 캘린더 인스턴스 |

### `m_group` - 소액금융 그룹(Group) 및 상위 센터(Center) 기본 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `external_id` | VARCHAR(100) | NULL | 외부 식별자 (UUID 등) |
| `status_enum` | INT | NOT NULL | 상태 코드 Enum |
| `activation_date` | date | NULL | 활성화 일자 |
| `office_id` | BIGINT | NOT NULL | 지점 ID (FK: m_office.id) |
| `staff_id` | BIGINT | NULL | 담당 직원 ID (FK: m_staff.id) |
| `parent_id` | BIGINT | NULL | parent 참조 식별자 (FK) |
| `level_id` | INT | NOT NULL | level 참조 식별자 (FK) |
| `display_name` | VARCHAR(100) | NOT NULL | 표시 명칭 |
| `hierarchy` | VARCHAR(100) | NULL | hierarchy 필드 |
| `closure_reason_cv_id` | INT | NULL | closure_reason_cv 참조 식별자 (FK) |
| `closedon_date` | date | NULL | 계좌 종결일자 |
| `activatedon_userid` | BIGINT | NULL | 활성화 승인자 ID |
| `submittedon_date` | date | NULL | 접수일자 |
| `submittedon_userid` | BIGINT | NULL | 접수자 ID |
| `closedon_userid` | BIGINT | NULL | 종결자 ID |
| `account_no` | VARCHAR(20) | NOT NULL | 계좌 번호 |
| `name` | varchar(100) | NOT NULL | 명칭 / 이름 |
| `is_deleted` | tinyint | NOT NULL | deleted 여부 플래그 (Boolean) |

### `m_group_client` - 그룹과 소속 고객(구성원) 간 N:M 매핑
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `group_id` | BIGINT | PK, NOT NULL | 그룹 ID (FK: m_group.id) |
| `client_id` | BIGINT | PK, NOT NULL | 고객 ID (FK: m_client.id) |

### `m_group_roles` - 그룹 내 직책(그룹장, 총무 등) 지정 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NULL | 고객 ID (FK: m_client.id) |
| `group_id` | BIGINT | NULL | 그룹 ID (FK: m_group.id) |
| `role_cv_id` | INT | NULL | role_cv 참조 식별자 (FK) |

### `m_group_level` - 조직/그룹 계층 레벨 정의
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | INT | PK, NOT NULL | 고유 식별자 (PK) |
| `parent_id` | INT | NULL | parent 참조 식별자 (FK) |
| `super_parent` | boolean | NOT NULL | super_parent 필드 |
| `level_name` | VARCHAR(100) | NOT NULL | level_name 필드 |
| `recursable` | boolean | NOT NULL | recursable 필드 |
| `can_have_clients` | boolean | NOT NULL | can_have_clients 필드 |
| `INDEX` | `Parent_levelId_reference` | NULL | INDEX 필드 |

### `m_meeting` - 그룹/센터의 정기 모임(Center Meeting) 실행 기록
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_instance_id` | BIGINT | NOT NULL | calendar_instance 참조 식별자 (FK) |
| `meeting_date` | date | NOT NULL | meeting_date 일자 |

### `m_calendar` - 정기 모임 일정 캘린더 정의(반복주기, 요일)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `created_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 생성 일시 (UTC) |
| `last_modified_on_utc` | TIMESTAMP WITH TIME ZONE | NULL | 최종 수정 일시 (UTC) |
| `title` | VARCHAR(70) | NOT NULL | title 필드 |
| `description` | VARCHAR(100) | NULL | description 필드 |
| `location` | VARCHAR(50) | NULL | location 필드 |
| `start_date` | date | NOT NULL | start_date 일자 |
| `end_date` | date | NULL | end_date 일자 |
| `duration` | SMALLINT | NULL | duration 필드 |
| `calendar_type_enum` | SMALLINT | NOT NULL | calendar_type 유형 구분 Enum 코드 |
| `repeating` | boolean | NOT NULL | repeating 필드 |
| `recurrence` | VARCHAR(100) | NULL | recurrence 필드 |
| `remind_by_enum` | SMALLINT | NULL | remind_by 유형 구분 Enum 코드 |
| `first_reminder` | SMALLINT | NULL | first_reminder 필드 |
| `second_reminder` | SMALLINT | NULL | second_reminder 필드 |
| `createdby_id` | BIGINT | NULL | 생성자 ID |
| `lastmodifiedby_id` | BIGINT | NULL | 최종 수정자 ID |
| `created_date` | datetime | NULL | 생성 일시 |
| `lastmodified_date` | datetime | NULL | 최종 수정 일시 |
| `meeting_time` | time | NULL | meeting_time 필드 |

### `m_calendar_instance` - 특정 그룹/센터 엔티티에 연계된 캘린더 인스턴스
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_id` | BIGINT | NOT NULL | calendar 참조 식별자 (FK) |
| `entity_id` | BIGINT | NOT NULL | entity 참조 식별자 (FK) |
| `entity_type_enum` | SMALLINT | NOT NULL | entity_type 유형 구분 Enum 코드 |

## 근거
- `fineract-db/old-schema-files/0001a-mifosplatform-core-ddl-latest.sql`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0035_add_audit_entries_to_calendar.xml`
