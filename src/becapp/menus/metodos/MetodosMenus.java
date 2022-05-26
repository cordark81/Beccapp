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
	 * con este metodo conseguimos una confirmacion si queremos salir del programa,
	 * esta seguro?? si o no.
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
				
				datos[i][0] = d.get(i).getCod();
				datos[i][1] = d.get(i).getNombre();
				datos[i][2] = d.get(i).getCondiciones();
				datos[i][3] = d.get(i).getDescripcion();
				datos[i][4] = d.get(i).getNombreProveedor();
				datos[i][5] = d.get(i).getContacto();
				datos[i][6] = d.get(i).getTipo_beca().toString();
	
			}

		} else if (tipoTabla.equals("administrador")) {

			ArrayList<Administrador> d = conexion.listarAdminitradoresArray();
			datos = new Object[d.size()][13];
			array = d.toArray();

			for (int i = 0; i < d.size(); i++) {
				datos[i][0] = d.get(i).getId_usuario();
				datos[i][1] = d.get(i).getEstado();
				datos[i][2] = d.get(i).getDescripcion_puesto();
				datos[i][3] = d.get(i).getFecha_inc();
				datos[i][4] = d.get(i).getFecha_nac();
				datos[i][5] = d.get(i).getClave();
				datos[i][6] = d.get(i).getEmail();
				datos[i][7] = d.get(i).getNombre();
				datos[i][8] = d.get(i).getApellido();
				datos[i][9] = d.get(i).getDni();
				datos[i][10] = d.get(i).getNacionalidad();
				datos[i][11] = d.get(i).getTelf();
				datos[i][12] = null;

			}

		} else {
			System.out.println("Revisar el string introducido");
		}

		return datos;
	}

}
