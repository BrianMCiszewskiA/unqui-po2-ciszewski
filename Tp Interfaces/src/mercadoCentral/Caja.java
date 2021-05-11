package mercadoCentral;

import java.util.List;
import java.util.ArrayList;

public class Caja {
	private List<Producto> productosRegistrados = new ArrayList<Producto>();
	
	public float montoAPagar(Cliente cliente) {
		float montoTotal = 0;
		for(Producto producto:cliente.getProductos()) {
			montoTotal = montoTotal + producto.getPrecio();
			this.registrarProducto(producto);
		}
		return montoTotal;
	}
	
	public void registrarProductos(List<Producto> productos) {
		for (Producto producto:productos) {
			this.registrarProducto(producto);
		}
	}
	public void registrarProducto(Producto producto) {
		if (producto.hayStock()) {
			productosRegistrados.add(producto);
			producto.disminuirStock();
		}
		else {
			System.out.println("No hay mas stock de: " + producto.getNombre());
		}
	}
	public List<Producto> getProductosRegistrados(){
		return productosRegistrados;
	}
	
	
}
