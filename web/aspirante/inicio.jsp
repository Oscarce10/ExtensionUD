<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>

<%@include file="nav.jsp"%>
<div class="container" style="margin-top: 150px;">
    <%
        if (request.getAttribute("upload") != null && request.getAttribute("upload").toString().equals("success")) { %>
    <div class="alert alert-success" role="alert">
        Foto actualizada.
    </div>
    <% } %>
    <div class="jumbotron" id="jumboAspirante" >
        <div class="row">
            <div class="col-12">
                <div class="card" id="cardInicioAspirante">
                    <div class="card-header bg-primary text-white">Bienvenido Aspirante</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-9">
                                <p>Aspirante: <% out.print(aspirante.getPrimerNombre() + " " + aspirante.getPrimerApellido());%></p>
                                <p>Correo: <% out.print(aspirante.getCorreo());%></p>
                                <p>Hoy es: <% out.print(DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now()));%></p>
                            </div>
                            <div class="col-3">
                                <%
                                    if(aspirante.getFoto()!= null && aspirante.getFoto() != "") { %>
                                    <img src="img/<%out.print(aspirante.getFoto());%>"alt="Foto aspirante" height="auto" width="auto">
                                <% } else { %>
                                <i class='fas fa-user-circle fa-8x'></i>
                                <% } %>                         
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <h1><%out.print(request.getAttribute("action"));%></h1>
</div>


<script>
    document.title = "Inicio Aspirante <% out.print(aspirante.getPrimerNombre() + " " + aspirante.getPrimerApellido());%> ";
</script>