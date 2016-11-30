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
		
		function fn_replyDelete(reno){
		    if (!confirm("삭제하시겠습니까?")) {
		        return;
		    }
		    var form = document.form2;

		    form.action="CatTubeServlet";
		    form.reno.value=reno;
		    form.submit();
		}
		var updateReno = updateRememo = null;
		function fn_replyUpdate(reno){
			if (!confirm("수정하시겠습니까?")) {
		        return;
		    }
			var form = document.form2;
			form.reno.value=reno;
		}
		
	</script>
    
	<title>CatTube</title>
</head>
<style>
	body{
		font-size:1.4em;
	}
</style>
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
				<c:forEach items="${boardList.articleList}" var="article">
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
					<a href="CatTubeServlet?command=board_list">홈</a>
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
						<td>게시일 ${bvo.writeDate}</td>
					</tr>
					<tr>
						<td>${bvo.content}</td>
					</tr>
					
				</table>
				<br>
			</div>


			<div style="width: 100%; height: auto; padding: 15px; margin-top: 15px; background-color: #FFFFFF">
				<form name="form1" action="CatTubeServlet" method="post">
					<input type="hidden" name="command" value="board_reply"/>
					<input type="hidden" name="articleNum" value="<c:out value="${bvo.num}"/>">
					작성자 : <input type="text" name="writer" value="<c:out value="${sessionScope.loginId }"/>"
							style="border:0;" readonly><br>
					<c:if test="${not empty sessionScope.loginId }">
					<textarea name="rememo" rows="4" cols="50" maxlength="100" placeholder="댓글 입력"></textarea>
					<input type="submit" value="쓰기">
					</c:if>
					
					<c:if test="${empty sessionScope.loginId }">
					<textarea name="rememo" rows="4" cols="50" maxlength="100" placeholder="댓글 입력" disabled></textarea>
					<input type="button" value="쓰기" onclick="">
					</c:if>
				</form>
			
			
			<c:forEach var="reply" items="${replyList}">
			<c:choose>
			<c:when test="${bvo.num eq reply.articleNum}">
				<div id="<c:out value="${reply.reNo }"/>" style="border:0;">
					<div id="content<c:out value="${reply.reNo }"/>">
					<br>
					<c:out value="${reply.reWriter}"/> <c:out value="${reply.reDate}"/>
					<c:if test="${sessionScope.loginId eq reply.reWriter}">
						<a href="#" id="update" onclick="fn_replyUpdate('<c:out value="${reply.reNo}"/>')">수정</a>
						<a href="#" onclick="fn_replyDelete('<c:out value="${reply.reNo}"/>')">삭제</a>
					</c:if>
						<div id="reply<c:out value="${reply.reNo}"/>">
							<c:out value="${reply.reMemo}"/>
						</div>
					</div>
				</div>
			</c:when>
			</c:choose>
			</c:forEach>
			</div>
		</div>
		
		<div id="replyDiv" style="border:1px solid; width:300px; display:none">
	    <form name="form2" action="CatTubeServlet" method="post">
	    	<input type="hidden" name="command" value="reply_delete">
	    	<input type="hidden" name="command" value="reply_update">
	        <input type="hidden" name="articleNum" value="<c:out value="${bvo.num}"/>">
	        <input type="hidden" name="reno">
	        <div id="text">
	        <textarea name="rememo" rows="3" cols="30" maxlength="500"></textarea>
	        <a href="#" onclick="fn_replyUpdateSave()">저장</a>
	        <a href="#" onclick="fn_replyUpdateCancel()">취소</a>
	        </div>
	    </form>
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
