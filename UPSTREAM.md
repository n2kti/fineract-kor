# Fineract-Kor 단일 저장소 업스트림 및 출처 기록 (UPSTREAM.md)

이 저장소(`fineract-kor`)는 Apache Fineract와 Backoffice UI를 단일 모노레포 구조로 통합한 한글화 및 하네스 실전 대상 저장소입니다.

## 1. 컴포넌트별 출처 및 기준 커밋

| 컴포넌트 | 경로 | 출처 리포지토리 | 브랜치 / 기준 커밋 | 비고 |
|---|---|---|---|---|
| **Backend** | `backend/` | `apache/fineract` | develop (`c8b48ee8da3aaa135f7d327bf4e09bfa917e8c13`) | Java 17 / Gradle 백엔드 |
| **Frontend** | `ui/` | `apache/fineract-backoffice-ui` | main (`505f52d52e52781e589eea074c289ed2513576f3`) | Angular 22 / Ionic UI |
| **OpenWiki** | `openwiki/` | `fineract-omp` | main (`cb2ca3a`, 위키 기준 `25eadc5`) | 로컬 Qwen 9B 18개 도메인 위키 |
| **Specs** | `specs/` | `fineract/specs` | 로컬 정본 | 대출 도메인 스펙 FN-001 ~ FN-007 |
| **Docs** | `docs/`, `rollup/` | `fineract-kor` | 로컬 정본 | 메뉴 구조도(`00_MENU_FN.md`) 및 122개 화면 분석 |

## 2. 로컬 변경 사항 (Customizations)
- **UI 번역 (`ui/src/assets/i18n/ko.json`)**: 메뉴 및 주요 화면 한글화 번역 적용.
- **빌드 (`backend/gradle/wrapper/gradle-wrapper.jar`, `backend/.gitignore`)**: 원본 `.gitignore` 의 `*.jar` 때문에 빠지는 wrapper jar 를 추적.
- **하네스 (`.planespec.json`, `hooks/`, `semgrep/`, `.github/`)**: 이 저장소에서 추가.

## 3. 실행 요구
- 백엔드 빌드·테스트는 **JDK 21 이상** 필요(빌드 플러그인 요구). 예: `JAVA_HOME=$(brew --prefix openjdk@21)/libexec/openjdk.jdk/Contents/Home`.
- 하네스 설정은 `.planespec.json`(planespec `verify_gate`·`verify_llm` 이 읽음). 보호 경로라 변경은 사람 승인 대상.
