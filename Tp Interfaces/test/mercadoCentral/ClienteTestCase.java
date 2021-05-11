package mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTestCase {
	private Cliente pepito;
	private ProductoCooperativa harina;
	private ProductoCooperativa yerbaMate;
	private ProductoEmpresaTradicional cafe;
	private ProductoEmpresaTradicional azucar;
	private ProductoEmpresaTradicional galletitas;
	
	@BeforeEach
	public void setUp() {
		pepito = new Cliente();
		harina = new ProductoCooperativa(150, 10, "Harina 0000");
		yerbaMate = new ProductoCooperativa(100, 15, "Yerba Mate Taragüi");
		cafe = new ProductoEmpresaTradicional(200, 1, "Cafe Dolca");
		azucar = new ProductoEmpresaTradicional(125, 20, "Azucar Ledesma");
		galletitas = new ProductoEmpresaTradicional(100, 12, "Galletitas de agua MediaTarde");
		
		pepito.addProducto(harina);
		pepito.addProducto(yerbaMate);
		pepito.addProducto(cafe);
		pepito.addProducto(azucar);
		pepito.addProducto(galletitas);
	}
	
	
	@Test
	void testPepitoTieneUnoDeTodoEnSuLista() {
		assertEquals(5, pepito.getProductos().size());
		assert(pepito.getProductos().contains(harina));
		assert(pepito.getProductos().contains(yerbaMate));
		assert(pepito.getProductos().contains(cafe));
		assert(pepito.getProductos().contains(azucar));
		assert(pepito.getProductos().contains(galletitas));
	}
	
	@Test
	void testPepitoSacaElAzucarDeLaLista() {
		pepito.removeProducto(azucar);
		assertEquals(4, pepito.getProductos().size());
		assert(pepito.getProductos().contains(harina));
		assert(pepito.getProductos().contains(yerbaMate));
		assert(pepito.getProductos().contains(cafe));
		assertFalse(pepito.getProductos().contains(azucar));
		assert(pepito.getProductos().contains(galletitas));
	}
	
	@Test
	void testPepitoAgregaMasCafeQueElStock() {
		//se supone que se puede tener mas en la lista que en el stock, eso despues se verificaria en la caja
		pepito.addProducto(cafe);
		pepito.removeProducto(azucar);
		pepito.removeProducto(yerbaMate);
		pepito.removeProducto(galletitas);
		pepito.removeProducto(harina);
		assertEquals(2, pepito.getProductos().size());
		assert(pepito.getProductos().contains(cafe));
		assert(cafe.getStock()<pepito.getProductos().size());
	}

}
