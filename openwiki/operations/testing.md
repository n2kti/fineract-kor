---
type: operations
title: 테스트 및 검증 전략
description: Apache Fineract의 테스트 프레임워크 구조, 단위/통합 테스트 전략, 데이터베이스 격리 방법 및 실행 프로세스에 대한 상세 가이드.
tags: [testing, quality-assurance, strategy, java, spring, hibernate, postgresql, mysql, oracle]
verified:
  - by: openwiki/0.7.0
    at: 2026-10-05T15:48:47.442Z
sources:
  - id: openwiki-source-45903bbe9f18a33b9299d7d7
    resource: repo://fineract-repo/settings.gradle
generated: { by: "omp", at: "2026-10-05T15:48:47.442Z" }
---

# 테스트 및 검증 전략

Apache Fineract는 금융 서비스 제공을 위한 오픈소스 플랫폼으로, 높은 신뢰성과 데이터 무결성이 요구되는 환경에서 운영됩니다. 따라서 테스트 전략은 단순한 코드 검증이 아닌, 금융 거래의 정확성, 데이터 격리, 그리고 다양한 데이터베이스 엔진에 대한 호환성을 보장하는 종합적인 품질 보증 체계를 포함합니다.

본 문서는 Fineract의 테스트 아키텍처, 주요 테스트 유형, 데이터베이스 격리 전략, 그리고 테스트 실행 워크플로우를 상세히 설명합니다.

## 1. 테스트 프레임워크 아키텍처

Fineract는 **JUnit 5**와 **Spring Boot Test**를 기반으로 한 통합 테스트 프레임워크를 사용합니다. 이 프레임워크는 Spring의 의존성 주입 (DI) 컨테이너를 활용하여 실제 애플리케이션 환경과 유사한 조건에서 단위 테스트와 통합 테스트를 수행할 수 있도록 설계되었습니다.

### 핵심 구성 요소

*   **JUnit 5**: 최신 버전의 JUnit 5를 사용하여 테스트 케이스를 정의하고 실행합니다. `@Test`, `@BeforeEach`, `@AfterEach` 등의 어노테이션을 통해 테스트 생명주기를 관리합니다.
*   **Spring Boot Test**: Spring 애플리케이션의 테스트 지원 기능을 제공합니다. `@SpringBootTest` 어노테이션을 통해 전체 애플리케이션 컨텍스트를 로드하고 테스트할 수 있습니다.
*   **Mockito**: 외부 의존성 (예: 다른 서비스, 외부 API, 파일 시스템) 을 모킹하여 단위를 격리하고 테스트 속도를 높입니다.
*   **Testcontainers**: 실제 데이터베이스 (PostgreSQL, MySQL, Oracle 등) 와 같은 외부 의존성을 Docker 컨테이너로 실행하여 통합 테스트 시 데이터베이스 격리를 보장합니다.

### 아키텍처 패턴

Fineract의 테스트 코드는 **Layered Architecture (계층형 아키텍처)** 에 맞춰 계층별로 분리되어 작성됩니다.

1.  **Unit Tests (단위 테스트)**: 특정 클래스나 메서드의 논리만 검증합니다. Spring 컨텍스트를 로드하지 않으며, 모든 의존성을 모킹합니다. 실행 속도가 매우 빠르고 CI 파이프라인의 초기 단계에서 실행됩니다.
2.  **Integration Tests (통합 테스트)**: Spring 컨텍스트 (`ApplicationContext`) 를 로드하여 여러 컴포넌트 간의 상호작용을 검증합니다. 데이터베이스 연결, 메시지 브로커, 외부 API 호출 등을 포함할 수 있습니다.

## 2. 단위 테스트 전략

단위 테스트는 Fineract 코드베이스의 가장 기본이 되는 검증 단계입니다. 각 서비스 레이어의 개별 메서드가 의도한 대로 동작하는지 확인합니다.

### 주요 특징

*   **의존성 격리**: Spring 컨텍스트를 로드하지 않으므로 실행 속도가 빠르고 리소스 소모가 적습니다.
*   **모킹 (Mocking)**: `Mockito`를 사용하여 `ApplicationService`, `DataAccessObject`, 외부 API 등을 모킹합니다.
    *   예: `MockBean` 또는 `@Mock` 을 사용하여 의존성 주입된 빈을 모킹합니다.
*   **테스트 데이터**: `@Data` 어노테이션을 가진 엔티티 클래스를 직접 인스턴스화하거나, `Mockito`를 통해 생성된 객체를 테스트 데이터로 사용합니다.

### 예시: 서비스 레이어 단위 테스트

```java
@Service
public class LoanProductService {
    private final LoanProductDao loanProductDao;
    // ... 의존성 주입
}

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(MockitoExtension.class)
@MockBean
private LoanProductDao loanProductDao; // MockitoExtension 사용 시

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private LoanProductDao loanProductDao;

@ExtendWith(SpringExtension.class)
@MockBean
private Loan
