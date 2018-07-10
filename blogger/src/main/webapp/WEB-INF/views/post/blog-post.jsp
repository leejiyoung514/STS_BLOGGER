<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<head>
<title>글 관리</title>	
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../include/blog_header.jsp" %>
</head>
<body>
<div class="colorlib-loader"></div>
	<div id="page">
	
	<!-- Navigation section  -->
	<%@ include file="../include/blog_navigation.jsp" %>

		<aside id="colorlib-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12 breadcrumbs text-center">
						<h2><a href="${pageContext.request.contextPath}/${authUser.userid}/about">블로그 관리</a></h2>
						<div class="col-md-12">
							<p2><a href="${pageContext.request.contextPath}/${authUser.userid}/blog/cate">카테고리 관리</a>/
							<a href="${pageContext.request.contextPath}/${authUser.userid}/post"><strong>글 관리</strong></a></p2>
						</div>
					</div>
				</div>
			</div>
		</aside>
		<div id="colorlib-container">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h4 class="heading-2">■ 글 관리</h4>
					</div>
					<div class="col-md-12">
						<div class="row">
							<div class="col-md-6">
								<div class="container">
									<div class="row">
										<div class="col-md-6">
										<!-- 검색폼 -->
											<form name="form1" action="${pageContext.request.contextPath}/${authUser.userid}/post">
												<div class="select">
													<select name="search_option">
														<option value="name" 
													<c:if test="${map.search_option == 'name'}">selected</c:if>
														>이름</option>
														<option value="title"
													<c:if test="${map.search_option == 'title'}">selected</c:if>
														>제목</option>
														<option value="postcontent"
													<c:if test="${map.search_option == 'postcontent'}">selected</c:if>	
														>내용</option>
														<option value="all"
													<c:if test="${map.search_option == 'all'}">selected</c:if>	
														>이름/내용/제목</option>
													</select>
												</div>
												<input id="button" name="keyword" value="${map.keyword}">
												<input id="button" type="submit" value="검색">
											</form>
										</div>
										<div class="col-md-6" style="float: right; width: 100px">
											<!-- 글쓰기 -->
											<button type="button" id="btnWrite">글쓰기</button><br/>
											<%-- BLOGGER[${map.count}] --%>
										</div>
										<!-- 게시물 리스트 -->
										<div class="col-xs-12"><br/>										
											<table class="table table-hover dt-responsive" >
												<thead>
													<tr>
													<!-- 	<th>&nbsp;</th> -->
														<th>번호</th>
														<th>제목</th>
														<th>이름</th>
														<th>날짜</th>
														<th>조회수</th>
													</tr>
												</thead>
												<tbody>
													<!-- forEach var="개별데이터" items="집합데이터" -->
													<c:forEach var="row" items="${map.list}">
														<tr>
															<!-- <td>&nbsp;&nbsp;<input type="checkbox"/>&nbsp;</td> -->
															<td>${row.postno}</td>
															<td><a href="${pageContext.request.contextPath}/${authUser.userid}/post/view?postno=${row.postno}">${row.title}</a></td>
															<td>${row.name}</td>
															<td><fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
															<td>${row.viewcnt}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
										<!-- 페이지 네비게이션 출력 -->
										<div class="col-md-12">
											<div class="container1">
											<!-- << / < -->
												<div class="pagination p8">	
													<c:if test="${map.pager.curBlock > 1}">	
														<a class="is-active" href="#" onclick="list('1')"><<</a>
													</c:if>
													<c:if test="${map.pager.curBlock > 1}">											
														<a class="is-active" href="#" onclick="list('${map.pager.prevPage}')"><</a>
													</c:if>	
												</div>
												
												<div class="pagination p2">
													<ul>
														<c:forEach var="num" begin="${map.pager.blockBegin}" end="${map.pager.blockEnd}">
															<c:choose>
																<c:when test="${num == map.pager.curPage}">																	
																	<a style="color:red;" class="is-active" href="#"><li>${num}</li></a>
																</c:when>
																<c:otherwise>
																	<a href="#" onclick="list('${num}')"><li>${num}</li></a>
																</c:otherwise>
															</c:choose>		
														</c:forEach>
													</ul>
												</div>												
												<div class="pagination p8">
													<c:if test="${map.pager.curBlock < map.pager.totBlock}">
														<a class="is-active" href="#" onclick="list('${map.pager.nextPage}')">></a>
													</c:if>
													<c:if test="${map.pager.curPage < map.pager.totPage}">
														<a class="is-active" href="#" onclick="list('${map.pager.totPage}')">>></a>
													</c:if>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div><!-- class="row"-->
					</div><!-- class="col-md-12"-->
					<div class="col-md-12">
				
					</div>	
					<div class="col-md-12">
						<div class="row">
																								
						</div> <!-- class="row" -->
					</div> <!-- class="col-md-12" -->		
							
				</div><!-- class="row"-->
			</div><!-- class="container"-->
		</div><!-- id="colorlib-container"-->
		
								
			<div id="colorlib-instagram">
				<div class="row">
					<div class="col-md-12 col-md-offset-0 colorlib-heading text-center">
						<h2>Instagram</h2>
					</div>
				</div>
				<div class="row">
					<div class="instagram-entry">
						<a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-1.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-2.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-3.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-4.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-5.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-6.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-7.jpg);">
						</a> <a href="#" class="instagram text-center"
							style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/gallery-8.jpg);">
						</a>
					</div>
				</div>
			</div>
			<footer id="colorlib-footer" role="contentinfo">
				<div class="container">
					<div class="row row-pb-md">
						<div class="col-md-3">
							<h2>Navigational</h2>
							<p>
							<ul class="colorlib-footer-links">
								<li><a href="#"><i class="icon-check"></i> Home</a></li>
								<li><a href="#"><i class="icon-check"></i> About Me</a></li>
								<li><a href="#"><i class="icon-check"></i> Blog</a></li>
								<li><a href="#"><i class="icon-check"></i> Travel</a></li>
								<li><a href="#"><i class="icon-check"></i> Lifestyle</a></li>
								<li><a href="#"><i class="icon-check"></i> Fashion</a></li>
								<li><a href="#"><i class="icon-check"></i> Health</a></li>
							</ul>
							</p>
						</div>
						<div class="col-md-3">
							<h2>Recent Post</h2>
							<div class="f-blog">
								<a href="blog.html" class="blog-img"
									style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/blog-1.jpg);">
								</a>
								<div class="desc">
									<h3>
										<a href="blog.html">Be a designer</a>
									</h3>
									<p class="admin">
										<span>25 March 2018</span>
									</p>
								</div>
							</div>
							<div class="f-blog">
								<a href="blog.html" class="blog-img"
									style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/blog-2.jpg);">
								</a>
								<div class="desc">
									<h3>
										<a href="blog.html">How to build website</a>
									</h3>
									<p class="admin">
										<span>24 March 2018</span>
									</p>
								</div>
							</div>
							<div class="f-blog">
								<a href="blog.html" class="blog-img"
									style="background-image: url(${pageContext.request.contextPath}/resources/images/blog/blog-3.jpg);">
								</a>
								<div class="desc">
									<h3>
										<a href="blog.html">Create website</a>
									</h3>
									<p class="admin">
										<span>23 March 2018</span>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<h2>Archive</h2>
							<p>
							<ul class="colorlib-footer-links">
								<li><a href="#"><i class="icon-check"></i> February
										2018</a></li>
								<li><a href="#"><i class="icon-check"></i> January 2018</a></li>
								<li><a href="#"><i class="icon-check"></i> December
										2017</a></li>
								<li><a href="#"><i class="icon-check"></i> November
										2017</a></li>
								<li><a href="#"><i class="icon-check"></i> October 2017</a></li>
								<li><a href="#"><i class="icon-check"></i> September
										2017</a></li>
							</ul>
							</p>
						</div>
						<div class="col-md-3">
							<h2>Tags</h2>
							<p class="tags">
								<span><a href="#"><i class="icon-tag"></i> Modeling</a></span> <span><a
									href="#"><i class="icon-tag"></i> Fashion</a></span> <span><a
									href="#"><i class="icon-tag"></i> Life</a></span> <span><a
									href="#"><i class="icon-tag"></i> Blog</a></span> <span><a
									href="#"><i class="icon-tag"></i> Workout</a></span> <span><a
									href="#"><i class="icon-tag"></i> Vacation</a></span> <span><a
									href="#"><i class="icon-tag"></i> Travel</a></span> <span><a
									href="#"><i class="icon-tag"></i> Exercise</a></span> <span><a
									href="#"><i class="icon-tag"></i> Health</a></span> <span><a
									href="#"><i class="icon-tag"></i> News</a></span> <span><a
									href="#"><i class="icon-tag"></i> Model</a></span> <span><a
									href="#"><i class="icon-tag"></i> Women</a></span> <span><a
									href="#"><i class="icon-tag"></i> Animals</a></span> <span><a
									href="#"><i class="icon-tag"></i> Nature</a></span> <span><a
									href="#"><i class="icon-tag"></i> Art</a></span> <span><a
									href="#"><i class="icon-tag"></i> Sea</a></span> <span><a
									href="#"><i class="icon-tag"></i> Ocean</a></span> <span><a
									href="#"><i class="icon-tag"></i> Office</a></span> <span><a
									href="#"><i class="icon-tag"></i> Home</a></span>
							</p>
						</div>
					</div>
				<div class="row">
					<div class="col-md-12">
						<p>
							<small class="block"> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script>
								All rights reserved | This template is made with <i
								class="icon-heart" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a> <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</small> <small class="block">Demo Images: <a
								href="http://unsplash.co/" target="_blank">Unsplash</a></small>
						</p>
					</div>
				</div>
			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
	</div>

	<!-- jQuery -->
	<script	src="${pageContext.request.contextPath}/resources/js/blog/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${pageContext.request.contextPath}/resources/js/blog/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script	src="${pageContext.request.contextPath}/resources/js/blog/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath}/resources/js/blog/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="${pageContext.request.contextPath}/resources/js/blog/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script	src="${pageContext.request.contextPath}/resources/js/blog/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="${pageContext.request.contextPath}/resources/js/blog/jquery.magnific-popup.min.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/js/blog/magnific-popup-options.js"></script>
	<!-- Main -->
	<script	src="${pageContext.request.contextPath}/resources/js/blog/main.js"></script>

</body>
<script>
	$(function() {
		$("#btnWrite").click(function() {
			location.href = "${pageContext.request.contextPath}/${authUser.userid}/post/write";
		});
	});
	function list(page) {
		location.href = "${pageContext.request.contextPath}/${authUser.userid}/post?curPage=" + page;
	}
</script>
</html>






