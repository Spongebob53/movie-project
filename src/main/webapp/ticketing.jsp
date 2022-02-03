<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/01/31
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%if(session.getAttribute("customer_id")==null){%>
<a href="login.jsp">로그인</a>
<%}else{
    String customer_id = (String)session.getAttribute("customer_id");
%>
<div><%=customer_id%>님 반갑습니다</div>
<a href="logout.jsp">로그아웃</a>
<%}%>
여기는 예매 페이지

</body>
</html>
