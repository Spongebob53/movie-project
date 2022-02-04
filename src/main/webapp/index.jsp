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
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/text.css" rel="stylesheet" type="text/css">
    <link href="css/header.css" rel="stylesheet" type="text/css">
    <link href="css/footer.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>

<body>
	
	 <header>
        <div class="header">
            <div class="header-inner header-search">
				<a href="#"><i class="bi bi-search"></i></a>
			</div>
            <div class="header-inner header-logo">
				<a href="index.jsp"></a>
			</div>
            <div class="header-inner header-member">
            	<a class="list-txt" href="login.jsp">로그인</a>
            	<a class="list-txt" href="join.jsp">회원가입</a>
            	<a class="list-txt" href="#">고객센터</a>
            </div>
        </div>
    </header>
    
    <nav>
        <div class="nav-list">
            <ul>
                <li><a href="#">영화</a></li>
                <li><a href="ticketing.jsp">예매</a></li>
                <li><a href="#">극장</a></li>
                <li><a href="#">이벤트</a></li>
                <li><a href="#">혜택</a></li>
            </ul>
        </div>
    </nav>
    
    <main class="container">
    	
    </main>
    
    

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

	<footer>
    	<div class="footer">
    		<div class="footer-logo">
				<a href="index.jsp"></a>
			</div>
    		<div class="footer-info">
				<section class="footer-info_list">
					<ul>
						<li><a href="#">기업정보</a></li>
						<li><a href="#">채용정보</a></li>
						<li><a href="#">광고/제휴문의</a></li>
						<li><a href="#">이메일무단수집거부</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">개인정보처리방침</a></li>
						<li><a href="#">윤리경영</a></li>
					</ul>
				</section>
				<section class="footer-info_content">
					<address class="footer-txt">(04377)서울특별시 용산구 한강대로 23길 55, 아이파크몰 6층(한강로동)</address>
					<ul>
						<li class="footer-txt">대표이사 : 신승용</li>
						<li class="footer-txt">사업자등록번호 : 000-00-00000</li>
						<li class="footer-txt">통신판매업신고번호 : 2022-휴먼교육센터-0203</li>
					</ul>
					<p class="footer-inner_copyright footer-txt">© CJ CGV. All Rights Reserved</p>
				</section>
			</div>
    	</div>
    </footer>

</body>
</html>
