package mercadoCentral;

public class ProductoCooperativa extends Producto {
	private final int porcentajeDescuento = 10;
	
	
	public ProductoCooperativa(float precio, int stock, String nombre) {
		super(precio, stock, nombre);
	}
	
	@Override
	public float getPrecio() {
		if (this.hayStock()) {
			return precioBase - this.descuentoIVA();
		}
		else return 0;
	}
	
	private float descuentoIVA() {
		return (precioBase * porcentajeDescuento)/100;
	}

}
