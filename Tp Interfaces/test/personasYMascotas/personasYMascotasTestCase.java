package personasYMascotas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class personasYMascotasTestCase {
	private Persona pepito;
	private Persona roberto;
	private Mascota rufus;
	private Mascota doge;
	private List<Nombrable> coleccion;
	
	@BeforeEach
	public void setUp() {
		pepito = new Persona("Pepito", 02, 04, 1990);
		roberto = new Persona("Roberto", 15, 03, 1960);
		rufus = new Mascota("Rufus", "Bulldog Frances");
		doge = new Mascota("Doge", "Shiba Inu");
		coleccion = new ArrayList<Nombrable>();

		coleccion.add(pepito);
		coleccion.add(roberto);
		coleccion.add(rufus);
		coleccion.add(doge);
	}
	
	@Test
	void testImprimirEnConsola() {
		//creo podria hacer esto con algun main y ejecutarlo, pero idk
		imprimirColeccion();
		assert(true);
	}
	
	public void imprimirColeccion() {
		for (Nombrable nombrable:coleccion) {
			System.out.println(nombrable.getNombre());
		}
	}

}
