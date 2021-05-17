package banco;

import java.util.List;

public interface BancoSolicitudes {
	public void registrarSolicitud(SolicitudCredito solicitud);
	public List<SolicitudCredito> getSolicitudes();
	public List<SolicitudCredito> getSolicitudesAprobadas();
	public boolean checkearSolicitud(SolicitudCredito solicitud);
	public void evaluarSolicitud(SolicitudCredito solicitud);
	public void evaluarSolicitudes();
	public void otorgarCredito(SolicitudCredito solicitud);
	public void otorgarCreditosAprobados();
	public float montoTotalCreditos();
}
