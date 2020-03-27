<div class="container" id="login">
    <div class="row">
        <div class="col align-self-center">

            <form class="form-signin" action="validarcto" method="post">
                <div class="brand text-center">
                    <div class="mb-4 logo">
                        <a href="#" title="Login"><i class="fas fa-book fa-7x"></i></a>
                    </div>

                    <h1 class="h3 mb-3 font-weight-normal">Unidad de Extension UD</h1>
                    <% if (request.getParameter("login") != null && request.getParameter("login").equals("fail")) {%>
                    <div class="alert alert-danger" role="alert">
                        Correo o clave incorrectos.
                    </div>
                    <% }%>
                </div>
                

                <!--Campo de correo-->
                <div class="input-group mb-3">
                    <div class="input-group-prepend email">
                        <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    </div>
                    <input type="email" name="correo" id="inputEmail" class="form-control"
                           placeholder="Correo electronico" required autofocus=""
                           title="Ingrese correo"/>
                </div>

                <!--Campo de contraseña-->
                <div class="input-group mb-3 contr">
                    <div class="input-group-prepend pass">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input type="password" name="clave" id="inputEmail"
                           class="form-control" placeholder="Contraseña" required autofocus=""
                           title="Ingrese Contraseña"/>
                </div>

                <div class="input-group mb-3">
                    <button class="btn btn-lg btn-primary btn-block btn-ingreso"
                            type="submit" name="ingresar">Ingresar
                    </button>
                    <a href="#" id="registrese"><p>Registrese aca</p></a>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    document.title = "Inicio";
</script>

</body>
