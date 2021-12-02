<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tierra Media &#x0007C; Inicio</title>
    <!--FontAwesome-->
    <script src="https://kit.fontawesome.com/0931472a64.js" crossorigin="anonymous"></script>
    <!--Bootstrap-->
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
    <!--CSS-->
    <link rel="stylesheet" href="./assets/css/style.css"/>
</head>
<body>
    <nav class="navbar nav sticky-top py-2">
        <div class="container-fluid" >
            <a href="#" >
                <img class="nav-logo" src="./assets/img/logo-gradiente.png" alt="Tierra Media">
            </a>
            <div class="usuario-stats d-flex flex-row-reverse justify-content-center" >
                <div class="user-img ml-3">
                    <img src="./assets/img/fondo-GRANDE.png" alt="">
                </div>

                <div class="stats d-flex flex-row justify-content-between">
                    <div class="stats-monedas align-self-center">
                        <span class="monedas-icono mr-1">
                            <i class="fas fa-coins"></i>
                        </span>
                        <span class="monedas-numero">12250</span>
                    </div>
                    <div class="stats-tiempo  align-self-center">
                        <span class="tiempo-icono mr-1">
                            <i class="fas fa-clock"></i>
                        </span>
                        <span class="tiempo-numero">02:30</span>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <section class="container-xl pt-2 min-vh-100">
        <section class="row row-cols-sm-1 row-cols-md-2 row-cols-lg-4 pt-4 " >
        	<c:forEach begin = "1" end = "15">
	            <article class="px-3 pb-5">
	                <div class="card border border-info">
	                    <div class="">
	                        <img class="card-img-top" src="./assets/img/img-test-atraccion.png" alt="">
	                    </div>
	                    <div class="card-body p-3">
	                        <h5 class="card-title mb-3 fs-5">
	                            Atraccion
	                        </h5>
	                        <div class="stats d-flex flex-row justify-content-between mb-4" >
	                            <div class="stats-monedas align-self-center">
	                                <span class="monedas-icono mr-2">
	                                    <i class="fas fa-coins"></i>
	                                </span>
	                                <span class="monedas-numero">12250</span>
	                            </div>
	                            <div class="stats-tiempo  align-self-center">
	                                <span class="tiempo-icono mr-2">
	                                    <i class="fas fa-clock"></i>
	                                </span>
	                                <span class="tiempo-numero">02:30</span>
	                            </div>
	                        </div>
	                        <div class="btn-container d-flex flex-column">
	                            <button class="btn btn-outline-primary mb-3 py-2">MAS INFO...</button>
	                            <button class="btn btn-primary py-2">COMPRAR</button>
	                        </div>
	                    </div>
	                </div>
	            </article>
        	</c:forEach>
        </section>
    </section>
</body>
</html>