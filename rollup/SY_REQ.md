# [SY] 요구사항정의서 (시스템운영)

> 소분류 3개 롤업.


---

## [SYC] 요구사항정의서

> 화면 2개 롤업(소분류 SYC, 대분류 SY - 공통코드 및 환경설정).

### SYC-001 공통 코드 및 확장 데이터

> 원본: `fineract-backoffice-ui/src/app/features/system/codes/codes-list.component.ts, datatables/datatables-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYC-001` | US1 | 시스템 공통 코드 및 코드값(Code Values) 관리 | `SC-001` |
| `FR-SYC-002` | US1 | 사용자 정의 확장 데이터테이블(DataTables) 관리 | `SC-002` |

#### `FR-SYC-001` 시스템 공통 코드 및 코드값(Code Values) 관리
- **유저 스토리 (US1)**: 담당 사용자는 공통 코드 및 확장 데이터 화면에서 시스템 공통 코드 및 코드값(Code Values) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 성별, 신분증유형, 대출목적 등 공통 코드 그룹 및 세부 코드값 등록/수정
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYC-002` 사용자 정의 확장 데이터테이블(DataTables) 관리
- **유저 스토리 (US1)**: 담당 사용자는 공통 코드 및 확장 데이터 화면에서 사용자 정의 확장 데이터테이블(DataTables) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객/대출 엔티티에 연계할 커스텀 추가 필드 테이블 스키마 동적 생성
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### SYC-002 환경설정 및 영업일 관리

> 원본: `fineract-backoffice-ui/src/app/features/settings/global-configurations.component.ts, system/business-dates.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYC-003` | US2 | 시스템 전역 환경 파라미터(Global Configurations) 관리 | `SC-003` |
| `FR-SYC-004` | US2 | 시스템 영업일자(Business Date) 및 공휴일 관리 | `SC-004` |

#### `FR-SYC-003` 시스템 전역 환경 파라미터(Global Configurations) 관리
- **유저 스토리 (US2)**: 담당 사용자는 환경설정 및 영업일 관리 화면에서 시스템 전역 환경 파라미터(Global Configurations) 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 글로벌 설정값(다중지점여부, 페널티적용 등) 조회 및 변경
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYC-004` 시스템 영업일자(Business Date) 및 공휴일 관리
- **유저 스토리 (US2)**: 담당 사용자는 환경설정 및 영업일 관리 화면에서 시스템 영업일자(Business Date) 및 공휴일 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 현재 업무 기준일자 설정 및 지점별 공휴일/휴일 상환 처리 규칙 설정
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/settings/global-configurations.component.ts, system/business-dates.component.ts`
- `fineract-backoffice-ui/src/app/features/system/codes/codes-list.component.ts, datatables/datatables-list.component.ts`

---

## [SYB] 요구사항정의서

> 화면 2개 롤업(소분류 SYB, 대분류 SY - 스케줄러 및 배치 작업).

### SYB-001 스케줄러 배치 작업 관리

> 원본: `fineract-backoffice-ui/src/app/features/system/scheduler-jobs/scheduler-jobs-list.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYB-001` | US1 | 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행 | `SC-001` |
| `FR-SYB-002` | US1 | 배치 작업 실행 이력(Job History) 모니터링 | `SC-002` |

#### `FR-SYB-001` 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행
- **유저 스토리 (US1)**: 담당 사용자는 스케줄러 배치 작업 관리 화면에서 스케줄러 배치 작업(Job) 크론 스케줄링 및 즉시 실행을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 이자계산, 연체평가, 자동이체 등 배치 작업 활성화/비활성화 및 즉시 실행
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYB-002` 배치 작업 실행 이력(Job History) 모니터링
- **유저 스토리 (US1)**: 담당 사용자는 스케줄러 배치 작업 관리 화면에서 배치 작업 실행 이력(Job History) 모니터링을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 배치 실행 시작/종료 시각, 처리 건수 및 오류 로그 모니터링
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### SYB-002 일마감(COB) 및 연체 관리

