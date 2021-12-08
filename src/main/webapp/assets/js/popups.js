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

			Swal.fire({
				title: res.nombre,
				text: `La descripcion`,
				imageUrl: '/TurismoTierraMedia_Capitulo03/assets/img/img-test-atraccion.png',
				showCancelButton: true,
				confirmButtonText: 'Comprar',
				cancelButtonText: 'Cancelar',
				reverseButtons: true
			}).then((result) => {
				if (result.isConfirmed) {

				} else if (result.dismiss === Swal.DismissReason.cancel) {
					
				}
			});

		}
	});
});