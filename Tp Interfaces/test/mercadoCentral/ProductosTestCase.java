package mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductosTestCase {
	private ProductoCooperativa productoCoop;
	private ProductoEmpresaTradicional productoET;
	
	@BeforeEach
	public void setUp() {
		productoCoop = new ProductoCooperativa(150, 10, "Harina");
		productoET = new ProductoEmpresaTradicional(200, 1, "Cafe");
	}
	
	@Test
	void testPrecios() {
		assertEquals(200, productoET.getPrecio());
		assertEquals(135, productoCoop.getPrecio());
	}
	
	@Test
	void testStock() {
		assertEquals(10, productoCoop.getStock());
		productoCoop.disminuirStock();
		assertEquals(9, productoCoop.getStock());
		productoCoop.reponerStock(11);
		assertEquals(20, productoCoop.getStock());
	}
	
	@Test
	void testFaltaDeStock() {
		assertEquals(1, productoET.getStock());
		productoET.disminuirStock();
		assertEquals(0, productoET.getStock());
		assertEquals(0, productoET.getPrecio());
		productoET.disminuirStock();
		assertEquals(0, productoET.getStock());
	}
	
	@Test
	void testNombre() {
		assertEquals("Harina", productoCoop.getNombre());
	}

}
