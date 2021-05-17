package banco;

public interface AdminFondos {
	public float getFondos();
	public void aumentarFondos(float cantidad);
	public void descontarFondos(float cantidad);
}
