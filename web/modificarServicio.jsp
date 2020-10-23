<%-- 
    Document   : modificarServicio
    Created on : 23/10/2020, 00:26:18
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar servicio</title>
    </head>
    <body>
        <h1>Modificar Servicio</h1>

		<form method="POST" action="/EjemploJSPconAutenticacion/ModificarServlet"> 
			<div class="form-group">
				<label for="cboTipo">Tipo</label>
				<select name="cboTipo" >

					<c:forEach var="t" items="${serviciodto.listaTipoServicios}">
						<option value="${t.id}" <c:if test="${t.id == serviciodto.servicio.tipo.id}"> selected</c:if>>${t.descripcion}</option>
					</c:forEach>


				</select>
			</div> 
			<input type="hidden" name="txtId" value="${serviciodto.servicio.id}" />
			<div class="form-group">
				<label for="txtDescripcion">Descripcion</label>
				<input type="text" name="txtDescripcion" id="txtDescripcion" value="${serviciodto.servicio.descripcion}"/>
			</div> 
			<div class="form-group">
				<label for="txtCosto">Costo</label>
				<input type="number" name="txtCosto" value="${serviciodto.servicio.costo}"/>
			</div> 

			<input type="submit" value="Enviar" class="btn btn-primary" />
		</form>
    </body>
</html>
