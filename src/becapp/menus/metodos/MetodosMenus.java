package becapp.menus.metodos;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import becapp.Beca;
import becapp.Conexion_BBDD;

public class MetodosMenus extends JFrame {

	public void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de cerrar la aplicacion", "Advertencia",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (valor == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Gracias, hasta pronto", "Gracias", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

	}
	public Object[][] arrayBidimensional(Conexion_BBDD conexion) {
		
		Object[] array;
		ArrayList<Beca> d = conexion.listarBecasArray();
		Object[][] datos = new Object[d.size()][7];

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
		
		return datos;
	}

}
