package becapp.menus.metodos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ColorFondo extends JPanel {
	
	//sin usar

	private Color color1 = Color.CYAN;
	private Color color2 = Color.MAGENTA;

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D G2D = (Graphics2D) g;

		int w = getWidth();
		int h = getHeight();

		GradientPaint gp = new GradientPaint(0, 0, color1, 50, 50, color2,true);

		G2D.setPaint(gp);
		G2D.fillRect(0, 0, 50, 50);

	}

}