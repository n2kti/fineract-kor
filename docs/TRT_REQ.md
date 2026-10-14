# [TRT] 요구사항정의서

> 화면 1개 롤업(소분류 TRT, 대분류 TR - 창구 및 출납원 운영).

## TRT-001 창구 및 출납원 운영

> 원본: `fineract-backoffice-ui/src/app/features/tellers/tellers-list.component.ts, cashiers-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-TRT-001` | US1 | 지점 창구(Teller / 금고) 개설 및 관리 | `SC-001` |
| `FR-TRT-002` | US2 | 출납원(Cashier) 배정 및 현금 시재 할당/정산 | `SC-002` |
| `FR-TRT-003` | US3 | 창구 출납 거래 원장(Cashier Transactions) 조회 | `SC-003` |

### `FR-TRT-001` 지점 창구(Teller / 금고) 개설 및 관리
- **유저 스토리 (US1)**: 담당 사용자는 창구 및 출납원 운영 화면에서 지점 창구(Teller / 금고) 개설 및 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 지점별 창구 생성, 상태(개점/폐쇄) 관리 및 연동 GL 현금계정 매핑
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-TRT-002` 출납원(Cashier) 배정 및 현금 시재 할당/정산
- **유저 스토리 (US2)**: 담당 사용자는 창구 및 출납원 운영 화면에서 출납원(Cashier) 배정 및 현금 시재 할당/정산을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 직원을 특정 창구 출납원으로 배정하고 영업 시작 시재 할당(Allocate) 및 영업 마감 시재 정산(Settle) 처리
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-TRT-003` 창구 출납 거래 원장(Cashier Transactions) 조회
- **유저 스토리 (US3)**: 담당 사용자는 창구 및 출납원 운영 화면에서 창구 출납 거래 원장(Cashier Transactions) 조회을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 출납원별 일일 현금 입출금 거래 내역 및 시재 과부족 모니터링
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/tellers/tellers-list.component.ts, cashiers-list.component.ts`
