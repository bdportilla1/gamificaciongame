package techloxa.gamificacion.juego3d.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "bancopreguntas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idbancopreguntas", scope = BancoPreguntas.class)
public class BancoPreguntas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idbancopreguntas", unique = true, nullable = false)
	private Integer idbancopreguntas;

	@Column(name = "codigo", nullable = false, length = 10)
	private String codigo;

	@Column(name = "grado", nullable = false, length = 10)
	private String grado;

	@Column(name = "tema", nullable = false, length = 80)
	private String tema;

	@Column(name = "periodo", nullable = false, length = 15)
	private String periodo;

	@Column(name = "paralelos", nullable = false, length = 45)
	private String paralelos;
	
	@Column(name = "asignatura", nullable = false, length = 45)
	private String asignatura;
	
	// LAZY = fetch when needed
	// EAGER = fetch immediately
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<OpcionMultiple> opcionmultiple = new HashSet<OpcionMultiple>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<VerdaderoFalso> verdaderofalso = new HashSet<VerdaderoFalso>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<Relleno> relleno = new HashSet<Relleno>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<Enlazado> enlazado = new HashSet<Enlazado>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<RespuestaJugador> respuestajugador = new HashSet<RespuestaJugador>(0);
	
	public BancoPreguntas() {
	}

	public BancoPreguntas(Integer idbancopreguntas, String codigo, String grado, String tema, String periodo,
			String asignatura, String paralelos, Usuario usuario, Set<OpcionMultiple> opcionmultiple,
			Set<VerdaderoFalso> verdaderofalso, Set<Relleno> relleno, Set<Enlazado> enlazado,
			Set<RespuestaJugador> respuestajugador) {
		super();
		this.idbancopreguntas = idbancopreguntas;
		this.codigo = codigo;
		this.grado = grado;
		this.tema = tema;
		this.periodo = periodo;
		this.asignatura = asignatura;
		this.paralelos = paralelos;
		this.usuario = usuario;
		this.opcionmultiple = opcionmultiple;
		this.verdaderofalso = verdaderofalso;
		this.relleno = relleno;
		this.enlazado = enlazado;
		this.respuestajugador = respuestajugador;
	}

	public Integer getIdbancopreguntas() {
		return idbancopreguntas;
	}

	public void setIdbancopreguntas(Integer idbancopreguntas) {
		this.idbancopreguntas = idbancopreguntas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String idasignatura) {
		this.asignatura = idasignatura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getParalelos() {
		return paralelos;
	}

	public void setParalelos(String paralelos) {
		this.paralelos = paralelos;
	}

	public Set<OpcionMultiple> getOpcionmultiple() {
		return opcionmultiple;
	}

	public void setOpcionmultiple(Set<OpcionMultiple> opcionmultiple) {
		this.opcionmultiple = opcionmultiple;
	}

	public Set<VerdaderoFalso> getVerdaderofalso() {
		return verdaderofalso;
	}

	public void setVerdaderofalso(Set<VerdaderoFalso> verdaderofalso) {
		this.verdaderofalso = verdaderofalso;
	}

	public Set<Relleno> getRelleno() {
		return relleno;
	}

	public void setRelleno(Set<Relleno> relleno) {
		this.relleno = relleno;
	}

	public Set<Enlazado> getEnlazado() {
		return enlazado;
	}

	public void setEnlazado(Set<Enlazado> enlazado) {
		this.enlazado = enlazado;
	}

	public Set<RespuestaJugador> getRespuestajugador() {
		return respuestajugador;
	}

	public void setRespuestajugador(Set<RespuestaJugador> respuestajugador) {
		this.respuestajugador = respuestajugador;
	}
	
}