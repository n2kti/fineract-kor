# [CLS] DB명세서

> 화면 1개 롤업(소분류 CLS, 대분류 CL - 일괄 수납 집계표).

## CLS-001 일괄 수납 집계표

> 원본: `fineract-provider/src/main/java/org/apache/fineract/portfolio/collectionsheet/`

### 테이블 목록
| 테이블명 | 역할 |
| :--- | :--- |
| `m_client_attendance` | 정기 모임별 고객 출석 현황 기록 (출석, 결석, 대리출석 등) |
| `m_client_attendance` | 고객별 모임 출석 이력 집계 |
| `m_meeting` | 모임 일자 및 수납 회차 정보 |

### `m_client_attendance` - 정기 모임별 고객 출석 현황 기록 (출석, 결석, 대리출석 등)
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 |
| `name` | VARCHAR(100) | NOT NULL | 엔티티 명칭 |
| `created_date` | DATETIME | NULL | 생성 일시 |

### `m_client_attendance` - 고객별 모임 출석 이력 집계
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `client_id` | BIGINT | NOT NULL | 고객 ID (FK: m_client.id) |
| `meeting_id` | BIGINT | NOT NULL | meeting 참조 식별자 (FK) |
| `attendance_type_enum` | SMALLINT | NOT NULL | attendance_type 유형 구분 Enum 코드 |

### `m_meeting` - 모임 일자 및 수납 회차 정보
| 컬럼명 | 타입 | 제약 | 설명 |
| :--- | :--- | :--- | :--- |
| `id` | BIGINT | PK, NOT NULL | 고유 식별자 (PK) |
| `calendar_instance_id` | BIGINT | NOT NULL | calendar_instance 참조 식별자 (FK) |
| `meeting_date` | date | NOT NULL | meeting_date 일자 |

## 근거
- `fineract-provider/src/main/resources/db/changelog/tenant/parts/0001_initial_schema.xml`
