package edu.unah.poo.model;





import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonBackReference;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "lote")
@IdClass(IdLote.class)
public class Lote {

	@Id
	private int idLote;
	@Id
	private int idEmpleado;
	@Id
	private int idProveedor;
	private String estado;
	private String tipoPescado;
	private int precioProducto;
	private int indiceCalidad;
	private String pesoProducto;
	

	@ManyToOne
	@JoinColumn(name="idEmpleado", referencedColumnName="idEmpleado", insertable= false, updatable=false)
	@JsonBackReference
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idProveedor",referencedColumnName="idProveedor", insertable= false, updatable=false)
	@JsonBackReference
	private Proveedor proveedor;
	
	

	public Lote() {}



	public Lote(int idLote, int idEmpleado, int idProveedor, String estado, String tipoPescado, int precioProducto,
			int indiceCalidad, String pesoProducto, Empleado empleado, Proveedor proveedor) {
		super();
		this.idLote = idLote;
		this.idEmpleado = idEmpleado;
		this.idProveedor = idProveedor;
		this.estado = estado;
		this.tipoPescado = tipoPescado;
		this.precioProducto = precioProducto;
		this.indiceCalidad = indiceCalidad;
		this.pesoProducto = pesoProducto;
		
	}



	public int getIdLote() {
		return idLote;
	}



	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}



	public int getIdEmpleado() {
		return idEmpleado;
	}



	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}



	public int getIdProveedor() {
		return idProveedor;
	}



	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTipoPescado() {
		return tipoPescado;
	}



	public void setTipoPescado(String tipoPescado) {
		this.tipoPescado = tipoPescado;
	}



	public int getPrecioProducto() {
		return precioProducto;
	}



	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}



	public int getIndiceCalidad() {
		return indiceCalidad;
	}



	public void setIndiceCalidad(int indiceCalidad) {
		this.indiceCalidad = indiceCalidad;
	}



	public String getPesoProducto() {
		return pesoProducto;
	}



	public void setPesoProducto(String pesoProducto) {
		this.pesoProducto = pesoProducto;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	
	
	
}