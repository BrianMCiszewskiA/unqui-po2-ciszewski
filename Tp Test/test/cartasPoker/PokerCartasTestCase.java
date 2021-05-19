package cartasPoker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerCartasTestCase {
	//Duplique el otro testCase asi no se pierden las diferencias
	//Pendiente marcar secciones setup etc
	PokerCartasStatus poker;
	String c;
	String d;
	String p;
	String t;
	Carta c2P;
	Carta c5C;
	Carta c7C;
	Carta c7D;
	Carta c7T;
	Carta c8C;
	Carta c8D;
	Carta c8P;
	Carta c8T;
	Carta c9C;
	Carta c9P;
	Carta c9T;
	Carta c10C;
	Carta c10D;
	Carta c10P;
	Carta c10T;
	Carta cJT;
		
	@BeforeEach
	void setUp() throws Exception {
		poker = new PokerCartasStatus();
		c = "Corazon";
		d = "Diamante";
		p = "Pica";
		t = "Trebol";
		
		c2P = new Carta(2, p);
		c5C = new Carta(5, c);
		c7C = new Carta(7, c);
		c7D = new Carta(7, d);
		c7T = new Carta(7, t);
		c8C = new Carta(8, c);
		c8D = new Carta(8, d);
		c8P = new Carta(8, p);
		c8T = new Carta(8, t);
		c9C = new Carta(9, c);
		c9P = new Carta(9, p);
		c9T = new Carta(9, t);
		c10C = new Carta(10, c);
		c10D = new Carta(10, d);
		c10P = new Carta(10, p);
		c10T = new Carta(10, t);
		cJT = new Carta("j", t);
	}
	
	@Test
	void testPoker() {
		assertEquals("Poker", poker.verificar(c8T, c9T, c8D, c8C, c8P));
		assertNotEquals("Poker", poker.verificar(c8T, c9T, c8D, c9C, c8P));
		assertNotEquals("Poker", poker.verificar(c8T, c9T, c8D, c7C, c10P));
	}
	
	@Test
	void testDistintasVerificaciones(){
		assertEquals("Poker", poker.verificar(c8T, c9T, c8D, c8C, c8P));
		assertEquals("Color", poker.verificar(c8T, c9T, c7T, cJT, c10T));
		assertEquals("Trio", poker.verificar(c8T, c9T, c8D, c8C, c9P));
		assertEquals("Nada", poker.verificar(c8T, c9T, c7D, c10C, c8P));
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
	void testValoresDistintos() {
		assertTrue(poker.valoresDistintos(this.manoTrio()).contains(10));
		assertTrue(poker.valoresDistintos(this.manoTrio()).contains(9));
		assertFalse(poker.valoresDistintos(this.manoTrio()).contains(8));
	}
	
	@Test
	void testCantidadRepetidos() {
		assertEquals(4, poker.cantMaxRepeticionNumerica(this.manoPoker()));
		assertEquals(3, poker.cantMaxRepeticionNumerica(this.manoTrio()));
		assertEquals(1, poker.cantMaxRepeticionNumerica(this.manoColor()));
		
		assertEquals(4, poker.cantidadApariciones(8, this.manoPoker()));
		assertEquals(0, poker.cantidadApariciones(10, this.manoPoker()));
		assertEquals(3, poker.cantidadApariciones(10, this.manoTrio()));
	}
		
	List<Carta> manoPoker(){
		//devuelve una "mano" con poker.
		return this.mano(c8T, c9T, c8D, c8C, c8P);
	}
	List<Carta> manoTrio(){
		//devuelve una "mano" con trio.
		return this.mano(c10T, c9T, c10D, c10C, c9P);
	}
	List<Carta> manoColor(){
		//devuelve una "mano" con color.
		return this.mano(c8T, c9T, c7T, cJT, c10T);
	}
	List<Carta> manoNada(){
		//devuelve una "mano" sin juego.
		return this.mano(c8T, c9T, c7D, c10C, c2P);
	}
	
	List<Carta> mano(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5){
		List<Carta> mano = new ArrayList<Carta>();
		mano.add(carta1);
		mano.add(carta2);
		mano.add(carta3);
		mano.add(carta4);
		mano.add(carta5);
		return mano;
	}
}
