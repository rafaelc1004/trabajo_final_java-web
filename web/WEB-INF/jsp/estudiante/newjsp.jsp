<div class="container">
    <div class=" row justify-content-center mb-3 mt-3">
        <div class="fondo card col-md-6 " >
            <h1 class="centrado">Registro de Estudiante</h1>
            <form  class="p-3 rounded needs-validation " id="formularioCreate" method="post" action="AlumnoControlador">
                <div class="mb-3">
                    <label for="txtRut" class="form-label">Rut:</label>
                    <input type="text" class="form-control" id="txtRut" placeholder="Ej. 12345678-k" name="txtRut">
                    <div id="errorRut" class="mensajeError">El Valor ingresado no es valido!</div>
                </div>
                <div class="mb-3">
                    <label for="txtApellido" class="form-label">Apellidos de Estudiante:</label>
                    <input type="text" class="form-control" id="txtApellido" placeholder="Ej. Perez Rojas" name="txtApellido" onchange="onLimpiarEstilos('Apellido')">
                    <div id="errorApellido" class="mensajeError">Nombre no puede estar vacio!</div>
                </div><!-- comment -->
                <div class="mb-3">
                    <label for="txtNombre" class="form-label">Nombres de Estudiante:</label>
                    <input type="text" class="form-control" id="txtNombre" placeholder="Ej. Juanito" name="txtNombre">
                    <div id="errorNombre" class="mensajeError">El Valor ingresado no es valido!</div>
                </div>

                <div >
                    <label for="txtGenero" class="form-label">Genero de Estudiante:</label>
                </div>  

                <div class="form-check form-check-inline mb-3">
                    <input class="form-check-input" type="radio" name="txtGenero" value="masculino">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Masculino
                    </label>
                </div>
                <div class="form-check form-check-inline mb-3">
                    <input class="form-check-input" type="radio" name="txtGenero" value="Femenino">
                    <label class="form-check-label" for="flexRadioDefault2">
                        Femenino
                    </label>
                </div>
                <div id="errorGenero" class="mensajeError">El Valor ingresado no es valido!</div>

                <div class="mb-3">
                    <label for="txtFono" class="form-label">Telefono:</label>
                    <input type="text" class="form-control" id="txtFono" placeholder="Ej. 987654321" name="txtFono">
                    <div id="errorFono" class="mensajeError">El valor ingresado no es valido!</div>
                </div>
                <div class="d-grid gap-2 col-6 mx-auto">
                    <input type="hidden" id="form" name="form" value="createAlumno"/>
                    <button class="btn btn-primary mb-3" type="submit">Send</button>
                </div>
            </form>
        </div>
    </div>
    <script>
        $(function(){
            $('#formularioCreate').submit(function(ev){
                        
                
                const nombre = $("#txtNombre");
                const genero = $("#txtGenero");
                const fono = $("#txtFono");
                        
                
                const eNombre = $("#errorNombre");
                const eGenero = $("#errorGenero");
                const eFono = $("#errorFono");
                                     
                
                const valorNombre = nombre.val();
                const valorGenero = genero.val();
                const valorFono = fono.val();
                         
                

                if( valorNombre === null || valorNombre === ''){
                    ev.preventDefault();
                    eNombre.addClass('mostrar');
                    nombre.addClass("error form-control");
                }
                        
                if( valorGenero !== "Masculino" && valorGenero !== "Femenino"){
                    ev.preventDefault();
                    eGenero.addClass('mostrar');
                    genero.addClass("error form-control");
                }
                        
                if( valorFono === null || valorFono === ''){
                    ev.preventDefault();
                    eFono.addClass('mostrar');
                    fono.addClass("error form-control");
                }
                                             
                if(valorNombre.length > 0 && valorNombre !== null && 
                   valorRut.length > 0 && valorRut!== null &&
                   valorApellido !== null && valorApellido.length >0 &&
                   (valorGenero === "Masculino" || valorGenero === "Femenino") &&
                   valorFono !== null && valorFono.length > 0 ){
                     
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
                const eNombre =$('#errorNombre');
                eNombre.removeClass("mostrar");
                nombre.removeClass("error");

            });

            $("#txtGenero").change(function(){
                const genero = $("#txtGenero");
                const eGenero =$('#errorGenero');
                eGenero.removeClass("mostrar");
                genero.removeClass("error");

            });
                    
            $("#txtFono").change(function(){
                const fono = $("#txtFono");
                const eFono =$('#errorFono');
                eFono.removeClass("mostrar");
                fono.removeClass("error");

            });
                    
        });
                
    </script>

</div>

