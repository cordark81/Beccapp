package infoBecas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/imagenFondoBecas.jpg");
		setContentPane(fondo);
		fondo.setLayout(null);

		JLabel Becapp = new JLabel("BECAPP");
		Becapp.setFont(new Font("Roboto Condensed", Font.PLAIN, 20));
		Becapp.setBounds(51, 11, 75, 40);
		fondo.add(Becapp);
		Becapp.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JPanel Inicio = new JPanel();
		Inicio.setBackground(new Color(175, 238, 238));
		Inicio.setBounds(0, 0, 724, 69);
		fondo.add(Inicio);
		Inicio.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		Conexion_BBDD c = new Conexion_BBDD();
			
		Beca beca = c.getBeca(i);
	
		JTextPane textoNombre = new JTextPane();
		textoNombre.setBounds(100, 89, 188, 28);
		textoNombre.setText(beca.getNombre());
		fondo.add(textoNombre);
		textoNombre.getText();
		textoNombre.setEditable(false);
		textoNombre.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JTextPane textoProveedor = new JTextPane();
		textoProveedor.setText(beca.getNombreProveedor());
		textoProveedor.setEditable(false);
		textoProveedor.setBounds(100, 128, 188, 28);
		fondo.add(textoProveedor);
		textoProveedor.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		
		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setText(beca.getDescripcion());
		textoDescripcion.setEditable(false);
		textoDescripcion.setBounds(67, 234, 563, 117);
		fondo.add(textoDescripcion);
		textoDescripcion.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(319, 72, 311, 151);
		
		ImageIcon nuevaImagen=new ImageIcon(Skills.class.getResource("/imagenes/ImagenBeca.jpg"));
		ImageIcon img = new ImageIcon(nuevaImagen.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
		imagen.setIcon(img);
		fondo.add(imagen);
		
		JButton contacto = new JButton("Obtener contacto");
		contacto.setBounds(125, 177, 140, 23);
		fondo.add(contacto);
		contacto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contacto ventana = new Contacto(i);
				ventana.setVisible(true);

				
			}
			
		});
		
		
		
	}
}
