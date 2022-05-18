package becapp.menus.gestionBecas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
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
import becapp.menus.metodos.MetodosMenus;

public class ModificarBeca extends JFrame {

	private Conexion_BBDD conexion;

	public ModificarBeca() {

		setTitle("MODIFICACION BECA");
		setBounds(500, 300, 600, 600);
		setResizable(false);
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		

		getContentPane().setLayout(null);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JButton atras = new JButton("ATRAS");
		atras.setBounds(50, 450, 100, 30);
		atras.setBackground(Color.orange);
		getContentPane().add(atras);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				GestionBecas gb = new GestionBecas();
				gb.setVisible(true);

			}
		});

		JTextPane codC = new JTextPane();
		codC.setText("ID");
		codC.setBounds(100, 30, 100, 19);
		getContentPane().add(codC);
		codC.setEditable(false);
		codC.setOpaque(false);

		JTextField cod = new JTextField();
		cod.setBounds(100, 60, 60, 19);
		getContentPane().add(cod);
		cod.setColumns(10);
		cod.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane antesModiC = new JTextPane();
		antesModiC.setText("Antes de modificaciones: ");
		antesModiC.setBounds(50, 210, 400, 19);
		getContentPane().add(antesModiC);
		antesModiC.setEditable(false);
		antesModiC.setOpaque(false);

		JTextField antesModi = new JTextField();
		antesModi.setBounds(50, 240, 500, 30);
		getContentPane().add(antesModi);
		antesModi.setColumns(10);
		antesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane despuesModiC = new JTextPane();
		despuesModiC.setText("Despues de modificaciones: ");
		despuesModiC.setBounds(50, 300, 400, 19);
		getContentPane().add(despuesModiC);
		despuesModiC.setEditable(false);
		despuesModiC.setOpaque(false);

		JTextField despuesModi = new JTextField();
		despuesModi.setBounds(50, 330, 500, 30);
		getContentPane().add(despuesModi);
		despuesModi.setColumns(10);
		despuesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane actualizacionC = new JTextPane();
		actualizacionC.setText("Actualizacion");
		actualizacionC.setBounds(250, 30, 200, 19);
		getContentPane().add(actualizacionC);
		actualizacionC.setEditable(false);
		actualizacionC.setOpaque(false);

		JTextField actualizacion = new JTextField();
		actualizacion.setBounds(250, 60, 250, 19);
		getContentPane().add(actualizacion);
		actualizacion.setColumns(10);
		actualizacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane columnaC = new JTextPane();
		columnaC.setText("Columnas");
		columnaC.setBounds(50, 100, 100, 19);
		getContentPane().add(columnaC);
		columnaC.setEditable(false);
		columnaC.setOpaque(false);

		JRadioButton nombre = new JRadioButton("nombre");
		nombre.setBounds(50, 130, 120, 23);
		getContentPane().add(nombre);
		nombre.setActionCommand("nombre");
		nombre.setOpaque(false);

		JRadioButton condiciones = new JRadioButton("condiciones");
		condiciones.setBounds(225, 130, 170, 23);
		getContentPane().add(condiciones);
		condiciones.setActionCommand("condiciones");
		condiciones.setOpaque(false);

		JRadioButton descripcion = new JRadioButton("descripcion");
		descripcion.setBounds(425, 130, 200, 23);
		getContentPane().add(descripcion);
		descripcion.setActionCommand("descripcion");
		descripcion.setOpaque(false);

		JRadioButton contacto = new JRadioButton("contacto");
		contacto.setBounds(50, 160, 120, 23);
		getContentPane().add(contacto);
		contacto.setActionCommand("contacto");
		contacto.setOpaque(false);

		JRadioButton nombreProveedor = new JRadioButton("proveedor");
		nombreProveedor.setBounds(225, 160, 120, 23);
		getContentPane().add(nombreProveedor);
		nombreProveedor.setActionCommand("nombreProveedor");
		nombreProveedor.setOpaque(false);

		JRadioButton tipoBeca = new JRadioButton("tipo beca");
		tipoBeca.setBounds(425, 160, 120, 23);
		getContentPane().add(tipoBeca);
		tipoBeca.setActionCommand("tipoBeca");
		tipoBeca.setOpaque(false);

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

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
				conexion.conectar();
				String mensaje = null;

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

					else {

						ButtonModel bm = grupo1.getSelection();
						columna = bm.getActionCommand();
						grupo1.clearSelection();
						int numeroCod = Integer.parseInt(cod.getText());

						if (conexion.modificarBeca(columna, numeroCod, actualizacion.getText().toUpperCase())) {
							JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito");
							cod.setText("");
							actualizacion.setText("");

							GregorianCalendar gc = new GregorianCalendar();
							Date fecha_hora = gc.getTime();
							Log metodos = new Log();

							despuesModi.setText(conexion.informacionActualizacion(numeroCod,columna));
							metodos.escribirLog(Tipo_movimiento.MODIFICAR_BECA, fecha_hora);

						} else {
							JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna Beca");
						}
						conexion.cerrar();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, mensaje);
				}

			}

		});

		JButton comprobar = new JButton("COMPROBAR ");
		comprobar.setBounds(225, 450, 150, 30);
		comprobar.setBackground(Color.orange);
		getContentPane().add(comprobar);
		comprobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
				conexion.conectar();
				int codigo = 0;
				String mensaje = "";
				try {
					if (cod.getText().isBlank() || cod.getText().isEmpty()) {
						mensaje = "Atencion: Es necesario introducir el numero de codigo para la comprobacion";
						throw new Exception();
					} else if (!(nombre.isSelected() || condiciones.isSelected() || descripcion.isSelected()
							|| contacto.isSelected() || nombreProveedor.isSelected() || tipoBeca.isSelected())) {
						mensaje  = "Atencion: Seleccione una columna para ver contenido";
						throw new Exception();
					}

					codigo = Integer.parseInt(cod.getText());

					ButtonModel aux = grupo1.getSelection();
					String columna = aux.getActionCommand();

					antesModi.setText(conexion.informacionActualizacion(codigo, columna));
					if (antesModi.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Atencion: no existe beca con esa ID");
					}
					conexion.cerrar();

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, mensaje);
				}

			}
		});

	}
}
