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
	
	List<Carta> manoGanadora(List<Carta> manoA, List<Carta> manoB){
		if(this.verificarEmpate(manoA, manoB)) {
			return this.manoGanadoraEmpate(manoA, manoB);
		}
		if(this.soloUnaManoConJuego(manoA, manoB)) {
			return this.manoGanadoraConJuego(manoA, manoB);
		}
		switch (this.verificarJuego(manoA)) {
			case "Poker": //solo llegaria aca descartando que ambos tengan poker, asiq ganaria por ser el de "categoria mayor"
				return manoA;
			case "Color"://aca ya empieza a comparar a ver si el otro tiene poker.
				return this.compararManoColor(manoA, manoB);
			default://aca llegaria si tiene trio, y como b no tiene trio, ni nada, gana B.
				return manoB;
		}//si se agregara otra jugada habria que modificar el case si o si
		//tmb la jugada podria ser un tipo aparte y hacer que se pueda definir el mayor/menor.
	}
	
	boolean verificarEmpate(List<Carta> manoA, List<Carta> manoB) {
		return this.verificarJuego(manoA).equals(this.verificarJuego(manoB));
	}
	List<Carta> manoGanadoraEmpate(List<Carta> manoA, List<Carta> manoB){
		int a = this.valorMayorDeMano(manoA);
		int b = this.valorMayorDeMano(manoB);
		if (this.mayorEntre(a, b) == a) {
			return manoA;
		} else {
			return manoB;
		}//si hay un empate de valores (lo cual solo es posible si hay empate de color o nada) se podria desempatar con valor o dejar en empate, pero eso no lo cubro.
	}
	int valorMayorDeMano(List<Carta> cartas) {
		int mayor = 0;
		for(Carta carta: cartas) {
			mayor = this.mayorEntre(mayor, this.valorPoker(carta));
		}
		return mayor;
	}
	int valorPoker(Carta carta) {
		if (carta.valor()==1) {
			return 14;
		} else {
			return carta.valor();
		}
		//lo hago aca y no en carta porq me parece mas un tema de las reglas del poker en si.
	}
	boolean soloUnaManoConJuego(List<Carta> manoA, List<Carta> manoB) {
		String juegoA = this.verificarJuego(manoA);
		String juegoB = this.verificarJuego(manoB);
		return (juegoA.equals("Nada")^juegoB.equals("Nada"));
	}
	List<Carta> manoGanadoraConJuego(List<Carta> manoA, List<Carta> manoB){
		//una de las 2 manos deberia no tener juego
		if(this.verificarJuego(manoA).equals("Nada")) {
			return manoB;
		} else {
			return manoA;
		}
	}
	List<Carta> compararManoColor(List<Carta> manoA, List<Carta> manoB){
		//la mano A tiene color, y la mano B no puede ser color ni nada.
		if (this.verificarJuego(manoB).equals("Poker")){
			return manoB;
		} else {
			return manoA;
		}
		
	}
}
