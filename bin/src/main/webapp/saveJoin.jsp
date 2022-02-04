<%--
  Created by IntelliJ IDEA.
  User: spongebob53
  Date: 2022/02/02
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.customer.CustomerDAO" %>
<%@ page import="model.customer.CustomerVO" %>
<jsp:useBean id="CustomerVO" class="model.customer.CustomerVO">
    <jsp:setProperty name="CustomerVO" property="*"/>
</jsp:useBean>
<jsp:useBean id="CustomerInfoVO" class="model.customer.CustomerInfoVO">
    <jsp:setProperty name="CustomerInfoVO" property="*"/>
</jsp:useBean>
<jsp:useBean id="CustomerTermVO" class="model.customer.CustomerTermVO">
    <jsp:setProperty name="CustomerTermVO" property="*"/>
</jsp:useBean>
<!-- 회원가입 정보 저장하기 -->
<%
    request.setCharacterEncoding("UTF-8");
    // 아이디 중복체크
    boolean checkID = CustomerDAO.getInstance().checkID(CustomerVO);
    if (checkID) {
        out.print("<script>alert('아이디 중복!!');</script>");
        out.print("<script>window.history.back();</script>");
    } else {
        // 중복 없는거 확인하고 저장
        CustomerDAO customerDao = CustomerDAO.getInstance();
        if (customerDao.insertC(CustomerVO) == 1) {
            customerDao.insertCInfo(CustomerInfoVO);
            customerDao.insertCTerm(CustomerTermVO);
        }else{
            out.print("<script>alert('오류오류오류!!!!!1');</script>");
        }
        out.print("<script>alert('회원가입 완료!!');</script>");
        out.print("<script>location.href='index.jsp';</script>");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
