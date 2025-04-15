package co.edu.uniquindio.poo;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int edad;
	private String identificacion;
	private String correoElectronico;
	private String telefono;
	
	public Estudiante(String nombre, String apellido, int edad, String identificacion, String correoElectronico, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.identificacion = identificacion;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
