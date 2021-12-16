<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body onload="timeConverter()">
	<jsp:include page="partials/navbar.jsp"></jsp:include>
	
	<section class="mt-5 mb-5">
		<div class="container-xl mb-4">
			<h2 class="fs-2 text-color-light">RECOMENDACIONES</h2>
		</div>
		<jsp:include page="partials/carrusel.jsp"></jsp:include>		
	</section>
	
	<section class="mb-5">
		<div class="d-flex justify-content-center fa-chevron-down-contenedor ">
			<i class="fas fa-chevron-down fa faa-burst faa-burst animated"></i>
			<i class="fas fa-chevron-down fa faa-burst faa-burst animated ms-5 me-5"></i>
			<i class="fas fa-chevron-down fa faa-burst faa-burst animated"></i>
		</div>
	</section>
	
	<section class="container-xl pt-2 min-vh-100 mt-3">
	
		<div class="container-xl mb-4">
			<h2 class="fs-2 text-color-light">ATRACCIONES Y PROMOCIONES DISPONIBLES</h2>
		</div>
	
		<section>
			<ul class="nav nav-tabs mb-3" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true">Atracciones</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Promociones</button>
				</li>
			</ul>
			
			<div class="tab-content" id="myTabContent">
			
				<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
					
					<jsp:include page="partials/atracciones-list.jsp"></jsp:include>
	        		
				</div>
				
				<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
					
					<jsp:include page="partials/promociones-list.jsp"></jsp:include>			
		
				</div>
				
			</div>
			
		</section>
	</section>
</body>
</html>