package banco;

import java.util.ArrayList;
import java.util.List;

public class Banco implements BancoAdminClientes, AdminFondos, BancoSolicitudes{
	private List<SolicitudCredito> solicitudesRegistradas = new ArrayList<SolicitudCredito>();
	private List<SolicitudCredito> solicitudesAprobadas = new ArrayList<SolicitudCredito>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private float fondos;
	
	public Banco() {
		this.fondos=0;
	}
	public Banco(float fondos) {
		this.fondos=fondos;
	}
	
	@Override
	public void registrarSolicitud(SolicitudCredito solicitud) {
		this.solicitudesRegistradas.add(solicitud);
	}
	private void removerSolicitudRegistrada(SolicitudCredito solicitud) {
		this.solicitudesRegistradas.remove(solicitud);
	}

	@Override
	public List<SolicitudCredito> getSolicitudes() {
		return solicitudesRegistradas;
	}
	@Override
	public List<SolicitudCredito> getSolicitudesAprobadas() {
		return solicitudesAprobadas;
	}
	

	@Override
	public void evaluarSolicitud(SolicitudCredito solicitud) {
		if (this.checkearSolicitud(solicitud)) {
			this.registrarSolicitudAprobada(solicitud);
			this.removerSolicitudRegistrada(solicitud);
		}
	}
	@Override
	public void evaluarSolicitudes() {
		for(SolicitudCredito solicitud: solicitudesRegistradas) {
			if (this.checkearSolicitud(solicitud)) {
				this.registrarSolicitudAprobada(solicitud);
			}
		}
		this.removerSolicitudesAprobadasDeLasRegistradas();
	}
	@Override
	public boolean checkearSolicitud(SolicitudCredito solicitud) {
		return solicitud.realizarCheckeo();
	}
	
	private void registrarSolicitudAprobada(SolicitudCredito solicitud) {
		this.solicitudesAprobadas.add(solicitud);
	}
	private void removerSolicitudAprobada(SolicitudCredito solicitud) {
		this.solicitudesAprobadas.remove(solicitud);
	}

	@Override
	public void otorgarCredito(SolicitudCredito solicitud) {
		solicitud.getCliente().recibirPrestamo(solicitud.getMontoSolicitado());
		this.descontarFondos(solicitud.getMontoSolicitado());
		this.removerSolicitudAprobada(solicitud);
	}

	@Override
	public float montoTotalCreditos() {
		// devuelve el valor total de dinero que deberia pagar el banco sobre las solicitudes aprobadas
		float montoTotal= 0;
		for(SolicitudCredito solicitud:solicitudesAprobadas) {
			montoTotal = montoTotal + solicitud.getMontoSolicitado();
		}
		return montoTotal;
	}

	@Override
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
		return clientes;
	}

	@Override
	public void removerCliente(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	@Override
	public float getFondos() {
		return fondos;
	}

	@Override
	public void aumentarFondos(float cantidad) {
		fondos= this.fondos + cantidad;
	}

	@Override
	public void descontarFondos(float cantidad) {
		//podria hacer una verificacion de fondos antes de descontarlos
		fondos= this.fondos - cantidad;
	}
	@Override
	public void otorgarCreditosAprobados() {
		for(SolicitudCredito solicitud:solicitudesAprobadas) {
			solicitud.getCliente().recibirPrestamo(solicitud.getMontoSolicitado());
			this.descontarFondos(solicitud.getMontoSolicitado());
		}
		this.removerSolicitudesAprobadas();
	}
	public void removerSolicitudesAprobadas(){
		this.solicitudesAprobadas = new ArrayList<SolicitudCredito>();
	}
	
	public void removerSolicitudesAprobadasDeLasRegistradas() {
		for (SolicitudCredito solicitud: solicitudesAprobadas) {
			this.removerSolicitudRegistrada(solicitud);
		}
	}


}
//nota: tal vez deberia agregar una tercera interfaz tipo "bancoAdminDinero" y agregar algo q lleve la cuenta de la plata del banco y la descuente al pagar a los clientes.
