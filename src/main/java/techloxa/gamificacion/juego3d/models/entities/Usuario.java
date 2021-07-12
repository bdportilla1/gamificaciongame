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
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idusuario", scope = Usuario.class)
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idusuario", unique = true, nullable = false)
	private Integer idusuario;

	@Column(name = "usuario", nullable = false, length = 15)
	private String usuario;

	@Column(name = "contrasenia", nullable = false, length = 100)
	private String contrasenia;

	@Column(name = "cedula", nullable = false, length = 10)
	private String cedula;

	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;

	@Column(name = "correo", nullable = false, length = 40)
	private String correo;

	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;

	@Column(name = "rol", nullable = false, length = 20)
	private String rol;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idinstitucion", referencedColumnName = "idinstitucion")
	private Institucion institucion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<BancoPreguntas> bancopreguntas = new HashSet<BancoPreguntas>(0);

	public Usuario() {
	}

	public Usuario(Integer idusuario, String usuario, String contrasenia, String cedula, String nombres,
			String apellidos, String correo, String telefono, String rol, Institucion institucion,
			Set<BancoPreguntas> bancopreguntas) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.rol = rol;
		this.institucion = institucion;
		this.bancopreguntas = bancopreguntas;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdUsuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Set<BancoPreguntas> getBancopreguntas() {
		return bancopreguntas;
	}

	public void setBancopreguntas(Set<BancoPreguntas> bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}

	@Override
	public String toString() {
		return "Usuario desde vista: "+idusuario+" "+ nombres+" "+apellidos+ " "+ cedula+" "+usuario+" "+contrasenia+" "+telefono+" "+correo+" "+institucion.getNombre()+" "+rol;
	}

}
