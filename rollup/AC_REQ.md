# [AC] 요구사항정의서 (회계결산)

> 소분류 3개 롤업.


---

## [ACC] 요구사항정의서

> 화면 3개 롤업(소분류 ACC, 대분류 AC - 계정과목 및 분개장).

### ACC-001 계정과목표(COA) 관리

> 원본: `fineract-backoffice-ui/src/app/features/accounting/chart-of-accounts.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-001` | US1 | 계정과목표(COA) 계층 트리 조회 | `SC-001` |
| `FR-ACC-002` | US1 | 총계정원장(GL Account) 계정과목 신규 등록 및 수정 | `SC-002` |

#### `FR-ACC-001` 계정과목표(COA) 계층 트리 조회
- **유저 스토리 (US1)**: 담당 사용자는 계정과목표(COA) 관리 화면에서 계정과목표(COA) 계층 트리 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 자산(1), 부채(2), 자본(3), 수익(4), 비용(5) 5대 대분류 계정 체계 트리 렌더링
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACC-002` 총계정원장(GL Account) 계정과목 신규 등록 및 수정
- **유저 스토리 (US1)**: 담당 사용자는 계정과목표(COA) 관리 화면에서 총계정원장(GL Account) 계정과목 신규 등록 및 수정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - GL코드, 계정명, 상위계정, 계정유형(헤더/세목), 수기분개 허용여부 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### ACC-002 분개 전표 조회 및 입력

> 원본: `fineract-backoffice-ui/src/app/features/accounting/journal-entry-view.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-003` | US2 | 일반/수기 분개 전표(Manual Journal Entry) 입력 | `SC-003` |
| `FR-ACC-004` | US2 | 분개 전표 검색 및 역분개(Reverse) 처리 | `SC-004` |

#### `FR-ACC-003` 일반/수기 분개 전표(Manual Journal Entry) 입력
- **유저 스토리 (US2)**: 담당 사용자는 분개 전표 조회 및 입력 화면에서 일반/수기 분개 전표(Manual Journal Entry) 입력을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 거래일자, 지점, 통화, 차변(Debit)/대변(Credit) 계정과목 및 금액 입력 후 대차평균 검증 및 전표 기표
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACC-004` 분개 전표 검색 및 역분개(Reverse) 처리
- **유저 스토리 (US2)**: 담당 사용자는 분개 전표 조회 및 입력 화면에서 분개 전표 검색 및 역분개(Reverse) 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 전표번호, 거래일자, 계정별 전표 검색 및 오류 전표 역분개 취소
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### ACC-003 기초잔액 등록

> 원본: `fineract-backoffice-ui/src/app/features/accounting/opening-balances.component.ts, accounting-closure-form.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACC-005` | US3 | 시스템 이관 계정별 기초잔액(Opening Balance) 등록 | `SC-005` |
| `FR-ACC-006` | US4 | 지점별/기간별 회계 마감(GL Closure) 처리 | `SC-006` |

#### `FR-ACC-005` 시스템 이관 계정별 기초잔액(Opening Balance) 등록
- **유저 스토리 (US3)**: 담당 사용자는 기초잔액 등록 화면에서 시스템 이관 계정별 기초잔액(Opening Balance) 등록을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 시스템 오픈 시점 계정과목별 기초 차/대 잔액 입력 및 확정
- **성공 기준 (`SC-005`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACC-006` 지점별/기간별 회계 마감(GL Closure) 처리
- **유저 스토리 (US4)**: 담당 사용자는 기초잔액 등록 화면에서 지점별/기간별 회계 마감(GL Closure) 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 특정 회계일자 이전의 전표 수정/추가 기표를 차단하는 결산 마감 처리
- **성공 기준 (`SC-006`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/accounting/chart-of-accounts.component.ts`
- `fineract-backoffice-ui/src/app/features/accounting/journal-entry-view.component.ts`
- `fineract-backoffice-ui/src/app/features/accounting/opening-balances.component.ts, accounting-closure-form.component.ts`

---

## [ACR] 요구사항정의서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

### ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-backoffice-ui/src/app/features/accounting/accounting-rule-form.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACR-001` | US1 | 정형 거래 회계 분개 규칙(Accounting Rules) 정의 | `SC-001` |
| `FR-ACR-002` | US2 | 금융 활동(Financial Activity) 계정 자동 매핑 | `SC-002` |

#### `FR-ACR-001` 정형 거래 회계 분개 규칙(Accounting Rules) 정의
- **유저 스토리 (US1)**: 담당 사용자는 회계 분개 규칙 및 매핑 화면에서 정형 거래 회계 분개 규칙(Accounting Rules) 정의을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 반복되는 수기 거래에 대해 차변/대변 계정을 사전 프리셋으로 정의
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACR-002` 금융 활동(Financial Activity) 계정 자동 매핑
- **유저 스토리 (US2)**: 담당 사용자는 회계 분개 규칙 및 매핑 화면에서 금융 활동(Financial Activity) 계정 자동 매핑을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 현금수납, 개설잔액 정산 등 시스템 핵심 금융 이벤트와 대응 GL 계정 1:1 매핑
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/accounting/accounting-rule-form.component.ts`

---

## [ACP] 요구사항정의서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

### ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-backoffice-ui/src/app/features/accounting/provisioning-entries/provisioning-entries-list.component.ts, accounting-closure-form.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACP-001` | US1 | 지점별 회계 마감(GL Closure) 및 결산 확정 | `SC-001` |
| `FR-ACP-002` | US2 | 대손충당금 산출 기준(Provisioning Criteria) 설정 | `SC-002` |
| `FR-ACP-003` | US3 | 대손충당금 자동 산출 배치 및 분개 전표 기표 | `SC-003` |

#### `FR-ACP-001` 지점별 회계 마감(GL Closure) 및 결산 확정
- **유저 스토리 (US1)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 지점별 회계 마감(GL Closure) 및 결산 확정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 회계 기간 마감일자를 지정하여 과거 전표 수정/입력을 원천 차단하고 결산 분개 확정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACP-002` 대손충당금 산출 기준(Provisioning Criteria) 설정
- **유저 스토리 (US2)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 대손충당금 산출 기준(Provisioning Criteria) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 대출 상품 및 자산건전성 분류(정상, 요주의, 고정 등) 구간별 충당 비율 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-ACP-003` 대손충당금 자동 산출 배치 및 분개 전표 기표
- **유저 스토리 (US3)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 대손충당금 자동 산출 배치 및 분개 전표 기표을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 여신 잔액에 대한 대손충당금 산출 실행 후 차변(대손상각비)/대변(대손충당금) 자동 분개 전표 생성
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/accounting/provisioning-entries/provisioning-entries-list.component.ts, accounting-closure-form.component.ts`
