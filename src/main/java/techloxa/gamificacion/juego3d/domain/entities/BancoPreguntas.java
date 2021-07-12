package techloxa.gamificacion.juego3d.domain.entities;

import java.util.List;

public class BancoPreguntas {
	
	private String codigo;
	private String grado;
	private String nivelComplejidad;
	private String tema;
	private String periodo;
	
	private List<Pregunta> lsPreguntas;
	private Asignatura objAsignatura;
	private Profesor objProfesor;
	

	public BancoPreguntas() {
	
	}
	public BancoPreguntas(String codigo, String grado, String nivelComplejidad, String tema, String periodo,
			List<Pregunta> lsPreguntas, Asignatura objAsignatura, Profesor objProfesor) {
		super();
		this.codigo = codigo;
		this.grado = grado;
		this.nivelComplejidad = nivelComplejidad;
		this.tema = tema;
		this.periodo = periodo;
		this.lsPreguntas = lsPreguntas;
		this.objAsignatura = objAsignatura;
		this.objProfesor = objProfesor;
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public String getGrado() {
		return grado;
	}
	public String getNivelComplejidad() {
		return nivelComplejidad;
	}
	public String getTema() {
		return tema;
	}
	public String getPeriodo() {
		return periodo;
	}
	public List<Pregunta> getLsPreguntas() {
		return lsPreguntas;
	}
	public Asignatura getObjAsignatura() {
		return objAsignatura;
	}
	public Profesor getObjProfesor() {
		return objProfesor;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public void setNivelComplejidad(String nivelComplejidad) {
		this.nivelComplejidad = nivelComplejidad;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public void setLsPreguntas(List<Pregunta> lsPreguntas) {
		this.lsPreguntas = lsPreguntas;
	}
	public void setObjAsignatura(Asignatura objAsignatura) {
		this.objAsignatura = objAsignatura;
	}
	public void setObjProfesor(Profesor objProfesor) {
		this.objProfesor = objProfesor;
	}
		
	

}
