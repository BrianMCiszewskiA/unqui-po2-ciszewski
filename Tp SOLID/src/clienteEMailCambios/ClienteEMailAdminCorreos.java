package clienteEMailCambios;

public interface ClienteEMailAdminCorreos {
	public int contarInbox();
	public int contarBorrados();
	public void borrarCorreo(Correo correo);
	public void eliminarBorrado(Correo correo);
}
