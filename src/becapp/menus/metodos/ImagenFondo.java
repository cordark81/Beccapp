package becapp.menus.metodos;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenFondo extends JPanel{

	public ImagenFondo() {
		
	}
		
	@Override
	public void paint(Graphics g) {
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
}
