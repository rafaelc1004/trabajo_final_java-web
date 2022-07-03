<%-- 
    Document   : calificacion-promedio
    Created on : 10 may 2022, 17:32:48
    Author     : Rafaelito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" rel="stylesheet"/>
        <link href="../../css/datatables.min.css" rel="stylesheet" type="text/css"/>
       
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
            
            <table id="example" class="table table-success table-striped tamanio display mt-3">
                <h1 class="centrado">Lista de de notas</h1>

                <thead>
                    <tr>
                        <th colspan="3" ><a href="../instituto_java_people/ControladorAsignatura?accion=addCourse&amp;id=${idAlumno}">Agregar Asignatura a Alumno</a></th>
                            
                    </tr>
                    <tr class="centrado">
                        <th>Asignatura</th>
                        <th>Nota 1</th>
                        <th>Nota 2</th>
                        <th>Nota 3</th>
                        <th>Nota 4</th>
                        <th>Nota 5</th>
                        <th>Promedio</th>
                        <th>Editar Nota</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="ramo" items="${asignaturas}">
                    <tr>
                        <th><c:out value="${ramo.asignatura.nombreAsignatura}" /></th>
                    <td><c:out value="${ramo.nota1}" /></td>
                    <td><c:out value="${ramo.nota2}" /></td>	
                    <td><c:out value="${ramo.nota3}" /></td>
                    <td><c:out value="${ramo.nota4}" /></td>
                    <td><c:out value="${ramo.nota5}" /></td>
                    <td><c:out value="${ramo.promedio}" /></td>


                    <td><a href="/instituto_java_people/ControladorCalificacion?accion=edit&amp;idEstudiante=${ramo.estudiante.idEstudiante}&idCourse=${ramo.asignatura.idAsignatura}">Editar nota</a></td>
                    </tr>
                </c:forEach>			
                </tbody>
            </table>
            <script>
                $(document).ready(function () {
                    $('#example').DataTable();
                });   
             
            </script>

        </div>
    </body>
</html>
