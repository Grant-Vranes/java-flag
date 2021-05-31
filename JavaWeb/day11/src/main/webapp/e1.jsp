<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	算数运算<br/>
	${1+1}<br/>
	${'a' + 'b'}<br/>
	${'1' + '2'}<br/>
	
	关系运算<br/>
	${1 < 2}<br/>
	<% request.setAttribute("s1","abc"); %>
	${s1 == 'abc'}<br/>
	${requestScope.s1 == 'abc'}<br/>
	
	逻辑运算<br/>
	${1<2 && 3>5}
	
	empty运算<br/>
	<%
		List<String> list1 = new ArrayList<String>();
		request.setAttribute("list1",list1);
		
		pageContext.setAttribute("s2", "");
	%>
	空的集合：${empty list1}<br/>
	空字符串：${empty s2}<br/>
	null值：${empty null}<br/>
	找不到对应的值：${empty aa}
</body>
</html>