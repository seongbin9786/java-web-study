# 객체지향 강의 1

## 객체지향을 쓸 때 가져야 할 마음 가짐

1. __캡슐화__, __다형성__, __상속__

2. 위 세 가지를 활용하여 코딩한다면 ===> 코드 재사용이 증가, 유지 보수는 감소

3. 객체지향 = 유연하게 알고리즘을 교체할 수 있게 됨 ---> 변경에 강한 구조을 갖게 됨 ---> 확장 시에 다른 코드의 변경이 거의 없거나 전혀 없게 됨

4. 3번을 실행하기 위해 `객체지향 실천법`에 나오는 생각 방식을 탑재한다면 이를 자연스럽게 실천하는 데에 매우 도움이 된다.

5. 높은 재사용성과 낮은 유지보수 비용은 객체지향을 쓴다고 보장되는 것이 아니라, 객체지향을 __잘__ 활용한 프로그래밍을 하느냐에 달려 있음을 인지하자.

## 객체지향 실천법

1. 클래스(or 객체)를 생각하는 관점을 다르게 해야 한다. 역할, 책임, 협력과 관계지어서 클래스(or 객체)를 생각해보자. 아래와 같이 생각해보자.

2. 클래스(or 객체)에는 인터페이스가 있다. 이 때의 인터페이스는 외부와 상호작용할 수 있는 메소드를 일컫는다. 객체는 메소드를 통해서 외부와 상호작용하게 되며, 객체는 스스로 생성되고 스스로 실행되지도 않는다. 따라서 3번을 도출할 수 있게 되는데

3. 객체는 독립적인 존재가 아닌 사회적인 존재라는 것이다. 각 객체는 역할이 있고, 그 역할은 1개일 수도, 여러개일 수도 있지만 반드시 역할이 있어야 한다. 또한 역할은 다른 객체로 대체될 수도 있다.

4. 실세계에서는 역할이 모여 `협력`을 이루게 된다. 오히려 협력 내에 역할이 있는 것이 더 맞는 것 같다. 아무튼 `협력`이란 여러 역할이 모여서 하나의 문제를 해결하는 것을 말한다. 협력은 큰 형태의, 구조적인, 알고리즘이다. 협력의 예로는 `재판`, `상품 거래` 등 각 역할이 상호작용하면서 목적을 이루는 어떤 일이면 된다.

5. `재판`의 경우, 판사, 피고, 원고, 변호사, 증인 등이 모여 법적으로 갈등을 해결하는 것이 목적이다. 즉 재판에서 `갈등을 해결한다.`는 문제를 해결하는 부분이고, `판사, 피고, 원고, 변호사, 증인` 등은 협력의 역할이고, 재판은 협력이다.

## 1편 - 객체지향 핵심 = <b>자율적</b>인 객체들의 <b>협력</b>

1. 객체를 사람처럼 생각해보자. 사람은 자율적이고, 협력하면서 살아간다. 아래는 커피 프랜차이즈의 예시이다.
    - (ex) `(자율)` 바리스타는 알아서 커피를 만든다.
    - (ex) `(자율)` 캐시어(casher)는 알아서 고객을 응대한다.
    - (ex) `(협력)` 고객은 캐시어에게 주문을 요청하고, 캐시어는 바리스타에게 주문을 알리며, 바리스타는 고객에게 커피를 제조한 후 완성됨을 알린다.

2. 협력 = 객체가 서로의 역할에 맞는 요청을 하고, 역할을 수행한 후 응답을 하여 일을 나누어 처리하는 방법이다. :smile:

3. 자율적 = 자신의 행동을 스스로 결정하고 책임짐을 말한다. 다른 사람의 요청에 따라 행동하지만 일은 스스로의 판단에 따라 결정하고 실행하게 된다.

4. 1에서 나온 역할을 살펴보자. 바리스타, 캐시어, 고객이 있다. 역할은 특정 사람을 지칭하지 않는다. 즉 여러 사람이 동일한 역할을 수행할 수 있다. 오, 그렇다면 역할을 수행하는 사람이 기계의 부품처럼 교환될 수도 있을까?

5. 그렇다. 각 바리스타는 규칙이 정해져 있지 않은 부분에서 자신만의 방식으로 커피를 제조하게 된다. 하지만 커피를 제조할 수 있다면 고객 입장에선 어떤 바리스타가 커피를 제조하더라도 문제 없다.

6. 정리
    - 역할은 대체 가능성을 의미한다.
    - 역할을 수행하는 사람은 역할을 수행하는 방법을 자율적으로 선택할 수 있다.
    - 역할이 모여 문제를 해결하는 단위를 협력이라고 한다.

## 2편 - 1편의 내용을 프로그래밍으로 옮겨온다면

1. 1편에서 나온 내용의 사람을 `객체`로, 요청을 `메시지`로, 처리(수행)을 `메소드`로 바꾸면, 객체지향이 된다! :sparkles:

