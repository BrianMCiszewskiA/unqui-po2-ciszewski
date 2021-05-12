package mercadoCentral;

public class Servicio extends Factura{
	private float costePorUnidad;
	private int unidadesConsumidas;
	
	public Servicio(float costeUnidad, int unidadesConsumidas) {
		this.setCostePorUnidad(costeUnidad);
		this.setUnidadesConsumidas(unidadesConsumidas);
	}
	public Servicio(float costeUnidad) {
		this(costeUnidad, 0);
	}
	public Servicio(float costeUnidad, int unidadesConsumidas, Agencia agencia) {
		this(costeUnidad, unidadesConsumidas);
		this.setAgenciaRecaudadora(agencia);
	}

	private void setCostePorUnidad(float cantidad) {
		costePorUnidad = cantidad;
	}
	private void setUnidadesConsumidas(int cantidad) {
		unidadesConsumidas = cantidad;
	}
	
	public float getCostePorUnidad() {
		return costePorUnidad;
	}
	public int getUnidadesConsumidas() {
		return unidadesConsumidas;
	}
	
	public void consumirUnidades(int cantidadAConsumir) {
		this.setUnidadesConsumidas(this.getUnidadesConsumidas() + cantidadAConsumir);
	}
	
	
	@Override
	public float getPrecio() {
		return this.getUnidadesConsumidas() * this.getCostePorUnidad();
	}
	@Override
	public void mensajeDeErrorDePago() {
		System.out.println("No se puedo efectuar el pago del Servicio " + this);
	}
	
	
}
