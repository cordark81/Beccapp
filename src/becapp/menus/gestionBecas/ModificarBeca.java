package becapp.menus.gestionBecas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import becapp.menus.metodos.MetodosMenus;

public class ModificarBeca extends JFrame {

	private Conexion_BBDD conexion;

	public ModificarBeca() {

		setTitle("MODIFICACION BECA");
		setBounds(500, 300, 600, 600);
		getContentPane().setLayout(null);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JButton atras = new JButton("ATRAS");
		atras.setBounds(100, 450, 100, 30);
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
		codC.setText("Numero de id");
		codC.setBounds(100, 30, 100, 19);
		getContentPane().add(codC);
		codC.setEditable(false);
		codC.setOpaque(false);

		JTextField cod = new JTextField();
		cod.setBounds(100, 60, 60, 19);
		getContentPane().add(cod);
		cod.setColumns(10);

		JTextPane antesModiC = new JTextPane();
		antesModiC.setText("Antes de modificaciones: ");
		antesModiC.setBounds(100, 210, 250, 19);
		getContentPane().add(antesModiC);
		antesModiC.setEditable(false);
		antesModiC.setOpaque(false);

		JTextField antesModi = new JTextField();
		antesModi.setBounds(50, 240, 500, 30);
		getContentPane().add(antesModi);
		antesModi.setColumns(10);
		antesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));

		JTextPane despuesModiC = new JTextPane();
		despuesModiC.setText("Despues de modificaciones: ");
		despuesModiC.setBounds(100, 300, 250, 19);
		getContentPane().add(despuesModiC);
		despuesModiC.setEditable(false);
		despuesModiC.setOpaque(false);

		JTextField despuesModi = new JTextField();
		despuesModi.setBounds(100, 330, 400, 30);
		getContentPane().add(despuesModi);
		despuesModi.setColumns(10);
		despuesModi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));

		JTextPane actualizacionC = new JTextPane();
		actualizacionC.setText("Actualizacion");
		actualizacionC.setBounds(250, 30, 100, 19);
		getContentPane().add(actualizacionC);
		actualizacionC.setEditable(false);
		actualizacionC.setOpaque(false);

		JTextField actualizacion = new JTextField();
		actualizacion.setBounds(250, 60, 250, 19);
		getContentPane().add(actualizacion);
		actualizacion.setColumns(10);

		JTextPane columnaC = new JTextPane();
		columnaC.setText("Columna");
		columnaC.setBounds(100, 100, 100, 19);
		getContentPane().add(columnaC);
		columnaC.setEditable(false);
		columnaC.setOpaque(false);

		JRadioButton nombre = new JRadioButton("nombre");
		nombre.setBounds(100, 130, 120, 23);
		getContentPane().add(nombre);
		nombre.setActionCommand("nombre");

		JRadioButton condiciones = new JRadioButton("condiciones");
		condiciones.setBounds(225, 130, 120, 23);
		getContentPane().add(condiciones);
		condiciones.setActionCommand("condiciones");

		JRadioButton descripcion = new JRadioButton("descripcion");
		descripcion.setBounds(350, 130, 120, 23);
		getContentPane().add(descripcion);
		descripcion.setActionCommand("descripcion");

		JRadioButton contacto = new JRadioButton("contacto");
		contacto.setBounds(100, 160, 120, 23);
		getContentPane().add(contacto);
		contacto.setActionCommand("contacto");

		JRadioButton nombreProveedor = new JRadioButton("proveedor");
		nombreProveedor.setBounds(225, 160, 120, 23);
		getContentPane().add(nombreProveedor);
		nombreProveedor.setActionCommand("nombreProveedor");

		JRadioButton tipoBeca = new JRadioButton("tipo beca");
		tipoBeca.setBounds(350, 160, 120, 23);
		getContentPane().add(tipoBeca);
		tipoBeca.setActionCommand("tipoBeca");

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(nombre);
		grupo1.add(condiciones);
		grupo1.add(descripcion);
		grupo1.add(contacto);
		grupo1.add(nombreProveedor);
		grupo1.add(tipoBeca);

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(400, 450, 100, 30);
		getContentPane().add(aceptar);

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
				conexion.conectar();

				String columna;

				// con null devuelve true si no esta seleccionado
				try {

					if (grupo1.isSelected(null)) {

						throw new Exception();
					}

					else if (cod.getText().isEmpty() || cod.getText().isBlank()) {

						throw new Exception();

					} else if (actualizacion.getText().isEmpty() || actualizacion.getText().isBlank()) {
						throw new Exception();
					}

					else {

						ButtonModel bm = grupo1.getSelection();
						columna = bm.getActionCommand();
						grupo1.clearSelection();
						int numeroCod = Integer.parseInt(cod.getText());

						if (conexion.modificarBeca(columna, numeroCod, actualizacion.getText().toUpperCase())) {
							JOptionPane.showMessageDialog(null, "Actualizacion realizada con exito");

							GregorianCalendar gc = new GregorianCalendar();
							Date fecha_hora = gc.getTime();
							Log metodos = new Log();

							despuesModi.setText(conexion.informacionActualizacion(numeroCod));
							metodos.escribirLog(Tipo_movimiento.MODIFICAR_BECA, fecha_hora, despuesModi.getText());

						} else {
							JOptionPane.showMessageDialog(null, "Error: al realizar la actualización");
						}
						conexion.cerrar();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Atencion: Algun campo esta vacio");
				}

			}

		});

		JButton comprobar = new JButton("COMPROBAR ");
		comprobar.setBounds(225, 450, 150, 30);
		getContentPane().add(comprobar);
		comprobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				conexion = new Conexion_BBDD();
				conexion.conectar();
				int codigo = 0;

				try {
					if (cod.getText().isBlank() || cod.getText().isEmpty()) {
						throw new Exception();
					} else {

						codigo = Integer.parseInt(cod.getText());
					}

					antesModi.setText(conexion.informacionActualizacion(codigo));
					conexion.cerrar();

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Atencion: Es necesario introducir el numero de codigo para la comprobarcion");
				}

			}
		});

	}
}
