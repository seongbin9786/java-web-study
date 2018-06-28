# 1강

## 9부 - FrontController 패턴

* [Properties를 사용한 Action 패턴 - 참고1](http://treasurebear.tistory.com/15)
* [Properties를 사용한 Action 패턴 - 참고2](https://github.com/madvirus/jsp23/tree/master/webapps/chap18/WEB-INF/src/mvc)
* 여기서 사용하는 패턴의 의미는 Action = Command 동일합니다.
* 디자인 패턴 관점에선 Action 패턴은 따로 없고, Strategy 패턴이어야 하고, Command 패턴은 아닙니다.
* Command 패턴은 execute()에 매개변수가 전달될 수 없기 때문입니다.

1. `FrontController` 패턴은 하나의 서블릿에 모든 요청을 처리하도록 하고, 해당 서블릿은 요청을 처리할 `Action 객체`에 처리를 위임한다. 이 때 `service(req, res)` 메소드를 `override`하여 모든 Type의 HttpMethod에 대하여 처리하게 된다.
    ```java
        protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Action action = ActionFactory.getAction(request);
            String view;
            try {
                view = action.execute(request, response);
            } catch (Exception e) {
                view = "redirect:/error.do";
            }
            navigate(request, response, view);
        }
    ```

2. `Action 객체`들은 `Action 인터페이스`를 구현해야 하는데, 이는 아래와 같다. `Action 객체`는 자신이 등록된 Method와 Path로 들어온 요청을 처리하는 책임이 있다.
    ```java
        public interface Action {
            public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
        }
    ```

3. `ActionFactory`는 `요청` 정보에서 어느 `Action 객체`가 처리할 지 판단하고 반환하는 책임을 가진다. `ActionFactory`는 `Factory 객체`이다. (`Factory 패턴`이 적용되었다는 뜻이다.)

4. `Factory 패턴`은 객체의 생성 과정을 감추는(캡슐화하는) 디자인 패턴이다.
    1. 객체는 단순히 `new 객체(...)`로 생성하면 되는 것 아닌가?

    2. `Factory`는 조건에 따라 다른 객체가 생성되어야 하는 경우 사용해야 한다.

    3. `Factory`는 어떤 객체를 필요로하는 다른 객체가 구체 타입을 알지 못하게 하여 결합도를 낮추는 경우에 사용된다.

    4. 예를 들어, `FrontController`는 `Action` 타입을 알고 있고, Action 타입의 `execute 메소드`만을 알면 __모든__ Action 타입과 소통할 수 있다. FrontController는 요청이 왔을 때 적절한 Action 객체에 처리를 위임해야 하는데, 그러기 위해선 `IndexAction`, `ErrorAction` 과 같은 Action 타입의 특수형을 직접 생성한 후 위임해야 한다. 이 때 각각의 모든 Action의 특수형과 결합이 발생한다.

    5. 그러나 FrontController가 Action만 알면 상관 없는데 모든 Action의 특수형을 알 필요가 없기 때문에, `ActionFactory`라는 Factory 객체에 생성을 위임하면 결합도가 Factory와만 생기면서 크게 줄어든다.

    6. 이렇게 결합도를 낮추는 장점 덕분에 Factory 패턴은 굉장히 자주 사용된다.

5. `ActionFactory`의 책임을 구현한 메소드이다.
    ```java
        private static Map<String, Action> actions = new HashMap<>();

        static {
            actions.put("GET/index", new IndexAction());
            actions.put("GET/error", new ErrorAction());
        }

        public static Action getAction(HttpServletRequest req) {
            String method = req.getMethod();
            String path = req.getRequestURI().toString();
            System.out.println("method: " + method + " path: " + path);

            String destination = method + path + ".do";
            return actions.get(destination);
        }
    ```

## 10부 - `.do`를 사용하는 이유

- 참고: [블로그](http://lng1982.tistory.com/97)
