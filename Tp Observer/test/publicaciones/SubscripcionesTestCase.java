package publicaciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

class SubscripcionesTestCase {
	@Mock
	private Investigador inv;
	private SistemaSubscripcion sistema;
	private ArticuloCientifico art1;
	private ArticuloCientifico art2;
	private Subscripcion sub;

	@BeforeEach
	void setUp() throws Exception {
		inv = mock (Investigador.class);
		sistema = new SistemaSubscripcion();
		sub = new Subscripcion(inv, "papasFritas", sistema);
	}

	@Test
	void testNotificacionSubscripcion() {
		art1 = new ArticuloCientifico("Nueva formula en las papas de McDonalds", List.of("Pepito") , List.of("Unq"),"Informativo", "Buenos Aires", List.of("McDonalds", "papasFritas", "formula") ,sistema);
		verify(inv, atLeastOnce()).notificarArticulo(art1, "papasFritas");
	}
	@Test
	void testNoNotifica() {
		art1 = new ArticuloCientifico("Nueva formula en las papas de McDonalds", List.of("Pepito") , List.of("Unq"),"Informativo", "Buenos Aires", List.of("McDonalds", "formula") ,sistema);
		verify(inv, never()).notificarArticulo(art1, "papasFritas");
	}
}
