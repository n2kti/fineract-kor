---
type: api-reference
title: API 및 이벤트 계약 규격
description: Apache Fineract의 REST API 엔드포인트, 에러 응답 포맷, 외부 웹훅 및 비즈니스 이벤트 명세를 정의하는 기술 문서입니다.
tags: [api, events, contracts, fineract-provider, integration]
verified:
  - by: openwiki/0.7.0
    at: 2026-10-05T15:48:47.442Z
sources:
  - id: openwiki-source-e34f6e35611416783059f722
    resource: repo://fineract-repo/fineract-provider/src/main/java/org/apache/fineract/ServerApplication.java
generated: { by: "omp", at: "2026-10-05T15:48:47.442Z" }
---

# API 및 이벤트 계약 규격

Apache Fineract는 금융 서비스 제공을 위한 오픈소스 플랫폼으로, 외부 시스템과의 통합을 위해 일관된 API 계약과 이벤트 메커니즘을 제공합니다. 본 문서는 `fineract-provider` 모듈에 정의된 REST API 규격, 표준 에러 응답 형식, 그리고 외부 시스템으로 방출되는 비즈니스 이벤트(웹훅) 명세를 상세히 기술합니다.

## 1. REST API 엔드포인트 규격

Fineract의 REST API는 HTTP 메서드와 URI 패턴을 통해 리소스에 대한 CRUD(생성, 조회, 수정, 삭제) 연산을 수행합니다. 모든 API 호출은 JSON 형식의 요청 본문과 응답을 사용합니다.

### 1.1. 기본 URI 패턴

API 엔드포인트는 다음 패턴을 따릅니다. 각 `{entityId}`는 해당 엔티티의 고유 식별자 (UUID) 입니다.

```text
/api/v1/{entityType}/{entityId}
```

*   **`entityType`**: 리소스 타입 (예: `loan`, `savingsAccount`, `customer`, `product`).
*   **`entityId`**: 리소스 고유 ID (UUID).

### 1.2. HTTP 메서드 및 동작

| HTTP 메서드 | 동작 설명 | 예시 엔드포인트 |
| :--- | :--- | :--- |
| **POST** | 새로운 리소스 생성 또는 데이터 제출 | `/api/v1/loans` (새 대출 생성)<br>`/api/v1/loans/{loanId}/disbursements` (대출금 지급) |
| **GET** | 리소스 또는 필터링된 리소스 목록 조회 | `/api/v1/loans/{loanId}` (특정 대출 조회)<br>`/api/v1/loans` (모든 대출 목록) |
| **PUT** | 기존 리소스 전체 업데이트 | `/api/v1/loans/{loanId}` (대출 정보 전체 수정) |
| **PATCH** | 기존 리소스 부분 업데이트 | `/api/v1/loans/{loanId}` (대출금리만 수정) |
| **DELETE** | 리소스 삭제 | `/api/v1/loans/{loanId}` (대출 삭제) |

### 1.3. 헤더 (Headers) 규격

모든 API 요청은 다음 표준 헤더를 포함해야 합니다.

*   **`Content-Type`**: `application/json` (필수)
*   **`Accept`**: `application/json` (필수)
*   **`X-Auth-Token`**: 인증 토큰 (필수). 로그인 후 발급된 토큰입니다.
*   **`X-Request-Id`**: (선택 사항) 클라이언트에서 생성한 고유 요청 ID. 트래블로그 추적에 유용합니다.

### 1.4. 요청 본문 (Request Body) 구조

POST, PUT, PATCH 요청 시 본문은 다음 구조를 따릅니다.

```json
{
  "entityId": "uuid-string", // PUT/PATCH 시에만 포함
  "entityIdType": "UUID",   // PUT/PATCH 시에만 포함
  "locale": "ko_KR",        // 기본값: en_US
  "currency": "KRW",       // 통화 코드
  "data": {
    // 엔티티별 속성 정의 (예: 대출 생성 시)
    "principal": 1000000,
    "interestRate": 5.5,
    "repaymentFrequency": "MONTHLY"
  }
}
```

