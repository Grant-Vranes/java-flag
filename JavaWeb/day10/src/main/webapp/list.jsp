<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户展示</title>
</head>
<body style="font-size:30px;">
	<%
		List<User> u = (List<User>)application.getAttribute("users");
		for(User user : u){
			out.println(user.getUsername());
		}
	%>
</body>
</html>