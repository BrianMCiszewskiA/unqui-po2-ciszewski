package mercadoCentral;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	private List<Producto> listaProductos = new ArrayList<Producto>();
	
	public List<Producto> getProductos(){
		return listaProductos;
	}
	public void addProducto(Producto producto) {
		listaProductos.add(producto);
	}
	public void removeProducto(Producto producto) {
		listaProductos.remove(producto);
	}
}
