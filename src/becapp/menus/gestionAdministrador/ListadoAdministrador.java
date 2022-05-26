package becapp.menus.gestionAdministrador;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import becapp.Conexion_BBDD;
import becapp.menus.metodos.MetodosMenus;
import becapp.menus.metodos.renderizarTabla;

public class ListadoAdministrador extends JFrame {

	public ListadoAdministrador(boolean eliminar) {

		String[] columnas = { "ID", "DNI", "Nombre", "Apellido", "Nacionalidad", "Email", "Telefono",
				"Fecha  nacimientos", "Clave", "Estado", "Descripcion puesto", "Fecha alta"};

		MetodosMenus mm = new MetodosMenus();
		Conexion_BBDD conexion = new Conexion_BBDD();
		conexion.conectar();

		Object[][] datos = mm.arrayBidimensional(conexion, "administrador");

		final JTable table = new JTable(datos, columnas);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane, BorderLayout.CENTER);

	}
}
