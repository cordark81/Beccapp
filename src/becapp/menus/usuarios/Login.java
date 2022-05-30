package becapp.menus.usuarios;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import becapp.Conexion_BBDD;
import becapp.menus.PrincipalGestion;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.invitados.MenuInvitados;
import becapp.menus.metodos.FondoLogin;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;
import java.awt.Color;

/**
 * 
 * @author Eduardo y Arturo
 *
 */
public class Login extends JFrame {

	private JPasswordField passwordField;

	public Login() {

		/**
		 * Admin:
		 * 
		 * ANTONIOOTONGONZALEZ@YAHOO.COM
		 * 
		 * 
		 * 
		 * User: MARIAALONSOCARMONA@GMAIL.COM Passw0rd
		 * 
		 * 
		 */

		setTitle("BECAPP");
		setBounds(200, 100, 800, 620);
		getContentPane().setLayout(null);
		setFont(new Font("Roboto", Font.PLAIN, 14));

		ImagenFondo fondo = new ImagenFondo("/imagenes/Definitivo.png");
		setContentPane(fondo);
		fondo.setLayout(null);

		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JTextPane nombreC = new JTextPane();
		nombreC.setForeground(Color.WHITE);
		nombreC.setText("Nombre");
		nombreC.setBounds(406, 132, 114, 19);
		getContentPane().add(nombreC);
		nombreC.setEditable(false);
		nombreC.setOpaque(false);
		nombreC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextField nombre = new JTextField();
		nombre.setBounds(363, 162, 150, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		nombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane claveC = new JTextPane();
		claveC.setForeground(Color.WHITE);
		claveC.setText("Clave");
		claveC.setBounds(414, 192, 49, 19);
		getContentPane().add(claveC);
		claveC.setEditable(false);
		claveC.setOpaque(false);
		claveC.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton login = new JButton("Login");
		login.setBounds(388, 263, 100, 30);
		getContentPane().add(login);
		login.setFont(new Font("Roboto", Font.PLAIN, 14));

		passwordField = new JPasswordField();
		passwordField.setBounds(363, 222, 150, 19);
		fondo.add(passwordField);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		/**
		 * Accion para el boton de verificación de los credencias
		 */

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String usuario = nombre.getText();
				String contrasena = passwordField.getText();
				Conexion_BBDD connection = new Conexion_BBDD();

				int resultado;
				// este metodo recibe los datos dados por el usuario en el formulario y los
				// checkea
				resultado = connection.loginUsuario(usuario, contrasena);

				if (resultado == 1) {
					// acceso a usuario
					JOptionPane.showMessageDialog(null, "Bienvenido a Becapp", "Mensaje de bienvenida",
							JOptionPane.INFORMATION_MESSAGE);
					MenuUsuario ventana = new MenuUsuario();
					ventana.setVisible(true);
					dispose();

					Log log = new Log();

					try {
						// registamos en el log la accion
						log.escribirLog(Tipo_movimiento.LOGIN);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (resultado == 2) {
					// acceso a menu gestión
					JOptionPane.showMessageDialog(null, "Bienvenido a Becapp", "Mensaje de bienvenida",
							JOptionPane.INFORMATION_MESSAGE);
					PrincipalGestion ventana = new PrincipalGestion();
					ventana.setVisible(true);
					dispose();

					Log log = new Log();

					try {
						log.escribirLog(Tipo_movimiento.LOGIN);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Acceso denegado:\n" + "Por favor ingrese un usuario y/o contrase�a correctos",
							"Acceso denegado", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton registro = new JButton("Registrate");
		registro.setBounds(388, 315, 100, 15);
		getContentPane().add(registro);
		registro.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton invitados = new JButton("Accede como invitado");
		invitados.setBounds(600, 40, 150, 20);
		getContentPane().add(invitados);
		invitados.setFont(new Font("Roboto", Font.PLAIN, 14));

		/**
		 * accion para el boton pasar como invitado
		 */
		invitados.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuInvitados ventana = new MenuInvitados();
				ventana.setVisible(true);
				dispose();

			}

		});

		/*
		 * accion para el boton de registrar usuario
		 */
		registro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistroUsuarios ventana = new RegistroUsuarios();
				ventana.setVisible(true);
				dispose();

			}

		});

	}

}
