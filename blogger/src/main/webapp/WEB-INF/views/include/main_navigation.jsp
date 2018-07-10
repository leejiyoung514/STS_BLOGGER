<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!-- Navigation section  -->

<div class="navbar navbar-default navbar-static-top" role="navigation">
     <div class="container">

          <div class="navbar-header">
               <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
                    <span class="icon icon-bar"></span>
               </button>
               <a href="#" class="navbar-brand"><img src="${pageContext.request.contextPath}/resources/images/fav.png"></a>
          </div>
          <div class="collapse navbar-collapse">
               <ul class="nav navbar-nav navbar-right">
                    <li class="active">
              			<c:choose>
							<c:when test="${authUser == null }">
								<!-- 로그인 전 메뉴 -->
								<li class="active"><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
								<li class="active"><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
						    </c:when>
					    	<c:otherwise>
								<!-- 로그인 후 메뉴 -->
								<li class="active"><a href="${pageContext.request.contextPath}/${authUser.userid}">내블로그</a></li>
								<li class="active"><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					        </c:otherwise>
			          </c:choose>	
               </ul>
          </div>
 	 </div>
</div>
    