package becapp.menus.gestionBecas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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

public class BorradoBecas extends JFrame {

	private JTextArea informacion;
	private String name;
	private int condicion;

	public BorradoBecas() {

		setTitle("GESTION: BORRAR BECAS");
		ImagenFondo fondo = new ImagenFondo("/imagenes/tabla.jpg");
		setContentPane(fondo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(500, 300, 600, 450);
		getContentPane().setLayout(null);
		setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane campoC = new JTextPane();
		campoC.setText("Seleccionar campo para el borrado de la beca:");
		campoC.setBounds(100, 40, 450, 19);
		getContentPane().add(campoC);
		campoC.setEditable(false);
		campoC.setOpaque(false);
		campoC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton id = new JRadioButton("ID");
		id.setBounds(100, 100, 50, 23);
		getContentPane().add(id);
		id.setOpaque(false);
		id.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton nombre = new JRadioButton("Nombre Proveedor");
		nombre.setBounds(200, 100, 200, 23);
		getContentPane().add(nombre);
		nombre.setOpaque(false);
		nombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton listado = new JRadioButton("Listado");
		listado.setBounds(400, 100, 100, 23);
		getContentPane().add(listado);
		listado.setOpaque(false);
		listado.setFont(new Font("Roboto", Font.PLAIN, 14));

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(id);
		grupo1.add(listado);
		grupo1.add(nombre);

		informacion = new JTextArea();
		informacion.setBounds(new Rectangle(50, 150, 500, 150));
		informacion.setEditable(false);
		informacion.setVisible(false);
		informacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		getContentPane().add(informacion);
		informacion.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton aceptar = new JButton("BORRAR BECAS");
		aceptar.setBounds(300, 350, 200, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.ORANGE);
		aceptar.setFont(new Font("Roboto", Font.PLAIN, 14));

		/**
		 * 
		 * 
		 * Funcionalidad del Radio Button id, pide la id para hacer la busqueda la hece
		 * y si encuentra muestra la informacion pero todavia no borra. Si no encuentra
		 * nada lazara un panel de diagolo con la inforamcion pertinente
		 */

		id.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conexion_BBDD conexion = new Conexion_BBDD();
			
				name = JOptionPane.showInputDialog("Introduzca ID de la beca");
				grupo1.clearSelection();
				condicion = 1;
				// busca la informacion
				informacion.setText(conexion.buscarDatos(name, condicion, "becas", true));
				informacion.setVisible(true);
				informacion.setEditable(false);
				// verifica si esta vacio o en blando el campo
				if (informacion.getText().isBlank() || informacion.getText().isEmpty()) {
					informacion.setVisible(false);
					JOptionPane.showMessageDialog(null, "Ninguna beca encontrada");
				}
		

			}
		});
		/**
		 * Funcionalidad del Radio Button nombre proveedor, pide el nombre de proveedor
		 * para hacer la busqueda la hace y si encuentra muestra la informacion pero
		 * todavia no borra, esta preparado para en caso de en la busqueda encontrar
		 * varios nombres iguales mostralos todos para su borrado simultaneo. Si no
		 * encuentra nada lazara un panel de diagolo con la inforamcion pertinente
		 */
		nombre.addActionListener(new ActionListener() {

			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion_BBDD();
				conexion.conectar();
				name = JOptionPane.showInputDialog("Introduzca nombre de la beca");
				grupo1.clearSelection();
				condicion = 2;
				// busca la informacion
				informacion.setText(conexion.buscarDatos(name, condicion, "becas", true));
				informacion.setVisible(true);
				// verifica si esta vacio o en blando el campo
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
		/**
		 * Funcionalidad del Radio Button listado, este es un poco distinto por que lo
		 * genera es una tabla con toda la informacion de la base de datos y lo muestra
		 * en una tabla con un boton de borrado por fila
		 */
		listado.addActionListener(new ActionListener() {
			private Conexion_BBDD conexion;

			@Override
			public void actionPerformed(ActionEvent e) {
				conexion = new Conexion_BBDD();
				
				grupo1.clearSelection();
				// columnas de la tabla
				String[] columnas = { "Codigo", "Proveedor", "Contacto", "Descripcion", "Nombre", "Condiciones",
						"Tipo de Beca", "" };
				// constructor que monta la tabla
				Listado listado = new Listado(true, columnas, "becas");
				listado.setVisible(true);
				listado.pack();
				listado.setTitle("Informacion Becas");

			

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
		
				if (conexion.borrarBeca(name, condicion, true)) {
					JOptionPane.showMessageDialog(null, "Seleccion de beca/s borrado con exito");
					Log metodos = new Log();
					try {
						// metodo de escritura en el archivo log con la hora y el tipo de movimiento
						metodos.escribirLog(Tipo_movimiento.BORRAR_BECA);
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
