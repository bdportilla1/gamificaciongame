package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.Institucion;


public interface IInstitucionService {
	
	public List<Institucion> listAll();

	public void save(Institucion institucion);

	public Institucion get(Integer id);

	public void delete(Integer id);
	

}
