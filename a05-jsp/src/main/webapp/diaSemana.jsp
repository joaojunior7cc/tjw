<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.*"

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	Date day = new Date();			
	Calendar cal = Calendar.getInstance();
	int iday = cal.get(Calendar.DAY_OF_WEEK);
	
	//switch aqui deu erro :(
	String diaSemana="";			
	switch (iday) {
	case 1:
		diaSemana="Domingo";
	    break;  
	case 2:
	    diaSemana="Segunda-feira";
	    break;
	case 3:
	    diaSemana="Terça-feira";
	    break;
	case 4:
		  diaSemana="Quarta-feira";
	    break;
	case 5:
		  diaSemana="Quinta-feira";
	    break;
	case 6:
		  diaSemana="Sexta-feira";
	    break;
	case 7:
		  diaSemana="Sabado";
	    break;
	}			
%>
<%= "<br>"+day %>
<%= "<br>"+iday %>
<%= "<br>"+diaSemana %>

<form method="GET" action="SemanaServlet">
	<br/>Dia da Semana (Bean):
	<select name="dia">
	  <option value=<%=iday %> selected="selected"><%=iday %></option> 
	</select>
	<input type="submit" name="btn" value="buscar">		
	<br/><br/><br/><br/>		
</form>
</body>
</html>