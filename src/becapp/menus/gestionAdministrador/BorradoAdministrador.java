package becapp.menus.gestionAdministrador;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import becapp.menus.metodos.Listado;

/**
 * 
 * @author edu
 *
 */
public class BorradoAdministrador extends JFrame {

	private JTextArea informacion;
	private String name;
	private int condicion;

	public BorradoAdministrador() {

		setTitle("GESTION: BORRAR ADMINISTRADORES");
		ImagenFondo fondo = new ImagenFondo("/imagenes/tabla.jpg");
		setContentPane(fondo);
		setBounds(500, 300, 600, 450);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JTextPane campoC = new JTextPane();
		campoC.setText("Seleccionar campo para el borrado:");
		campoC.setBounds(100, 40, 450, 19);
		getContentPane().add(campoC);
		campoC.setEditable(false);
		campoC.setOpaque(false);

		JRadioButton id = new JRadioButton("ID");
		id.setBounds(100, 70, 50, 23);
		getContentPane().add(id);
		id.setOpaque(false);

		JRadioButton dni = new JRadioButton("DNI");
		dni.setBounds(250, 70, 150, 23);
		getContentPane().add(dni);
		dni.setOpaque(false);

		JRadioButton listado = new JRadioButton("Listado");
		listado.setBounds(400, 70, 175, 23);
		getContentPane().add(listado);
		listado.setOpaque(false);

		// grupo de JRadioButton para un unica seleccion
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(id);
		grupo1.add(listado);
		grupo1.add(dni);

		informacion = new JTextArea();
		informacion.setBounds(new Rectangle(100, 100, 400, 200));
		informacion.setEditable(false);
		informacion.setVisible(false);
		informacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		getContentPane().add(informacion);

		JButton aceptar = new JButton("BORRAR");
		aceptar.setBounds(400, 350, 100, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.orange);

		/**
		 * Funcionalidad del Radio Button id, pide la id para hacer la busqueda la hace
		 * y si encuentra muestra la informacion pero todavia no borra. Si no encuentra
		 * nada lazara un panel de diagolo con la inforamcion pertinente
		 */

		id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();

				name = JOptionPane.showInputDialog("Introduzca ID del administrador");
				grupo1.clearSelection();
				condicion = 3;
				// busca la informacion
				informacion.setText(conexion.buscarDatos(name, condicion, "administradores", true));
				informacion.setVisible(true);
				informacion.setEditable(false);
				// verifica si esta vacio o en blanco el campo
				if (informacion.getText().isBlank() || informacion.getText().isEmpty()) {
					informacion.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ninguna administrador encontrado");
				}

			}
		});
		/**
		 * Funcionalidad del Radio Button dni, pide el dni para hacer la busqueda la
		 * hace y si encuentra muestra la informacion pero todavia no borra, Si no
		 * encuentra nada lazara un panel de diagolo con la inforamcion pertinente
		 */
		dni.addActionListener(new ActionListener() {

			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {

				Conexion_BBDD conexion = new Conexion_BBDD();

				name = JOptionPane.showInputDialog("Introduzca Dni del adminitrador");
				grupo1.clearSelection();
				condicion = 4;
				// busca la informacion
				informacion.setText(conexion.buscarDatos(name, condicion, "administradores", true));
				informacion.setVisible(true);
				informacion.setEditable(false);
				// verifica si esta vacio o en blanco el campo
				if (informacion.getText().isBlank() || informacion.getText().isEmpty()) {
					informacion.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ninguna administrador encontrado");
				}

			}
		});

		/**
		 * Funcionalidad del Radio Button listado, este es un poco distinto por que lo
		 * genera es una tabla con toda la informacion de la base de datos y lo muestra
		 * en una tabla con un boton de borrado por fila
		 */

		listado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();

				grupo1.clearSelection();
				// columnas de la tabla
				String[] columnas = { "ID", "Estado", "Descripcion puesto", "Fecha inicio", "Fecha nacimiento", "Clave",
						"Email", "Nombre", "Apellido", "Dni", "Nacionalidad", "Teléfono", "" };
				// constructor que monta la tabla
				Listado listado = new Listado(true, columnas, "administrador");
				listado.setVisible(true);
				listado.setTitle("Datos administradores");
				listado.pack();

			}
		});
		/**
		 * Despues de hacer las seleccion con lo botones de opciones(Radio Button), si
		 * la informacion mostrada es la que queremos borras esta accion lo borra de la
		 * base de datos y hace un registro en nuestros archivo log con el tipo de
		 * movimiento
		 */

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();

				if (conexion.darBajaAdmin(name, condicion)) {
					JOptionPane.showMessageDialog(null, "administrador borrado con exito");
					Log metodos = new Log();
					try {
						// metodo de escritura en el archivo log con la hora y el tipo de movimiento
						metodos.escribirLog(Tipo_movimiento.BORRAR_ADMINISTRADOR);
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
