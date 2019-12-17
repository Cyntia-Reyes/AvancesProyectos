package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Archivo {

	private String nombre;
	private double tamanio;
	private User userSu;
	private ArrayList<User> userCom = new ArrayList<User>();
	private String carpeta;
	private Fecha fechaSu;
	private Fecha fechaMo;

	public Archivo(String nombre, double tamanio, User userSu, ArrayList<User> userCom, String carpeta, Fecha fechaSu,
			Fecha fechaMo) {

		this.nombre = nombre;
		this.tamanio = tamanio;
		this.userSu = userSu;
		this.userCom = userCom;
		this.carpeta = carpeta;
		this.fechaSu = fechaSu;
		this.fechaMo = fechaMo;
	}

	public Archivo() {

	}

	public void solicitarInformacion() {
 
		boolean op;
		do {

			this.nombre = JOptionPane.showInputDialog("Ingrese el Nombre del archivo", this.nombre);
			op = this.verificarNombre(this.nombre);

		} while (op == false);

		do {
			this.tamanio = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del archivo en bytes", this.tamanio));
			op = this.verificarTam(this.tamanio);
		} while (op == false);

		User a = new User();

		a.solicitarInformacion();
		this.userSu = a;

		int n;
		do {
			n = Integer.parseInt(JOptionPane.showInputDialog("¿Con cuantos usuarios compartira el archivo?"));

			if (n <= 5) {
				for (int i = 1; i <= n; i++) {

					JOptionPane.showMessageDialog(null, "Ingrese los datos del Usuario " + i);

					User b = new User();

					b.solicitarInformacion();

					userCom.add(b);

				}
			}

		} while (n > 5);

		this.carpeta = JOptionPane.showInputDialog("Nombre de la carpeta donde estara ubicado");

		String fecha1, fecha2;

		fecha1 = JOptionPane.showInputDialog("Ingrese la fecha de subida en el formato DD-MM-YYYY");
		fecha2 = JOptionPane.showInputDialog("Ingrese la fecha de modificacion en el formato DD-MM-YYYY");

		Fecha c = new Fecha();

		c.verificarFecha(fecha1);
		this.fechaSu = c;
		c.verificarFecha(fecha2);
		this.fechaMo = c;

	}

	public boolean verificarTam(double tam) {

		double peso = tam / 1000000;

		if (peso > 500) {
			return false;
		} else {
			return true;
		}

	}

	public boolean verificarNombre(String nom) {

		if (nom.contains(".bat") || nom.contains(".exe")) {
			return false;
		} else {
			return true;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTamanio() {
		return tamanio;
	}

	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}

	public User getUserSu() {
		return userSu;
	}

	public void setUserSu(User userSu) {
		this.userSu = userSu;
	}

	public ArrayList<User> getUserCom() {
		return userCom;
	}

	public void setUserCom(ArrayList<User> userCom) {
		this.userCom = userCom;
	}

	public String getCarpeta() {
		return carpeta;
	}

	public void setCarpeta(String carpeta) {
		this.carpeta = carpeta;
	}

	public Fecha getFechaSu() {
		return fechaSu;
	}

	public void setFechaSu(Fecha fechaSu) {
		this.fechaSu = fechaSu;
	}

	public Fecha getFechaMo() {
		return fechaMo;
	}

	public void setFechaMo(Fecha fechaMo) {
		this.fechaMo = fechaMo;
	}

	public String toString() {
		return "Archivo [nombre=" + nombre + ", tamanio=" + tamanio + ", userSu=" + userSu + ", userCom=" + userCom
				+ ", carpeta=" + carpeta + ", fechaSu=" + fechaSu + ", fechaMo=" + fechaMo + "]";
	}

}
