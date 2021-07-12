package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.Relleno;

public interface IRellenoService {
	
	
	public List<Relleno> listAll();

	public void save(Relleno relleno);

	public Relleno get(Integer id);

	public void delete(Integer id);

}
