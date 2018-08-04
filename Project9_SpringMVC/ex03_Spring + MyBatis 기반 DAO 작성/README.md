# Spring + MyBatis 기반 DAO 작성

## 환경
- Spring Legacy Project로 생성하여 아래의 버전으로 설정된 프로젝트입니다.
	1. Spring 4.3.3.RELEASE
	2. MySQL Connector 5.1.39
	3. JDK 1.8
	4. JUnit 4.12
	5. MyBatis 3.4.1 (Mybatis-spring: 1.3.0)
	6. Spring-jdbc / Spring-test
	7. Jackson 2.8.4
	8. Servlet 3.1.0
	9. JsonPath 2.3.0
	10. log4jdbc-log4j2-jdbc4.1 1.16
	11. log4j-api 2.0.1
	12. log4j-core 2.0.1

## 소스 설명

- test 폴더의 `com.study.sb.MyBatisDaoTest`는 MyBatis 기반으로 구현한 `UserDao`를 테스트합니다.
- main 폴더의 `User`는 User 객체를 표현합니다.

## SQL 실행

- `ex-ddl.sql`을 실행하면 데이터베이스와 초기 데이터를 생성합니다.