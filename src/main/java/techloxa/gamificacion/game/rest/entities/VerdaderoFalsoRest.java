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

import techloxa.gamificacion.game.models.entities.VerdaderoFalso;
import techloxa.gamificacion.game.models.services.implementation.VerdaderoFalsoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class VerdaderoFalsoRest {

	@Autowired
	private VerdaderoFalsoServiceImpl service;

	// Listar preguntas de verdadero y falso
	@RequestMapping("/listarVerdaderoFalso")
	public List<VerdaderoFalso> getOpcionMultiple() {
		List<VerdaderoFalso> obj = service.listAll();

		return obj;
	}

	// Obtener pregunta de verdadero y falso por id
	@RequestMapping("/verdaderoFalso/{id}")
	public ResponseEntity<VerdaderoFalso> getById(@PathVariable(value = "id") Integer id) {
		VerdaderoFalso obj = service.get(id);
		if (obj == null) {
			return new ResponseEntity<VerdaderoFalso>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<VerdaderoFalso>(obj, HttpStatus.OK);
	}

	// Guardar y actualizar pregunta de verdadero y falso
	@PostMapping("/guardarVerdaderoFalso")
	public void guardarVerdaderoFalso(@RequestBody VerdaderoFalso inst) {
		service.save(inst);
	}

	// Eliminar registro de verdadero y falso
	@GetMapping("/eliminarVerdaderoFalso/{id}")
	public void eliminarVerdaderoFalso(@PathVariable Integer id) {
		VerdaderoFalso obj = service.get(id);
		if (obj != null) {
			service.delete(id);
		}
	}
}
