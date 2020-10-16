<%-- 
    Document   : menu
    Created on : 02/10/2020, 11:04:54
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

		<%= request.getSession().getAttribute("usuario") %>
		<a href="/EjemploJSPconAutenticacion/LogoutServlet">Salir</a>
		
        <h1>Menú</h1>
		<a href="/EjemploJSPconAutenticacion/AltaServicioServlet">Alta de Servicio</a>
		<a href="/EjemploJSPconAutenticacion/ListadoDeServiciosServlet">Listado de Servicios</a>
		<a href="">Estadisticas</a>
    </body>
</html>
