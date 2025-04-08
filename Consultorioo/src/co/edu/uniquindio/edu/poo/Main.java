package co.edu.uniquindio.edu.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Consultorio consultorio = new Consultorio("Happy Clínica Dental",
				"Carrera 14 #9-15, Piso 2, Local 2, Armenia, Quindío. ");

		String nombres = "";
		String apellidos = "";
		String identificacion = "";

		int opcionMenu;

		do {

			opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"MENU PRINCIPAL\n" + "1- Registrar paciente\n" + "2- Eliminar paciente\n"
							+ "3- Mostrar lista de pacientes\n" + "4- Mostrar lista de pacientes con revisiones gratuitas\n" + "5- Registrar odontologo\n" 
							+ "6- Eliminar odontologo\n" + "7- Mostrar lista de odontologos\n" + "8- Salir"));

			switch (opcionMenu) {
			case 1:
				nombres = JOptionPane.showInputDialog("Ingrese el nombre del paciente que desea registrar:");
				apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del paciente que desea registrar:");
				identificacion = JOptionPane
						.showInputDialog("Ingrese la identificacion del paciente que desea registrar:");
				String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
				String fechaStr = JOptionPane.showInputDialog("Ingrese la última fecha de consulta (YYYY-MM-DD):");
				LocalDate ultimaFecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
				int cantidadTratamientos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de tratamientos:"));
				consultorio.registrarPaciente(nombres, apellidos, identificacion, telefono, ultimaFecha, cantidadTratamientos);

				break;
			case 2:
				identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del paciente que desee eliminar");
				consultorio.eliminarPaciente(identificacion);

				break;
			case 3:
				JOptionPane.showMessageDialog(null, consultorio.toStringPacientes(), "Lista de Pacientes",
						JOptionPane.INFORMATION_MESSAGE);

				break;
				
			case 4:
				 consultorio.actualizarListaPacientesGratuitos(); 
				    JOptionPane.showMessageDialog(null, consultorio.toStringConsultasGratis());
				    break;
			    
			case 5:
				nombres = JOptionPane.showInputDialog("Ingrese el nombre del odontólogo que desea registrar:");
                apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del odontólogo que desea registrar:");
                identificacion = JOptionPane.showInputDialog("Ingrese la identificación del odontólogo que desea registrar:");
                String numeroLicencia = JOptionPane.showInputDialog(null, "Ingrese el número de licencia del odontologo que desea registrar: ");
                String[] opcionesEspecialidad = { "ODONTOLOGIA_GENERAL", "ORTODONCIA", "ENDODONCIA", "CIRUGIA_ORAL" };
                String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione la especialidad:",
                        "Especialidad", JOptionPane.QUESTION_MESSAGE, null, opcionesEspecialidad,
                        opcionesEspecialidad[0]);
                Especialidad especialidad = Especialidad.valueOf(seleccion);
                consultorio.registrarOdontologo(nombres, apellidos, identificacion, numeroLicencia, especialidad);
                break;

			case 6:
				identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del odontologo que desee eliminar");
				consultorio.eliminarOdontologo(identificacion);
				break;

			case 7:
				JOptionPane.showMessageDialog(null, consultorio.toStringOdontologos(), "Lista de odontologos",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Saliendo del programa, hasta pronto");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Dato ingresado no valido, intentelo de nuevo");

			}

		}while(opcionMenu!=8);

}

}
