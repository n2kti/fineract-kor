# [SCU] 요구사항정의서

> 화면 3개 롤업(소분류 SCU, 대분류 SC - 사용자 및 권한 관리).

## SCU-001 사용자 계정 관리

> 원본: `fineract-backoffice-ui/src/app/features/security/users/users-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-001` | US1 | 백오피스 사용자 계정 생성 및 지점/직원 연결 | `SC-001` |

### `FR-SCU-001` 백오피스 사용자 계정 생성 및 지점/직원 연결
- **유저 스토리 (US1)**: 담당 사용자는 사용자 계정 관리 화면에서 백오피스 사용자 계정 생성 및 지점/직원 연결을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 사용자 ID, 이메일, 소속 지점, 연계 직원, 비밀번호 설정 후 계정 활성화
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## SCU-002 역할 및 권한 설정

> 원본: `fineract-backoffice-ui/src/app/features/security/roles/roles-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-002` | US2 | 사용자 역할(Role) 및 세부 권한(Permissions) 매핑 | `SC-002` |
| `FR-SCU-003` | US2 | Maker-Checker 이중 결재 대상 권한 지정 | `SC-003` |

### `FR-SCU-002` 사용자 역할(Role) 및 세부 권한(Permissions) 매핑
- **유저 스토리 (US2)**: 담당 사용자는 역할 및 권한 설정 화면에서 사용자 역할(Role) 및 세부 권한(Permissions) 매핑을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 역할별 메뉴 접근 및 C/R/U/D 권한 매트릭스 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SCU-003` Maker-Checker 이중 결재 대상 권한 지정
- **유저 스토리 (US2)**: 담당 사용자는 역할 및 권한 설정 화면에서 Maker-Checker 이중 결재 대상 권한 지정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 주요 금융 거래/설정 변경에 대해 승인자 결재 필수 플래그 활성화
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## SCU-003 보안 정책 및 2단계 인증

> 원본: `fineract-backoffice-ui/src/app/features/system/password-preferences/password-preferences.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SCU-004` | US3 | 비밀번호 정책 및 2단계 인증(2FA) 설정 | `SC-004` |

### `FR-SCU-004` 비밀번호 정책 및 2단계 인증(2FA) 설정
- **유저 스토리 (US3)**: 담당 사용자는 보안 정책 및 2단계 인증 화면에서 비밀번호 정책 및 2단계 인증(2FA) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 비밀번호 최소 길이/특수문자 필수 조건 및 2FA OTP 인증 연동
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/security/roles/roles-list.component.ts`
- `fineract-backoffice-ui/src/app/features/security/users/users-list.component.ts`
- `fineract-backoffice-ui/src/app/features/system/password-preferences/password-preferences.component.ts`
