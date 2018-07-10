<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- views/include/blog_navigation.jsp -->

<nav class="colorlib-nav" role="navigation">
	<div class="top-menu">
		<div class="container">
			<div class="row">
				<div class="col-xs-2">
					<div id="colorlib-logo">
						<a href="${pageContext.request.contextPath}/">BLOGGER</a>
					</div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li><a href="${pageContext.request.contextPath}/${blogDto.userid}">${blogDto.blogtitle}</a></li>
						<li><a href="${pageContext.request.contextPath}/${blogDto.userid}/about">About Me</a></li>
						<c:choose>
							<c:when test="${authUser == null }">
								<!-- 로그인 전 메뉴 -->
								<li class="active"><a href="${pageContext.request.contextPath}/user/login">로그인 </a></li>
							</c:when>
							<c:otherwise>
								<!-- 로그인 후 메뉴 -->
								<c:if test="${blogDto.userid eq authUser.userid }">
									<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
									<li class="has-dropdown"><a
										href="${pageContext.request.contextPath}/${authUser.userid}/about/update">계정
											관리</a>
										<ul class="dropdown">
											<li><a href="${pageContext.request.contextPath}/${authUser.userid}/about/update">프로필 수정</a></li>
											<li><a href="${pageContext.request.contextPath}/${authUser.userid}/account/update">회원정보 재설정</a></li>
										</ul></li>
									<li class="has-dropdown"><a
										href="${pageContext.request.contextPath}/${authUser.userid}/blog/cate">블로그 관리</a>
										<ul class="dropdown">
											<li><a href="${pageContext.request.contextPath}/${authUser.userid}/blog/cate">카테고리 관리</a></li>
											<li><a href="${pageContext.request.contextPath}/${authUser.userid}/post">글 관리 </a></li>
										</ul></li>
								</c:if>
								<li class="active"><a href="${pageContext.request.contextPath}/user/logout">로그아웃 </a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>
