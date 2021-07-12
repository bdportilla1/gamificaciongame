package techloxa.gamificacion.juego3d.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.Relleno;
import techloxa.gamificacion.juego3d.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.juego3d.models.services.implementation.RellenoServiceImpl;


@Controller
@SessionAttributes("usuario")
public class RellenoController {
	
	@Autowired
	RellenoServiceImpl relleno_service;

	@Autowired
	BancoPreguntasServiceImpl banco_service;
	
	@RequestMapping("/profesor/agregar_relleno")
	public String verdaderofalso(@ModelAttribute("relleno") Relleno relleno, Model model) {

		return "profesor/banco_preguntas";
	}

	// Guardar bRELLENO
	@RequestMapping(value = "/profesor/guardar_relleno", method = RequestMethod.POST)
	public String guardarVerdaderfalso(@ModelAttribute("relleno") Relleno relleno,
			BindingResult bindingResult, Model model) {
		
		relleno_service.save(relleno);
		BancoPreguntas objbanco = banco_service.get(relleno.getBancopreguntas().getIdbancopreguntas());

		// objeto para visualizar en la vista
		model.addAttribute("relleno", relleno);
		model.addAttribute("bancopreguntas", objbanco);
		return "profesor/agregar_preguntas";
	}

}
