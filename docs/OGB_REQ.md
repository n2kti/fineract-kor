# [OGB] 요구사항정의서

> 화면 3개 롤업(소분류 OGB, 대분류 OG - 지점 및 직원 관리).

## OGB-001 지점(Office) 관리

> 원본: `fineract-backoffice-ui/src/app/features/organization/offices/offices-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-OGB-001` | US1 | 조직 지점 계층 구조(Office Hierarchy) 관리 | `SC-001` |

### `FR-OGB-001` 조직 지점 계층 구조(Office Hierarchy) 관리
- **유저 스토리 (US1)**: 담당 사용자는 지점(Office) 관리 화면에서 조직 지점 계층 구조(Office Hierarchy) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 본점 하위 지점 등록, 상위 지점 변경 및 지점 개설일/외부식별자 관리
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## OGB-002 직원(Staff) 관리

> 원본: `fineract-backoffice-ui/src/app/features/organization/staff/staff-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-OGB-002` | US2 | 지점 직원 등록 및 담당자(Loan Officer) 역할 지정 | `SC-002` |

### `FR-OGB-002` 지점 직원 등록 및 담당자(Loan Officer) 역할 지정
- **유저 스토리 (US2)**: 담당 사용자는 직원(Staff) 관리 화면에서 지점 직원 등록 및 담당자(Loan Officer) 역할 지정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 직원 인적사항 등록, 소속 지점 배정 및 여신/수신 영업 권한 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## OGB-003 지점간 거래 및 포트폴리오 요약

> 원본: `fineract-backoffice-ui/src/app/features/organization/office-transactions/office-transactions-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-OGB-003` | US3 | 본지점간 자금 이동 거래 및 여신 집계 요약 조회 | `SC-003` |

### `FR-OGB-003` 본지점간 자금 이동 거래 및 여신 집계 요약 조회
- **유저 스토리 (US3)**: 담당 사용자는 지점간 거래 및 포트폴리오 요약 화면에서 본지점간 자금 이동 거래 및 여신 집계 요약 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 지점간 자금 대체 전표 등록 및 지점별 여신/수신 잔액 현황 조회
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/organization/office-transactions/office-transactions-list.component.ts`
- `fineract-backoffice-ui/src/app/features/organization/offices/offices-list.component.ts`
- `fineract-backoffice-ui/src/app/features/organization/staff/staff-list.component.ts`
