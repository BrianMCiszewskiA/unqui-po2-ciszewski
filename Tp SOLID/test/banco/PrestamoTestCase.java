package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrestamoTestCase {
	private Banco banco;
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
		banco = new Banco(1000000);
		pepito = new Cliente("Pepito", "Perez", "Calle Falsa 123", 23, 52000);
		roberto = new Cliente("Roberto", "Hernandez", "Avenida Siempreviva 457", 64, 70500);

		propiedadPepito = new Propiedad("Casa de Pepito", "Calle Falsa 123", 200000);
		propiedadRoberto = new Propiedad("Casa de Roberto", "Avenida Simpreviva 457", 500000);
		
		hipotecaPepito= new SolicitudCreditoHipotecario(pepito, 15000, 2, propiedadPepito);
		hipotecaRoberto= new SolicitudCreditoHipotecario(roberto, 20000, 24, propiedadRoberto);
		personalPepito= new SolicitudCreditoPersonal(pepito, 51000, 1);
		personalRoberto= new SolicitudCreditoPersonal(roberto, 10000, 5);
		
		pepito.pedirPrestamo(banco, hipotecaPepito);
		pepito.pedirPrestamo(banco, personalPepito);
		roberto.pedirPrestamo(banco, hipotecaRoberto);
		roberto.pedirPrestamo(banco, personalRoberto);
		
	}
	@Test
	void testEvaluacionesRegistradas() {
		assertEquals(4, banco.getSolicitudes().size());
	}

	@Test
	void testCheckearSolicitudes() {
		assert(banco.checkearSolicitud(hipotecaPepito));
		assertFalse(banco.checkearSolicitud(hipotecaRoberto));
		assertFalse(banco.checkearSolicitud(personalPepito));
		assert(banco.checkearSolicitud(personalRoberto));
	}
	@Test
	void testEvaluarSolicitudes() {
		banco.evaluarSolicitud(hipotecaPepito);
		banco.evaluarSolicitud(hipotecaRoberto);
		banco.evaluarSolicitud(personalPepito);
		banco.evaluarSolicitud(personalPepito);
	}
	
	@Test
	void testEvaluarTodos() {
		banco.evaluarSolicitudes();
		
		//assertEquals(2, banco.getSolicitudes().size());
		assertEquals(2, banco.getSolicitudesAprobadas().size());
	}
	
	@Test
	void testMontoTotalAprobadas() {
		assertEquals(0, banco.montoTotalCreditos());
		banco.evaluarSolicitudes();
		assertEquals(25000, banco.montoTotalCreditos());
	}
	
	@Test
	void testOtorgarCreditosAprobados() {
		banco.evaluarSolicitudes();
		banco.otorgarCreditosAprobados();
		assertEquals(975000, banco.getFondos());
		assertEquals(15000, pepito.getFondos());
		assertEquals(10000, roberto.getFondos());
	}
	//remover solicitudes aparte sin reutilizar codigo de la activiad individual
}
