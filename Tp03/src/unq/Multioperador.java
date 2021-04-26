package unq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Multioperador {
	
	public int sumarTodos(List<Integer> numeros) {
		int counter = 0;
		for(Integer n: numeros) {
			counter = counter + n;
		}
		return counter;
	}
	
	public int restarTodos(List<Integer> numeros) {
		int counter = numeros.get(0);
		List<Integer> restoNumeros = numeros.subList(1, numeros.size());
		for(Integer n: restoNumeros) {
			counter = counter - n;
		}
		return counter;
	}
	
	public int multiplicarTodos(List<Integer> numeros) {
		int counter = 1;
		for(Integer n: numeros) {
			counter = counter * n;
		}
		return counter;
	}
	
	public int dividirTodos(List<Integer> numeros) {
		int counter = numeros.get(0);
		List<Integer> restoNumeros = numeros.subList(1, numeros.size());
		for(Integer n: restoNumeros) {
			counter = counter / n;
		}
		return counter;
	}
}
