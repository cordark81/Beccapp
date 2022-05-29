package becapp.menus.usuarios;

import javax.swing.JFrame;

import becapp.Alumno;
import becapp.menus.metodos.ImagenFondo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 * 
 * @author Eduardo y Arturo
 * 
 *
 */
public class VentanaCalcula extends JFrame {
	private JTextField Dinero;
	private JTextField Nfam;
	private boolean prima_universidad = false;

	/**
	 *         El siguiente constructor contiene los elementos
	 *         necesarios para generar la ventana mediante la que el usuario calcula
	 *         la cuant�a de la beca mediante dos par�metros(cuant�a de ingresos
	 *         anuales y n�mero de familiares).
	 */
	public VentanaCalcula() {

		setTitle("CALCULA LA CUANT�A DE TU BECA");
		setBounds(200, 100, 563, 342);

		ImagenFondo fondo = new ImagenFondo("/imagenes/FondoCalcula.jpg");
		setContentPane(fondo);
		fondo.setLayout(null);

		JLabel Ingresos = new JLabel("Ingresos anuales");
		Ingresos.setToolTipText(
				"Introduz la suma de los ingresos durante los \u00FAltimos 12 meses de todos los componentes de su unidad familiar");
		Ingresos.setBounds(127, 51, 112, 23);
		fondo.add(Ingresos);
		Ingresos.setFont(new Font("Roboto", Font.PLAIN, 14));

		JLabel Familiares = new JLabel("Numero de familiares");
		Familiares.setBounds(301, 53, 142, 19);
		fondo.add(Familiares);
		Familiares.setFont(new Font("Roboto", Font.PLAIN, 14));

		Dinero = new JTextField();
		Dinero.setBounds(115, 85, 125, 20);
		fondo.add(Dinero);
		Dinero.setColumns(10);
		Dinero.setFont(new Font("Roboto", Font.PLAIN, 14));

		Nfam = new JTextField();
		Nfam.setBounds(301, 85, 125, 20);
		Nfam.setColumns(10);
		fondo.add(Nfam);
		Nfam.setFont(new Font("Roboto", Font.PLAIN, 14));

		JTextPane panel = new JTextPane();
		panel.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel.setBounds(92, 160, 351, 60);
		fondo.add(panel);
		panel.setVisible(false);
		panel.setEditable(false);
		panel.setFont(new Font("Roboto", Font.PLAIN, 14));

		JButton calcular = new JButton("Calcular");
		calcular.setBounds(184, 249, 182, 23);
		fondo.add(calcular);

		JLabel universitario = new JLabel("�Eres universitario?");
		universitario.setToolTipText("");
		universitario.setBounds(172, 123, 142, 23);
		fondo.add(universitario);

		JCheckBox univ = new JCheckBox("");
		
		/**
		 * para verificar si tiene prima de universidad  en el checkbox
		 */
		univ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prima_universidad = true;
			}

		});

		univ.setBounds(320, 123, 21, 23);
		fondo.add(univ);
		calcular.setFont(new Font("Roboto", Font.PLAIN, 14));
		/**
		 * Accion del notón calcular, lanzara la información según los criterios introducidos
		 */
		calcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					double euros = Double.valueOf(Dinero.getText());
					Integer Nfamiliares = Integer.valueOf(Nfam.getText());
					String umbral = Alumno.calUmbral(Nfamiliares, euros);
					Double cantidad = Alumno.calBeca(umbral, prima_universidad);
					if (cantidad == 0) {
						panel.setVisible(true);
						panel.setText("No tiene derecho a recibir una beca p�blica debido a sus ingresos anuales");
					} else {
						panel.setVisible(true);
						panel.setText("La cuant�a de su beca es de: " + cantidad);
					}
				} catch (NumberFormatException a) {
					panel.setText("Introduzca unos parametros correctos");

				}

			}

		});

	}
}
