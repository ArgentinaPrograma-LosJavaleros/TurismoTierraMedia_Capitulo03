<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                
                <h1 class="display-3 mb-4">Tickets</h1>

                <p class="mb-5">Aca se podra ver todas las compras realizadas por todos los usuarios</p>
                
                <jsp:include page="/partials/admin/admin-tickets-table.jsp"></jsp:include>
                
            </section>
        </section>
    </main>
</body>

</html>