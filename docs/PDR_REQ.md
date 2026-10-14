# [PDR] 요구사항정의서

> 화면 1개 롤업(소분류 PDR, 대분류 PD - 금리·수수료·세무 설정).

## PDR-001 금리·수수료·세무 설정

> 원본: `fineract-backoffice-ui/src/app/features/products/rates/rate-form.component.ts, tax-group-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-PDR-001` | US1 | 시장 기준금리 및 변동금리(Floating Rates) 설정 | `SC-001` |
| `FR-PDR-002` | US2 | 이자율 차트(Interest Rate Chart) 및 슬랩(Slabs) 구간 설정 | `SC-002` |
| `FR-PDR-003` | US3 | 수수료 규정(Charges) 마스터 설정 | `SC-003` |
| `FR-PDR-004` | US4 | 원천징수 세무 그룹(Tax Group) 및 세율(Tax Component) 설정 | `SC-004` |

### `FR-PDR-001` 시장 기준금리 및 변동금리(Floating Rates) 설정
- **유저 스토리 (US1)**: 담당 사용자는 금리·수수료·세무 설정 화면에서 시장 기준금리 및 변동금리(Floating Rates) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 기준금리(CD/코픽스) 명칭 및 일자별 고시 금리값 등록
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-PDR-002` 이자율 차트(Interest Rate Chart) 및 슬랩(Slabs) 구간 설정
- **유저 스토리 (US2)**: 담당 사용자는 금리·수수료·세무 설정 화면에서 이자율 차트(Interest Rate Chart) 및 슬랩(Slabs) 구간 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 예치 기간(일/월) 및 금액 구간별 차등 금리/우대금리 매트릭스 정의
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-PDR-003` 수수료 규정(Charges) 마스터 설정
- **유저 스토리 (US3)**: 담당 사용자는 금리·수수료·세무 설정 화면에서 수수료 규정(Charges) 마스터 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 정액/정률 수수료, 부과 시점(실행시, 납입시, 연체시), 징수 방식 정의
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-PDR-004` 원천징수 세무 그룹(Tax Group) 및 세율(Tax Component) 설정
- **유저 스토리 (US4)**: 담당 사용자는 금리·수수료·세무 설정 화면에서 원천징수 세무 그룹(Tax Group) 및 세율(Tax Component) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 이자소득세, 지방소득세 등 세목별 세율 및 회계 매핑 계정 설정
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/products/rates/rate-form.component.ts, tax-group-form.component.ts`
