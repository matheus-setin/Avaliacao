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
<title>Cadastrado com Sucesso</title>
</head>
<body>

	<h1>
	 	
	 	O usuario ${usuario.nome} foi cadastrado ao banco de dados
	 	
	</h1>
	
	<h1>Todos usuarios cadastrados:<br></h1>
	
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
