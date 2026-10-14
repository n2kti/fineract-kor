# [SYB] 요구사항정의서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

## SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-backoffice-ui/src/app/features/system/scheduler-jobs/scheduler-jobs-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYB-001` | US1 | 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행 | `SC-001` |
| `FR-SYB-002` | US1 | 배치 작업 실행 이력(Job History) 모니터링 | `SC-002` |

### `FR-SYB-001` 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행
- **유저 스토리 (US1)**: 담당 사용자는 스케줄러 배치 작업 관리 화면에서 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 이자계산, 연체평가, 자동이체 등 배치 작업 활성화/비활성화 및 즉시 실행
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYB-002` 배치 작업 실행 이력(Job History) 모니터링
- **유저 스토리 (US1)**: 담당 사용자는 스케줄러 배치 작업 관리 화면에서 배치 작업 실행 이력(Job History) 모니터링을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 배치 실행 시작/종료 시각, 처리 건수 및 오류 로그 모니터링
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-backoffice-ui/src/app/features/loans/cob-catchup/loan-cob-catchup.component.ts, fineract-backoffice-ui/src/app/features/system/delinquency/delinquency-management.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYB-003` | US2 | 일마감(COB) 배치 스텝 구성 및 실패 건 처리 | `SC-003` |
| `FR-SYB-004` | US2 | 연체 구간(Delinquency Bucket) 분류 기준 설정 | `SC-004` |

### `FR-SYB-003` 일마감(COB) 배치 스텝 구성 및 실패 건 처리
- **유저 스토리 (US2)**: 담당 사용자는 일마감(COB) 및 연체 관리 화면에서 일마감(COB) 배치 스텝 구성 및 실패 건 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - COB 마감 비즈니스 스텝 순서 설정 및 미처리 대출 일괄 재처리
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYB-004` 연체 구간(Delinquency Bucket) 분류 기준 설정
- **유저 스토리 (US2)**: 담당 사용자는 일마감(COB) 및 연체 관리 화면에서 연체 구간(Delinquency Bucket) 분류 기준 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 연체 일수 범위별 버킷 정의 및 대출 계좌 자동 분류
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/loans/cob-catchup/loan-cob-catchup.component.ts, fineract-backoffice-ui/src/app/features/system/delinquency/delinquency-management.component.ts`
- `fineract-backoffice-ui/src/app/features/system/scheduler-jobs/scheduler-jobs-list.component.ts`
