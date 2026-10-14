# [RPR] 요구사항정의서

> 화면 2개 롤업(소분류 RPR, 대분류 RP - 보고서 및 조회).

## RPR-001 보고서 조회 및 실행

> 원본: `fineract-backoffice-ui/src/app/features/reporting/reports-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-RPR-001` | US1 | 카테고리별 표준 보고서 목록 조회 및 파라미터 실행 | `SC-001` |
| `FR-RPR-002` | US1 | 보고서 데이터 내보내기 (PDF, Excel, CSV) | `SC-002` |

### `FR-RPR-001` 카테고리별 표준 보고서 목록 조회 및 파라미터 실행
- **유저 스토리 (US1)**: 담당 사용자는 보고서 조회 및 실행 화면에서 카테고리별 표준 보고서 목록 조회 및 파라미터 실행을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 여신/수신/회계 표준 보고서 선택, 검색 조건 입력 후 표/차트 렌더링
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-RPR-002` 보고서 데이터 내보내기 (PDF, Excel, CSV)
- **유저 스토리 (US1)**: 담당 사용자는 보고서 조회 및 실행 화면에서 보고서 데이터 내보내기 (PDF, Excel, CSV)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 실행된 보고서 결과를 다양한 포맷 파일로 다운로드
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## RPR-002 보고서 정의 및 메일링 작업

> 원본: `fineract-backoffice-ui/src/app/features/system/report-definitions/report-definitions-list.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-RPR-003` | US2 | 커스텀 SQL 보고서 템플릿 등록 및 파라미터 매핑 | `SC-003` |
| `FR-RPR-004` | US2 | 보고서 자동 메일링 스케줄(Report Mailing Job) 설정 | `SC-004` |

### `FR-RPR-003` 커스텀 SQL 보고서 템플릿 등록 및 파라미터 매핑
- **유저 스토리 (US2)**: 담당 사용자는 보고서 정의 및 메일링 작업 화면에서 커스텀 SQL 보고서 템플릿 등록 및 파라미터 매핑을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 사용자 정의 SQL 쿼리 등록 및 런타임 입력 파라미터 연결
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-RPR-004` 보고서 자동 메일링 스케줄(Report Mailing Job) 설정
- **유저 스토리 (US2)**: 담당 사용자는 보고서 정의 및 메일링 작업 화면에서 보고서 자동 메일링 스케줄(Report Mailing Job) 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 지정된 일자에 보고서를 자동 생성하여 이메일로 발송하는 작업 스케줄링
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/reporting/reports-list.component.ts`
- `fineract-backoffice-ui/src/app/features/system/report-definitions/report-definitions-list.component.ts`
