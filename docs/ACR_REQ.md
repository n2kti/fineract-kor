# [ACR] 요구사항정의서

> 화면 1개 롤업(소분류 ACR, 대분류 AC - 회계 규칙 및 매핑).

## ACR-001 회계 분개 규칙 및 매핑

> 원본: `fineract-backoffice-ui/src/app/features/accounting/accounting-rule-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-ACR-001` | US1 | 정형 거래 회계 분개 규칙(Accounting Rules) 정의 | `SC-001` |
| `FR-ACR-002` | US2 | 금융 활동(Financial Activity) 계정 자동 매핑 | `SC-002` |

### `FR-ACR-001` 정형 거래 회계 분개 규칙(Accounting Rules) 정의
- **유저 스토리 (US1)**: 담당 사용자는 회계 분개 규칙 및 매핑 화면에서 정형 거래 회계 분개 규칙(Accounting Rules) 정의을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 반복되는 수기 거래에 대해 차변/대변 계정을 사전 프리셋으로 정의
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-ACR-002` 금융 활동(Financial Activity) 계정 자동 매핑
- **유저 스토리 (US2)**: 담당 사용자는 회계 분개 규칙 및 매핑 화면에서 금융 활동(Financial Activity) 계정 자동 매핑을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 현금수납, 개설잔액 정산 등 시스템 핵심 금융 이벤트와 대응 GL 계정 1:1 매핑
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/accounting/accounting-rule-form.component.ts`
