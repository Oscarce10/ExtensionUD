<%@include file="nav.jsp"%>

<title>Consultar Aspirante</title>

<div class="container form" style="margin-top: 200px;">
    <div class="card" id="inicio-admin">
        <div class="card-header bg-primary text-white">Consultar Aspirante

        </div>
        <div class="card-body">
            <div>
                <!-- Search form -->
                <form>
                    <div class="form-group row">
                        <label for="inputFiltro" class="col-sm-1 col-form-label"><i class="fas fa-search" aria-hidden="true"></i> </label>
                        <div class="col">
                            <input type="text" class="form-control" id="formConsulta" placeholder="Buscar aspirante por nombre y/o apellido"
                                   aria-label="Search">
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <div id="tabla" style="margin-top: 100px;"></div>

</div>

<div class="modal fade" id="modalCliente" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content" id="modalContent"></div>
    </div>
</div>

<script>
    $(document).ready(function () {

        $('body').on('show.bs.modal', '.modal', function (e) {
            var link = $(e.relatedTarget);
            $(this).find(".modal-content").load(link.attr("href"));
        });

        $("#formConsulta").keyup(function () {
            console.log($("#formConsulta").val());
            if ($("#formConsulta").val() != "") {
                $("#tabla").show();
                var ruta = "filtroaspirante";


                $("#tabla").load(ruta, {"filtro": $("#formConsulta").val()});
            } else
                $("#tabla").hide();

        });

        //Al presionar enter se cierra la sesion, esto evita que eso pase
        $(document).keypress(
                function (event) {
                    if (event.which == '13') {
                        event.preventDefault();
                    }
                });

    });
</script>