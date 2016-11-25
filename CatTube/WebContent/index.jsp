<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
  
  	<link rel="icon" href="img/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="css/style.css"> <!-- Resource style -->
	<script src="js/modernizr.js"></script> <!-- Modernizr -->
    
	<script type="text/javascript">
	function test_key(){
		alert(document.getElementByName('search').value);
		if(frm.getElementByName('search').value=''){
			alert("asd");
		}
	}
	</script>
	
<title>Responsive Sidebar Navigation | CodyHouse</title>
</head>
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
				
				<%-- <datalist id="keywords">
				<c:forEach items="${boardList.articleList}" var="article">
					<option value="${article.title}">
				</c:forEach>
				</datalist> --%>
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
		<div style="width:100%; line-height:40px; background-color: #FFFFFF">
			<a>홈</a>
			<a>인기</a>
		</div>
		
		<div class="content-wrapper" align="center"  style="background-color: #EAEAEA">
			
		
		
			<table border="1">
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td>
				<a href="CatTubeServlet?command=board_read&num=${board.num }">
				<img src="${board.imagePath}" 
				alt="cat 00 image" width="128" height="128">
				</a>
				</td>
			</tr>
			<tr>
				<td>${board.title}</td>
			</tr>
			<tr>
				<td colspan="2">${board.writer}</td>
			</tr>
				<td>조회수 ${board.readCount} 회</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;
					${board.writeDate}</td>
			</c:forEach>
			</table>
		</div> <!-- .content-wrapper -->
			</main> <!-- .cd-main-content -->
			
			<!---------------------- footer ---------------------->
			<%-- <div id="footer" style="height:50px;clear:both;">
				<jsp:include page="footer.jsp"/>  
			</div> --%>
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>
