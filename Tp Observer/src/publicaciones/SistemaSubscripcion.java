package publicaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class SistemaSubscripcion extends Observable{
	private List<ArticuloCientifico> articulos = new ArrayList<ArticuloCientifico>();
	
	public void agregarArticulo(ArticuloCientifico articulo){
		this.articulos.add(articulo);
		this.setChanged();
		this.notifyObservers(articulo);
	}
}
