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
import techloxa.gamificacion.game.models.entities.OpcionMultiple;
import techloxa.gamificacion.game.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.game.models.services.implementation.OpcionMultipleServiceImpl;

@Controller
@SessionAttributes("usuario")
public class OpcionMultipleController {

	@Autowired
	OpcionMultipleServiceImpl opcionmultiple_service;

	@Autowired
	BancoPreguntasServiceImpl banco_service;
	
	
	@RequestMapping("/profesor/agregar_opcionmultiple")
	public String banco_preguntas(@ModelAttribute("opcionmultiple") OpcionMultiple opcionmultiple, Model model) {

		return "profesor/banco_preguntas";
	}

	// Guardar banco de preguntas
	@RequestMapping(value = "/profesor/guardar_opcionmultiple", method = RequestMethod.POST)
	public String guardarOpcionMultiple(@ModelAttribute("opcionmultiple") OpcionMultiple opcionmultiple,
			BindingResult bindingResult, Model model) {
		
		opcionmultiple.setRescorrecta(opcionmultiple.getRes1());
		opcionmultiple_service.save(opcionmultiple);
		BancoPreguntas objbanco = banco_service.get(opcionmultiple.getBancopreguntas().getIdbancopreguntas());

		// objeto para visualizar en la vista
		model.addAttribute("opcionmultiple", opcionmultiple);
		model.addAttribute("bancopreguntas", objbanco);
		
		return "profesor/agregar_preguntas";
	}

}
