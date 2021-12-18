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
                
                <h1 class="display-3 mb-4">Atracciones</h1>

                <p class="mb-5">Aca se pueden editar, agregar y deshabilitar atracciones</p>
               	
                <button class="btn btn-primary mb-4">AgregarAtracciones</button>
                
                <jsp:include page="/partials/admin/admin-atraccion-table.jsp"></jsp:include>
            </section>
        </section>
    </main>
</body>

</html>