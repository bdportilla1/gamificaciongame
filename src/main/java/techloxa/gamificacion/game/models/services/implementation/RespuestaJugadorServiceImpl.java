package techloxa.gamificacion.game.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.game.models.dao.IRespuestaJugadorRepository;
import techloxa.gamificacion.game.models.entities.RespuestaJugador;
import techloxa.gamificacion.game.models.services.interfaces.IRespuestaJugadorService;

@Service
public class RespuestaJugadorServiceImpl implements IRespuestaJugadorService{

	@Autowired
	private IRespuestaJugadorRepository repoRespuestaJugador;

	@Override
	public List<RespuestaJugador> listAll() {

		return repoRespuestaJugador.findAll();
	}

	@Override
	public void save(RespuestaJugador profesor) {
		repoRespuestaJugador.save(profesor);
		
	}

	@Override
	public RespuestaJugador get(Integer id) {
		return repoRespuestaJugador.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoRespuestaJugador.deleteById(id);
		
	}

	@Override
	public List<RespuestaJugador> getParalelosById(int idbancopreguntas) {
		return repoRespuestaJugador.getParalelosById(idbancopreguntas);
	}

	@Override
	public List<RespuestaJugador> getEstudiantesById(int idbancopreguntas) {
		return repoRespuestaJugador.getEstudiantesById(idbancopreguntas);
	}
	
	
}
