package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{

	public static String NATURAL = "Natural";
	private String nombre;
	private String identificador;
	@Override
	public String getIdentificador() {
		return identificador;
	}

	@Override
	public String getTipoCliente() {
		return NATURAL;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	

}
