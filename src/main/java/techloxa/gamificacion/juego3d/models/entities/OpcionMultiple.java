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
@Table(name = "opcionmultiple")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idopcionmultiple", scope = OpcionMultiple.class)
public class OpcionMultiple implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idopcionmultiple", unique = true, nullable = false)
	private Integer idopcionmultiple;
	
	@Column(name = "enunciado", nullable = false, length = 350)
	private String enunciado;

	@Column(name = "res1", nullable = false, length = 100)
	private String res1;

	@Column(name = "res2", nullable = false, length = 100)
	private String res2;

	@Column(name = "res3", nullable = false, length = 100)
	private String res3;

	@Column(name = "res4", nullable = true, length = 100)
	private String res4;

	@Column(name = "rescorrecta", nullable = true, length = 100)
	private String rescorrecta;

	@Column(name = "retroalimentacion", nullable = false, length = 100)
	private String retroalimentacion;

	@Column(name = "nivelcomplejidad", nullable = false, length = 5)
	private String nivelcomplejidad;
	
	@Column(name = "tipo", nullable = false, length = 20)
	private String tipo;
	
	// LAZY = fetch when needed
	// EAGER = fetch immediately
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;

	public OpcionMultiple() {
	}

	public OpcionMultiple(Integer idopcionmultiple, String enunciado, String res1, String res2, String res3, String res4,
			String rescorrecta, String retroalimentacion, String nivelcomplejidad, String tipo, BancoPreguntas bancopreguntas) {
		super();
		this.idopcionmultiple = idopcionmultiple;
		this.enunciado = enunciado;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.res4 = res4;
		this.rescorrecta = rescorrecta;
		this.retroalimentacion = retroalimentacion;
		this.nivelcomplejidad=nivelcomplejidad;
		this.tipo = tipo;
		this.bancopreguntas = bancopreguntas;
	}

	public Integer getIdopcionmultiple() {
		return idopcionmultiple;
	}

	public void setIdopcionmultiple(Integer idopcionmultiple) {
		this.idopcionmultiple = idopcionmultiple;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public String getRes2() {
		return res2;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	public String getRes3() {
		return res3;
	}

	public void setRes3(String res3) {
		this.res3 = res3;
	}

	public String getRes4() {
		return res4;
	}

	public void setRes4(String res4) {
		this.res4 = res4;
	}

	public String getRescorrecta() {
		return rescorrecta;
	}

	public void setRescorrecta(String rescorrecta) {
		this.rescorrecta = rescorrecta;
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