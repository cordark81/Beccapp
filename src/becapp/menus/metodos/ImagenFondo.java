package becapp.menus.metodos;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 
 * @author edu
 *
 *Clase para implemtar una imagen de fondo en la ventana
 */
public class ImagenFondo extends JPanel{
	
	String imag;
	//constructor para poder variar la imagen
	public ImagenFondo(String imagen) {
		this.imag=imagen;
	}
		
	@Override
	public void paint(Graphics g) {
		
		ImageIcon imagen = new ImageIcon(getClass().getResource(imag));
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	
	
}
