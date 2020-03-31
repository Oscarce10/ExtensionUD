<%@include file="nav.jsp"%>
<%   
    String pnombre = "";
    String snombre = "";
    String papellido = "";
    String sapellido = "";
    String correo = "";
    String clave = "";
    if (request.getAttribute("fail") != null) {
        pnombre = request.getParameter("pnombre");
        snombre = request.getParameter("snombre");
        papellido = request.getParameter("papellido");
        sapellido = request.getParameter("sapellido");
        correo = request.getParameter("correo");
        clave = "";
    }
%>

<div class="jumbotron form" id="jumboRegistro-coordinador">
    <div class="row justify-content-center">
        <div class="col col-md-auto col-lg-6">
            <div class="card" id="cardRegistroUsuario">
                <div class="card-header bg-primary text-white">Registro Coordinador</div>
                <div class="card-body"> 
                    <%
                        if (request.getAttribute("fail") != null && request.getAttribute("fail").toString().equals("correo")) {
                    %>
                    <div class="alert alert-danger" role="alert">
                        Correo ya registrado, ingrese otro
                    </div>
                    <% } %>
                    <form

                        action="registrocoordinador"
                        method="post">                        

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Primer Nombre</label>
                                    <input type="text" name="pnombre" class="form-control"
                                           required="required"
                                           value="<%out.print(pnombre);%>">
                                </div>

                                <div class="col">
                                    <label for="nombre">Segundo Nombre</label>
                                    <input type="text" name="snombre" class="form-control"
                                           value="<%out.print(snombre);%>">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Primer Apellido</label>
                                    <input type="text" name="papellido" class="form-control"
                                           required="required"
                                           value="<%out.print(papellido);%>">
                                </div>

                                <div class="col">
                                    <label for="nombre">Segundo Apellido</label>
                                    <input type="text" name="sapellido" class="form-control"
                                           value="<%out.print(sapellido);%>">
                                </div>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="row">

                                <div class="col">

                                    <label for="correo">Correo</label>
                                    <input type="email" name="correo" class="form-control"
                                           required="required"
                                           value="<%out.print(correo);%>">
                                </div>

                                <div class="col">
                                    <label for="clave">Clave</label>
                                    <input type="password" name="clave" class="form-control"
                                           required="required">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-lg" name="registrar" value="registrar">Registrar</button>
                            <a class="btn btn-secondary btn-lg" href="index.jsp" style="float: right">Volver</a>
                        </div>


                    </form>
                </div>
            </div>
        </div>

    </div>
</div>

