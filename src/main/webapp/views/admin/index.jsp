<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="partials/admin-head.jsp"></jsp:include>
</head>
<body>
    <main class="container-fluid row min-vh-100 m-0 p-0">
        
        <jsp:include page="partials/admin-aside.jsp"></jsp:include>
        
        <section class="col p-0 vh-100 overflow-auto">
            <header class="navbar navbar-light  sticky-top bg-white py-3 navbar-expand-lg mb-5 border-bottom">
                <div class="container-fluid d-flex justify-content-end">
                    <div class="d-flex flex-row justify-content-center">
                        <span cless="align-self-center mr-2">Nombre Admin</span>
                        <div class="avatar avatar-lg bg-secondary">A</div>
                    </div>
                </div>
            </header>
    
            <section class="container">
                
                <h1 class="display-4 mb-4">Usuarios</h1>

                <p class="mb-5">Aca se puede editar y agregar e inhabilitar usuarios</p>
               	
                <button class="btn btn-primary mb-4">Agregar Usuario</button>
                
                <table id="lista-usuarios" class="mb-5" style="width:100%">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Admin</th>
                            <th>Tiempo</th>
                            <th>Monedas</th>
                            <th>Gusto</th>
                            <th>Activo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Eowyn</td>
                            <td>Admin</td>
                            <td>2:50</td>
                            <td>10</td>
                            <td>Aventura</td>
                            <td class="d-flex justify-content-center">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                                </div>
                            </td>
                            <td>
                                <button class="btn btn-primary ">
                                    <i class="fas fa-edit"></i>
                                </button>
                            </td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Admin</th>
                            <th>Tiempo</th>
                            <th>Monedas</th>
                            <th>Gusto</th>
                            <th>Activo</th>
                            <th></th>
                        </tr>
                    </tfoot>
                </table>
            </section>
        </section>
    </main>
</body>

</html>