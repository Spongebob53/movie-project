<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/02/02
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.customer.CustomerDAO" %>
<jsp:useBean id="customerVO" class="model.customer.CustomerVO">
    <jsp:setProperty name="customerVO" property="*"/>
</jsp:useBean>
<!-- 계정 확인 결과 가져오기 -->
<%
    request.setCharacterEncoding("UTF-8");
    boolean login = CustomerDAO.getInstance().login(customerVO);
    // 기존 세션이 있으면 없에고 다시 생성해서 충돌을 막아준다
    if(session.getAttribute("customer_id") != null){
        session.removeAttribute("customer_id");
    }
    // 로그인이 성공하면
    if(login){
        Cookie cookie = null;
        // 아이디 저장을 선택했을 때
        if(request.getParameter("save_id") != null){
            cookie = new Cookie("save_id", customerVO.getCustomer_id());
            cookie.setMaxAge(60*60*24*365);
        }else{
            // 아이디 저장을 선택하지 않았을 때
            cookie = new Cookie("save_id", customerVO.getCustomer_id());
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        // 로그인 세션을 만들어서 보낸다
        session.setAttribute("customer_id",customerVO.getCustomer_id());
        //메인 페이지로 이동
        response.sendRedirect("index.jsp");
    }else{
        // 로그인 실패 시 이전 로그인 화면으로 이동
        out.print("<script>alert('아이디 혹은 비밀번호가 틀렸습니다 정확하게 입력해주세요');</script>");
        out.print("<script>window.history.back();</script>");
    }
%>

<html>
<head>
</head>
<body>
<!-- 로그인 성공시 이런식 -->
<%if (login) {%>
<%= customerVO.getCustomer_id()%>님 안녕하세요
<%}%>
</body>
</html>
