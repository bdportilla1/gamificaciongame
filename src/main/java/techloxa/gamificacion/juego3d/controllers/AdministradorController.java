package techloxa.gamificacion.juego3d.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import techloxa.gamificacion.juego3d.models.entities.Institucion;
import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.implementation.InstitucionServiceImpl;
import techloxa.gamificacion.juego3d.models.services.implementation.UsuarioServiceImpl;

@Secured("ROLE_ADMINISTRADOR")
@Controller
@RequestMapping("/administrador")
@SessionAttributes("usuario")
public class AdministradorController {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private InstitucionServiceImpl institucionService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("inicio_administrador")
	public String inicio_profesor() {
		String vista = "usuario/inicio_usuario";
		return vista;
	}

	@RequestMapping("editar_usuario")
	public String editarUsuario(Model model, RedirectAttributes flash) {

		Usuario usuario = (Usuario) model.getAttribute("usuario");
		int id = usuario.getIdusuario();
		if (id > 0) {
			usuario = usuarioService.get(id);
			if (usuario == null) {
				flash.addFlashAttribute("error",
						"El usuario de este Id que desea editar no existe en la Base de Datos!");
				return "redirect:/usuario/inicio_usuario";
			}
		} else {
			flash.addFlashAttribute("error", "El usuario que desea editar no puede tener el Id cero!");
			return "redirect:/usuario/inicio_usuario";
		}

		model.addAttribute("titulo", "Editar usuario");
		usuario.setRol("ADMINISTRADOR");
		model.addAttribute("usuario", usuario);
		model.addAttribute("instituciones", institucionService.listAll());

		return "usuario/editar_usuario";
	}

	// Guardar usuario luego de editar (Profesor)
	@RequestMapping(value = "guardar_usuario_editado", method = RequestMethod.POST)
	public String guardarUsuario(@RequestParam(value = "sms", required = false) String sms,
			@ModelAttribute("usuario") Usuario usuario, RedirectAttributes flash, Map<String, Object> model) {

		Usuario usuarioObj = (Usuario) model.get("usuario");
		// Se busca usuario por id
		Usuario userObj = usuarioService.findByIdusuario(usuario.getIdusuario());

		String pass = encoder.encode(usuario.getContrasenia());
		usuario.setContrasenia(pass);
		usuario.setRol("ROLE_ADMINISTRADOR");

		if (encoder.matches("123", usuario.getContrasenia()) == true) {
			// Se modifica campos únicamente establecidos
			Usuario mod = new Usuario(userObj.getIdusuario(), userObj.getUsuario(), userObj.getContrasenia(),
					userObj.getCedula(), usuario.getNombres(), usuario.getApellidos(), usuario.getCorreo(),
					usuario.getTelefono(), userObj.getRol(), userObj.getInstitucion(), userObj.getBancopreguntas());
			usuarioService.save(mod);
			// objeto para visualizar en la vista
			usuarioObj = mod;

		} else if (encoder.matches("123", usuario.getContrasenia()) != true) {

			usuarioService.save(usuario);
			// objeto para visualizar en la vista
			usuarioObj = usuario;
		}
		model.put("instituciones", institucionService.listAll());
		model.put("usuario", usuarioObj);
		System.out.println("Datos guardados correctamente!");

		usuarioObj.setRol("ADMINISTRADOR");
		model.put("sms", "Usuario modificado correctamente!");

		return "usuario/inicio_usuario";
	}

	// Guardar usuario luego de editar (Administrador)
	@RequestMapping(value = "guardar_usuarios", method = RequestMethod.POST)
	public String guardarUsuarioEditado(@RequestParam(value = "sms", required = false) String sms,
			@Validated @ModelAttribute("usObj") Usuario usObj, RedirectAttributes flash, Map<String, Object> model) {

		// Se busca Usuario por usuario
		Usuario userObj = usuarioService.findByUsuario(usObj.getUsuario());
		String pass = encoder.encode(usObj.getContrasenia());
		usObj.setContrasenia(pass);

		// Establecer rol de acuerdo a objeto original
		String rol = userObj.getRol();

		switch (rol) {
		case "ROLE_PROFESOR":
			usObj.setRol("ROLE_PROFESOR");
			break;

		default:
			usObj.setRol("ROLE_ADMINISTRADOR");
			break;
		}

		// Establecer id en objeto entrante (de acuerdo a objeto original)
		usObj.setIdUsuario(userObj.getIdusuario());

		if (encoder.matches("123", usObj.getContrasenia()) == true) {
			// Se modifica campos únicamente establecidos, sin topar contraseña
			usObj = new Usuario(userObj.getIdusuario(), userObj.getUsuario(), userObj.getContrasenia(),
					userObj.getCedula(), usObj.getNombres(), usObj.getApellidos(), usObj.getCorreo(),
					usObj.getTelefono(), userObj.getRol(), userObj.getInstitucion(), userObj.getBancopreguntas());
			usuarioService.save(usObj);

		} else if (encoder.matches("123", usObj.getContrasenia()) != true) {
			usuarioService.save(usObj);
		}

		flash.addFlashAttribute("sms", "Usuario modificado correctamente!");
		model.put("titulo", "Usuarios registrados");

		return "redirect:/administrador/listar_usuarios";
	}

	// Eliminar usuarios como administrador
	@RequestMapping("/eliminar_usuario/{id}")
	public String eliminarUser(@PathVariable(name = "id") int id, RedirectAttributes flash) {

		if (id > 0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("sms", "Usuario eliminado exitosamente!");
		}
		return "redirect:/administrador/listar_usuarios";
	}

	// INSTITUCIONES
	// Guardar institución
	@RequestMapping(value = "/guardar_institucion", method = RequestMethod.POST)
	public String guardarInstitucion(@RequestParam(value = "sms", required = false) String sms,
			@ModelAttribute("instObj") Institucion instObj, RedirectAttributes flash, Model model) {

		if (instObj.getIdinstitucion() != null) {
			flash.addFlashAttribute("sms", "Institución editada exitosamente!");
		} else {
			flash.addFlashAttribute("sms", "Institución creada exitosamente!");
		}
		institucionService.save(instObj);
		System.out.println("Datos guardados correctamente!");
		return "redirect:/administrador/listar_instituciones";
	}

	// Eliminar institución
	@RequestMapping("/eliminar_institucion/{id}")
	public String eliminarInstitucion(@PathVariable(name = "id") int id, RedirectAttributes flash) {

		if (id > 0) {
			institucionService.delete(id);
			flash.addFlashAttribute("sms", "Institución eliminada exitosamente!");
		}
		return "redirect:/administrador/listar_instituciones";
	}
}
