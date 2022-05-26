package becapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Beca {

	private int cod;

	private String nombre;

	private String condiciones;

	private String descripcion;

	private String contacto;

	private String nombreProveedor;

	public tipo_beca tipo_beca;
	Connection connection = null;

	public Beca(String nombre, String condiciones, String descripcion, String contacto, String nombreProveedor,
			becapp.tipo_beca tipo_beca) {
		super();
		this.nombre = nombre;
		this.condiciones = condiciones;
		this.descripcion = descripcion;
		this.contacto = contacto;
		this.nombreProveedor = nombreProveedor;
		this.tipo_beca = tipo_beca;

	}

	public Beca(int cod, String nombre, String condiciones, String descripcion, String contacto, String nombreProveedor,
			becapp.tipo_beca tipo_beca) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.condiciones = condiciones;
		this.descripcion = descripcion;
		this.contacto = contacto;
		this.nombreProveedor = nombreProveedor;
		this.tipo_beca = tipo_beca;

	}
	
	public Beca(String nombre, String descripcion) {
		this.nombre=nombre;
		this.descripcion=descripcion;
	}
	
	public Beca(String nombre, String descripcion, String proveedor) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.nombreProveedor=proveedor;
	}


	public Beca() {
		
	}
	public String mostrarBeca() {
		return null;
	}

	public int buscarBeca(String nombre) {
		return 1;
	}

	public String solicitarContacto() {
		return "contacto";
	}

	public String getNombre() {
		return nombre;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getContacto() {
		return contacto;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public tipo_beca getTipo_beca() {
		return tipo_beca;
	}

	public int getCod() {
		return cod;
	}

	@Override
	public String toString() {
		return "Beca [ nombre=" + nombre + ", condiciones=" + condiciones + ", descripcion=" + descripcion
				+ ", contacto=" + contacto + ", nombreProveedor=" + nombreProveedor + ", tipo_beca=" + tipo_beca + "]";
	}

	
	
}