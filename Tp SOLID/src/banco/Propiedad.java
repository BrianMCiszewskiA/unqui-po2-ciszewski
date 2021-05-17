package banco;

public class Propiedad {
	private String breveDescripcion;
	private String direccion;
	private float valorFiscal;
	
	public Propiedad(String desc, String direccion, float valor) {
		this.breveDescripcion=desc;
		this.direccion=direccion;
		this.valorFiscal=valor;
	}

	public String getDescripcion() {
		return breveDescripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public float getValorFiscal() {
		return valorFiscal;
	}
	
	public float porcentajeValorFiscal(int porcentaje) {
		return (this.valorFiscal * porcentaje) /100;
	}
}
