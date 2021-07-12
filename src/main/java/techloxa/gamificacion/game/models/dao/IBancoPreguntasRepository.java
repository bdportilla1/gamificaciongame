package techloxa.gamificacion.game.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.game.models.entities.BancoPreguntas;
import techloxa.gamificacion.game.models.entities.Usuario;

@Repository("bancoPreguntasRepository")
public interface IBancoPreguntasRepository extends JpaRepository<BancoPreguntas, Integer> {
	
	
	public BancoPreguntas findByCodigo(String codigo);
	
	@Query(value="select idbancopreguntas, asignatura, codigo,grado,paralelos, periodo, tema, idusuario from bancopreguntas where idbancopreguntas = (select max(idbancopreguntas) from bancopreguntas WHERE idusuario=:idusuario)", nativeQuery = true)
	public BancoPreguntas lastBanco(int idusuario);

	
	public List<BancoPreguntas> findByUsuario(Usuario usuario);
}
