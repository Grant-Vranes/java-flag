<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.row1{background-color:#fff8dc;}
	.row2{backgrounf-color:#f0f0f0;}
	
</style>
</head>
<body>
	<%
		List<User> users = new ArrayList<User>();
		for(int i = 0; i < 8; i++){
			User user = new User();
			user.setUsername("user"+i);
			user.setGender("m");
			users.add(user);
		}
		request.setAttribute("users",users);
	%>
	<table width="80%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>用户名</td>
			<td>性别</td>
			<td>下标</td>
			<td>序号</td>
		</tr>
		<c:forEach items="${users}" var="u" varStatus="s">
			<tr class="row${s.index%2+1 }">
				<td>${u.username }</td>
				<td>${u.gender }</td>
				<td>${s.index }</td>
				<td>${s.count }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>