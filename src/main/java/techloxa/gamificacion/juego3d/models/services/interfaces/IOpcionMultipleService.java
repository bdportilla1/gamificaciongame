package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.juego3d.models.entities.OpcionMultiple;


public interface IOpcionMultipleService {
	
	public List<OpcionMultiple> listAll();

	public void save(OpcionMultiple opcionMultiple);

	public OpcionMultiple get(Integer id);

	public void delete(Integer id);

}
