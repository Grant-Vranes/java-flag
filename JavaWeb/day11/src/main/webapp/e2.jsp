<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%
		//这是本来在Servlet中的代码
		User user = new User();
		user.setUsername("king");
		user.setAge(22);
		user.setLove(new String[]{"cooking","snooker"});
		request.setAttribute("user",user);
	%>
	username:<%
		//User user1 = (User)request.getAttribute("user");
		//out.println(user1.getUsername());
	%>
	<br/>
	username:${user.username}
	
	<br/>
	
	username:${user['username']} <br/>
	
	<%
		pageContext.setAttribute("s1","username");
	%>
	${user[s1]}
	${user[pageScope.s1]}
	${user.love[0]}
</body>
</html>