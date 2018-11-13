<%@page import="negocio.Usuario"%>
<%@page import="negocio.Conta"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contas</title>

</head>
<body>
	<%
	List<Conta> contas = (List<Conta>)request.getAttribute("listaContas");
	Usuario usuario = (Usuario)request.getAttribute("userLogado");
	float debito = 0;
	float credito = 0;
	%>
	<form action="ContaController" method="get">
	<input type="hidden" name="idLogado" value="<%=usuario.getId()%>"> 	
	<h4>Olá, <%=usuario.getNome()%>(<%=usuario.getEmail()%>)</h4>
	<%if(contas != null) {%>
	
		<table border="1">
			<tr>
				<th width="150">Descrição</th>
				<th width="75">Valor</th>
				<th width="75">Tipo</th>
			</tr>
	<%for(Conta c : contas) {
		if(c.isDebito()) {
			debito = debito + c.getValor();
			
		} else {
			credito = credito + c.getValor();
		}
	%>		
			<tr>
				<td><%=c.getDescricao()%></td>
				<td align="center"><%=c.getValor()%></td>
				<td align="center"><%=c.isDebito() ? 'D' : 'C'%></td>
			</tr>
		<%}%>
		</table>
			<h3>Credito: <%=credito%></h3>
			<h3>Debito: <%=debito%></h3>
			<h3>Saldo: <%=credito-debito%></h3>
		<%} %>
	
		<hr>
		<input type="submit" value="Voltar">
	</form>
</body>
</html>