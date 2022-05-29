package becapp.menus.invitados;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import becapp.Beca;
import becapp.Conexion_BBDD;
import becapp.menus.metodos.ButtonColumn;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;
import becapp.menus.usuarios.Login;
import becapp.menus.usuarios.RegistroUsuarios;
import infoBecas.Skills;

/**
 * 
 * @author Eduardo y Arturo
 *
 */
public class MenuInvitados extends JFrame {

	private JTable table;
	private JScrollPane scroll;

	public MenuInvitados() {

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();

			}
		});

		setTitle("BECAPP");
		setBounds(200, 100, 648, 430);
		setFont(new Font("Roboto", Font.PLAIN, 14));
		setResizable(false);

		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoCalcula.jpg");
		setContentPane(fondo);
		SpringLayout sl_fondo = new SpringLayout();
		fondo.setLayout(sl_fondo);

		JButton sesion = new JButton("Atras");
		fondo.add(sesion);
		sesion.setFont(new Font("Roboto", Font.PLAIN, 14));

		sesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Login cerrar = new Login();
				cerrar.setVisible(true);
			}
		});

		JLabel listaBecas = new JLabel("Nuestras becas");
		sl_fondo.putConstraint(SpringLayout.EAST, sesion, -16, SpringLayout.EAST, listaBecas);
		sl_fondo.putConstraint(SpringLayout.NORTH, listaBecas, 45, SpringLayout.NORTH, fondo);
		sl_fondo.putConstraint(SpringLayout.WEST, listaBecas, 163, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, listaBecas, -272, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, listaBecas, -149, SpringLayout.EAST, fondo);

		fondo.add(listaBecas);
		listaBecas.setFont(new Font("Roboto", Font.PLAIN, 40));

		scroll = new JScrollPane();
		sl_fondo.putConstraint(SpringLayout.NORTH, scroll, 6, SpringLayout.SOUTH, listaBecas);
		sl_fondo.putConstraint(SpringLayout.WEST, scroll, 67, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.SOUTH, scroll, -101, SpringLayout.SOUTH, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, scroll, -66, SpringLayout.EAST, fondo);
		fondo.add(scroll);

		JButton registra = new JButton("Registrate");
		sl_fondo.putConstraint(SpringLayout.WEST, registra, 133, SpringLayout.WEST, fondo);
		sl_fondo.putConstraint(SpringLayout.EAST, registra, -344, SpringLayout.EAST, fondo);
		sl_fondo.putConstraint(SpringLayout.NORTH, sesion, 0, SpringLayout.NORTH, registra);
		sl_fondo.putConstraint(SpringLayout.WEST, sesion, 26, SpringLayout.EAST, registra);
		sl_fondo.putConstraint(SpringLayout.NORTH, registra, 16, SpringLayout.SOUTH, scroll);
		registra.setFont(new Font("Roboto", Font.PLAIN, 14));
		fondo.add(registra);
		registra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				RegistroUsuarios ventana = new RegistroUsuarios();
				ventana.setVisible(true);
				dispose();
			}

		});

		construirTabla();

	}

	/**
	 * M�todo que crea y da formato a la tabla que se muestra en el men� de
	 * navegaci�n de usuario. Tambi�n a�ade un bot�n con funcionalidad de ver m�s
	 * informaci�n de la beca seleccionada,
	 */

	public void construirTabla() {
		String[] columnas = { "Nombre", "Descripcion", "M�s" };
		Object informacion[][] = obetenerMatriz();

		System.out.println(informacion.length);

		DefaultTableModel model = new DefaultTableModel(informacion, columnas) {
			boolean[] columnEditables = new boolean[] { false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table = new JTable(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		// table.setEnabled(false);
		// table.setModel(new modelo());

		scroll.setViewportView(table);

		ButtonColumn buttonColumn = new ButtonColumn(table, new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int modelRow = Integer.valueOf(e.getActionCommand());
				Skills s = new Skills(modelRow + 1);
				s.setVisible(true);

			}
		}, columnas.length - 1);
		buttonColumn.setText("Ver m�s");
	}

	/**
	 * Método para obtener matriz con la información de nombre y descripcion de las
	 * becas
	 * 
	 * @return matriz de objecto con la info
	 */
	private Object[][] obetenerMatriz() {

		Conexion_BBDD c = new Conexion_BBDD();
		ArrayList<Beca> miLista = c.recuperarBecas();

		Object info[][] = new Object[miLista.size()][3];

		for (int i = 0; i < miLista.size(); i++) {
			info[i] = new Object[3];
			info[i][0] = miLista.get(i).getNombre();
			info[i][1] = miLista.get(i).getDescripcion();
			info[i][2] = null;

		}

		return info;
	}
}
