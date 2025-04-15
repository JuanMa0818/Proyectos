package co.edu.uniquindio.poo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Universidad {
	private String nombre;
	private String ubicacion;
	private ArrayList<Estudiante> listaEstudiantes;

	public Universidad(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.listaEstudiantes = new ArrayList<Estudiante>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public void registrarEstudiante(String nombre, String apellido, int edad, String identificacion,
			String correoElectronico, String telefono) {
		Estudiante encontrado = null;
		Estudiante nuevoEstudiante = null;

		encontrado = buscarEstudiante(identificacion);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El estudiante" + encontrado.getNombre() + " ya se encuentra registrado en la universidad");

		}

		else {

			nuevoEstudiante = new Estudiante(nombre, apellido, edad, identificacion, correoElectronico, telefono);
			listaEstudiantes.add(nuevoEstudiante);
			JOptionPane.showMessageDialog(null, "El estudiante fue registrado exitosamente");

		}
	}

	public Estudiante buscarEstudiante(String identificacion) {

		for (Estudiante estudianteAux : listaEstudiantes) {
			if (estudianteAux.getIdentificacion().equals(identificacion)) {
				return estudianteAux;

			}

		}

		return null;

	}

	public String toString() {

		String resultado = "UNIVERSIDAD: " + nombre + "\nUBICACIÓN: " + ubicacion + "\n";
		StringBuilder mensaje = new StringBuilder("ESTUDIANTES REGISTRADOS\n");
		for (Estudiante estudiante : getListaEstudiantes()) {
			mensaje.append("Nombre: ").append(estudiante.getNombre()).append("\nApellido: ")
					.append(estudiante.getApellido()).append("\nEdad: ").append(estudiante.getEdad())
					.append("\nIdentificacion: ").append(estudiante.getIdentificacion())
					.append("\nCorreo electronico: ").append(estudiante.getCorreoElectronico()).append("\nTelefono: ")
					.append(estudiante.getTelefono())
					.append("\n--------------------------------------------------------------------------------\n");
		}
		return resultado + mensaje.toString();

	}

}
