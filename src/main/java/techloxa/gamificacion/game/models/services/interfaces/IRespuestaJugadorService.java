package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.RespuestaJugador;

public interface IRespuestaJugadorService {
	
	public List<RespuestaJugador> listAll();

	public void save(RespuestaJugador respuestaJugador);

	public RespuestaJugador get(Integer id);

	public void delete(Integer id);
	
	//Promedio por paralelos sobre 10
	public List<RespuestaJugador> getParalelosById(int idbancopreguntas);
	
	//Número de estudiantes por nota/10
	public List<RespuestaJugador> getEstudiantesById(int idbancopreguntas);

}
