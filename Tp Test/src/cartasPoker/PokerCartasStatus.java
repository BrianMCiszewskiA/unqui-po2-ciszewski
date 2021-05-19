package cartasPoker;

import java.util.ArrayList;
import java.util.List;

public class PokerCartasStatus {
	//Duplique la otra clase asi no se pierden las diferencias

	String verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5){
		List<Carta> manoCartas = new ArrayList<Carta>();
		manoCartas.add(carta1);
		manoCartas.add(carta2);
		manoCartas.add(carta3);
		manoCartas.add(carta4);
		manoCartas.add(carta5);
		return this.verificarJuego(manoCartas);
	}
	
	List<Integer> agregarSiEsDistinto(List<Integer> valores, int valorCarta){
		if (!valores.contains(valorCarta)) {
			valores.add(valorCarta);
			return valores;
		} else {
			return valores;
		}
	}
	
	String verificarJuego(List<Carta> cartas) {
		if(this.hayColor(cartas)) {return "Color";} 
		if(this.hayPoker(cartas)) {return "Poker";} 
		if(this.hayTrio(cartas)) {return "Trio";}
		return "Nada";
	}
	boolean hayColor(List<Carta> cartas) {
		boolean hay = cartas.get(0).sonDeMismoPalo(cartas.get(4));
		for(int i=0; i<4; i++) {
			hay = hay && cartas.get(i).sonDeMismoPalo(cartas.get(i+1));
		}
		return hay;
	}
	boolean hayPoker(List<Carta> cartas) {
		return this.cantMaxRepeticionNumerica(cartas) == 4;
	}
	boolean hayTrio(List<Carta> cartas) {
		return this.cantMaxRepeticionNumerica(cartas) == 3;
	}
	
	int cantMaxRepeticionNumerica(List<Carta> cartas) {
		return this.cantMaximaRepeticion(this.valoresDistintos(cartas), cartas);
	}
	
	List<Integer> valoresDistintos(List<Carta> cartas){
		List<Integer> valoresDistintos = new ArrayList<Integer>();
		for (Carta carta: cartas) {
			valoresDistintos = this.agregarSiEsDistinto(valoresDistintos, carta.valor());
		}
		return valoresDistintos;
	}
	int cantMaximaRepeticion(List<Integer> valores, List<Carta> cartas) {
		int maximoRepetidas = 1;
		for(int valor: valores) {
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
	int cantidadApariciones(int valor,List<Carta> cartas) {
		int count = 0;
		for(Carta carta: cartas) {
			count = count + this.unoSiEsIgual(valor, carta.valor());
		}
		return count;
	}
	int unoSiEsIgual(int a, int b) {
		if (a==b) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
