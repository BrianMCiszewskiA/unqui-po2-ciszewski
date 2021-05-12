package mercadoCentral;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	private List<Pagable> listaDeCompra = new ArrayList<Pagable>();
	
	public List<Pagable> getListaDeCompra(){
		return listaDeCompra;
	}
	public void addPago(Pagable pagable) {
		listaDeCompra.add(pagable);
	}
	public void removePago(Pagable pagable) {
		listaDeCompra.remove(pagable);
	}
}
