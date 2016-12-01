<%@ page contentType="text/html; charset=euc-kr" %>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" href="img/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
	<script src="js/jquery-3.1.1.min.js"></script>
	
	<script type="text/javascript">
		function test_key(){
			var data = document.getElementById("search");
			if(data.value==''){
				alert("검색어를 입력하세요.");
			}
		}
		
		$(function(){
			$(document).on('click','#content',function(){
				if($('#content').text().length>5){
					var str = $(this).text().substring(0,5);
					$(this).text(str+"...");
				}
			})
		})
		
	</script>
    
	<title>CatTube</title>
</head>
<body>
	<header class="cd-main-header">
		<a href="CatTubeServlet?command=board_list" class="cd-logo">
		<img src="img/cat_2.gif" width="123" height="30">
		</a>
		
		<div class="cd-search is-hidden">
			<form action="CatTubeServlet" method="post">
				<input type="hidden" name="command" value="board_search">
				<input type="text" list="keywords" autocomplete="on" name="search" placeholder="Search..."
				onkeydown="javascript:if(event.keyCode==13){test_key();}">
				
				<%-- <datalist id="keywords">
				<c:forEach items="${searchList}" var="article">
					<option value="${article.title}">
				</c:forEach>
				</datalist> --%>
			</form>
		</div> <!-- cd-search -->

		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<nav class="cd-nav">
			<ul class="cd-top-nav">
				<c:if test="${empty sessionScope.loginId }">
				<li><a href="CatTubeServlet?command=login_form">업로드</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.loginId }">
				<li><a href="CatTubeServlet?command=board_upload">업로드</a></li>
				</c:if>
				
				<li style="margin-right:15px;">
					<c:if test="${not empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=member_logout">로그아웃</a>
					</c:if>
					<c:if test="${empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=login_form">로그인</a>
					</c:if>
				</li>
			</ul>
		</nav>
		
	</header> <!-- .cd-main-header -->

	<main class="cd-main-content">
		<nav class="cd-side-nav">
			<ul>
				<li class="cd-label">Main</li>
				<li class="has-children overview">
					<a href="http://localhost:8082/CatTube/CatTubeServlet?command=board_list">홈</a>
					
					<!-- <ul>
						<li><a href="#0">All Data</a></li>
						<li><a href="#0">Category 1</a></li>
						<li><a href="#0">Category 2</a></li>
					</ul> -->
				</li>
				
				<li class="has-children users">
					<c:if test="${not empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=my_channel">내 채널</a>
					</c:if>
					
					<c:if test="${empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=login_form">내 채널</a>
					</c:if>
					
					<!-- <ul>
						<li><a href="#0">All Comments</a></li>
						<li><a href="#0">Edit Comment</a></li>
						<li><a href="#0">Delete Comment</a></li>
					</ul> -->
				</li>
				
				<li class="has-children comments">
					<a href="#0">인기</a>
					
					<!-- <ul>
						<li><a href="#0">All Comments</a></li>
						<li><a href="#0">Edit Comment</a></li>
						<li><a href="#0">Delete Comment</a></li>
					</ul> -->
				</li>
			</ul>


			<ul>
				<li class="cd-label">Secondary</li>
				
				<li class="has-children notifications active">
					<a href="#0">구독<span class="count">+ 999</span></a>
					
					<!-- <ul>
						<li><a href="#0">구독1</a></li>
						<li><a href="#0">구독2</a></li>
						<li><a href="#0">구독3</a></li>
					</ul> -->
				</li>
				
				<!-- <li class="has-children bookmarks">
					<a href="#0">Bookmarks</a>
					
					<ul>
						<li><a href="#0">All Bookmarks</a></li>
						<li><a href="#0">Edit Bookmark</a></li>
						<li><a href="#0">Import Bookmark</a></li>
					</ul>
				</li> -->
				<!-- <li class="has-children images">
					<a href="#0">Images</a>
					
					<ul>
						<li><a href="#0">All Images</a></li>
						<li><a href="#0">Edit Image</a></li>
					</ul>
				</li> -->

				<!-- <li class="has-children users">
					<a href="#0">Users</a>
					
					<ul>
						<li><a href="#0">All Users</a></li>
						<li><a href="#0">Edit User</a></li>
						<li><a href="#0">Add User</a></li>
					</ul>
				</li> -->
			</ul>

			<!-- <ul>
				<li class="cd-label">Action</li>
				<li class="action-btn"><a href="#0">+ Button</a></li>
			</ul> -->
		</nav>
		
		<div class="content-wrapper" align="center"  style="background-color: #EAEAEA">
		&nbsp;
		<div style="width:80%; padding-top:15px; padding-bottom:15px; background-color: #FFFFFF">
			<br><br>
			<!-- <img src="img/tap(2).png" width="20%" 
			onmouseover="this.src='img/tap(1).png'"
			onmouseout="this.src='img/tap(2).png'"/><br><br>
			 -->
			
			
			<span id="fileInputForm" style="position:relative; float:left; 
			width:100px; height:50px; overflow:hidden; cursor:pointer; 
			background-image:url('img/tap(1).png');">
			<input type="file" id="filename" name="filename" 
			value="" style='position：absolute; margin-left:-10px; width:62px; height:18px; 
			filter:alpha(opacity=0); opacity:0; -moz-opacity:0; cursor:pointer;' onChange="fileUpload()">
			</span>
			
			<font size="5">업로드할 파일을 선택</font>
			<div>&nbsp;</div>
			<p>또는 동영상 파일을 드래그 앤 드롭</p>
			
			
		
		</div>
	</div> <!-- .content-wrapper -->
			</main> <!-- .cd-main-content -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>
