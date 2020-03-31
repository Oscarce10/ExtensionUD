<%@page import="modelo.dto.AspiranteDTO"%>

<%
    AspiranteDTO aspirante = new AspiranteDTO(request.getParameter("id"));
    aspirante.consultarInicio();
    aspirante.consultarHojaDeVida();
%>

<div class="modal-header">
    <h5 class="modal-title h4" id="myExtraLargeModalLabel">Consulta de aspirante</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">×</span>
    </button>
</div>
<div class="modal-body">
    <div class="card">
        <div class="card-body">
            <table class="table table-striped table-hover" style="width: 100%;">
                <tbody>
                    <tr>
                        <th width="40%">Codigo interno</th>
                        <td><%out.print(aspirante.getId());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Documento</th>
                        <td><%out.print(aspirante.tipoDocumento() + ". " + aspirante.getNumero_documento());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Nombres</th>
                        <td><%out.print(aspirante.getPrimerNombre() + " " + aspirante.getSegundoNombre());%></td>

                    </tr>                    

                    <tr>
                        <th width="40%">Apellidos</th>
                        <td><%out.print(aspirante.getPrimerApellido() + " " + aspirante.getSegundoApellido());%></td>
                    </tr>

                    <tr>
                        <th width="40%">Telefono</th>
                        <td><%out.print(aspirante.getTelefono_fijo());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Celular</th>
                        <td><%out.print(aspirante.getCelular());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Correo</th>
                        <td><%out.print(aspirante.getCorreo());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Fecha de nacimiento</th>
                        <td><%out.print(aspirante.getFecha_nacimiento());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Profesion</th>
                        <td><%out.print(aspirante.getProfesion() == null || aspirante.getProfesion().equals("") ? "NO ASIGNADO" : aspirante.getProfesion());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Fecha de nacimiento</th>
                        <td><%out.print(aspirante.getFecha_nacimiento());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Genero</th>
                        <td><%out.print(aspirante.genero());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Ciudad de residencia</th>
                        <td><%out.print(aspirante.ciudad_residencia());%></td>
                    </tr>
                    <tr>
                        <th width="40%">Formacion</th>
                        <td><%out.print(aspirante.formacion());%></td>
                    </tr>
                    <tr>
                        <th width="30%">Hoja de vida</th>
                        <%if(aspirante.getHoja_de_vida() != null && !aspirante.getHoja_de_vida().equals("")){ %>
                        <td><embed src="<%out.print("pdf/" + aspirante.getHoja_de_vida());%>" type="application/pdf" width="800" height="780" style="border: none;"/></td>
                        <% } else { %>
                        <td>No se ha subido la hoja de vida</td>
                        <% } %>
                    </tr>
                    
                    <tr>
                        <th width="30%">Descripcion</th>
                        <%if(aspirante.getDescripcion() != null && !aspirante.getDescripcion().equals("")){ %>
                        <td><div contenteditable="false" id="descripcion"><%out.print(aspirante.getDescripcion());%></div></td>
                        <% } else { %>
                        <td>No hay descripcion</td>
                        <% } %>
                        
                    </tr>                   
                    

                </tbody>
            </table>

        </div>
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
    </div>


    <script>
        tinymce.init({
            selector: 'textarea',
            plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker advlist lists',
            toolbar: 'a11ycheck addcomment showcomments casechange checklist code formatpainter pageembed permanentpen table bullist numlist',
            toolbar_mode: 'floating',
            tinycomments_mode: 'embedded',
            tinycomments_author: 'Author name',
            height: "480",
        });
    </script>
