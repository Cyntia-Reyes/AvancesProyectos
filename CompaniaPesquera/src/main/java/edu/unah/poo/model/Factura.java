package edu.unah.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idFactura;
	@Id
	private int idEmpleado;
	private int precio;
	private int cantidad;
	private String tipoProducto;
	private LocalDate fecha;
	private String lugar;
	
	
	public Factura(int idFactura, int idEmpleado, int precio, int cantidad, String tipoProducto, LocalDate fecha,
			String lugar,Empleado empleado) {
		super();
		this.idFactura = idFactura;
		this.idEmpleado = idEmpleado;
		this.precio = precio;
		this.cantidad = cantidad;
		this.tipoProducto = tipoProducto;
		this.fecha = fecha;
		this.lugar = lugar;
	}
	public Factura() {}

	public int getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}


	public int getIdEmpleado() {
		return idEmpleado;
	}


	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	
}