package techloxa.gamificacion.juego3d.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;
import techloxa.gamificacion.juego3d.models.entities.Enlazado;
import techloxa.gamificacion.juego3d.models.entities.OpcionMultiple;
import techloxa.gamificacion.juego3d.models.entities.Relleno;
import techloxa.gamificacion.juego3d.models.entities.VerdaderoFalso;
import techloxa.gamificacion.juego3d.models.services.implementation.BancoPreguntasServiceImpl;
import techloxa.gamificacion.juego3d.rest.services.entities.BancoPreguntaJSON;
import techloxa.gamificacion.juego3d.rest.services.entities.EnlazadoJSON;
import techloxa.gamificacion.juego3d.rest.services.entities.OpcionMultipleJSON;
import techloxa.gamificacion.juego3d.rest.services.entities.PreguntaJSON;
import techloxa.gamificacion.juego3d.rest.services.entities.RellenoJSON;
import techloxa.gamificacion.juego3d.rest.services.entities.VerdaderoFalsoJSON;

@Service
public class JuegoQueries {

	@Autowired
	private BancoPreguntasServiceImpl service_bancoPreguntas;

	// lista de preguntas por nivel
	List<PreguntaJSON> lsPreguntasBajo = new ArrayList<>();
	List<PreguntaJSON> lsPreguntasMedio = new ArrayList<>();
	List<PreguntaJSON> lsPreguntasAlto = new ArrayList<>();

	public HashMap<String, BancoPreguntaJSON> obtenerBancoPreguntas(String codigo) {

		BancoPreguntaJSON objJSONBancoPreguntas = new BancoPreguntaJSON();

		// OBTENIENDO OBJETOS DE LA BASE DE DATOS
		BancoPreguntas objBanco = service_bancoPreguntas.findByCodigo(codigo);
		HashMap<String, BancoPreguntaJSON> returnJSON = new HashMap<String, BancoPreguntaJSON>();

		// PARSEANDO PROPIEDADES DE LA BASE DE DATOS
		// PARSEANDO PROPIEDADES DE BD HACIA JSON DE RETORNO
		objJSONBancoPreguntas.setIdbancopreguntas(objBanco.getIdbancopreguntas());
		objJSONBancoPreguntas.setCodigo(objBanco.getCodigo());

		// PARSEANDO PARALELOS EN LISTA PARA JSON
		List<String> lsparalelos = new ArrayList<>();
		String[] paralelos = objBanco.getParalelos().split(";");
		for (String paralelo : paralelos) {
			lsparalelos.add(paralelo);
		}
		objJSONBancoPreguntas.setParalelos(lsparalelos);

		objJSONBancoPreguntas.setTema(objBanco.getTema());
		objJSONBancoPreguntas.setAsignatura(objBanco.getAsignatura());
		objJSONBancoPreguntas
				.setDocente(objBanco.getUsuario().getNombres() + " " + objBanco.getUsuario().getApellidos());

		// PARSEANDO LISTA DE PREGUNTAS
		List<HashMap<String, List<PreguntaJSON>>> lspreguntasFinal = new ArrayList<HashMap<String, List<PreguntaJSON>>>();

		HashMap<String, List<PreguntaJSON>> objHash = new HashMap<>();
		
		//Opción múltiple
		for (OpcionMultiple pregunta : objBanco.getOpcionmultiple()) {
			agregarPregunta(pregunta);
		}
		
		//Verdadero y falso
		for (VerdaderoFalso pregunta : objBanco.getVerdaderofalso()) {
			agregarPregunta(pregunta);
		}
		
		//Enlazado
		for (Enlazado pregunta : objBanco.getEnlazado()) {
			agregarPregunta(pregunta);
		}
		
		//Relleno
		for (Relleno pregunta : objBanco.getRelleno()) {
			agregarPregunta(pregunta);
		}

		objHash.put("nivelbajo", lsPreguntasBajo);
		objHash.put("nivelmedio", lsPreguntasMedio);
		objHash.put("nivelalto", lsPreguntasAlto);
		lspreguntasFinal.add(objHash);
		objJSONBancoPreguntas.setPreguntas(lspreguntasFinal);

		returnJSON.put("bancopreguntas_" + codigo, objJSONBancoPreguntas);

		return returnJSON;
	}

