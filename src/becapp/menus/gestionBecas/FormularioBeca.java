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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import becapp.tipo_beca;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.Listado;
import becapp.menus.metodos.MetodosMenus;
import becapp.Beca;
import becapp.Conexion_BBDD;

public class FormularioBeca extends JFrame {

	private JTextField nombre;
	private JTextField condiciones;
	private JTextField descripcion;
	private JTextField nombreProveedor;
	private JTextField contacto;
	private JRadioButton privada;
	private JRadioButton publica;
	private Beca beca;
	private Conexion_BBDD conexion;

	public FormularioBeca() {

		setTitle("FORMULARIO BECA");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setBounds(500, 300, 800, 500);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JTextPane nombreC = new JTextPane();
		nombreC.setText("Nombre");
		nombreC.setBounds(100, 20, 114, 19);
		getContentPane().add(nombreC);
		nombreC.setEditable(false);
		nombreC.setOpaque(false);

		nombre = new JTextField();
		nombre.setBounds(100, 50, 150, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));

		JTextPane condicionesC = new JTextPane();
		condicionesC.setText("Condiciones");
		condicionesC.setBounds(100, 80, 114, 19);
		getContentPane().add(condicionesC);
		condicionesC.setEditable(false);
		condicionesC.setOpaque(false);

		condiciones = new JTextField();
		condiciones.setBounds(100, 110, 250, 19);
		getContentPane().add(condiciones);
		condiciones.setColumns(10);
		condiciones.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));

		JTextPane descripcionC = new JTextPane();
		descripcionC.setText("Descripcion");
		descripcionC.setBounds(100, 140, 114, 19);
		getContentPane().add(descripcionC);
		descripcionC.setEditable(false);
		descripcionC.setOpaque(false);

		descripcion = new JTextField();
		descripcion.setBounds(100, 170, 250, 19);
		getContentPane().add(descripcion);
		descripcion.setColumns(10);
		descripcion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));

		JTextPane nombreProveedorC = new JTextPane();
		nombreProveedorC.setText("Nombre proveedor");
		nombreProveedorC.setBounds(450, 20, 250, 19);
		getContentPane().add(nombreProveedorC);
		nombreProveedorC.setEditable(false);
		nombreProveedorC.setOpaque(false);

		nombreProveedor = new JTextField();
		nombreProveedor.setBounds(450, 50, 250, 19);
		getContentPane().add(nombreProveedor);
		nombreProveedor.setColumns(10);
		nombreProveedor.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));

		JTextPane contactoC = new JTextPane();
		contactoC.setText("Contacto");
		contactoC.setBounds(450, 80, 114, 19);
		getContentPane().add(contactoC);
		contactoC.setEditable(false);
		contactoC.setOpaque(false);

		contacto = new JTextField();
		contacto.setBounds(450, 110, 250, 19);
		getContentPane().add(contacto);
		contacto.setColumns(10);
		contacto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));

		JTextPane tipoBecaC = new JTextPane();
		tipoBecaC.setText("Tipo de beca");
		tipoBecaC.setBounds(450, 140, 114, 19);
		getContentPane().add(tipoBecaC);
		tipoBecaC.setEditable(false);
		tipoBecaC.setOpaque(false);

		privada = new JRadioButton("Privada");
		privada.setBounds(450, 170, 149, 23);
		getContentPane().add(privada);
		privada.setOpaque(false);

		publica = new JRadioButton("Publica");
		publica.setBounds(600, 170, 149, 23);
		getContentPane().add(publica);
		publica.setOpaque(false);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(privada);
		grupo1.add(publica);

		JButton salir = new JButton("ATRAS");
		salir.setBounds(100, 400, 100, 30);
		getContentPane().add(salir);
		salir.setBackground(Color.ORANGE);

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// con dispose cerramos el constructor en ejecucion ventana y como hemos pulsado
				// el boton se abra la siguiente ventana
				dispose();
				GestionBecas becas = new GestionBecas();
				becas.setVisible(true);

			}

		});

		JTextPane informacionC = new JTextPane();
		informacionC.setText("Ultima beca añadida");
		informacionC.setBounds(100, 240, 250, 30);
		getContentPane().add(informacionC);
		informacionC.setEditable(false);
		informacionC.setOpaque(false);

		JTextArea informacion = new JTextArea();
		informacion.setBounds(new Rectangle(100, 270, 600, 30));
		informacion.setEditable(false);
		informacion.setVisible(true);
		informacion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));
		getContentPane().add(informacion);

		JButton BBDD = new JButton("BBDD");
		BBDD.setBounds(450, 400, 100, 30);
		getContentPane().add(BBDD);
		BBDD.setBackground(Color.ORANGE);

		BBDD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String[] columnas = { "Codigo", "Nombre", "Condiciones", "Descripcion", "Proveedor", "Contacto",
						"Tipo de Beca"};
				Listado listado = new Listado(false,columnas,"beca");
				
				listado.setTitle("Datos Becas");
				listado.pack();
				listado.setVisible(true);

			}

		});

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(600, 400, 100, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.ORANGE);
		// accion de aceptar la entrada de datos

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tipo_beca tipo = null;

				conexion = new Conexion_BBDD();

				// comprueba que este seleccionado alguno de nuestros radio buttons
				try {
					if (nombre.getText().isBlank() || nombre.getText().isBlank() || nombre.getText().isBlank()
							|| nombre.getText().isBlank() || nombre.getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Atencion: Algun campo en blanco");
						throw new Exception();
					}

						if (privada.isSelected() || publica.isSelected()) {
							if (privada.isSelected()) {
								tipo = tipo_beca.PRIVADA;
							} else {
								tipo = tipo_beca.PUBLICA;

							}

						} else {
							// en caso contrario levanto una expcecion y controlo la ejecucion del metodo
							JOptionPane.showMessageDialog(null, "Atencion: obligatorio elegir beca publica o privada");
							throw new Exception();

						}

					beca = new Beca(nombre.getText().toUpperCase(), condiciones.getText().toUpperCase(),
							descripcion.getText().toUpperCase(), contacto.getText().toUpperCase(),
							nombreProveedor.getText().toUpperCase(), tipo);

					conexion.conectar();
					informacion.setText(beca.toString());
					//
					if (conexion.aniadirBeca(beca)) {

						JOptionPane.showMessageDialog(null, "Beca añadida con exito");
						informacion.setText(beca.toString());

						GregorianCalendar gc = new GregorianCalendar();
						Date fecha_hora = gc.getTime();

						try {

							Log metodos = new Log();
							metodos.escribirLog(Tipo_movimiento.INTRODUCIR_BECA, fecha_hora);
						} catch (IOException elog) {
							elog.getStackTrace();
						}

					} else {
						informacion.setText("Error: Problemas a la hora de cargar la beca");
					}

					nombre.setText("");
					condiciones.setText("");
					descripcion.setText("");
					contacto.setText("");
					nombreProveedor.setText("");

					grupo1.clearSelection();

					try {
						conexion.cerrar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} catch (Exception e1) {
					// en la excepcion abrimos un cuadro de diaglo indicando el problema
				

				}

			}
		});

		JButton limpiar = new JButton("LIMPIAR");
		limpiar.setBounds(250, 400, 100, 30);
		getContentPane().add(limpiar);
		limpiar.setBackground(Color.ORANGE);

		limpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				nombre.setText("");
				condiciones.setText("");
				descripcion.setText("");
				contacto.setText("");
				nombreProveedor.setText("");
				grupo1.clearSelection();

			}

		});

	}

}
