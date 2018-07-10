<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
	<title>로그인페이지</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="../include/main_header.jsp" %>
<script>
$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val(); //태그의 value 속성값
		var passwd=$("#passwd").val();
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.form1.action="${pageContext.request.contextPath}/user/login";
		document.form1.submit();
	});
});
</script>
</head>
<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" name="form1" method="post">
					<span class="login100-form-title p-b-43">
						Blogger 로그인
					</span>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="userid" placeholder="아이디">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="passwd" placeholder="비밀번호">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								아이디 저장
							</label>
						</div>
						<div>
						<a href="#" class="txt1">비밀번호를 잊으셨나요?</a>
						</div>
					</div>
					
					<div class="container-login100-form-btn">
						<input class="login100-form-btn" id="btnLogin" type="button" value="로그인">
					</div><br/>
					
					<c:if test="${param.message == 'nologin' }">
				         <div style="color:red;">
					         로그인 하신 후 사용하세요.
				         </div>				
					</c:if>
					<c:if test="${param.message == 'error'}">
						<div style="color:red;">
						아이디 또는 비밀번호를 다시 확인해 주세요
					</div>
					</c:if>
					<c:if test="${param.message == 'logout'}">
						<div style="color:blue;">
							로그아웃 처리되었습니다.
						</div>
					</c:if>
			
			<%=application.getRealPath("/WEB-INF/views/images/") %> 
			
					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
				        계정이 없으신가요?  <a href="${pageContext.request.contextPath}/user/join" class="txt1">가입하기</a>
						</span>
					</div>

					<div class="login100-form-social flex-c-m">
						<a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
							<i class="fa fa-facebook-f" aria-hidden="true"></i>
						</a>

						<a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
							<i class="fa fa-twitter" aria-hidden="true"></i>
						</a>
					</div>
				</form>

				<div class="login100-more" style="background-image: url('${pageContext.request.contextPath}/resources/images/bg-01.jpg');">
				</div>
			</div>
		</div>
	</div>
 
</body>
</html>

