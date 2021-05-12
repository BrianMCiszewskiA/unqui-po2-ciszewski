package mercadoCentral;

public abstract class Producto implements Pagable{
	protected float precioBase;
	private int stock;
	private String nombre;
	
	public Producto(float precio, int stock, String nombre) {
		this.setPrecioBase(precio);
		this.setStock(stock);
		this.setNombre(nombre);
	}
	
	private void setPrecioBase(float precio) {
		precioBase = precio;
	}
	private void setStock(int n){
		stock = n;
	}
	private void setNombre(String n) {
		nombre = n;
	}
	
	public int getStock() {
		return stock;
	}
	public String getNombre() {
		return nombre;
	}

	public void pagar() {
			this.disminuirStock();
	}
	public boolean sePuedePagar() {
		return this.getStock()>0;
	}
	public void mensajeDeErrorDePago() {
		System.out.println("No hay mas stock de: " + this.getNombre());
	}

	
	public void disminuirStock() {
		try {
			if (this.hayStock()) {
				this.setStock(this.getStock()-1);
			}
			else {
				throw new Exception("no hay stock de " + this.getNombre());
			}
		}
		
		catch (Exception e){
			System.out.print(e); //quizas hacer directamente esto en el else?
		}
	}
	public void reponerStock(int cantidad) {
		this.setStock(this.getStock()+cantidad);
	}
	public boolean hayStock() {
		return this.getStock()>0;
	}
	
	
	public abstract float getPrecio();
}
