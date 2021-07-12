package techloxa.gamificacion.juego3d.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.juego3d.models.entities.OpcionMultiple;
import techloxa.gamificacion.juego3d.models.dao.IOpcionMultipleRepository;
import techloxa.gamificacion.juego3d.models.services.interfaces.IOpcionMultipleService;

@Service
public class OpcionMultipleServiceImpl implements IOpcionMultipleService{
	
	@Autowired
	private IOpcionMultipleRepository repoOpcionMultiple;

	@Override
	public List<OpcionMultiple> listAll() {

		return repoOpcionMultiple.findAll();
	}

	@Override
	public void save(OpcionMultiple profesor) {
		repoOpcionMultiple.save(profesor);
		
	}

	@Override
	public OpcionMultiple get(Integer id) {
		return repoOpcionMultiple.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoOpcionMultiple.deleteById(id);
		
	}

}
