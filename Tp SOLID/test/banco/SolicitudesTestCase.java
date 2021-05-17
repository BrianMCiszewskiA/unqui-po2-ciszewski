package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudesTestCase {
	private Cliente pepito;
	private Cliente roberto;
	private SolicitudCreditoHipotecario hipotecaPepito;
	private SolicitudCreditoHipotecario hipotecaRoberto;
	private SolicitudCreditoPersonal personalPepito;
	private SolicitudCreditoPersonal personalRoberto;
	private Propiedad propiedadPepito;
	private Propiedad propiedadRoberto;
	
	
	
	@BeforeEach
	void setUp(){
		pepito = new Cliente("Pepito", "Perez", "Calle Falsa 123", 23, 52000);
		roberto = new Cliente("Roberto", "Hernandez", "Avenida Siempreviva 457", 64, 70500);

		propiedadPepito = new Propiedad("Casa de Pepito", "Calle Falsa 123", 200000);
		propiedadRoberto = new Propiedad("Casa de Roberto", "Avenida Simpreviva 457", 500000);
		
		hipotecaPepito= new SolicitudCreditoHipotecario(pepito, 15000, 2, propiedadPepito);
		hipotecaRoberto= new SolicitudCreditoHipotecario(roberto, 20000, 24, propiedadRoberto);
		personalPepito= new SolicitudCreditoPersonal(pepito, 51000, 1);
		personalRoberto= new SolicitudCreditoPersonal(roberto, 10000, 5);
		
	}

	@Test
	void testAprobacionDeSolicitudes() {
		assert(hipotecaPepito.realizarCheckeo());
		assertFalse(hipotecaRoberto.realizarCheckeo());
		assertFalse(personalPepito.realizarCheckeo());
		assert(personalRoberto.realizarCheckeo());
	}
	
	@Test
	void testGarantias() {
		Propiedad propiedad = new Propiedad("Valor Fiscal bajo", "Direccion Falsa", 10000);
		SolicitudCredito solicitud1 = new SolicitudCreditoHipotecario(pepito, 7000, 1, propiedad);
		SolicitudCredito solicitud2 = new SolicitudCreditoHipotecario(pepito, 8000, 1, propiedad);
		assertTrue(solicitud1.realizarCheckeo());
		assertFalse(solicitud2.realizarCheckeo());
		
	}

}
