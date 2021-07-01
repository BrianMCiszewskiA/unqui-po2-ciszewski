package publicaciones;

import java.util.List;

public class ArticuloCientifico{
	private String titulo;
	private List<String> autores;
	private List<String> filiaciones;
	private String tipoArticulo;
	private String lugarPublicacion;
	private List<String> palabrasClave;
	private SistemaSubscripcion sistema;
	
	public ArticuloCientifico(String titulo, List<String> autores, List<String> filiaciones, String tipoArticulo, String lugarPublicacion, List<String> palabrasClave, SistemaSubscripcion sistema) {
		this.setTitulo(titulo);
		this.setAutores(autores);
		this.setFiliaciones(filiaciones);
		this.setTipoArticulo(tipoArticulo);
		this.setLugarPublicacion(lugarPublicacion);
		this.setPalabrasClave(palabrasClave);
		this.setSistema(sistema);
		sistema.agregarArticulo(this);
	}
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	private void setAutores(List<String> autores) {
		this.autores = autores;
	}
	private void setFiliaciones(List<String> filiaciones) {
		this.filiaciones = filiaciones;
	}
	private void setTipoArticulo(String tipo) {
		this.tipoArticulo = tipo;
	}
	private void setLugarPublicacion(String lugar) {
		this.lugarPublicacion = lugar;
	}
	private void setPalabrasClave(List<String> palabras) {
		this.palabrasClave = palabras;
	}
	private void setSistema(SistemaSubscripcion sistema) {
		this.sistema = sistema;
	}
	
	public List<String> getPalabrasClave(){
		return this.palabrasClave;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
}
