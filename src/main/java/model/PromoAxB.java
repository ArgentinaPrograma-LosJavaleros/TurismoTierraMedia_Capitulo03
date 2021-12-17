package model;

import java.util.ArrayList;
 
public class PromoAxB extends Promocion {

	private Atraccion atraccionGratis;

	public PromoAxB(Integer idPromocion, String nombrePromocion, Atraccion atraccionGratis, 
					ArrayList<Atraccion> atracciones, TipoPromocion tipoPromo, Boolean activo) {
		super(idPromocion, nombrePromocion, tipoPromo, atracciones, activo);
		this.setAtraccionGratis(atraccionGratis);
		super.tiempo += this.atraccionGratis.getTiempo();
	}

	public void setAtraccionGratis(Atraccion atraccionGratis) {
		this.atraccionGratis = atraccionGratis;
	}

	public Atraccion getAtraccionGratis() {
		return atraccionGratis;
	}

	@Override
	public String toString() {
		
		System.out.printf("| Nombre = %-30s"
                        + "| Atracciones = %-50s"
                        + "| Atracci�n gratis = %-29s"
                        + "| Precio Final = %-5d"
                        + "| Tem�tica = %-15s |", 
                        super.getNombre(),
                        getNombreAtracciones(),
                        getAtraccionGratis().getNombre(),
                        super.getCosto(),
                        getTematica());
		return "";
	}
	
}