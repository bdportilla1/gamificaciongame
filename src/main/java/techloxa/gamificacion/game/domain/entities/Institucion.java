package techloxa.gamificacion.game.domain.entities;

public class Institucion {
	
	private String nombre;
	private String nivel;
	private String tipo;
	
	public Institucion() {
		
	}
	
	public Institucion(String nombre, String nivel, String tipo) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.tipo = tipo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getNivel() {
		return nivel;
	}
	public String getTipo() {
		return tipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
