<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%=request.getParameter("username") %>
	<br/>
	${param.username}
	
	<br/>
	
	<%=request.getParameterValues("interest")[0] %>
	${paramValues.interest[0]}
</body>
</html>