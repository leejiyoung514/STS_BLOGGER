<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<head>
<title>글 쓰기</title>	
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../include/blog_header.jsp" %>
<link href="${pageContext.request.contextPath}/summernote/summernote.css" rel="stylesheet">
<!-- ckeditor의 라이브러리 -->
<%-- <script src="${pageContext.request.contextPath}/include/js/common.js"></script>
<script src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script> --%>

</head>
<body>

<div class="colorlib-loader"></div>
	<div id="page">

		<!-- Navigation section  -->
		<%@ include file="../include/blog_navigation.jsp"%>

		<aside id="colorlib-breadcrumbs">
			<div class="container">
				<div class="row">
					<div class="col-md-12 breadcrumbs text-center">
						<h2>
							<a href="${pageContext.request.contextPath}/${authUser.userid}/about">블로그 관리</a>
						</h2>
						<div class="col-md-12">
							<p2>
							<a href="${pageContext.request.contextPath}/${authUser.userid}/blog/cate">카테고리 관리</a>/ 
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
										<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/${authUser.userid}/post/write">
											<div class="col-md-12">
												<div class="col-md-12">
													<div class="select">
														<select name="cateno">
															<c:forEach items="${cateList}" var="cateDto">
																<option value="${cateDto.cateno}">${cateDto.catename}</option>
															</c:forEach>
														</select>
													</div>
													<input type="text" name="title" style="width:580px;" value="${postDto.title}" placeholder="&nbsp;제목">
												</div>
												<div class="col-md-12"><br/>
													<textarea name="postcontent" id="postcontent" cols="100" rows="10" placeholder="내용을 입력해주세요">${postDto.postcontent}</textarea><br/>
<!-- <script>
CKEDITOR.replace("postcontent",{
	filebrowserUploadUrl:"${pageContext.request.contextPath}/imageUpload",
	height:"300px"
});
</script>	 -->																			
													첨부파일을 등록하세요
													<div class="fileDrop"></div>
													<div id="uploadedList"></div><br/>
													
												<!-- 수정,삭제에 필요한 글번호를 hidden 태그에 저장 -->	
													<input type="hidden" name="postno" value="${postDto.postno}">
													
													<button type="button" id="btnUpdate" >글 수정</button>
													<button type="button" id="btnDelete" >글 삭제</button>
													<button type="button" id="btnList" >글 목록</button>
												</div>
											</div>	
										</form>							
									</div>
                             	</div>
						   	</div>
						</div>
					</div><!-- class="col-md-12"-->
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
	<script src="${pageContext.request.contextPath}/include/js/common.js"></script>
	<!-- include summernote css/js -->
	<script src="${pageContext.request.contextPath}/summernote/summernote.js"></script>
</body>
<script>
$(function(){
				
		$(".fileDrop").on("dragenter dragover",function(e){
			//기본 효과 막음
			e.preventDefault();
		});
		
		$(".fileDrop").on("drop",function(e){
			e.preventDefault();
			//첫번째 첨부파일
			var files=e.originalEvent.dataTransfer.files;
			var file=files[0];
			//폼 데이터에 첨부파일 추가
			var formData=new FormData();
			formData.append("file",file);
			$.ajax({
				url: "${pageContext.request.contextPath}/upload/uploadAjax",
				data: formData,
				dataType: "text",
				processData: false,
				contentType: false,
				type: "post",
				success: function(data){
					//console.log(data);
					//data : 업로드한 파일 정보와 Http 상태 코드
					var fileInfo=getFileInfo(data);
					//console.log(fileInfo);
					var html="<a href='"+fileInfo.getLink+"'>"+
						fileInfo.fileName+"</a><br>";
					html += "<input type='hidden' class='file' value='"
						+fileInfo.fullName+"'>";
					$("#uploadedList").append(html);
				}
			});
		});
		
		//글 목록 
		$("#btnList").click(function() {
			location.href = "${pageContext.request.contextPath}/${authUser.userid}/post";
		});
		
		//수정 버튼
		$("#btnUpdate").click(function(){
			//첨부파일 이름들을 폼에 추가
			var str="";
			$("#uploadedList .file").each(function(i){
				str+=
					"<input type='hidden' name='files["+i+"]' value='"
					+$(this).val()+"'>";
			});
			$("#form1").append(str); 
			document.form1.action="${pageContext.request.contextPath}/${authUser.userid}/post/update";
			document.form1.submit();
		});
		
		//삭제 버튼
		$("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="${pageContext.request.contextPath}/${authUser.userid}/post/delete";
				document.form1.submit();
			}
		});
		
		listAttach();
		
		//첨부파일 삭제
		//id가 uploadedList인 태그의 class가 file_del인 태그 클릭
		$("#uploadedList").on("click",".file_del",function(e){
			var that=$(this); //클릭한 태그
	//data: {fileName: $(this).attr("data-src") },		
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/upload/deleteFile",
				data: "fileName="+	$(this).attr("data-src"),		
				dataType: "text",
				success: function(result){
					if(result=="deleted"){
						//화면에서 태그 제거
						that.parent("div").remove();
					}
				}
			});
		});
		
		$("#btnSave").click(function(){
			var str="";
			// uploadedList 내부의 .file 태그 각각 반복
			$("#uploadedList .file").each(function(i){
				console.log(i);
				//hidden 태그 구성
				str += 
	"<input type='hidden' name='files["+i+"]' value='" + $(this).val()+"'>";
			});
			//폼에 hidden 태그들을 붙임
			$("#form1").append(str);
			document.form1.submit();
		});
});
		
//첨부파일 리스트를 출력하는 함수
function listAttach(){
	$.ajax({
		type: "post",
		url: "${pageContext.request.contextPath}/getAttach/${postDto.postno}",
		success: function(list){
			// list : json
			console.log(list);
			$(list).each(function(){
				var fileInfo=getFileInfo(this);
				console.log(fileInfo);
				var html="<div><a href='"+fileInfo.getLink+"'>"
					+fileInfo.fileName+"</a>&nbsp;&nbsp;";
					html+="<a href='#' class='file_del' data-src='"
						+this+"'>[삭제]</a></div>";
				$("#uploadedList").append(html);
			});
		}
	});
}
	
$(function(){
	//id가 memo인 태그에 summernote 적용
	$("#postcontent").summernote({
		width: 800,
		height: 500
	});
});	
</script>
</html>


