package becapp.menus.metodos;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author Eduardo y Arturo
 *
 *         Clase para la poner imagen de fondo de el login
 */
public class FondoLogin extends JPanel {

	public FondoLogin() {

	}

	@Override
	public void paint(Graphics g) {

		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/Logo.png"));
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}

}
