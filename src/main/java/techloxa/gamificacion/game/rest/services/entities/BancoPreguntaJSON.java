package techloxa.gamificacion.game.rest.services.entities;

import java.util.HashMap;
import java.util.List;

public class BancoPreguntaJSON {
	
	private int idbancopreguntas;
	private String codigo;
	private List<String> paralelos;
	private String tema;
	private String asignatura;
	private String docente;
	private List<HashMap<String, List<PreguntaJSON>>> preguntas;
	
	public BancoPreguntaJSON(int idbancopreguntas, String codigo, List<String> paralelos, String tema,
			String asignatura, String docente, List<HashMap<String, List<PreguntaJSON>>> preguntas) {
		super();
		this.idbancopreguntas = idbancopreguntas;
		this.codigo = codigo;
		this.paralelos = paralelos;
		this.tema = tema;
		this.asignatura = asignatura;
		this.docente = docente;
		this.preguntas = preguntas;
	}
	public BancoPreguntaJSON() {
	
	}
	public int getIdbancopreguntas() {
		return idbancopreguntas;
	}
	public String getCodigo() {
		return codigo;
	}
	public List<String> getParalelos() {
		return paralelos;
	}
	public String getTema() {
		return tema;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public String getDocente() {
		return docente;
	}
	public List<HashMap<String, List<PreguntaJSON>>> getPreguntas() {
		return preguntas;
	}
	public void setIdbancopreguntas(int idbancopreguntas) {
		this.idbancopreguntas = idbancopreguntas;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setParalelos(List<String> paralelos) {
		this.paralelos = paralelos;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public void setPreguntas(List<HashMap<String, List<PreguntaJSON>>> preguntas) {
		this.preguntas = preguntas;
	}
	
	
	
	
	
	

}
