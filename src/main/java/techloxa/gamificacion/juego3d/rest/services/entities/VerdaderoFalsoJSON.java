package techloxa.gamificacion.juego3d.rest.services.entities;

public class VerdaderoFalsoJSON extends PreguntaJSON {

	private boolean respuesta;
	private String retroalimentacion;
	
	public VerdaderoFalsoJSON(boolean respuesta, String retroalimentacion) {
		super();
		this.respuesta = respuesta;
		this.retroalimentacion = retroalimentacion;
	}
	public VerdaderoFalsoJSON() {
	}
	public boolean isRespuesta() {
		return respuesta;
	}
	public String getRetroalimentacion() {
		return retroalimentacion;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
}
