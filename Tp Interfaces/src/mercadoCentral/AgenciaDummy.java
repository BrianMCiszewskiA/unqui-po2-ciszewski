package mercadoCentral;

public class AgenciaDummy implements Agencia{

	@Override
	public void registrarPago(Factura factura) {
		System.out.println("Se efectuo el pago de: " + factura.getClass() + " $" + factura.getPrecio() + "\n" + factura);
	}
}
