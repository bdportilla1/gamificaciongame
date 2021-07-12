package techloxa.gamificacion.juego3d.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.juego3d.models.dao.IBancoPreguntasRepository;
import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.interfaces.IBancoPreguntasService;

@Service
public class BancoPreguntasServiceImpl implements IBancoPreguntasService{

	@Autowired
	private IBancoPreguntasRepository repoBancoPreguntas;

	@Override
	public List<BancoPreguntas> listAll() {

		return repoBancoPreguntas.findAll();
	}

	@Override
	public void save(BancoPreguntas profesor) {
		repoBancoPreguntas.save(profesor);
		
	}

	@Override
	public BancoPreguntas get(Integer id) {
		return repoBancoPreguntas.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoBancoPreguntas.deleteById(id);
		
	}
	
	@Override
	public BancoPreguntas findByCodigo(String codigo) {
		return repoBancoPreguntas.findByCodigo(codigo);
	}

	@Override
	public BancoPreguntas lastBanco(int idusuario) {
		return repoBancoPreguntas.lastBanco(idusuario);
	}
	
	@Override
	public List<BancoPreguntas> findByUsuario(Usuario usuario){
		return repoBancoPreguntas.findByUsuario(usuario);
	}
	
	
}
