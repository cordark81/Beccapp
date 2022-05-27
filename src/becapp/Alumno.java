package becapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Alumno extends Usuario {

	private Integer numero_familiares;

	private double ingreso_anual;


  public ArrayList<Beca> becasFavoritas;

    public estudios_requisitos estudios_requisitos;
    public umbral_ingresos umbral_ingresos;
    
public Alumno(String dni, String clave, String nombre, String apellido, String nacionalidad, String email, int telf,
			String fecha_nac, Integer numero_familiares, double ingreso_anual, 
			becapp.estudios_requisitos estudios_requisitos, becapp.umbral_ingresos umbral_ingresos) {
		super(dni, clave, nombre, apellido, nacionalidad, email, telf, fecha_nac);
		this.numero_familiares = numero_familiares;
		this.ingreso_anual = ingreso_anual;
		becasFavoritas=new ArrayList<Beca>();
		this.estudios_requisitos = estudios_requisitos;
		this.umbral_ingresos = umbral_ingresos;
	}

public Alumno(String dni, String clave, String nombre, String apellido, String nacionalidad, String email, int telf,
		String fecha_nac, Integer numero_familiares, double ingreso_anual) {
	super(dni, clave, nombre, apellido, nacionalidad, email, telf, fecha_nac);
	this.numero_familiares = numero_familiares;
	this.ingreso_anual = ingreso_anual;
	becasFavoritas=new ArrayList<Beca>();
	this.estudios_requisitos = null;
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



public estudios_requisitos getEstudios_requisitos() {
	return estudios_requisitos;
}

public void setEstudios_requisitos(estudios_requisitos estudios_requisitos) {
	this.estudios_requisitos = estudios_requisitos;
}

public umbral_ingresos getUmbral_ingresos() {
	return umbral_ingresos;
}

public void setUmbral_ingresos(umbral_ingresos umbral_ingresos) {
	this.umbral_ingresos = umbral_ingresos;
}

public void aniadirFavorito(Beca beca) {
  }

	public String mostrarBecaFavorita() {
		return null;
	}

  public void borrarBecaFavorita(Beca beca) {
  }
  
  
  double calcularCuantia(double ingresosAnuales, int numeroFamiliares) {
	  double total = 0;
	  
	  String[]umbrales= {"umbral1","umbral2","umbral3"};
	  String umbral="";
	  
	  if(numeroFamiliares==1) {	  
		  if(ingresosAnuales<=8871) {
			 umbral=umbrales[0];
		  }
		  else if (ingresosAnuales>8871 && ingresosAnuales<=13236) {
			  umbral=umbrales[1];
		  }
		  else {
			  umbral=umbrales[2];
		  }
		   
	  }
	  
	  
	  
	  return total;
	  
  }

}