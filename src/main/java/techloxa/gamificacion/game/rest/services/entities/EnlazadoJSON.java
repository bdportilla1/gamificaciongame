package techloxa.gamificacion.game.rest.services.entities;

import java.util.List;

public class EnlazadoJSON extends PreguntaJSON {

	
	private List<String> preguntas;
	private List<String> respuestas;
	
	public EnlazadoJSON(List<String> preguntas, List<String> respuestas) {
		super();
		this.preguntas = preguntas;
		this.respuestas = respuestas;
	}
	
	public EnlazadoJSON() {

	}

	public List<String> getPreguntas() {
		return preguntas;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}

	public void setPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
	}

	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}
}
