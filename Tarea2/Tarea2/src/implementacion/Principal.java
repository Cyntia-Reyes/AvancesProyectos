package implementacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Cliente;

public class Principal {

	public static void main(String[] args) {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		int op = 0;

		do {
			op = Integer.parseInt(
					JOptionPane.showInputDialog("0. Salir\n" + "1. Agregar un Cliente\n" + "2. Eliminar un Cliente\n"
							+ "3. Mostrar Información Completa\n" + "4. Mostar las Líneas Telefónicas de un Cliente"));

			switch (op) {
			case 0:
				System.out.println("Adios");
				break;
			case 1:
				Cliente a = new Cliente();

				a.solicitarInformacion();

				clientes.add(a);

				break;
			case 2:
				int indiceEliminar = Integer.parseInt(
						JOptionPane.showInputDialog("¿Qué alumno desea Eliminar? (0 -" + (clientes.size() - 1) + ")"));
				clientes.remove(indiceEliminar);
				JOptionPane.showMessageDialog(null, "Se eliminó el registro");

				break;
			case 3:
				String registro = "";

				for (int i = 0; i < clientes.size(); i++) {
					registro += clientes.get(i) + "\n";
				}

				JOptionPane.showMessageDialog(null, registro);

				break;
			case 4:

				int indice = Integer
						.parseInt(JOptionPane.showInputDialog("Indice del user al cual quiere ver las lineas"));

				Cliente cliente = clientes.get(indice);

				JOptionPane.showMessageDialog(null, cliente.getLinea());

				break;

			default:
				break;
			}
		} while (op != 0);

	}

}
