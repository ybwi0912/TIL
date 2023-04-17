<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> JSP </title>
</head>
<body>
<h1>JSP 입문</h1>
<% // 스크립트 릿 내 변수들은 모두 지역 변수. 무조건 초기화가 되어야 한다
    // java 영역
    String name = "상희"; // 지역 변수 -
    int age = 20;
    String message = "안녕하세요!";
    // 출력 - 서버
    System.out.println("name = " + name);

    // 출력 - 브라우저
    out.println("<h3> name = " + name + "</h3>");
%>

<hr>

<h4>
    나이 : <%=age%>살 <br>
    메소드 호출 : <%=this.greeting("상희")%>
</h4>

<%! // 느낌표가 없는 상태에서는 메소드를 선언할 수 없다!!!
    String addr;
    String info = "info";
    public String greeting(String name){
        System.out.println("test() method");
        return name + "님, 활기찬 월요일 보내세요";
    }
%>
</body>
</html>