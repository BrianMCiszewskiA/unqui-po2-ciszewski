package cartasPoker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadasPokerTestCase {
	PokerCartasStatus poker;
	String c;
	String d;
	String p;
	String t;
	Carta cAD;
	Carta c2P;
	Carta c7D;
	Carta c7T;
	Carta c8C;
	Carta c8D;
	Carta c8P;
	Carta c8T;
	Carta c9P;
	Carta c9T;
	Carta c10C;
	Carta c10D;
	Carta c10T;
	Carta cJT;
		
	@BeforeEach
	void setUp() throws Exception {
		//Setup
		poker = new PokerCartasStatus();
		c = "Corazon";
		d = "Diamante";
		p = "Pica";
		t = "Trebol";
		

		cAD = new Carta("A", d);
		c2P = new Carta(2, p);
		c7D = new Carta(7, d);
		c7T = new Carta(7, t);
		c8C = new Carta(8, c);
		c8D = new Carta(8, d);
		c8P = new Carta(8, p);
		c8T = new Carta(8, t);
		c9P = new Carta(9, p);
		c9T = new Carta(9, t);
		c10C = new Carta(10, c);
		c10D = new Carta(10, d);
		c10T = new Carta(10, t);
		cJT = new Carta("j", t);
	}
	
	@Test
	void testJugadaGanadora() {
		//Verify
		assertEquals(this.manoPoker(), poker.manoGanadora(this.manoPoker(), this.manoColor()));
		assertEquals(this.manoColor(), poker.manoGanadora(this.manoTrio(), this.manoColor()));
		assertEquals(this.manoTrio(), poker.manoGanadora(this.manoTrio(), this.manoNada()));
		assertEquals(this.manoPoker(), poker.manoGanadora(this.manoPoker(), this.manoTrio()));
		assertEquals(this.manoColor(), poker.manoGanadora(this.manoNada(), this.manoColor()));
	}
	
	@Test
	void testManoSinJuego() {
		//Verify
		assertTrue(poker.soloUnaManoConJuego(this.manoNada(), this.manoColor()));
		assertTrue(poker.soloUnaManoConJuego(this.manoColor(), this.manoNada()));
		assertFalse(poker.soloUnaManoConJuego(this.manoNada(), this.manoNada()));
		assertFalse(poker.soloUnaManoConJuego(this.manoColor(), this.manoColor()));
	}
	
	@Test
	void testEmpate() {
		//Excercise
		// cartas iguales para ahorrar
		List<Carta> manoPoker8 = new ArrayList<Carta>();
		List<Carta> manoPoker9 = new ArrayList<Carta>();
		for(int i=0; i<=4;i++) {
			manoPoker8.add(c8C);
			manoPoker9.add(c9P);
		}

		//Verify
		assertEquals(manoPoker9, poker.manoGanadora(manoPoker9, manoPoker8));
	}
	
	
	@Test
	void testValoresPoker() {
		//Verify
		assertEquals(14, poker.valorPoker(cAD));//transforma el valor de la carta a su valor para el poker(solo modifica el as).
		assertEquals(11, poker.valorPoker(cJT));
	}

	//Excercise
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
