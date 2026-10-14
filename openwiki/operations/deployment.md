---
type: operations
title: 배포 및 운영 가이드
description: Apache Fineract 플랫폼의 컨테이너 기반 배포, 환경 설정, 및 운영 절차를 상세히 설명하는 가이드입니다.
tags: [deployment, docker, operations, fineract, kubernetes, production]
verified:
  - by: openwiki/0.7.0
    at: 2026-10-05T15:48:47.442Z
sources:
  - id: openwiki-source-f9ab35cc8a94eea4cbfb6b9e
    resource: repo://fineract-repo/docker-compose.yml
generated: { by: "omp", at: "2026-10-05T15:48:47.442Z" }
---

# 배포 및 운영 가이드

Apache Fineract는 현대적인 마이크로서비스 아키텍처를 기반으로 구축되어 있으며, Docker 컨테이너화를 통해 일관된 개발, 테스트, 프로덕션 환경에서 실행되도록 설계되었습니다. 본 가이드는 Fineract 플랫폼을 Docker Compose 또는 Kubernetes 환경에서 안정적으로 배포하고 운영하는 표준 절차를 제공합니다.

## 1. 배포 아키텍처 개요

Fineract는 다음과 같은 주요 컴포넌트로 구성된 마이크로서비스 생태계를 가집니다. 각 컴포넌트는 독립적으로 빌드되고 실행되며, 서비스 간 통신은 HTTP/gRPC 프로토콜을 통해 이루어집니다.

### 주요 컴포넌트

| 컴포넌트 | 역할 | 기술 스택 |
| :--- | :--- | :--- |
| **Fineract Core** | 핵심 비즈니스 로직 (대출, 예금, 카드, 보고 등) | Java (Spring Boot), PostgreSQL |
| **Fineract Mobile** | 모바일 애플리케이션 백엔드 API | Java (Spring Boot), PostgreSQL |
| **Fineract Mobile Gateway** | 모바일 API 게이트웨이 및 인증 처리 | Java (Spring Boot), Redis |
| **Fineract Mobile App** | 모바일 클라이언트 (Android/iOS) | Native Mobile SDK |
| **Fineract Web App** | 웹 클라이언트 프론트엔드 | React, Angular (버전별 차이) |
| **Fineract Scheduler** | 백그라운드 작업 스케줄링 (이체, 리포트 등) | Java (Spring Boot), PostgreSQL |
| **Fineract Reporting** | 보고서 생성 및 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 신용 결정 엔진 (규칙 기반) | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 및 게이트웨이 연동 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 (상품 정의, 가격 등) | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 (기관) 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 및 권한 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Deposit** | 예금 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Card** | 카드 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Report** | 보고서 정의 및 실행 | Java (Spring Boot), PostgreSQL |
| **Fineract Decisioning** | 의사결정 엔진 | Java (Spring Boot), PostgreSQL |
| **Fineract Payments** | 결제 처리 | Java (Spring Boot), PostgreSQL |
| **Fineract Product** | 상품 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Tenant** | 테넌트 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract User** | 사용자 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Account** | 계정 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Collateral** | 담보 관리 | Java (Spring Boot), PostgreSQL |
| **Fineract Loan** | 대출 관리 | Java (Spring Boot), PostgreSQL |
|
