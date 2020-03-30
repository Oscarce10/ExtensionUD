<%@page import="java.io.File"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>

<%@include file="nav.jsp"%>

<%
    if (request.getAttribute("uploadfoto") != null && request.getAttribute("uploadfoto").toString().equals("success")) { %>
<div class="alert alert-success container" role="alert" style="margin-top: 150px;">
    Foto actualizada.
</div>

<% } %>

<%
    if (request.getAttribute("actualizarInfo") != null && request.getAttribute("actualizarInfo").toString().equals("success")) { %>
<div class="alert alert-success container" role="alert" style="margin-top: 150px;">
    Informacion actualizada.
</div>

<% } %>


<div class="jumbotron container" id="jumboAspirante" style="margin-top: 150px;">

    <div class="row">        
        <div class="col-12">
            
            <div class="card" id="cardInicioAspirante">
                <div class="card-header bg-primary text-white">Bienvenido Aspirante</div>
                <div class="card-body" id="card-inicio-aspirante">
                    <div class="row">
                        <div class="col-8">
                            <p>Aspirante: <% out.print(aspirante.getPrimerNombre() + " " + aspirante.getPrimerApellido());%></p>
                            <p>Correo: <% out.print(aspirante.getCorreo());%></p>
                            <p>Hoy es: <% out.print(DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now()));%></p>
                        </div>
                        <div class="col-4">
                            <%
                                if (aspirante.getFoto() != null && aspirante.getFoto() != "") { %>

                                <img src="images/<%out.print(aspirante.getFoto());%>" alt="Foto aspirante" class="rounded-full h-192 w-306 flex items-center justify-center " id="foto-aspirante">

                            <% } else { %>
                            <a href="actualizarfoto"><i class='fas fa-user-circle fa-8x' data-toggle="tooltip" title="Actualizar foto de perfil" data-placement="right"></i></a>
                                <% } %>                         
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    document.title = "Inicio Aspirante <% out.print(aspirante.getPrimerNombre() + " " + aspirante.getPrimerApellido());%> ";
</script>