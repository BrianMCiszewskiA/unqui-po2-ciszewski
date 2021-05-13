package personasYMascotas;

public class Persona implements Nombrable{
	private String nombre;
	private int diaNacimiento;
	private int mesNacimiento;
	private int anioNacimiento;
	
	public Persona(String nombre) {
		this.setNombre(nombre);
	}
	public Persona(String nombre, int dia, int mes, int anio) {
		this(nombre);
		this.setFechaNacimiento(dia, mes, anio);
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	public String getFechaNacimiento(){
		return diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento;
	}
	
	
	private void setNombre(String n){
		nombre = n;
	}
	private void setFechaNacimiento(int dia, int mes, int anio){
		diaNacimiento = dia;
		mesNacimiento = mes;
		anioNacimiento = anio;
	}
	
	public int getEdad(int anio){
		//podria haber reutilizado el codigo de persona hecho en un tp anterior
		return anio - anioNacimiento;
	}
	public boolean menorQue(Persona persona, int anio){
		return this.getEdad(anio) < persona.getEdad(anio);
	}
}

