<%-- 
    Document   : listado
    Created on : 02/10/2020, 11:13:49
    Author     : mnava
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Servicios</h1>

		<table>

		<%
			ArrayList<Servicio> lista = (ArrayList<Servicio>) request.getAttribute("lista");

			for (Servicio servicio : lista) {
				out.print("<tr><td>"+servicio.getId()+"<td><td>"+servicio.getTipo().getDescripcion()+"<td><td>"+servicio.getDescripcion()+"<td><td>"+servicio.getCosto()+"<td></tr>");
			}

		%>

		</table>
    </body>
</html>
