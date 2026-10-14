---
type: "참조"
title: "Apache Fineract Quick Start"
openwiki_generated: true
verified:
  - by: openwiki/0.7.0
    at: 2026-10-05T10:52:04.485Z
sources:
  - id: openwiki-source-394c8e0099f5b36d7fe35b65
    resource: repo://fineract-repo/README.md
generated: { by: "antigravity", at: "2026-10-05T10:52:04.485Z" }
---

# Apache Fineract Quick Start

Apache Fineract 는 분산형 금융 서비스 플랫폼으로, 금융 기관이 대출, 예금, 결제, 보고 등의 금융 거래를 관리할 수 있도록 설계된 오픈소스 솔루션입니다.

## 설치

### 요구 사항

- Java 11 이상
- Maven 3.6 이상
- H2 데이터베이스 (데모용) 또는 PostgreSQL, MySQL, Oracle 등

### 설치 방법

#### 1. Maven 프로젝트 클론

```bash
git clone https://github.com/Fineract/fineract.git
cd fineract
```

#### 2. 빌드

```bash
mvn clean install -DskipTests
```

#### 3. 애플리케이션 실행

```bash
java -jar target/fineract-app-*.jar
```

## 기본 사용법

### 1. 애플리케이션 시작

```bash
java -jar target/fineract-app-*.jar --spring.profiles.active=dev
```

### 2. 데이터베이스 연결

애플리케이션을 시작할 때 데이터베이스 연결 정보를 설정해야 합니다:

```bash
java -jar target/fineract-app-*.jar \
  --spring.datasource.url=jdbc:h2:mem:fineract \
  --spring.datasource.driver-class-name=org.h2.Driver \
  --spring.datasource.username=sa \
  --spring.datasource.password=sa
```

### 3. 초기 데이터 로드

```bash
java -jar target/fineract-app-*.jar \
  --spring.datasource.url=jdbc:h2:mem:fineract \
  --spring.datasource.driver-class-name=org.h2.Driver \
  --spring.datasource.username=sa \
  --spring.datasource.password=sa \
  --data-loader.initialize
```

## API 사용

Fineract 는 RESTful API 를 제공합니다. 다음 명령어로 API 를 호출할 수 있습니다:

```bash
curl -X GET http://localhost:8080/fineract/members/v1/members
```

## 개발 환경 설정

### IDE 설정

IntelliJ IDEA 또는 Eclipse 를 사용하여 개발할 수 있습니다.

### 로컬 개발 서버

```bash
mvn spring-boot:run -pl :fineract-app
```

## 추가 정보

<!-- openwiki: broken internal link [./architecture/overview.md] file "./architecture/overview.md" does not exist. Fix the href or restore the target, then delete this comment. -->
- [Architecture Overview](./architecture/overview.md)
<!-- openwiki: broken internal link [./backend/overview.md] file "./backend/overview.md" does not exist. Fix the href or restore the target, then delete this comment. -->
- [Backend Overview](./backend/overview.md)
<!-- openwiki: broken internal link [./backend/commands-events.md] file "./backend/commands-events.md" does not exist. Fix the href or restore the target, then delete this comment. -->
- [Backend Commands & Events](./backend/commands-events.md)
<!-- openwiki: broken internal link [./backend/organization-client.md] file "./backend/organization-client.md" does not exist. Fix the href or restore the target, then delete this comment. -->
- [Backend Organization & Client](./backend/organization-client.md)
<!-- openwiki: broken internal link [./backend/security.md] file "./backend/security.md" does not exist. Fix the href or restore the target, then delete this comment. -->
- [Backend Security](./backend/security.md)
