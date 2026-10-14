# [SYC] 요구사항정의서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

## SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-backoffice-ui/src/app/features/system/codes/codes-list.component.ts, datatables/datatables-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYC-001` | US1 | 시스템 공통 코드 및 코드값(Code Values) 관리 | `SC-001` |
| `FR-SYC-002` | US1 | 사용자 정의 확장 데이터테이블(DataTables) 관리 | `SC-002` |

### `FR-SYC-001` 시스템 공통 코드 및 코드값(Code Values) 관리
- **유저 스토리 (US1)**: 담당 사용자는 공통 코드 및 확장 데이터 화면에서 시스템 공통 코드 및 코드값(Code Values) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 성별, 신분증유형, 대출목적 등 공통 코드 그룹 및 세부 코드값 등록/수정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYC-002` 사용자 정의 확장 데이터테이블(DataTables) 관리
- **유저 스토리 (US1)**: 담당 사용자는 공통 코드 및 확장 데이터 화면에서 사용자 정의 확장 데이터테이블(DataTables) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객/대출 엔티티에 연계할 커스텀 추가 필드 테이블 스키마 동적 생성
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-backoffice-ui/src/app/features/settings/global-configurations.component.ts, system/business-dates.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYC-003` | US2 | 시스템 전역 환경 파라미터(Global Configurations) 관리 | `SC-003` |
| `FR-SYC-004` | US2 | 시스템 영업일자(Business Date) 및 공휴일 관리 | `SC-004` |

### `FR-SYC-003` 시스템 전역 환경 파라미터(Global Configurations) 관리
- **유저 스토리 (US2)**: 담당 사용자는 환경설정 및 영업일 관리 화면에서 시스템 전역 환경 파라미터(Global Configurations) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 글로벌 설정값(다중지점여부, 페널티적용 등) 조회 및 변경
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYC-004` 시스템 영업일자(Business Date) 및 공휴일 관리
- **유저 스토리 (US2)**: 담당 사용자는 환경설정 및 영업일 관리 화면에서 시스템 영업일자(Business Date) 및 공휴일 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 현재 업무 기준일자 설정 및 지점별 공휴일/휴일 상환 처리 규칙 설정
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/settings/global-configurations.component.ts, system/business-dates.component.ts`
- `fineract-backoffice-ui/src/app/features/system/codes/codes-list.component.ts, datatables/datatables-list.component.ts`
