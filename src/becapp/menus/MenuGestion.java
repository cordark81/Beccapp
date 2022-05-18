package becapp.menus;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import becapp.menus.Ficheros.Log;
import becapp.menus.gestionAdministrador.GestionAdministradores;
import becapp.menus.gestionBecas.GestionBecas;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.metodos.MetodosMenus;

public class MenuGestion extends JFrame {

	public MenuGestion() {

		setTitle("MENU DE GESTION");
		ImagenFondo fondo = new ImagenFondo();
		setContentPane(fondo);
		setBounds(600, 300, 600, 450);
		getContentPane().setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MetodosMenus mm = new MetodosMenus();
				mm.confirmarSalida();
			}
		});

		JButton gestionAdministrador = new JButton("Gestión de Administradores");
		gestionAdministrador.setBounds(100, 150, 400, 30);
		getContentPane().add(gestionAdministrador);
		gestionAdministrador.setBackground(Color.orange);

		gestionAdministrador.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestionAdministradores aa = new GestionAdministradores();
				aa.setVisible(true);
			}
		});

		JButton salir = new JButton("ATRAS");
		salir.setBounds(100, 300, 100, 30);
		getContentPane().add(salir);
		salir.setBackground(Color.orange);

		JButton Becas = new JButton("Gestión de becas");
		Becas.setBounds(100, 50, 400, 30);
		getContentPane().add(Becas);
		Becas.setBackground(Color.orange);

		Becas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GestionBecas gestionBecas = new GestionBecas();
				gestionBecas.setVisible(true);
				dispose();

			}
		});

		JButton log = new JButton("VER LOG");
		log.setBounds(400, 300, 100, 30);
		getContentPane().add(log);
		log.setBackground(Color.orange);
		

		JButton bLog = new JButton("DEL LOG");
		bLog.setBounds(250, 300, 100, 30);
		getContentPane().add(bLog);
		bLog.setBackground(Color.orange);
		
		bLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File f = new File("log.txt");
				if(f.delete()) {
					JOptionPane.showMessageDialog(null, "Registro borrado con exito");
				}
				else {
					JOptionPane.showMessageDialog(null,"Atencion: problema en el borrado");
				}
				
			}
		});

		log.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

	}
}
