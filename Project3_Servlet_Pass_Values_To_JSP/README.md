# 1강

## 5부 - VO로 데이터 출력하기

1. 패키지 생성 (ex.sbstudy)
2. 서블릿 생성 (New > Servlet)
    1. `IndexServlet`을 `'/'`로 라우팅되게
    2. `LoginServlet`을 `'/login'` 으로 라우팅되게
    3. `LogoutServlet`을 `'/logout'` 으로 라우팅되게
    4. 모두 `onGet(req, res)` 만 구현

3. `IndexServlet`을 작성
    ```java
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // index.jsp를 포워딩한다.
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    ```

4. `LoginServlet`을 작성
    ```java
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // ID 값을 받는다.
            String id = request.getParameter("id");

            // ID 값을 attribute로 설정한다.
            request.setAttribute("name", id);

            // index.jsp 페이지로 attribute를 전달
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    ```

5. `LogoutServlet`을 작성
    ```java
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // attribute를 제거한다.
            request.removeAttribute("name");

            // index 페이지로 attribute를 전달
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    ```

6. `index.jsp`를 생성하고, `안녕하세요, ${name}님` 을 추가한 후
    - `/`
    - `/login?id=hello`
    - `/logout`
    - 을 차례대로 방문하고 결과 확인
    - `${변수명}`과 같이 표기하는 문법을 EL(expression language, 표현 언어)라고 한다.

7. `index.jsp`에서 `${name}`이 있을 때와 없을 때를 구분해 다른 화면을 나타내기 위해 아래와 같이 작성
    ```html
        <c:choose>
            <c:when test="${name != null}">
                <div>안녕하세요. ${name}님</div>
            </c:when>
            <c:otherwise>
                <form action="/login">
                    <input name="id" />
                    <input name="password" type="password" />
                    <button type="submit" class="login__btn">로그인</button>
                </form>
            </c:otherwise>
        </c:choose>
    ```

    - `/WebContent/WEB-INF/lib` 내에 `taglibs-*.jar` 파일들(총 3개) 추가

    - JSP dtd 아래에 `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>` 추가

## 6부 - JSTL을 배우기

1. 강의는 이 [블로그 1](http://hunit.tistory.com/203) / [블로그 2](http://javayo.tistory.com/entry/JSTL-%EB%AC%B8%EB%B2%95) 에서 공부
2. foreach로 Collection이나 Array의 데이터를 순회하면서 접근 가능
3. if, choose 등으로 분기 가능

## 7부 - JSTL 활용

1. 로그인 화면, 로그인 이후에는 환영 화면을 `index.jsp`에 구현해보기

## 8부 - Session 활용

1. Session에 사용자 정보를 저장한다.
2. Redirect로 화면 전환을 해도 정보가 유지된다 :smile:
