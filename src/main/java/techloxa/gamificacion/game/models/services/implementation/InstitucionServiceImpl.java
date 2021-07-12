package techloxa.gamificacion.game.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.game.models.dao.IInstitucionRepository;
import techloxa.gamificacion.game.models.entities.Institucion;
import techloxa.gamificacion.game.models.services.interfaces.IInstitucionService;

@Service
public class InstitucionServiceImpl implements IInstitucionService{

	@Autowired
	private IInstitucionRepository repoInstitucion;

	@Override
	public List<Institucion> listAll() {

		return repoInstitucion.findAll();
	}

	@Override
	public void save(Institucion profesor) {
		repoInstitucion.save(profesor);
		
	}

	@Override
	public Institucion get(Integer id) {
		return repoInstitucion.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoInstitucion.deleteById(id);
		
	}

}