2. 객체지향의 근본 개념이 실세계에서 사람들이 타인과 관계를 맺으며 협력하는 과정과 유사하다. :joy:

3. `협력`은 객체들의 관계를 의미하고, `객체`는 실제로 협력을 수행하는 개별 주체를 의미한다.

## 3편 - 역할을 엄밀하게 배우기

1. 역할을 제대로 이해하려면, `책임`에 대해서도 배워야 한다. 책임은 객체가 짊어질 의무를 의미한다.

2. 역할은 책임의 집합이다. 책임이 더 작은 단위이고, 역할은 여러 책임을 포함할 수 있다.
    - (ex) `역할` = 판사
    - `책임` = 재판을 시작하다, 증인을 부를 것을 요청하다, 증인의 입장을 요청하다, 증언을 요청하다, 판결을 내리다, ...
    - 객체의 재사용 = __역할 단위__ !

3. 책임은 무엇(what)을 할 지 설명한다. 이 때 __어떻게(how)는 관여하지 않아야__ 하는데, 자율성을 보장하기 위한 것이다.
    - (ex) `판사` 역할의 책임
        - 증언하라 (:heavy_check_mark:) = 무엇을 할 지만 설명했음
        - 목격했던 장면을 떠올려서 증언하라 (:x:) = 무엇(what)을 포함하지만, 어떻게(how)까지 관여하고 있음

4. 하나의 역할에 포함되는 책임은 서로 관련성이 높아야 한다! (객체지향 개념 중 응집성을 보장하기 위함이다)

5. 객체지향 프로그래밍에선 역할 단위로 재사용하게 된다.
    - (ex) 판사, 피고, 증인, 원고
    - 물론 위와 같이 실세계와 1:1로 모델링할 일은 거의 없다. (시뮬레이션 프로그램에서나 하게 됨)
    - 실제론 프로그램으로 처리할 기능만 구현하게 되고, 이름을 지을 땐 실세계에서 은유해서 가져오게 된다.

6. 역할이 모이면 협력이 된다. (복습) 참고로 협력 단위로도 재사용 가능하며 이 땐 주로 역할을 갈아 끼우게 됨
    - (ex) `재판` 협력
        - 각 재판마다 역할은 바뀌게 되어있으나 협력은 계속 새로 만들어지게 됨
        - 새로운 증인
        - 새로운 변호인
        - 새로운 판사

## 4편 - 객체지향적 설계를 하는 방법 :star:

1. 프로그램을 만들 때, 어떤 자료형으로 어떤 변수를 선언할까 생각하기보다 협력부터 생각하자.

2. 객체는 협력에 참여하기 위해 존재한다. 역할을 수행하기 위해 데이터가 필요한 것이지, 데이터가 있고 역할이 있는 것은 아니다.

3. 책임 주도 설계(Responsibility-Driven Design) :heart:
    1. 프로그램이 사용자에게 제공해야 하는 기능을 파악한다. (요구 사항 분석)
    2. 요구 사항을 책임으로 분할한다. (어떤 행위가 필요한 지 결정)
    3. 분할된 책임을 수행할 만한 역할을 찾아 책임을 할당한다. (행위를 수행할 객체를 결정)
    4. 역할을 수행할 객체를 구현한다.
    5. 4를 진행하면서 새로운 역할이나 책임을 발견하는 경우 반영한다.
    - 요약: 프로그램 요구사항을 역할 단위로 잘게 나누고 구현한다!

4. 디자인 패턴(Design Pattern) :sunglasses:
    - 전문가들이, 반복적으로 활용되는 설계의 모음이다.
    - 이미 역할, 책임, 협력이 식별되어 있다.
    - 이미 발명된 패턴은 차용하자.

5. 테스트 주도 개발(Test Driven Development)
    - 테스트를 먼저 작성하고 테스트를 통과하는 구체적인 코드를 추가하면서 개발하는 방법이다.
    - TDD는 설계를 위한 기법이다.
    - 협력/역할을 먼저 정의하고 구현체를 정의하게 되므로, 역할/책임/협력을 식별하고 식별된 역할/책임/협력이 적합한지 확인할 수 있다.
    - 메시지를 먼저 결정하여 객체의 인터페이스를 발견할 수 있다.
    - 덤으로 테스트 코드를 얻을 수 있다.

## 5편 - 책임을 엄밀하게 배우기

1. 책임은 WHAT만 정의한다.

2. 책임은 추상적이면 안 된다.
    - (ex) 설명하라
    - 무엇을 설명해야 하는지 분명하지 않음 (추상적)
    - 해결: 설명하라 -----> 증언하라

3. 객체는 다른 객체로부터 메시지를 받아야만 행동할 수 있다.

## 6편 - 객체지향 실습

1. 카페 프랜차이즈 협력 구현하기

2. 급여 관리 시스템 구현하기