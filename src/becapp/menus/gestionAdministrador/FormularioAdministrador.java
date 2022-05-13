package becapp.menus.gestionAdministrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import becapp.mirar;
import becapp.menus.gestionBecas.GestionBecas;
import becapp.menus.gestionBecas.ListadoBecas;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;

public class FormularioAdministrador extends JFrame {

	public FormularioAdministrador() {

		setTitle("FORMULARIO ADMINISTRADOR");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setBounds(500, 300, 1000, 650);
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
		dniC.setForeground(Color.white);

		JTextField dni = new JTextField();
		dni.setBounds(100, 50, 150, 19);
		getContentPane().add(dni);
		dni.setColumns(10);

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

		JTextPane apellidoC = new JTextPane();
		apellidoC.setText("Apellido");
		apellidoC.setBounds(100, 140, 114, 19);
		getContentPane().add(apellidoC);
		apellidoC.setEditable(false);
		apellidoC.setOpaque(false);
		apellidoC.setForeground(Color.white);

		JTextField apellido = new JTextField();
		apellido.setBounds(100, 170, 250, 19);
		getContentPane().add(apellido);
		apellido.setColumns(10);

		JTextPane nacionalidadC = new JTextPane();
		nacionalidadC.setText("Nacioalidad");
		nacionalidadC.setBounds(450, 20, 150, 19);
		getContentPane().add(nacionalidadC);
		nacionalidadC.setEditable(false);
		nacionalidadC.setOpaque(false);

		JTextField nacionalidad = new JTextField();
		nacionalidad.setBounds(450, 50, 250, 19);
		getContentPane().add(nacionalidad);
		nacionalidad.setColumns(10);

		JTextPane emailC = new JTextPane();
		emailC.setText("Email");
		emailC.setBounds(450, 80, 114, 19);
		getContentPane().add(emailC);
		emailC.setEditable(false);
		emailC.setOpaque(false);
		emailC.setForeground(Color.white);

		JTextField email = new JTextField();
		email.setBounds(450, 110, 250, 19);
		getContentPane().add(email);
		email.setColumns(10);

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
		
		JTextPane fecha_nacC = new JTextPane();
		fecha_nacC.setText("Fecha de nacimiento");
		fecha_nacC.setBounds(100, 200, 150, 19);
		getContentPane().add(fecha_nacC);
		fecha_nacC.setEditable(false);
		fecha_nacC.setOpaque(false);
		
		JTextField fecha_nac = new JTextField();
		fecha_nac.setBounds(100, 230, 100, 19);
		getContentPane().add(fecha_nac);
		fecha_nac.setColumns(10);
		fecha_nac.setEditable(false);
		
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
		
		JTextPane estadoC = new JTextPane();
		estadoC.setText("Estado");
		estadoC.setBounds(100, 260, 150, 19);
		getContentPane().add(estadoC);
		estadoC.setEditable(false);
		estadoC.setOpaque(false);
		estadoC.setForeground(Color.white);
		
		JTextField estado = new JTextField();
		estado.setBounds(100, 290, 100, 19);
		getContentPane().add(estado);
		estado.setColumns(10);
		
		JTextPane descipcion_puestoC = new JTextPane();
		descipcion_puestoC.setText("Descripcion puesto");
		descipcion_puestoC.setBounds(450, 260, 150, 19);
		getContentPane().add(descipcion_puestoC);
		descipcion_puestoC.setEditable(false);
		descipcion_puestoC.setOpaque(false);
		descipcion_puestoC.setForeground(Color.white);
		
		JTextField descripcion_puesto = new JTextField();
		descripcion_puesto.setBounds(450, 290, 250, 19);
		getContentPane().add(descripcion_puesto);
		descripcion_puesto.setColumns(10);
		
		

		JButton salir = new JButton("ATRAS");
		salir.setBounds(100, 550, 100, 30);
		getContentPane().add(salir);
		
		

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

		JButton listado = new JButton("Ver BBDD");
		listado.setBounds(250, 550, 100, 30);
		getContentPane().add(listado);
		listado.setSelectedIcon(new ImageIcon(getClass().getResource("/imagenes/tabla.jpg")));

		listado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListadoBecas lb = new ListadoBecas();
				lb.setTitle("Datos Administradores");
				lb.pack();
				lb.setVisible(true);
			}
		});
	}

}
