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

@Entity
@Table(name = "verdaderofalso")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idopcionvf", scope = VerdaderoFalso.class)
public class VerdaderoFalso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idopcionvf", unique = true, nullable = false)
	private Integer idopcionvf;
	
	@Column(name = "enunciado", nullable = false, length = 350)
	private String enunciado;

	@Column(name = "respuesta", nullable = false)
	private int respuesta;

	@Column(name = "retroalimentacion", nullable = false, length = 100)
	private String retroalimentacion;

	@Column(name = "nivelcomplejidad", nullable = false, length = 5)
	private String nivelcomplejidad;
	
	@Column(name = "tipo", nullable = false, length = 20)
	private String tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;

	public VerdaderoFalso() {
	}

	public VerdaderoFalso(Integer idopcionvf, String enunciado, int respuesta, String retroalimentacion, String nivelcomplejidad, String tipo,
			BancoPreguntas bancopreguntas) {
		super();
		this.idopcionvf = idopcionvf;
		this.enunciado = enunciado;
		this.respuesta = respuesta;
		this.retroalimentacion = retroalimentacion;
		this.nivelcomplejidad = nivelcomplejidad;
		this.tipo = tipo;
		this.bancopreguntas = bancopreguntas;
	}

	public Integer getIdopcionvf() {
		return idopcionvf;
	}

	public void setIdopcionvf(Integer idopcionvf) {
		this.idopcionvf = idopcionvf;
	}
	
	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public String getRetroalimentacion() {
		return retroalimentacion;
	}

	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}

	public String getNivelcomplejidad() {
		return nivelcomplejidad;
	}

	public void setNivelcomplejidad(String nivelcomplejidad) {
		this.nivelcomplejidad = nivelcomplejidad;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BancoPreguntas getBancopreguntas() {
		return bancopreguntas;
	}

	public void setBancopreguntas(BancoPreguntas bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}

}