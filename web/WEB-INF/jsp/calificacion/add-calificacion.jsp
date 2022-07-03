
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
        <title>JSP Page</title>
        
        <style>
            .centrado{
                text-align: center;

            }

            .tamanio{
                font-size: 11px;
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

                    <form id="formulario" method="post" action="ControladorCalificacion">
                        <input type="hidden" name="idAsignatura" id="idAsigatura" value="${calificacion.asignatura.idAsignatura}" />
                        <input type="hidden" name="idEstudiante" id="idEstudiante" value="${calificacion.estudiante.idEstudiante}" />
                        <div class="mb-3">
                            <label for="txtNombreEstudiante" class="form-label">Estudiante:</label>
                            <input type="text" class="form-control" id="txtNombreEstudiante" value='<c:out value="${calificacion.estudiante.nombreEstudiante}"/>' name="txtNombreEstudiante" aria-label="Disabled input example" disabled readonly>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombreAsignatura" class="form-label">Asignatura:</label>
                            <input type="text" class="form-control" id="txtNombreAsignatura" value='<c:out value="${calificacion.asignatura.nombreAsignatura}"/>' name="txtNombreAsignatura" aria-label="Disabled input example" disabled readonly>
                        </div>
                        <div class="mb-3">
                            <label for="txtNota1" class="form-label">Nota 1:</label>
                            <input type="number"  min="1" max="7" class="form-control" id="txtNota1" value='<c:out value="${calificacion.nota1}"/>' name="txtNota1" placeholder="Ej. 0.0" >
                        </div>
                        <div class="mb-3">
                            <label for="txtNota2" class="form-label">Nota 2:</label>
                            <input type="number"  min="1" max="7" class="form-control" id="txtNota2" value='<c:out value="${calificacion.nota1}"/>' name="txtNota2" placeholder="Ej. 0.0" >
                        </div>
                        <div class="mb-3">
                            <label for="txtNota3" class="form-label">Nota 3:</label>
                            <input type="number"  min="1" max="7" class="form-control" id="txtNota3" value='<c:out value="${calificacion.nota1}"/>' name="txtNota3" placeholder="Ej. 0.0" >
                        </div>
                        <div class="mb-3">
                            <label for="txtNota4" class="form-label">Nota 4:</label>
                            <input type="number"  min="1" max="7" class="form-control" id="txtNota4" value='<c:out value="${calificacion.nota1}"/>' name="txtNota4" placeholder="Ej. 0.0" >
                        </div>
                        <div class="mb-3">
                            <label for="txtNota5" class="form-label">Nota 5:</label>
                            <input type="number"  min="1" max="7" class="form-control" id="txtNota5" value='<c:out value="${calificacion.nota1}"/>' name="txtNota5" placeholder="Ej. 0.0" >
                        </div>

                        <div class="d-grid gap-2 col-6 mx-auto">
                            <input type="hidden" id="form" name="form" value="addRamoStudent"/>
                            <button class="btn btn-primary mb-3" type="submit">Send</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
