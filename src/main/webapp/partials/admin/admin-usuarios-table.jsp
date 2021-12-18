<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<table id="lista-usuarios" class="table table-striped mb-5 w-100">
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Admin</th>
				<th>Monedas</th>
				<th>Tiempo</th>
				<th>Gusto</th>
				<th>Activo</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nombre}</td>
					<c:choose>
						<c:when test="${usuario.isAdmin}">
							<td>ADMIN</td>
						</c:when>
						<c:otherwise>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<td>${usuario.cantidadMonedas}</td>
					<td>${usuario.tiempoDisponible}</td>
					<td>${usuario.preferencia}</td>
					<c:choose>
						<c:when test="${usuario.activo}">
							<td>ACTIVO</td>
						</c:when>
						<c:otherwise>
							<td>-</td>
						</c:otherwise>
					</c:choose>
					<td><c:choose>
							<c:when test="${usuario.id == id}">
								
							</c:when>
							<c:otherwise>
								<form method="GET" action="admin-editar.admin" class="d-inline">
									<input type="hidden" name="id" value="${usuario.id}" />
									<button class="btn btn-primary ">
										<i class="fas fa-edit"></i>
									</button>
								</form>

								<form method="POST" action="admin-baja.admin" class="d-inline">
									<input type="hidden" name="id" value="${usuario.id}" />
									<c:choose>
										<c:when test="${usuario.activo}">
											<input type="hidden" name="activo" value="0" />
											<button class="btn btn-danger ">
												<i class="fas fa-trash"></i>
											</button>
										</c:when>
										<c:otherwise>
											<input type="hidden" name="activo" value="1" />
											<button class="btn btn-success ">
												<i class="fas fa-trash-restore"></i>
											</button>
										</c:otherwise>
									</c:choose>
								</form>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>