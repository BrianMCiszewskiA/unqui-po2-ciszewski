package cartasPoker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTestCase {
	//Setup
	Carta ochoTrebol;
	Carta ochoCorazon;
	Carta nuevePica;
	Carta asDiamante;
	Carta jPica;
	Carta qPica;
	Carta kPica;
	Carta kDiamante;
	
	@BeforeEach
	void setUp() throws Exception {
		//Setup
		ochoTrebol = new Carta(8, "Trebol");
		ochoCorazon = new Carta(8, "Corazon");
		nuevePica = new Carta(9, "Pica");
		asDiamante = new Carta("A", "Diamante");
		jPica = new Carta("J", "Pica");
		qPica = new Carta("Q", "Pica");
		kPica = new Carta("K", "Pica");
		kDiamante = new Carta(13, "Diamante");
	}

	@Test
	void testValor() {
		//Verify
		assertEquals(8, ochoTrebol.valor());
		assertEquals(8, ochoCorazon.valor());
		assertEquals(1, asDiamante.valor());
		assertEquals(12, qPica.valor());
		assertEquals(13, kDiamante.valor());
		
		assertEquals(11, jPica.letraAValor("J"));
	}
	
	@Test
	void testColor() {
		//Verify
		assertEquals("Trebol", ochoTrebol.color());
		assertEquals("Corazon", ochoCorazon.color());
		assertEquals("Pica", nuevePica.color());
		assertEquals("Diamante", kDiamante.color());
	}
	@Test
	void testNombre() {
		//Verify
		assertEquals("8 de Trebol", ochoTrebol.nombre());
		assertEquals("As de Diamante", asDiamante.nombre());
		assertEquals("Rey de Pica", kPica.nombre());
		assertEquals("Reina de Pica", qPica.nombre());
		assertEquals("Jota de Pica", jPica.nombre());
	}
	
	@Test
	void testComparacionNumerica() {
		//Verify
		assertTrue(ochoTrebol.esMayorA(asDiamante));
		assertTrue(nuevePica.esMayorA(ochoTrebol));
		assertTrue(kDiamante.esMayorA(jPica));
		assertFalse(asDiamante.esMayorA(jPica));
		assertFalse(ochoTrebol.esMayorA(ochoCorazon));
		assertFalse(ochoTrebol.esMayorA(nuevePica));
	}
	
	@Test
	void testComparacionColor() {
		//Verify
		assertTrue(asDiamante.sonDeMismoPalo(kDiamante));
		assertTrue(jPica.sonDeMismoPalo(kPica));
		assertFalse(ochoTrebol.sonDeMismoPalo(ochoCorazon));
		assertFalse(nuevePica.sonDeMismoPalo(asDiamante));
	}

}
