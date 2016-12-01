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
	
<style type="text/css">
.filebox label {
  display: inline-block;
  padding: .5em .75em;
  color: #999;
  font-size: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #fdfdfd;
  cursor: pointer;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
}

.filebox input[type="file"] {  /* ���� �ʵ� ����� */
  position: absolute;
  width: 1px;
  height: 1px;
  padding: 0;
  margin: -1px;
  overflow: hidden;
  clip:rect(0,0,0,0);
  border: 0;
}
/* named upload */
.filebox .upload-name {
  display: inline-block;
  padding: .5em .75em;  /* label�� �е����� ��ġ */
  font-size: inherit;
  font-family: inherit;
  line-height: normal;
  vertical-align: middle;
  background-color: #f5f5f5;
  border: 1px solid #ebebeb;
  border-bottom-color: #e2e2e2;
  border-radius: .25em;
  -webkit-appearance: none; /* ����Ƽ�� ���� ���߱� */
  -moz-appearance: none;
  appearance: none;
  }
</style>

	<script src="js/modernizr.js"></script> <!-- Modernizr -->
	<script src="js/jquery-3.1.1.min.js"></script>
	
	<script type="text/javascript">
		function test_key(){
			var data = document.getElementById("search");
			if(data.value==''){
				alert("�˻�� �Է��ϼ���.");
			}
		}
		
		$(document).ready(function(){
			  var fileTarget = $('.filebox .upload-hidden');

			  fileTarget.on('change', function(){  // ���� ����Ǹ�
			    if(window.FileReader){  // modern browser
			      var filename = $(this)[0].files[0].name;
			    } 
			    else {  // old IE
			      var filename = $(this).val().split('/').pop().split('\\').pop();  // ���ϸ� ����
			    }
			    
			    // ������ ���ϸ� ����
			    $(this).siblings('.upload-name').val(filename);
			    var form = document.frm;
			    
			    form.action="CatTubeServlet";
			    form.submit();
			  });
			}); 
		
		
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
				<li><a href="CatTubeServlet?command=login_form">���ε�</a></li>
				</c:if>
				<c:if test="${not empty sessionScope.loginId }">
				<li><a href="CatTubeServlet?command=board_upload">���ε�</a></li>
				</c:if>
				
				<li style="margin-right:15px;">
					<c:if test="${not empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=member_logout">�α׾ƿ�</a>
					</c:if>
					<c:if test="${empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=login_form">�α���</a>
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
					<a href="http://localhost:8082/CatTube/CatTubeServlet?command=board_list">Ȩ</a>
					
					<!-- <ul>
						<li><a href="#0">All Data</a></li>
						<li><a href="#0">Category 1</a></li>
						<li><a href="#0">Category 2</a></li>
					</ul> -->
				</li>
				
				<li class="has-children users">
					<c:if test="${not empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=my_channel">�� ä��</a>
					</c:if>
					
					<c:if test="${empty sessionScope.loginId }">
						<a href="CatTubeServlet?command=login_form">�� ä��</a>
					</c:if>
					
					<!-- <ul>
						<li><a href="#0">All Comments</a></li>
						<li><a href="#0">Edit Comment</a></li>
						<li><a href="#0">Delete Comment</a></li>
					</ul> -->
				</li>
				
				<li class="has-children comments">
					<a href="#0">�α�</a>
					
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
					<a href="#0">����<span class="count">+ 999</span></a>
					
					<!-- <ul>
						<li><a href="#0">����1</a></li>
						<li><a href="#0">����2</a></li>
						<li><a href="#0">����3</a></li>
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
						
			<div class="filebox">
			<form name="frm" enctype="multipart/form-data">
				<input type="hidden" name="command" value="upload_data">
				<input type="hidden" class="upload-name" name="fileUpload" value="���ϼ���" disabled="disabled">
					
				<label for="ex_filename">
				<img src="img/tap(2).png" 
					onmouseover="this.src='img/tap(1).png'"
					onmouseout="this.src='img/tap(2).png'">
				</label>
				<input type="file" id="ex_filename" class="upload-hidden" accept="video/*">
			</form>
			</div>
			
			<br><br>
			<font size="5">���ε��� ������ ����</font>
			<div>&nbsp;</div>
			<p>�Ǵ� ������ ������ �巡�� �� ���</p>
		
		</div>
	</div> <!-- .content-wrapper -->
			</main> <!-- .cd-main-content -->
<script src="js/jquery-2.1.4.js"></script>
<script src="js/jquery.menu-aim.js"></script>
<script src="js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>
