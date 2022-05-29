package becapp;

/**
 * 
 * @ @author Eduardo y Arturo
 *
 */
public class Usuario {

	protected int id_usuario;

	private String dni;

	private String nombre;

	private String apellido;

	private String nacionalidad;

	private String email;

	private int telf;

	private String fecha_nac;

	private String clave;

	/**
	 * 
	 * 
	 * Constructor sin id_usuario para generarlo de menera auntomatica según la
	 * tabla usuarios Datos base para alumnos y administradores
	 * 
	 * @param dni          dni usuario
	 * @param clave        clave acesso alumnos o adminitradores
	 * @param nombre       nombre
	 * @param apellido     apellido
	 * @param nacionalidad nacionalidad
	 * @param email        email para acceso
	 * @param telf         telefono contacto
	 * @param fecha_nac    fecha nacimiento
	 */

	public Usuario(String dni, String clave, String nombre, String apellido, String nacionalidad, String email,
			int telf, String fecha_nac) {
		super();
		this.dni = dni;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.telf = telf;
		this.fecha_nac = fecha_nac;
	}

	public Usuario(int id_usuario, String dni, String clave, String nombre, String apellido, String nacionalidad,
			String email, int telf, String fecha_nac) {
		super();
		this.id_usuario = id_usuario;
		this.dni = dni;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.email = email;
		this.telf = telf;
		this.fecha_nac = fecha_nac;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDni() {
		return dni;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public String getEmail() {
		return email;
	}

	public int getTelf() {
		return telf;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", nacionalidad=" + nacionalidad + ", email=" + email + ", telf=" + telf + ", fecha_nac=" + fecha_nac
				+ "]";
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}