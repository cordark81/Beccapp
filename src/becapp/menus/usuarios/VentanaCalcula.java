package becapp.menus.usuarios;


import javax.swing.JFrame;

import becapp.menus.metodos.ImagenFondo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class VentanaCalcula extends JFrame {
	private JTextField textField;
	private JTextField textField_1;




	/**
	 * Create the frame.
	 */
	public VentanaCalcula() {
		
		setTitle("CALCULA LA CUANTÍA DE TU BECA");
		setBounds(200, 100, 563, 342);
	    
		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoNeutro.png");
		setContentPane(fondo);
		fondo.setLayout(null);
		
		JLabel Ingresos = new JLabel("Ingresos anuales");
		Ingresos.setBounds(118, 38, 82, 23);
		fondo.add(Ingresos);
		
		JLabel Familiares = new JLabel("Numero de familiares");
		Familiares.setBounds(332, 40, 107, 19);
		fondo.add(Familiares);
		
		textField = new JTextField();
		textField.setBounds(96, 72, 125, 20);
		fondo.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(318, 72, 125, 20);
		textField_1.setColumns(10);
		fondo.add(textField_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(96, 117, 351, 109);
		fondo.add(panel);
		
		JButton calcular = new JButton("Calcular");
		calcular.setBounds(184, 249, 182, 23);
		fondo.add(calcular);

	}
}
