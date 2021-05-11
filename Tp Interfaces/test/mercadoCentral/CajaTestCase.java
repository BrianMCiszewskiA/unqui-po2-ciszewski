package mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaTestCase {
	private Cliente pepito;
	private ProductoCooperativa harina;
	private ProductoCooperativa yerbaMate;
	private ProductoEmpresaTradicional cafe;
	private ProductoEmpresaTradicional azucar;
	private ProductoEmpresaTradicional galletitas;
	private Caja caja;
	
	@BeforeEach
	public void setUp() {
		pepito = new Cliente();
		harina = new ProductoCooperativa(150, 10, "Harina 0000");
		yerbaMate = new ProductoCooperativa(100, 15, "Yerba Mate Taragüi");
		cafe = new ProductoEmpresaTradicional(200, 1, "Cafe Dolca");
		azucar = new ProductoEmpresaTradicional(125, 20, "Azucar Ledesma");
		galletitas = new ProductoEmpresaTradicional(100, 12, "Galletitas de agua MediaTarde");
		caja = new Caja();
		
		pepito.addProducto(harina);
		pepito.addProducto(yerbaMate);
		pepito.addProducto(cafe);
		pepito.addProducto(azucar);
		pepito.addProducto(galletitas);
	}
	
	@Test
	void testMontoTotal() {
		assertEquals(650, caja.montoAPagar(pepito));
	}
	
	@Test
	void testMontoTotalSinStock() {
		//si se agrega algo que no tiene stock, el precio total deberia no incluir el elemento sin stock (si se quieren 2 cafes y solo hay uno, se suma solo el primero)
		pepito.addProducto(cafe);
		assertEquals(650, caja.montoAPagar(pepito));
	}
	
	
	@Test
	void testRegistroConStock() {
		caja.registrarProductos(pepito.getProductos());
		assertEquals(pepito.getProductos(), caja.getProductosRegistrados());
	}
	
	@Test
	void testRegistroSinStock() {
		pepito.addProducto(cafe); //se supone que solo hay un cafe y esta linea esta agregando un segundo
		caja.registrarProductos(pepito.getProductos());

		assertNotEquals(pepito.getProductos(), caja.getProductosRegistrados());
	}
}
