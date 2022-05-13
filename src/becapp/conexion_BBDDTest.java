package becapp;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class conexion_BBDDTest {

	@Test
	public void testAnadirBeca() {
		// beca valida
		Beca b = new Beca("luis", "vivir en madrid", "beca para estudiantes", "santander@gmail.com", "banco santander",
				tipo_beca.PRIVADA);
		Conexion_BBDD c = new Conexion_BBDD();
		boolean resultado = c.aniadirBeca(b);
		assertTrue(resultado);

	}

	@Test
	public void testBorrarBeca() {
		// si no existe no lanzara false y no se borrara
		int condicion=1;
		String dato="123";
		Conexion_BBDD c = new Conexion_BBDD();
		boolean resultado = c.borrarBeca(dato,condicion);
		assertTrue(resultado);
	}

	@Test
	public void testModificarBeca() {
		// nombre de la columna a cambiar
		String columna = "nombre";
		// codigo que de beca que se va a cambiar la columna
		int cod = 1;
		// campo actualizado
		String actualizacion = "luis";

		Conexion_BBDD c = new Conexion_BBDD();
		boolean resultado = c.modificarBeca(columna, cod, actualizacion);
		assertTrue(resultado);
	}

	@Test
	public void testListarBecas() {
		Conexion_BBDD c = new Conexion_BBDD();
		String resultado = c.listarBecas();
		// se puede testear este metodo????
	}

	@Test
	public void testDarAltaAdmin() {

		// esta deprecated como hacerlo de otra manera
		Date d = new Date(100, 5, 2);

		new SimpleDateFormat("dd-MM-yyyy").format(d);

		int id_usuario = 3;
		String dni = "45454545L";
		String nombre = "Angel";
		String apellido = "Tarraga";
		String nacionalidad = "Española";
		String email = "angel@gmail.com";
		int telf = 654654654;
		Date fecha_nac = d;// pendiente de preguntar como hacerlo;
		String clave = "clave";
		String estado = "activo";
		String descripcion_puesto = "Administrador jefe";

		Administrador a = new Administrador( dni, nombre, apellido, nacionalidad, email, telf, fecha_nac,
				clave, estado, descripcion_puesto);
		Conexion_BBDD c = new Conexion_BBDD();

		boolean resultado = c.darAltaAdmin(a);
		assertTrue(resultado);

	}

	@Test
	public void testDarBajaAdmin() {
		int id = 2;
		Conexion_BBDD c = new Conexion_BBDD();
		boolean resultado = c.darBajaAdmin(id);
		assertTrue(resultado);

	}

	@Test
	public void testMostrarAdmin() {
		Conexion_BBDD c = new Conexion_BBDD();
		String resultado = c.mostrarAdmin();
		//Se puede testear este metodo?
	}

}
