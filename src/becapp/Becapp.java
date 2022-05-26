package becapp;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import becapp.menus.PrincipalGestion;

public class Becapp {

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
		Conexion_BBDD conexion=new Conexion_BBDD();
		conexion.conectar();
		
		PrincipalGestion pg = new PrincipalGestion();
		pg.setVisible(true);
	}
}