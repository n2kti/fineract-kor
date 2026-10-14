# [SYI] 요구사항정의서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

## SYI-001 대외연계 및 알림 설정

> 원본: `fineract-backoffice-ui/src/app/features/system/bulk-import/bulk-import.component.ts, campaigns/email/email-campaign-form.component.ts`

### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYI-001` | US1 | 엑셀/CSV 일괄 데이터 업로드(Bulk Import) | `SC-001` |
| `FR-SYI-002` | US2 | SMS / 이메일 대량 발송 캠페인 관리 | `SC-002` |
| `FR-SYI-003` | US3 | 대외 결제 연계(Interop) 식별자 관리 | `SC-003` |

### `FR-SYI-001` 엑셀/CSV 일괄 데이터 업로드(Bulk Import)
- **유저 스토리 (US1)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 엑셀/CSV 일괄 데이터 업로드(Bulk Import)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객, 대출, 예금, 전표 템플릿 다운로드 및 일괄 등록 파싱/검증
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYI-002` SMS / 이메일 대량 발송 캠페인 관리
- **유저 스토리 (US2)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 SMS / 이메일 대량 발송 캠페인 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객 타깃 그룹 및 메시지 템플릿 지정 후 자동 발송 예약
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### `FR-SYI-003` 대외 결제 연계(Interop) 식별자 관리
- **유저 스토리 (US3)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 대외 결제 연계(Interop) 식별자 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - Mojaloop 등 금융망 연계를 위한 계좌 식별자 매핑 및 연동 상태 조회
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

## 근거
- `fineract-backoffice-ui/src/app/features/system/bulk-import/bulk-import.component.ts, campaigns/email/email-campaign-form.component.ts`
