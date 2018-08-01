Java Web Study
==============

1. 개발 환경 설정
    1. [UTF-8](http://gangzzang.tistory.com/entry/%EC%9D%B4%ED%81%B4%EB%A6%BD%EC%8A%A4-%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD-UTF8-%EC%9D%B8%EC%BD%94%EB%94%A9-%EC%84%A4%EC%A0%95) 설정

2. Forward와 Redirect의 차이
    1. Forward: 서버 내에서 브라우저에게 자료를 보여줄 때 사용. 들어온 `Request`에 대한 `Response`를 주는 행위이다.
    2. Redirect: `302 Found`을 브라우저에게 응답을 주고, 브라우저가 해당 `URL`로 다시 요청하게 된다.
    3. [참고1](https://stackoverflow.com/questions/6068891/difference-between-jsp-forward-and-redirect), [참고2](https://stackoverflow.com/questions/2047122/requestdispatcher-forward-vs-httpservletresponse-sendredirect)
