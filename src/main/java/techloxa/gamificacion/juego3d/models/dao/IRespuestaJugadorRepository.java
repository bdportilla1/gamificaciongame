package techloxa.gamificacion.juego3d.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import techloxa.gamificacion.juego3d.models.entities.RespuestaJugador;

@Repository("respuestaJugadorRepository")
public interface IRespuestaJugadorRepository extends JpaRepository<RespuestaJugador, Integer>{

	//Promedio por paralelos sobre 10 (número aleatorios de id de estudiantes)
	@Query(value="SELECT FLOOR(RAND() * 30) as idrespuestajugador, 'nombre' as nombrejugador, paralelo,  AVG(puntaje) AS puntaje, 'respuestas' as respuestas , :idbancopreguntas as idbancopreguntas FROM respuestajugador WHERE idbancopreguntas=:idbancopreguntas GROUP BY paralelo", nativeQuery = true)
	public List<RespuestaJugador> getParalelosById(int idbancopreguntas);
	
	//Número de estudiantes por nota/10
	@Query(value="SELECT FLOOR(RAND() * 30) as idrespuestajugador, 'nombre' as nombrejugador, 'paralelo' as paralelo, puntaje, COUNT(puntaje) as respuestas , :idbancopreguntas as idbancopreguntas FROM respuestajugador WHERE idbancopreguntas=:idbancopreguntas GROUP BY puntaje", nativeQuery = true)
	public List<RespuestaJugador> getEstudiantesById(int idbancopreguntas);
}
