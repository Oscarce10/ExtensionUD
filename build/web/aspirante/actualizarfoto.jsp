<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@include file="nav.jsp"%>

<div class="container form">
    <div class="row">
        <div class="col col-lg-7 offset-2">
            <div class="card form">
                <div class="card-header bg-primary text-white text-center">Actualizar Foto Cliente</div>
                <div class="card-body">

                    <form action="actualizarfoto" method="post" enctype="multipart/form-data">
                        <!-- Upload image input-->
                        <div class="input-group mb-3 px-2 py-2 rounded-pill bg-white shadow-sm">
                            <input id="upload" type="file" onchange="readURL(this);" class="form-control border-0" name="foto">
                            <label id="upload-label" for="upload" class="font-weight-light text-muted" style="font-size: 18px">Subir
                                archivo</label>
                            <div class="input-group-append">
                                <label for="upload" class="btn btn-light m-0 rounded-pill px-4"> <i
                                        class="fa fa-cloud-upload mr-2 text-muted"></i><small
                                        class="text-uppercase font-weight-bold text-muted">Seleccione
                                        archivo</small></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <!-- Uploaded image area-->
                            <p class="font-italic text-white text-center">Visualizar la imagen a subir.</p>
                            <div class="image-area mt-4"><img id="imageResult" src="#" alt=""
                                                              class="img-fluid rounded shadow-sm mx-auto d-block"></div>
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-success btn-lg" name="action" value="subir">Cargar foto</button>
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
    /*  ==========================================
     SHOW UPLOADED IMAGE
     * ========================================== */
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#imageResult')
                        .attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }

    $(function () {
        $('#upload').on('change', function () {
            readURL(input);
        });
    });

    /*  ==========================================
     SHOW UPLOADED IMAGE NAME
     * ========================================== */
    var input = document.getElementById('upload');
    var infoArea = document.getElementById('upload-label');

    input.addEventListener('change', showFileName);

    function showFileName(event) {
        var input = event.srcElement;
        var fileName = input.files[0].name;
        infoArea.textContent = 'Archivo: ' + fileName;
    }
</script>  