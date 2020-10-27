<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- TJW 2020.1 
	Equipe: Joao Junior
			Samuel Mendes		
 -->
<meta charset="UTF-8">
<title>App Lista Tarefas</title>
</head>
<body>
<h1>App Lista Tarefas</h1>
<!-- <a href="StatusCtrl?opStatus=CadastrarStatus&id=1&status=Pendente"> Cadastrar Status Pendente</a><br/>
<a href="StatusCtrl?opStatus=CadastrarStatus&id=2&status=Concluido"> Cadastrar Status Concluido</a><br/> -->
<form action="StatusCtrl" method="get">
	<input type="submit" name="opStatus" value="CadastrarStatusDefault"/>
</form>
<form action="StatusCtrl" method="get">
	<input type="submit" name="opStatus" value="TodosOsStatus"/>
</form>
<form action="view/novaTarefa.jsp" method="post">
	<input type="submit" name="tarefa" value="CadastrarTarefa"/>
</form>
<form action="TarefaCtrl" method="get">
	<input type="submit" name="tarefa" value="TarefasPendentes"/>
</form>
<form action="TarefaCtrl" method="get">
	<input type="submit" name="tarefa" value="TodasAsTarefas"/>
</form>
</body>
</html>