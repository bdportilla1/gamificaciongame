package techloxa.gamificacion.juego3d.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import techloxa.gamificacion.juego3d.models.entities.BancoPreguntas;

@Entity
@Table(name = "respuestajugador")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idrespuestajugador", scope = RespuestaJugador.class)
public class RespuestaJugador implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idrespuestajugador", unique = true, nullable = false)
	private Integer idrespuestajugador;

	@Column(name = "respuestas", nullable = false, length = 50)
	private String respuestas;

	@Column(name = "puntaje", nullable = false)
	private double puntaje;

	@Column(name = "nombrejugador", nullable = false, length = 100)
	private String nombrejugador;

	@Column(name = "paralelo", nullable = false, length = 3)
	private String paralelo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;

	public RespuestaJugador() {
	}

	public RespuestaJugador(String paralelo, double puntaje) {

		this.puntaje = puntaje;
		this.paralelo = paralelo;
	}

	public RespuestaJugador(Integer idrespuestajugador, String respuestas, double puntaje, String nombrejugador,
			String paralelo, BancoPreguntas bancopreguntas) {
		super();
		this.idrespuestajugador = idrespuestajugador;
		this.respuestas = respuestas;
		this.puntaje = puntaje;
		this.nombrejugador = nombrejugador;
		this.paralelo = paralelo;
		this.bancopreguntas = bancopreguntas;
	}

	public Integer getIdrespuestajugador() {
		return idrespuestajugador;
	}

	public void setIdrespuestajugador(Integer idrespuestajugador) {
		this.idrespuestajugador = idrespuestajugador;
	}

	public String getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public String getNombrejugador() {
		return nombrejugador;
	}

	public void setNombrejugador(String nombrejugador) {
		this.nombrejugador = nombrejugador;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public BancoPreguntas getBancopreguntas() {
		return bancopreguntas;
	}

	public void setBancopreguntas(BancoPreguntas bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}

	@Override
	public String toString() {
		return "hi ".concat(getIdrespuestajugador().toString()).concat(" ").concat(getNombrejugador()).concat(" ")
				.concat(getParalelo()).concat(" ").concat(getRespuestas()).concat(" ").concat(" ")
				.concat(String.valueOf(getPuntaje())).concat(" ")
				.concat(String.valueOf(getBancopreguntas().getCodigo()));
	}

}