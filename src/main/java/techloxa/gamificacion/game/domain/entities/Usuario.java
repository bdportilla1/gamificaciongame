package techloxa.gamificacion.game.domain.entities;

public class Usuario {
	
	private String usuario;
	private String contrasenia;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String telefono;
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String contrasenia, String cedula, String nombres, String apellidos, String correo,
			String telefono) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public String getCedula() {
		return cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}
