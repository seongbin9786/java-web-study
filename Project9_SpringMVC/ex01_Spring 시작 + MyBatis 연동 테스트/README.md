# Spring 시작 + MyBatis 연동 테스트

## 환경
- Spring Legacy Project로 생성하여 아래의 버전으로 설정된 프로젝트입니다.
	1. Spring 4.3.3.RELEASE
	2. MySQL Connector 5.1.39
	3. JDK 1.8
	4. JUnit 4.12
	5. MyBatis 3.4.1 (Mybatis-spring: 1.3.0)
	6. Spring-jdbc / Spring-test

## 소스 설명

- test 폴더의 `com.study.sb.DataSourceTest` 는 DataSource에서 Connection을 잘 받아오는지 확인합니다.
- test 폴더의 `com.study.sb.MyBatisTest`는 SqlSession을 잘 받아오는지 확인합니다.