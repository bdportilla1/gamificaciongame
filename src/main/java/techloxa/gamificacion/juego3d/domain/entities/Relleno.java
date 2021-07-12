package techloxa.gamificacion.juego3d.domain.entities;

import java.util.List;

public class Relleno extends Pregunta{
	
	private String frase;
	private List<String> palabrasRelleno;
	private List<String> palabrasTrampa;
	
	
	
	public Relleno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Relleno(String enunciado) {
		super(enunciado);
		// TODO Auto-generated constructor stub
	}
	public Relleno(String frase, List<String> palabrasRelleno) {
		super();
		this.frase = frase;
		this.palabrasRelleno = palabrasRelleno;
	}
	public String getFrase() {
		return frase;
	}
	public List<String> getPalabrasRelleno() {
		return palabrasRelleno;
	}
	public List<String> getPalabrasTrampa() {
		return palabrasTrampa;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public void setPalabrasRelleno(List<String> palabrasRelleno) {
		this.palabrasRelleno = palabrasRelleno;
	}
	public void setPalabrasTrampa(List<String> palabrasTrampa) {
		this.palabrasTrampa = palabrasTrampa;
	}
	
	
	
	
	
	

}
