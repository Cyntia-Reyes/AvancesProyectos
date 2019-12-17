package clases;

import javax.swing.JOptionPane;

public class User {

	private String nombre;
	private String correo;

	public User(String nombre, String correo) {

		this.nombre = nombre;
		this.correo = correo;
	}

	public User() {

	}

	public void solicitarInformacion() {
		this.nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Usuario");

		boolean op;
		do {

			this.correo = JOptionPane.showInputDialog("Ingrese el correo");
			op = this.verificarCorreo();

		} while (op == false);
	}

	public boolean verificarCorreo() {

		int p, u;

		p = this.correo.indexOf('@');
		u = this.correo.lastIndexOf('@');

		if (p == -1) {
			return false;
		}

		if (p == u) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Ingrese un correo valido");
			return false;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String toString() {
		return "User [nombre=" + nombre + ", correo=" + correo + "]";
	}

}
