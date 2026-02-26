package uniandes.dpoo.aerolinea.tiquetes;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.*;

public class Tiquete extends GeneradorTiquetes{
	
	private Cliente cliente;
	private String codigo;
	private int tarifa;
	private boolean usado;
	private Vuelo vuelo;
	
	public Tiquete(String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa) {
		this.cliente=clienteComprador;
		this.codigo=codigo;
		this.vuelo = vuelo;
		this.tarifa = tarifa;
		this.usado = false;
				
	}

	
	public int getTarifa() {
		return tarifa;
	}

	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void marcarComoUsado() {
		this.usado=true;
	}
	public boolean esUsado() {
		return usado;
	}
	}
