<%@include file="nav.jsp"%>
<%
    aspirante.consultarHojaDeVida();
    String fechaNacimiento = aspirante.getFecha_nacimiento();
    String profesion = aspirante.getProfesion();
    String descripcion = aspirante.getDescripcion();
    %>

<script src="https://cdn.tiny.cloud/1/2q2zqw2txah5dkoycgz1rvf25b77xewpmvblaib6mlxcl493/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

<div class="container registro-cv" style="margin-top: 150px;" >
    <%
        if (request.getAttribute("fail") != null) {%>
    <div class="alert alert-danger container" role="alert" style="margin-top: 150px;">
        <% out.print(request.getAttribute("fail").toString()); %>
    </div>
    <% } %>
    <div class="jumbotron jumbotron-fluid registro-cv" id="jumbo-registro-cv">
        <div class="container">
            <div class="card" id="card-registro-cv">
                <h5 class="card-header bg-primary text-white text-center">Actualizar datos de hoja de vida</h5>
                <div class="card-body">
                    <form action="actualizarhojadevida" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col">
                                <label for="fechaNacimiento">Fecha de nacimiento</label>
                                <input type="date" name="fechaNacimiento" class="form-control" value="<%out.print((fechaNacimiento != null)?fechaNacimiento:"");%>">
                            </div>
                            <div class="col">
                                <label>Profesion</label>
                                <input type="text" name="profesion" class="form-control" placeholder="Ingrese su profesion" value="<%out.print((profesion!= null)?profesion:"");%>">
                            </div>
                        </div>
                        <br>

                        <div class="form-group">
                            <label for="descripcion">Descripcion personal</label>                              
                            <textarea id="editor" class="md:w-2/3" name="descripcion"><%out.print((profesion!= null)?descripcion:"");%></textarea>
                        </div>

                        <br>
                        <div class="form-group">
                            <label>Inserte aca su hoja de vida en PDF</label>
                            <div class="zone">

                                <div id="dropZ">
                                    <i class="fa fa-cloud-upload"></i>
                                    <div>Arrastre y suekte su archivo aca</div>                    
                                    <span>O</span>
                                    <div class="selectFile">       
                                        <label for="file">Seleccionar archivo</label>                   
                                        <input type="file" name="pdf" id="file">
                                    </div>
                                    <p>Tamaño maximo: 10 MB</p>
                                </div>

                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-lg" name="action" value="subir">Actualizar hoja de vida</button>
                            <a class="btn btn-light" style="float: right"
                               href="index.jsp"
                               role="button">Volver</a>
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
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