	public PreguntaJSON parsearPreguntaJSON(Object pregunta) {
		String om = OpcionMultiple.class.getSimpleName();
		String vf = VerdaderoFalso.class.getSimpleName();
		String en = Enlazado.class.getSimpleName();
		String re = Relleno.class.getSimpleName();
		String clase = pregunta.getClass().getSimpleName();

		// OPCION MULTIPLE
		if (clase.equals(om)) {

			OpcionMultiple objMultiple = (OpcionMultiple) pregunta;

			OpcionMultipleJSON obj = new OpcionMultipleJSON();

			obj.setTipo(objMultiple.getTipo());
			obj.setEnunciado(objMultiple.getEnunciado());
			obj.setRes1(objMultiple.getRes1());
			obj.setRes2(objMultiple.getRes2());
			obj.setRes3(objMultiple.getRes3());
			obj.setRes4(objMultiple.getRes4());
			obj.setResCorrecta(objMultiple.getRescorrecta());
			obj.setRetroalimentacion(objMultiple.getRetroalimentacion());
			obj.setComplejidad(objMultiple.getNivelcomplejidad());

			return obj;
		}
		// VERDADERO FALSE
		else if (clase.equals(vf)) {
			VerdaderoFalso objVF = (VerdaderoFalso) pregunta;
			VerdaderoFalsoJSON obj = new VerdaderoFalsoJSON();
			obj.setTipo(objVF.getTipo());
			obj.setEnunciado(objVF.getEnunciado());
			if (objVF.getRespuesta() == 1) {
				obj.setRespuesta(true);
			} else {
				obj.setRespuesta(false);
			}
			obj.setRetroalimentacion(objVF.getRetroalimentacion());
			obj.setComplejidad(objVF.getNivelcomplejidad());

			return obj;

		}
		// ENLAZADO
		else if (clase.equals(en)) {
			Enlazado objEnlazado = (Enlazado) pregunta;
			EnlazadoJSON obj = new EnlazadoJSON();

			obj.setTipo(objEnlazado.getTipo());
			obj.setEnunciado("Arrastrar hacia la respuesta correcta");

			// PARSEANDO PALABRAS A A PREGUNTAS JSON
			List<String> lspreguntas = new ArrayList<>();
			String[] palabrasaa = objEnlazado.getPalabrasa().split(";");
			for (String P : palabrasaa) {
				lspreguntas.add(P);
			}
			obj.setPreguntas(lspreguntas);
			// PARSEANDO PALABRAS B A PREGUNTAS JSON
			List<String> lsrespuestas = new ArrayList<>();
			String[] palabrasab = objEnlazado.getPalabrasb().split(";");
			for (String P : palabrasab) {
				lsrespuestas.add(P);
			}
			obj.setRespuestas(lsrespuestas);
			obj.setComplejidad(objEnlazado.getNivelcomplejidad());

			return obj;

		}
		// RELLENO
		else if (clase.equals(re)) {
			Relleno objRelleno = (Relleno) pregunta;
			RellenoJSON obj = new RellenoJSON();

			obj.setTipo(objRelleno.getTipo());
			obj.setEnunciado("Complete la frase");

			obj.setFrase(objRelleno.getFrase());

			// PARSENADO PALABRAS CORRECTAS
			List<String> lspalabras = new ArrayList<>();
			String[] splitpalabras = objRelleno.getPalabras().split(";");
			for (String p : splitpalabras) {
				lspalabras.add(p);
			}
			obj.setPalabras(lspalabras);

			// PARSENADO PALABRAS TRAMPA
			List<String> lspalabrasTrampa = new ArrayList<>();
			String[] splitpalabrasTrampa = objRelleno.getPalabrastrampa().split(";");
			for (String p : splitpalabrasTrampa) {
				lspalabrasTrampa.add(p);
			}
			obj.setPalabrastrampa(lspalabrasTrampa);

			// PARSENADO PALABRAS TRAMPA
			List<Integer> lsposiciones = new ArrayList<>();
			String[] splitposiciones = objRelleno.getPosiciones().split(";");
			for (String p : splitposiciones) {
				lsposiciones.add(Integer.parseInt(p));
			}
			obj.setPosiciones(lsposiciones);

			// PARSEANDO FRASE SPLIT
			String[] splitfrase = objRelleno.getFrase().split(" ");
			for (int pos : lsposiciones) {
				splitfrase[pos] = "_";
			}
			String frasesplit = "";
			for (String palabra : splitfrase) {
				frasesplit = frasesplit + palabra + " ";
			}
			obj.setFrasesplit(frasesplit);
			obj.setComplejidad(objRelleno.getNivelcomplejidad());

			return obj;

		}

		return null;
	}

	//Agregando preguntas a lista
	public void agregarPregunta(Object pregunta) {
		PreguntaJSON obj = parsearPreguntaJSON(pregunta);
		if (obj.getComplejidad().equals("Bajo")) {
			lsPreguntasBajo.add(obj);
		} else if (obj.getComplejidad().equals("Medio")) {
			lsPreguntasMedio.add(obj);
		} else if (obj.getComplejidad().equals("Alto")) {
			lsPreguntasAlto.add(obj);
		}
	}

}
