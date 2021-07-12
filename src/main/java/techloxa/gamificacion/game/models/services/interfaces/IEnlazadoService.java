package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.Enlazado;


public interface IEnlazadoService {
	
	public List<Enlazado> listAll();

	public void save(Enlazado enlazado);

	public Enlazado get(Integer id);

	public void delete(Integer id);

}
