package mercadoCentral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacturasTestCase {
	private Cliente pepito;
	private ProductoEmpresaTradicional cafe;
	private Caja caja;
	private AgenciaDummy agenciaDummy;
	private Impuesto impuestoTest;
	private Servicio servicioTest;

	@BeforeEach
	public void setUp() {
		pepito = new Cliente();
		cafe = new ProductoEmpresaTradicional(200, 1, "Cafe Dolca");
		caja = new Caja();
		agenciaDummy = new AgenciaDummy();
		impuestoTest = new Impuesto(1500, agenciaDummy);
		servicioTest = new Servicio(100, 50, agenciaDummy);
		
		pepito.addPago(cafe);
		pepito.addPago(impuestoTest);
		pepito.addPago(servicioTest);
		
	}
	
	@Test
	void testServicioPrecio() {
		Servicio servicioTestUnidades = new Servicio(50);

		assertEquals(0, servicioTestUnidades.getPrecio());
		
		servicioTestUnidades.consumirUnidades(2);
		
		assertEquals(100, servicioTestUnidades.getPrecio());
	}
	
	@Test
	void testMontoTotal() {
		assertEquals(6700, caja.montoAPagar(pepito));
	}

}
