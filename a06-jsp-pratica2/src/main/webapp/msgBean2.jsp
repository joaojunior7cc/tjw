<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="msg" class="br.edu.ifce.Mensagem"/>
	<jsp:setProperty property="texto" name="msg" param="msg"/>
	<jsp:getProperty property="texto" name="msg"/>
	
	<%= msg.getTexto()%>

	
</body>
</html>