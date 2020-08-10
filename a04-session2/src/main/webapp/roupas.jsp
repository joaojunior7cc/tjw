<%@page import="net.sytes.joaojunior.servlet.AddCarrinhoServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	
	import="javax.servlet.http.HttpServletRequest"
    import="javax.servlet.http.HttpSession"

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>POG-Varejo ;)</title>
	<script>
	function url(){
		console.log(document.URL);
	}
	</script>
</head>
<body onload="url()">	

	<%!	
		//String msg = "Olá dia: ";
	%>
	
	<h2>Departamento de Roupas</h2>	

	<form id="formulario" name="form" method="GET" action="AddCarrinhoServlet">
		<br/>Camisas:
		<select name="sel-prod">
		  <option value="Camisa Branca" selected="selected">Camisa Branca</option> 
		  <option value="Camisa Preta" >Camisa Preta</option>
		  <option value="Camisa Azul">Camisa Azul</option>
		</select>
		<input type="submit" name="btn" value="Add Carrinho">		
		<br/><br/><br/><br/>		
	</form>
	
 	<form method="post" action="LimparCarrinhoServlet">
		<input type="submit" name="btn" value="Limpar Carrinho">
		<br/><br/><br/><br/>
	</form>
	
 	<form method="get" action="VerificarCarrinhoServlet">
		<input type="submit" name="btn" value="Verificar Carrinho">
		<br/><br/><br/><br/>
	</form>
</body>
</html>