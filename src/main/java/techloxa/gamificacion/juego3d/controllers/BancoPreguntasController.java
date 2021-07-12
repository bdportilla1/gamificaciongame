package techloxa.gamificacion.juego3d.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.bytebuddy.utility.RandomString;
import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.juego3d.models.services.implementation.UsuarioServiceImpl;

@Secured("ROLE_PROFESOR")
@Controller
@RequestMapping("/profesor")
@SessionAttributes("usuario")
public class BancoPreguntasController {

	@Autowired
	BancoPreguntasServiceImpl bancopreguntas_service;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@RequestMapping(value ="agregar_bancopreguntas")
	public String banco_preguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas, Model model) {

		return "profesor/banco_preguntas";
	}
	
	@RequestMapping("visualizar")
	public String visualizar_bancopreguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas,
			@ModelAttribute("usuario") Usuario usuario, Map<String, Object> model) {
		Usuario usuarioObj = (Usuario) model.get("usuario");
		Usuario obj = usuarioService.findByUsuario(usuarioObj.getUsuario());
		List<BancoPreguntas> lsbancopreguntas = bancopreguntas_service.findByUsuario(obj);
		model.put("usuario", usuarioObj);
		model.put("lsbancopreguntas", lsbancopreguntas);
		model.put("bancopreguntas", bancopreguntas);

		
		return "profesor/visualizar_bancopreguntas";
	}
	
	@RequestMapping("agregar_preguntas")
	public String agregarPreguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas, Model model) {

		return "profesor/agregar_preguntas";
	}
	
	@RequestMapping(value = "editar_bancopreguntas"  )
	public String editar_bancopreguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas,
			@ModelAttribute("usuario") Usuario usuario,
			Map<String, Object> model) {
		
		Usuario usuarioObj = (Usuario) model.get("usuario");
		Usuario objUsuario = usuarioService.findByUsuario(usuarioObj.getUsuario());
	
		if(bancopreguntas.getIdbancopreguntas()!=null) {
			bancopreguntas = bancopreguntas_service.get(bancopreguntas.getIdbancopreguntas());
		}else {
			bancopreguntas = bancopreguntas_service.lastBanco(objUsuario.getIdusuario());
		}
		
		// objeto para visualizar en la vista
		model.put("bancopreguntas", bancopreguntas);
		return "profesor/agregar_preguntas";
	}

	// Guardar banco de preguntas
	@RequestMapping(value = "guardar_bancoPreguntas", method = RequestMethod.POST)
	public String guardarBancoPreguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas,
			BindingResult bindingResult, Model model) {
		
		if(bancopreguntas.getIdbancopreguntas()!=null) {
			bancopreguntas_service.save(bancopreguntas);
		}else {
			// CREANDO UN CODIGO ALEATORIO PARA CADA BANCO DE PREGUNTAS
			String codigo_aleatorio = "";
			BancoPreguntas objCodigo = null;
			do {
				codigo_aleatorio = RandomString.make(5).toUpperCase();
				objCodigo = bancopreguntas_service.findByCodigo(codigo_aleatorio);
			} while (objCodigo != null);
			// AQUI ACABA LA COMPARACION DE CODIGO ALEATORIO
			bancopreguntas.setCodigo(codigo_aleatorio);
			bancopreguntas_service.save(bancopreguntas);

			// objeto para visualizar en la vista
			model.addAttribute("bancopreguntas", bancopreguntas);
		}
		return "redirect:/profesor/editar_bancopreguntas";
	}
	
	@RequestMapping(value = "eliminar_bancopreguntas", method = RequestMethod.POST)
	public String eliminar_bancopreguntas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas, Model model) {
		bancopreguntas_service.delete(bancopreguntas.getIdbancopreguntas());
		return "redirect:/profesor/visualizar";
	}

}
