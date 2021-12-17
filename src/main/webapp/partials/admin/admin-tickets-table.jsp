<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<c:forEach items="${usuarios}" var="usuario">
		<c:if test="${not usuario.isAdmin}">
			<h2>${usuario.nombre}</h2>
			<table class="table table-stripped mb-4">

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
						<c:if test="${usuario.nombre == ticket.comprador}">
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
						</c:if>
					</c:forEach>
				</tbody>

			</table>
		</c:if>
	</c:forEach>
</div>