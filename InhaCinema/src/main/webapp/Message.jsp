<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
	Object obj = session.getAttribute("message");
	String message = "";
	if(obj != null) message = "처리 결과 : " + obj.toString();
	session.removeAttribute("message");
%>
	<div style="text-align: center; margin: 30px auto; font-color: yellow"><%=message %></div>
</body>
</html>