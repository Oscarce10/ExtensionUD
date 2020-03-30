<div class="container" id="login">
    <div class="row">
        <div class="col-lg-7">
            <img src="img/logo/undraw_career_progress_ivdb.svg" width="auto" alt="Imagen inicio" id="image-icon"/>

        </div>

        <div class="col col-lg-5">
            <form class="form-signin" action="validar" method="post">
                <div class="brand text-center">
                    <div class="mb-4 logo">
                        <a href="#" title="Login"><i class="fas fa-book fa-7x"></i></a>
                    </div>

                    <h1 class="h1 mb-3 font-weight-normal" id="nombre">Unidad de Extension UD</h1>
                    <% if (request.getAttribute("login") != null && request.getAttribute("login").toString().equals("fail")) {%>
                    <div class="alert alert-danger" role="alert">
                        Correo o clave incorrectos.
                    </div>
                    <% }
                        if (request.getAttribute("registro") != null && request.getAttribute("registro").toString().equals("success")) {%>
                    <div class="alert alert-success" role="alert">
                        Usuario registrado.
                    </div>
                    <% }

                    %>
                </div>


                <!--Campo de correo-->
                <div class="input-group mb-3">
                    <div class="input-group-prepend email">
                        <span class="input-group-text"><i class="fas fa-user-tie"></i></span>
                    </div>
                    <input type="email" name="correo" class="form-control"
                           placeholder="Correo electronico" required autofocus=""
                           title="Ingrese correo"/>
                </div>

                <!--Campo de contraseña-->
                <div class="input-group mb-3 contr">
                    <div class="input-group-prepend pass">
                        <span class="input-group-text"><i class="fas fa-key"></i></span>
                    </div>
                    <input type="password" name="clave"
                           class="form-control" placeholder="Contraseña" required autofocus=""
                           title="Ingrese Contraseña"/>
                </div>

                <div class="input-group mb-3">
                    <button class="btn btn-lg btn-primary btn-block btn-ingreso"
                            type="submit" name="ingresar">Ingresar
                    </button>
                    <a href="registrousuario" id="registrese"><p>Registrese aca</p></a>
                </div>
            </form>
        </div>  
    </div>

</div>

<footer class="footer container-fluid ">
    <p class="text-muted container">
        Hecho con <i class="fas fa-heart"></i> y mucho <i
            class="fas fa-coffee"></i> Por Oscar Cely y Michael Moreno <a
                id="lic" href="https://fontawesome.com/license/free" target="_blank" style="float: right"><span>Licencias
                Font Awessome</span></a>
    </p>


</footer>
<script>
    document.title = "Inicio";
</script>

</body>
