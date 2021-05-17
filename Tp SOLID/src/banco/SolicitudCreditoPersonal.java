package banco;

public class SolicitudCreditoPersonal extends SolicitudCredito{
	private float ingresosAnualesRequeridos = 15000;
	private int porcentajeIngresosMensualesRequerido = 70;

	public SolicitudCreditoPersonal(Cliente cliente, float monto, int meses) {
		super(cliente, monto, meses);
	}

	@Override
	public boolean realizarCheckeo() {
		return this.cubreIngresosAnuales() && this.noSuperaPorcentajeIngresosMensuales();
	}
	
	private boolean cubreIngresosAnuales() {
		//devuelve si el cliente tiene al menos la cantidad necesaria de ingresos anuales
		return this.getCliente().getSueldoNetoAnual() >= this.ingresosAnualesRequeridos;
	}
	private boolean noSuperaPorcentajeIngresosMensuales() {
		//devuelve si el monto de la cuota no supera en el porcentaje dado de los ingresos mensuales del cliente
		return this.getCliente().getPorcentajeIngresosMensuales(this.porcentajeIngresosMensualesRequerido) >= this.getMontoMensual();
	}
	

}
