<%-- 
    Document   : index
    Created on : 16/10/2020, 10:23:50
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
		<form method="POST" action="/EjemploJSPconAutenticacion/LoginServlet">
			<label for="txtUsername">Username</label>
			<input type="text" name="txtUsername"/>
			<label for="txtPassword">Password</label>
			<input type="text" name="txtPassword"/>
			
			<input type="submit" value="Enviar" />
		</form>

		<c:if test="${not empty error}">
			<p>Error: ${error}</p>	
		</c:if>
    </body>
</html>
