package becapp.menus;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import becapp.Conexion_BBDD;

public class prueba {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MenuGestion aplicacion = new MenuGestion();
		aplicacion.setVisible(true);
		
	}

}
