package techloxa.gamificacion.juego3d.domain.entities;

public class VerdaderoFalso extends Pregunta {
	private int respuesta;
	private String retroalimentacion;
	
	
	
	

	public VerdaderoFalso(int respuesta, String retroalimentacion) {
		super();
		this.respuesta = respuesta;
		this.retroalimentacion = retroalimentacion;
	}

	public VerdaderoFalso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerdaderoFalso(String enunciado) {
		super(enunciado);
		// TODO Auto-generated constructor stub
	}

	public VerdaderoFalso(int respuesta) {
		super();
		this.respuesta = respuesta;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}
	
	public String getRetroalimentacion() {
		return retroalimentacion;
	}

	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
	
	

}
