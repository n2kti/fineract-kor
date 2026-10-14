# [LNO] 요구사항정의서

> 화면 2개 롤업(소분류 LNO, 대분류 LN - 대출 부속 및 운영).

## LNO-001 대출 담보 및 보증인 관리

> 원본: `fineract-backoffice-ui/src/app/features/loans/loan-view.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-LNO-001` | US1 | 대출 담보물(Collateral) 등록 및 관리 | `SC-001` |
| `FR-LNO-002` | US2 | 연대보증인(Guarantor) 등록 및 관계 설정 | `SC-002` |
| `FR-LNO-003` | US2 | 보증인 예금 질권 설정(Guarantor On-Hold) | `SC-003` |

### `FR-LNO-001` 대출 담보물(Collateral) 등록 및 관리
- **유저 스토리 (US1)**: 담당 사용자는 대출 담보 및 보증인 관리 화면에서 대출 담보물(Collateral) 등록 및 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 부동산, 유가증권, 보증서 등 담보 유형, 감정가액, 담보인정비율(LTV) 등록
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-LNO-002` 연대보증인(Guarantor) 등록 및 관계 설정
- **유저 스토리 (US2)**: 담당 사용자는 대출 담보 및 보증인 관리 화면에서 연대보증인(Guarantor) 등록 및 관계 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기존 고객 또는 외부인의 보증인 등록, 보증한도금액 지정
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-LNO-003` 보증인 예금 질권 설정(Guarantor On-Hold)
- **유저 스토리 (US2)**: 담당 사용자는 대출 담보 및 보증인 관리 화면에서 보증인 예금 질권 설정(Guarantor On-Hold)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 보증인의 보통/정기예금 계좌에 보증금액만큼 지급정지(Hold) 및 질권 설정
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## LNO-002 대출 일괄 재배정 및 시점조회

> 원본: `fineract-backoffice-ui/src/app/features/loans/loans-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-LNO-004` | US3 | 대출 담당 직원 일괄 재배정(Bulk Loan Reassignment) | `SC-004` |
| `FR-LNO-005` | US4 | 특정 기준일자 시점별 대출 원장 조회(Point In Time Loan View) | `SC-005` |

### `FR-LNO-004` 대출 담당 직원 일괄 재배정(Bulk Loan Reassignment)
- **유저 스토리 (US3)**: 담당 사용자는 대출 일괄 재배정 및 시점조회 화면에서 대출 담당 직원 일괄 재배정(Bulk Loan Reassignment)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 인사이동 시 특정 직원의 대출 계좌 목록을 다른 담당 직원에게 일괄 이관
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-LNO-005` 특정 기준일자 시점별 대출 원장 조회(Point In Time Loan View)
- **유저 스토리 (US4)**: 담당 사용자는 대출 일괄 재배정 및 시점조회 화면에서 특정 기준일자 시점별 대출 원장 조회(Point In Time Loan View)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 과거 특정 일자 기준의 대출 잔액, 연체 상태, 미수이자 시점 재현 조회
- **성공 기준 (`SC-005`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/loans/loan-view.component.ts`
- `fineract-backoffice-ui/src/app/features/loans/loans-list.component.ts`
