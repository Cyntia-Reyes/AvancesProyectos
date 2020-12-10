package edu.unah.poo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "empleado")
public class Empleado {
		
	@Id
	private int  idEmpleado;
	private String nombre;
	private String telefono;
	private String direccion;
	private LocalDate fechaContrato;
	private LocalDate fechaNacimiento;
	private String puesto;
	
	@OneToMany(mappedBy="empleado",fetch=FetchType.EAGER)
	private List<Limpieza> limpieza;
	
	//@OneToMany(mappedBy="empleado",fetch=FetchType.EAGER)
//	private List<Factura> factura;
	
	public Empleado(int idEmpleado, String nombre, String telefono, String direccion, LocalDate fechaContrato,
			LocalDate fechaNacimiento, String puesto) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaContrato = fechaContrato;
		this.fechaNacimiento = fechaNacimiento;
		this.puesto = puesto;
	}
	
	
	public Empleado() {}


	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public LocalDate getFechaContrato() {
		return fechaContrato;
	}


	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
}