*   **`entityId`**: 업데이트할 경우에만 포함해야 합니다.
*   **`locale`**: 응답 언어 및 날짜/숫자 포맷을 결정합니다.
*   **`currency`**: 해당 엔티티의 기본 통화입니다.

### 1.5. 응답 본문 (Response Body) 구조

성공적인 요청 (HTTP 2xx) 에 대한 응답은 다음 구조를 따릅니다.

```json
{
  "id": "uuid-string",
  "type": "ENTITY_TYPE",
  "locale": "ko_KR",
  "currency": "KRW",
  "data": {
    // 엔티티의 현재 상태 및 속성
    "principal": 1000000,
    "interestRate": 5.5,
    "repaymentFrequency": "MONTHLY",
    "status": "ACTIVE"
  },
  "meta": {
    "version": 1,
    "lastModifiedBy": "userId",
    "lastModifiedOn": "2023-10-27T10:00:00.000Z"
  }
}
```

*   **`id`**: 생성된 리소스 또는 조회된 리소스의 UUID.
*   **`type`**: 리소스 타입 (예: `LOAN`).
*   **`data`**: 실제 비즈니스 데이터.
*   **`meta`**: 메타데이터 (버전, 수정자, 수정일).

## 2. 에러 응답 포맷

API 호출 중 오류가 발생하면 HTTP 상태 코드와 함께 표준화된 에러 응답이 반환됩니다.

### 2.1. HTTP 상태 코드

*   **200, 201, 204**: 성공 (데이터 반환 또는 생성 성공 또는 변경 없음).
*   **400**: 잘못된 요청 (Bad Request). 유효성 검사 실패, 필수 필트 누락 등.
*   **401**: 인증 실패 (Unauthorized). 유효하지 않은 토큰 또는 만료된 토큰.
*   **403**: 권한 없음 (Forbidden). 해당 리소스에 대한 접근 권한이 없음.
*   **404**: 리소스 없음 (Not Found). 요청한 ID 가 존재하지 않음.
*   **409**: 충돌 (Conflict). 동시성 문제 (예: 대출이 이미 지급됨).
*   **500**: 서버 오류 (Internal Server Error). 예외 발생.

### 2.2. 에러 응답 본문 구조

에러 응답은 다음 JSON 구조를 따릅니다.

```json
{
  "error": {
    "code": "ERROR_CODE",
    "status": 400,
    "message": "에러 메시지 (사용자 친화적)",
    "defaultMessage": "에러 메시지 (개발자용)",
    "details": [
      {
        "field": "fieldName",
        "message": "필드별 상세 에러 메시지"
      }
    ],
    "trace": "스택 트레이스 (디버깅용, 프로덕션에서는 숨김 가능)",
    "timestamp": "2023-10-27T10:00:00.000Z"
  }
}
```

*   **`code`**: Fineract 내부 에러 코드 (예: `INVALID_LOAN_PRODUCT`, `LOAN_ALREADY_DISBURSED`).
*   **`status`**: HTTP 상태 코드.
*   **`message`**: 클라이언트에 표시될 읽기 쉬운 메시지.
*   **`details`**: 유효성 검사 오류 등 구체적인 필드별 에러 목록.
*   **`trace`**: 예외의 스택 트레이스. 보안상 프로덕션 환경에서는 비활성화될 수 있습니다.

## 3. 외부 웹훅 및 비즈니스 이벤트 명세

Fineract 는 중요한 비즈니스 이벤트 발생 시 외부 시스템으로 웹훅 (Webhook) 을 발송합니다. 이는 대출 승인, 대출금 지급, 원금 상환, 이자 상환, 계좌 개설 등 주요 금융 이벤트를 구독자에게 알리기 위해 사용됩니다.

### 3.1. 웹훅 구독 (Subscription)

