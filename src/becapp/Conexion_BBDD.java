package becapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Conexion_BBDD {

	// datos pendientes de cambiar a la base de datos valida

	private String bd = "XE";
	private String login = "ADMINISTRADOR";
	private String password = "ADMINISTRADOR";
	private String url = "jdbc:oracle:thin:@localhost:1521:" + bd;
	java.sql.Statement st = null;
	java.sql.ResultSet rs = null;

	Connection connection = null;

	// CONECTAR CON LA BASE DE DATOS
	public void conectar() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexion realizada correctamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// CIERRA CONEXION
	public void cerrar() throws SQLException {

		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (connection != null)
			connection.close();

	}

	/**
	 * @author Eduardo
	 */

	/**
	 * En este metodo recibimos los datos correspondiente a la beca que queremos dar
	 * de alta en un objeto beca, a excepción del numero de beca, que conseguimos en
	 * la primera parte del metodo de la tabla beca.cod y le sumamos +1 para que
	 * siga el orden correlativo. En la segunda parte del metodo hacemos un insert
	 * con todo los datos recopilados con el metodo consulta preparada.
	 * 
	 * @param nombre          datos beca
	 * @param condiciones     datos beca
	 * @param descripcion     datos beca
	 * @param contacto        datos beca
	 * @param nombreProveedor datos beca
	 * @param tipo_beca       datos beca
	 * @return true en caso de exito, false en caso contrario
	 */
	public boolean aniadirBeca(Beca b) {

		boolean alta = false;
		// convertimos el enum a String
		String tBeca = b.getTipo_beca().toString();
		int cod = 0;

		// En proceos de evaluacion
		// Beca beca = new Beca(nombre, condiciones, descripcion, contacto,
		// nombreProveedor, tipo_beca);

		try {
			PreparedStatement ps = connection.prepareStatement("select max(cod) from becas");
			rs = ps.executeQuery();

			while (rs.next()) {
				cod = rs.getInt(1) + 1;
			}

			ps = connection.prepareStatement("insert into becas values(?,?,?,?,?,?,?)");
			ps.setInt(1, cod);
			ps.setString(2, b.getNombre());
			ps.setString(3, b.getCondiciones());
			ps.setString(4, b.getDescripcion());
			ps.setString(5, b.getContacto());
			ps.setString(6, b.getNombreProveedor());
			ps.setString(7, tBeca);
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se encuantan los datos en la base de datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}

		return alta;
	}

	/**
	 * Este metodo a partir del codigo de beca recibido, borrara la beca
	 * correspondiente.
	 * 
	 * @param cod numero de beca referencia para el borrado
	 * @return true en caso de exito, false en caso contrario
	 * @throws SQLException
	 */
	public boolean borrarBeca(String dato, int condicion) {

		boolean borrado = false;

		PreparedStatement ps;

		try {
			// como solventar los capos vacios para el borrado?????

			if (dato.isBlank() || dato.isEmpty()) {

				throw new Exception();
			}

			String filtro = menuFiltro(dato, condicion, false);

			ps = connection.prepareStatement("delete from becas where " + filtro + " like upper('%" + dato + "%')");
			ps.executeQuery();

			borrado = true;

		} catch (SQLException e) {
			e.printStackTrace();
			borrado = false;
			return borrado;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Atecion: el campo esta vacio");
		}

		return borrado;
	}

	/**
	 * Con este metodo podremos actualizar determinados datos de las distintaas
	 * becas de nuestra BBDD
	 * 
	 * @param columna       campo del que queremos hacer la actualizacion
	 * @param cod           codigo del cliente al que se le hace el cambio
	 * @param actualizacion dato que se cambia en la columna
	 * @return true en caso de exito, false en caso contrario
	 */
	public boolean modificarBeca(String columna, int cod, String actualizacion) {

		boolean modificado = false;

		PreparedStatement ps;

		try {

			ps = connection
					.prepareStatement("update becas set " + columna + " = '" + actualizacion + "' where cod= " + cod);
			int up = ps.executeUpdate();

			if (up == 2) {
				modificado = false;
			} else {
				modificado = true;
			}

		} catch (SQLException e) {
			System.out.println("No se a podido realizar la actualizacion de la beca");
			modificado = false;
			return modificado;
		}

		return modificado;
	}

	/**
	 * Este metodo nos saca de la base de datos toda la informacion relativa a
	 * nuestras becas
	 * 
	 * @return devuelve un string con la informacion solicita o un mensaje de error
	 *         en caso de fallo
	 */
	public String listarBecas() {

		PreparedStatement ps;
		String lista = "";

		try {
			ps = connection.prepareStatement("select * from becas order by 1");
			rs = ps.executeQuery();
			while (rs.next()) {

				lista += "Codigo beca= " + rs.getInt(1) + " nombre beca = " + rs.getString(2) + " condiciones= "
						+ rs.getString(3) + " descripcion= " + rs.getString(4) + " contacto= " + rs.getString(5)
						+ " nombre proveedor= " + rs.getString(6) + " tipo de beca= " + rs.getString(7) + "\n";

			}

		} catch (SQLException e) {

			return "La lista no se ha podido cargar";
		}

		return lista;
	}

	public ArrayList<Beca> listarBecasArray() {

		ArrayList<Beca> datos = new ArrayList<Beca>();

		PreparedStatement ps;

		try {
			ps = connection.prepareStatement("select * from becas order by 1");
			rs = ps.executeQuery();

			while (rs.next()) {
				String tipo = rs.getString(7);
				tipo_beca tp = null;

				if (tipo.equals("PRIVADA")) {
					tp = tp.PRIVADA;
				} else {
					tp = tp.PUBLICA;

				}

				Beca b = new Beca(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), tp);
				datos.add(b);
			}

		} catch (SQLException e) {

			System.out.println("La lista no se ha podido cargar");
		}

		return datos;
	}

	/**
	 * Metodo destinado a buscar informacion en la base de datos basado en una
	 * palabra y con una condicion que define el tipo de busqueda que se va a hacer
	 * 
	 * @param dato      palabra que hace de filtro en el campo
	 * @param condicion 1 2 o 3 segun si queremos buscar por id, nombre de beca o
	 *                  nombre de proveedor
	 * @return String con la informacion encontrada
	 */

	public String buscarDatosBeca(String dato, int condicion) {

		String lista = "";
		String filtro;

		try {

			filtro = menuFiltro(dato, condicion, true);

			while (rs.next()) {

				lista += "Codigo beca= " + rs.getInt(1) + " nombre beca = " + rs.getString(2) + " descripcion= "
						+ rs.getString(4) + " contacto= " + rs.getString(5) + " nombre proveedor= " + rs.getString(6)
						+ " tipo de beca= " + rs.getString(7);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	/**
	 * metodo que recoge dato y condicion de de busqueda
	 * 
	 * @param dato      es la informacion que buscamos
	 * @param condicion es el filtro por el cual queremos buscar esta informacion
	 * 
	 * @throws SQLException subimos la excepcion de funcionamiento SQL
	 */

	public String menuFiltro(String dato, int condicion, boolean buscar) throws SQLException {

		String filtro = null;

		PreparedStatement ps;

		switch (condicion) {
		case 1:

			filtro = "cod";
			if (buscar) {
				ps = connection.prepareStatement("select * from becas where " + filtro + "=" + dato);
				rs = ps.executeQuery();
			}
			break;

		case 2:
			filtro = "nombre";
			if (buscar) {
				ps = connection
						.prepareStatement("select * from becas where " + filtro + " like upper('%" + dato + "%')");
				rs = ps.executeQuery();
			}

			break;
		case 3:
			filtro = "nombreproveedor";
			if (buscar) {
				ps = connection
						.prepareStatement("select * from becas where " + filtro + " like upper('%" + dato + "%')");
				rs = ps.executeQuery();

			}
			break;

		default:
			break;

		}
		return filtro;
	}

	public String informacionActualizacion(int cod) throws SQLException {

		PreparedStatement ps;
		String lista = "";

		ps = connection.prepareStatement("select * from becas where cod=" + cod);
		rs = ps.executeQuery();

		while (rs.next()) {

			lista += "Codigo beca= " + rs.getInt(1) + " nombre beca = " + rs.getString(2) + " descripcion= "
					+ rs.getString(4) + " contacto= " + rs.getString(5) + " nombre proveedor= " + rs.getString(6)
					+ " tipo de beca= " + rs.getString(7) + "\n";

		}

		return lista;
	}

	/**
	 * Con este metodos daremos de alta administradores en la tabla de
	 * administradores, a partir de un objeto administrador que herreda de usuario
	 * 
	 * @param a Objeto de la calse administrador con todos los datos
	 * @return true en caso de exito, false en caso contrario
	 */

	public boolean darAltaAdmin(Administrador a) {

		boolean alta = false;
		int cod = 0;

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("select max(id_usuario)from administradores");
			rs = ps.executeQuery();
			// variar en un futuro para poder hacer la incorpoacion en una tabla vacia

			while (rs.next()) {

				cod = rs.getInt(1) + 1;
			}

			ps = connection.prepareStatement("insert into administradores values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate)");
			ps.setInt(1, cod);
			ps.setString(2, a.getDni());
			ps.setString(3, a.getNombre());
			ps.setString(4, a.getApellido());
			ps.setString(5, a.getNacionalidad());
			ps.setString(6, a.getEmail());
			ps.setInt(7, a.getTelf());
			// pendiente de ver al interaccion de este dato
			// ps.setDate(8,"sysdate");
			// ps.setString(8, "sysdate");
			ps.setString(8, a.getClave());
			ps.setString(9, a.getEstado());
			ps.setString(10, a.getDescripcion_puesto());
			// ps.setString(11, "sysdate");
			ps.executeUpdate();

			alta = true;

		} catch (SQLException e) {
			System.out.println("no se han insertar los datos");
			e.printStackTrace();
			alta = false;
			return alta;
		}

		return alta;

	}

	/**
	 * Metodo que borra un admin de la tabla admin a partir de una id de usuario
	 * 
	 * @param id_usuario dato que filtra el borrado del administrador
	 * @return true en caso de exito, false en caso contrario
	 */

	public boolean darBajaAdmin(int id_usuario) {

		boolean borrado = false;

		PreparedStatement ps;

		try {
			ps = connection.prepareStatement("delete from administradores where id_usuario= " + id_usuario);
			ps.executeQuery();

			borrado = true;

		} catch (SQLException e) {
			System.out.println("No se a podido realizar el borrado del administrador");
			e.printStackTrace();
			borrado = false;
			return borrado;
		}

		return borrado;
	}

	/**
	 * Metodo que devuelve una lista completa de todo los administradores que
	 * tenemos en la tabla administradores
	 * 
	 * @return variable String con toda la informacion
	 */

	public String mostrarAdmin() {

		PreparedStatement ps;
		String lista = "";

		try {
			ps = connection.prepareStatement("select * from administradores");
			rs = ps.executeQuery();

			while (rs.next()) {

				lista += "Codigo administrador " + rs.getInt(1) + " dni = " + rs.getString(2) + " nombre= "
						+ rs.getString(3) + " apellido= " + rs.getString(4) + " nacionalidad= " + rs.getString(5)
						+ " email= " + rs.getString(6) + " telfono= " + rs.getInt(7) + " fecha nacimiento= "
						+ rs.getDate(8) + " clave= " + rs.getString(9) + " estado= " + rs.getString(10)
						+ " Descripcion puesto= " + rs.getString(11) + " fecha inicio= " + rs.getDate(12) + "\n";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "La lista no se ha podido cargar";
		}

		return lista;
	}

}