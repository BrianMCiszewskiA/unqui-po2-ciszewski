package clienteEMailCambios;

import java.util.List;

public interface IServidorConexion {
	public List<Correo> recibirNuevos(String user, String pass);
	public void conectar(String nombreUsuario, String passusuario);
	public void enviar(Correo correo);
}
