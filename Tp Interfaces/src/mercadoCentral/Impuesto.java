package mercadoCentral;

public class Impuesto extends Factura{
	private float tasaDelServicio;
	
	public Impuesto(float valor) {
		this.setTasaDelServicio(valor);
	}
	public Impuesto(float valor, Agencia agencia) {
		this(valor);
		this.setAgenciaRecaudadora(agencia);
	}
	
	private void setTasaDelServicio(float valor) {
		tasaDelServicio = valor;
	}
	
	public float getTasaDelServicio() {
		return tasaDelServicio;
	}

	@Override
	public float getPrecio() {
		return this.getTasaDelServicio();
	}

	@Override
	public void mensajeDeErrorDePago() {
		System.out.println("No se puedo efectuar el pago del Impuesto " + this);
	}
	
	
}
