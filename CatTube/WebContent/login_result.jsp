<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login_result.jsp</title>
</head>
<body>
<c:if test="${not empty sessionScope.loginId}">
	<script type="text/javascript">
		alert("로그인 성공");
		location.href="CatTubeServlet?command=board_list";
	</script>
</c:if>

<c:if test="${empty sessionScope.loginId }">
	<script type="text/javascript">
		alert("로그인 실패");
		location.href="CatTubeServlet?command=board_list";
	</script>
</c:if>
</body>
</html>