<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<!-- 
	1- Criar o Maven Project
	2- pom.xml:  
		https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api 
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>

		Criar Servlet:
		2.1- Botao direito em cima da pasta do projeto
		2.2- New>Servlet:
			 Name Package: servlet (OBS: antes ja tem que criar o package main/java)
			 Class name: servlet
		2.3- Configurar o doGet usando request e response
		
	3- Criar um formulario: criei em index.jsp
	4- Criar uma page par login com sucesso: criei webapp/email.jsp	
 -->
	<h2>Hello Servlet!</h2>
	<form id="formulario" name="form" method="post" action="HelloServlet">
		Digite seu login
		<input type="text" name="usuario" id="user">
		
		Senha:
		<input type="password" name="senha" id="pass">
		<input type="submit" name="btn" value="Enter">		
		
	</form>
</body>
</html>
