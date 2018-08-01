# Java Web Study

저자(김성빈)가 2018/07 ~ (아직 종료X) 진행한 Spring Study 저장소입니다.

Spring에 대한 내용과 Spring을 제대로 배우기 위한 기본기를 포함한 내용들을 포함하고 있습니다.

제대로 이해하기 위해선 Spring의 내부 구조와 연계된 기술 또한 세밀하게 알아야 한다고 생각하여 `why`에 기반한 내용을 담고 있습니다.

이 저장소의 내용은 스터디를 위해 작성되었으며, 과제/보충설명 등은 해당 저장소에 포함되어 있지 않으므로, 이 저장소를 참고하여 공부하시는 경우, 기초 부분은 빠르게 지나가기 때문에 보충 학습이 꼭 필요합니다.

이 저장소의 내용은 `Java`만 공부했을 때를 기준으로 합니다.

모든 예제는 직접 생성하였습니다.

## 출처

- Spring Official Document / Guide

- 믿을만한 저자의 블로그 (Spring, OO, DDD, TDD)

- StackOverFlow의 믿을만한 답변 + Comment 모두 고려

- Slipp의 Spring Study 내용

- Baeldung 

- Spring 내부 소스 확인 및 디버깅 - `DispatcherServlet` 등 (10%)

## 목차

1. Servlet에 관련된 내용을 학습합니다. (기능만 짚고 넘어갑니다. 연습은 알아서)

    - `Project1_JustIndexPage` - Servlet 애플리케이션에서 index.html을 제공하는 가장 간단한 방법을 수록

    - `Project2_JustServlet` - Servlet의 API를 소개합니다.

    - `Project3_Servlet_Pass_Value_To_JSP` - JSP를 forward하는 예제입니다. `Model(request 객체)`에 `Attribute`를 전달하는 과정이 포함되어 있습니다. JSTL, Session 내용도 포함되지만 예제를 확장하는 과제 형식으로 수록되어있습니다.

    - `Project4_Action_Pattern` - Servlet 기반에서 자주 쓰이는 `FrontController - Action` 패턴을 적용한 예제입니다.

    - `Project5_MVC_Pattern` - `MVC Pattern`을 적용한 Servlet 애플리케이션입니다. Project4에서 적용한 FrontController도 포함되어 있습니다. MVC에 대해 자세히 설명하였고, 로그인, 회원가입등이 구현된 예제입니다.

2. 객체지향 기본기를 학습합니다. (적은 내용이더라도 제대로 짚고 넘어갑니다. 숙련이 오래걸리기 때문에 연습은 필수입니다.)

    - `Project6_객체지향_강의록` - 자율, 책임, 협력 등을 핵심 개념으로 객체지향의 기초를 학습합니다. `객체지향의 사실과 오해` 내용을 기반으로 집약하였습니다.

    - `Project6_OOP_1_카페프랜차이즈` - `객체지향의 사실과 오해`에 나오는 예제를 더 쉽게 각색한 예제입니다. 객체지향 강의록의 내용을 연습하기 위한 예제입니다.

    - `Project6_OOP_2_급여관리시스템` - `클린 소프트웨어`에 나오는 예제의 난이도를 매우 줄인 버전입니다. `OCP`를 (강의록에 수록하진 않았지만) 활용하는 예제입니다. 요구사항이 다양하여 추상화를 잘 해야 하기 때문에 처음 객체지향을 접하셨다면 상당히 어렵습니다. 어서 절차지향에서 탈출하세요. 이 예제를 성공적으로 구현하였다면 Spring을 배울 정도의 객체지향 기본기는 충분합니다. Spring이 `OCP`에 입각해서 만들어졌기 때문입니다. (OCP보다 전체적인 객체지향 개념이지만, OCP가 설계에서 가장 쉽게 보이고 사용자 입장에서의 확장 포인트이므로 강조했고, SpringMVC 공식 문서에서도 OCP에 입각했다고 나와있습니다.)

3. Spring의 내부 구조를 학습합니다. (토비의 스프링 정도 / 공식 문서 수준까지 가기엔 벅차서, 적절히 선별 중)

    - `Project7_Spring_기본기` - Spring의 핵심 기술을 설명합니다. 단순히 기술의 나열보다, 기술이 어떻게 구현되고 어떻게 적용되고, 왜 사용해야 하는지 까지 모두 정리하였습니다. (내용이 방대하기 때문에 계속해서 업데이트 중입니다.)

    - `Project7_Spring_Start` - Spring의 `DI`를 활용하는 굉장히 간단한 예제입니다. `XML-based Configuration`으로 `Bean`을 설정하고 Java Code에서 Bean을 주입 받아 사용합니다.

4. Database를 간단히 학습합니다.

    - `Project8_Database_with_Spring` - Database를 설명하고, Spring에서 어떻게 사용하는지 설명합니다. DB의 전체적인 내용을 훑으면서도 가장 필수적인 부분은 자세히 설명하였습니다. `DDL`, `DML` 등은 문서화하기 힘들어 생략하였습니다 :smile: (백과사전식 내용은 모두 과제 형태로 나갑니다.) Spring에서 JDBC를 활용한 예제를 포함합니다.

5. SpringMVC를 학습합니다. (제공되는 기능이 많기 때문에 )

    - `Project9_SpringMVC` - Spring MVC의 내부 구현을 `DispatcherServlet`을 뜯어보면서 설명합니다. 백과사전식 나열보다 어떤 기술이 어떻게 적용되는지 실제로 볼 수 있도록 합니다. 매우 Deep하게 가진 않고, 적절한 수준으로 해부합니다.

    - `Project9_SpringMVC_실전` - 실제로 사용되는 기능을 학습합니다. 기능을 자동화해주는 `Annotation`과 SpringMVC의 확장 포인트, `REST API` 처리 등을 이 프로젝트에서 설명합니다.

6. 디자인 패턴 - 객체지향의 5대 원칙인 SOLID에 대해서 공부하고, SOLID가 실제로 어떻게 활용되는 지 공부하기 위해 디자인 패턴을 공부합니다. 시간이 된다면 `리팩토링`과 `TDD`도 하면 좋겠는데...

7. Hibernate - 아마 Transaction을 Spring이 AOP Proxy 방식으로 처리하므로 때문에 AOP를 어느 정도 해야 할 것 같습니다.

8. Spring Security

9. Spring AOP

10. 리팩토링, TDD, DDD, ..., 수 없이 많은 것들이 있죠