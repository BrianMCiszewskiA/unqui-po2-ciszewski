package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTestCase {
	private Cliente pepito;
	private Cliente roberto;
	
	@BeforeEach
	void setUp(){
		pepito = new Cliente("Pepito", "Perez", "Calle Falsa 123", 23, 52000);
		roberto = new Cliente("Roberto", "Hernandez", "Avenida Siempreviva 457", 45, 70500);
		
	}

	@Test
	void testNombreCompleto() {
		assertEquals("Pepito Perez", pepito.getNombreCompleto());
		assertEquals("Roberto Hernandez", roberto.getNombreCompleto());
	}
	
	@Test
	void testSueldoAnual() {
		assertEquals(624000, pepito.getSueldoNetoAnual());
		assertEquals(846000, roberto.getSueldoNetoAnual());
	}

}
