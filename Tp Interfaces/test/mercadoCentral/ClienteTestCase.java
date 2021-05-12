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
		
		pepito.addPago(harina);
		pepito.addPago(yerbaMate);
		pepito.addPago(cafe);
		pepito.addPago(azucar);
		pepito.addPago(galletitas);
	}
	
	
	@Test
	void testPepitoTieneUnoDeTodoEnSuLista() {
		assertEquals(5, pepito.getListaDeCompra().size());
		assert(pepito.getListaDeCompra().contains(harina));
		assert(pepito.getListaDeCompra().contains(yerbaMate));
		assert(pepito.getListaDeCompra().contains(cafe));
		assert(pepito.getListaDeCompra().contains(azucar));
		assert(pepito.getListaDeCompra().contains(galletitas));
	}
	
	@Test
	void testPepitoSacaElAzucarDeLaLista() {
		pepito.removePago(azucar);
		assertEquals(4, pepito.getListaDeCompra().size());
		assert(pepito.getListaDeCompra().contains(harina));
		assert(pepito.getListaDeCompra().contains(yerbaMate));
		assert(pepito.getListaDeCompra().contains(cafe));
		assertFalse(pepito.getListaDeCompra().contains(azucar));
		assert(pepito.getListaDeCompra().contains(galletitas));
	}
	
	@Test
	void testPepitoAgregaMasCafeQueElStock() {
		//se supone que se puede tener mas en la lista que en el stock, eso despues se verificaria en la caja
		pepito.addPago(cafe);
		pepito.removePago(azucar);
		pepito.removePago(yerbaMate);
		pepito.removePago(galletitas);
		pepito.removePago(harina);
		assertEquals(2, pepito.getListaDeCompra().size());
		assert(pepito.getListaDeCompra().contains(cafe));
		assert(cafe.getStock()<pepito.getListaDeCompra().size());
	}

}
