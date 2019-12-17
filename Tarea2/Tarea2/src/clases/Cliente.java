package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cliente {

	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private String identidad;
	private String correo;
	private String direccion;
	private ArrayList<LineaTelefonica> linea = new ArrayList<LineaTelefonica>();

	public Cliente(String nombre, String apellido, int edad, String genero, String identidad, String correo,
			String direccion, ArrayList<LineaTelefonica> linea) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.identidad = identidad;
		this.correo = correo;
		this.direccion = direccion;
		this.linea = linea;
	}

	public Cliente() {

	}

	public void solicitarInformacion() {

		this.nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
		this.apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
		this.edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente"));
		this.genero = JOptionPane.showInputDialog("Ingrese el genero del cliente");
		this.direccion = JOptionPane.showInputDialog("Ingrese la Direccion");

		boolean op;
		do {

			this.correo = JOptionPane.showInputDialog("Ingrese el Correo");
			op = this.verificarCorreo();

		} while (op == false);

		do {

			this.identidad = JOptionPane.showInputDialog("Ingrese la identidad", this.identidad);
			op = this.verificarIdentidad(identidad);

		} while (op == false);

		int i;

		i = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas líneas adquirira?"));
		for (int j = 1; j <= i; j++) {

			JOptionPane.showMessageDialog(null, "Ingrese la Línea " + j);

			LineaTelefonica lineas = new LineaTelefonica();

			lineas.solicitarInformacion();

			linea.add(lineas);

		}

	}

	public boolean verificarCorreo() {

		int p, u;

		p = this.correo.lastIndexOf('@');
		u = this.correo.indexOf('@');

		if (p == -1) {
			return false;
		}
		if (p == u) {
			return true;
		} else {
			JOptionPane.showConfirmDialog(null, "Ingrese un correo válido");
			return false;
		}

	}

	public boolean verificarIdentidad(String identidad1) {
		String partes[] = identidad1.split("-");

		if (partes[0].length() == 4) {
			if (partes[1].length() == 4) {
				if (partes[2].length() == 5) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<LineaTelefonica> getLinea() {
		return linea;
	}

	public void setLinea(ArrayList<LineaTelefonica> linea) {
		this.linea = linea;
	}

	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero
				+ ", identidad=" + identidad + ", correo=" + correo + ", direccion=" + direccion + ", linea=" + linea
				+ "]";
	}

}
