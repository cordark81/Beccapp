package becapp.menus.usuarios;


<<<<<<< HEAD

import java.awt.Color;
=======
import java.awt.Font;
>>>>>>> 9f9a626d5602cc74ddd6f48a7ba16947a4f12c95
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import becapp.Alumno;
import becapp.Conexion_BBDD;
import becapp.Usuario;
import becapp.menus.Ficheros.Log;
import becapp.menus.Ficheros.Tipo_movimiento;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class RegistroUsuarios extends JFrame {

	private JTextField Fnombre;
	private JTextField Ftelf;
	private JTextField Fdni;
	private JTextField Femail;
	private JTextField Fcontra;
	private JTextField Fapellido;
	private JTextField Fnacionalidad;


	public RegistroUsuarios(){

		setTitle("REGISTRO");
		setBounds(200, 100, 500, 420);
		getContentPane().setLayout(null);

		ImagenFondo fondo = 
				new ImagenFondo("/imagenes/FondoNeutro.png");
		setContentPane(fondo);

		getContentPane().setLayout(null);
		fondo.setLayout(null);

		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(134, 39, 65, 41);
		fondo.add(nombre);
		nombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel apellido = new JLabel("Apellido");
		apellido.setBounds(281, 39, 76, 41);
		fondo.add(apellido);
		apellido.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel telf = new JLabel("Tel\u00E9fono");
		telf.setBounds(134, 109, 65, 41);
		fondo.add(telf);
		telf.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel dni = new JLabel("DNI");
		dni.setBounds(297, 109, 23, 41);
		fondo.add(dni);
		dni.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel correo = new JLabel("Email");
		correo.setBounds(134, 169, 48, 41);
		fondo.add(correo);
		correo.setFont(new Font("Roboto", Font.PLAIN, 14));

<<<<<<< HEAD
		JLabel contraseņa = new JLabel("Contrasenia");
		contraseņa.setBounds(274, 169, 83, 41);
		fondo.add(contraseņa);
=======
		JLabel contrasena = new JLabel("Contrase\u00F1a");
		contrasena.setBounds(274, 169, 61, 41);
		contrasena.setFont(new Font("Roboto", Font.PLAIN, 14));
		fondo.add(contrasena);
>>>>>>> 9f9a626d5602cc74ddd6f48a7ba16947a4f12c95

		Fnombre = new JTextField();
		Fnombre.setBounds(113, 78, 86, 20);
		fondo.add(Fnombre);
		Fnombre.setColumns(10);
		Fnombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		Ftelf = new JTextField();
		Ftelf.setColumns(10);
		Ftelf.setBounds(113, 148, 86, 20);
		fondo.add(Ftelf);
		Ftelf.setFont(new Font("Roboto", Font.PLAIN, 14));

		Fdni = new JTextField();
		Fdni.setColumns(10);
		Fdni.setBounds(264, 148, 86, 20);
		fondo.add(Fdni);
		Fdni.setFont(new Font("Roboto", Font.PLAIN, 14));

		Femail = new JTextField();
		Femail.setColumns(10);
		Femail.setBounds(113, 207, 86, 20);
		fondo.add(Femail);
		Femail.setFont(new Font("Roboto", Font.PLAIN, 14));

		Fcontra = new JTextField();
		Fcontra.setColumns(10);
		Fcontra.setBounds(264, 207, 86, 20);
		fondo.add(Fcontra);
		Fcontra.setFont(new Font("Roboto", Font.PLAIN, 14));

		Fapellido = new JTextField();
		Fapellido.setColumns(10);
		Fapellido.setBounds(264, 78, 86, 20);
		fondo.add(Fapellido);
		Fapellido.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton resgistrarse = new JButton("Registrarse");
		resgistrarse.setBounds(183, 313, 109, 30);
		fondo.add(resgistrarse);
<<<<<<< HEAD
		
		JDateChooser jdc = new JDateChooser();
		jdc.setDateFormatString("d/MM/y");
		jdc.setBounds(264, 270, 93, 19);
		fondo.add(jdc);
		jdc.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.orange));
=======
		resgistrarse.setFont(new Font("Roboto", Font.PLAIN, 14));
>>>>>>> 9f9a626d5602cc74ddd6f48a7ba16947a4f12c95

		Fnacionalidad = new JTextField();
		Fnacionalidad.setColumns(10);
		Fnacionalidad.setBounds(113, 269, 86, 20);
		fondo.add(Fnacionalidad);
		Fnacionalidad.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(123, 231, 76, 41);
		fondo.add(lblNacionalidad);
		lblNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 14));

<<<<<<< HEAD
		JLabel lblFechaNac = new JLabel("Fecha de nacimiento");
		lblFechaNac.setBounds(264, 231, 104, 41);
=======
		Ffecha = new JTextField();
		Ffecha.setColumns(10);
		Ffecha.setBounds(264, 269, 86, 20);
		fondo.add(Ffecha);
		Ffecha.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel lblFechaNac = new JLabel("Fecha Nac");
		lblFechaNac.setBounds(281, 231, 55, 41);
>>>>>>> 9f9a626d5602cc74ddd6f48a7ba16947a4f12c95
		fondo.add(lblFechaNac);
		lblFechaNac.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton atras = new JButton("<-");
		atras.setBounds(29, 11, 30, 23);
		fondo.add(atras);
		atras.setFont(new Font("Roboto", Font.PLAIN, 14));

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Login ventana = new Login();
				ventana.setVisible(true);
				dispose();


			}
		});

		resgistrarse.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date fechaCalendario = jdc.getDate();
				DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				String Ffecha = f.format(fechaCalendario);

				Conexion_BBDD connection = new Conexion_BBDD();
				connection.conectar();
				if( Fcontra.getText().length()==0 || Fdni.getText().length()==0|| Fnombre.getText().length()==0 ||  Fapellido.getText().length()==0
						|| Fnacionalidad.getText().length()==0 || Femail.getText().length()==0){
						
					JOptionPane.showMessageDialog(null, "Debe comprobar que ha introducido todos los datos!", "Campos vacios",
							JOptionPane.INFORMATION_MESSAGE);
						
				}
				else {
					Alumno nuevoUsuario = new Alumno( Fdni.getText(), Fcontra.getText(), Fnombre.getText(), Fapellido.getText(), Fnacionalidad.getText(),
							Femail.getText(), Integer.valueOf(Ftelf.getText()), Ffecha);

					if(connection.registrarAlumno(nuevoUsuario)){

						JOptionPane.showMessageDialog(null, "Usuario registrado con exito!", "Registro finalizado",
								JOptionPane.INFORMATION_MESSAGE);
						MenuUsuario ventana = new MenuUsuario();         
						ventana.setVisible(true);
						dispose();

					

						Log log = new Log();
						try {
							log.escribirLog(Tipo_movimiento.REGISTRAR_ALUMNO);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


					}else {

						JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
								+ "Por favor ingrese los datos correctamente", "Registro incompleto",
								JOptionPane.ERROR_MESSAGE);

					}
				}


			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});





	}
}
