package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.juego3d.models.entities.Relleno;

public interface IRellenoService {
	
	
	public List<Relleno> listAll();

	public void save(Relleno relleno);

	public Relleno get(Integer id);

	public void delete(Integer id);

}
