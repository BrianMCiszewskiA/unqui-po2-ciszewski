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
		
		pepito.addPago(harina);
		pepito.addPago(yerbaMate);
		pepito.addPago(cafe);
		pepito.addPago(azucar);
		pepito.addPago(galletitas);
	}
	
	@Test
	void testMontoTotal() {
		assertEquals(650, caja.montoAPagar(pepito));
	}
	
	@Test
	void testMontoTotalSinStock() {
		//si se agrega algo que no tiene stock, el precio total deberia no incluir el elemento sin stock (si se quieren 2 cafes y solo hay uno, se suma solo el primero)
		pepito.addPago(cafe);
		assertEquals(650, caja.montoAPagar(pepito));
	}
	
	
	@Test
	void testRegistroConStock() {
		caja.registrarCompras(pepito.getListaDeCompra());
		assertEquals(pepito.getListaDeCompra(), caja.getPagosRegistrados());
	}
	
	@Test
	void testRegistroSinStock() {
		pepito.addPago(cafe); //se supone que solo hay un cafe y esta linea esta agregando un segundo
		caja.registrarCompras(pepito.getListaDeCompra());

		assertNotEquals(pepito.getListaDeCompra(), caja.getPagosRegistrados());
	}
}
