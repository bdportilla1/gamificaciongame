package techloxa.gamificacion.game.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="institucion")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idinstitucion", scope = Institucion.class)
public class Institucion implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idinstitucion", unique = true, nullable = false)
	private Integer idinstitucion;

	@Column(name = "nombre", nullable = false, length = 125)
	private String nombre;

	@Column(name = "tipo", nullable = false, length = 15)
	private String tipo;

	@Column(name = "nivel", nullable = false, length = 15)
	private String nivel;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "institucion")
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	
	public Institucion() {
	}

	public Institucion(Integer idinstitucion, String nombre, String tipo, String nivel, Set<Usuario> usuarios) {
		super();
		this.idinstitucion = idinstitucion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.nivel = nivel;
		this.usuarios = usuarios;
	}

	public Integer getIdinstitucion() {
		return idinstitucion;
	}

	public void setIdinstitucion(Integer idinstitucion) {
		this.idinstitucion = idinstitucion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}