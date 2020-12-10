package edu.unah.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	private int  idProveedor;
	private String nombre;
	private String direccion;
	private String telefono;
	private String correo;
	

	
	
	public Proveedor(int idProveedor, String nombre, String direccion, String telefono, String correo) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public Proveedor() {}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
