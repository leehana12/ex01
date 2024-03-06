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
	out.println("로그아웃 되었습니다.");
%>
</body>
<script>
const deleteMember = (id) => {
    console.log(id);
    location.href = "/member/delete?id="+id; //delete의 id로받아서 삭제할수 있도록 하는 코드
}
</script>
</html>