<%@page import="modelo.dto.CoordinadorDTO"%>

<%
    HttpSession sesion = request.getSession();
    CoordinadorDTO coordinador = new CoordinadorDTO(sesion.getAttribute("id").toString());
    coordinador.consultar();
%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>

<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
    <div class="container">
        <div class="site-logo">
            <a id="tool" class="navbar-brand" href="index.jsp" data-toggle="tooltip" data-placement="bottom" title="Extension UD">
                <i class="fas fa-book"></i>
                <span>Extension UD</span>
            </a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse"
             id="navbarResponsive">
            <div class="nav-item dropdown">
                <a class="menu nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Consultar
                </a>
                <div class="dropdown-menu dropdown-menu-right rounded shadow menu-animate slideIn" aria-labelledby="navbarDropdown">
                    <a class="menu dropdown-item" href="#">
                        Coordinador
                    </a>
                    <a class="menu dropdown-item" href="index.jsp?pid=<%out.print(Base64.encodeBase64String("coordinador/consultaraspirante.jsp".getBytes()));%>">
                        Aspirante
                    </a>
                </div>
            </div>

            <div class="nav-item dropdown">
                <a class="menu nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Registrar
                </a>
                <div class="menu dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="menu dropdown-item" href="#"> Coordinador</a>
                    <a class="menu dropdown-item" href="#"> Aspirante</a>

                </div>
            </div>
            <ul class="social-list list-inline mt-3 mt-lg-0 mb-lg-0 d-flex ml-lg-5 mr-lg-5">
                <li class="list-inline-item">
                    <a class="menu" id="tool" data-toggle="tooltip" data-placement="bottom" title="Github" href="https://github.com/oscarce10" target="_blank">
                        <i class="fab fa-github"></i>
                    </a>
                </li>
                <li class="list-inline-item">
                    <a class="menu" id="tool" data-toggle="tooltip" data-placement="bottom" title="GitLab" href="https://gitlab.com/oscarce10" target="_blank">
                        <i class="fab fa-gitlab"></i>
                    </a>
                </li>
            </ul>

        </div>


        <ul class="menu navbar-nav ml-lg-auto">
            <li class="nav-item mr-lg-4">
                <span class="nav-link">
                    Coordinador: <%out.print(coordinador.getPrimerNombre());%>  <%out.print(coordinador.getPrimerApellido());%>
                </span>
            </li>



            <li class="menu nav-item mr-lg-4">
                <a class="nav-link" href="logout">Salir </a>
            </li>
        </ul>
    </div>
</div>


