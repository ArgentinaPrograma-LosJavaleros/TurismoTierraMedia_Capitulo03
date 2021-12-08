<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="partials/head.jsp"></jsp:include>
</head>

<body>

    <div class="contenedor" id="imagen" >
    
        <div class="container-flex d-flex flex-column" id="formulario" >
    
            <div id="logo-contenedor">
                <img src="./assets/img/logo-gradiente.png" alt="Tierra Media" id="logo">
            </div>
    
            <form class="form-group justify-content-center" id="usuario-form" action="login" method="post">

                <div>
                    <label for="user">Nombre de usuario</label>
                    <input name="user" type="text" class="form-control border-0" id="user" >
                    <small id="text" class="text-muted visible">
                        Must be 8-20 characters long.
                    </small>
                </div>

                <div class="mb-4">
                    <label for="pass" class="form-label">Contrase&#x000F1;a</label>
                    <input name="pass" type="password" class="form-control border-0" aria-describedby="passwordHelpInline" id="pass">
                    <small id="text" class="text-muted visible">
                        Must be 8-20 characters long.
                    </small>
                </div>
                
                <div class="text-center">
                	<span class="text-danger">${error}</span>
				</div>
				
	            <div class="contenedor">
	                <button class="btn btn-login" id="btn-ingresar">
	                	Ingresar
	                <div class="color"> </div></button>
	            </div>

            </form>

        </div>

        <div id="javaleros">
            <strong>
                &#x000A9; JAVALEROS (2021)                    
            </strong>
        </div>

    </div>

</body>

</html>