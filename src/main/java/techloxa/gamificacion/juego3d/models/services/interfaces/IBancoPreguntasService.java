package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.Usuario;


public interface IBancoPreguntasService {
	
	public List<BancoPreguntas> listAll();

	public void save(BancoPreguntas bancoPreguntas);

	public BancoPreguntas get(Integer id);

	public void delete(Integer id);
	
	public BancoPreguntas findByCodigo(String codigo);
	
	public BancoPreguntas lastBanco(int idusuario);

	public List<BancoPreguntas> findByUsuario(Usuario usuario);
}