외부 시스템은 먼저 Fineract 에 웹훅 구독을 등록해야 합니다.

*   **엔드포인트**: `POST /api/v1/webhooks`
*   **요청 본문**:
    ```json
    {
      "webhookId": "uuid-string",
      "url": "https://example.com/webhook-handler",
      "events": ["LOAN_DISBURSED", "LOAN_REPAYMENT", "SAVINGS_ACCOUNT_OPENED"],
      "secret": "your-secret-key",
      "locale": "ko_KR"
    }
    ```
*   **설명**:
    *   `url`: 웹훅이 전송될 외부 URL.
    *   `events`: 구독할 이벤트 타입 목록.
    *   `secret`: HMAC 시그니처 생성에 사용되는 비밀 키.

### 3.2. 웹훅 메시지 구조

Fineract 는 구독된 이벤트 발생 시 다음 구조의 POST 요청을 웹훅 URL 로 전송합니다.

```json
{
  "webhookId": "uuid-string",
  "timestamp": "2023-10-27T10:00:00.000Z",
  "locale": "ko_KR",
  "events": [
    {
      "eventType": "LOAN_DISBURSED",
      "entityId": "loan-uuid",
      "entityType": "LOAN",
      "data": {
        "loanId": "loan-uuid",
        "disbursementId": "disbursement-uuid",
        "amount": 1000000,
        "currency": "KRW",
        "status": "DISBURSED"
      },
      "metadata": {
        "userId": "user-uuid",
        "branchId": "branch-uuid"
      }
    }
  ],
  "signature": "HMAC-SHA256-signature"
}
```

*   **`signature`**: `secret` 키와 요청 본문 (JSON 문자열) 을 사용하여 생성된 HMAC-SHA256 서명. 외부 시스템은 이를 검증하여 위변조를 확인해야 합니다.
*   **`events`**: 발생된 이벤트 배열. 하나의 웹훅 호출에 여러 이벤트가 포함될 수 있습니다.
*   **`eventType`**: 이벤트 타입 (예: `LOAN_DISBURSED`, `LOAN_REPAYMENT`, `SAVINGS_ACCOUNT_CLOSED`).

### 3.3. 주요 비즈니스 이벤트 타입

Fineract 가 지원하는 주요 웹훅 이벤트 타입은 다음과 같습니다.

| 이벤트 타입 | 설명 | 발생 시점 |
| :--- | :--- | :--- |
| `LOAN_APPLICATION_SUBMITTED` | 대출 신청서 제출 | 사용자가 대출 신청서를 제출할 때 |
| `LOAN_APPLICATION_APPROVED` | 대출 승인 | 대출 심사자가 신청서를 승인할 때 |
| `LOAN_APPLICATION_REJECTED` | 대출 거절 | 대출 심사자가 신청서를 거절할 때 |
| `LOAN_DISBURSED` | 대출금 지급 | 대출금이 지급될 때 |
| `LOAN_REPAYMENT` | 대출금 상환 | 대출금 상환이 완료될 때 |
| `LOAN_REPAYMENT_FAILED` | 대출금 상환 실패 | 자동 상환 시도 실패 시 |
| `LOAN_CLOSURE` | 대출 종료 | 대출이 완전히 종료될 때 |
| `SAVINGS_ACCOUNT_OPENED` | 예금 계좌 개설 | 예금 계좌가 개설될 때 |
| `SAVINGS_ACCOUNT_CLOSED` | 예금 계좌 폐지 | 예금 계좌가 폐지될 때 |
| `SAVINGS_DEPOSIT` | 예금 입금 | 예금에 입금이 될 때 |
| `SAVINGS_WITHDRAWAL` | 예금 출금 | 예금에서 출금이 될 때 |
| `CUSTOMER_CREATED` | 고객 생성 | 새로운 고객이 등록될 때 |
| `PRODUCT_CREATED` | 상품 생성 | 새로운 금융 상품이 생성될 때 |

