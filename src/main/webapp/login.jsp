<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/01/31
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    // 아이디 저장 쿠키 유무 확인
    Cookie[] cookies = request.getCookies();
    String save_id = "";
    String checked = "";
    if(cookies != null){
        for(Cookie c : cookies){
            if(c.getName().equals("save_id")){
                save_id = c.getValue();
                checked = "checked";
            }
        }
    }
%>
<html>
<head>
    <title>로그인</title>
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/text.css" rel="stylesheet" type="text/css">
    <link href="css/logo.css" rel="stylesheet" type="text/css">
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="login">
	
		<div class="login-logo">
			<a href="index.jsp"><img src="img/textLogo-color.png" class="logo-large"></a>
		</div>

		<div class="login-form">		
			<form action="checkLogin.jsp" method="post">
			    <input type="text" name="customer_id" placeholder="아이디" value="<%=save_id%>">
			    <input type="password" name="customer_pw" placeholder="비밀번호">
			    <button type="submit">로그인</button>
			    <input type="checkbox" name="save_id" id="save_id" <%=checked%>>
			    <label for="save_id">아이디 저장</label>
			    <a href="#">아이디 / 비밀번호 찾기</a>
			</form>
		</div>
		<a href="join.jsp">회원가입</a>

	</div>
	

</body>
</html>
