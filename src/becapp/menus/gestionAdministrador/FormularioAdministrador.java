package becapp.menus.gestionAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

import becapp.Administrador;
import becapp.Conexion_BBDD;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.Listado;
import becapp.menus.metodos.MetodosMenus;

public class FormularioAdministrador extends JFrame {

	public FormularioAdministrador() {

		setTitle("FORMULARIO ADMINISTRADOR");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setBounds(500, 300, 800, 650);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});
		JTextPane dniC = new JTextPane();
		dniC.setText("Dni");
		dniC.setBounds(100, 20, 114, 19);
		getContentPane().add(dniC);
		dniC.setEditable(false);
		dniC.setOpaque(false);

		JTextField dni = new JTextField();
		dni.setBounds(100, 50, 150, 19);
		getContentPane().add(dni);
		dni.setColumns(10);
		dni.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane nombreC = new JTextPane();
		nombreC.setText("Nombre");
		nombreC.setBounds(100, 80, 114, 19);
		getContentPane().add(nombreC);
		nombreC.setEditable(false);
		nombreC.setOpaque(false);

		JTextField nombre = new JTextField();
		nombre.setBounds(100, 110, 250, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane apellidoC = new JTextPane();
		apellidoC.setText("Apellido");
		apellidoC.setBounds(100, 140, 114, 19);
		getContentPane().add(apellidoC);
		apellidoC.setEditable(false);
		apellidoC.setOpaque(false);

		JTextField apellido = new JTextField();
		apellido.setBounds(100, 170, 250, 19);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		apellido.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane nacionalidadC = new JTextPane();
		nacionalidadC.setText("Nacionalidad");
		nacionalidadC.setBounds(450, 20, 150, 19);
		getContentPane().add(nacionalidadC);
		nacionalidadC.setEditable(false);
		nacionalidadC.setOpaque(false);

		JTextField nacionalidad = new JTextField();
		nacionalidad.setBounds(450, 50, 250, 19);
		getContentPane().add(nacionalidad);
		nacionalidad.setColumns(10);
		nacionalidad.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane emailC = new JTextPane();
		emailC.setText("Email");
		emailC.setBounds(450, 80, 114, 19);
		getContentPane().add(emailC);
		emailC.setEditable(false);
		emailC.setOpaque(false);

		JTextField email = new JTextField();
		email.setBounds(450, 110, 250, 19);
		getContentPane().add(email);
		email.setColumns(10);
		email.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane telfC = new JTextPane();
		telfC.setText("Telefono");
		telfC.setBounds(450, 140, 114, 19);
		getContentPane().add(telfC);
		telfC.setEditable(false);
		telfC.setOpaque(false);

		JTextField telf = new JTextField();
		telf.setBounds(450, 170, 250, 19);
		getContentPane().add(telf);
		telf.setColumns(10);
		telf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane fecha_nacC = new JTextPane();
		fecha_nacC.setText("Fecha de nacimiento");
		fecha_nacC.setBounds(100, 200, 250, 19);
		getContentPane().add(fecha_nacC);
		fecha_nacC.setEditable(false);
		fecha_nacC.setOpaque(false);

		JTextPane claveC = new JTextPane();
		claveC.setText("Clave");
		claveC.setBounds(450, 200, 150, 19);
		getContentPane().add(claveC);
		claveC.setEditable(false);
		claveC.setOpaque(false);

		JTextField clave = new JTextField();
		clave.setBounds(450, 230, 100, 19);
		getContentPane().add(clave);
		clave.setColumns(10);
		clave.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane estadoC = new JTextPane();
		estadoC.setText("Estado");
		estadoC.setBounds(100, 260, 150, 19);
		getContentPane().add(estadoC);
		estadoC.setEditable(false);
		estadoC.setOpaque(false);

		String[] optionsToChoose = { "Activo", "No activo" };

		JComboBox<String> estado = new JComboBox<>(optionsToChoose);
		estado.setBounds(100, 290, 100, 19);
		getContentPane().add(estado);
		estado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane descipcion_puestoC = new JTextPane();
		descipcion_puestoC.setText("Descripcion puesto");
		descipcion_puestoC.setBounds(450, 260, 150, 19);
		getContentPane().add(descipcion_puestoC);
		descipcion_puestoC.setEditable(false);
		descipcion_puestoC.setOpaque(false);

		JTextField descripcion_puesto = new JTextField();
		descripcion_puesto.setBounds(450, 290, 250, 19);
		getContentPane().add(descripcion_puesto);
		descripcion_puesto.setColumns(10);
		descripcion_puesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JTextPane ultimoAdminitradorC = new JTextPane();
		ultimoAdminitradorC.setText("Ultimo Administrador añadido");
		ultimoAdminitradorC.setBounds(100, 350, 300, 19);
		getContentPane().add(ultimoAdminitradorC);
		ultimoAdminitradorC.setEditable(false);
		ultimoAdminitradorC.setOpaque(false);

		JTextField ultimoAdministrador = new JTextField();
		ultimoAdministrador.setBounds(100, 380, 600, 38);
		getContentPane().add(ultimoAdministrador);
		ultimoAdministrador.setColumns(10);
		ultimoAdministrador.setEditable(false);
		ultimoAdministrador.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));

		JDateChooser jdc = new JDateChooser();
		jdc.setDateFormatString("d/MM/y");
		jdc.setBounds(100, 230, 224, 19);
		fondo.add(jdc);
		jdc.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		

		JButton salir = new JButton("ATRAS");
		salir.setBounds(100, 550, 100, 30);
		getContentPane().add(salir);
		salir.setBackground(Color.orange);

		JButton limpiar = new JButton("LIMPIAR");
		limpiar.setBounds(450, 550, 100, 30);
		getContentPane().add(limpiar);
		limpiar.setBackground(Color.orange);

		limpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dni.setText("");
				nombre.setText("");
				apellido.setText("");
				jdc.setCalendar(null);
				nacionalidad.setText("");
				email.setText("");
				telf.setText("");
				clave.setText("");
				descripcion_puesto.setText("");
			}
		});

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// con dispose cerramos el constructor en ejecucion ventana y como hemos pulsado
				// el boton se abra la siguiente ventana
				dispose();
				GestionAdministradores ga = new GestionAdministradores();
				ga.setVisible(true);

			}

		});

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(600, 550, 100, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.orange);

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Conexion_BBDD conexion = new Conexion_BBDD();
				conexion.conectar();
				try {

					if (dni.getText().isBlank() || nombre.getText().isBlank() || apellido.getText().isBlank()
							|| nacionalidad.getText().isBlank() || email.getText().isBlank() || telf.getText().isBlank()
							|| clave.getText().isBlank() || descripcion_puesto.getText().isBlank()) {
						throw new Exception();
					}

					Date fechaCalendario = jdc.getDate();
					DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					String fecha = f.format(fechaCalendario);

					int telefono = Integer.parseInt(telf.getText());

					Administrador admin = new Administrador(dni.getText().toUpperCase(), nombre.getText().toUpperCase(),
							apellido.getText().toUpperCase(), nacionalidad.getText().toUpperCase(),
							email.getText().toUpperCase(), telefono, fecha, clave.getText().toUpperCase(),
							estado.getSelectedItem().toString().toUpperCase(),
							descripcion_puesto.getText().toUpperCase());

					if (conexion.darAltaAdmin(admin)) {

						JOptionPane.showMessageDialog(null, "Administrador añadido con exito");
						ultimoAdministrador.setText(admin.toString());
						dni.setText("");
						nombre.setText("");
						apellido.setText("");
						jdc.setCalendar(null);
						nacionalidad.setText("");
						email.setText("");
						telf.setText("");
						clave.setText("");
						descripcion_puesto.setText("");

						GregorianCalendar gc = new GregorianCalendar();
						Date fecha_hora = gc.getTime();

						try {

							Log metodos = new Log();
							metodos.escribirLog(Tipo_movimiento.INTRODUCIR_ADMINISTRADOR, fecha_hora);
						} catch (IOException elog) {
							elog.getStackTrace();
						}

					} else {

						JOptionPane.showMessageDialog(null, "Error: la Beca no se ha podido añadir");

					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Atenccion: letras en el numero de telefono");
				}

				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Atenccion: algun campo vacio");
				}
			}
		});

		JButton listado = new JButton("Ver BBDD");
		listado.setBounds(250, 550, 100, 30);
		getContentPane().add(listado);
		listado.setBackground(Color.orange);
		// intento de poner un icono en boton no fuciona probar con otra foto
		// listado.setSelectedIcon(new
		// ImageIcon(getClass().getResource("/imagenes/tabla.jpg")));

		listado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String[] columnas = { "ID", "DNI", "Nombre", "Apellido", "Nacionalidad", "Email", "Telefono",
						"Fecha  nacimientos", "Clave", "Estado", "Descripcion puesto", "Fecha alta" };

				Listado listado = new Listado(false, columnas, "administrador");
				listado.setVisible(true);
				listado.setTitle("Datos administradores");
				listado.pack();

			}
		});

	}
}
