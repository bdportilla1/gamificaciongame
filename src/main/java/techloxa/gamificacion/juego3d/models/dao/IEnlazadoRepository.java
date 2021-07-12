package techloxa.gamificacion.juego3d.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.juego3d.models.entities.Enlazado;

@Repository("enlazadoRepository")
public interface IEnlazadoRepository extends JpaRepository<Enlazado, Integer> {

}
