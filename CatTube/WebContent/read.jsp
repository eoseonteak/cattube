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
	<script>
		function test_key(){
			var data = document.getElementById("search");
			if(data.value==''){
				alert("검색어를 입력하세요.");
			}
		}
	</script>
    
	<title>SearchList.jsp</title>
</head>
<style>
	body{
		font-size:1.4em;
	}
</style>
<body>
	<header class="cd-main-header">
		<a href="http://localhost:8082/CatTube/CatTubeServlet?command=board_list" class="cd-logo">
		<img src="img/cat_2.gif" width="123" height="30">
		</a>
		
		<div class="cd-search is-hidden">
			<form action="BoardServlet" method="post">
				<input type="hidden" name="command" value="board_search">
				<input type="text" list="keywords" autocomplete="on" name="search" placeholder="Search..."
				onkeydown="javascript:if(event.keyCode==13){test_key();}">
				
				<datalist id="keywords">
				<c:forEach items="${boardList.articleList}" var="article">
					<option value="${article.title}">
				</c:forEach>
				</datalist>
			</form>
		</div> <!-- cd-search -->

		<a href="#0" class="cd-nav-trigger">Menu<span></span></a>

		<nav class="cd-nav">
			<ul class="cd-top-nav">
				<li><a href="#0">Tour</a></li>
				<li><a href="#0">Support</a></li>
				<li class="has-children account">
					<a href="#0">
						<img src="img/cd-avatar.png" alt="avatar">
						Account
					</a>

					<ul>

						<li><a href="#0">My Account</a></li>
						<li><a href="#0">Edit Account</a></li>
						<li><a href="#0">Logout</a></li>
					</ul>
				</li>
			</ul>
		</nav>
		
	</header> <!-- .cd-main-header -->

	<main class="cd-main-content">
		<nav class="cd-side-nav">
			<ul>
				<li class="cd-label">Main</li>
				<li class="has-children overview">
					<a href="#0">홈</a>
					<!-- <ul>
						<li><a href="#0">All Data</a></li>
						<li><a href="#0">Category 1</a></li>
						<li><a href="#0">Category 2</a></li>
					</ul> -->
				</li>
				
				<li class="has-children users">
					<a href="#0">내채널</a>
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
				</li>
				<li class="has-children images">
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
		
		<div class="content-wrapper" style="background-color: #EAEAEA">
		<div style="width:70%; height:auto; float: left; background-color: #EAEAEA">
			<div style="margin-top:15px;">
				<iframe src="${bvo.videoPath}" height="360" width="100%">
				</iframe>
			</div>
			
			<div style="width: 100%; height: auto; margin-top:15px; padding: 15px; background-color: #FFFFFF">
				<table>
					<tr style="padding:10px;">
						<td colspan="8">${bvo.title}</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td rowspan="2">
							<img src="img/user.png" style="width: 48px; height: 48px;">
						</td>
						<td valign="middle">ID12345677</td>
					</tr>
					<tr>
						<td><img src="img/subscribe.png" style="vertical-align:middle;"></td>
						<td>1,223</td>
						<td style="width: 200px" align="right">조회수 ${bvo.readCount}회</td>
					</tr>
					<tr>
						<td colspan="9">
							<hr width=100%>
						</td>
					</tr>
					<tr>
						<td><img src="img/add.png" style="vertical-align:middle;">&nbsp;추가&nbsp;</td>
						<td align="center"><img src="img/next.png" style="vertical-align:middle;">&nbsp;공유</td>
						<td><img src="img/more.png" style="vertical-align:middle;">&nbsp;더보기</td>
						<td style="width: 400px" align="right">
							<img src="img/thumb-up.png">9,999 &nbsp;
							<img src="img/thumb-down.png">1,234
						</td>
					</tr>
				</table>
			</div>
			<div style="width: 100%; height: auto; padding: 15px; margin-top: 15px; background-color: #FFFFFF">
				<table>
					<tr>
						<td>게시일:2016.11.14</td>
					</tr>
					<tr>
						<td>${bvo.content}</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td width="100px">카테고리</td>
						<td>동물</td>
					</tr>
					<tr>
						<td>라이센스</td>
						<td>표준 CatTube 라이센스</td>
					</tr>
				</table>
			</div>

			<div style="width: 100%; height: auto; padding: 15px; margin-top: 15px; background-color: #FFFFFF">
				댓글 96개
				<pre>
				1
				2
				3
				4
				</pre>
			</div>
		</div>

		<!--리스트  -->		
		<div
			style="height: auto; display:inline-block; margin-left:15px; margin-top:15px; background-color: #FFFFFF">
			<table>
				<tr>
					<td><iframe src="http://www.youtube.com/embed/bEknnqRsLYI"
							height="200" width="200"></iframe> <br>올린사람<br> 조회수
						9999회<br></td>
				</tr>
				<tr>
					<td><iframe src="http://www.youtube.com/embed/bEknnqRsLYI"
							height="200" width="200"></iframe> <br>올린사람<br> 조회수
						9999회<br></td>
				</tr>
				<tr>
					<td><iframe src="http://www.youtube.com/embed/bEknnqRsLYI"
							height="200" width="200"></iframe> <br>올린사람<br> 조회수
						9999회<br></td>
				</tr>
				<tr>
					<td><iframe src="http://www.youtube.com/embed/bEknnqRsLYI"
							height="200" width="200"></iframe> <br>올린사람<br> 조회수
						9999회<br></td>
				</tr>
				<tr>
					<td><iframe src="http://www.youtube.com/embed/bEknnqRsLYI"
							height="200" width="200"></iframe> <br>올린사람<br> 조회수
						9999회<br></td>
				</tr>
			</table>
		</div>
	</div> <!-- .content-wrapper -->
			</main> <!-- .cd-main-content -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>
