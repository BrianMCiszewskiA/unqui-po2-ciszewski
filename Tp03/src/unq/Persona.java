package unq;

import java.util.Date;

public class Persona {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	
	public Persona(String nom, Date fNacimiento) {
		this.setNombre(nom);
		this.setFechaNacimiento(fNacimiento);
	}
	public Persona(String nom, String ape, Date fNacimiento) {
		this(nom, fNacimiento);
		this.setApellido(ape);
	}
	
	private void setNombre(String nom) {
		nombre = nom;
	}
	private void setFechaNacimiento(Date fNacimiento) {
		fechaNacimiento = fNacimiento;
	}
	private void setApellido(String ape){
		apellido = ape;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento; 
	}
	public String getApellido(){
	 	return apellido;
	}
	@SuppressWarnings("deprecation")
	public int getEdad() {
		if (this.yaPasoElCumple()) {
			return new Date().getYear() - this.getFechaNacimiento().getYear();
		}
		else {
			return (new Date().getYear() - this.getFechaNacimiento().getYear()) -1;
		}
	}
	@SuppressWarnings("deprecation")
	public boolean yaPasoElCumple() {
		Date cumpleEsteAnio = new Date(new Date().getYear(), this.getFechaNacimiento().getMonth(), this.getFechaNacimiento().getDay());
		return new Date().after(cumpleEsteAnio);
	}
	
	public boolean menorQue(Persona persona) {
		return this.getEdad() < persona.getEdad();
	}
	
	public String getNombreCompuesto(){
		return nombre + " " + apellido;
	}
}
