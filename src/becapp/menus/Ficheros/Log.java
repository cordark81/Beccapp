package becapp.menus.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Eduardo y Arturo
 *
 */
public class Log {

	Tipo_movimiento tipo;
	Date fecha_hora;

	public Log(Tipo_movimiento tipo, Date fecha_hora) {

		this.tipo = tipo;
		this.fecha_hora = fecha_hora;
	}

	public Log() {

	}

	/**
	 * Con este metodo escribimos nuestro fichero log.txt en que vamos dejando
	 * registrado las acciones que se realizan el programa con la hora y la fecha
	 * del sistema
	 * 
	 * @param tipo Enum con lo tipo de movimientos
	 * 
	 * @throws IOException subimos la excepcion para tratala mas tarde
	 */
	public void escribirLog(Tipo_movimiento tipo) throws IOException {

		File log = new File("log.txt");
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);

		GregorianCalendar gc = new GregorianCalendar();
		Date fecha_hora = gc.getTime();

		bw.write(tipo.toString());
		bw.write(" ");
		bw.write(fecha_hora.toString());
		bw.newLine();

		bw.close();
		fw.close();

	}

	/**
	 * Metodo para lectura del archivo log.txt donde tenemos almacenado la
	 * informacion de los movimientos
	 * 
	 * @return String con los datos sacados del fichero para su sup
	 * @throws IOException
	 */
	public String leerLog() throws IOException {

		File log = new File("log.txt");
		FileReader fr = new FileReader(log);
		BufferedReader br = new BufferedReader(fr);

		String registro;
		String salida = "";

		while ((registro = br.readLine()) != null) {
			salida += registro + "\n";
		}

		br.close();
		fr.close();

		return salida;

	}

}
