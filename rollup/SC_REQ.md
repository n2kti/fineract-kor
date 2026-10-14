# [SC] 요구사항정의서 (보안승인)

> 소분류 2개 롤업.


---

## [SCU] 요구사항정의서

> 화면 3개 롤업(소분류 SCU, 대분류 SC - 사용자 및 권한 관리).

### SCU-001 사용자 계정 관리

> 원본: `fineract-backoffice-ui/src/app/features/security/users/users-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-001` | US1 | 백오피스 사용자 계정 생성 및 지점/직원 연결 | `SC-001` |

#### `FR-SCU-001` 백오피스 사용자 계정 생성 및 지점/직원 연결
- **유저 스토리 (US1)**: 담당 사용자는 사용자 계정 관리 화면에서 백오피스 사용자 계정 생성 및 지점/직원 연결을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 사용자 ID, 이메일, 소속 지점, 연계 직원, 비밀번호 설정 후 계정 활성화
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### SCU-002 역할 및 권한 설정

> 원본: `fineract-backoffice-ui/src/app/features/security/roles/roles-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-002` | US2 | 사용자 역할(Role) 및 세부 권한(Permissions) 매핑 | `SC-002` |
| `FR-SCU-003` | US2 | Maker-Checker 이중 결재 대상 권한 지정 | `SC-003` |

#### `FR-SCU-002` 사용자 역할(Role) 및 세부 권한(Permissions) 매핑
- **유저 스토리 (US2)**: 담당 사용자는 역할 및 권한 설정 화면에서 사용자 역할(Role) 및 세부 권한(Permissions) 매핑을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 역할별 메뉴 접근 및 C/R/U/D 권한 매트릭스 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SCU-003` Maker-Checker 이중 결재 대상 권한 지정
- **유저 스토리 (US2)**: 담당 사용자는 역할 및 권한 설정 화면에서 Maker-Checker 이중 결재 대상 권한 지정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 주요 금융 거래/설정 변경에 대해 승인자 결재 필수 플래그 활성화
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### SCU-003 보안 정책 및 2단계 인증

> 원본: `fineract-backoffice-ui/src/app/features/system/password-preferences/password-preferences.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-004` | US3 | 비밀번호 정책 및 2단계 인증(2FA) 설정 | `SC-004` |

#### `FR-SCU-004` 비밀번호 정책 및 2단계 인증(2FA) 설정
- **유저 스토리 (US3)**: 담당 사용자는 보안 정책 및 2단계 인증 화면에서 비밀번호 정책 및 2단계 인증(2FA) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 비밀번호 최소 길이/특수문자 필수 조건 및 2FA OTP 인증 연동
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/security/roles/roles-list.component.ts`
- `fineract-backoffice-ui/src/app/features/security/users/users-list.component.ts`
- `fineract-backoffice-ui/src/app/features/system/password-preferences/password-preferences.component.ts`

---

## [SCA] 요구사항정의서

> 화면 1개 롤업(소분류 SCA, 대분류 SC - 감사 로그 및 결재 수신함).

### SCA-001 감사 로그 및 결재 수신함

> 원본: `fineract-backoffice-ui/src/app/features/security/audit-logs/audit-logs-list.component.ts, tasks/checker-inbox.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCA-001` | US1 | 전체 사용자 작업 감사 로그(Audit Trail) 조회 | `SC-001` |
| `FR-SCA-002` | US2 | Maker-Checker 결재 대기열(Checker Inbox) 승인/반려 | `SC-002` |
| `FR-SCA-003` | US3 | 외부 시스템 연동 웹훅(Hook) 이벤트 설정 | `SC-003` |

#### `FR-SCA-001` 전체 사용자 작업 감사 로그(Audit Trail) 조회
- **유저 스토리 (US1)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 전체 사용자 작업 감사 로그(Audit Trail) 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 사용자별, 일자별, API 엔드포인트별 상태 변경 요청 및 페이로드 감사 추적
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SCA-002` Maker-Checker 결재 대기열(Checker Inbox) 승인/반려
- **유저 스토리 (US2)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 Maker-Checker 결재 대기열(Checker Inbox) 승인/반려을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기안된 금융 거래/정보 변경 요청에 대해 승인(Approve) 또는 반려(Reject) 처리
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SCA-003` 외부 시스템 연동 웹훅(Hook) 이벤트 설정
- **유저 스토리 (US3)**: 담당 사용자는 감사 로그 및 결재 수신함 화면에서 외부 시스템 연동 웹훅(Hook) 이벤트 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 특정 비즈니스 이벤트(고객생성, 대출승인) 발생 시 외부 웹훅 URL 호출 구성
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/security/audit-logs/audit-logs-list.component.ts, tasks/checker-inbox.component.ts`
