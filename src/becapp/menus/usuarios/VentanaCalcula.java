package becapp.menus.usuarios;

import javax.swing.JFrame;

import becapp.Alumno;
import becapp.menus.metodos.ImagenFondo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		panel.setVisible(false);
		panel.setEditable(false);

		JButton calcular = new JButton("Calcular");
		calcular.setBounds(184, 249, 182, 23);
		fondo.add(calcular);
		calcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double euros = Double.valueOf(Dinero.getText());
					Integer Nfamiliares = Integer.valueOf(Nfam.getText());
					String umbral = Alumno.calUmbral(Nfamiliares, euros);
					Double cantidad = Alumno.calBeca(umbral);
					if (cantidad == 0) {
						panel.setVisible(true);
						panel.setText("No tiene derecho a recibir una beca pública debido a sus ingresos anuales");
					} else {
						panel.setVisible(true);
						panel.setText("La cuantía de su beca es de: " + cantidad);
					}
				} catch (NumberFormatException a) {
					panel.setText("Introduzca unos parametros correctos");

				}

			}

		});

	}
}