### 3.4. 웹훅 전송 전략

*   **비동기 전송**: Fineract 는 이벤트 발생 후 비동기적으로 웹훅을 전송합니다.
*   **재시도 정책**: 외부 시스템이 웹훅을 처리하지 않거나 네트워크 오류가 발생하면, Fineract 는 지정한 시간 간격으로 여러 번 재시도합니다. 최대 재시도 횟수에 도달하면 에러 로깅이 수행됩니다.
*   **웹훅 검증**: 외부 시스템은 수신된 웹훅의 `signature` 를 검증해야 합니다. 검증되지 않은 웹훅은 무시되어야 합니다.

## 4. 아키텍처 패턴 및 구현 세부사항

### 4.1. 이벤트 소스 (Event Source)

Fineract 는 내부적으로 이벤트 소스 패턴을 사용하여 비즈니스 로직과 이벤트 발행을 분리합니다. 주요 클래스는 다음과 같습니다.

*   **`EventPublisher`**: 이벤트를 발행하는 인터페이스.
*   **`EventBus`**: 이벤트를 구독하고 발행자에게 전달하는 중앙 관리자.
*   **`WebhookPublisher`**: 이벤트를 외부 웹훅 URL 로 전송하는 컴포넌트.

### 4.2. 이벤트 발행 흐름

1.  **비즈니스 로직 실행**: 예를 들어, `LoanApprovalService` 가 대출을 승인합니다.
2.  **이벤트 생성**: 서비스는 승인 완료 후 `LoanApprovedEvent` 객체를 생성합니다.
3.  **이벤트 발행**: `EventPublisher` 를 통해 이벤트를 `EventBus` 에 발행합니다.
4.  **구독자 처리**: `EventBus` 는 구독된 웹훅 구독자를 찾아 이벤트를 변환합니다.
5.  **웹훅 전송**: `WebhookPublisher` 가 변환된 JSON 을 외부 URL 로 POST 합니다.

### 4.3. 데이터 변환

내부 도메인 객체 (예: `LoanApprovalEvent`) 는 외부 웹훅 포맷으로 변환됩니다. 이 과정에서 민감한 정보 (예: 비밀번호, 개인 식별 정보) 는 마스킹되거나 제거됩니다.

```java
// 예시: 내부 이벤트 -> 웹훅 이벤트 변환
public Map<String, Object> convertToWebhookPayload(LoanApprovalEvent internalEvent) {
    Map<String, Object> payload = new HashMap<>();
    payload.put("eventType", "LOAN_APPROVED");
    payload.put("entityId", internalEvent.getLoanId());
    payload.put("data", convertLoanData(internalEvent.getLoan()));
    // ... 기타 필드 변환
    return payload;
}
```

## 5. 보안 고려사항

*   **인증**: 모든 API 호출은 `X-Auth-Token` 을 통해 인증되어야 합니다.
*   **웹훅 보안**: 웹훅은 반드시 `secret` 키를 사용하여 HMAC 시그니처를 검증해야 합니다.
*   **HTTPS**: 웹훅 URL 은 반드시 HTTPS 프로토콜을 사용해야 합니다.
*   **데이터 마스킹**: 웹훅 본문에는 금융 데이터의 민감한 부분 (예: 카드 번호, 주민등록번호) 은 포함되지 않아야 합니다.

## 6. 요약

Apache Fineract 의 API 및 이벤트 계약은 다음과 같은 원칙을 따릅니다.

1.  **일관성**: RESTful 패턴과 표준 JSON 포맷을 엄격히 준수합니다.
2.  **확장성**: 새로운 엔티티와 이벤트 타입을 쉽게 추가할 수 있는 구조를 가집니다.
3.  **신뢰성**: 에러 응답 표준화와 웹훅 재시도 정책으로 시스템의 안정성을 보장합니다.
4.  **보안**: 인증, 암호화,
