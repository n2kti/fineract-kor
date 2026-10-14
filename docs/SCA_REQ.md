# [SCA] 요구사항정의서

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

## SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-backoffice-ui/src/app/features/security/audit-logs/audit-logs-list.component.ts, tasks/checker-inbox.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCA-001` | US1 | 전체 사용자 작업 감사 로그(Audit Trail) 조회 | `SC-001` |
| `FR-SCA-002` | US2 | Maker-Checker 결재 대기열(Checker Inbox) 승인/반려 | `SC-002` |
| `FR-SCA-003` | US3 | 외부 시스템 연동 웹훅(Hook) 이벤트 설정 | `SC-003` |

### `FR-SCA-001` 전체 사용자 작업 감사 로그(Audit Trail) 조회
- **유저 스토리 (US1)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 전체 사용자 작업 감사 로그(Audit Trail) 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 사용자별, 일자별, API 엔드포인트별 상태 변경 요청 및 페이로드 감사 추적
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SCA-002` Maker-Checker 결재 대기열(Checker Inbox) 승인/반려
- **유저 스토리 (US2)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 Maker-Checker 결재 대기열(Checker Inbox) 승인/반려을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기안된 금융 거래/정보 변경 요청에 대해 승인(Approve) 또는 반려(Reject) 처리
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SCA-003` 외부 시스템 연동 웹훅(Hook) 이벤트 설정
- **유저 스토리 (US3)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 외부 시스템 연동 웹훅(Hook) 이벤트 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 특정 비즈니스 이벤트(고객생성, 대출승인) 발생 시 외부 웹훅 URL 호출 구성
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/security/audit-logs/audit-logs-list.component.ts, tasks/checker-inbox.component.ts`
