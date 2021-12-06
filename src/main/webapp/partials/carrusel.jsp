<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    </div>
    <div class="carousel-inner container" >
        <div class="carousel-item container active">
            <div class="row row-cols-2 align-items-start" id="carrusel">
            	<c:forEach items="${promociones}" var="promocion" end="1">            	
	                <div class="shadow-lg card border border-info overflow-hidden">
	                    <div class="">
	                        <img class="card-img-top" src="./assets/img/img-test-atraccion.png" alt="" />
	                    </div>
	                    <div class="card-body p-3">
	                        <div class="d-flex justify-content-between">                        
		                        <h5 class="card-title mb-3 fs-5 me-5">${promocion.nombre}</h5>
		                        <div class="stats d-flex flex-row mb-4">
		                            <div class="stats-monedas align-self-center me-2">
		                                <span class="monedas-icono mr-2"> 
		                                	<i class="fas fa-coins"></i> 
		                                </span> 
		                                <span class="monedas-numero">${promocion.costo}</span>
		                            </div>
		                            <div class="stats-tiempo align-self-center">
		                                <span class="tiempo-icono mr-2"> 
		                                	<i class="fas fa-clock"></i> 
		                                </span> 
		                                <span class="tiempo-numero">${promocion.tiempo}</span>
		                            </div>
		                        </div>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>     
            </div>
        </div>
        
        <div class="carousel-item container">
            <div class="row row-cols-2 align-items-start" id="carrusel">
            	<c:forEach items="${atracciones}" var="atraccion" end="1">            	
	                <div class="shadow-lg card border border-info overflow-hidden">
	                    <div class="">
	                        <img class="card-img-top" src="./assets/img/img-test-atraccion.png" alt="" />
	                    </div>
	                    <div class="card-body p-3">
	                        <div class="d-flex justify-content-between">                        
		                        <h5 class="card-title mb-3 fs-5 me-5">${atraccion.nombre}</h5>
		                        <div class="stats d-flex flex-row mb-4">
		                            <div class="stats-monedas align-self-center me-2">
		                                <span class="monedas-icono mr-2"> 
		                                	<i class="fas fa-coins"></i> 
		                                </span> 
		                                <span class="monedas-numero">${atraccion.costo}</span>
		                            </div>
		                            <div class="stats-tiempo align-self-center">
		                                <span class="tiempo-icono mr-2"> 
		                                	<i class="fas fa-clock"></i> 
		                                </span> 
		                                <span class="tiempo-numero">${atraccion.tiempo}</span>
		                            </div>
		                        </div>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>     
            </div>
        </div>
        
    </div>

    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next"><span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span></button>
</div>