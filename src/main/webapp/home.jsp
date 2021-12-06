<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partials/navbar.jsp"></jsp:include>
	
	<section>
		<jsp:include page="partials/carrusel.jsp"></jsp:include>		
	</section>
	<section class="container-xl pt-2 min-vh-100">
		<section>
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="home-tab" data-bs-toggle="tab"
						data-bs-target="#home" type="button" role="tab"
						aria-controls="home" aria-selected="true">RECOMENDADO</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="profile-tab" data-bs-toggle="tab"
						data-bs-target="#profile" type="button" role="tab"
						aria-controls="profile" aria-selected="false">TODO</button>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
					
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
		
					<section class="row row-cols-sm-1 row-cols-md-2 row-cols-lg-4 pt-4 ">
						<c:forEach begin="1" end="10">
							<article class="px-3 pb-5">
								<div class="shadow-lg card border border-info overflow-hidden">
									<div class="">
										<img class="card-img-top"
											src="./assets/img/img-test-atraccion.png" alt="">
									</div>
									<div class="card-body p-3">
										<h5 class="card-title mb-3 fs-5">Atraccion</h5>
										<div class="stats d-flex flex-row justify-content-between mb-4">
											<div class="stats-monedas align-self-center">
												<span class="monedas-icono mr-2"> <i
													class="fas fa-coins"></i>
												</span> <span class="monedas-numero">12250</span>
											</div>
											<div class="stats-tiempo  align-self-center">
												<span class="tiempo-icono mr-2"> <i class="fas fa-clock"></i>
												</span> <span class="tiempo-numero">02:30</span>
											</div>
										</div>
										<div class="btn-container d-flex flex-column">
											<button class="btn btn-outline-primary mb-3 py-2">MAS
												INFO...</button>
											<button class="btn btn-primary py-2">COMPRAR</button>
										</div>
									</div>
								</div>
							</article>
						</c:forEach>
					</section>
		
				</div>
			</div>
		</section>
	</section>
</body>
</html>