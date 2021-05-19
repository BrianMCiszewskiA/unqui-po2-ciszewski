package cartasPoker;

public class Carta {
	private int valor;
	private String color;
	
	public Carta(int valor, String color) {
		this.valor=valor;
		this.color=color;
	}
	public Carta(String valor, String color) {
		this.valor=this.letraAValor(valor);
		this.color=color;
	}
	int letraAValor(String letra) {
		switch(letra) {
			case "A":
				return 1;
			case "a":
				return 1;
			case "J":
				return 11;
			case "j":
				return 11;
			case "Q":
				return 12;
			case "q":
				return 12;
			case "K":
				return 13;
			case "k":
				return 13;
			default:
				//no deberia llegar aca
				return 0;
		}
	}
	public int valor() {
		return valor;
	}
	public String color() {
		return color;
	}
	public String nombre() {
		return this.valorAString() + " de " + this.color();
	}
	public String valorAString() {
		switch(this.valor()) {
			case 1:
				return "As";
			case 11:
				return "Jota";
			case 12:
				return "Reina";
			case 13:
				return "Rey";
			default:
				return "" + this.valor();
		}
	}
	public boolean esMayorA(Carta carta) {
		return this.valor() > carta.valor();
	}
	public boolean sonDeMismoPalo(Carta carta) {
		return this.color().equals(carta.color());
	}
}
