package techloxa.gamificacion.game.controllers;

import java.security.Principal;
import java.util.*;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import techloxa.gamificacion.game.models.entities.Institucion;
import techloxa.gamificacion.game.models.entities.Usuario;
import techloxa.gamificacion.game.models.services.implementation.InstitucionServiceImpl;
import techloxa.gamificacion.game.models.services.implementation.UsuarioServiceImpl;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private InstitucionServiceImpl institucionService;

	// Ingreso al sistema
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
			RedirectAttributes flash) {

		model.addAttribute("titulo", "Sistema de Gamificación 3D");

		if (principal != null) {
			flash.addFlashAttribute("info", "Ya inicio sesión anteriormente");
			return "redirect:/";
		}

		if (error != null) {
			model.addAttribute("error", "Usuario o contraseña incorrectos, inténtelo nuevamente!");
		}

		if (logout != null) {
			model.addAttribute("success", "La sesión se cerró correctamente!");
		}

		return "usuario/login";
	}

	// Crear usuario
	@RequestMapping("/crear_usuario")
	public String crearUsuario(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("titulo", "Registrar usuario");
		model.put("usuario", usuario);
		model.put("instituciones", institucionService.listAll());

		String vista = "usuario/crear_usuario";
		return vista;
	}

	// Guardar usuario
	@RequestMapping(value = "/guardar_usuario", method = RequestMethod.POST)
	public String guardarUsuario(@RequestParam(value = "sms", required = false) String sms,
			@ModelAttribute("usuario") Usuario usuario, RedirectAttributes flash, SessionStatus status, Model model) {

		String mensajeFlash = (usuario.getIdusuario() != null) ? "Usuario creado exitosamente!"
				: "Usuario Registrado Exitosamente!";

		String contrasenia = encoder.encode(usuario.getContrasenia());
		usuario.setContrasenia(contrasenia);

		usuario.setRol("ROLE_PROFESOR");

		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		System.out.println("Datos guardados correctamente!");

		// objeto para visualizar en la vista
		model.addAttribute("usuario", usuario);
		model.addAttribute("sms", "Usuario creado correctamente, inicie sesión!");
		String vista = "usuario/login";
		return vista;
	}

	@Secured("ROLE_ADMINISTRADOR")
	@RequestMapping("/administrador/listar_usuarios")
	public String listarUsuarios(Map<String, Object> model) {
		//Objeto para modificar usuario
		Usuario usObj = new Usuario();
		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		List<Usuario> listUs = usuarioService.listAll();

		for (Usuario usuario : listUs) {
			String rol = usuario.getRol();
			switch (rol) {
			case "ROLE_PROFESOR":
				usuario.setRol("PROFESOR");
				break;

			default:
				usuario.setRol("ADMINISTRADOR");
				break;
			}

			listUsuarios.add(usuario);
		}
		model.put("titulo", "Usuarios registrados");
		model.put("listUsuarios", listUsuarios);
		model.put("usObj", usObj);
		return "administrador/listar_usuarios";
	}
	
	@Secured("ROLE_ADMINISTRADOR")
	@RequestMapping("/administrador/listar_instituciones")
	public String listarInstituciones(Map<String, Object> model) {
		//Objeto para modificar usuario
		Institucion instObj = new Institucion();
		
		List<Institucion> listInstituciones = institucionService.listAll();
		List<String> tipo = Arrays.asList("Privada", "Pública");
		List<String> nivel = Arrays.asList("Primaria", "Secundaria");

		model.put("titulo", "Instituciones registradas");
		
		model.put("listInstituciones", listInstituciones);
		model.put("tipo", tipo);
		model.put("nivel", nivel);
		model.put("instObj", instObj);
		return "administrador/listar_instituciones";
	}

}
