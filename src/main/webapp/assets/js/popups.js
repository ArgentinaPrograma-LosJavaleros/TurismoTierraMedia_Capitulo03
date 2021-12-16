
const popUp = Swal.mixin({
	background: '#061D26',
	color: '#A4BAD7',
});

const mostrar = popUp.mixin({
	showCancelButton: true,
	background: '#061D26',
	color: '#A4BAD7',
	confirmButtonText: 'COMPRAR',
	cancelButtonText: 'CANCELAR',
	confirmButtonColor: '#79D4FF',
	cancelButtonColor: '#FF7979',
	reverseButtons: true
});

const compraCorrecta = popUp.mixin({
	title: 'Compra Realizada',
	icon: 'success'
});

const compraFallida = popUp.mixin({
	title: 'Compra fallida',
	icon: 'error'
});

$(document).on('click', '.btn-mas-info', function() {
	const id = $(this).attr('value');
	const tipo = $(this).attr('name');

	$.ajax({
		url: `/TurismoTierraMedia_Capitulo03/${tipo}/info`,
		method: 'GET',
		data: {
			id
		},
		cache: false,
		dataType: 'json'
	}).done(function(res) {

		if (tipo === 'atraccion') {

			mostrar.fire({
				title: res.nombre,
				html: `
						<div class="stats d-flex flex-row mb-4">
							<div class="stats-monedas align-self-center me-3">
								<span class="monedas-icono me-1"> 
									<i class="fas fa-coins fa-lg"></i>
								</span> 
								<span class="monedas-numero fs-5">
										${res.costo}
								</span>
							</div>
							<div class="stats-tiempo  align-self-center">
								<span class="tiempo-icono me-1 fa-lg"> 
									<i class="fas fa-clock"></i>
								</span> 
								<span class="tiempo-numero fs-5" onload="decimalAHora()"> 
									${decimalAHora(res.tiempo)}
								</span>
							</div>
						</div>
						<div class="text-start">
							${res.descripcion === undefined ? '' : res.descripcion}	
						</div>
					`,
				imageUrl: `/TurismoTierraMedia_Capitulo03/assets/img/${res.tematica.nombre.toLowerCase()}.jpg`
			}).then((result) => {
				if (result.isConfirmed) {
					$.ajax({
						url: `/TurismoTierraMedia_Capitulo03/buy.do`,
						method: 'POST',
						data: {
							atraccion: id
						},
						cache: false,
						dataType: 'json',

					}).done(function(res) {

						if (res.tipo === 0) {
							compraCorrecta.fire({ html: res.mensaje })
								.then(() => location.reload());
						} else
							compraFallida.fire({ html: res.mensaje });

					}).fail(function(xhr) {
						console.log(`${xhr.status}: ${xhr.statusText}`);
						compraFallida.fire({
							title: 'La compra no se pudo realizar',
							html: 'Ocurrio un errror inesperado'
						});
					});
				}
			});
		}

		if (tipo === 'promocion') {

			let atracciones = '<ul class="list-group list-group-flush">';
			
			for (let i = 0; i < res.atracciones.length; i++) {
				atracciones += `<li class="list-group-item text-start list-element">${res.atracciones[i].nombre}</li>`;
			}
			
			atracciones += '</ul>'

			mostrar.fire({
				title: res.nombre,
				html: `
						<div class="stats d-flex flex-row mb-4">
							<div class="stats-monedas align-self-center me-3">
								<span class="monedas-icono me-1"> 
									<i class="fas fa-coins fa-lg"></i>
								</span> 
								<span class="monedas-numero fs-5">
										${res.costo}
								</span>
							</div>
							<div class="stats-tiempo  align-self-center">
								<span class="tiempo-icono me-1 fa-lg"> 
									<i class="fas fa-clock"></i>
								</span> 
								<span class="tiempo-numero fs-5"> 
									${decimalAHora(res.tiempo)}
								</span>
							</div>
						</div>
						La Promocion incluye :
						${atracciones}
					`,
				imageUrl: `/TurismoTierraMedia_Capitulo03/assets/img/${res.atracciones[0].tematica.nombre.toLowerCase()}.jpg`
			}).then((result) => {
				if (result.isConfirmed) {
					$.ajax({
						url: `/TurismoTierraMedia_Capitulo03/buy.do`,
						method: 'POST',
						data: {
							promocion: id
						},
						cache: false,
						dataType: 'json',

					}).done(function(res) {

						if (res.tipo === 0) {
							compraCorrecta.fire({ html: res.mensaje })
								.then(() => location.reload());
						} else
							compraFallida.fire({ html: res.mensaje });

					}).fail(function(xhr) {
						console.log(`${xhr.status}: ${xhr.statusText}`);
						compraFallida.fire({
							title: 'La compra no se pudo realizar',
							html: 'Ocurrio un errror inesperado'
						});
					});
				}
			});
		}
	});
});



$(document).on('click', '.btn-comprar', function() {

	const id = $(this).attr('value');
	const tipo = $(this).attr('name');


	mostrar.fire({
		title: `¿Quieres Comprar esta ${tipo}?`,
		icon: 'question'
	}).then((result) => {
		if (result.isConfirmed) {
			if (tipo === 'atraccion') {
				$.ajax({
					url: `/TurismoTierraMedia_Capitulo03/buy.do`,
					method: 'POST',
					data: {
						atraccion: id
					},
					cache: false,
					dataType: 'json',

				}).done(function(res) {

					if (res.tipo === 0) {
						compraCorrecta.fire({ html: res.mensaje })
							.then(() => location.reload());
					} else
						compraFallida.fire({ html: res.mensaje });

				}).fail(function(xhr) {
					console.log(`${xhr.status}: ${xhr.statusText}`);
					compraFallida.fire({
						title: 'La compra no se pudo realizar',
						html: 'Ocurrio un errror inesperado'
					});
				});
			}

			if (tipo === 'promocion') {
				$.ajax({
					url: `/TurismoTierraMedia_Capitulo03/buy.do`,
					method: 'POST',
					data: {
						promocion: id
					},
					cache: false,
					dataType: 'json',

				}).done(function(res) {

					if (res.tipo === 0) {
						compraCorrecta.fire({ html: res.mensaje })
							.then(() => location.reload());
					} else
						compraFallida.fire({ html: res.mensaje });

				}).fail(function(xhr) {
					console.log(`${xhr.status}: ${xhr.statusText}`);
					compraFallida.fire({
						title: 'La compra no se pudo realizar',
						html: 'Ocurrio un errror inesperado'
					});
				});
			}
		}
	});
});
