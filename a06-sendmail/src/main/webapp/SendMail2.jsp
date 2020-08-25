<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.sytes.joaojunior.mail.CommonsMail" 
		 import="org.apache.commons.mail.EmailException"
		 import="java.lang.reflect.InvocationTargetException"	
		 import="java.io.IOException"	 
		
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%System.out.println("SENDMAIL2 OK"); %>
	<jsp:useBean id="m" class="net.sytes.joaojunior.bean.Mail" />
	<jsp:setProperty property="assunto" name="m" param="assunto"/>
	<jsp:setProperty property="mensagem" name="m" param="mensagem"/>
	<jsp:setProperty property="destinatario" name="m" param="destinatario"/>
	
	<%
	System.out.println(m.getDestinatario());
	CommonsMail mail;
	try {
		mail = new CommonsMail();
		mail.enviaEmailSimples(m);
		response.sendRedirect("ResumoEmailsEnviados");			
	} catch (EmailException e) {
		e.printStackTrace();
	}
	%>
</body>
</html>