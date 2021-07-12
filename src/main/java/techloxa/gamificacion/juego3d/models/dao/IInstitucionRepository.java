package techloxa.gamificacion.juego3d.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.juego3d.models.entities.Institucion;

@Repository("institucionRepository")
public interface IInstitucionRepository extends JpaRepository<Institucion, Integer> {

}
