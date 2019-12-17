

package implementacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Archivo;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Archivo> archivos = new ArrayList<Archivo>();

		int op = 0;

		do {

			op = Integer.parseInt(
					JOptionPane.showInputDialog("0. Salir\n" + "1. Subir Archivo\n" + "2. Mostrar Informacion\n"));

			switch (op) {
			case 0:
				JOptionPane.showMessageDialog(null, "Adios!");

				break;
			case 1:
				Archivo a = new Archivo();

				a.solicitarInformacion();

				archivos.add(a);
				break;
			case 2:
				String r = "";

				for (int i = 0; i < archivos.size(); i++)
					r += archivos.get(i);

				JOptionPane.showMessageDialog(null, r);

			default:
				break;
			}

		} while (op != 0);

	}

}
