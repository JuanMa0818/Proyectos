package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Universidad universidad = new Universidad("Universidad del Quindio",
				"Carrera 15 Calle 12 Norte Armenia, Quindío, Colombia");

		String nombre = "";
		String identificacion = "";
		int cantidadNotas = 0;

		int opcionMenu;

		do {

			opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"MENU PRINCIPAL\n" + "1- Registrar estudiante\n" + "2- Registrar notas estudiante\n"
							+ "3- Cambiar nota estudiante\n" + "4- Eliminar estudiante\n"
							+ "5- Mostrar lista de estudiantes registrados\n" + "6- Salir"));

			switch (opcionMenu) {
			case 1:
				nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario que desee agregar");
				identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del usuario que desee agregar");
				universidad.registrarEstudiante(nombre, identificacion);
				break;
			case 2:
				identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificacion del estudiante");
				String nombreNota = JOptionPane.showInputDialog(null,
						"Ingrese el nombre de la nota de (" + nombre + ")");
				float valorNota = Float.parseFloat(
						JOptionPane.showInputDialog(null, "Ingrese el valor de la nota (" + nombreNota + ")"));
				universidad.ingresarNota(identificacion, nombreNota, valorNota);
				break;
			case 3:
				String cambiarNotaNombre = JOptionPane.showInputDialog(null,
						"Ingrese el nombre de la nota a la que desea cambiar su valor");
				float cambiarValorNota = Float.parseFloat(JOptionPane.showInputDialog(null,
						"Ingrese el nuevo valor de la nota (" + cambiarNotaNombre + ")"));
				universidad.cambiarNota(identificacion, cambiarNotaNombre, cambiarValorNota);
				break;
			case 4:
				String identificacionEliminar = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del  usuario que desee eliminar");
				universidad.eliminarEstudiante(identificacionEliminar);

				break;
			case 5:
				universidad.getListaEstudiantes();
				JOptionPane.showMessageDialog(null, universidad);

				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Saliendo del programa");
				System.exit(0);

				break;

			default:
				JOptionPane.showMessageDialog(null, "Dato ingresado no valido, intentelo de nuevo");

				Estudiante estudiante = new Estudiante(nombre, identificacion);

			}

		} while (opcionMenu != 6);

	}

}
