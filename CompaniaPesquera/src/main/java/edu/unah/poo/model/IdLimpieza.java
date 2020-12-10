package edu.unah.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdLimpieza implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEmpleado;
	private int idLote;
	
	public IdLimpieza(int idEmpleado, int idLote) {
		super();
		this.idEmpleado = idEmpleado;
		this.idLote = idLote;
	}
	public IdLimpieza() {}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdLimpieza) {
			IdLimpieza tmpid = (IdLimpieza)obj;
			if(this.idEmpleado == tmpid.getIdEmpleado()
				&& this.idLote == tmpid.getIdLote()) {
				return true;
			}else 
				return false;
		}else return false;
		
	}
	
	
	public int hashCode() {
		return this.idEmpleado+this.idLote;
	}
	
}
