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
import techloxa.gamificacion.juego3d.models.entities.Enlazado;
import techloxa.gamificacion.juego3d.models.services.implementation.EnlazadoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class EnlazadoRest {
	
	@Autowired
	private EnlazadoServiceImpl service;
	
	// Listar preguntas de enlazado
		@RequestMapping("/listarEnlazado")
		public List<Enlazado> getRellenos() {
			List<Enlazado> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener enlazado por id
	@RequestMapping("/enlazado/{id}")
	public ResponseEntity<Enlazado> getById(@PathVariable(value = "id") Integer id) {
		Enlazado objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Enlazado>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Enlazado>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar enlazado
		@PostMapping("/guardarEnlazado")
		public void guardarRelleno(@RequestBody Enlazado enlazado) {
			service.save(enlazado);
		}

		// Eliminar registro enlazado
		@GetMapping("/eliminarEnlazado/{id}")
		public void eliminarRelleno(@PathVariable Integer id) {
			Enlazado obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}


}
