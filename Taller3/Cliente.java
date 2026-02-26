package uniandes.dpoo.aerolinea.modelo.cliente;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar;
	private List<Tiquete> tiquetesUsados;
	

	
	public Cliente() {
		this.tiquetesSinUsar= new ArrayList<Tiquete>();
		this.tiquetesUsados= new ArrayList<Tiquete>();
		
	}

	public void agregarTiquete(Tiquete nuevoTiquete) {
		this.tiquetesSinUsar.add(nuevoTiquete);
		}
	
	public void usarTiquetes(Vuelo vuelo) {
		Collection<Tiquete> tiquetes_vuelo=  vuelo.getTiquetes();
		for (Tiquete tiquete:tiquetes_vuelo) {
			if ( tiquete.getVuelo().equals(vuelo)){
				tiquetesUsados.add(tiquete);
				tiquetesSinUsar.remove(tiquete);
				tiquete.marcarComoUsado();
			}
		}
		
	
	}
	public abstract String getIdentificador();
	public abstract String getTipoCliente();
	public int calcularValorTotalTiquete() {
		return 0;
	}


}
