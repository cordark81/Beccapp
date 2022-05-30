package becapp;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import becapp.menus.PrincipalGestion;
import becapp.menus.usuarios.Login;
import becapp.menus.usuarios.MenuUsuario;
import becapp.menus.usuarios.RegistroUsuarios;
import becapp.menus.usuarios.VentanaCalcula;

/**
 * La siguiente clase sirve para inicializar la ventana principal de nuestro programa.
 * @author Arturo y Eduardo
 */
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
		
		Login pg = new Login();
		pg.setVisible(true);
		/*MenuUsuario pg= new MenuUsuario();
		pg.setVisible(true);*/
		
		
	}
}