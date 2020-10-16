<%-- 
    Document   : altaServicio
    Created on : 02/10/2020, 11:43:30
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <h1>Alta Servicio</h1>

		<form method="POST" action="/EjemploJSPconAutenticacion/AltaServicioServlet" onsubmit="return validar();"> 
			<div class="form-group">
				<label for="cboTipo">Tipo</label>
				<select name="cboTipo" >

					<c:forEach var="t" items="${lista}">
						<option value="${t.id}">${t.descripcion}</option>
					</c:forEach>


				</select>
			</div> 
			<div class="form-group">
				<label for="txtDescripcion">Descripcion</label>
				<input type="text" name="txtDescripcion" id="txtDescripcion"/>
			</div> 
			<div class="form-group">
				<label for="txtCosto">Costo</label>
				<input type="number" name="txtCosto"/>
			</div> 

			<input type="submit" value="Enviar" class="btn btn-primary" />
		</form>
    </body>
	<script>
		function validar() {
			let txtDescripcion = document.getElementById("txtDescripcion").value;
			if (!txtDescripcion) {
				alert("Debe incluir una descripcion");
				return false;
			}
			return true;
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
