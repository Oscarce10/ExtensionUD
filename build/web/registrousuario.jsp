<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
    String pnombre = "";
    String snombre = "";
    String papellido = "";
    String sapellido = "";
    String correo = "";
    String clave = "";
    String telefono = "";
%>

<div class="jumbotron" id="jumboRegistro">
    <div class="row justify-content-center">
        <div class="col col-md-auto col-lg-5">
            <div class="card" id="cardRegistroUsuario">
                <div class="card-header bg-primary text-white">Registro Usuario</div>
                <div class="card-body">                   
                    <form
                        action="#"
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
                                <label for="correo">Correo</label>
                                <input type="email" name="correo" class="form-control"
                                       required="required"
                                       value="<%out.print(correo);%>">
                            </div>
                            <div class="form-group">
                                <label for="clave">Clave</label>
                                <input type="password" name="clave" class="form-control"
                                       required="required">
                            </div>
                            <div class="form-group">
                                <label for="telefono">Telefono</label>
                                <input type="text" name="telefono" class="form-control"
                                       placeholder="telefono"
                                       value="<%out.print(telefono);%>">
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success btn-lg" name="registro" >Registrar</button>
                                <a class="btn btn-secondary btn-lg" href="index.php" style="float: right">Volver</a>
                            </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
