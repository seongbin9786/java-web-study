# Spring MVC Controller 및 Test

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

## 소스 설명

- main 폴더의 `com.study.sb.HomeController`는 여러가지 `RequestHandler`의 예제를 포함합니다.
- test 폴더의 `com.study.sb.HomeControllerTest`의 `test_HomeController_json()`은 `/json` 엔드포인트를 테스트합니다.