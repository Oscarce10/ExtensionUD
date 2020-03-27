<%@page import="modelo.dto.CoordinadorDTO"%>
<%
    HttpSession sesion = request.getSession();
    CoordinadorDTO coordinador = new CoordinadorDTO(sesion.getAttribute("id").toString());
    coordinador.consultar();
%>
<%@page import="controlador.CoordinadorCTO"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>

<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand nav-link" href="index.jsp" id="navLogo">
            <i class="fas fa-book"></i>
            <span>Extension UD</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse"
            id="navbarNav">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="projects-grid-cards.html">Projects</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="cv.html">CV</a></li>
                <li class="nav-item mr-lg-4" >
                        <span class="nav-link">
                            Coordinador: <%out.print(coordinador.getPrimerNombre());%>  <%out.print(coordinador.getPrimerApellido());%>
                        </span>
                </li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="logout">Salir </a></li>
            </ul>
        </div>
    </div>
</div>


