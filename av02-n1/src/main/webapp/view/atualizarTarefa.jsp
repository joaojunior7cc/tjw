<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>App Lista Tarefas</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>Atualizar Tarefa</h2>
	<a href="./index.jsp">Home</a>
<form action="TarefaCtrl" method="get">
	<label for="nTarefa">Descrição da tarefa:</label>
	<input type="hidden" name="id" value="<c:out value="${id}" />"><br>
  	<input type="text" name="descricao" placeholder="Atualizar" value="<c:out value="${descricao}" />"><br>  
  	<input type="text" name="status_id" placeholder="Status (1 ou 2)" value="<c:out value="${status_id}" />"><br>
  	<input type="text" name="data" placeholder="data: 2020-01-01" value="<c:out value="${data}" />"><br>
  	<input type="submit" name="tarefa" value="Atualizar"/>
</form>
</body>
</html>