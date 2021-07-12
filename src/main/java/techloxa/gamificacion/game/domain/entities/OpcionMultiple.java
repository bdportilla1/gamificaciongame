package techloxa.gamificacion.game.domain.entities;

import java.util.List;

public class OpcionMultiple extends Pregunta {
	
	private List<String> respuestas;
	private String respuestaCorrecta;
	private String retroalimentacion;
	
	public OpcionMultiple(List<String> respuestas, String respuestaCorrecta, String retroalimentacion) {
		super();
		this.respuestas = respuestas;
		this.respuestaCorrecta = respuestaCorrecta;
		this.retroalimentacion = retroalimentacion;
	}
	public OpcionMultiple() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OpcionMultiple(String enunciado) {
		super(enunciado);
		// TODO Auto-generated constructor stub
	}
	public List<String> getRespuestas() {
		return respuestas;
	}
	public String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}
	public String getRetroalimentacion() {
		return retroalimentacion;
	}
	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}
	public void setRespuestaCorrecta(String respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}
	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
	
	
	
	
	
	

	
	
	

}
