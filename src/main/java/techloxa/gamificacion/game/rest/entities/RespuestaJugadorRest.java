package techloxa.gamificacion.game.rest.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import techloxa.gamificacion.game.models.entities.RespuestaJugador;
import techloxa.gamificacion.game.models.services.implementation.RespuestaJugadorServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class RespuestaJugadorRest {
	
	@Autowired
	private RespuestaJugadorServiceImpl service;
	
	// Listar preguntas de respuesta jugador
		@RequestMapping("/listarRespuestaJugador")
		public List<RespuestaJugador> getRellenos() {
			List<RespuestaJugador> objRespuestaJugador = service.listAll();
			return objRespuestaJugador;
		}
		
	// Obtener respuestajugador por id
	@RequestMapping("/respuestaJugador/{id}")
	public ResponseEntity<RespuestaJugador> getById(@PathVariable(value = "id") Integer id) {
		RespuestaJugador objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<RespuestaJugador>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RespuestaJugador>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar respuesta jugador
		@PostMapping("/guardarRespuestaJugador")
		public void guardarRespuestaJugador(@RequestBody RespuestaJugador respuestaJugador) {
			service.save(respuestaJugador);
		}

		// Eliminar registro respuesta jugador
		@GetMapping("/eliminarRespuestaJugador/{id}")
		public void eliminarRespuestaJugador(@PathVariable Integer id) {
			RespuestaJugador obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
