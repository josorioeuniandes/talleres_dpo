package uniandes.dpoo.aerolinea.tarifas;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;


public abstract class CalculadoraTarifas {
	public static double IMPUESTO= 0.28;
	
	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	protected abstract double calcularPorcentajeDescuento(Vuelo vuelo, Cliente cliente);
	protected  int calcularDistanciaVuelo(Ruta ruta){
		return 
	}
	protected int calclularValorImpuesto(int costoBase){
		return (souble) (costoBase*IMPUESTO);
		
	}
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = this.calcularCostoBase(vuelo, cliente);
		double descuento = this.calcularPorcentajeDescuento(vuelo, cliente);
		double impuesto = this.calclularValorImpuesto(costoBase);
		
			
		double tarifaFinal = (costoBase * (1 - descuento)) + impuesto;
	    
	    return (int) tarifaFinal;
	}
	
	
	}






