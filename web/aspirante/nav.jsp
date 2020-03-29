<%@page import="modelo.dto.AspiranteDTO"%>
<%
    HttpSession sesion = request.getSession();
    AspiranteDTO aspirante = new AspiranteDTO(sesion.getAttribute("id").toString());
    aspirante.consultarInicio();
%>
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
             id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item mr-lg-4" >
                    <span class="nav-link">
                        Aspirante: <%out.print(aspirante.getPrimerNombre());%>  <%out.print(aspirante.getPrimerApellido());%>
                    </span>
                </li>
                
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Actualizar
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="index.jsp?pid=<%out.print(Base64.encodeBase64String("aspirante/actualizarfoto.jsp".getBytes()));%>">Foto</a>
                        <a class="dropdown-item" href="#">Hoja de vida</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Ver datos</a>
                    </div>
                </li>
                
                <li class="nav-item" role="presentation"><a class="nav-link" href="logout">Salir </a></li>
            </ul>
        </div>
    </div>
</div>


