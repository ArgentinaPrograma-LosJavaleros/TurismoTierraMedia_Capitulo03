function timeConverter() {
	
	let listTiempo = document.getElementsByClassName("tiempo-numero");
	for (let i = 0; i < listTiempo.length; i++) {
		listTiempo[i].innerHTML = decimalAHora(listTiempo[i].innerHTML);
	}
};

function decimalAHora(decimal) {
	
	let horas = Math.floor(decimal), // Obtenemos la parte entera
		restoHoras = Math.floor(decimal % 1 * 100), // Obtenemos la parde decimal
		decimalMinutos = restoHoras * 60 / 100, // Obtenemos los minutos expresado en decimal

		minutos = Math.floor(decimalMinutos); // Obtenemos la parte entera
		
	return `${('00' + horas).slice(-2)}:${('00' + minutos).slice(-2)}`;
}
