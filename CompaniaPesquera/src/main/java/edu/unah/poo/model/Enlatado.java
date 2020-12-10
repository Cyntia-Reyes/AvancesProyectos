package edu.unah.poo.model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enlatado")
public class Enlatado {

	@Id
	private int  idEnlatado;
	private String descripcion;
	private int precio;
	private int cantidadLatas;
	private String tipoPescado;
	
	
	//@OneToMany(mappedBy="enlatado",fetch=FetchType.EAGER)
	//private List<Limpieza> limpieza;
	
	
	public Enlatado(int idEnlatado, String descripcion,int precio , int cantidadLatas,String tipoPescado) {
		super();
		this.idEnlatado = idEnlatado;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadLatas = cantidadLatas;
		this.tipoPescado = tipoPescado;
		
	}

	public Enlatado() {}

	public int getIdEnlatado() {
		return idEnlatado;
	}

	public void setIdEnlatado(int idEnlatado) {
		this.idEnlatado = idEnlatado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoPescado() {
		return tipoPescado;
	}

	public void setTipoPescado(String tipoPescado) {
		this.tipoPescado = tipoPescado;
	}

	public int getCantidadLatas() {
		return cantidadLatas;
	}

	public void setCantidadLatas(int cantidadLatas) {
		this.cantidadLatas = cantidadLatas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
	
}
