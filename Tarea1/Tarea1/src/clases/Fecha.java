package clases;

public class Fecha {

	private int dia;
	private int mes;
	private int year;

	public Fecha(int dia, int mes, int year) {

		this.dia = dia;
		this.mes = mes;
		this.year = year;
	}

	public Fecha() {

	}

	public void verificarFecha(String fe) {
		String partes[] = fe.split("-");

		this.dia = Integer.parseInt(partes[0]);
		this.mes = Integer.parseInt(partes[1]);
		this.year = Integer.parseInt(partes[2]);

	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", year=" + year + "]";
	}

}
