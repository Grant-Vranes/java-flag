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
		user.setUsername("李白");
		user.setGender("m");
		request.setAttribute("user",user);
	%>
	用户名：${user.username}
	性别：<c:if test="${user.gender == 'm'}">男</c:if>
	性别：<c:if test="${user.gender == 'm'}" var="rs" scope="page">男</c:if>
		 <c:if test="${!rs}">女</c:if>
</body>
</html>