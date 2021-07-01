package publicaciones;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Subscripcion implements Observer{
	private Investigador investigador;
	private String palabraClave;
	private SistemaSubscripcion sistema;
	
	public Subscripcion(Investigador inv, String palabra, SistemaSubscripcion sistema) {
		this.setInvestigador(inv);
		this.setPalabra(palabra);
		this.setSistema(sistema);
		sistema.addObserver(this);
	}
	
	private void setInvestigador(Investigador inv) {
		this.investigador = inv;
	}
	private void setPalabra(String palabra) {
		this.palabraClave = palabra;
	}
	private void setSistema(SistemaSubscripcion sistema) {
		this.sistema = sistema;
	}
	
	public String getPalabra() {
		return this.palabraClave;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(this.esDeInteres((ArticuloCientifico) arg)) {
			investigador.notificarArticulo((ArticuloCientifico)arg, palabraClave);
		}
	}
	

	public boolean esDeInteres(ArticuloCientifico articulo) {
		return articulo.getPalabrasClave().contains(this.palabraClave);
	}
	
	
	public void removerSubscripcion() {
		sistema.deleteObserver(this);
	}
	
	
}
