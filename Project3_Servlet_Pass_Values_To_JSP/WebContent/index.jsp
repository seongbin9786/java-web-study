<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.rawgit.com/hiun/NanumSquare/master/nanumsquare.css">
    <title>2004년 네이버 가즈아</title>
    <style>
        html {
            font-family: 'Nanum Square', 'Malgun Gothic', sans-serif;
            padding: 0;
            margin: 0;
        }
        
        body {
            max-width: 1000px;
            margin: 0 auto;
        }
        
        #root {
            margin: 0 50px;
            min-height: 1080px;
            color: #00ab33;
        }

        table {
            /* 네이버 같은 느낌 */
            width: 190px;
            height: 100px;
            padding: 0px;
            font-family: 굴림;
            color: rgb(79, 79, 48);
            font-size: 12px;
            line-height: 1.3;
            background-color: rgb(245, 244, 214);
            border: 1px solid rgb(211, 209, 156);
            height: 70px;
        }

        .title {
            width: 48px;
            text-align: right;
        }

        .email {
            font-size: 11px;
            letter-spacing: -1px;
        }

        input {
            width: 64px;
        }
        
        .register a {
            text-decoration: none;
            color: rgb(237, 108, 31);
        }

        button {
            font-size: 10px;
        }
    </style>
</head>
<body>
    <div id="root">
        <h1>네이버 - 지식까지 찾아주는 검색, 네이버</h1>
        
        <c:choose>
            <c:when test="${name != null}">
                <div>안녕하세요. ${name}님</div>
                <button onClick="location.href='/'">로그아웃</button>
            </c:when>
            <c:otherwise>
                <form action="/login">
                    <table>
                        <tr>
                            <td class="title">아이디</td>
                            <td><input name="id" /></td>
                            <td class="email">@naver.com</td>
                        </tr>
                        <tr>
                            <td class="title">비밀번호</td>
                            <td><input name="password" type="password" /></td>
                        </tr>
                        <tr>
                            <td><button type="submit" class="login__btn">로그인</button></td>
                        </tr>
                        <tr class="register">
                            <td><a href="/register">회원가입</a></td>
                        </tr>
                    </table>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>