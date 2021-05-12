package mercadoCentral;

public interface Pagable {
	public void pagar();
	public float getPrecio();
	public boolean sePuedePagar();
	public void mensajeDeErrorDePago();
}
