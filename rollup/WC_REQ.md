# [WC] 요구사항정의서 (운전자금)

> 소분류 3개 롤업.


---

## [WCL] 요구사항정의서

> 화면 1개 롤업(소분류 WCL, 대분류 WC - 운전자금 대출 관리).

### WCL-001 운전자금 대출 관리

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-loans-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCL-001` | US1 | 운전자금/공급망 대출 한도 조회 및 계좌 개설 | `SC-001` |
| `FR-WCL-002` | US2 | 운전자금 분할 인출(Drawdown) 및 실행 | `SC-002` |
| `FR-WCL-003` | US3 | 운전자금 원리금 상환 및 한도 복원 | `SC-003` |

#### `FR-WCL-001` 운전자금/공급망 대출 한도 조회 및 계좌 개설
- **유저 스토리 (US1)**: 담당 사용자는 운전자금 대출 관리 화면에서 운전자금/공급망 대출 한도 조회 및 계좌 개설을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기업 차주별 승인된 신용공여한도(Credit Facility) 내 운전자금 대출 신청 및 개설
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-WCL-002` 운전자금 분할 인출(Drawdown) 및 실행
- **유저 스토리 (US2)**: 담당 사용자는 운전자금 대출 관리 화면에서 운전자금 분할 인출(Drawdown) 및 실행을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기업의 필요 자금 요청에 따른 분할 실행 처리 및 상환 스케줄 생성
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-WCL-003` 운전자금 원리금 상환 및 한도 복원
- **유저 스토리 (US3)**: 담당 사용자는 운전자금 대출 관리 화면에서 운전자금 원리금 상환 및 한도 복원을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 원금 상환 시 사용 잔액 감소 및 가용 여신 한도 자동 복원
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-loans-list.component.ts`

---

## [WCP] 요구사항정의서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

### WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/breach/wc-breach-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCP-001` | US1 | 운전자금 전용 대출 상품 및 이자율 설정 | `SC-001` |
| `FR-WCP-002` | US2 | 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정 | `SC-002` |

#### `FR-WCP-001` 운전자금 전용 대출 상품 및 이자율 설정
- **유저 스토리 (US1)**: 담당 사용자는 운전자금 상품 및 한도위반 설정 화면에서 운전자금 전용 대출 상품 및 이자율 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 변동금리 연동 운전자금 상품 마스터 및 거치기간/회전한도 약관 설정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-WCP-002` 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정
- **유저 스토리 (US2)**: 담당 사용자는 운전자금 상품 및 한도위반 설정 화면에서 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 한도 소진율 임계치(예: 90% Near-Breach, 100% Breach) 및 연체 감지 규칙 정의
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/working-capital/breach/wc-breach-list.component.ts`

---

## [WCO] 요구사항정의서

> 화면 2개 롤업(소분류 WCO, 대분류 WC - 운전자금 사후조치 및 운영).

### WCO-001 운전자금 위반 조치 관리

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-breach-action-form.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCO-001` | US1 | 한도위반 계좌 거래 정지 및 한도 축소 사후조치 | `SC-001` |

#### `FR-WCO-001` 한도위반 계좌 거래 정지 및 한도 축소 사후조치
- **유저 스토리 (US1)**: 담당 사용자는 운전자금 위반 조치 관리 화면에서 한도위반 계좌 거래 정지 및 한도 축소 사후조치을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 위반 차주에 대한 신규 인출 차단, 금리 가산, 여신 한도 강제 축소 조치 실행
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### WCO-002 운전자금 마감처리 및 계좌잠금

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-cob-catchup/wc-loan-cob-catchup.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCO-002` | US2 | 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리 | `SC-002` |

#### `FR-WCO-002` 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리
- **유저 스토리 (US2)**: 담당 사용자는 운전자금 마감처리 및 계좌잠금 화면에서 운전자금 일마감(COB) 후속 처리 및 계좌 락 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 배치 미처리 계좌에 대한 수동 Catch-up 실행 및 동시성 락 해제 관리
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-breach-action-form.component.ts`
- `fineract-backoffice-ui/src/app/features/working-capital/loans/wc-cob-catchup/wc-loan-cob-catchup.component.ts`
