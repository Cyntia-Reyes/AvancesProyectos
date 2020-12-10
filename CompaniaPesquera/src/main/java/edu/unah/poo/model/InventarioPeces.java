package edu.unah.poo.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "inventariopeces")
public class InventarioPeces {

	@Id
	private int  idPez;
	private String nombre;
	private String color;
	private String tipoPez;
	private String tamanio;
	private int cantidad;
	
	
	
	
	public InventarioPeces(int idPez, String nombre, String color, String tipoPez, String tamanio, int cantidad) {
		super();
		this.idPez = idPez;
		this.nombre = nombre;
		this.color = color;
		this.tipoPez = tipoPez;
		this.tamanio = tamanio;
		this.cantidad = cantidad;
	}

	public InventarioPeces() {}

	public int getIdPez() {
		return idPez;
	}

	public void setIdPez(int idPez) {
		this.idPez = idPez;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoPez() {
		return tipoPez;
	}

	public void setTipoPez(String tipoPez) {
		this.tipoPez = tipoPez;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
