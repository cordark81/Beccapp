package becapp;

import java.util.Date;
import java.util.List;

public class Alumno extends Usuario {

  private Integer numero_familiares;

  private double ingreso_anual;

  private Integer telf;

  public List<Beca> becasFavoritas;

    public estudios_requisitos estudios_requisitos;
    public umbral_ingresos umbral_ingresos;
    
  

  public Alumno( String dni, String nombre, String apellido, String nacionalidad, String email,
			int telf, Date fecha_nac, Integer numero_familiares, double ingreso_anual, Integer telf2,
			List<Beca> becasFavoritas, becapp.estudios_requisitos estudios_requisitos,
			becapp.umbral_ingresos umbral_ingresos) {
		super( dni, nombre, apellido, nacionalidad, email, telf, fecha_nac);
		this.numero_familiares = numero_familiares;
		this.ingreso_anual = ingreso_anual;
		telf = telf2;
		this.becasFavoritas = becasFavoritas;
		this.estudios_requisitos = estudios_requisitos;
		this.umbral_ingresos = umbral_ingresos;
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

  public void aniadirFavorito(Beca beca) {
  }

  public String mostrarBecaFavorita() {
  return null;
  }

  public void borrarBecaFavorita(Beca beca) {
  }

}