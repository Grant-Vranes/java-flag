<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<!-- 这个要和a3.jsp连起来看，目的主要是为了证明pageContext是独属于一个jsp实例的 -->
	<%
		pageContext.setAttribute("username","fighting");
	%>
	<%=pageContext.getAttribute("username")%>
</body>
</html>