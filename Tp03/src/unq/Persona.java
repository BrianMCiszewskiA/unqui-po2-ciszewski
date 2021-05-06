package unq;

import java.util.Date;

public class Persona {
	private String nombre;
	private Date fechaNacimiento;
	
	public Persona(String nom, Date fNacimiento) {
		this.setNombre(nom);
		this.setFechaNacimiento(fNacimiento);
	}
	
	private void setNombre(String nom) {
		nombre = nom;
	}
	private void setFechaNacimiento(Date fNacimiento) {
		fechaNacimiento = fNacimiento;
	}
	
	public String getNombre() {
		return nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento; 
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
}
