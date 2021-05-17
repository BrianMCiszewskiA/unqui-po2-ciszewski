package banco;

public class SolicitudCreditoHipotecario extends SolicitudCredito{
	private Propiedad garantia;
	private int porcentajeIngresosMensualesRequerido = 50;
	private int porcentajeValorFiscalRequerido = 70;
	private int edadMaximaPermitida = 65;

	public SolicitudCreditoHipotecario(Cliente cliente, float monto, int meses, Propiedad propiedad) {
		super(cliente, monto, meses);
		this.garantia=propiedad; 
	}

	@Override
	public boolean realizarCheckeo() {
		return this.noSuperanPorcentajeIngresosMensuales() && this.noSuperaPorcentajeValorFiscal() && this.clienteNoSuperaEdadAlTerminarDePagar();
	}

	private boolean noSuperanPorcentajeIngresosMensuales() {
		//devuelve que el monto de la cuota no supere el porcentaje dado de los ingresos mensuales del titular.
		return this.getCliente().getPorcentajeIngresosMensuales(this.porcentajeIngresosMensualesRequerido) >= this.getMontoMensual();
	}
	private boolean noSuperaPorcentajeValorFiscal() {
		//devuelve que el monto pedido no supera el porcentaje dado del valor fiscal de la propiedad dada como garantia.
		return this.garantia.porcentajeValorFiscal(porcentajeValorFiscalRequerido) >= this.getMontoSolicitado();
	}
	private boolean clienteNoSuperaEdadAlTerminarDePagar() {
		//devuelve si el cliente no supera la edad maxima dada al terminar el plazo de la solicitud.
		return (this.getCliente().getEdad() + (this.getCantidadDeMeses() /12)) <= this.edadMaximaPermitida;
	}
}
