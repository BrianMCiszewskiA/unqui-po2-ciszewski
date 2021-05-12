package mercadoCentral;

import java.util.List;
import java.util.ArrayList;

public class Caja {
	private List<Pagable> pagosRegistrados = new ArrayList<Pagable>();
	
	public float montoAPagar(Cliente cliente) {
		float montoTotal = 0;
		for(Pagable pagable:cliente.getListaDeCompra()) {
			montoTotal = montoTotal + pagable.getPrecio();
			this.registrarCompra(pagable);
		}
		return montoTotal;
	}
	
	public void registrarCompras(List<Pagable> pagables) {
		for (Pagable pagable:pagables) {
			this.registrarCompra(pagable);
		}
	}
	public void registrarCompra(Pagable pagable) {
		if (pagable.sePuedePagar()) {
			pagosRegistrados.add(pagable);
			pagable.pagar();
		}
		else {
			pagable.mensajeDeErrorDePago();
		}
		
	}
	public List<Pagable> getPagosRegistrados(){
		return pagosRegistrados;
	}
	
	
}
