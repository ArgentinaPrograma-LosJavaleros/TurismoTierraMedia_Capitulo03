<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<jsp:include page="partials/head.jsp"></jsp:include>

</head>

<body onload="timeConverter()">
	<jsp:include page="partials/navbar.jsp"></jsp:include>

	<section class="container-xl mt-5">
		<a type="button" class="btn btn-volver px-3 py-2 mb-5"
				href="../home.do">
			<i class="fas fa-chevron-left me-1"></i> <span class="">
				VOLVER </span>
		</a>
		<div class="mb-4">
			<h2 class="fs-2 text-color-light">HISTORIAL DE COMPRAS</h2>
		</div>

		<section
			class="card shadow-lg card border border-info overflow-hidden mb-5">

			<table class="default text-white">

				<thead>
					<tr>
						<th>NOMBRE</th>
						<th>TIPO</th>
						<th>COSTO</th>
						<th>TIEMPO</th>
					</tr>				
				</thead>

				<tbody>
					<c:forEach items="${tickets}" var="ticket">
						<tr>
							<c:choose>
								<c:when test="${!empty ticket.promocionesReservadas}">
									<td>${ticket.promocionesReservadas}</td>
									<td>Promoción</td>
								</c:when>
								<c:otherwise>
									<td>${ticket.atraccionesReservadas}</td>
									<td>Atracción</td>
								</c:otherwise>
							</c:choose>
							<td>${ticket.monedasGastadas}</td>
							<td>${ticket.tiempoGastado}</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

		</section>

	</section>

</body>

</html>
