package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdLote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEmpleado;
	private int idProveedor;
	
	
	public IdLote(int idEmpleado, int idProveedor) {
		super();
		this.idEmpleado = idEmpleado;
		this.idProveedor = idProveedor;
	}
	public IdLote() {}
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdLote) {
			IdLote tmpid = (IdLote)obj;
			if(this.idEmpleado == tmpid.getIdEmpleado()
				&& this.idProveedor == tmpid.getIdProveedor()) {
				return true;
			}else 
				return false;
		}else return false;
		
	}
	
	
	public int hashCode() {
		return this.idEmpleado+this.idProveedor;
	}
	
}
