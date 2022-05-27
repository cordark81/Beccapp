package becapp.menus.gestionBecas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import becapp.Conexion_BBDD;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;

/**
 * 
 * @author edu
 *
 */

public class ModificarBeca extends JFrame {

	private Conexion_BBDD conexion;

	public ModificarBeca() {

		setTitle("MODIFICACION BECA");
		setBounds(500, 300, 600, 600);
		setResizable(false);
		ImagenFondo fondo = new ImagenFondo("/imagenes/tabla.jpg");
		setContentPane(fondo);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane codC = new JTextPane();
		codC.setText("ID");
		codC.setBounds(100, 30, 100, 19);
		getContentPane().add(codC);
		codC.setEditable(false);
		codC.setOpaque(false);
		codC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField cod = new JTextField();
		cod.setBounds(100, 60, 60, 19);
		getContentPane().add(cod);
		cod.setColumns(10);
		cod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		cod.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane antesModiC = new JTextPane();
		antesModiC.setText("Antes de modificaciones: ");
		antesModiC.setBounds(50, 210, 400, 19);
		getContentPane().add(antesModiC);
		antesModiC.setEditable(false);
		antesModiC.setOpaque(false);
		antesModiC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField antesModi = new JTextField();
		antesModi.setBounds(50, 240, 500, 30);
		getContentPane().add(antesModi);
		antesModi.setColumns(10);
		antesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		antesModi.setEditable(false);
		antesModi.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane despuesModiC = new JTextPane();
		despuesModiC.setText("Despues de modificaciones: ");
		despuesModiC.setBounds(50, 300, 400, 19);
		getContentPane().add(despuesModiC);
		despuesModiC.setEditable(false);
		despuesModiC.setOpaque(false);
		despuesModiC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField despuesModi = new JTextField();
		despuesModi.setBounds(50, 330, 500, 30);
		getContentPane().add(despuesModi);
		despuesModi.setColumns(10);
		despuesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		despuesModi.setEditable(false);
		despuesModi.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane actualizacionC = new JTextPane();
		actualizacionC.setText("Actualizacion");
		actualizacionC.setBounds(250, 30, 200, 19);
		getContentPane().add(actualizacionC);
		actualizacionC.setEditable(false);
		actualizacionC.setOpaque(false);
		actualizacionC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField actualizacion = new JTextField();
		actualizacion.setBounds(250, 60, 250, 19);
		getContentPane().add(actualizacion);
		actualizacion.setColumns(10);
		actualizacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		actualizacion.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane columnaC = new JTextPane();
		columnaC.setText("Columnas");
		columnaC.setBounds(50, 100, 100, 19);
		getContentPane().add(columnaC);
		columnaC.setEditable(false);
		columnaC.setOpaque(false);
		columnaC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton nombre = new JRadioButton("nombre");
		nombre.setBounds(50, 130, 120, 23);
		getContentPane().add(nombre);
		nombre.setActionCommand("nombre");
		nombre.setOpaque(false);
		nombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton condiciones = new JRadioButton("condiciones");
		condiciones.setBounds(225, 130, 170, 23);
		getContentPane().add(condiciones);
		condiciones.setActionCommand("condiciones");
		condiciones.setOpaque(false);
		condiciones.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton descripcion = new JRadioButton("descripcion");
		descripcion.setBounds(425, 130, 200, 23);
		getContentPane().add(descripcion);
		descripcion.setActionCommand("descripcion");
		descripcion.setOpaque(false);
		descripcion.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JRadioButton contacto = new JRadioButton("contacto");
		contacto.setBounds(50, 160, 120, 23);
		getContentPane().add(contacto);
		contacto.setActionCommand("contacto");
		contacto.setOpaque(false);
		contacto.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JRadioButton nombreProveedor = new JRadioButton("proveedor");
		nombreProveedor.setBounds(225, 160, 120, 23);
		getContentPane().add(nombreProveedor);
		nombreProveedor.setActionCommand("nombre_proveedor");
		nombreProveedor.setOpaque(false);
		nombreProveedor.setFont(new Font("Roboto", Font.PLAIN, 14));

		JRadioButton tipoBeca = new JRadioButton("tipo beca");
		tipoBeca.setBounds(425, 160, 120, 23);
		getContentPane().add(tipoBeca);
		tipoBeca.setActionCommand("tipo");
		tipoBeca.setOpaque(false);
		tipoBeca.setFont(new Font("Roboto", Font.PLAIN, 14));

		// agrupamiento de los JRadioButton para que sea unica la seleccion
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(nombre);
		grupo1.add(condiciones);
		grupo1.add(descripcion);
		grupo1.add(contacto);
		grupo1.add(nombreProveedor);
		grupo1.add(tipoBeca);

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(450, 450, 100, 30);
		aceptar.setBackground(Color.orange);
		getContentPane().add(aceptar);
		aceptar.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton comprobar = new JButton("COMPROBAR ");
		comprobar.setBounds(50, 450, 150, 30);
		comprobar.setBackground(Color.orange);
		getContentPane().add(comprobar);
		comprobar.setFont(new Font("Roboto", Font.PLAIN, 14));

		/**
		 * Accion del boton aceptar en el cual se comprueba la correcta entrada de datos
		 * para que se pueda validar el cambio
		 */

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
			
				// mensaje de la excepcion
				String mensaje = "Atencion: solo son validos los numeros en ID";

				String columna;

				// con null devuelve true si no esta seleccionado
				try {

					if (grupo1.isSelected(null)) {
						mensaje = "Atencion: falta poner campo a actualizar";
						throw new Exception();
					}

					else if (cod.getText().isEmpty() || cod.getText().isBlank()) {
						mensaje = "Atencion: falta poner codigo";
						throw new Exception();

					} else if (actualizacion.getText().isEmpty() || actualizacion.getText().isBlank()) {
						mensaje = "Atencion: falta poner contenido de la actualizacion";
						throw new Exception();
					}
					// si no hay nada mal en el apartado de introducir los datos, pasamos a realizar
					// el cambio
					else {

						ButtonModel bm = grupo1.getSelection();
						columna = bm.getActionCommand();

						grupo1.clearSelection();

						int numeroCod = Integer.parseInt(cod.getText());

						if (conexion.modificarBeca(columna, numeroCod, actualizacion.getText().toUpperCase())) {
							JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito");
							cod.setText("");
							actualizacion.setText("");
						
							Log metodos = new Log();
							// muestra la informacion en el jtext de como ha quedado despues del cambio
							despuesModi.setText(conexion.informacionActualizacion(numeroCod, columna));
							// escribimos en el log el movimiento
							metodos.escribirLog(Tipo_movimiento.MODIFICAR_BECA);

						} else {
							JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna Beca");
						}

					}
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, mensaje);
				}

			}

		});

		/**
		 * Accion del boton comprobar nuevamente validamos que estan lo datos y
		 * selecciones necesarias para la busqueda y acontinuacion si esta todo en orden
		 * mostraremos la informacion que tiene el campo seleccionado para su posterior
		 * eliminacion con el boton aceptar
		 */
		comprobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
			
				int codigo = 0;
				String mensaje = "Atencion: solo son validos los numeros en ID";
				try {
					if (cod.getText().isBlank() || cod.getText().isEmpty()) {
						mensaje = "Atencion: Es necesario introducir el numero de codigo para la comprobacion";
						throw new Exception();
					} else if (!(nombre.isSelected() || condiciones.isSelected() || descripcion.isSelected()
							|| contacto.isSelected() || nombreProveedor.isSelected() || tipoBeca.isSelected())) {
						mensaje = "Atencion: Seleccione una columna para ver contenido";
						throw new Exception();
					}

					codigo = Integer.parseInt(cod.getText());

					ButtonModel aux = grupo1.getSelection();
					String columna = aux.getActionCommand();
					//mostramos los datos del campo que se quiere sondear para cambiar
					antesModi.setText(conexion.informacionActualizacion(codigo, columna));
					if (antesModi.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Atencion: no existe beca con esa ID");
					}
				

				} catch (SQLException e1) {

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, mensaje);
				}

			}
		});

	}
}
