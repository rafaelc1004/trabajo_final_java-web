
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <!-- CSS only -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>

        <script src="https://code.jquery.com/jquery-3.6.0.slim.min.js" integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>

        <style>
            .centrado{
                text-align: center;
            }
            .mensajeError {
                color: red;
                font-size: 12px;
                display: none;
            }
            .error {
                border-color: red;
            }

            .mostrar {
                display: block;
            }
        </style>
    </head>
    <body>
    <header>
        <jsp:include page="../includes/nav.jsp"/>
        <a href="../includes/nav.jsp"></a>
    </header>
        <div class="container">
            <div class=" row justify-content-center mb-3 mt-3">
                <div class="fondo card col-md-6 " >
                    <h1 class="centrado">Registro de Estudiante</h1>
                    <form id="formulario" method="post" action="AlumnoControlador">
                        <div class="mb-3">
                            <label for="txtRut" class="form-label">Rut de Estudiante:</label>
                            <input type="text" class="form-control" id="txtRut" placeholder="Ej. 12345678-k" name="txtRut">
                            <div id="errorRut" class="mensajeError">Error! Rut es requerido</div>
                        </div>
                        <div class="mb-3">
                            <label for="txtApellido" class="form-label">Apellidos de Estudiante:</label>
                            <input type="text" class="form-control" id="txtApellido" placeholder="Ej. Perez Rojas" name="txtApellido">
                            <div id="errorApellido" class="mensajeError">Error! Apellido es requerido</div>
                        </div>
                        <div>
                            <label for="txtNombre">Nombres de Estudiante: </label>
                            <input type="text" id="txtNombre" class="form-control" name="txtNombre" placeholder="Ej: Juan" />
                            <div id="errorNombre" class="mensajeError">Error! Nombre es requerido.</div>
                        </div>

                        <label for="txtGenero" class="form-label mt-3">Genero de Estudiante:</label><br/>
                        <div class="form-check form-check-inline mb-3">
                            <input class="form-check-input" type="radio" name="txtGenero" value="M" checked >
                            <label class="form-check-label" for="flexRadioDefault1">
                                Masculino
                            </label>
                        </div>
                        <div class="form-check form-check-inline mb-3">
                            <input class="form-check-input" type="radio" name="txtGenero" value="F">
                            <label class="form-check-label" for="flexRadioDefault2">
                                Femenino
                            </label>
                        </div>
                        <div class="mb-3">
                            <label for="txtFono" class="form-label">Telefono:</label>
                            <input type="text" class="form-control" id="txtFono" placeholder="Ej. 987654321" name="txtFono">
                            <div id="errorFono" class="mensajeError">Error! Telefono es requerido.</div>
                        </div>

                        <div class="d-grid gap-2 col-6 mx-auto">
                            <input type="hidden" id="form" name="form" value="createAlumno"/>
                            <button class="btn btn-primary mb-3" type="submit">Send</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

    <script>
        $(function(){
            $('#formulario').submit(function(ev){
                    
        
                const rut = $("#txtRut");
                const apellido = $("#txtApellido");
                const nombre = $("#txtNombre");
                const fono = $("#txtFono");
                    
                const eRut = $("#errorRut");
                const eApellido = $("#errorApellido");
                const eNombre = $('#errorNombre');
                const eFono = $("#errorFono");

                
                const valorRut = rut.val();
                const valorApellido = apellido.val();
                const valorNombre = nombre.val();
                const valorFono = fono.val();


                if( valorRut === null || valorRut === ''){
                ev.preventDefault();
                eRut.addClass('mostrar');
                rut.addClass("error form-control");
                }
                        
                if( valorApellido === null || valorApellido === ''){
                    ev.preventDefault();
                    eApellido.addClass('mostrar');
                    apellido.addClass("error form-control");
                }

                if (valorNombre === null || valorNombre === ''){
                    ev.preventDefault();
                    eNombre.addClass('mostrar');
                    nombre.addClass("error form-control");
                }
                
                if( valorFono === null || valorFono === ''){
                    ev.preventDefault();
                    eFono.addClass('mostrar');
                    fono.addClass("error");
                }

            });
            
            $("#txtRut").change(function(){
                const rut = $("#txtRut");
                const eRut =$('#errorRut');
                eRut.removeClass("mostrar");
                rut.removeClass("error");

            });
                    
             $("#txtApellido").change(function(){
                const apellido = $("#txtApellido");
                const eApellido =$('#errorApellido');
                eApellido.removeClass("mostrar");
                apellido.removeClass("error");

            });

            $("#txtNombre").change(function(){
                const nombre = $("#txtNombre");
                const eNombre = $('#errorNombre');
                eNombre.removeClass("mostrar");
                nombre.removeClass("error");
            });

            $("#txtFono").change(function(){
                const fono = $("#txtFono");
                const eFono =$('#errorFono');
                eFono.removeClass("mostrar");
                fono.removeClass("error");

            });
            
        });

    </script>
</html>