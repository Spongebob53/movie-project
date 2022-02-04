<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/01/31
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.movie.MovieDAO" %>
<%@ page import="model.movie.MovieVO" %>
<!--영화 목록 불러오기 -->
<%
    List<MovieVO> movieList = MovieDAO.getInstance().getMovieList();
    request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
여기는 메인페이지
<a href="ticketing.jsp">예매</a>
<%if(session.getAttribute("customer_id")==null){%>
    <a href="login.jsp">로그인</a>
<%}else{
    String customer_id = (String)session.getAttribute("customer_id");
%>
    <div><%=customer_id%>님 반갑습니다</div>
    <a href="logout.jsp">로그아웃</a>
<%}%>   <!-- end of else-->

<!--영화 목록이 없을 경우 구분 -->
<% if (movieList.isEmpty()) { %>
검색된 결과가 없습니다.
<% } else { %>
<!-- 있다면 하나씩 반복 -->
<% for (MovieVO movie : movieList) { %>
<hr>
<form method="get">
    <!-- 영화 id를 파라미터로 -->
    <input type="hidden" name="movie_id" value="<%= movie.getMovie_id() %>">
    <!-- 임시 확인용, 추후 영화 커버를 영화 id로 저장하고 불러오면 편할 듯 -->
    제목 : <%= movie.getMovie_title() %> <br>
    <!-- 상세 정보에 전달하거나 -->
    <button type="submit" formaction="movie-detail.jsp">상세정보</button>
    <!-- 예매 페이지에 전달하거나 -->
    <button type="submit" formaction="ticketing.jsp">예매하기</button>
</form>
<hr>
<% } // end of for
} // end if-else %>

</body>
</html>
