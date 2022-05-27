package becapp.menus.usuarios;



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
import becapp.menus.metodos.FondoLogin;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;

public class Login extends JFrame{
	
	private JPasswordField passwordField;

	public Login(){
		
		/**
		 * Admin:
		 * 
		 * ANTONIOOTONGONZALEZ@YAHOO.COM
		 * Passw0rd
		 * 
		 * 
		 * User:
		 * MARIAALONSOCARMONA@GMAIL.COM
		 * Passw0rd
		 * 
		 * 
		 */

		setTitle("BECAPP");
		setBounds(200, 100, 800, 620);
		getContentPane().setLayout(null);

		ImagenFondo fondo = 
		new ImagenFondo("/imagenes/Logo.png");
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
		nombreC.setText("Nombre");
		nombreC.setBounds(543, 205, 114, 19);
		getContentPane().add(nombreC);
		nombreC.setEditable(false);
		nombreC.setOpaque(false);

		JTextField nombre = new JTextField();
		nombre.setBounds(495, 225, 150, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);

		JTextPane claveC = new JTextPane();
		claveC.setText("Clave");
		claveC.setBounds(550, 275, 114, 19);
		getContentPane().add(claveC);
		claveC.setEditable(false);
		claveC.setOpaque(false);

		JButton login = new JButton("Login");
		login.setBounds(520, 350, 100, 30);
		getContentPane().add(login);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(495, 295, 150, 19);
		fondo.add(passwordField);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String usuario = nombre.getText();
				String contraseña = passwordField.getText();
				Conexion_BBDD connection = new Conexion_BBDD();
				connection.conectar();
				
				int resultado;
				
				resultado=connection.loginUsuario(usuario, contraseña);
				
				if(resultado==1){

					JOptionPane.showMessageDialog(null, "Bienvenido a Becapp", "Mensaje de bienvenida",
					JOptionPane.INFORMATION_MESSAGE);
					MenuUsuario ventana = new MenuUsuario();          
					ventana.setVisible(true);
					dispose();
					
				
					Log log = new Log();
					
					try {
						log.escribirLog(Tipo_movimiento.LOGIN);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else if(resultado==2) {
					
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
				}
				else {
					JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
							+ "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		JButton registro = new JButton("Registrate");
		registro.setBounds(520, 400, 100, 15);
		getContentPane().add(registro);

		JButton invitados = new JButton("Accede como invitado");
		invitados.setBounds(600, 40, 150, 20);
		getContentPane().add(invitados);
		
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


