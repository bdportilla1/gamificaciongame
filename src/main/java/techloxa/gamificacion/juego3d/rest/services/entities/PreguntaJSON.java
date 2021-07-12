package techloxa.gamificacion.juego3d.rest.services.entities;

public class PreguntaJSON {
	private String enunciado;
	private String tipo;
	private String complejidad;
	
	
	

	public PreguntaJSON() {
	}
	
	public PreguntaJSON(String tipo, String enunciado, String compledidad) {
		super();
		this.enunciado = tipo;
		this.enunciado = enunciado;
		this.enunciado = compledidad;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	
	
	
	

}
