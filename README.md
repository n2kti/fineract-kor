# fineract-kor

> **비공식 포크.** Apache Fineract 의 한국어화·검증 하네스 실험 저장소이며 Apache Software Foundation 과 무관하다. "Apache Fineract" 는 ASF 의 상표다.
> Unofficial fork of Apache Fineract. Not affiliated with or endorsed by the Apache Software Foundation.

- `backend/` — Apache Fineract (Java 17, Gradle, 빌드는 JDK 21)
- `ui/` — Apache Fineract Backoffice UI (Angular, Ionic), 한국어 번역 추가
- `specs/`, `docs/`, `rollup/`, `00_MENU_FN.md` — 화면 스펙·메뉴 구조
- `openwiki/` — 도메인 위키
- 출처 커밋과 변경 파일: [UPSTREAM.md](UPSTREAM.md). 라이선스: Apache-2.0 ([LICENSE](LICENSE), [NOTICE](NOTICE)).

## 검증
- 커밋 전: `git config core.hooksPath hooks` — `hooks/pre-commit` 이 바뀐 Java·TS 파일을 Semgrep 으로 검사.
- PR: `.github/workflows/ci.yml` — 백엔드 테스트 + Semgrep(PR 이 새로 만든 문제만, 발견 시 실패).
