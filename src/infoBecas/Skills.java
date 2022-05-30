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
	 * Create the frame.
	 * 
	 * @param i
	 */
	public Skills(int i) {
		setTitle("BECAPP");
		setBounds(400, 50, 701, 466);

		ImagenFondo fondo = new ImagenFondo("/imagenes/imagenFondoBecas.jpg");
		setContentPane(fondo);
		fondo.setLayout(null);

		Conexion_BBDD c = new Conexion_BBDD();

		Beca beca = c.getBeca(i);

		JTextPane textoNombre = new JTextPane();
		textoNombre.setBounds(99, 56, 188, 62);
		textoNombre.setText(beca.getNombre());
		fondo.add(textoNombre);
		textoNombre.getText();
		textoNombre.setEditable(false);
		textoNombre.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane textoProveedor = new JTextPane();
		textoProveedor.setText(beca.getNombreProveedor());
		textoProveedor.setEditable(false);
		textoProveedor.setBounds(99, 133, 188, 61);
		fondo.add(textoProveedor);
		textoProveedor.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane textoDescripcion = new JTextPane();
		textoDescripcion.setText(beca.getDescripcion());
		textoDescripcion.setEditable(false);
		textoDescripcion.setBounds(67, 233, 563, 117);
		fondo.add(textoDescripcion);
		textoDescripcion.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel imagen = new JLabel("");
		imagen.setBounds(296, 44, 334, 178);

		ImageIcon nuevaImagen = new ImageIcon(Skills.class.getResource("/imagenes/ImagenBeca.jpg"));
		ImageIcon img = new ImageIcon(
				nuevaImagen.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH));
		imagen.setIcon(img);
		fondo.add(imagen);

		JButton contacto = new JButton("Obtener contacto");
		contacto.setBounds(262, 367, 154, 28);
		fondo.add(contacto);
		/**
		 * no me aparece esta clase
		 */
		contacto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Contacto ventana = new Contacto(i);
				ventana.setVisible(true);

			}

		});

	}
}
