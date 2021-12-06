<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<nav class="shadow-lg navbar nav sticky-top py-2">
	<div class="container-fluid">
		<a href="#"> <img class="nav-logo"
			src="/TurismoTierraMedia_Capitulo03/assets/img/logo-gradiente.png" alt="Tierra Media">
		</a>
		<div
			class="usuario-stats d-flex flex-row-reverse justify-content-center">
			<div class="user-img ms-3 ">
				<img src="/TurismoTierraMedia_Capitulo03/assets/img/fondo-GRANDE.png" alt="">
			</div>
			<span class="text-color-light">${usuario}</span>
			<div class="stats d-flex flex-row justify-content-between">
				<div class="stats-monedas align-self-center">
					<span class="monedas-icono mr-1"> <i class="fas fa-coins"></i>
					</span> <span class="monedas-numero">${monedas}</span>
				</div>
				<div class="stats-tiempo  align-self-center">
					<span class="tiempo-icono mr-1"> <i class="fas fa-clock"></i>
					</span> <span class="tiempo-numero">${tiempo}</span>
				</div>
				
				<div>
					<form method="post" action="logout">
						<button class="btn btn-outline-danger"><i class="fas fa-sign-out-alt"></i> Logout </button>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</nav>