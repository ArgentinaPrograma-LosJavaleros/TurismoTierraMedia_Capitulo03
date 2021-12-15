<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="">
	<table id="lista-usuarios" class="table table-striped mb-5 w-100">
	    <thead>
	        <tr>
	            <th>#</th>
	            <th>Nombre</th>
	            <th>Monedas</th>
	            <th>Tiempo</th>
	            <th>Atracciones</th>
	            <th>Habilitado</th>
	            <th>Editar</th>
	        </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="i" begin="1" end="30">
	    		<tr>
		            <td>${i}</td>
		            <td>Eowyn</td>
		            <td>10</td>
		            <td>2:50</td>
		            <td>Aventura</td>
		            <td>
		            	<div class="d-flex justify-content-center h-100">
			                <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                </div>
		            	</div>
		            </td>
		            <td>
		                <button class="btn btn-primary ">
		                    <i class="fas fa-edit"></i>
		                </button>
		            </td>
	        	</tr>
	    	</c:forEach>
	    </tbody>
	</table>
</div>