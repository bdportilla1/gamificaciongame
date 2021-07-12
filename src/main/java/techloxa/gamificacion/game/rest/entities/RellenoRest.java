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

import techloxa.gamificacion.game.models.entities.Relleno;
import techloxa.gamificacion.game.models.services.implementation.RellenoServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class RellenoRest {
	
	@Autowired
	private RellenoServiceImpl service;
	
	// Listar preguntas de relleno
		@RequestMapping("/listarRelleno")
		public List<Relleno> getRellenos() {
			List<Relleno> objRelleno = service.listAll();
			return objRelleno;
		}
		
	// Obtener profesor por id
	@RequestMapping("/relleno/{id}")
	public ResponseEntity<Relleno> getById(@PathVariable(value = "id") Integer id) {
		Relleno objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Relleno>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Relleno>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar relleno
		@PostMapping("/guardarRelleno")
		public void guardarRelleno(@RequestBody Relleno relleno) {
			service.save(relleno);
		}

		// Eliminar registro relleno
		@GetMapping("/eliminarRelleno/{id}")
		public void eliminarRelleno(@PathVariable Integer id) {
			Relleno obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}
}
