package clases;

import javax.swing.JOptionPane;

public class Plan {

	private int minutos;
	private int mensajes;
	private int megas;
	private int costo;

	public Plan(int minutos, int mensajes, int megas, int costo) {

		this.minutos = minutos;
		this.mensajes = mensajes;
		this.megas = megas;
		this.costo = costo;
	}

	public Plan() {

	}

	public void solicitarInformacion() {

		this.minutos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los minutos"));
		this.mensajes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los mensajes"));
		this.megas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los megas"));
		this.costo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el costo"));

	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getMensajes() {
		return mensajes;
	}

	public void setMensajes(int mensajes) {
		this.mensajes = mensajes;
	}

	public int getMegas() {
		return megas;
	}

	public void setMegas(int megas) {
		this.megas = megas;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String toString() {
		return "Plan [minutos=" + minutos + ", mensajes=" + mensajes + ", megas=" + megas + ", costo=" + costo + "]";
	}

}
