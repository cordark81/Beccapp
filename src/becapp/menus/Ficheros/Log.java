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

public class Log {

	Tipo_movimiento tipo;
	Date fecha_hora;

	public Log(Tipo_movimiento tipo, Date fecha_hora) {

		this.tipo = tipo;
		this.fecha_hora = fecha_hora;
	}

	public Log() {

	}

	/*
	 * SIN USAR public void escribirObjetos(File f,Tipo_movimiento tipo, Date
	 * fecha_hora) throws IOException {
	 * 
	 * FileOutputStream fo = null; ObjectOutputStream datos = null;
	 * 
	 * if (!f.exists()) { fo = new FileOutputStream(f); datos = new
	 * ObjectOutputStream(fo); }
	 * 
	 * else { fo = new FileOutputStream(f, true); datos = new MiObjeto(fo); }
	 * 
	 * Log log = new Log(tipo,fecha_hora);
	 * 
	 * datos.writeObject(log); datos.close(); }
	 */

	/**
	 * Con este metodo escribimos nuestro fichero log.txt en que vamos dejando
	 * registrado las acciones que se realizan el programa
	 * 
	 * @param f fichero en el que se guarda la info
	 * @param tipo Enum con lo tipo de movimientos
	 * @param fecha_hora fecha y hora del movimiento
	 * @param detalle aqui se pasa un string con todos los datos de la beca
	 * @throws IOException subimos la excepcion para tratala mas tarde
	 */
	public void escribirLog(Tipo_movimiento tipo, Date fecha_hora, String detalle) throws IOException {

		File log = new File("log.txt");
		FileWriter fw = new FileWriter(log, true);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(tipo.toString());
		bw.write(" ");
		bw.write(fecha_hora.toString());
		bw.write(" ");
		bw.write(detalle);
		bw.newLine();

		bw.close();
		fw.close();

	}
	
	public String leerLog () throws IOException {
		
		File log = new File("log.txt");
		FileReader fr= new FileReader(log);
		BufferedReader br = new BufferedReader(fr);
		
		String registro;
		String salida="";
		
		while ((registro=br.readLine()) != null) {
			salida+=registro+"\n";
		}
		
		br.close();
		fr.close();
		
		
		return salida;

		
	}
	


}
