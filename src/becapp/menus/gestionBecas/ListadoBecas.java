package becapp.menus.gestionBecas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import becapp.Conexion_BBDD;
import becapp.menus.metodos.*;

public class ListadoBecas extends JFrame {

	public ListadoBecas() {

		String[] columnas = { "Codigo", "Nombre", "Condiciones", "Descripcion", "Proveedor", "Contacto",
				"Tipo de Beca" };
		
		MetodosMenus mm= new MetodosMenus();
		Conexion_BBDD conexion = new Conexion_BBDD();
		conexion.conectar();

		Object[][] datos = mm.arrayBidimensional(conexion);

		final JTable table = new JTable(datos, columnas);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		

	
	}

}
