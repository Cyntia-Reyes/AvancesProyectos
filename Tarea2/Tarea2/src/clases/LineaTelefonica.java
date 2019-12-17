package clases;

import javax.swing.JOptionPane;

public class LineaTelefonica {

	private String numero;
	private String marca;
	private String modelo;
	private Plan plan;

	public LineaTelefonica(String numero, String marca, String modelo, Plan plan) {
		this.numero = numero;
		this.marca = marca;
		this.modelo = modelo;
		this.plan = plan;
	}

	public LineaTelefonica() {

	}

	public void solicitarInformacion() {

		this.numero = JOptionPane.showInputDialog("Ingrese el numero");
		this.marca = JOptionPane.showInputDialog("Ingrese la marca");
		this.modelo = JOptionPane.showInputDialog("Ingrese el modelo");

		Plan planes = new Plan();

		planes.solicitarInformacion();

		this.plan = planes;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String toString() {
		return "LineaTelefonica [numero=" + numero + ", marca=" + marca + ", modelo=" + modelo + "," + plan + "]";
	}

}
