package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Universidad universidad = new Universidad("Universidad del Quindio",
				"Carrera 15 Calle 12 Norte Armenia, Quindío, Colombia");

		int opcionMenu;
		do {

			opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"MENU PRINCIPAL\n" + "1- Registrar estudiante\n" + "2- Lista de Estudiantes\n" + "3- Salir\n"));
			switch (opcionMenu) {
			case 1:
				String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario que desea registrar");
				String apellido = JOptionPane.showInputDialog(null,
						"Ingrese el apellido del usuario que desea registrar");
				int edad = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del usuario que desea registrar"));
				String identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del usuario que desea registrar");
				String correoElectronico = JOptionPane.showInputDialog(null,
						"Ingrese el correo electronico del usuario que desea registrar");
				String telefono = JOptionPane.showInputDialog(null,
						"Ingrese el número telefonico del usuario que desea registrar");
				universidad.registrarEstudiante(nombre, apellido, edad, identificacion, correoElectronico, telefono);
				break;

			case 2:
				universidad.getListaEstudiantes();
				JOptionPane.showMessageDialog(null, universidad);
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "Saliendo del programa");
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Dato ingresado no valido, intentelo de nuevo");

			}

		} while (opcionMenu != 3);

	}

}
