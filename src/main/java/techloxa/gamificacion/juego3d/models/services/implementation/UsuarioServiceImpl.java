package techloxa.gamificacion.juego3d.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.juego3d.models.dao.IUsuarioRepository;
import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	@Autowired
	private IUsuarioRepository repoUsuario;

	@Override
	public List<Usuario> listAll() {

		return repoUsuario.findAll();
	}

	@Override
	public void save(Usuario profesor) {
		repoUsuario.save(profesor);
		
	}

	@Override
	public Usuario get(Integer id) {
		return repoUsuario.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repoUsuario.deleteById(id);
		
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		return repoUsuario.findByUsuario(usuario);
	}

	@Override
	public void updateUserWithoutPass(int id, String apellidos, String correo, String nombres, String telefono) {
		repoUsuario.updateUserWithoutPass(id, apellidos, correo, nombres, telefono);
		
	}

	@Override
	public Usuario findByIdusuario(Integer idusuario) {
		return repoUsuario.findByIdusuario(idusuario);
	}

}
