package mercadoCentral;

public class ProductoEmpresaTradicional extends Producto {
	
	public ProductoEmpresaTradicional(float precio, int stock, String nombre) {
		super(precio, stock, nombre);
	}
	
	@Override
	public float getPrecio() {
		if (this.hayStock()) {
			return precioBase;
		}
		else return 0;
	}
}
