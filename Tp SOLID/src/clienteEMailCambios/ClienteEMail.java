package clienteEMailCambios;

import java.util.ArrayList;

public class ClienteEMail implements ClienteEMailConexion, ClienteEMailAdminCorreos{
	IServidor servidor;
	String nombreUsuario;
	String passusuario;
	ArrayList<Correo> inbox;
	private ArrayList<Correo> borrados;
	
	public ClienteEMail(IServidor servidor, String nombreUsuario, String pass){
		this.servidor=servidor;
		this.nombreUsuario=nombreUsuario;
		this.passusuario=pass;
		this.inbox = new ArrayList<Correo>();
		this.borrados = new ArrayList<Correo>();
		this.conectar();
	}
	
	@Override
	public int contarInbox() {
		return this.inbox.size();
	}

	@Override
	public int contarBorrados() {
		return this.borrados.size();
	}

	@Override
	public void borrarCorreo(Correo correo) {
		this.inbox.remove(correo);
		this.borrados.remove(correo);
	}

	@Override
	public void eliminarBorrado(Correo correo) {
		this.borrados.remove(correo);
	}

	@Override
	public void conectar() {
		this.servidor.conectar(this.nombreUsuario,this.passusuario);
	}

	@Override
	public void recibirNuevos() {
		this.servidor.recibirNuevos(this.nombreUsuario, this.passusuario);
	}

	@Override
	public void enviarCorreo(String asunto, String destinatario, String cuerpo) {
		Correo correo = new Correo(asunto, destinatario, cuerpo);
		this.servidor.enviar(correo);
	}

}
