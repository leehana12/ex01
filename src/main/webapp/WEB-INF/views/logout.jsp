<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  	HttpSession usersession = request.getSession();
	usersession.invalidate();
	out.println("<h1>로그아웃 되었습니다.</h1>");
%>
<!-- script의 인덱스 함수로 넘어 가겠다는 뜻이다. -->
<button onclick="index()">메인화면</button>
</body>
<script>
	const index = () => {
	    location.href = "/"; //HomeController.java에 설정한 index페이지로 이동하게 해주는것이다.
	}
</script>
</html>