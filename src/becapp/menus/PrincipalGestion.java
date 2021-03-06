package becapp.menus;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import becapp.menus.Ficheros.Log;
import becapp.menus.gestionAdministrador.BorradoAdministrador;
import becapp.menus.gestionAdministrador.FormularioAdministrador;
import becapp.menus.gestionBecas.BorradoBecas;
import becapp.menus.gestionBecas.FormularioBeca;
import becapp.menus.gestionBecas.ModificarBeca;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.Listado;
import becapp.menus.metodos.MetodosMenus;
import becapp.menus.usuarios.Login;

/**
 * 
 * @see https://www.juegosoftware.com/2018/10/hacer-un-jmenubar-en-una-ventana-en-java.html
 * 
 * @author Eduardo y Arturo
 *
 * 
 */
public class PrincipalGestion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar;// crea la barra de menús
	private JMenu menuBecas, menuAdministrador, registro;// menús que añadiremos a la bara de menús

	private JMenuItem anaidirBeca, borrarBeca, modiBeca, listadoBeca, anaidirAdmin, borrarAdmin, listaAdmin, verLog,
			borrarLog, sesion, cerrarSesion;// los items que tienen los menús

	public PrincipalGestion() {

		setBounds(300, 100, 1200, 820);
		setTitle("MENU PRINCIPAL");
		ImagenFondo fondo = new ImagenFondo("/imagenes/Definitivo.png");
		setContentPane(fondo);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setFont(new Font("Roboto", Font.PLAIN, 14));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		// creamos la barra de menú

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setFont(new Font("Roboto", Font.PLAIN, 14));

		// añadimos la opción menú
		menuBecas = new JMenu("Gesti?n becas");
		menuBar.add(menuBecas);
		menuBecas.setFont(new Font("Roboto", Font.PLAIN, 14));

		// añadimos un item
		anaidirBeca = new JMenuItem("A?adir becas");
		anaidirBeca.addActionListener(this);
		menuBecas.add(anaidirBeca);
		anaidirBeca.setFont(new Font("Roboto", Font.PLAIN, 14));

		// añadimos otro item
		borrarBeca = new JMenuItem("Borrar becas");
		borrarBeca.addActionListener(this);
		menuBecas.add(borrarBeca);
		borrarBeca.setFont(new Font("Roboto", Font.PLAIN, 14));

		// y añadimos otro item más
		modiBeca = new JMenuItem("Modificar becas");
		modiBeca.addActionListener(this);
		menuBecas.add(modiBeca);
		modiBeca.setFont(new Font("Roboto", Font.PLAIN, 14));

		listadoBeca = new JMenuItem("Listar Becas");
		listadoBeca.addActionListener(this);
		menuBecas.add(listadoBeca);
		listadoBeca.setFont(new Font("Roboto", Font.PLAIN, 14));

		// añadimos otro menu a la barra de menús que en este caso no hace nada
		menuAdministrador = new JMenu("Gesti?n administrador");
		menuBar.add(menuAdministrador);
		menuAdministrador.setFont(new Font("Roboto", Font.PLAIN, 14));

		anaidirAdmin = new JMenuItem("A?adir administrador");
		anaidirAdmin.addActionListener(this);
		menuAdministrador.add(anaidirAdmin);
		anaidirAdmin.setFont(new Font("Roboto", Font.PLAIN, 14));

		borrarAdmin = new JMenuItem("Borrar administrador");
		borrarAdmin.addActionListener(this);
		menuAdministrador.add(borrarAdmin);
		borrarAdmin.setFont(new Font("Roboto", Font.PLAIN, 14));

		listaAdmin = new JMenuItem("Listado administrador");
		listaAdmin.addActionListener(this);
		menuAdministrador.add(listaAdmin);
		listaAdmin.setFont(new Font("Roboto", Font.PLAIN, 14));

		registro = new JMenu("Registro");
		menuBar.add(registro);
		registro.setFont(new Font("Roboto", Font.PLAIN, 14));

		verLog = new JMenuItem("Ver registro");
		verLog.addActionListener(this);
		registro.add(verLog);
		verLog.setFont(new Font("Roboto", Font.PLAIN, 14));

		borrarLog = new JMenuItem("Borrar registros");
		borrarLog.addActionListener(this);
		registro.add(borrarLog);
		borrarLog.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		sesion = new JMenu("Sesi?n");
		sesion.addActionListener(this);
		sesion.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(sesion);
		
		cerrarSesion = new JMenuItem("Cerrar Sesion");
		cerrarSesion.addActionListener(this);
		sesion.add(cerrarSesion);
		cerrarSesion.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		
		
		
		

		JTextPane version = new JTextPane();
		version.setText("VERSION 1.0");
		version.setBounds(1025, 700, 450, 19);
		getContentPane().add(version);
		version.setEditable(false);
		version.setOpaque(false);
		version.setVisible(true);
		version.setFont(new Font("Roboto", Font.PLAIN, 14));

	}

	// acciones que hace cada item cuando son pulsados
	/**
	 * En este evento de accion vamos comprobando que opción del menu desplegable se
	 * ha seleccionado, para recurrir a su menu correspondiente
	 */
	public void actionPerformed(ActionEvent e) {
		Container f = this.getContentPane();
		if (e.getSource() == anaidirBeca) {
			FormularioBeca fb = new FormularioBeca();
			fb.setVisible(true);

		}
		if (e.getSource() == borrarBeca) {
			f.setBackground(new Color(0, 102, 255));// cambia a color azul
			BorradoBecas bb = new BorradoBecas();
			bb.setVisible(true);

		}
		if (e.getSource() == modiBeca) {
			ModificarBeca mb = new ModificarBeca();
			mb.setVisible(true);

		}
		if (e.getSource() == listadoBeca) {

			String[] columnas = { "Codigo", "Proveedor", "Contacto", "Descripcion", "Nombre", "Condiciones",
					"Tipo de Beca" };

			Listado listado = new Listado(false, columnas, "becas");
			listado.setTitle("Datos Becas");
			listado.pack();
			listado.setVisible(true);

		}
		if (e.getSource() == anaidirAdmin) {
			FormularioAdministrador fa = new FormularioAdministrador();
			fa.setVisible(true);

		}
		if (e.getSource() == borrarAdmin) {
			BorradoAdministrador ba = new BorradoAdministrador();
			ba.setVisible(true);

		}
		if (e.getSource() == listaAdmin) {

			String[] columnas = { "ID", "DNI", "Nombre", "Apellido", "Nacionalidad", "Email", "Telefono",
					"Fecha  nacimientos", "Clave", "Estado", "Descripcion puesto", "Fecha alta" };

			Listado listado = new Listado(false, columnas, "administrador");
			listado.setVisible(true);
			listado.setTitle("Datos administradores");
			listado.pack();

		}
		if (e.getSource() == verLog) {

			Log log = new Log();
			try {
				String datos = log.leerLog();
				JOptionPane.showMessageDialog(null, datos);
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No existen regristros");
			}

		}
		if (e.getSource() == borrarLog) {

			File archivo = new File("log.txt");
			if (archivo.delete()) {
				JOptionPane.showMessageDialog(null, "Registro borrado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "Atencion: registro vacio");
			}

		}
		
		if(e.getSource() == cerrarSesion) {
			
			Login lo = new Login();
			lo.setVisible(true);
			dispose();
		}
	}

}
