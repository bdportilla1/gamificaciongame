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
@Table(name = "relleno")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idrelleno", scope = Relleno.class)
public class Relleno implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idrelleno", unique = true, nullable = false)
	private Integer idrelleno;
	
	@Column(name = "frase", nullable = false, length = 350)
	private String frase;
	
	@Column(name = "palabras", nullable = false, length = 200)
	private String palabras;
	
	@Column(name = "posiciones", nullable = false, length = 100)
	private String posiciones;
	
	@Column(name = "palabrastrampa", nullable = false, length = 100)
	private String palabrastrampa;
	
	@Column(name = "nivelcomplejidad", nullable = false, length = 5)
	private String nivelcomplejidad;
	
	@Column(name = "tipo", nullable = false, length = 20)
	private String tipo;

	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;
	
	public Relleno() {
	}
	
	public Relleno(Integer idrelleno, String frase, String palabras, String posiciones, String palabrastrampa, String nivelcomplejidad, String tipo, BancoPreguntas bancopreguntas) {
		super();
		this.idrelleno = idrelleno;
		this.frase = frase;
		this.palabras = palabras;
		this.posiciones = posiciones;
		this.palabrastrampa = palabrastrampa;
		this.nivelcomplejidad=nivelcomplejidad;
		this.tipo = tipo;
		this.bancopreguntas = bancopreguntas;
	}

	
	public Integer getIdrelleno() {
		return idrelleno;
	}

	public void setIdrelleno(Integer idrelleno) {
		this.idrelleno = idrelleno;
	}

	
	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	
	public String getPalabras() {
		return palabras;
	}

	public void setPalabras(String palabras) {
		this.palabras = palabras;
	}
	
	public String getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(String posiciones) {
		this.posiciones = posiciones;
	}
	
	
	public String getPalabrastrampa() {
		return palabrastrampa;
	}

	public void setPalabrastrampa(String palabrastrampa) {
		this.palabrastrampa = palabrastrampa;
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