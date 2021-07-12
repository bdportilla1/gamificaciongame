package techloxa.gamificacion.game.models.entities;

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
@Table(name = "enlazado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idenlazado", scope = Enlazado.class)
public class Enlazado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idenlazado", unique = true, nullable = false)
	private Integer idenlazado;
	
	@Column(name = "palabrasa", nullable = false, length = 300)
	private String palabrasa;
	
	@Column(name = "palabrasb", nullable = false, length = 300)
	private String palabrasb;
	
	@Column(name = "nivelcomplejidad", nullable = false, length = 5)
	private String nivelcomplejidad;
	
	@Column(name = "tipo", nullable = false, length = 20)
	private String tipo;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;
	
	public Enlazado() {
	}
	
	public Enlazado(Integer idenlazado, String palabrasa, String palabrasb, String nivelcomplejidad, String tipo, BancoPreguntas bancopreguntas) {
		super();
		this.idenlazado = idenlazado;
		this.palabrasa = palabrasa;
		this.palabrasb = palabrasb;
		this.nivelcomplejidad=nivelcomplejidad;
		this.bancopreguntas = bancopreguntas;
		this.tipo = tipo;
	}

	
	public Integer getIdenlazado() {
		return idenlazado;
	}

	public void setIdenlazado(Integer idenlazado) {
		this.idenlazado = idenlazado;
	}

	
	public String getPalabrasa() {
		return palabrasa;
	}

	public void setPalabrasa(String palabrasa) {
		this.palabrasa = palabrasa;
	}

	
	public String getPalabrasb() {
		return palabrasb;
	}

	public void setPalabrasb(String palabrasb) {
		this.palabrasb = palabrasb;
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