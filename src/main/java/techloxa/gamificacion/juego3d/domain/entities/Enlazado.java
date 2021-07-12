package techloxa.gamificacion.juego3d.domain.entities;

import java.util.List;

public class Enlazado extends Pregunta {
	
	private List<String> palabrasA;
	private List<String> palabrasB;
	
	
	
	public Enlazado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enlazado(String enunciado) {
		super(enunciado);
		// TODO Auto-generated constructor stub
	}
	public Enlazado(List<String> palabrasA, List<String> palabrasB) {
		super();
		this.palabrasA = palabrasA;
		this.palabrasB = palabrasB;
	}
	public List<String> getPalabrasA() {
		return palabrasA;
	}
	public List<String> getPalabrasB() {
		return palabrasB;
	}
	public void setPalabrasA(List<String> palabrasA) {
		this.palabrasA = palabrasA;
	}
	public void setPalabrasB(List<String> palabrasB) {
		this.palabrasB = palabrasB;
	}
	
	

}
