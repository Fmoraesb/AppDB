<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalhe da Conta</title>
</head>
<body>

<%Long id = Long.valueOf((String)request.getAttribute("idLogado")); %>

	<form action="ContaController" method="post">
	<input type="hidden" name="idLogado" value="<%=id%>">
		<input type="submit" value="Lan�ar conta">
		
		<hr>
		
		<h3>Descri��o</h3>
		<input type="text" name="descricao">
		
		<h3>Valor</h3>
		<input type="text" name="valor">
		
		<h3>Tipo</h3>
		<select name="tipo">
			<option value="D">D�bito</option>
			<option value="C">Cr�dito</option>
		</select>
	</form>
</body>
</html>