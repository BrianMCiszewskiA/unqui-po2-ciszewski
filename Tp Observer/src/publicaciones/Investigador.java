package publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Investigador {
	private List<Subscripcion> misSubscripciones = new ArrayList<Subscripcion>();
	
	public void subscribirse(SistemaSubscripcion sistema, String palabraClave) {
		this.misSubscripciones.add(new Subscripcion(this, palabraClave, sistema));
	}
	public void desubscribirse(Subscripcion subs) {
		if(this.misSubscripciones.contains(subs)){
			this.misSubscripciones.remove(subs);
			subs.removerSubscripcion();
		}
	}
	public void notificarArticulo(ArticuloCientifico art, String palabraClave) {
		String mensaje = "Se ha publicado un nuevo articulo sobre " + palabraClave + ". \n" + "Titulado: " + art.getTitulo();
		System.out.println(mensaje);
	}
	
	public List<Subscripcion> getSubscripciones(){
		return this.misSubscripciones;
	}
}
