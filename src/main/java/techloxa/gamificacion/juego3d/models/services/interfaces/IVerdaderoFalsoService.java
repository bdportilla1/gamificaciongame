package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;


import techloxa.gamificacion.juego3d.models.entities.VerdaderoFalso;

public interface IVerdaderoFalsoService {
	
	
	public List<VerdaderoFalso> listAll();

	public void save(VerdaderoFalso verdaderoFalso);

	public VerdaderoFalso get(Integer id);

	public void delete(Integer id);

}
