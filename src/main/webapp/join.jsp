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
    <title>회원가입</title>
    <link href="css/reset.css" rel="stylesheet" type="text/css">
    <link href="css/text.css" rel="stylesheet" type="text/css">
    <link href="css/logo.css" rel="stylesheet" type="text/css">
    <link href="css/join.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="join">
	
		<div class="join-logo">
			<a href="index.jsp"><img src="img/textLogo-color.png" class="logo-large"></a>
		</div>
		
		<div class="join-form">
			<form action="saveJoin.jsp" method="post">
				<section class="join_member-info">
					<p class="section-title main-txt">회원정보</p>
				   	<input type="text" name="customer_id" class="input-box" placeholder="아이디">
				    <input type="password" name="customer_pw" class="input-box" placeholder="비밀번호">
				    <input type="password" name="customer_chpw" class="input-box" placeholder="비밀번호 확인">
				    <input type="text" name="customer_email" class="input-box" placeholder="이메일">
				    <input type="text" name="customer_name" class="input-box" placeholder="이름">
				    <input type="text" name="customer_tel" class="input-box" placeholder="연락처">
			    </section>
			    
			    <hr>
			    
			    <section class="join_terms">
			    <p class="section-title main-txt">서비스 약관</p>
			    	<div class="terms-box agree-all main-txt">
					    <input type="checkbox" id="agree_all" onclick="checkAll(this)">
					    <label for="agree_all">모두 동의합니다.</label>
				    </div>
				    <div class="terms-box main-txt">
					    <input type="checkbox" name="term_1" id="term_1">
					    <label for="term_1">[필수] 만 14세 이상입니다.</label>
				    </div>
				    <div class="terms-box main-txt">
					    <input type="checkbox" name="term_2" id="term_2">
					    <label for="term_2">[필수] 개인정보 수집 및 이용 동의</label>
				    </div>
				    <div class="terms-box main-txt">
					    <input type="checkbox" name="term_3" id="term_3">
					    <label for="term_3">[선택] 광고성 정보 수신 동의</label>
					</div>
				    <button type="submit" class="btn_join main-txt">가입하기</button>
			    </section>
			</form>
		</div>
	
	</div>

</body>
</html>
