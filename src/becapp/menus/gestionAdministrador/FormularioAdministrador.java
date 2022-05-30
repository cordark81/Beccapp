package becapp.menus.gestionAdministrador;

import java.awt.Color;
import java.awt.Font;
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

/**
 * 
 *  @author Eduardo y Arturo
 *
 */

public class FormularioAdministrador extends JFrame {

	public FormularioAdministrador() {

		setTitle("FORMULARIO ADMINISTRADOR");
		ImagenFondo fondo = new ImagenFondo("/imagenes/tabla.jpg");
		setContentPane(fondo);
		setBounds(500, 300, 800, 650);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane dniC = new JTextPane();
		dniC.setText("Dni");
		dniC.setBounds(100, 20, 114, 19);
		getContentPane().add(dniC);
		dniC.setEditable(false);
		dniC.setOpaque(false);
		dniC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField dni = new JTextField();
		dni.setBounds(100, 50, 150, 19);
		getContentPane().add(dni);
		dni.setColumns(10);
		dni.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		dni.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane nombreC = new JTextPane();
		nombreC.setText("Nombre");
		nombreC.setBounds(100, 80, 114, 19);
		getContentPane().add(nombreC);
		nombreC.setEditable(false);
		nombreC.setOpaque(false);
		nombreC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField nombre = new JTextField();
		nombre.setBounds(100, 110, 250, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		nombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		nombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane apellidoC = new JTextPane();
		apellidoC.setText("Apellido");
		apellidoC.setBounds(100, 140, 114, 19);
		getContentPane().add(apellidoC);
		apellidoC.setEditable(false);
		apellidoC.setOpaque(false);
		apellidoC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField apellido = new JTextField();
		apellido.setBounds(100, 170, 250, 19);
		getContentPane().add(apellido);
		apellido.setColumns(10);
		apellido.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		apellido.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane nacionalidadC = new JTextPane();
		nacionalidadC.setText("Nacionalidad");
		nacionalidadC.setBounds(450, 20, 150, 19);
		getContentPane().add(nacionalidadC);
		nacionalidadC.setEditable(false);
		nacionalidadC.setOpaque(false);
		nacionalidadC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField nacionalidad = new JTextField();
		nacionalidad.setBounds(450, 50, 250, 19);
		getContentPane().add(nacionalidad);
		nacionalidad.setColumns(10);
		nacionalidad.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		nacionalidad.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane emailC = new JTextPane();
		emailC.setText("Email");
		emailC.setBounds(450, 80, 114, 19);
		getContentPane().add(emailC);
		emailC.setEditable(false);
		emailC.setOpaque(false);
		emailC.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JTextField email = new JTextField();
		email.setBounds(450, 110, 250, 19);
		getContentPane().add(email);
		email.setColumns(10);
		email.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		email.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane telfC = new JTextPane();
		telfC.setText("Telefono");
		telfC.setBounds(450, 140, 114, 19);
		getContentPane().add(telfC);
		telfC.setEditable(false);
		telfC.setOpaque(false);
		telfC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField telf = new JTextField();
		telf.setBounds(450, 170, 250, 19);
		getContentPane().add(telf);
		telf.setColumns(10);
		telf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		telf.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JTextPane fecha_nacC = new JTextPane();
		fecha_nacC.setText("Fecha de nacimiento");
		fecha_nacC.setBounds(100, 200, 250, 19);
		getContentPane().add(fecha_nacC);
		fecha_nacC.setEditable(false);
		fecha_nacC.setOpaque(false);
		fecha_nacC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane claveC = new JTextPane();
		claveC.setText("Clave");
		claveC.setBounds(450, 200, 150, 19);
		getContentPane().add(claveC);
		claveC.setEditable(false);
		claveC.setOpaque(false);
		claveC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField clave = new JTextField();
		clave.setBounds(450, 230, 100, 19);
		getContentPane().add(clave);
		clave.setColumns(10);
		clave.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		clave.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane estadoC = new JTextPane();
		estadoC.setText("Estado");
		estadoC.setBounds(100, 260, 150, 19);
		getContentPane().add(estadoC);
		estadoC.setEditable(false);
		estadoC.setOpaque(false);
		estadoC.setFont(new Font("Roboto", Font.PLAIN, 14));

		String[] optionsToChoose = { "Activo", "No activo" };

		JComboBox<String> estado = new JComboBox<>(optionsToChoose);
		estado.setBounds(100, 290, 100, 19);
		getContentPane().add(estado);
		estado.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		estado.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane descipcion_puestoC = new JTextPane();
		descipcion_puestoC.setText("Descripcion puesto");
		descipcion_puestoC.setBounds(450, 260, 150, 19);
		getContentPane().add(descipcion_puestoC);
		descipcion_puestoC.setEditable(false);
		descipcion_puestoC.setOpaque(false);
		descipcion_puestoC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField descripcion_puesto = new JTextField();
		descripcion_puesto.setBounds(450, 290, 250, 19);
		getContentPane().add(descripcion_puesto);
		descripcion_puesto.setColumns(10);
		descripcion_puesto.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		descripcion_puesto.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane ultimoAdminitradorC = new JTextPane();
		ultimoAdminitradorC.setText("Ultimo Administrador añadido");
		ultimoAdminitradorC.setBounds(100, 350, 300, 19);
		getContentPane().add(ultimoAdminitradorC);
		ultimoAdminitradorC.setEditable(false);
		ultimoAdminitradorC.setOpaque(false);
		ultimoAdminitradorC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField ultimoAdministrador = new JTextField();
		ultimoAdministrador.setBounds(100, 380, 600, 38);
		getContentPane().add(ultimoAdministrador);
		ultimoAdministrador.setColumns(10);
		ultimoAdministrador.setEditable(false);
		ultimoAdministrador.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		ultimoAdministrador.setEditable(false);
		ultimoAdministrador.setFont(new Font("Roboto", Font.PLAIN, 14));

		// boton estrella con funcinaliidad de calendario, fuentes importadas
		JDateChooser jdc = new JDateChooser();
		jdc.setDateFormatString("d/MM/y");
		jdc.setBounds(100, 230, 224, 19);
		fondo.add(jdc);
		jdc.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
		jdc.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton limpiar = new JButton("LIMPIAR");
		limpiar.setBounds(350, 550, 100, 30);
		getContentPane().add(limpiar);
		limpiar.setBackground(Color.orange);
		limpiar.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton listado = new JButton("Ver BBDD");
		listado.setBounds(100, 550, 100, 30);
		getContentPane().add(listado);
		listado.setBackground(Color.orange);
		listado.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setBounds(600, 550, 100, 30);
		getContentPane().add(aceptar);
		aceptar.setBackground(Color.orange);
		aceptar.setFont(new Font("Roboto", Font.PLAIN, 14));

		/**
		 * Accion del boton limpiar para resetear la entrada de datos
		 */

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

		/**
		 * Accion del boton aceptar en cual validamos la entrada de los datos
		 * introducidos en los correspondientes campos
		 */

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Conexion_BBDD conexion = new Conexion_BBDD();
			
				
				try {
					// comprobramos que no hay campos en blanco
					if (dni.getText().isBlank() || nombre.getText().isBlank() || apellido.getText().isBlank()
							|| nacionalidad.getText().isBlank() || email.getText().isBlank() || telf.getText().isBlank()
							|| clave.getText().isBlank() || descripcion_puesto.getText().isBlank()) {
						// mostramos mensaje y cortamos la ejecucion del codigo
						throw new Exception();
					}
					// cogemos el dato de la fecha y lo formateamos para darselo al constructor
					Date fechaCalendario = jdc.getDate();
					DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					String fecha = f.format(fechaCalendario);

					int telefono = Integer.parseInt(telf.getText());
					// completamos el objeto beca con los datos recogidos
					Administrador admin = new Administrador(dni.getText().toUpperCase(), clave.getText(),
							nombre.getText().toUpperCase(), apellido.getText().toUpperCase(),
							nacionalidad.getText().toUpperCase(), email.getText().toUpperCase(), telefono, fecha,
							estado.getSelectedItem().toString().toUpperCase(), descripcion_puesto.getText().toUpperCase());
							

					if (conexion.darAltaAdmin(admin)) {

						JOptionPane.showMessageDialog(null, "Administrador añadido con exito");
						ultimoAdministrador.setText(admin.toString());
						// limpeza automatica
						dni.setText("");
						nombre.setText("");
						apellido.setText("");
						jdc.setCalendar(null);
						nacionalidad.setText("");
						email.setText("");
						telf.setText("");
						clave.setText("");
						descripcion_puesto.setText("");
				
						try {

							Log metodos = new Log();
							// metodo de escritura en el fichero log
							metodos.escribirLog(Tipo_movimiento.INTRODUCIR_ADMINISTRADOR);
						} catch (IOException elog) {
							elog.getStackTrace();
						}

					} else {

						JOptionPane.showMessageDialog(null, "Error: el administrador no se ha podido añadir");

					}
					// excepction para el numero de teleno
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Atenccion: letras en el numero de telefono");
				}

				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Atenccion: algun campo vacio");
				}
			}
		});

		/**
		 * Accion del boton de consulta a la base de datos, genera una tabla con la
		 * informacion de la tabla
		 */

		listado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// columnas de la tabla
				String[] columnas = { "ID", "Estado", "Descripcion puesto", "Fecha inicio", "Fecha nacimiento", "Clave",
						"Email", "Nombre", "Apellido", "Dni", "Nacionalidad", "Telefono" };
				// constructor que genera la tabla
				Listado listado = new Listado(false, columnas, "administrador");
				listado.setVisible(true);
				listado.setTitle("Datos administradores");
				listado.pack();

			}
		});

	}
}
