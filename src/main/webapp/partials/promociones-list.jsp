<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="row row-cols-sm-1 row-cols-md-2 row-cols-lg-4 pt-4 ">
	<c:forEach items="${promociones}" var="promocion">
		<article class="px-3 pb-5">
			<div class="shadow-lg card border border-info overflow-hidden">
				<div class="">
					<img class="card-img-top" src="/TurismoTierraMedia_Capitulo03/assets/img/${fn:toLowerCase(promocion.tematica)}.jpg" alt="">
				</div>
				<div class="card-body p-3">
					<h5 class="card-title mb-2 fs-5">
						<c:out value="${promocion.nombre}"></c:out>
					</h5>
					
					<span class="badge badge-outline rounded-pill mb-2 badge-${fn:toLowerCase(promocion.tematica)}">
			        	${promocion.tematica}
			        </span>
					
					<div class="stats d-flex flex-row justify-content-between mb-4">
						<div class="stats-monedas align-self-center">
							<span class="monedas-icono mr-2"> <i class="fas fa-coins"></i>
							</span> <span class="monedas-numero"> <c:out
									value="${promocion.costo}"></c:out>
							</span>
						</div>
						<div class="stats-tiempo  align-self-center">
							<span class="tiempo-icono mr-2"> <i class="fas fa-clock"></i>
							</span> <span class="tiempo-numero"> 
								<c:out value="${promocion.tiempo}"></c:out>
							</span>
						</div>
					</div>
					<div class="btn-container d-flex flex-column">
						<button class="btn-mas-info btn btn-outline-primary mb-3 py-2" value="promocion-${promocion.id}">MAS
							INFO...
						</button>
						<form class="btn-container d-flex flex-column" action="buy.do" method="post">
							<button class="btn btn-primary py-2" value="${promocion.id}" name="promocion">COMPRAR</button>
						</form>
					</div>
				</div>
			</div>
		</article>
	</c:forEach>
</section>