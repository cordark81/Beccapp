package infoBecas;


import javax.swing.JFrame;
import javax.swing.JTextPane;

import becapp.Beca;
import becapp.Conexion_BBDD;
import becapp.menus.metodos.ImagenFondo;

public class Contacto extends JFrame {

	public Contacto(int i) {
		setTitle("BECAPP");
		setBounds(400, 50, 414, 181);
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/imagenFondoBecas.jpg");
		setContentPane(fondo);
		fondo.setLayout(null);

		Conexion_BBDD c = new Conexion_BBDD();
		c.conectar();
		
		Beca beca = c.getBeca(i);
		JTextPane contacto = new JTextPane();
		contacto.setBounds(21, 54, 356, 28);
		contacto.setText(beca.getContacto());
		contacto.getText();
		contacto.setEditable(false);
		fondo.add(contacto);
	}

}
