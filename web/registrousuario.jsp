<%@page import="modelo.dto.FormacionDTO"%>
<%@page import="modelo.dto.ResidenciaDTO"%>
<%@page import="modelo.dto.TipoDocumentoDTO"%>
<%@page import="modelo.dto.NacionalidadDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
    String pnombre = "";
    String snombre = "";
    String papellido = "";
    String sapellido = "";
    String correo = "";
    String clave = "";
    String telefono = "";
    String celular = "";
    String numdoc = "";
    if (request.getAttribute("fail") != null) {
        pnombre = request.getParameter("pnombre");
        snombre = request.getParameter("snombre");
        papellido = request.getParameter("papellido");
        sapellido = request.getParameter("sapellido");
        correo = request.getParameter("correo");
        clave = "";
        telefono = request.getParameter("telefono");
        celular = request.getParameter("celular");
        numdoc = request.getParameter("numdoc");
    }
    NacionalidadDTO nacionalidad = new NacionalidadDTO();
    ArrayList<NacionalidadDTO> lista = nacionalidad.consultar();
    request.setAttribute("nacionalidad", lista);
    TipoDocumentoDTO doc = new TipoDocumentoDTO();
    ArrayList<TipoDocumentoDTO> listaDoc = doc.consultar();
    request.setAttribute("listaDoc", listaDoc);
    ResidenciaDTO residencia = new ResidenciaDTO();
    ArrayList<ResidenciaDTO> listaRes = residencia.consultar();
    request.setAttribute("listaRes", listaRes);
    FormacionDTO Formacion = new FormacionDTO();
    ArrayList<FormacionDTO> listaFor = Formacion.consultar();
    request.setAttribute("listaFor", listaFor);
%>

<div class="jumbotron" id="jumboRegistro">
    <div class="row justify-content-center">
        <div class="col col-md-auto col-lg-6">
            <div class="card" id="cardRegistroUsuario">
                <div class="card-header bg-primary text-white">Registro Usuario</div>
                <div class="card-body"> 
                    <%
                        if (request.getAttribute("fail") != null && request.getAttribute("fail").toString().equals("correo")) {
                    %>
                    <div class="alert alert-danger" role="alert">
                        Correo ya registrado, ingrese otro
                    </div>
                    <% } %>
                    <form

                        action="registrousuario"
                        method="post">

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Tipo de documento</label>
                                    <select id="tipodocumento" name="tipodocumento">
                                        <c:forEach var="obDoc" items="${listaDoc}">
                                            <option value="${obDoc.getId()}">${obDoc.getDocumento()}</option>
                                        </c:forEach>                                       
                                    </select>
                                </div>

                                <div class="col">
                                    <label for="nombre">Numero de documento</label>
                                    <input type="number" name="numdoc" class="form-control"
                                           value="<%out.print(numdoc);%>">
                                </div>
                            </div>
                        </div>

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
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Telefono</label>
                                    <input type="number" name="telefono" class="form-control" minlength="7" maxlength="7"
                                           required="required"
                                           value="<%out.print(telefono);%>">
                                </div>

                                <div class="col">
                                    <label for="nombre">Celular</label>
                                    <input type="number" name="celular" class="form-control" minlength="10" maxlength="10"
                                           value="<%out.print(celular);%>">
                                </div>


                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Genero</label>
                                    <br>
                                    <input type="radio" id="male" name="sexo" value="1">
                                    <label for="male">Masculino</label><br>
                                    <input type="radio" id="female" name="sexo" value="2">
                                    <label for="female">Femenino</label><br>

                                </div>

                                <div class="col">
                                    <label for="nombre">Pais de origen</label>
                                    <select id="nacionalidad" name="nacionalidad">
                                        <c:forEach var="ob" items="${nacionalidad}">
                                            <option value="${ob.getId()}" <c:if test="${ob.getId() == 52}"> selected="selected"  </c:if>>${ob.getNacionalidad()}</option>
                                        </c:forEach>                                        
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="row">
                                <div class="col">
                                    <label for="nombre">Ciudad de residencia</label>
                                    <select id="residencia" name="residencia">
                                        <c:forEach var="obres" items="${listaRes}">
                                            <option value="${obres.getId()}">${obres.getResidencia()}</option>
                                        </c:forEach>                                        
                                    </select>
                                </div>

                                <div class="col">
                                    <label for="nombre">Formacion</label>
                                    <select id="formacion" name="formacion">
                                        <c:forEach var="obFor" items="${listaFor}">
                                            <option value="${obFor.getId()}">${obFor.getFormacion()}</option>
                                        </c:forEach>                                        
                                    </select>
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
