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
    <script>
        function checkAll(checkAll){
            <!-- 모두 체크 함수 만들기 -->
            const checkboxes
                = document.querySelectorAll('input[type="checkbox"]');

            checkboxes.forEach((checkbox) => {
                checkbox.checked = checkAll.checked
            })
        }
    </script>
    <title>Title</title>
</head>
<body>
여기는 회원가입 페이지
<form action="saveJoin.jsp" method="post">
    <input type="text" name="customer_id" placeholder="아이디">
    <input type="password" name="customer_pw" placeholder="비밀번호">
    <input type="password" name="customer_chpw" placeholder="비밀번호 확인">
    <input type="text" name="customer_email" placeholder="이메일">
    <input type="text" name="customer_name" placeholder="이름">
    <input type="text" name="customer_tel" placeholder="연락처">
    <input type="checkbox" id="agree_all" onclick="checkAll(this)">
    <label for="agree_all">모두 동의합니다.</label>
    <input type="checkbox" name="term_1" id="term_1">
    <label for="term_1">[필수] 서비스 약관입니다.</label>
    <input type="checkbox" name="term_2" id="term_2">
    <label for="term_2">[필수] 서비스 약관입니다.</label>
    <input type="checkbox" name="term_3" id="term_3">
    <label for="term_3">[필수] 서비스 약관입니다.</label>
    <button type="submit">가입하기</button>
</form>
</body>
</html>
