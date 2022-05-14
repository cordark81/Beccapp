package becapp.menus.metodos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//sin usar
public class Limpiar {

	public void limpiar_texto(JFrame panel) {
		for (int i = 0; panel.getComponents().length > i; i++) {
			if (panel.getComponents()[i] instanceof JTextField) {
				((JTextField) panel.getComponents()[i]).setText("");
			} else if (panel.getComponents()[i] instanceof JPasswordField) {
				((JPasswordField) panel.getComponents()[i]).setText("");
			}
		}
	}

}
