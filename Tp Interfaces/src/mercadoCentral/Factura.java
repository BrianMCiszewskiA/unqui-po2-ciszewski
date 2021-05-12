package mercadoCentral;

public abstract class Factura implements Pagable {
	private Agencia agenciaRecaudadora;
	
	public void setAgenciaRecaudadora(Agencia agencia) {
		agenciaRecaudadora = agencia;
	}
	public Agencia getAgenciaRecaudadora() {
		return agenciaRecaudadora;
	}
	
	@Override
	public final void pagar() {
		agenciaRecaudadora.registrarPago(this);
	}
	@Override
	public final boolean sePuedePagar() {
		return true;
	}
	@Override
	public abstract float getPrecio();
	@Override
	public abstract void mensajeDeErrorDePago();
}
