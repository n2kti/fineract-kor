---
type: technical-guide
title: 테넌시 및 마이그레이션 (Tenancy and Migrations)
description: Apache Fineract 의 멀티테넌시 아키텍처, Liquibase 를 통한 스키마 마이그레이션 전략, 그리고 데이터베이스 라우팅 메커니즘에 대한 상세 기술 문서입니다.
tags: [fineract, backend, tenancy, migrations, liquibase, database-routing, architecture]
verified:
  - by: openwiki/0.7.0
    at: 2026-10-05T15:48:47.442Z
sources:
  - id: openwiki-source-25b774cf530ec842329732f1
    resource: repo://fineract-repo/fineract-core/src/main/java/org/apache/fineract/infrastructure/core/service/migration/TenantDataSourceFactory.java
generated: { by: "omp", at: "2026-10-05T15:48:47.442Z" }
---

# 테넌시 및 마이그레이션

Apache Fineract 는 멀티테넌시 (Multi-tenancy) 를 핵심 아키텍처 원칙으로 채택한 금융 관리 플랫폼입니다. 이 문서에서는 Fineract 의 테넌시 관리 구조, 데이터베이스 마이그레이션 파이프라인 (Liquibase), 그리고 동적 데이터베이스 라우팅 전략을 상세히 설명합니다.

## 1. 멀티테넌시 아키텍처

Fineract 는 **데이터베이스 레벨 (Database-level)** 에서 테넌시를 구현합니다. 각 테넌시 (기관/기관 그룹) 는 독립적인 데이터베이스 스키마를 가지며, 이는 데이터 격리, 보안, 그리고 성능 최적화를 보장합니다.

### 1.1 논리적 및 물리적 구조

Fineract 의 테넌시는 계층적 구조로 정의됩니다.

*   **Tenant Group (테넌시 그룹):** 상위 조직 단위 (예: 은행 그룹, 협력사).
*   **Tenant (테넌시):** 실제 운영 단위 (예: 본점, 지점).

각 테넌시는 고유한 식별자 (`tenantId`) 를 가지며, 이 ID 는 모든 데이터베이스 테이블의 `tenant_id` 컬럼에 저장되어 데이터 격리를 수행합니다.

### 1.2 데이터베이스 스키마 분리 전략

Fineract 는 스키마를 물리적으로 분리하지 않고, **테이블 내 `tenant_id` 컬럼**을 통해 논리적으로 격리하는 방식을 주로 사용합니다. 그러나 특정 상황 (예: 매우 큰 규모의 데이터 양) 에 따라 물리적 스키마 분리가 가능하도록 설계되었습니다.

*   **공유 스키마, 논리적 격리:** 모든 테넌시가 같은 물리적 데이터베이스를 공유하지만, 쿼리 시 `tenant_id` 필터링을 통해 데이터를 분리합니다. 이는 유지보수 비용을 줄이고 스키마 마이그레이션을 간소화합니다.
*   **물리적 격리 (선택 사항):** 특정 테넌시 그룹에 대해 별도의 물리적 데이터베이스를 할당할 수 있습니다. 이 경우 Fineract 의 라우팅 로직이 변경되어야 합니다.

### 1.3 주요 엔티티 및 클래스 구조

`fineract-repo/fineract-provider` 모듈 내의 주요 클래스들은 테넌시 컨텍스트를 인식하도록 설계되었습니다.

*   **`Tenant` 엔티티:** 테넌시의 기본 정보를 저장합니다.
    *   `tenantId`: 고유 식별자 (UUID).
    *   `tenantGroupId`: 부모 테넌시 그룹 ID.
    *   `tenantCode`: 테넌시 코드 (예: `FINERACT`, `BRANCH001`).
    *   `status`: 테넌시 상태 (예: `ACTIVE`, `INACTIVE`).
*   **`TenantGroup` 엔티티:** 테넌시 그룹의 정보를 저장합니다.
    *   `tenantGroupId`: 고유 식별자.
    *   `tenantGroupName`: 그룹 이름.
    *   `status`: 그룹 상태.

### 1.4 테넌시 컨텍스트 관리

애플리케이션 실행 시, 현재 세션이 어떤 테넌시에서 실행되는지 명시해야 합니다.

*   **API 호출 시 헤더:** `X-Tenant-Id` 헤더를 통해 클라이언트가 현재 테넌시를 명시합니다.
*   **API 호출 시 쿼리 파라미터:** `tenantId` 파라미터를 통해 명시합니다.
*   **API 호출 시 인증 토큰:** JWT 토큰에 테넌시 정보가 포함될 수 있습니다.

Fineract 는 이 정보를 기반으로 현재 실행 컨텍스트를 결정하고, 모든 데이터베이스 쿼리에 해당 `tenant_id` 를 자동으로 추가합니다.

## 2. 데이터베이스 마이그레이션 파이프라인 (Liquibase)

