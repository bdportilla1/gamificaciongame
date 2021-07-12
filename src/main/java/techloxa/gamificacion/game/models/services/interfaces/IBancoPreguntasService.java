package techloxa.gamificacion.game.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.game.models.entities.BancoPreguntas;
import techloxa.gamificacion.game.models.entities.Usuario;


public interface IBancoPreguntasService {
	
	public List<BancoPreguntas> listAll();

	public void save(BancoPreguntas bancoPreguntas);

	public BancoPreguntas get(Integer id);

	public void delete(Integer id);
	
	public BancoPreguntas findByCodigo(String codigo);
	
	public BancoPreguntas lastBanco(int idusuario);

	public List<BancoPreguntas> findByUsuario(Usuario usuario);
}
