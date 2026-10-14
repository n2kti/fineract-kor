# [WCP] 요구사항정의서

> 화면 1개 롤업(소분류 WCP, 대분류 WC - 운전자금 상품 및 한도위반 설정).

## WCP-001 운전자금 상품 및 한도위반 설정

> 원본: `fineract-backoffice-ui/src/app/features/working-capital/breach/wc-breach-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-WCP-001` | US1 | 운전자금 전용 대출 상품 및 이자율 설정 | `SC-001` |
| `FR-WCP-002` | US2 | 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정 | `SC-002` |

### `FR-WCP-001` 운전자금 전용 대출 상품 및 이자율 설정
- **유저 스토리 (US1)**: 담당 사용자는 운전자금 상품 및 한도위반 설정 화면에서 운전자금 전용 대출 상품 및 이자율 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 변동금리 연동 운전자금 상품 마스터 및 거치기간/회전한도 약관 설정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-WCP-002` 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정
- **유저 스토리 (US2)**: 담당 사용자는 운전자금 상품 및 한도위반 설정 화면에서 한도초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 한도 소진율 임계치(예: 90% Near-Breach, 100% Breach) 및 연체 감지 규칙 정의
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/working-capital/breach/wc-breach-list.component.ts`
