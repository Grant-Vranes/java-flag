<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<%!
		int i = 100;
		int sum(int a1, int a2){
			return a1+a2;
		}
	%>
	<%=i+100 %>
	<%=sum(1,2) %>
</body>
</html>