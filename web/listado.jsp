<%-- 
    Document   : listado
    Created on : 02/10/2020, 11:13:49
    Author     : mnava
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Servicios</h1>

		<table>

			<c:forEach var="servicio" items="${lista}">
				<tr>
					<td>${servicio.id}</td>
					<td>${servicio.tipo.descripcion}</td>
					<td>${servicio.descripcion}</td>
					<td>${servicio.costo}</td>
					<td><a href="/EjemploJSPconAutenticacion/EliminarServlet?id=${servicio.id}">eliminar</a></td>
				</tr>
			</c:forEach>

		</table>
	</body>
</html>