Fineract 는 **Liquibase** 를 사용하여 데이터베이스 스키마의 버전 관리와 마이그레이션을 관리합니다. 이는 개발, 테스트, 프로덕션 환경 간의 스키마 일관성을 보장하는 핵심 메커니즘입니다.

### 2.1 Liquibase 구조

Fineract 의 Liquibase 스크립트는 계층적으로 조직화되어 있습니다.

*   **`fineract-repo/fineract-provider`**: 실제 비즈니스 로직과 관련된 스키마 변경 사항이 정의됩니다.
*   **`fineract-repo/fineract-provider/src/main/resources/db/changeLog`**: Liquibase 변경 로그 파일들이 저장됩니다.

### 2.2 변경 로그 파일 (ChangeLog Files)

각 변경 로그 파일은 특정 버전의 변경 사항을 포함합니다. 파일명은 일반적으로 `YYYYMMDD-HHMMSS-changelog.sql` 형식을 따릅니다.

*   **`db.changelog-master.xml`**: 마스터 변경 로그 파일로, 하위 모든 변경 로그를 포함합니다.
*   **하위 변경 로그:** 특정 기능 추가, 수정, 삭제에 대한 SQL 스크립트들이 XML 또는 SQL 형식으로 정의됩니다.

### 2.3 테넌시 고려사항

Liquibase 스크립트는 테넌시 구조를 반영하여 작성됩니다.

*   **테넌시 테이블 생성:** `tenant` 과 `tenant_group` 테이블은 초기 스키마 설정 시 생성됩니다.
*   **테넌시 컬럼 추가:** 기존 테이블에 `tenant_id` 컬럼을 추가하는 스크립트는 마이그레이션 과정에서 순차적으로 적용됩니다.
*   **테넌시 데이터 이동:** 기존 데이터에 `tenant_id` 를 할당하는 스크립트는 마이그레이션 시 실행됩니다.

### 2.4 마이그레이션 실행 흐름

1.  **스냅샷 생성:** Liquibase 는 현재 데이터베이스 스키마의 스냅샷을 생성합니다.
2.  **차이점 분석:** 마스터 변경 로그와 현재 스냅샷을 비교하여 미적용 변경 사항을 찾습니다.
3.  **적용:** 미적용 변경 로그를 순차적으로 데이터베이스에 적용합니다.
4.  **테넌시 데이터 마이그레이션:** 기존 테넌시 데이터 (테이블에 저장된 데이터) 를 새로운 테넌시 구조로 이동합니다.

### 2.5 마이그레이션 스크립트 예시

테넌시 관련 마이그레이션은 일반적으로 다음과 같은 단계로 수행됩니다.

```sql
-- 1. 테넌시 그룹 테이블 생성
CREATE TABLE tenant_group (
    tenant_group_id BIGINT NOT NULL,
    tenant_group_name VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (tenant_group_id)
);

-- 2. 테넌시 테이블 생성
CREATE TABLE tenant (
    tenant_id BIGINT NOT NULL,
    tenant_group_id BIGINT NOT NULL,
    tenant_code VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    PRIMARY KEY (tenant_id),
    FOREIGN KEY (tenant_group_id) REFERENCES tenant_group(tenant_group_id)
);

-- 3. 기존 테이블에 tenant_id 컬럼 추가 (테넌시 컬럼 추가)
ALTER TABLE account ADD tenant_id BIGINT;
ALTER TABLE loan ADD tenant_id BIGINT;
-- ... 기타 테이블에 tenant_id 추가

-- 4. 기존 데이터에 tenant_id 할당 (테넌시 데이터 이동)
-- 예: 기존 account 데이터를 tenant_id 가 있는 데이터로 이동
UPDATE account a
SET tenant_id = (
    SELECT tenant_id FROM tenant t
    WHERE t.tenant_code = a.tenant_code
    LIMIT 1
);
```

## 3. 데이터베이스 라우팅 분석

Fineract 는 동적 데이터베이스 라우팅을 지원하여, 테넌시 ID 에 따라 적절한 데이터베이스를 선택하거나 쿼리 조건을 동적으로 변경합니다.

### 3.1 라우팅 전략

Fineract 는 주로 **JDBC 커넥션 풀 (Connection Pool)** 을 사용하여 데이터베이스 라우팅을 관리합니다.

*   **공유 데이터베이스:** 모든 테넌시가 같은 데이터베이스를 공유합니다. 이 경우, 라우팅은 쿼리 수준에서 수행됩니다.
*   **물리적 데이터베이스 분리:** 각 테넌시 그룹이 별도의 데이터베이스를 가질 수 있습니다. 이 경우, JDBC 커넥션 풀 설정에 따라 테넌시 그룹에 따라 다른 데이터베이스를 연결합니다.

### 3.2 JDBC 커넥션 풀 설정

Fineract 는 `fineract-provider` 모듈의 `DatabaseConfiguration` 클래스를 사용하여 데이터베이스 연결을 관리합니다.

