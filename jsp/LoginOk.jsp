<%@ page import="kb.servlet.Customer" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> Title </title>
</head>
<body>
<h2>로그인 성공</h2>
<%
    Customer cu = (Customer)request.getAttribute("cu"); // Object형이 나오기 때문에 downcasting이 필요하다
%>
<h3>
    이름 : <%=cu.getName()%><br>
    나이 : <%=cu.getAge()%><br>
    주소 : <%=cu.getAddr()%><br>
    연락처 : <%=cu.getPhone()%><br>
</h3>
</body>
</html>