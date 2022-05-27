package becapp.menus.usuarios;


import javax.swing.JFrame;

import becapp.Alumno;
import becapp.menus.metodos.ImagenFondo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class VentanaCalcula extends JFrame {
	private JTextField Dinero;
	private JTextField Nfam;




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
		
		Dinero = new JTextField();
		Dinero.setBounds(96, 72, 125, 20);
		fondo.add(Dinero);
		Dinero.setColumns(10);
		
		Nfam = new JTextField();
		Nfam.setBounds(318, 72, 125, 20);
		Nfam.setColumns(10);
		fondo.add(Nfam);
		
		JTextPane panel = new JTextPane();
		
		panel.setBounds(96, 117, 351, 109);
		fondo.add(panel);
		
		
		JButton calcular = new JButton("Calcular");
		calcular.setBounds(184, 249, 182, 23);
		fondo.add(calcular);
		
		String umbral=Alumno.calUmbral(Integer.valueOf(Nfam.getText()),Double.valueOf(Dinero.getText()));
		panel.setText(Alumno.calBeca(umbral));
		

	}
}
