package techloxa.gamificacion.juego3d.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.juego3d.models.entities.VerdaderoFalso;
import techloxa.gamificacion.juego3d.models.dao.IVerdaderoFalsoRepository;
import techloxa.gamificacion.juego3d.models.services.interfaces.IVerdaderoFalsoService;

@Service
public class VerdaderoFalsoServiceImpl implements IVerdaderoFalsoService{

	@Autowired
	private IVerdaderoFalsoRepository repoVerdaderoFalso;

	@Override
	public List<VerdaderoFalso> listAll() {

		return repoVerdaderoFalso.findAll();
	}

	@Override
	public void save(VerdaderoFalso profesor) {
		repoVerdaderoFalso.save(profesor);
		
	}

	@Override
	public VerdaderoFalso get(Integer id) {
		return repoVerdaderoFalso.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoVerdaderoFalso.deleteById(id);
		
	}
}
