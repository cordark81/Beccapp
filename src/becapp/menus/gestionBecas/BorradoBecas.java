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
import becapp.menus.metodos.MetodosMenus;

public class BorradoBecas extends JFrame {

	private JTextArea informacion;
	private String name;
	private int condicion;

	public BorradoBecas() {

		setTitle("GESTION: BORRAR BECAS");
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
		campoC.setBounds(100, 40, 350, 19);
		getContentPane().add(campoC);
		campoC.setEditable(false);
		campoC.setOpaque(false);

		JRadioButton id = new JRadioButton("ID");
		id.setBounds(100, 70, 50, 23);
		getContentPane().add(id);

		JRadioButton nombre = new JRadioButton("Nombre Beca");
		nombre.setBounds(175, 70, 150, 23);
		getContentPane().add(nombre);

		JRadioButton nombreProveedor = new JRadioButton("Nombre Proveedor");
		nombreProveedor.setBounds(350, 70, 175, 23);
		getContentPane().add(nombreProveedor);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(id);
		grupo1.add(nombreProveedor);
		grupo1.add(nombre);

		id.addActionListener(new ActionListener() {

			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca ID de la beca");
				grupo1.clearSelection();
				condicion = 1;
				informacion.setText(conexion.buscarDatosBeca(name, condicion));
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
				informacion.setText(conexion.buscarDatosBeca(name, condicion));

				try {
					conexion.cerrar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		

		nombreProveedor.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca nombre del proveedor");
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
				GestionBecas gb = new GestionBecas();
				gb.setVisible(true);

			}
		});

		JButton aceptar = new JButton("BORRAR BECAS");
		aceptar.setBounds(300, 350, 200, 30);
		getContentPane().add(aceptar);

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
						metodos.escribirLog(Tipo_movimiento.BORRAR_BECA, fecha_hora, informacion.getText());
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
