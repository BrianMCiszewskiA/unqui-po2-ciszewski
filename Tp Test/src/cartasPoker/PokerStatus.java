package cartasPoker;

import java.util.ArrayList;
import java.util.List;

public class PokerStatus {

	String verificar(String carta1, String carta2, String carta3, String carta4, String carta5){
		List<String> manoCartas = new ArrayList<String>();
		manoCartas.add(carta1);
		manoCartas.add(carta2);
		manoCartas.add(carta3);
		manoCartas.add(carta4);
		manoCartas.add(carta5);
		return this.verificarJuego(manoCartas);
	}
	
	List<String> agregarSiEsDistinto(List<String> valores, String valorCarta){
		if (!valores.contains(valorCarta)) {
			valores.add(valorCarta);
			return valores;
		} else {
			return valores;
		}
	}
	
	String cartaAValor(String carta) {
		if(carta.length() == 3) {
			return carta.substring(0,2);
		}else {
			return carta.substring(0,1);
		}
	}
	
	String verificarJuego(List<String> cartas) {
		if(this.hayColor(cartas)) {return "Color";} 
		if(this.hayPoker(cartas)) {return "Poker";} 
		if(this.hayTrio(cartas)) {return "Trio";}
		return "Nada";
	}
	boolean hayColor(List<String> cartas) {
		return this.hayUnColor(cartas);
	}
	boolean hayPoker(List<String> cartas) {
		return this.cantMaxRepeticionNumerica(cartas) == 4;
	}
	boolean hayTrio(List<String> cartas) {
		return this.cantMaxRepeticionNumerica(cartas) == 3;
	}
	
	int cantMaxRepeticionNumerica(List<String> cartas) {
		return this.cantMaximaRepeticion(this.valoresDistintos(cartas), cartas);
	}
	
	List<String> coloresMano(List<String> cartas){
		List<String> valoresDistintos = new ArrayList<String>();
		for (String carta: cartas) {
			valoresDistintos = this.agregarSiEsDistinto(valoresDistintos, this.colorDe(carta));
		}
		return valoresDistintos;
	}
	
	String colorDe(String carta) {
		if(carta.length() == 3) {
			return carta.substring(2,3);
		}else {
			return carta.substring(1,2);
		}
	}
	boolean hayUnColor(List<String> cartas) {
		return this.coloresMano(cartas).size() == 1;
	}
	
	List<String> valoresDistintos(List<String> cartas){
		List<String> valoresDistintos = new ArrayList<String>();
		for (String carta: cartas) {
			valoresDistintos = this.agregarSiEsDistinto(valoresDistintos, this.cartaAValor(carta));
		}
		return valoresDistintos;
	}
	int cantMaximaRepeticion(List<String> valores, List<String> cartas) {
		int maximoRepetidas = 1;
		for(String valor: valores) {
			maximoRepetidas = this.mayorEntre(maximoRepetidas, this.cantidadApariciones(valor, cartas));
		}
		return maximoRepetidas;
	}
	int mayorEntre(int valor1, int valor2) {
		if (valor1>valor2) {
			return valor1;
		} else {
			return valor2;
		}
	}
	int cantidadApariciones(String valor,List<String> cartas) {
		int count = 0;
		for(String carta: cartas) {
			count = count + this.unoSiEsIgual(valor, this.cartaAValor(carta));
		}
		return count;
	}
	int unoSiEsIgual(String a, String b) {
		if (a.equals(b)) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