> 원본: `fineract-backoffice-ui/src/app/features/loans/cob-catchup/loan-cob-catchup.component.ts, fineract-backoffice-ui/src/app/features/system/delinquency/delinquency-management.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYB-003` | US2 | 일마감(COB) 배치 스텝 구성 및 실패 건 처리 | `SC-003` |
| `FR-SYB-004` | US2 | 연체 구간(Delinquency Bucket) 분류 기준 설정 | `SC-004` |

#### `FR-SYB-003` 일마감(COB) 배치 스텝 구성 및 실패 건 처리
- **유저 스토리 (US2)**: 담당 사용자는 일마감(COB) 및 연체 관리 화면에서 일마감(COB) 배치 스텝 구성 및 실패 건 처리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - COB 마감 비즈니스 스텝 순서 설정 및 미처리 대출 일괄 재처리
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYB-004` 연체 구간(Delinquency Bucket) 분류 기준 설정
- **유저 스토리 (US2)**: 담당 사용자는 일마감(COB) 및 연체 관리 화면에서 연체 구간(Delinquency Bucket) 분류 기준 설정을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 연체 일수 범위별 버킷 정의 및 대출 계좌 자동 분류
- **성공 기준 (`SC-004`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/loans/cob-catchup/loan-cob-catchup.component.ts, fineract-backoffice-ui/src/app/features/system/delinquency/delinquency-management.component.ts`
- `fineract-backoffice-ui/src/app/features/system/scheduler-jobs/scheduler-jobs-list.component.ts`

---

## [SYI] 요구사항정의서

> 화면 1개 롤업(소분류 SYI, 대분류 SY - 대외연계 및 알림/부가서비스).

### SYI-001 대외연계 및 알림 설정

> 원본: `fineract-backoffice-ui/src/app/features/system/bulk-import/bulk-import.component.ts, campaigns/email/email-campaign-form.component.ts`

#### 요구사항 목록
| 요구사항ID | 유저스토리 | 주요 기능 | 성공 기준 |
| :--- | :--- | :--- | :--- |
| `FR-SYI-001` | US1 | 엑셀/CSV 일괄 데이터 업로드(Bulk Import) | `SC-001` |
| `FR-SYI-002` | US2 | SMS / 이메일 대량 발송 캠페인 관리 | `SC-002` |
| `FR-SYI-003` | US3 | 대외 결제 연계(Interop) 식별자 관리 | `SC-003` |

#### `FR-SYI-001` 엑셀/CSV 일괄 데이터 업로드(Bulk Import)
- **유저 스토리 (US1)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 엑셀/CSV 일괄 데이터 업로드(Bulk Import)을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객, 대출, 예금, 전표 템플릿 다운로드 및 일괄 등록 파싱/검증
- **성공 기준 (`SC-001`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYI-002` SMS / 이메일 대량 발송 캠페인 관리
- **유저 스토리 (US2)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 SMS / 이메일 대량 발송 캠페인 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - 고객 타깃 그룹 및 메시지 템플릿 지정 후 자동 발송 예약
- **성공 기준 (`SC-002`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

#### `FR-SYI-003` 대외 결제 연계(Interop) 식별자 관리
- **유저 스토리 (US3)**: 담당 사용자는 대외연계 및 알림 설정 화면에서 대외 결제 연계(Interop) 식별자 관리을(를) 수행하여 업무를 처리할 수 있다.
- **기능 명세**:
  - Mojaloop 등 금융망 연계를 위한 계좌 식별자 매핑 및 연동 상태 조회
- **성공 기준 (`SC-003`)**:
  - 정상 요청 시 데이터가 정확히 처리/조회되고 화면에 오류 없이 반영된다.

### 근거
- `fineract-backoffice-ui/src/app/features/system/bulk-import/bulk-import.component.ts, campaigns/email/email-campaign-form.component.ts`
