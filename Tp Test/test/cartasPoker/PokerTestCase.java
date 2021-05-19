package cartasPoker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerTestCase {
	//Pendiente marcar secciones setup etc
	PokerStatus poker;
	
	@BeforeEach
	void setUp() throws Exception {
		poker = new PokerStatus();
	}

	@Test
	void testPoker() {
		assertEquals("Poker", poker.verificar("8T", "9T", "8D", "8C", "8P"));
		assertNotEquals("Poker", poker.verificar("8T", "9T", "8D", "9C", "8P"));
		assertNotEquals("Poker", poker.verificar("8T", "9T", "8D", "7C", "10P"));
	}
	
	@Test
	void testDistintasVerificaciones(){
		assertEquals("Poker", poker.verificar("8T", "9T", "8D", "8C", "8P"));
		assertEquals("Color", poker.verificar("8T", "9T", "7T", "JT", "10T"));
		assertEquals("Trio", poker.verificar("8T", "9T", "8D", "8C", "9P"));
		assertEquals("Nada", poker.verificar("8T", "9T", "7D", "10C", "8P"));
		
	}
	
	@Test
	void testPoker2() {
		assertTrue(poker.hayPoker(this.manoPoker()));
		assertFalse(poker.hayPoker(this.manoTrio()));
		assertFalse(poker.hayPoker(this.manoColor()));
		assertFalse(poker.hayPoker(this.manoNada()));
		
	}
	@Test
	void testTrio() {
		assertFalse(poker.hayTrio(this.manoPoker()));
		assertTrue(poker.hayTrio(this.manoTrio()));
		assertFalse(poker.hayTrio(this.manoColor()));
		assertFalse(poker.hayTrio(this.manoNada()));
		
	}
	@Test
	void testColor() {
		assertFalse(poker.hayColor(this.manoPoker()));
		assertFalse(poker.hayColor(this.manoTrio()));
		assertTrue(poker.hayColor(this.manoColor()));
		assertFalse(poker.hayColor(this.manoNada()));
		
	}
	@Test
	void testColores() {
		assertEquals("T", poker.colorDe("10T"));
		assertEquals("C", poker.colorDe("5C"));
		assertTrue(poker.coloresMano(this.manoNada()).contains("T"));
		assertTrue(poker.coloresMano(this.manoNada()).contains("C"));
		assertTrue(poker.coloresMano(this.manoNada()).contains("D"));
		assertTrue(poker.coloresMano(this.manoNada()).contains("P"));
		assertFalse(poker.coloresMano(this.manoNada()).contains("10"));
	}
	
	@Test
	void testValoresDistintos() {
		assertEquals("10", poker.cartaAValor("10T"));
		assertEquals("5", poker.cartaAValor("5C"));
		assertTrue(poker.valoresDistintos(this.manoTrio()).contains("10"));
		assertTrue(poker.valoresDistintos(this.manoTrio()).contains("9"));
		assertFalse(poker.valoresDistintos(this.manoTrio()).contains("8"));
		assertFalse(poker.valoresDistintos(this.manoTrio()).contains("T"));
	}
	
	@Test
	void testCantidadRepetidos() {
		assertEquals(4, poker.cantMaxRepeticionNumerica(this.manoPoker()));
		assertEquals(3, poker.cantMaxRepeticionNumerica(this.manoTrio()));
		assertEquals(1, poker.cantMaxRepeticionNumerica(this.manoColor()));
		
		assertEquals(4, poker.cantidadApariciones("8", this.manoPoker()));
		assertEquals(0, poker.cantidadApariciones("10", this.manoPoker()));
		assertEquals(3, poker.cantidadApariciones("10", this.manoTrio()));
		
		
	}
	
	
	List<String> manoPoker(){
		//devuelve una "mano" con poker.
		return this.mano("8T", "9T", "8D", "8C", "8P");
	}
	List<String> manoTrio(){
		//devuelve una "mano" con trio.
		return this.mano("10T", "9T", "10D", "10C", "9P");
	}
	List<String> manoColor(){
		//devuelve una "mano" con color.
		return this.mano("8T", "9T", "7T", "JT", "10T");
	}
	List<String> manoNada(){
		//devuelve una "mano" sin juego.
		return this.mano("8T", "9T", "7D", "10C", "2P");
	}
	
	List<String> mano(String carta1, String carta2, String carta3, String carta4, String carta5){
		List<String> mano = new ArrayList<String>();
		mano.add(carta1);
		mano.add(carta2);
		mano.add(carta3);
		mano.add(carta4);
		mano.add(carta5);
		return mano;
	}
}
