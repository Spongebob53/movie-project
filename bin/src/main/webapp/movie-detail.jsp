<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/01/31
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.movie.MovieDAO" %>
<%@ page import="model.movie.MovieVO" %>
<jsp:useBean id="MovieVO" class="model.movie.MovieVO">
    <jsp:setProperty name="MovieVO" property="movie_id"/>
</jsp:useBean>
<!-- 영화 id에 해당하는 정보 가져오기 -->
<%
    MovieVO movieInfo = MovieDAO.getInstance().movieInfo(MovieVO);
    request.setCharacterEncoding("UTF-8");
%>
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
여기는 상세영화 페이지
<%= movieInfo.getMovie_title() %>
<%= movieInfo.getMovie_time() %>
<%= movieInfo.getMovie_age() %>
<%= movieInfo.getMovie_gerne() %>
<a href="ticketing.jsp">예약 페이지</a>
<a href="index.jsp">메인 페이지</a>
</body>
</html>
