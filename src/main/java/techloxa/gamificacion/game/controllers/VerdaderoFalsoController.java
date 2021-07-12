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
import techloxa.gamificacion.game.models.entities.VerdaderoFalso;
import techloxa.gamificacion.game.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.game.models.services.implementation.VerdaderoFalsoServiceImpl;

@Controller
@SessionAttributes("usuario")
public class VerdaderoFalsoController {
	
	@Autowired
	VerdaderoFalsoServiceImpl verdaderofalso_service;

	@Autowired
	BancoPreguntasServiceImpl banco_service;
	
	@RequestMapping("/profesor/agregar_verdaderofalso")
	public String verdaderofalso(@ModelAttribute("verdaderofalso") VerdaderoFalso verdaderofalso, Model model) {

		return "profesor/banco_preguntas";
	}

	// Guardar banco de preguntas
	@RequestMapping(value = "/profesor/guardar_verdaderofalso", method = RequestMethod.POST)
	public String guardarVerdaderfalso(@ModelAttribute("verdaderofalso") VerdaderoFalso verdaderofalso,
			BindingResult bindingResult, Model model) {
		
		verdaderofalso_service.save(verdaderofalso);
		BancoPreguntas objbanco = banco_service.get(verdaderofalso.getBancopreguntas().getIdbancopreguntas());

		// objeto para visualizar en la vista
		model.addAttribute("verdaderofalso", verdaderofalso);
		model.addAttribute("bancopreguntas", objbanco);
		return "profesor/agregar_preguntas";
	}

}

