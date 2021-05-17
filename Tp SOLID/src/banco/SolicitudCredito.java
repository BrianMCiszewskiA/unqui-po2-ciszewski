package banco;

public abstract class SolicitudCredito {
	private Cliente cliente;
	private float montoSolicitado;
	private int cantidadDeMeses;
	
	public SolicitudCredito(Cliente cliente, float monto, int meses) {
		this.setCliente(cliente);
		this.setMonto(monto);
		this.setMeses(meses);
	}
	
	private void setCliente(Cliente cliente) {
		this.cliente=cliente;
	}
	private void setMonto(float monto) {
		this.montoSolicitado=monto;
	}
	private void setMeses(int meses) {
		this.cantidadDeMeses= meses;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public float getMontoSolicitado() {
		return montoSolicitado;
	}
	public int getCantidadDeMeses() {
		return cantidadDeMeses;
	}
	public float getMontoMensual() {
		return this.montoSolicitado / this.cantidadDeMeses;
	}
	
	public abstract boolean realizarCheckeo();
}
