package becapp.menus.metodos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import becapp.Conexion_BBDD;

public class Listado extends JFrame {

	public Listado(boolean eliminar,String [] columnas,String tabla) {

		MetodosMenus mm = new MetodosMenus();
		Conexion_BBDD conexion = new Conexion_BBDD();
		conexion.conectar();

		Object[][] datos = mm.arrayBidimensional(conexion, tabla);

		final JTable table = new JTable(datos, columnas);
		if(eliminar) {
		ButtonColumn btnConsultar = new ButtonColumn(table, new AbstractAction() {
			public void actionPerformed(ActionEvent e)
			{
			
			}
		}, columnas.length-1);
		btnConsultar.setText("ELIMINAR");
		}
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		JScrollPane scrollpane = new JScrollPane(table);
		getContentPane().add(scrollpane, BorderLayout.CENTER);

	}
}
