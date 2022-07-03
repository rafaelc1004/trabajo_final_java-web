<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Menu de Navegacion</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/instituto_java_people/index.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/instituto_java_people/AlumnoControlador?accion=add">Registro de Estudiante</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/instituto_java_people/AlumnoControlador?accion=list">Lista de Estudiante</a>
                    </li>

                </ul>
                <form class="d-flex" id="formulario" method="post" action="ControllerCliente">
                    <input class="form-control me-2" id="txtBuscar" name="txtBuscar" type="search" placeholder="Buscar Numero de Orden " aria-label="Search">
                    <input type="hidden" id="form" name="form" value="search"/>
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
</div>