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

	public void registrarEstudiante(String nombre, String identificacion) {
		Estudiante encontrado = null;
		Estudiante nuevoEstudiante = null;

		encontrado = buscarEstudiante(identificacion);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El estudiante" + encontrado.getNombre() + " ya se encuentra registrado en la universidad");

		}

		else {
		
		nuevoEstudiante = new Estudiante(nombre, identificacion);
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

	public ArrayList<Estudiante> eliminarEstudiante(String identificacionEliminar) {

		for (Estudiante estudianteAux : listaEstudiantes) {
			if (estudianteAux.getIdentificacion().equals(identificacionEliminar)) {
				listaEstudiantes.remove(estudianteAux);
				JOptionPane.showMessageDialog(null, "El Estudiante ha sido eliminado");
				break;

			}

		}

		return listaEstudiantes;

	}

	public ArrayList<Estudiante> ingresarNota(String identificacion, String nombreNota, float valorNota) {
		Estudiante estudiante = buscarEstudiante(identificacion);

		if (estudiante != null) {
			estudiante.ingresarNota(nombreNota, valorNota);
			
		}

		else {
			JOptionPane.showMessageDialog(null, "El estudiante no existe"); 
		}

		return listaEstudiantes;

	}

	public ArrayList<Estudiante> cambiarNota(String identificacion, String cambiarNotaNombre, float cambiarValorNota) {
		Estudiante estudiante = buscarEstudiante(identificacion);

		estudiante.cambiarNota(cambiarNotaNombre, cambiarValorNota);

		return listaEstudiantes;

	}

	public float obtenerPromedioGeneral() {

		float promedio = 0;

		for (Estudiante estudiante : listaEstudiantes) {
			promedio += estudiante.calcularPromedio();

		}

		float definitiva = promedio / listaEstudiantes.size();

		return definitiva;

	}

	public String toString() {

		String resultado = "UNIVERSIDAD: " + nombre + "\nUBICACIÓN: " + ubicacion + "\n";
		StringBuilder mensaje = new StringBuilder("ESTUDIANTES REGISTRADOS\n");
		for (Estudiante estudiante : getListaEstudiantes()) {
			mensaje.append("Nombre: ").append(estudiante.getNombre()).append("\n").append("Identificacion: ")
					.append(estudiante.getIdentificacion()).append("\n")
					.append("Promedio: ").append(estudiante.calcularPromedio()).append("\n--------------------------------------------------------------------------------\n");
		}
		return resultado + mensaje.toString();

	}

}