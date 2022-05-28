package becapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Alumno extends Usuario {

	private Integer numero_familiares;

	private double ingreso_anual;


	public ArrayList<Beca> becasFavoritas;

	public String umbral_ingresos;

	public Alumno(String dni, String clave, String nombre, String apellido, String nacionalidad, String email, int telf,
			String fecha_nac, Integer numero_familiares, double ingreso_anual, 
			becapp.estudios_requisitos estudios_requisitos, String umbral_ingresos) {
		super(dni, clave, nombre, apellido, nacionalidad, email, telf, fecha_nac);
		this.numero_familiares = numero_familiares;
		this.ingreso_anual = ingreso_anual;
		becasFavoritas=new ArrayList<Beca>();
		this.umbral_ingresos = umbral_ingresos;
	}

	public Alumno(String dni, String clave, String nombre, String apellido, String nacionalidad, String email, int telf,
			String fecha_nac) {
		super(dni, clave, nombre, apellido, nacionalidad,email,
				 telf, fecha_nac );
		this.numero_familiares = 0;
		this.ingreso_anual = 0;
		becasFavoritas=new ArrayList<Beca>();
		this.umbral_ingresos = null;
	}


	public double calcularUmbral() {
		return 0.0;
	}

	public void registrarAlumno(Alumno A) {
	}

	public void darDeBajaAlumno(Alumno A) {
	}

	public void consultarAlumno(Alumno A) {
	}

	public Integer getNumero_familiares() {
		return numero_familiares;
	}

	public void setNumero_familiares(Integer numero_familiares) {
		this.numero_familiares = numero_familiares;
	}

	public double getIngreso_anual() {
		return ingreso_anual;
	}

	public void setIngreso_anual(double ingreso_anual) {
		this.ingreso_anual = ingreso_anual;
	}


	public List<Beca> getBecasFavoritas() {
		return becasFavoritas;
	}


	public void aniadirFavorito(Beca beca) {
	}

	public String mostrarBecaFavorita() {
		return null;
	}

	public void borrarBecaFavorita(Beca beca) {
	}

	/**
	 * @author Eduardo y Arturo
	 * @param numFamilia
	 * @param dinero
	 * @return umbral
	 * El siguiente método nos permite calcular el umbral económico en el que se encuentra el 
	 * usuario que introduce los datos. Posteriormente esta variable umbral se utiliza para 
	 * calcular la cuantía monetaria de la beca.
	 */
	public static String calUmbral(Integer numFamilia,Double dinero) {
		String umbral="";
		final int intervalos[][] = {
				{8422, 13236, 14112},
				{12632, 22594, 24089},
				{16843, 30668, 32697},
				{21054, 36421, 38831},
				{24423, 40708, 43402},
				{27791, 43945, 46853},
				{31160, 47146, 50262},
				{34526, 50333, 53665}
		};

		if (dinero <= intervalos[numFamilia-1][0]){
			umbral="umbral1";
		}
		else if(dinero > intervalos[numFamilia-1][0] &dinero <= intervalos[numFamilia-1][1]) {
			umbral="umbral2";
		}
		else if (dinero > intervalos[numFamilia-1][1] &dinero <= intervalos[numFamilia-1][2]) {
			umbral="umbral3";
		}
		else {
			umbral="Sin derecho a beca";
		}
		return umbral;
	}
	/**
	 * @author amart y Eduardo
	 * @param umbral
	 * @param universitario
	 * @return total de la beca
	 * El siguiente método nos sirve para calcular la cuantía de la beca.
	 */
	public static Double calBeca(String umbral, boolean universitario) {
		Double total = 0.0;
	
		if(umbral.equals("umbral1")) {
			total = total + 1700 + 1600 + 60+ 125;
		}
		else if(umbral.equals("umbral2")&&universitario==false) {
			total = total + 1600 + 60;
		}
		else if(umbral.equals("umbral2")&&universitario) {
			total = total + 1700 + 60;
		}
		else if(umbral.equals("umbral3")&&universitario==false) {
			total = total + 0;
		}
		else if(umbral.equals("umbral3")&&universitario) {
			total=total+300;
		}
		else {
			total=total+0;
		}
		return total;
	}

	
	
}