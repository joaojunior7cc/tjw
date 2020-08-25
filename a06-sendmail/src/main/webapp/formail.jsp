<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8>
<title>Formulário de Envio de E-mails</title>
</head>
<body>
<div> 
<h1 align=center>Formulário de Envio de Emails</h1>  
<p align=center>Captura automática de parâmetros da Requisição usando JavaBeans - <a href=Logout>Sair</a></p>  
</div>

<%
String user = (String) request.getSession().getAttribute("usuario");

if (user == null){
	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	dispatcher.forward(request, response);
	
}
%>
<form action="SendMail2.jsp" method="post" name="form_sendmail" > 
  <p>&nbsp;</p> 
  <table width=230 border=0 align=center>
    <tr>
      <td width=70>Assunto:</td>
      <td width=144><input type=text name=assunto></td>
    </tr>
    <tr>
      <td>Destinatário:</td>
      <td><input type=text name=destinatario></td>
    </tr>
    <tr>
      <td>Mensagem: </td>
      <td><textarea name=mensagem id=textarea cols=45 rows=5></textarea></td> 
    </tr>
    <tr> 
      <td></td>
      <td><input type=submit name=sendmail value=Enviar e-mail></td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>
</body>
</html>