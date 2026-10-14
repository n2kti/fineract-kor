# 00. 메뉴구조도 (Fineract 한글화)

> _DOC(문서 프로젝트) 및 이슈 프로젝트의 기준 메뉴구조도.
> 대분류(Plane Label) 2글자, 소분류(Plane Module) 3글자(대분류코드+1글자) 확정 후 화면별 spec-kit 폴더(Module)가 여기서 파생됨.
> 채번규칙: 대분류=2글자 영문 코드, 소분류=대분류코드+1글자(3글자), 화면코드=`<소분류코드>-###`.

## 대분류 (Label)

| 코드(Label) | 대분류명 | 설명 |
|---|---|---|
| `CL` | 고객관리 | 고객(개인/법인), 소액금융 그룹, 센터 및 일괄 수납 집계표 관리 |
| `LN` | 여신관리 | 대출 계좌 관리, 신청/실행, 상환 거래, 일정 재조정, 담보/보증인 및 운영 |
| `SV` | 수신관리 | 보통예금, 정기예금, 정기적금, 주식(출자금) 계좌 관리 및 거래 처리 |
| `PD` | 상품설정 | 대출/예금/적금/주식 상품, 금리 및 이자율 차트, 수수료, 세무 설정 |
| `AC` | 회계결산 | 계정과목표(COA), 분개 전표, 회계 규칙, 회계 결산, 대손충당금 및 미수수익 |
| `TR` | 이체창구 | 계좌간 이체, 정기 자동이체(SI), 지점 창구(Teller) 및 출납원(Cashier) 시재 관리 |
| `WC` | 운전자금 | 운전자금(Working Capital) 대출 계좌, 상품, 한도위반(Breach) 감지 및 사후조치 |
| `OG` | 조직관리 | 지점(Office), 직원(Staff), 통화(Currency), 자금원, 결제수단 및 계좌번호 체계 |
| `SC` | 보안승인 | 백오피스 사용자, 역할 및 권한(RBAC), 보안 정책, 감사 로그 및 결재 수신함 |
| `SY` | 시스템운영 | 공통코드, 전역 환경설정, 영업일자, 스케줄러 배치, 데이터테이블 및 대외연계 |
| `RP` | 보고서통계 | 여신/수신/회계 표준 보고서, 맞춤형 보고서 템플릿 및 사회성과(SPM) 지표 |

## 소분류 (Module = spec-kit 폴더)

| 대분류 | 코드(Module) | 소분류명 | spec-kit 폴더(예상) |
|---|---|---|---|
| `CL` | `CLA` | 고객 관리 | `specs/CLA-###-기능명/` |
| `CL` | `CLG` | 그룹 및 센터 관리 | `specs/CLG-###-기능명/` |
| `CL` | `CLS` | 일괄 수납 집계표 | `specs/CLS-###-기능명/` |
| `LN` | `LNA` | 대출 계좌 관리 | `specs/LNA-###-기능명/` |
| `LN` | `LNR` | 대출 상환 및 재조정 | `specs/LNR-###-기능명/` |
| `LN` | `LNO` | 대출 부속 및 운영 | `specs/LNO-###-기능명/` |
| `SV` | `SVA` | 보통예금 계좌 | `specs/SVA-###-기능명/` |
| `SV` | `SVF` | 정기예금 계좌 | `specs/SVF-###-기능명/` |
| `SV` | `SVR` | 정기적금 계좌 | `specs/SVR-###-기능명/` |
| `SV` | `SVS` | 주식 계좌 | `specs/SVS-###-기능명/` |
| `PD` | `PDL` | 대출 상품 설정 | `specs/PDL-###-기능명/` |
| `PD` | `PDS` | 수신 및 주식 상품 설정 | `specs/PDS-###-기능명/` |
| `PD` | `PDR` | 금리·수수료·세무 설정 | `specs/PDR-###-기능명/` |
| `AC` | `ACC` | 계정과목 및 분개장 | `specs/ACC-###-기능명/` |
| `AC` | `ACR` | 회계 규칙 및 매핑 | `specs/ACR-###-기능명/` |
| `AC` | `ACP` | 회계 결산 및 충당금 | `specs/ACP-###-기능명/` |
| `TR` | `TRA` | 계좌이체 및 자동이체 | `specs/TRA-###-기능명/` |
| `TR` | `TRT` | 창구 및 출납원 운영 | `specs/TRT-###-기능명/` |
| `WC` | `WCL` | 운전자금 대출 관리 | `specs/WCL-###-기능명/` |
| `WC` | `WCP` | 운전자금 상품 및 한도위반 설정 | `specs/WCP-###-기능명/` |
| `WC` | `WCO` | 운전자금 사후조치 및 운영 | `specs/WCO-###-기능명/` |
| `OG` | `OGB` | 지점 및 직원 관리 | `specs/OGB-###-기능명/` |
| `OG` | `OGC` | 통화 및 조직 공통설정 | `specs/OGC-###-기능명/` |
| `SC` | `SCU` | 사용자 및 권한 관리 | `specs/SCU-###-기능명/` |
| `SC` | `SCA` | 감사 로그 및 결재 수신함 | `specs/SCA-###-기능명/` |
| `SY` | `SYC` | 공통코드 및 환경설정 | `specs/SYC-###-기능명/` |
| `SY` | `SYB` | 스케줄러 및 배치 작업 | `specs/SYB-###-기능명/` |
| `SY` | `SYI` | 대외연계 및 알림/부가서비스 | `specs/SYI-###-기능명/` |
| `RP` | `RPR` | 보고서 및 조회 | `specs/RPR-###-기능명/` |
| `RP` | `RPS` | 사회성과 관리 | `specs/RPS-###-기능명/` |

