package becapp.menus.metodos;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import becapp.Administrador;
import becapp.Beca;
import becapp.Conexion_BBDD;

/**
 * 
 * @author edu
 *
 */

public class MetodosMenus extends JFrame {
	
	/**
	 * con este metodo conseguimos una confirmacion si queremos salir del programa, esta seguro?? si o no.
	 */
	public void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar la aplicacion", "Advertencia",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracias, hasta pronto", "Gracias", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}

	/**
	 * Este metodo se encarga de transformatar un arraylist de becas o
	 * administradores en una matriz de objetos que contiene los capos que iran en
	 * las tablas que luego enseñaremos.
	 * 
	 * @param conexion  conexion a base de datos para usar el metodo necesario
	 * @param tipoTabla string "beca" o "administrador" para navegar por el if
	 * @return matriz de objetos para la tabla
	 */
	public Object[][] arrayBidimensional(Conexion_BBDD conexion, String tipoTabla) {

		Object[] array;
		Object[][] datos = null;

		if (tipoTabla.equals("beca")) {

			ArrayList<Beca> d = conexion.listarBecasArray();
			datos = new Object[d.size()][8];

			array = d.toArray();

			for (int i = 0; i < d.size(); i++) {

				for (int j = 0; j <= 6; j++) {

					switch (j) {
					case 0:
						Integer cod = ((Beca) array[i]).getCod();
						datos[i][j] = cod;
						break;
					case 1:
						String nombre = ((Beca) array[i]).getNombre();
						datos[i][j] = nombre;
						break;
					case 2:
						String condiciones = ((Beca) array[i]).getCondiciones();
						datos[i][j] = condiciones;
						break;
					case 3:
						String descripcion = ((Beca) array[i]).getDescripcion();
						datos[i][j] = descripcion;
						break;
					case 4:
						String proveedor = ((Beca) array[i]).getNombreProveedor();
						datos[i][j] = proveedor;
						break;
					case 5:
						String contacto = ((Beca) array[i]).getContacto();
						datos[i][j] = contacto;
						break;
					case 6:
						String tipo = ((Beca) array[i]).getTipo_beca().toString();
						datos[i][j] = tipo;
						break;

					default:
						break;
					}

				}
			}

		} else if (tipoTabla.equals("administrador")) {
			
			ArrayList<Administrador> d = conexion.listarAdminitradoresArray();
			datos = new Object[d.size()][13];
			array = d.toArray();
			
			for (int i = 0; i < d.size(); i++) {

				for (int j = 0; j <= 11; j++) {

					switch (j) {
					case 0:
						Integer cod = ((Administrador) array[i]).getId_usuario();
						datos[i][j] = cod;
						break;
					case 1:
						String dni = ((Administrador) array[i]).getDni();
						datos[i][j] = dni;
						break;
					case 2:
						String nombre = ((Administrador) array[i]).getNombre();
						datos[i][j] = nombre;
						break;
					case 3:
						String apellido = ((Administrador) array[i]).getApellido();
						datos[i][j] = apellido;
						break;
					case 4:
						String nacionalidad = ((Administrador) array[i]).getNacionalidad();
						datos[i][j] = nacionalidad;
						break;
					case 5:
						String email = ((Administrador) array[i]).getEmail();
						datos[i][j] = email;
						break;
					case 6:
						Integer telefono = ((Administrador) array[i]).getTelf();
						datos[i][j] = telefono;
						break;
					case 7:
						String fechaNaci = ((Administrador) array[i]).getFecha_nac();
						datos[i][j] = fechaNaci;
						break;
					case 8:
						String clave = ((Administrador) array[i]).getClave();
						datos[i][j] = clave;
						break;
					case 9:
						String estado = ((Administrador) array[i]).getEstado();
						datos[i][j] = estado;
						break;
					case 10:
						String descripcion = ((Administrador) array[i]).getDescripcion_puesto();
						datos[i][j] = descripcion;
						break;
					case 11:
						String fechaAlta = ((Administrador) array[i]).getFecha_inc();
						datos[i][j] = fechaAlta;
						break;
					case 12:
						JButton eliminar = new JButton("Eliminar");
						datos[i][j] = eliminar;
						break;
								

					default:
						break;
					}

				}
			}

		}else {
			System.out.println("Revisar el string introducido");
		}
		

		return datos;
	}

}
