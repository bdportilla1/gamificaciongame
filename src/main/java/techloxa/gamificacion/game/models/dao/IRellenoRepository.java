package techloxa.gamificacion.game.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.game.models.entities.Relleno;

@Repository("rellenoRepository")
public interface IRellenoRepository extends JpaRepository<Relleno, Integer> {

}
