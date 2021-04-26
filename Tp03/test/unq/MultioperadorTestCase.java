package unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;



class MultioperadorTestCase {
	private List<Integer> numbers;    
	private Multioperador multioperador;
	   
	/**
	* Crea un escenario de test básico, que consiste en un contador 
	* con 10 enteros
	* 
	* @throws Exception
	*/
	@BeforeEach
	public void setUp() throws Exception {
		//Se crea el contador
		numbers = new ArrayList<Integer>();
		multioperador = new Multioperador();

		//Se agregan los numeros. Un solo par y nueve impares
		numbers.add(2);
		numbers.add(2);
	}
	
	@Test
	void testSuma() {
		assertEquals(multioperador.sumarTodos(numbers), 4);
	}
	@Test
	void testResta() {
		assertEquals(multioperador.restarTodos(numbers), 0);
	}
	@Test
	void testMultiplicacion() {
		assertEquals(multioperador.multiplicarTodos(numbers), 4);
	}
	@Test
	void testDivicion() {
		assertEquals(multioperador.dividirTodos(numbers), 1);
	}
}
