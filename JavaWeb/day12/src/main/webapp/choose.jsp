<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setGender("x");
		request.setAttribute("user",user);
	%>
	性别：
	<c:choose>
		<c:when test="${user.gender == 'm'}">男</c:when>
		<c:when test="${user.gender == 'f'}">女</c:when>
		<c:otherwise>保密</c:otherwise>		
	</c:choose>
</body>
</html>