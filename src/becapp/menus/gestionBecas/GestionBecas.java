package becapp.menus.gestionBecas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import becapp.Beca;
import becapp.Conexion_BBDD;
import becapp.menus.MenuGestion;
import becapp.menus.metodos.MetodosMenus;

public class GestionBecas extends JFrame {

	public GestionBecas() {

		setTitle("GESTION BECAS");
		setBounds(600, 300, 600, 450);
		getContentPane().setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JButton añadirBeca = new JButton("Añadir Beca");
		añadirBeca.setBounds(100, 50, 400, 30);
		getContentPane().add(añadirBeca);
		añadirBeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormularioBeca fb = new FormularioBeca();
				fb.setVisible(true);
				dispose();
			}
		});

		JButton borrarBeca = new JButton("Borrar Beca");
		borrarBeca.setBounds(100, 125, 400, 30);
		getContentPane().add(borrarBeca);
		borrarBeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BorradoBecas bb = new BorradoBecas();
				bb.setVisible(true);
				dispose();

			}
		});

		JButton modificarBeca = new JButton("Modificar Beca");
		modificarBeca.setBounds(100, 200, 400, 30);
		getContentPane().add(modificarBeca);
		modificarBeca.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ModificarBeca mb = new ModificarBeca();
				mb.setVisible(true);
				dispose();

			}
		});

		JButton listaBeca = new JButton("Listar Becas");
		listaBeca.setBounds(100, 275, 400, 30);
		getContentPane().add(listaBeca);
		
		listaBeca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				ListadoBecas lb = new ListadoBecas();
				lb.setTitle("Datos Becas");
				lb.pack();
				lb.setVisible(true);
				
			}
		});

		JButton atras = new JButton("ATRAS");
		atras.setBounds(100, 350, 100, 30);
		getContentPane().add(atras);

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				MenuGestion aplicacion = new MenuGestion();
				aplicacion.setVisible(true);

			}
		});

	}

}
