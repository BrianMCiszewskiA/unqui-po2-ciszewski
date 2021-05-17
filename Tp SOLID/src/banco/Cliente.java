package banco;

public class Cliente implements AdminFondos{
	private String nombre;
	private String apellido;
	private String direccion;
	private int edad;
	private float sueldoNetoMensual;
	private float fondos = 0;
	
	public Cliente(String nombre, String apellido, String direccion, int edad, float sueldoMensual) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.edad=edad;
		this.sueldoNetoMensual=sueldoMensual;
	}
	public Cliente(String nombre, String apellido, String direccion, int edad, float sueldoMensual, float fondos) {
		this(nombre, apellido, direccion, edad, sueldoMensual);
		this.fondos=fondos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getEdad() {
		return edad;
	}
	public float getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}
	public float getSueldoNetoAnual() {
		return sueldoNetoMensual *12;
	}
	@Override
	public float getFondos() {
		return fondos;
	}

	@Override
	public void aumentarFondos(float cantidad) {
		fondos = this.fondos + cantidad;
	}
	@Override
	public void descontarFondos(float cantidad) {
		//podria hacer una verificacion de fondos antes de descontarlos
		fondos = this.fondos - cantidad;
	}
	
	public void pedirPrestamo(Banco banco, SolicitudCredito solicitud) {
		banco.registrarSolicitud(solicitud);
	}
	public void recibirPrestamo(float cantidad) {
		this.aumentarFondos(cantidad);
		//hacer algo con el tema meses?
	}
	
	public float getPorcentajeIngresosMensuales(int porcentaje) {
		return (this.getSueldoNetoMensual() * porcentaje) /100;
	}
	
}
