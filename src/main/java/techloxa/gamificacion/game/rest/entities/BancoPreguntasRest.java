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

import techloxa.gamificacion.game.models.entities.BancoPreguntas;
import techloxa.gamificacion.game.models.services.implementation.BancoPreguntasServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class BancoPreguntasRest {
	@Autowired
	private BancoPreguntasServiceImpl service;
	
	// Listar BancoPreguntas
		@RequestMapping("/listarBancoPreguntas")
		public List<BancoPreguntas> getRellenos() {
			List<BancoPreguntas> objBancoPreguntas = service.listAll();
			return objBancoPreguntas;
		}
		
	// Obtener objBancoPreguntas por id
	@RequestMapping("/bancoPreguntas/{id}")
	public ResponseEntity<BancoPreguntas> getById(@PathVariable(value = "id") Integer id) {
		BancoPreguntas objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<BancoPreguntas>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<BancoPreguntas>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar BancoPreguntas
		@PostMapping("/guardarBancoPreguntas")
		public void guardarBancoPreguntas(@RequestBody BancoPreguntas bancopreguntas) {
			service.save(bancopreguntas);
		}

		// Eliminar registro BancoPreguntas
		@GetMapping("/eliminarBancoPreguntas/{id}")
		public void eliminarBancoPreguntas(@PathVariable Integer id) {
			BancoPreguntas obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
