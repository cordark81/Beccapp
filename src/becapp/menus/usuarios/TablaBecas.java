package becapp.menus.usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import becapp.Conexion_BBDD;

/**
 * 
 * @author Eduardo y Arturo
 *
 *         Clase para la creacion de una tabla del menu de visialización de
 *         becas
 *
 */
public class TablaBecas extends JFrame {

	Connection c = null;
	ResultSet rs = null;
	Statement st = null;

	TablaBecas() {

		Conexion_BBDD conect = new Conexion_BBDD();

		JTable table = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Proveedor");
		modelo.addColumn("Descripci�n");
		modelo.addColumn("M�s info");
		table.setModel(modelo);

		String[] datos = new String[2];

	}

}