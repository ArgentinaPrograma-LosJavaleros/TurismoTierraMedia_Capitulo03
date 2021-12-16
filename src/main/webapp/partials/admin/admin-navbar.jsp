<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<header class="navbar navbar-light  sticky-top bg-white py-3 navbar-expand-lg border-bottom">
	<div class="container-fluid d-flex justify-content-end">
		<div class="dropstart">
			<a class="usuario" href="#" role="button"
				id="dropdownMenuLink" data-bs-toggle="dropdown"
				aria-expanded="false">
				<div class="d-flex flex-row align-items-center usuario-stats">
					<span class="text-color-light d-inline">admin</span>
					<div class="ms-3 rounded-circle usuario-avatar d-flex justify-content-center aling-items-center">
						<div class="fs-2">A</div>
					</div>
				</div>
			</a>
			<div class="dropdown-menu position-absolute top-100 end-50"
				aria-labelledby="dropdownMenuLink">
				<div class="dropdown-item ">
					<form method="post" action="logout">
						<button class=" dropdown-item">
							<i class="fas fa-sign-out-alt"></i> Logout
						</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</header>