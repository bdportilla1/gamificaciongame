package techloxa.gamificacion.game.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import techloxa.gamificacion.game.models.entities.BancoPreguntas;
import techloxa.gamificacion.game.models.entities.Enlazado;
import techloxa.gamificacion.game.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.game.models.services.implementation.EnlazadoServiceImpl;

@Controller
@SessionAttributes("usuario")
public class EnlazadoController {
	
	@Autowired
	EnlazadoServiceImpl enlazado_service;

	@Autowired
	BancoPreguntasServiceImpl banco_service;
	
	@RequestMapping("/profesor/agregar_enlazado")
	public String enlazado(@ModelAttribute("enlazado") Enlazado enlazado, Model model) {

		return "profesor/banco_preguntas";
	}

	// Guardar banco de preguntas
	@RequestMapping(value = "/profesor/guardar_enlazado", method = RequestMethod.POST)
	public String guardarEnlazado(@ModelAttribute("enlazado") Enlazado enlazado,
			BindingResult bindingResult, Model model) {
		
		enlazado_service.save(enlazado);
		BancoPreguntas objbanco = banco_service.get(enlazado.getBancopreguntas().getIdbancopreguntas());

		// objeto para visualizar en la vista
		model.addAttribute("enlazado", enlazado);
		model.addAttribute("bancopreguntas", objbanco);
		return "profesor/agregar_preguntas";
	}

}
