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
		            <td>
		            	<form method="GET" action="admin-editar.admin">
		            		<input type="hidden" name="id" value="${usuario.id}"/>		            	
			                <button class="btn btn-primary ">
			                    <i class="fas fa-edit"></i>
			                </button>
		            	</form>
		                <button class="btn btn-danger ">
		                    <i class="fas fa-trash"></i>
		                </button>
		            </td>
	        	</tr>
	    	</c:forEach>
	    </tbody>
	</table>
</div>