package techloxa.gamificacion.juego3d.rest.entities;

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

import techloxa.gamificacion.juego3d.models.entities.OpcionMultiple;
import techloxa.gamificacion.juego3d.models.services.implementation.OpcionMultipleServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class OpcionMultipleRest {
	
	@Autowired
	private OpcionMultipleServiceImpl service;

	// Listar preguntas de opción multiple
	@RequestMapping("/listarOpcionMultiple")
	public List<OpcionMultiple> getOpcionMultiple() {
		List<OpcionMultiple> obj = service.listAll();

		return obj;
	}

	// Obtener pregunta de opción múltiple por id
	@RequestMapping("/opcionMultiple/{id}")
	public ResponseEntity<OpcionMultiple> getById(@PathVariable(value = "id") Integer id) {
		OpcionMultiple obj = service.get(id);
		if (obj == null) {
			return new ResponseEntity<OpcionMultiple>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<OpcionMultiple>(obj, HttpStatus.OK);
	}

	// Guardar y actualizar pregunta de opción múltiple
	@PostMapping("/guardarOpcionMultiple")
	public void guardarOpcionMultiple(@RequestBody OpcionMultiple inst) {
		service.save(inst);
	}

	// Eliminar registro de opción múltiple
	@GetMapping("/eliminarOpcionMultiple/{id}")
	public void eliminarOpcionMultiple(@PathVariable Integer id) {
		OpcionMultiple obj = service.get(id);
		if (obj != null) {
			service.delete(id);
		}
	}

}
