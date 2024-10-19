<%@page import="com.beans.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autores</title>
</head>
<body>
<table id = "tabla">
	<thead>
		<tr>
			<th>Codigo del autor</th>
			<th>nombre del autor</th>
			<th>nacionalidad</th>
			<th>Operaciones</th>
		</tr>
	</thead>
	
	<tbody>
	<%
	List<Autor> listaAutores =(List<Autor>) request.getAttribute("listaAutores");
	if(listaAutores != null){
		for(Autor autor : listaAutores){
		%>	
		<tr>
				<td><%= autor.getId() %></td>
				<td><%= autor.getNombre() %></td>
				<td><%= autor.getPais() %></td>
				<td></td>				
		</tr>
	<%
		}
	}else{
	%>
		<tr>
			<td>no hay datos</td>
			<td>no hay datos</td>
			<td>no hay datos</td>
			<td></td>
		</tr>
	<%
	}
	%>
		

	
	</tbody>
	</table>
</body>
</html>