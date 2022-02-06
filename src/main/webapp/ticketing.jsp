<%@ page import="model.movie.MovieDAO" %>
<%@ page import="model.company.AreaVO" %>
<%@ page import="model.company.TheaterVO" %>
<%@ page import="model.company.Movie_showVO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.movie.MovieVO" %>
<%@ page import="java.util.ArrayList" %><%--
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
    <title>Ticketing</title>
</head>
<body>
<%if (session.getAttribute("customer_id") == null) {%>
<a href="login.jsp">로그인</a>
<%
} else {
    String customer_id = (String) session.getAttribute("customer_id");
%>
<div><%=customer_id%>님 반갑습니다</div>
<a href="logout.jsp">로그아웃</a>
<%}%>
여기는 예매 페이지

<%
    MovieDAO movie = MovieDAO.getInstance();
    List<AreaVO> areaList = movie.areaList();
    String area_id = request.getParameter("area");
    String theater_id = request.getParameter("theater");
    String movie_id = request.getParameter("movie");
%>
<!-- 지역 목록 -->
<ul>
    <%for (AreaVO area : areaList) {%>
    <li><a href="ticketing.jsp?area=<%=area.getArea_id()%>"><%=area.getArea_name()%>
    </a></li>
    <%}%>
</ul>
<!--지역별 지점 목록-->
<ul>
    <%
        if (area_id != null) {
            for (TheaterVO theater : movie.theaterList(area_id)) {
    %>
    <li><a href="ticketing.jsp?area=<%=area_id%>&theater=<%=theater.getTheater_id()%>"><%=theater.getTheater_name()%>
    </a></li>
    <%}%>
    <%}%>
</ul>
<!--지점별 상영 영화 목록-->
<ul>
    <%
        if (theater_id != null) {
            for (String show : movie.showList(theater_id)) {
                MovieVO movieInfo = movie.getMovieList(show);
    %>
    <li>
        <a href="ticketing.jsp?area=<%=area_id%>&theater=<%=theater_id%>&movie=<%=movieInfo.getMovie_id()%>">
            <span>연령 : <%=movieInfo.getMovie_age()%></span>
            <br>
            <span>제목 : <%=movieInfo.getMovie_title()%></span>
        </a>
    </li>
    <%
            }
        }
    %>
</ul>

<!--선택 현황-->
<span>극장 : </span><span><% if (theater_id != null) out.print(movie.searchTheater(theater_id));%></span><br>
<span>영화 : </span><span><% if (movie_id != null) out.print(movie.getMovieList(movie_id).getMovie_title());%></span>

</body>
</html>
