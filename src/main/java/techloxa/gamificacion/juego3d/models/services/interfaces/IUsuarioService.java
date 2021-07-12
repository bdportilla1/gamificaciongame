package techloxa.gamificacion.juego3d.models.services.interfaces;

import java.util.List;

import techloxa.gamificacion.juego3d.models.entities.Usuario;

public interface IUsuarioService {
	public List<Usuario> listAll();

	public void save(Usuario usuario);

	public Usuario get(Integer id);

	public void delete(Integer id);
	
	public Usuario findByUsuario(String usuario);
	
	public Usuario findByIdusuario(Integer idusuario);
	
	public void updateUserWithoutPass(int id, String apellidos, String correo, String nombres, String telefono);

}
