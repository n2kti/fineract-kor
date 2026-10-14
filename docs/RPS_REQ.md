# [RPS] 요구사항정의서

> 화면 1개 롤업(소분류 RPS, 대분류 RP - 사회성과 관리).

## RPS-001 사회성과(SPM) 지표 관리

> 원본: `fineract-backoffice-ui/src/app/features/spm/surveys/spm-surveys-list.component.ts, poverty-line/poverty-line.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-RPS-001` | US1 | 사회성과 설문조사(Survey) 등록 및 문항 구성 | `SC-001` |
| `FR-RPS-002` | US2 | 고객 설문 응답(Scorecard) 입력 및 점수 산출 | `SC-002` |
| `FR-RPS-003` | US3 | 국가별 빈곤선(Poverty Line) 기준값 설정 | `SC-003` |

### `FR-RPS-001` 사회성과 설문조사(Survey) 등록 및 문항 구성
- **유저 스토리 (US1)**: 담당 사용자는 사회성과(SPM) 지표 관리 화면에서 사회성과 설문조사(Survey) 등록 및 문항 구성을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 설문조사 기본정보, 질문 문항 및 선택지 점수 가중치 정의
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-RPS-002` 고객 설문 응답(Scorecard) 입력 및 점수 산출
- **유저 스토리 (US2)**: 담당 사용자는 사회성과(SPM) 지표 관리 화면에서 고객 설문 응답(Scorecard) 입력 및 점수 산출을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객별 설문 답변 등록 및 빈곤선 확률(Likelihood) 자동 산출
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-RPS-003` 국가별 빈곤선(Poverty Line) 기준값 설정
- **유저 스토리 (US3)**: 담당 사용자는 사회성과(SPM) 지표 관리 화면에서 국가별 빈곤선(Poverty Line) 기준값 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 국가별/연도별 빈곤선 기준 및 점수 환산 매트릭스 설정
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/spm/surveys/spm-surveys-list.component.ts, poverty-line/poverty-line.component.ts`
