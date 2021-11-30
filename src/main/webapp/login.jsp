<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tierra Media &#x0007C; JAVALEROS</title>
    <!--Bootstrap-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <!--CSS-->
    <link rel="stylesheet" href="./assets/css/style.css" />
</head>

<body>

    <div class="contenedor" id="imagen" >
    
        <div class="container-flex d-flex flex-column" id="formulario" >
    
            <div id="logo-contenedor">
                <img src="./assets/img/logo-gradiente.png" alt="Tierra Media" id="logo">
            </div>
    
            <form class="form-group justify-content-center" id="usuario-form">

                <div>
                    <label for="user">Nombre de usuario</label>
                    <input type="text" class="form-control border-0" id="user" >
                    <small id="text" class="text-muted visible">
                        Must be 8-20 characters long.
                    </small>
                </div>

                <div>
                    <label for="pass" class="form-label">Contraseña</label>
                    <input type="password" class="form-control border-0" aria-describedby="passwordHelpInline" id="pass">
                    <small id="text" class="text-muted visible">
                        Must be 8-20 characters long.
                    </small>
                </div>

            </form>

            <div class="contenedor">
                <button class="btn btn-login" id="btn-ingresar">Ingresar<div class="color"> </div></button>
            </div>

        </div>

        <div id="javaleros">
            <strong>
                &#x000A9; JAVALEROS (2021)                    
            </strong>
        </div>

    </div>

</body>

</html>