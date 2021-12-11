<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<nav class="shadow-lg navbar nav sticky-top py-2">
	<div class="container-fluid">
		<a href="#"> <img class="nav-logo"
			src="/TurismoTierraMedia_Capitulo03/assets/img/logo-gradiente.png"
			alt="Tierra Media">
		</a>
		<div
			class="usuario-stats d-flex flex-row-reverse justify-content-center">
			<div class="dropstart">
				<a class="text-decoration-none" href="#" role="button"
					id="dropdownMenuLink" data-bs-toggle="dropdown"
					aria-expanded="false">
					<div class="d-flex flex-row align-items-center">
						<span class="text-color-light d-inline">${usuario}</span>
						<div class="user-img ms-3 ">
							<img
								src="/TurismoTierraMedia_Capitulo03/assets/img/fondo-GRANDE.png"
								alt="">
						</div>
					</div>
				</a>
				<div class="dropdown-menu position-absolute top-100 end-50"   aria-labelledby="dropdownMenuLink">
					<div class="dropdown-item ">
						<form method="post" action="logout">
							<button class=" dropdown-item"  >
								<i class="fas fa-sign-out-alt"></i> Logout
							</button>
						</form>
					</div>
				</div>

			</div>

			<div class="stats d-flex flex-row justify-content-end me-3">
				<div class="stats-monedas align-self-center me-2">
					<span class="monedas-icono me-1"> <i class="fas fa-coins"></i>
					</span> <span class="monedas-numero">${monedas}</span>
				</div>
				<div class="stats-tiempo  align-self-center ">
					<span class="tiempo-icono me-1"> <i class="fas fa-clock"></i>
					</span> <span class="tiempo-numero">${tiempo}</span>
				</div>


			</div>
		</div>
	</div>
</nav>