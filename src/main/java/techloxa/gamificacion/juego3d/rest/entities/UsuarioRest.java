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


import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.implementation.UsuarioServiceImpl;


@CrossOrigin("**")
@RestController
@RequestMapping(path = "/api")
public class UsuarioRest {

	@Autowired
	private UsuarioServiceImpl service;


	// Listar profesores
	@RequestMapping("/listarUsuarios")
	public List<Usuario> getUsuarios() {
		List<Usuario> objUsuario = service.listAll();

		return objUsuario;
	}

	// Obtener profesor por id
	@RequestMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable(value = "id") Integer id) {
		Usuario objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Usuario>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(objP, HttpStatus.OK);
	}

	// Guardar y actualizar profesor
	@PostMapping(path= "/guardarUsuario")
	public void guardarUsuario(@RequestBody Usuario usuario) {
		service.save(usuario);
	}

	// Eliminar registro profesor
	@GetMapping("/eliminarUsuario/{id}")
	public void eliminarUsuario(@PathVariable Integer id) {
		Usuario obj = service.get(id);
		if (obj != null) {
			service.delete(id);
		}
	}

}
