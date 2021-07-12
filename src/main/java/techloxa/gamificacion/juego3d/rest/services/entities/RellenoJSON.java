package techloxa.gamificacion.juego3d.rest.services.entities;

import java.util.List;

public class RellenoJSON extends PreguntaJSON {
	
	private String frase;
	private String frasesplit;
	private List<String> palabrastrampa;
	private List<String> palabras;
	private List<Integer> posiciones;
	
	public RellenoJSON(String frase, String frasesplit, List<String> palabrastrampa, List<String> palabras,
			List<Integer> posiciones) {
		super();
		this.frase = frase;
		this.frasesplit = frasesplit;
		this.palabrastrampa = palabrastrampa;
		this.palabras = palabras;
		this.posiciones = posiciones;
	}
	public RellenoJSON() {
	}
	public String getFrase() {
		return frase;
	}
	public String getFrasesplit() {
		return frasesplit;
	}
	public List<String> getPalabrastrampa() {
		return palabrastrampa;
	}
	public List<String> getPalabras() {
		return palabras;
	}
	public List<Integer> getPosiciones() {
		return posiciones;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}
	public void setFrasesplit(String frasesplit) {
		this.frasesplit = frasesplit;
	}
	public void setPalabrastrampa(List<String> palabrastrampa) {
		this.palabrastrampa = palabrastrampa;
	}
	public void setPalabras(List<String> palabras) {
		this.palabras = palabras;
	}
	public void setPosiciones(List<Integer> posiciones) {
		this.posiciones = posiciones;
	}
	
	
	
	
	
	
	

}
