package edu.unah.poo.model;


import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "limpieza")
@IdClass(IdLimpieza.class)
public class Limpieza {

	@Id
	private int idLimpieza;
	@Id
	private int idEmpleado;
	@Id
	private int idLote;
	private int numEnlatados;
	private int numEmpleados;
	private LocalTime horaFin;
	private LocalTime horaInicio;
	
	@ManyToOne
	@JoinColumn(name="idEmpleado", referencedColumnName="idEmpleado", insertable= false, updatable=false)
	@JsonBackReference
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name="idLote",referencedColumnName="idLote", insertable= false, updatable=false)
	@JsonBackReference
	private Lote lote;
	
	public Limpieza(int idLimpieza, int idEmpleado, int idLote, int numEnlatados, int numEmpleados, LocalTime horaFin,
			LocalTime horaInicio,Empleado empleado, Lote lote) {
		super();
		this.idLimpieza = idLimpieza;
		this.idEmpleado = idEmpleado;
		this.idLote = idLote;
		this.numEnlatados = numEnlatados;
		this.numEmpleados = numEmpleados;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
	
	}
	
	public Limpieza() {}

	public int getIdLimpieza() {
		return idLimpieza;
	}

	public void setIdLimpieza(int idLimpieza) {
		this.idLimpieza = idLimpieza;
	}

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

	public int getNumEnlatados() {
		return numEnlatados;
	}

	public void setNumEnlatados(int numEnlatados) {
		this.numEnlatados = numEnlatados;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	
	
	
	
}
