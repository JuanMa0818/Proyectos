package co.edu.uniquindio.edu.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Consultorio {
	private String nombre;
	private String direccion;
	private List<Paciente> listaPacientes;
	private List<Odontologo> listaOdontologos;
	private List<Paciente> listaPacientesGratuitos;

	public Consultorio(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaPacientes = new ArrayList<Paciente>();
		this.listaOdontologos = new ArrayList<Odontologo>();
		this.listaPacientesGratuitos = new ArrayList <Paciente> ();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void registrarPaciente(String nombre, String apellido, String identificacion, String telefono,
			LocalDate ultimaFecha, int cantidadTratamientos) {
		Paciente encontrado = null;
		Paciente nuevoPaciente = null;

		encontrado = buscarPaciente(identificacion);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El paciente" + encontrado.nombre() + " ya se encuentra registrado en la clinica");

		}

		else {

			nuevoPaciente = new Paciente(nombre, apellido, identificacion, telefono, ultimaFecha, cantidadTratamientos);
			listaPacientes.add(nuevoPaciente);
			JOptionPane.showMessageDialog(null, "El paciente fue registrado exitosamente");

		}
	}

	public Paciente buscarPaciente(String identificacion) {

		for (Paciente pacienteAux : listaPacientes) {
			if (pacienteAux.identificacion().equals(identificacion)) {
				return pacienteAux;

			}
		}
		return null;
	}
	
	public List<Paciente> eliminarPaciente(String identificacion) {

		for (Paciente pacienteAux : listaPacientes) {
			if(pacienteAux.identificacion().equals(identificacion)) {
				listaPacientes.remove(pacienteAux);
				JOptionPane.showMessageDialog(null, "El Estudiante ha sido eliminado");
				break;

			}

		}

		return listaPacientes;

	}
	
	public void actualizarListaPacientesGratuitos() {
	    listaPacientesGratuitos.clear(); 
	    for (Paciente paciente : listaPacientes) {
	        if (paciente.cantidadTratamientos() > 5) {
	            listaPacientesGratuitos.add(paciente);
	        }
	    }
	}

	public void registrarOdontologo(String nombre, String apellidos, String identificacion, String numeroLicencia,
			Especialidad especialidad) {
		Odontologo encontrado = null;
		Odontologo nuevoOdontologo = null;

		encontrado = buscarOdontologo(identificacion);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El odontologo" + encontrado.nombre() + " ya se encuentra registrado en la clinica");

		}

		else {

			nuevoOdontologo = new Odontologo(nombre, apellidos, identificacion, numeroLicencia, especialidad);
			listaOdontologos.add(nuevoOdontologo);
			JOptionPane.showMessageDialog(null, "El odontologo fue registrado exitosamente");

		}
	}

	public Odontologo buscarOdontologo(String identificacion) {

		for (Odontologo odontologoAux : listaOdontologos) {
			if (odontologoAux.identificacion().equals(identificacion)) {
				return odontologoAux;

			}
		}
		return null;
	}

	public List<Odontologo> eliminarOdontologo(String identificacion) {

		for (Odontologo odontologoAux : listaOdontologos) {
			if(odontologoAux.identificacion().equals(identificacion)) {
				listaOdontologos.remove(odontologoAux);
				JOptionPane.showMessageDialog(null, "El Estudiante ha sido eliminado");
				break;

			}

		}

		return listaOdontologos;

	}
	
	public String toStringPacientes() {

		String resultado = "CLINICA: " + nombre + "\nDIRECCIÓN: " + direccion;
		StringBuilder mensaje = new StringBuilder("\nPACIENTES REGISTRADOS\n");
		for (Paciente paciente : listaPacientes) {
			mensaje.append("NOMBRE: ").append(paciente.nombre()).append("\nAPELLIDO: ").append(paciente.apellido())
					.append("\nIDENTIFICACIÓN: ").append(paciente.identificacion()).append("\nTELEFONO: ")
					.append(paciente.telefono()).append("\nULTIMA FECHA: ").append(paciente.ultimaFecha())
					.append("\n--------------------------------------------------------------------------------\n");
		}

		return resultado + mensaje.toString();
	}

	public String toStringOdontologos() {
		String resultado = "CLINICA: " + nombre + "\nDIRECCIÓN: " + direccion;
		StringBuilder mensaje = new StringBuilder("\nODONTOLOGOS REGISTRADOS\n");
		for (Odontologo odontologoAux : listaOdontologos) {
			mensaje.append("NOMBRE: ").append(odontologoAux.nombre()).append("\nAPELLIDO: ")
					.append(odontologoAux.apellidos()).append("\nIDENTIFICACIÓN: ")
					.append(odontologoAux.identificacion()).append("\nNÚMERO DE LICENCIA: ")
					.append(odontologoAux.numeroLicencia()).append("\nESPECIALIDAD: ")
					.append(odontologoAux.especialidad())
					.append("\n--------------------------------------------------------------------------------\n");
		}

		return resultado + mensaje.toString();

	}


	public String toStringConsultasGratis () {
	
	StringBuilder mensaje = new StringBuilder("Pacientes con revisión gratuita:\n");
    for (Paciente paciente : listaPacientesGratuitos) {
        mensaje.append("Nombre: ").append(paciente.nombre()).append(" ").append(paciente.apellido())
               .append("\nIdentificación: ").append(paciente.identificacion()).append("\n")
               .append("Cantidad de Tratamientos: ").append(paciente.cantidadTratamientos())
               .append("\n----------------------\n");
}
	return mensaje.toString();}}
	
