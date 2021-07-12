package techloxa.gamificacion.game.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.game.models.entities.OpcionMultiple;

@Repository("opcionMultipleRepository")
public interface IOpcionMultipleRepository extends JpaRepository<OpcionMultiple, Integer> {

}
