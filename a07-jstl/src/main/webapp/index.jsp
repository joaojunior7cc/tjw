<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
	<title>JSTL</title>
</head>
<body>
	<sql:setDataSource var="bd" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/tjw" user="root" password="112233-Mysql"/>
	<sql:query dataSource="${bd}" sql="select * from tbl_user" var="result"/>
	<table border="1" width="100%">
		<tr>
			<th>Usuário</th>
			<th>Senha</th> 
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.user}"/></td>
				<td><c:out value="${row.passwd}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
