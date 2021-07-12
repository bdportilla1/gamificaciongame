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

import techloxa.gamificacion.game.models.entities.Institucion;
import techloxa.gamificacion.game.models.services.implementation.InstitucionServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class InstitucionRest {
	
	@Autowired
	private InstitucionServiceImpl service;

	// Listar instituciones
	@RequestMapping("/listarInstituciones")
	public List<Institucion> getInstituciones() {
		List<Institucion> obj = service.listAll();

		return obj;
	}

	// Obtener institución por id
	@RequestMapping("/institucion/{id}")
	public ResponseEntity<Institucion> getById(@PathVariable(value = "id") Integer id) {
		Institucion obj = service.get(id);
		if (obj == null) {
			return new ResponseEntity<Institucion>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Institucion>(obj, HttpStatus.OK);
	}

	// Guardar y actualizar institución
	@PostMapping("/guardarInstitucion")
	public void guardarInstitucion(@RequestBody Institucion inst) {
		service.save(inst);
	}

	// Eliminar registro institución
	@GetMapping("/eliminarInstitucion/{id}")
	public void eliminarInst(@PathVariable Integer id) {
		Institucion obj = service.get(id);
		if (obj != null) {
			service.delete(id);
		}
	}
}
