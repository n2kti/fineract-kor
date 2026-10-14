# [ACC] 요구사항정의서

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

## ACC-001 계정과목표(COA) 관리

> 원본: `fineract-backoffice-ui/src/app/features/accounting/chart-of-accounts.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-001` | US1 | 계정과목표(COA) 계층 트리 조회 | `SC-001` |
| `FR-ACC-002` | US1 | 총계정원장(GL Account) 계정과목 신규 등록 및 수정 | `SC-002` |

### `FR-ACC-001` 계정과목표(COA) 계층 트리 조회
- **유저 스토리 (US1)**: 담당 사용자는 계정과목표(COA) 관리 화면에서 계정과목표(COA) 계층 트리 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 자산(1), 부채(2), 자본(3), 수익(4), 비용(5) 5대 대분류 계정 체계 트리 렌더링
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACC-002` 총계정원장(GL Account) 계정과목 신규 등록 및 수정
- **유저 스토리 (US1)**: 담당 사용자는 계정과목표(COA) 관리 화면에서 총계정원장(GL Account) 계정과목 신규 등록 및 수정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - GL코드, 계정명, 상위계정, 계정유형(헤더/세목), 수기분개 허용여부 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-backoffice-ui/src/app/features/accounting/journal-entry-view.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-003` | US2 | 일반/수기 분개 전표(Manual Journal Entry) 입력 | `SC-003` |
| `FR-ACC-004` | US2 | 분개 전표 검색 및 역분개(Reverse) 처리 | `SC-004` |

### `FR-ACC-003` 일반/수기 분개 전표(Manual Journal Entry) 입력
- **유저 스토리 (US2)**: 담당 사용자는 분개 전표 조회 및 입력 화면에서 일반/수기 분개 전표(Manual Journal Entry) 입력을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 거래일자, 지점, 통화, 차변(Debit)/대변(Credit) 계정과목 및 금액 입력 후 대차평균 검증 및 전표 기표
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACC-004` 분개 전표 검색 및 역분개(Reverse) 처리
- **유저 스토리 (US2)**: 담당 사용자는 분개 전표 조회 및 입력 화면에서 분개 전표 검색 및 역분개(Reverse) 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 전표번호, 거래일자, 계정별 전표 검색 및 오류 전표 역분개 취소
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## ACC-003 기초잔액 등록

> 원본: `fineract-backoffice-ui/src/app/features/accounting/opening-balances.component.ts, accounting-closure-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-005` | US3 | 시스템 이관 계정별 기초잔액(Opening Balance) 등록 | `SC-005` |
| `FR-ACC-006` | US4 | 지점별/기간별 회계 마감(GL Closure) 처리 | `SC-006` |

### `FR-ACC-005` 시스템 이관 계정별 기초잔액(Opening Balance) 등록
- **유저 스토리 (US3)**: 담당 사용자는 기초잔액 등록 화면에서 시스템 이관 계정별 기초잔액(Opening Balance) 등록을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 시스템 오픈 시점 계정과목별 기초 차/대 잔액 입력 및 확정
- **성공 기준 (`SC-005`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACC-006` 지점별/기간별 회계 마감(GL Closure) 처리
- **유저 스토리 (US4)**: 담당 사용자는 기초잔액 등록 화면에서 지점별/기간별 회계 마감(GL Closure) 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 특정 회계일자 이전의 전표 수정/추가 기표를 차단하는 결산 마감 처리
- **성공 기준 (`SC-006`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/accounting/chart-of-accounts.component.ts`
- `fineract-backoffice-ui/src/app/features/accounting/journal-entry-view.component.ts`
- `fineract-backoffice-ui/src/app/features/accounting/opening-balances.component.ts, accounting-closure-form.component.ts`
