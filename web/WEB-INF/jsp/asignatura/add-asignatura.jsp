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

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <link href="../../css/datatables.min.css" rel="stylesheet" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Asignatura</title>
        <style>
            .centrado{
                text-align: center;

            }

        </style>
        
        
    </head>
    <body>
        <header>
            <jsp:include page="../includes/nav.jsp"/>
        </header>
        <div class="container">
            <div class=" row justify-content-center mb-3 mt-3">
                <div class="fondo card col-md-6 " >
                    <h2 class="centrado">Registro de Estudiante</h2>

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
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
