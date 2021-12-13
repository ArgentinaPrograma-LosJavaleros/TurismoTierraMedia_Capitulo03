$(document).on('click', '.btn-mas-info', function () {
	let values = $(this).attr('value').split('-');
	
	let tipo = values[0];
	let id = values[1];

	$.ajax({
		url:`/TurismoTierraMedia_Capitulo03/${tipo}/info`,
		method: 'GET',
		data: {
			id
		},
		cache: false,
		dataType: 'json',
		success: function(res){
			
			if(tipo === 'promocion'){
				
				let atracciones = '<ul class="list-group list-group-flush">';
				for(let i = 0; i < res.atracciones.length; i++){
					atracciones += `<li class="list-group-item text-start list-element">${res.atracciones[i].nombre}</li>`;
				}
				atracciones += '</ul>'
	
				Swal.fire({
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
					imageUrl:`/TurismoTierraMedia_Capitulo03/assets/img/${res.atracciones[0].tematica.nombre.toLowerCase()}.jpg`,
					showCancelButton: true,
					background:'#061D26',
					color: '#A4BAD7',					
					confirmButtonText: 'Comprar',
					cancelButtonText: 'Cancelar',
					customClass: {
						confirmButton:'btn-primary',
						cancelButton:'btn-outline-primary',
					},
					reverseButtons: true
				}).then((result) => {
					if (result.isConfirmed) {
	
					} else if (result.dismiss === Swal.DismissReason.cancel) {
						
					}
				});
				
			}else {
				Swal.fire({
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
							${res.descripcion === undefined ?  '' : res.descripcion}	
						</div>
					`,
					imageUrl:`/TurismoTierraMedia_Capitulo03/assets/img/${res.tematica.nombre.toLowerCase()}.jpg`,
					showCancelButton: true,
					background:'#061D26',
					color: '#A4BAD7',
					confirmButtonText: 'Comprar',
					cancelButtonText: 'Cancelar',
					reverseButtons: true
				}).then((result) => {
					if (result.isConfirmed) {
	
					} else if (result.dismiss === Swal.DismissReason.cancel) {
						
					}
				});
			}
		}
	});
});