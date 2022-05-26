package infoBecas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import becapp.Beca;
import becapp.Conexion_BBDD;
import becapp.menus.metodos.ImagenFondo;
import becapp.menus.usuarios.Login;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Skills extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param i 
	 */
	public Skills(int i) {
		setTitle("BECAPP");
		setBounds(400, 50, 701, 466);
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoNeutro.png");
		setContentPane(fondo);
		fondo.setLayout(null);

		JLabel Becapp = new JLabel("BECAPP");
		Becapp.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		Becapp.setBounds(51, 11, 75, 40);
		fondo.add(Becapp);
		
		JPanel Inicio = new JPanel();
		Inicio.setBackground(new Color(175, 238, 238));
		Inicio.setBounds(0, 0, 724, 69);
		fondo.add(Inicio);
		
		Conexion_BBDD c = new Conexion_BBDD();
		c.conectar();
		
		Beca beca = c.getBeca(i);
		JTextPane textoNombre = new JTextPane();
		textoNombre.setBounds(80, 106, 501, 40);
		textoNombre.setText(beca.getNombre());
		fondo.add(textoNombre);
		textoNombre.getText();
		textoNombre.setEditable(false);
		
		JTextPane textoProveedor = new JTextPane();
		textoProveedor.setText(beca.getNombreProveedor());
		textoProveedor.setEditable(false);
		textoProveedor.setBounds(80, 157, 501, 40);
		fondo.add(textoProveedor);
		
		
		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setText(beca.getDescripcion());
		textoDescripcion.setEditable(false);
		textoDescripcion.setBounds(80, 208, 501, 167);
		fondo.add(textoDescripcion);
		
	}
}
