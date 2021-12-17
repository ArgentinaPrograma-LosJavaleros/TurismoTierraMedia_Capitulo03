<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<table id="lista-usuarios" class="table table-striped mb-5 w-100">
	    <thead>
	        <tr>
	            <th>#</th>
	            <th>Nombre</th>
	            <th>Costo</th>
	            <th>Tipo</th>
	            <th>Habilitado</th>
	            <th>Acciones</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${promociones}" var="promocion">
	    		<tr>
		            <td>${promocion.id}</td>
		            <td>${promocion.nombre}</td>
		            <td>${promocion.costo}</td>
		            <td>${promocion.tipoPromocion}</td>
		            <c:choose>
						<c:when test="${promocion.activo}">
							<td>HABILITADA</td>
						</c:when>
						<c:otherwise>
							<td>-</td>							
						</c:otherwise>
					</c:choose>
		            <td>
		                <button class="btn btn-primary ">
		                    <i class="fas fa-edit"></i>
		                </button>
		                <button class="btn btn-danger ">
		                    <i class="fas fa-trash"></i>
		                </button>
		            </td>
	        	</tr>
	    	</c:forEach>
	    </tbody>
	</table>
</div>