# [ACP] 요구사항정의서

> 화면 1개 롤업(소분류 ACP, 대분류 AC - 회계 결산 및 대손충당금).

## ACP-001 회계 결산 및 대손충당금

> 원본: `fineract-backoffice-ui/src/app/features/accounting/provisioning-entries/provisioning-entries-list.component.ts, accounting-closure-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACP-001` | US1 | 지점별 회계 마감(GL Closure) 및 결산 확정 | `SC-001` |
| `FR-ACP-002` | US2 | 대손충당금 산출 기준(Provisioning Criteria) 설정 | `SC-002` |
| `FR-ACP-003` | US3 | 대손충당금 자동 산출 배치 및 분개 전표 기표 | `SC-003` |

### `FR-ACP-001` 지점별 회계 마감(GL Closure) 및 결산 확정
- **유저 스토리 (US1)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 지점별 회계 마감(GL Closure) 및 결산 확정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 회계 기간 마감일자를 지정하여 과거 전표 수정/입력을 원천 차단하고 결산 분개 확정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACP-002` 대손충당금 산출 기준(Provisioning Criteria) 설정
- **유저 스토리 (US2)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 대손충당금 산출 기준(Provisioning Criteria) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 대출 상품 및 자산건전성 분류(정상, 요주의, 고정 등) 구간별 충당 비율 설정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACP-003` 대손충당금 자동 산출 배치 및 분개 전표 기표
- **유저 스토리 (US3)**: 담당 사용자는 회계 결산 및 대손충당금 화면에서 대손충당금 자동 산출 배치 및 분개 전표 기표을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 여신 잔액에 대한 대손충당금 산출 실행 후 차변(대손상각비)/대변(대손충당금) 자동 분개 전표 생성
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/accounting/provisioning-entries/provisioning-entries-list.component.ts, accounting-closure-form.component.ts`
