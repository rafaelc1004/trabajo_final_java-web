<%-- 
    Document   : add-asignatura
    Created on : 30 jun 2022, 22:34:29
    Author     : Rafaelito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Asignatura</title>
    </head>
    <body>
        <form id="formulario" method="post" action="ControladorAsignatura">
            <input type="hidden" name="id" id="id" value="${estudiante.idEstudiante}" />
            <div class="mb-3">
                <label for="txtRut" class="form-label">Rut de Estudiante:</label>
                <input type="text" class="form-control" id="txtRut" value='<c:out value="${estudiante.rut}"/>' name="txtRut" aria-label="Disabled input example" disabled readonly>
            </div>
            <div class="mb-3">
                <label for="txtApellido" class="form-label">Apellidos de Estudiante:</label>
                <input type="text" class="form-control" id="txtApellido" value='<c:out value="${estudiante.apellidoEstudiante}"/>' name="txtApellido" aria-label="Disabled input example" disabled readonly>
            </div>
            <div>
                <label for="txtNombre">Nombres de Estudiante: </label>
                <input type="text" id="txtNombre" class="form-control" name="txtNombre" value='<c:out value="${estudiante.nombreEstudiante}"/>' aria-label="Disabled input example" disabled readonly />
            </div>
            <div class="mb-3">
                <label for="txtAsignatura" class="form-label">Asignatura:</label>

                <select class="form-select" name="idAsignatura" id="idAsigatura" aria-label=".form-select-lg " required>
                    <option value="">asignatura</option>
                    <c:forEach var="asignatura" items="${asignaturas}">
                        <option value="${asignatura.idAsignatura}">${asignatura.nombreAsignatura}</option>				
                    </c:forEach>
                </select>

            <div class="d-grid gap-2 col-6 mx-auto">
                <input type="hidden" id="form" name="form" value="addRamoStudent"/>
                <button class="btn btn-primary mb-3" type="submit">Send</button>
            </div>
        </form>
    </body>
</html>
