package techloxa.gamificacion.game.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.game.models.entities.Enlazado;

@Repository("enlazadoRepository")
public interface IEnlazadoRepository extends JpaRepository<Enlazado, Integer> {

}
