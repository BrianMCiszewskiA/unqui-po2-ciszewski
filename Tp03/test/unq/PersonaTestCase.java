package unq;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTestCase {
	private Persona brian;
	private Persona agus;
	private Persona roberto;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		brian = new Persona("Brian", new Date(100, 01, 02));
		agus = new Persona("Agustin", new Date(106, 02, 11));
		roberto = new Persona("Roberto", new Date(60, 11, 05));
	}
	
	@Test
	void testEdad() {
		assertEquals(brian.getEdad(), 21);
		assertEquals(agus.getEdad(), 15);
		assertEquals(roberto.getEdad(), 60);
		
	}
	
	@Test
	void testMenorQue() {
		assertTrue(agus.menorQue(brian));
		assertTrue(brian.menorQue(roberto));
		
		assertFalse(roberto.menorQue(brian));
		assertFalse(brian.menorQue(agus));
	}

}
