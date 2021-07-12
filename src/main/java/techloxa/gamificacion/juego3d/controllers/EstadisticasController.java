package techloxa.gamificacion.juego3d.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.RespuestaJugador;
import techloxa.gamificacion.juego3d.models.entities.Usuario;
import techloxa.gamificacion.juego3d.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.juego3d.models.services.implementation.RespuestaJugadorServiceImpl;
import techloxa.gamificacion.juego3d.models.services.implementation.UsuarioServiceImpl;

@Secured("ROLE_PROFESOR")
@Controller
@RequestMapping("/profesor")
@SessionAttributes("usuario")
public class EstadisticasController {

	@Autowired
	BancoPreguntasServiceImpl bancopreguntas_service;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Autowired
	private RespuestaJugadorServiceImpl resJugadorService;

	@RequestMapping("estadisticas")
	public String bancopreguntas_estadisticas(@ModelAttribute("bancopreguntas") BancoPreguntas bancopreguntas,Map<String, Object> model) {
		Usuario usuarioObj = (Usuario) model.get("usuario");
		Usuario obj = usuarioService.findByUsuario(usuarioObj.getUsuario());
		List<BancoPreguntas> lsbancopreguntas = bancopreguntas_service.findByUsuario(obj);
		model.put("usuario", usuarioObj);
		model.put("lsbancopreguntas", lsbancopreguntas);

		return "estadisticas/estadisticas";
	}

	@RequestMapping(value = "observar_estadisticas")
	public String observar_estadisticas(@ModelAttribute("idbancopreguntas") int idbancopreguntas,
			@ModelAttribute("usuario") Usuario usuario, Map<String, Object> model) {
		
		/*-------------	Promedio por paralelos sobre 10 -------------*/	
		// String de paralelos
		String paralelos="";
		//String de puntaje
		String puntaje="";

		List<RespuestaJugador> resJugador = resJugadorService.getParalelosById(idbancopreguntas);
		
		for (int i = 0; i < resJugador.size(); i++) {
			if (i==resJugador.size()-1) {
				paralelos+=resJugador.get(i).getParalelo();
				puntaje+=resJugador.get(i).getPuntaje();
			}else {
				paralelos+=resJugador.get(i).getParalelo()+";";
				puntaje+=resJugador.get(i).getPuntaje()+";";
			}
		}
		
		/*-------------	Número de estudiantes por nota/10 -------------*/
		// String del número de estudiantes
				String numEstudiantes="";
				//String del promedio
				String promedio="";

				List<RespuestaJugador> estByProm = resJugadorService.getEstudiantesById(idbancopreguntas);
				
				for (int i = 0; i < estByProm.size(); i++) {
					if (i==estByProm.size()-1) {
						numEstudiantes+=estByProm.get(i).getRespuestas();
						promedio+=estByProm.get(i).getPuntaje();
					}else {
						numEstudiantes+=estByProm.get(i).getRespuestas()+";";
						promedio+=estByProm.get(i).getPuntaje()+";";
					}
				}
		

		// objeto para visualizar en la vista
		/*-------------	Promedio por paralelos sobre 10 -------------*/					
		model.put("paralelos", paralelos);
		model.put("puntaje", puntaje);
		/*-------------	Número de estudiantes por nota/10 -------------*/
		model.put("numEstudiantes", numEstudiantes);
		model.put("promedio", promedio);
		
		model.put("idbancopreguntas", idbancopreguntas);
		return "estadisticas/observar_estadisticas";
	}
	
	
	public void llenarListas(List<RespuestaJugador> lista, String cadena1, String cadena2, String condicion) {
		for (int i = 0; i < lista.size(); i++) {
			if (i==lista.size()-1) {
				if (condicion=="metodo1") {
					cadena1+=lista.get(i).getRespuestas();
				}else {
					cadena1+=lista.get(i).getParalelo();
				}
				cadena2+=lista.get(i).getPuntaje();
			}else {
				if (condicion=="metodo1") {
					cadena1+=lista.get(i).getRespuestas()+";";
				}else {
					cadena1+=lista.get(i).getParalelo()+";";
				}
				cadena2+=lista.get(i).getPuntaje()+";";
			}
		}
	}
}
