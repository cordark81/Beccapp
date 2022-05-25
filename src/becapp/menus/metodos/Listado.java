package becapp.menus.metodos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import becapp.Conexion_BBDD;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;

/**
 * 
 * @author edu/arturo
 *
 */

public class Listado extends JFrame {
	/**
	 * Con este contructor tenemos el opcion de crear una tabla con o sin botones de borrado de linea 
	 * 
	 * @param eliminar true si queremos el boton de eliminar fila
	 * @param columnas array de String con la lumnas que queremos añadir
	 * @param tabla seleccionamos la tabla de la base de datos que queremos sacar la info
	 */

	public Listado(boolean eliminar, String[] columnas, String tabla) {

		MetodosMenus mm = new MetodosMenus();
		Conexion_BBDD conexion = new Conexion_BBDD();
		conexion.conectar();
		
		Object[][] datos = mm.arrayBidimensional(conexion, tabla);

		final JTable table = new JTable(datos, columnas);
		if (eliminar) {
			ButtonColumn btnEliminar = new ButtonColumn(table, new AbstractAction() {
				public void actionPerformed(ActionEvent e) {
					//aqui sacamos el dato de la id de la fila 1 para el borrado
					String dato = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
					
					if (conexion.borrarBeca(dato, 1, false)) {
						JOptionPane.showMessageDialog(null, "Beca borrada con exito");
						Log metodos = new Log();
						GregorianCalendar gc = new GregorianCalendar();
						Date fecha_hora = gc.getTime();
						try {
							//tiene su propio añadido al fichero log si se elige con borrado
							metodos.escribirLog(Tipo_movimiento.BORRAR_BECA, fecha_hora);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Atecion: la beca no se ha podido borrar");
					}
					// cerramos la ventana de tabla despues del borrado
					dispose();
				}
			}, columnas.length - 1);
			//opcion de añadir texto o icono como esta en este caso
			btnEliminar.setText("");
			btnEliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/elimina.png")));

		}
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane, BorderLayout.CENTER);

	}
}
