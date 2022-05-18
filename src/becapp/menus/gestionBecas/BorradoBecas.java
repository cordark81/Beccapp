package becapp.menus.gestionBecas;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import becapp.Conexion_BBDD;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.Listado;
import becapp.menus.metodos.MetodosMenus;

public class BorradoBecas extends JFrame {

	private JTextArea informacion;
	private String name;
	private int condicion;

	public BorradoBecas() {

		setTitle("GESTION: BORRAR BECAS");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setResizable(false);
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
		campoC.setText("Seleccionar campo para el borrado de la beca:");
		campoC.setBounds(100, 40, 450, 19);
		getContentPane().add(campoC);
		campoC.setEditable(false);
		campoC.setOpaque(false);

		JRadioButton id = new JRadioButton("ID");
		id.setBounds(100, 100, 50, 23);
		getContentPane().add(id);
		id.setOpaque(false);

		JRadioButton nombre = new JRadioButton("Nombre Proveedor");
		nombre.setBounds(200, 100, 200, 23);
		getContentPane().add(nombre);
		nombre.setOpaque(false);

		JRadioButton listado = new JRadioButton("Listado");
		listado.setBounds(400, 100, 100, 23);
		getContentPane().add(listado);
		listado.setOpaque(false);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(id);
		grupo1.add(listado);
		grupo1.add(nombre);

		id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca ID de la beca");
				grupo1.clearSelection();
				condicion = 1;
				informacion.setText(conexion.buscarDatos(name, condicion, "becas", true));
				informacion.setVisible(true);
				if (informacion.getText().isBlank() || informacion.getText().isEmpty()) {
					informacion.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ninguna beca encontrada");
				}
				try {
					conexion.cerrar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		nombre.addActionListener(new ActionListener() {

			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca nombre de la beca");
				grupo1.clearSelection();
				condicion = 2;
				informacion.setText(conexion.buscarDatos(name, condicion, "becas", true));
				informacion.setVisible(true);
				if (informacion.getText().isBlank() || informacion.getText().isEmpty()) {
					informacion.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ninguna beca encontrada");
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
				grupo1.clearSelection();
				String[] columnas = { "Codigo", "Nombre", "Condiciones", "Descripcion", "Proveedor", "Contacto",
				"Tipo de Beca",""};
				Listado listado=new Listado(true, columnas,"beca");
				listado.setVisible(true);
				listado.pack();
				listado.setTitle("Informacion Becas");

				try {
					conexion.cerrar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		informacion = new JTextArea();
		informacion.setBounds(new Rectangle(50, 150, 500, 150));
		informacion.setEditable(false);
		informacion.setVisible(false);
		informacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		getContentPane().add(informacion);

		JButton atras = new JButton("ATRAS");
		atras.setBounds(100, 350, 100, 30);
		getContentPane().add(atras);
		atras.setBackground(Color.ORANGE);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				GestionBecas gb = new GestionBecas();
				gb.setVisible(true);

			}
		});

		JButton aceptar = new JButton("BORRAR BECAS");
		aceptar.setBounds(300, 350, 200, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.ORANGE);

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();

				GregorianCalendar gc = new GregorianCalendar();
				Date fecha_hora = gc.getTime();

				if (conexion.borrarBeca(name, condicion)) {
					JOptionPane.showMessageDialog(null, "Seleccion de beca/s borrado con exito");
					Log metodos = new Log();
					try {
						metodos.escribirLog(Tipo_movimiento.BORRAR_BECA, fecha_hora);
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				} else {
					System.out.println("Error:problema en el borrado de beca");
				}

			}
		});

	}

}
