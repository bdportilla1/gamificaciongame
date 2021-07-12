package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.juego3d.models.entities.Institucion;


public interface IInstitucionService {
	
	public List<Institucion> listAll();

	public void save(Institucion institucion);

	public Institucion get(Integer id);

	public void delete(Integer id);
	

}
