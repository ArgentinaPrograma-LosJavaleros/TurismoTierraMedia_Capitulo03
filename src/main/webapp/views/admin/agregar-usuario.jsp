<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/partials/admin/admin-head.jsp"></jsp:include>
    <jsp:include page="/partials/admin/admin-head-data-tables.jsp"></jsp:include>
</head>
<body>
    <main class="container-fluid row min-vh-100 m-0 p-0 bg-light">
        
        <jsp:include page="/partials/admin/admin-aside.jsp"></jsp:include>
        
        <section class="col p-0 vh-100 overflow-auto">
            
            <jsp:include page="/partials/admin/admin-navbar.jsp"></jsp:include>
    
            <section class="container-xl shadow bg-white py-5 px-5">
                
                <h1 class="display-3 mb-4">Modificar Usuario</h1>

                <p class="mb-5">Acá se pueden editar los datos de una usuario</p>

               	<form class="w-50" method="post" action="">
				    
				    <input type="hidden" name="id" value="">
				    
				    <div class="mb-3">
				      <legend>Nombre</legend>
				      <input type="text" class="form-control">
				    </div>
				   
				    <div class="mb-3">
				      <legend>Tiempo</legend>
				      <input type="number" min="0" class="form-control">
				    </div>
				    
				    <div class="mb-3">
				      <legend>Monedas</legend>
				      <input type="number" min="0" class="form-control">
				    </div>
				    
				    <div class="mb-3">
				      <legend>Preferencia</legend>
				      <select class="form-select">
				      	
				      </select>
				    </div>
				    
			        <div class="mb-3">
				      <div class="form-check">
				        <input class="form-check-input" type="checkbox">
				        <label class="form-check-label">
				          ¿Es Admin?
				        </label>
				      </div>
				    </div>
				    
					<button type="submit" class="btn btn-primary mb-4">Guardar Cambios</button>				    
				    
				</form>
               	
            </section>
        </section>
    </main>
</body>

</html>