*   **`DatabaseConfiguration` 클래스:** 데이터베이스 연결 정보를 저장합니다.
    *   `databaseType`: 데이터베이스 타입 (예: `MYSQL`, `POSTGRESQL`).
    *   `databaseName`: 데이터베이스 이름.
    *   `databaseHost`: 데이터베이스 호스트.
    *   `databasePort`: 데이터베이스 포트.
    *   `databaseUsername`: 데이터베이스 사용자 이름.
    *   `databasePassword`: 데이터베이스 비밀번호.

### 3.3 동적 라우팅 로직

Fineract 는 테넌시 ID 를 기반으로 데이터베이스 이름을 동적으로 결정합니다.

*   **테넌시 그룹별 데이터베이스:** 각 테넌시 그룹은 고유한 데이터베이스 이름을 가질 수 있습니다.
    *   예: `fineract_group_1`, `fineract_group_2`.
*   **테넌시별 데이터베이스:** 각 테넌시는 고유한 데이터베이스 이름을 가질 수 있습니다.
    *   예: `fineract_tenant_1`, `fineract_tenant_2`.

### 3.4 데이터베이스 라우팅 다이어그램

다음 다이어그램은 Fineract 의 데이터베이스 라우팅 구조를 보여줍니다.

```mermaid
graph TD
    Client[클라이언트] --> API[API Gateway]
    API --> Auth[인증/인가]
    
    subgraph TenantContext[테넌시 컨텍스트]
        Auth --> TenantService[테넌시 서비스]
        TenantService --> Tenant[테넌시 엔티티]
        Tenant --> TenantGroup[테넌시 그룹 엔티티]
    end
    
    subgraph DatabaseRouting[데이터베이스 라우팅]
        TenantContext --> RoutingLogic[라우팅 로직]
        RoutingLogic --> DBPool[JDBC 커넥션 풀]
        
        DBPool --> DB1[데이터베이스 1 (테넌시 그룹 1)]
        DBPool --> DB2[데이터베이스 2 (테넌시 그룹 2)]
        
        DB1 --> Schema1[스키마 1]
        DB2 --> Schema2[스키마 2]
    end
    
    subgraph Application[애플리케이션]
        DBPool --> Repository[리포지토리 레이어]
        Repository --> Service[서비스 레이어]
        Service --> Controller[컨트롤러 레이어]
    end
    
    Application --> Client
```

### 3.5 데이터베이스 라우팅 구현 예시

Fineract 는 `TenantDatabaseResolver` 와 같은 클래스를 사용하여 테넌시 ID 를 기반으로 데이터베이스 이름을 결정합니다.

```java
public class TenantDatabaseResolver {
    private final Map<String, String> tenantDatabaseMapping; // 테넌시 ID -> 데이터베이스 이름

    public String resolveDatabase(String tenantId) {
        // 테넌시 ID 를 기반으로 데이터베이스 이름을 결정하는 로직
        // 예: "fineract_" + tenantId
        return tenantDatabaseMapping.getOrDefault(tenantId, "fineract_default");
    }
}
```

## 4. 비즈니스 규칙 및 제약 사항

Fineract 의 테넌시 및 마이그레이션은 다음과 같은 비즈니스 규칙과 제약 사항을 따릅니다.

### 4.1 데이터 격리

*   **테넌시 데이터 격리:** 각 테넌시의 데이터는 다른 테넌시와 격리되어야 합니다.
*   **테넌시 그룹 데이터 격리:** 테넌시 그룹의 데이터는 다른 테넌시 그룹과 격리되어야 합니다.

### 4.2 데이터 마이그레이션 규칙

*   **순차적 마이그레이션:** 마이그레이션 스크립트는 순차적으로 실행되어야 합니다.
*   **테넌시 데이터 이동:** 기존 테넌시 데이터는 새로운 테넌시 구조로 이동되어야 합니다.
*   **데이터 무결성:** 마이그레이션 과정에서 데이터 무결성이 유지되어야 합니다.

### 4.3 성능 최적화

*   **인덱싱:** 테넌시 ID 를 기반으로 인덱싱을 수행하여 쿼리 성능을 최적화합니다.
*   **데이터 분할:** 대용량 데이터를 여러 테넌시 데이터베이스로 분할하여 성능을 최적화합니다.

### 4.4 보안

*   **접근 제어:** 각 테넌시는 자신의 데이터만 접근할 수 있어야 합니다.
*   **암호화:** 민감한 데이터는 암호화되어야 합니다.

## 5. 결론

Apache Fineract 는 강력한 멀티테넌시 아키텍처와 Liquibase 를 통한 효율적인 마이그레이션 파이프라인을 제공합니다. 이는 금융 기관의 복잡한 요구 사항을 충족하고, 데이터 격리, 보안, 성능 최적화를 보장합니다.

Fineract 의 테넌시 및 마이그레이션 구조를 이해하는 것은 플랫폼을 효과적으로 사용하고 유지보수하는 데 필수적입니다. 특히, 데이터베이스 라우팅과 마이그레이션 스크립트 관리에 주의를 기울여야 합니다.
