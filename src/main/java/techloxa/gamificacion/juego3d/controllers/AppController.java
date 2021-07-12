package techloxa.gamificacion.juego3d.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("usuario")
public class AppController {

	@RequestMapping("/")
	public String inicioSistema(Model model) {
		//model.addAttribute("titulo", "Gamificación juego 3D");
		
		return "principal/principal";
	}
	@RequestMapping("/principal")
	public String principal(Model model) {
		//model.addAttribute("titulo", "Gamificación juego 3D");
		return "profesor/inicio_profesor";
	}
	
	
	@RequestMapping("administrador")
	public String admin() {
		return "administrador";
	}

	@RequestMapping("PROFESOR")
	public String user() {
		return "PROFESOR";
	}

}
