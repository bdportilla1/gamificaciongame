package techloxa.gamificacion.juego3d.rest;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import techloxa.gamificacion.juego3d.rest.services.JuegoQueries;
import techloxa.gamificacion.juego3d.rest.services.entities.BancoPreguntaJSON;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/juego")
public class JuegoRest {

	@Autowired
	JuegoQueries queriesJuego;

	@RequestMapping("/bancopreguntas/{codigo}")
	public HashMap<String, BancoPreguntaJSON> obtenerBancoPreguntas(@PathVariable(value = "codigo") String codigo) {
		return queriesJuego.obtenerBancoPreguntas(codigo);
	}

}
