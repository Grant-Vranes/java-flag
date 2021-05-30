<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="../b2.jsp">相对路径访问b2</a><br/>
	<a href="/day05/good/b1.jsp">绝对路径访问b1</a><br/>
	<a href="<%=request.getContextPath()%>/good/b1.jsp">绝对路径访问b1</a><br/>
	
</body>
</html>