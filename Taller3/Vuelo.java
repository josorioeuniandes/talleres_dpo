package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Objects;
import java.util.Collection;
import java.util.HashMap;
import java.lang.String;

import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Vuelo {

	private Avion avion;
	private String fecha;
	private Ruta ruta;
	private Map<String,Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion) {
		this.avion=avion;
		this.fecha = fecha;
		this.ruta=ruta;
		this.tiquetes=new HashMap<>();	
				
	}

	public Collection<Tiquete> getTiquetes() {
		return this.tiquetes.values();
	}

	public Ruta getRuta() {
		return ruta;
	}

	public String getFecha() {
		return fecha;
	}

	public Avion getAvion() {
		return avion;
	}
	
	public int  venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		
		if (this.tiquetes.size() + cantidad > this.avion.getCapacidad()) {
	        throw new VueloSobrevendidoException(this); 
	    }

	    int precioUnitario = calculadora.calcularTarifa(this, cliente);
	    int valorTotal = precioUnitario * cantidad;

	    for (int i = 0; i < cantidad; i++) {
	        Tiquete nuevoTiquete = GeneradorTiquetes.generarTiquete(this, cliente, precioUnitario);
	        
	        this.tiquetes.put(nuevoTiquete.getCodigo(), nuevoTiquete);
	        
	        cliente.agregarTiquete(nuevoTiquete);
	    }

	    return valorTotal;
	
	}
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }

	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }

	        Vuelo other = (Vuelo) obj;

	        boolean rutaIgual = (this.ruta == null ? other.ruta == null : this.ruta.equals(other.ruta));
	        boolean fechaIgual = (this.fecha == null ? other.fecha == null : this.fecha.equals(other.fecha));

	        return rutaIgual && fechaIgual;
	    }
	    

	    @Override
	    public int hashCode() {
	        int result = (ruta != null ? ruta.hashCode() : 0);
	        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
	        return Objects.hash(fecha, ruta); 
	    	
	    
	}
	
	
}
