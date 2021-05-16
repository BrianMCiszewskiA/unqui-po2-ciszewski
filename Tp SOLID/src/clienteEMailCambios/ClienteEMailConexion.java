package clienteEMailCambios;

public interface ClienteEMailConexion {
	public void conectar();
	public void recibirNuevos();
	public void enviarCorreo(String asunto, String destinatario, String cuerpo);
}
