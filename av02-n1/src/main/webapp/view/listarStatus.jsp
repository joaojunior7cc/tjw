<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	<h2>Listar - <c:out value="${titulo_st}" /></h2>
	<a href="index.jsp">Home</a>
	<table style="width: 80%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Status</th>
				<th colspan=1>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaStatus}" var="stt">
				<tr>
					<td><c:out value="${stt.id}" /></td>
					<td><c:out value="${stt.status}" /></td>
					<td><a href="StatusCtrl?opStatus=ExcluirStatus&statusId=<c:out value="${stt.id}"/>"> Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>
