<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/a6.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%
		String qty = request.getParameter("qty");
		int total = Integer.parseInt(qty) + 100;
		out.println(total);
	%>
</body>
</html>