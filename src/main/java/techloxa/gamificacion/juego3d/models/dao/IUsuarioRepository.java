package techloxa.gamificacion.juego3d.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.juego3d.models.entities.Usuario;

@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUsuario(String usuario);
	
	public Usuario findByIdusuario(Integer idusuario);
	
	
	@Modifying
	@Transactional
	@Query(value="update usuario u set u.apellidos=:apellidos, u.correo=:correo, u.nombres=:nombres, u.telefono=:telefono where u.idusuario=:id", nativeQuery = true)
	public void updateUserWithoutPass(@Param(value = "id") int id, @Param(value = "apellidos") String apellidos,@Param(value = "correo") String correo,@Param(value = "nombres") String nombres,@Param(value = "telefono") String telefono);
	
}
