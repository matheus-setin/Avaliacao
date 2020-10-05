<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Usuario.DadosUsuario"%>
<%@page import="Usuario.BancoUsuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Encontrado</title>
</head>
<body>

		<h1>Usuario ${usuario.nome} encontrado</h1>

		<%
		List<DadosUsuario> x =  (List<DadosUsuario>) request.getAttribute("lista");
		for (DadosUsuario du : x){
		
	 	%>
		
		<h2>
		
			Nome: <%= du.getNome() %><br>
			email: <%= du.getEmail() %><br>
			Telefone: <%= du.getTelefone() %><br>
		
		</h2>
		
		<%
	
		}
	
		%>

</body>
</html>