package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTestCase {
	private Banco banco;
	private Cliente pepito;
	private Cliente roberto;
	
	
	@BeforeEach
	void setUp(){
		banco = new Banco();
		pepito = new Cliente("Pepito", "Perez", "Calle Falsa 123", 23, 52000);
		roberto = new Cliente("Roberto", "Hernandez", "Avenida Siempreviva 457", 45, 70500);
		
	}

	@Test
	void testClientes() {
		banco.agregarCliente(pepito);
		assert(banco.getClientes().contains(pepito));
		banco.agregarCliente(roberto);
		assert(banco.getClientes().contains(roberto));
		assertEquals(2, banco.getClientes().size());
		banco.removerCliente(pepito);
		assertFalse(banco.getClientes().contains(pepito));
		
	}
	
	@Test
	void testRegistrarSolicitudes() {
		SolicitudCredito solicitudTest=new SolicitudCreditoPersonal(pepito, 10000, 10);
		banco.registrarSolicitud(solicitudTest);
		assert(banco.getSolicitudes().contains(solicitudTest));
	}

}