## 화면 목록 (화면구조도)

| No | 화면코드 | 소분류(Module) | 대분류(Label) | 한글 화면명 | 주요 기능 및 라우트 |
|---|---|---|---|---|---|
| 1 | `CLA-001` | `CLA` | `CL` | 고객 목록 및 검색 | 고객 기본 목록 조회 및 조건별 고급 검색 (`/clients`, `/clients/search`) |
| 2 | `CLA-002` | `CLA` | `CL` | 고객 등록 및 상세정보 | 고객 신규 등록, 기본정보, KYC(신분증/주소/가족/문서) 및 계좌 현황 조회 (`/clients/create`, `/clients/view/:id`) |
| 3 | `CLG-001` | `CLG` | `CL` | 그룹 및 센터 관리 | 소액금융 그룹/센터 생성, 구성원 관리 및 모임 일정 관리 (`/groups`, `/centers`) |
| 4 | `CLS-001` | `CLS` | `CL` | 일괄 수납 집계표 | 센터/그룹 단위 대출 상환금 및 예금 일괄 수납/집계 처리 (`/collection-sheet`) |
| 5 | `LNA-001` | `LNA` | `LN` | 대출 계좌 목록 및 상세 | 대출 계좌 목록 조회, 원리금 잔액, 거래 내역 및 상환 일정표 조회 (`/loans`, `/loans/view/:id`) |
| 6 | `LNA-002` | `LNA` | `LN` | 대출 신청 및 실행 | 신규 대출 신청 접수, 승인, 실행(지급) 및 취소 처리 (`/loans/create`, `/loans/:id/transactions/disburse`) |
| 7 | `LNR-001` | `LNR` | `LN` | 대출 상환 및 거래 처리 | 대출 원리금 상환, 조기상환, 수수료 납부 및 거래 취소 (`/loans/:id/transactions/:type`) |
| 8 | `LNR-002` | `LNR` | `LN` | 대출 상환일정 재조정 | 만기 연장, 상환유예, 이자감면 등 상환일정 변경 및 재조정 신청/승인 (`/loans/:id/rescheduling`, `/loans/schedule-modify`) |
| 9 | `LNO-001` | `LNO` | `LN` | 대출 담보 및 보증인 관리 | 대출 담보물 등록/평가 및 연대보증인 등록/관리 (`/loans/:id/collateral`, `/loans/:id/guarantors`) |
| 10 | `LNO-002` | `LNO` | `LN` | 대출 일괄 재배정 및 시점조회 | 담당자별 대출 계좌 일괄 이관 및 특정 기준일자 시점별 대출 잔액/상태 조회 (`/loans/bulk-reassignment`, `/loans/point-in-time`) |
| 11 | `SVA-001` | `SVA` | `SV` | 보통예금 계좌 관리 | 보통예금 계좌 개설, 목록/상세 조회, 입출금 거래 및 지급보류 관리 (`/products/savings-accounts`, `/products/savings-accounts/view/:id`) |
| 12 | `SVF-001` | `SVF` | `SV` | 정기예금 계좌 관리 | 정기예금 계좌 개설, 만기 약정, 예치금 입금, 중도해지 및 만기해지 처리 (`/products/fixed-deposits`, `/products/fixed-deposits/view/:id`) |
| 13 | `SVR-001` | `SVR` | `SV` | 정기적금 계좌 관리 | 정기적금 계좌 개설, 월불입금 납입 처리, 자동이체 연결 및 만기 처리 (`/products/recurring-deposits`, `/products/recurring-deposits/view/:id`) |
| 14 | `SVS-001` | `SVS` | `SV` | 주식 계좌 및 배당 관리 | 조합원 주식(출자금) 계좌 개설, 주식 매수/환급 청구 및 배당금 지급 관리 (`/products/shares`, `/products/shares/view/:id`) |
| 15 | `SVA-002` | `SVA` | `SV` | 예금 수수료 및 거래 이력 | 예금 계좌 수수료 부과/면제 및 입출금 상세 거래내역 관리 (`/products/savings-accounts/:id/charges`) |
| 16 | `PDL-001` | `PDL` | `PD` | 대출 상품 관리 | 대출 상품 신규 등록, 여신 금리체계, 상환방식, 수수료 및 회계 매핑 설정 (`/products/loan`, `/products/loan/create`, `/products/loan/view/:id`) |
| 17 | `PDL-002` | `PDL` | `PD` | 대출 상품 믹스 및 모집인 | 대출 상품 간 동시취급 제한(Product Mix) 및 대출 모집인(Originator) 관리 (`/products/loan/:productId/product-mix`, `/products/loan-originators`) |
| 18 | `PDS-001` | `PDS` | `PD` | 예적금 상품 관리 | 보통예금, 정기예금, 정기적금 상품 등록, 이자 계산방식 및 예금 약관 설정 (`/products/savings`, `/products/fixed`, `/products/recurring`) |
| 19 | `PDS-002` | `PDS` | `PD` | 주식 상품 관리 | 출자금/주식 상품 등록, 1주당 액면가, 최소/최대 보유한도 및 배당 정책 설정 (`/products/share`, `/products/shares/:productId/dividends`) |
| 20 | `PDR-001` | `PDR` | `PD` | 금리·수수료·세무 설정 | 기준금리/변동금리, 이자율 차트 구간(Slabs), 수수료 규정 및 원천징수 세무그룹 설정 (`/products/rates`, `/products/interest-rate-charts`, `/products/tax-groups`) |
| 21 | `ACC-001` | `ACC` | `AC` | 계정과목표(COA) 관리 | 자산/부채/자본/수익/비용 계정과목 체계(GL Account) 트리 조회 및 등록/수정 (`/accounting/chart-of-accounts`) |
| 22 | `ACC-002` | `ACC` | `AC` | 분개 전표 조회 및 입력 | 일반/수기 분개 전표 생성, 역분개, 전표 검색 및 빈번한 전표 템플릿 관리 (`/accounting/journal-entries`, `/accounting/journal-entries/create`) |
| 23 | `ACC-003` | `ACC` | `AC` | 기초잔액 등록 | 회계 시스템 도입/이관 시 계정별 기초 개설 잔액 등록 및 확정 (`/accounting/opening-balances`) |
| 24 | `ACR-001` | `ACR` | `AC` | 회계 분개 규칙 및 매핑 | 정형 거래 분개 규칙 정의 및 금융 활동(수납/지급 등) 계정 자동 매핑 (`/accounting/rules`, `/accounting/financial-activity-mappings`) |
| 25 | `ACP-001` | `ACP` | `AC` | 회계 결산 및 대손충당금 | 회계 기간 마감(결산), 대손충당금 산출 기준/분개 생성 및 미수수익 일괄 기표 (`/accounting/closures`, `/accounting/provisioning-entries`, `/accounting/run-accruals`) |
| 26 | `TRA-001` | `TRA` | `TR` | 계좌간 이체 | 당행/고객 계좌간 자금 이체 실행 및 이체 거래 이력 조회 (`/transfers/account-transfer`, `/transfers/history`) |
| 27 | `TRA-002` | `TRA` | `TR` | 자동이체(SI) 관리 | 정기 자동이체 등록, 변경, 해지 및 자동이체 실행 이력 조회 (`/transfers/standing-instructions`, `/transfers/standing-instructions/history`) |
| 28 | `TRT-001` | `TRT` | `TR` | 창구 및 출납원 운영 | 지점 창구(Teller) 개설, 출납원(Cashier) 현금 시재 배정/회수 및 출납 마감 (`/tellers`, `/tellers/:tellerId/cashiers`) |
| 29 | `WCL-001` | `WCL` | `WC` | 운전자금 대출 관리 | 공급망/운전자금 대출 한도 조회, 대출 신청/승인 및 원리금 회수 관리 (`/working-capital/loans`, `/working-capital/loans/view/:id`) |
| 30 | `WCP-001` | `WCP` | `WC` | 운전자금 상품 및 한도위반 설정 | 운전자금 상품 정의, 차주 한도 초과/위반(Breach) 및 임박(Near-Breach) 감지 규칙 설정 (`/working-capital/loan-products`, `/working-capital/breach`, `/working-capital/near-breach`) |
| 31 | `WCO-001` | `WCO` | `WC` | 운전자금 위반 조치 관리 | 한도위반/연체 발생 계좌에 대한 거래정지, 한도축소 등 사후 조치 실행 (`/working-capital/loans/:id/breach-action`, `/working-capital/loans/:id/delinquency-action`) |
| 32 | `WCO-002` | `WCO` | `WC` | 운전자금 마감처리 및 계좌잠금 | 운전자금 일마감(COB) 배치 후속 처리 및 동시성 제어를 위한 계좌 락 관리 (`/working-capital/loans/cob-catchup`, `/working-capital/loans/account-locks`) |
| 33 | `OGB-001` | `OGB` | `OG` | 지점(Office) 관리 | 본점/지점 계층 구조 생성, 지점 정보 수정 및 지점별 상세 현황 조회 (`/organization/offices`, `/organization/offices/create`) |
| 34 | `OGB-002` | `OGB` | `OG` | 직원(Staff) 관리 | 지점별 대출/영업 담당 직원 등록, 정보 변경 및 담당자 상태 관리 (`/organization/staff`, `/organization/staff/create`) |
| 35 | `OGB-003` | `OGB` | `OG` | 지점간 거래 및 포트폴리오 요약 | 지점간 자금 이동 거래 및 지점별 여신 포트폴리오 요약 현황 (`/organization/office-transactions`, `/organization/loan-portfolio-summary`) |
| 36 | `OGC-001` | `OGC` | `OG` | 통화·자금원·계좌체계 | 다중 통화 설정, 자금원(Fund), 결제수단 및 지점/상품별 계좌번호 채번 규칙 설정 (`/organization/currencies`, `/organization/funds`, `/organization/account-number-formats`) |
| 37 | `SCU-001` | `SCU` | `SC` | 사용자 계정 관리 | 백오피스 사용자 계정 생성, 소속 지점/직원 연결, 상태 활성화/비활성화 (`/security/users`, `/security/users/create`) |
| 38 | `SCU-002` | `SCU` | `SC` | 역할 및 권한 설정 | 사용자 역할(Role) 정의, 세부 메뉴/기능 권한(Permissions) 부여 및 Maker-Checker 권한 설정 (`/security/roles`, `/system/permissions`) |
| 39 | `SCU-003` | `SCU` | `SC` | 보안 정책 및 2단계 인증 | 비밀번호 복잡도/만료 주기 정책 및 관리자 2단계 인증(2FA) 설정 (`/system/password-preferences`, `/settings/two-factor`) |
| 40 | `SCA-001` | `SCA` | `SC` | 감사 로그 및 결재 수신함 | 전체 사용자 감사 로그(Audit Trail) 조회 및 승인자(Checker) 결재 대기열 처리 (`/security/audits`, `/tasks/checker-inbox`, `/tasks/work-queues`) |
| 41 | `SYC-001` | `SYC` | `SY` | 공통 코드 및 확장 데이터 | 시스템 공통 코드/코드값 관리 및 고객/대출 연계 사용자정의 데이터테이블(DataTables) 설정 (`/system/codes`, `/system/data-tables`) |
| 42 | `SYC-002` | `SYC` | `SY` | 환경설정 및 영업일 관리 | 글로벌 파라미터, 시스템 영업일자(Business Date) 및 영업일/휴일 캘린더 관리 (`/settings/configurations`, `/system/business-dates`, `/settings/holidays`, `/settings/working-days`) |
| 43 | `SYB-001` | `SYB` | `SY` | 스케줄러 배치 작업 관리 | 일/월마감 배치 작업 스케줄링, 수동 즉시 실행 및 작업 실행 이력 모니터링 (`/system/scheduler-jobs`, `/admin/inline-job`, `/system/scheduler-jobs/:id/history`) |
| 44 | `SYB-002` | `SYB` | `SY` | 일마감(COB) 및 연체 관리 | 여신 일마감(COB) 미처리 건 추적/실행 및 연체 구간(Delinquency Bucket) 분류 기준 설정 (`/loans/cob-catchup`, `/system/delinquency`, `/admin/cob-tools`) |
| 45 | `SYI-001` | `SYI` | `SY` | 대외연계 및 알림 설정 | 웹훅(Hooks), 외부 이벤트, 일괄 데이터 업로드(Bulk Import), SMS/이메일 캠페인 및 대외 결제 연계(Interop) (`/system/hooks`, `/system/external-events`, `/system/bulk-import`, `/campaigns/email`, `/interop/parties`) |
| 46 | `RPR-001` | `RPR` | `RP` | 보고서 조회 및 실행 | 여신, 수신, 회계 등 표준 보고서 카테고리별 조회 및 파라미터 조건 실행/다운로드 (`/reporting`, `/reporting/run/:reportName`) |
| 47 | `RPR-002` | `RPR` | `RP` | 보고서 정의 및 메일링 작업 | 커스텀 SQL/Pentaho 보고서 템플릿 등록, 자동 메일링 스케줄 및 임의 질의(Ad-Hoc Query) 관리 (`/system/report-definitions`, `/system/report-mailing-jobs`, `/system/adhoc-query`) |
| 48 | `RPS-001` | `RPS` | `RP` | 사회성과(SPM) 지표 관리 | 사회성과 설문조사 등록, 빈곤선(Poverty Line) 기준값, 빈곤 확률 산출 및 설문 응답 결과 분석 (`/spm/surveys`, `/spm/poverty-line`, `/spm/likelihood`, `/spm/survey-responses`) |

## 사용 규칙 (이번 세션 확정)

- 대분류 = Plane **Label**(2글자 코드), 소분류(=화면/업무단위 하나) = Plane **Module**(대분류코드+1글자), 양쪽 모두 이슈 프로젝트·문서 프로젝트(`_DOC`) 공통 적용.
- spec-kit 폴더명 컨벤션: `specs/<소분류코드>-###-기능명/`(예: `specs/LNA-001-대출계좌목록조회/`) — sync 명령이 이 폴더명에서 Label(앞 2글자)/Module(전체 소분류코드)을 파싱하여 자동 동기화.
- 이 메뉴구조도가 기준(정본): 화면이 이슈로 등록돼도 이 표에 이미 있는 소분류면 메뉴구조도 자체는 안 바뀜(진행상태만 이슈쪽에 표시). 계획에 없던 소분류가 새로 나오면 그때 이 표에 행을 추가.
- 배치(비-UI 작업, 예: COB 마감 배치, 스케줄러 작업 등)도 소분류 표에 동일하게 한 행으로 등록 가능(화면 아니어도 소분류코드+Module 규칙 그대로 적용).
