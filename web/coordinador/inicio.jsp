<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="modelo.dto.CoordinadorDTO"%>

<%@include file="nav.jsp"%>


<div class="container" style="margin-top: 150px;">
    <div class="jumbotron" id="jumboRegistro">
        <div class="row">
            <div class="col-12">
                <div class="card" id="cardInicioCoordinador">
                    <div class="card-header bg-primary text-white">Bienvenido Coordinador</div>
                    <div class="card-body">
                        <p>Coordinador: <% out.print(coordinador.getPrimerNombre() + " " + coordinador.getPrimerApellido());%></p>
                        <p>Correo: <% out.print(coordinador.getCorreo());%></p>
                        <p>Hoy es: <% out.print(DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now()));%></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <img src="<%out.print(getServletContext().getContextPath());%>/img/logo/undraw_sorting_thoughts_6d48.svg" id="image-icon">
            </div>
        </div>
    </div>
</div>

<script>
     document.title = "Inicio coordinador <% out.print(coordinador.getPrimerNombre() + " " + coordinador.getPrimerApellido());%> ";
</script>