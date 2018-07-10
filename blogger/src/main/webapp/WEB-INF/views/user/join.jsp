<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
	<title>회원가입페이지</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="../include/main_header.jsp" %>
</head>

<body style="background-color: #666666;">
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" id="join-form" method="post" action="${pageContext.request.contextPath}/user/join">
					<span class="login100-form-title p-b-43">
						Blogger 회원가입
					</span>
					
					<div class="wrap-input100 validate-input" >
						<input class="input100" type="text" id="name" name="name" placeholder="이름">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>
										
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" id="userid" name="userid" placeholder="아이디">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>
				    <p style="display:inline-block;"  id="checkid-msg" class="form-error">&nbsp;</p>
					<input class="login100-form-btn1" id="btn-checkid" type="button" value="id 중복체크">
					<input type="hidden" id="isIdCheck" value="false">
					<br/>
					
					<div class="wrap-input100 validate-input">
						<input class="input100" type="password" id="passwd" name="passwd" placeholder="비밀번호">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" id="email" name="email" placeholder="이메일">
						<span class="focus-input100"></span>
						<span class="label-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-32">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="agreeProv" value="y">
							<label class="label-checkbox100" for="ckb1">
								서비스 약관에 동의합니다.
							</label>
						</div>
					</div>
					
					<div class="container-login100-form-btn">
						<input class="login100-form-btn" type="submit" value="가입하기">
					</div>
					
					<div class="text-center p-t-46 p-b-20">
						<span class="txt2">
				        계정이 있으신가요?  <a href="${pageContext.request.contextPath}/user/login" class="txt1">로그인</a>
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
<script>
//아이디체크 
	$("#btn-checkid").on("click", function(){
		console.log("id체크");
		var $userid = $("#userid").val();
		console.log($userid);
		$.ajax({
			url : "${pageContext.request.contextPath }/user/idCheck",
			type : "post",
			data : {userid : $userid},
			dataType : "json",
			success : function(isExist) {
				if(isExist==false){
					$("#checkid-msg").html("사용할 수 있는 아이디 입니다.");
					$("#checkid-msg").css("color","blue");
					$("#isIdCheck").val("true");
					
				}else{
					$("#checkid-msg").html("다른 아이디로 가입해 주세요.");
					$("#checkid-msg").css("color","red");
					return false;
				}				
				console.log(isExist);
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});

	$("#join-form").on("submit", function() {
		var status = finalCheck(); //입력 폼에 입력한 상황체크
		if (status == true) {
			return true;
		} else {
			return false;
		}
	});

	function finalCheck() {
		if (!$("#name").val()) { //name을 입력하지 않으면 수행
			alert("이름을 입력해주세요");
			$("#name").focus(); //입력 포커스 이동
			return false; //함수종료
		}

		if (!$("#userid").val()) { //name을 입력하지 않으면 수행
			alert("아이디를 입력해주세요");
			$("#userid").focus(); //입력 포커스 이동
			return false; //함수종료
		}

		if ($("#isIdCheck").val() != "true") {
			alert("아이디 중복체크를 해주세요.");
			$("#id").focus();
			return false;
		}

		if (!$("#passwd").val()) { //password을 입력하지 않으면 수행
			alert("비밀번호를 입력해주세요");
			$("#passwd").focus(); //입력 포커스 이동
			return false; //함수종료
		}

		if (!$("#email").val()) { //password을 입력하지 않으면 수행
			alert("이메일을 입력해주세요");
			$("#email").focus(); //입력 포커스 이동
			return false; //함수종료
		}

		if ($("#ckb1:checked").length < 1) { //agree-prov을 입력하지 않으면 수행
			alert("약관에 동의해 주세요");
			$("#ckb1").focus(); //입력 포커스 이동
			return false; //함수종료
		}
		return true;
	}
</script>
</html>

