# [WCO] 요구사항정의서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

## WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-breach-action-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCO-001` | US1 | 한도위반 계좌 거래 정지 및 한도 축소 사후조치 | `SC-001` |

### `FR-WCO-001` 한도위반 계좌 거래 정지 및 한도 축소 사후조치
- **유저 스토리 (US1)**: 담당 사용자는 운전자금 위반 조치 관리 화면에서 한도위반 계좌 거래 정지 및 한도 축소 사후조치을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 위반 차주에 대한 신규 인출 차단, 금리 가산, 여신 한도 강제 축소 조치 실행
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-cob-catchup/wc-loan-cob-catchup.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCO-002` | US2 | 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리 | `SC-002` |

### `FR-WCO-002` 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리
- **유저 스토리 (US2)**: 담당 사용자는 운전자금 마감처리 및 계좌잠금 화면에서 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 배치 미처리 계좌에 대한 수동 Catch-up 실행 및 동시성 락 해제 관리
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-breach-action-form.component.ts`
- `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-cob-catchup/wc-loan-cob-catchup.component.ts`
