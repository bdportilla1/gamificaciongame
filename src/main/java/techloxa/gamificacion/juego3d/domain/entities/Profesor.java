package techloxa.gamificacion.juego3d.domain.entities;

public class Profesor extends Usuario {
	
	private Institucion objInstitucion;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String usuario, String contrasenia, String cedula, String nombres, String apellidos, String correo,
			String telefono) {
		super(usuario, contrasenia, cedula, nombres, apellidos, correo, telefono);
		// TODO Auto-generated constructor stub
	}
	

	public Profesor(Institucion objInstitucion) {
		super();
		this.objInstitucion = objInstitucion;
	}

	public Institucion getObjInstitucion() {
		return objInstitucion;
	}

	public void setObjInstitucion(Institucion objInstitucion) {
		this.objInstitucion = objInstitucion;
	}
	

	
	
}
