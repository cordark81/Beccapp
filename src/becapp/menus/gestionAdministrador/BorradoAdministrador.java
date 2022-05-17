package becapp.menus.gestionAdministrador;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import becapp.Conexion_BBDD;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;

public class BorradoAdministrador extends JFrame {

	private JTextArea informacion;
	private String name;
	private int condicion;

	public BorradoAdministrador() {

		setTitle("GESTION: BORRAR ADMINISTRADORES");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setBounds(500, 300, 600, 450);
		getContentPane().setLayout(null);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JTextPane campoC = new JTextPane();
		campoC.setText("Seleccionar campo para el borrado:");
		campoC.setBounds(100, 40, 450, 19);
		getContentPane().add(campoC);
		campoC.setEditable(false);
		campoC.setOpaque(false);
		campoC.setForeground(Color.white);

		JRadioButton id = new JRadioButton("ID");
		id.setBounds(100, 70, 50, 23);
		getContentPane().add(id);
		id.setOpaque(false);

		JRadioButton dni = new JRadioButton("DNI");
		dni.setBounds(175, 70, 150, 23);
		getContentPane().add(dni);
		dni.setOpaque(false);

		JRadioButton listado = new JRadioButton("Listado");
		listado.setBounds(350, 70, 175, 23);
		getContentPane().add(listado);
		listado.setOpaque(false);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(id);
		grupo1.add(listado);
		grupo1.add(dni);

		id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca ID del administrador");
				grupo1.clearSelection();
				condicion = 1;
				informacion.setText(conexion.buscarDatos(name, condicion, "administradores", true));
				if (informacion.getText().isBlank()||informacion.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ninguna administrador encontrado");					
				}
				try {
					conexion.cerrar();
				} catch (SQLException e1) {
				}

			}
		});
		dni.addActionListener(new ActionListener() {

			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca Dni del adminitrador");
				grupo1.clearSelection();
				condicion = 2;
				informacion.setText(conexion.buscarDatos(name, condicion,"administradores",true));
				if (informacion.getText().isBlank()||informacion.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Ninguna administrador encontrado");					
				}
				try {
					conexion.cerrar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		listado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Listado");
				grupo1.clearSelection();
				condicion = 3;
				informacion.setText(conexion.buscarDatosBeca(name, condicion));

				try {
					conexion.cerrar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		informacion = new JTextArea();
		informacion.setBounds(new Rectangle(100, 100, 400, 200));
		informacion.setEditable(false);
		informacion.setVisible(true);
		informacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
		getContentPane().add(informacion);

		JButton atras = new JButton("ATRAS");
		atras.setBounds(100, 350, 100, 30);
		getContentPane().add(atras);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				GestionAdministradores gb = new GestionAdministradores();
				gb.setVisible(true);

			}
		});

		JButton aceptar = new JButton("BORRAR");
		aceptar.setBounds(300, 350, 200, 30);
		getContentPane().add(aceptar);

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();

				GregorianCalendar gc = new GregorianCalendar();
				Date fecha_hora = gc.getTime();

				if (conexion.darBajaAdmin(name, condicion)) {
					JOptionPane.showMessageDialog(null, "administrador borrado con exito");
					Log metodos = new Log();
					try {
						metodos.escribirLog(Tipo_movimiento.BORRAR_ADMINITRADOR, fecha_hora);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("Error:problema en el borrado del administrador");
				}

			}
		});

	}

}
