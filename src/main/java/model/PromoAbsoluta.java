package model;

import java.util.ArrayList;

public class PromoAbsoluta extends Promocion {
	
	// Constructor
	public PromoAbsoluta(Integer idPromocion, String nombrePromocion, Integer costoPromocion, 
						 ArrayList<Atraccion> atracciones, TipoPromocion tipoPromo, Boolean activo) {
		super(idPromocion, nombrePromocion, tipoPromo, atracciones, activo);
		super.setCosto(costoPromocion);
	}
	
	// Getter
	//----------------------------------------------
	public Integer getCostoAnterior() {
		double suma = 0.0;
		for (Atraccion a : super.getAtracciones()) {
			suma += a.getCosto();
		}
		return (int) Math.ceil(suma);
	}

	@Override
	public String toString() {

		System.out.printf("| Nombre = %-30s"
		                + "| Atracciones = %-50s"
		                + "| Costo Anterior = %-31d"
		                + "| Precio Final = %-5d"
		                + "| Tem�tica = %-15s |", 
		                super.getNombre(),
		                getNombreAtracciones(),
		                getCostoAnterior(),
		                super.getCosto(),
		                getTematica());
		return "";
	}

}