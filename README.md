# 개요

## 목적
- 기존에 진행했던 닭가슴살 구매 프로젝트를 최신화
- Kotlin 을 공부하며 얻은 지식을 적용하는데 초점을 둔다.  
- 간소화 할 부분
  - 인증 및 인가 프로세스는 간략화
  - 실제 결제를 적용하지 않음

# 기술 스택
기존 진행 프로젝트
- https://github.com/GroovyArea/My-ChickenBreast-Shop
- Java 와 Spring Framework 를 공부하며 얻은 지식으로 혼신을 쏟은 프로젝트

## 기존 진행 프로젝트 기술 스택
- 언어 : Java 17
- 프레임워크 : Spring MVC, Spring Security, Spring Data JPA
- 라이브러리 : MapStruct
- 데이터베이스 : Mysql, Redis
- 아키텍처 : Clean Architecture, Domain Driven Design

## 진행할 프로젝트 기술 스택
- 언어 : Kotlin, JDK 21, Coroutine
- 프레임워크 : Spring Webflux, Spring Data Reactive Mongo, Spring Data Redis
- 라이브러리 : Spring Kafka, MapStruct
- 메시지 브로커 : Kafka
- 데이터베이스 : Mongodb, Redis
- 컨테이너 툴 : Docker

## 프로젝트 설정

- docker-compose 실행
  - `docker-compose -f docker/docker-compose.yaml up -d`
- 기타 Application 실행