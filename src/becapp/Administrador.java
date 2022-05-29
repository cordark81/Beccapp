package becapp;

/**
 * 
 * @author Eduardo y Arturo
 *
 */

public class Administrador extends Usuario {

	private String estado;

	private String descripcion_puesto;

	private String fecha_inc;

	/**
	 * 
	 * 
	 * Constructor sin id_usuario para generarlo de menera auntomatica según la
	 * tabla usuarios Datos del nuevo administrador
	 * 
	 * @param dni                dni
	 * @param nombre             nombre
	 * @param apellido           apellidos
	 * @param nacionalidad       nacionalidad
	 * @param email              email para el acceso
	 * @param telf               telefono
	 * @param fecha_nac          fecha naciemiento
	 * @param clave              clave de acceso
	 * @param estado             indica si esta en activo no el administrador
	 * @param descripcion_puesto comentario del puesto
	 */

	public Administrador(String dni, String clave, String nombre, String apellido, String nacionalidad, String email,
			int telf, String fecha_nac, String estado, String descripcion_puesto) {
		super(dni, clave, nombre, apellido, nacionalidad, email, telf, fecha_nac);

		this.estado = estado;
		this.descripcion_puesto = descripcion_puesto;
	}

	public Administrador(int id_usuario, String dni, String clave, String nombre, String apellido, String nacionalidad,
			String email, int telf, String fecha_nac, String estado, String descripcion_puesto, String fecha_inc) {
		super(id_usuario, dni, clave, nombre, apellido, nacionalidad, email, telf, fecha_nac);

		this.estado = estado;
		this.descripcion_puesto = descripcion_puesto;
		this.fecha_inc = fecha_inc;
	}

	public String getEstado() {
		return estado;
	}

	public String getDescripcion_puesto() {
		return descripcion_puesto;
	}

	public String getFecha_inc() {
		return fecha_inc;
	}

	@Override
	public String toString() {
		return "Administrador [ID: " + super.getId_usuario() + " Nombre " + super.getNombre() + " "
				+ super.getApellido() + " DNI: " + super.getDni() + "]";
	}

}
