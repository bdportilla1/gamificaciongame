package techloxa.gamificacion.juego3d.domain.entities;

public class Jugador {

	
	private String nombre;
	private String paralelo;
	
	
	public Jugador() {
	
	}
	public Jugador(String nombre, String paralelo) {
		super();
		this.nombre = nombre;
		this.paralelo = paralelo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getParalelo() {
		return paralelo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}
	
	
	
	
}
