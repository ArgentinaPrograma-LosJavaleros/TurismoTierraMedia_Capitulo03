<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner container" >
        <div class="carousel-item container active">
            <div class="row row-cols-2 g-2">
            	<c:forEach items="${promociones}" var="promocion" end="1">   
            		<div class="col">         	
		                <div class=" shadow-lg card border border-info overflow-hidden">
		                    <div class="">
		                        <img class="card-img-top card-img-carrusel " src="./assets/img/${fn:toLowerCase(promocion.tematica)}.jpg" alt=""/>
		                    <span class="badge rounded-pill position-relative">
			                	PROMOCIÓN
			                </span>		                  
		                    </div>
		                    <div class="card-body px-2 py-2">
		                        <div class="d-flex flex-row justify-content-between">                        
			                        <h5 class="card-title fs-5 col">${promocion.nombre}</h5>
			                        <div class="stats d-flex col-6 justify-content-end">
			                            <div class="stats-monedas align-self-center me-2">
			                                <span class="monedas-icono mr-2"> 
			                                	<i class="fas fa-coins"></i> 
			                                	${promocion.costo}
			                                </span>
			                            </div>
			                            <div class="stats-tiempo align-self-center">
			                                <span class="tiempo-icono mr-2"> 
			                                	<i class="fas fa-clock"></i> 
			                                	<span class="tiempo-numero">${promocion.tiempo}</span>
			                                </span> 
			                            </div>
			                        </div>
			                        
		                        </div>
		                        
		                    </div>
		                </div>
	                </div>
            	</c:forEach>     
            </div>
        </div>
        
        <div class="carousel-item container">
            <div class="row row-cols-2 g-2">
            	<c:forEach items="${atracciones}" var="atraccion" end="1">   
            		<div class="col">         	
		                <div class=" shadow-lg card border border-info overflow-hidden">
		                    <div class="">
		                        <img class="card-img-top card-img-carrusel" src="./assets/img/${fn:toLowerCase(atraccion.tematica)}.jpg" alt="" />
		                        <span class="badge rounded-pill position-relative">
		                        	ATRACCIÓN
								</span>
		                    </div>
		                    <div class="card-body px-2 py-2">
		                        <div class="d-flex flex-row justify-content-between">   
			                        <h5 class="card-title fs-5">${atraccion.nombre}</h5>
			                        <div class="stats d-flex col-6 justify-content-end">
			                            <div class="stats-monedas align-self-center me-2">
			                                <span class="monedas-icono mr-2"> 
			                                	<i class="fas fa-coins"></i> 
			                                	${atraccion.costo}
			                                </span> 
			                            </div>
			                            <div class="stats-tiempo align-self-center">
			                                <span class="tiempo-icono mr-2"> 
			                                	<i class="fas fa-clock"></i>
			                                	 <span class="tiempo-numero">${atraccion.tiempo}</span>
			                                </span> 
			                            </div>
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