package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.OpcionMultiple;


public interface IOpcionMultipleService {
	
	public List<OpcionMultiple> listAll();

	public void save(OpcionMultiple opcionMultiple);

	public OpcionMultiple get(Integer id);

	public void delete(Integer id);

}
