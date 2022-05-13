package becapp;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Becapp {

	public static void main(String[] args) {

		List<Usuario> usuarios;
		List<Beca> beca;

		Conexion_BBDD conexion = new Conexion_BBDD();
		
		conexion.conectar();
		
		Beca beca1=new Beca("Ostras","acceso al mar","beca para marineros", "banco@galicia","banco galicia", tipo_beca.PRIVADA);
		conexion.aniadirBeca(beca1);
		//conexion.borrarBeca(4);
		conexion.modificarBeca("nombre", 3, "ostritas");
		System.out.println(conexion.listarBecas());
		
		Date d = new Date(100, 5, 2);
		new SimpleDateFormat("dd-MM-yyyy").format(d);
		Date fecha_nac=d;
		Administrador administrador1 = new Administrador("45454545L", "luis", "miguel", "española", "luis@gmail.com",65465466, fecha_nac,"1234", "activo", "administrador jefe");
		conexion.darAltaAdmin(administrador1);
		
		conexion.darBajaAdmin(3);
		
		System.out.println(conexion.mostrarAdmin());
		
		
		
		try {
			conexion.cerrar();
		} catch (SQLException e) {
			System.out.println("no se ha podido cerrar la conexion");
			e.printStackTrace();
		}
	}

}