package personasYMascotas;

public class Mascota implements Nombrable{
	String nombre;
	String raza;
	
	public Mascota(String nombre, String raza) {
		this.setNombre(nombre);
		this.setRaza(raza);
	}
	
	private void setNombre(String n){
		nombre = n;
	}
	private void setRaza(String r){
		raza = r;
	}
	
	@Override
	public String getNombre(){
		return nombre;
	}
	public String getRaza(){
		return raza;
	}
}
