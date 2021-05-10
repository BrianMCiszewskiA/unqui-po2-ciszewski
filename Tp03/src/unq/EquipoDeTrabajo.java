package unq;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class EquipoDeTrabajo {
	private String nombreEquipo;
	private List<Persona> integrantes = new ArrayList<Persona>();

	public EquipoDeTrabajo(String nombre){
		this.setNombreEquipo(nombre);
	}
	
	public EquipoDeTrabajo(String nombre, List<Persona> personas){
		this(nombre);
		this.setIntegrantes(personas);
	}

	private void setNombreEquipo(String n){
		nombreEquipo = n;
	}
	private void setIntegrantes(List<Persona> personas){
		integrantes = personas;
	}
	
	public String getNombreEquipo(){
		return nombreEquipo;
	}
	public List<Persona> getIntegrantes(){ 
		return integrantes;
	}

	public void agregarIntegrante(Persona persona){
		integrantes.add(persona); 
	}
	public void removerIntegrante(Persona persona){
		integrantes.remove(persona); 
	}

	public int promedioEdad(){
		int sumaEdades = 0;
		for(Persona p : integrantes){
			sumaEdades = sumaEdades + p.getEdad();
		}
		return sumaEdades / integrantes.size();
	}
}
