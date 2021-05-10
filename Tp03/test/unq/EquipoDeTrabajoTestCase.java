package unq;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipoDeTrabajoTestCase {
	private Persona persona1;
	private Persona persona2;
	private Persona persona3;
	private Persona persona4;
	private Persona persona5;
	private List<Persona> cPersonas123;
	private EquipoDeTrabajo equipo;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		persona1 = new Persona("Brian", "Ciszewski", new Date(100, 01, 02));
		persona2 = new Persona("Roberto", "Perez", new Date(105, 02, 15));
		persona3 = new Persona("Rey", "BabyYoda", new Date(101, 03, 24));
		persona4 = new Persona("Juan", "Perinola", new Date(90, 8, 11));
		persona5 = new Persona("Xol", "Ilphelkir", new Date(99, 04, 23));
		cPersonas123 = new ArrayList<Persona>();
		cPersonas123.add(persona1);
		cPersonas123.add(persona2);
		cPersonas123.add(persona3);
		equipo = new EquipoDeTrabajo("Equipo de Rol", cPersonas123);
		equipo.agregarIntegrante(persona4);
		equipo.agregarIntegrante(persona5);
	}
	

	@Test
	void testPromedioEdades() {
		assertEquals(equipo.promedioEdad(), 21);
		System.out.print(equipo.promedioEdad());
	}

}
