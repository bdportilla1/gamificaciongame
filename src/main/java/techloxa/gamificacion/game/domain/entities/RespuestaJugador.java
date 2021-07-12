package techloxa.gamificacion.game.domain.entities;

import java.util.List;

public class RespuestaJugador {

	private double puntaje;
	private List<Integer> respuestasJugador;
	
	private BancoPreguntas objBanco;
	private Jugador objJugador;
	
	public RespuestaJugador() {
	}
	public RespuestaJugador(double puntaje, List<Integer> respuestasJugador, BancoPreguntas objBanco,
			Jugador objJugador) {
		super();
		this.puntaje = puntaje;
		this.respuestasJugador = respuestasJugador;
		this.objBanco = objBanco;
		this.objJugador = objJugador;
	}
	public double getPuntaje() {
		return puntaje;
	}
	public List<Integer> getRespuestasJugador() {
		return respuestasJugador;
	}
	public BancoPreguntas getObjBanco() {
		return objBanco;
	}
	public Jugador getObjJugador() {
		return objJugador;
	}
	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}
	public void setRespuestasJugador(List<Integer> respuestasJugador) {
		this.respuestasJugador = respuestasJugador;
	}
	public void setObjBanco(BancoPreguntas objBanco) {
		this.objBanco = objBanco;
	}
	public void setObjJugador(Jugador objJugador) {
		this.objJugador = objJugador;
	}
	
	
	
	
	
}
