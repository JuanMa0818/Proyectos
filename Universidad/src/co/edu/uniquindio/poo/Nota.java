package co.edu.uniquindio.poo;

public class Nota {
	private String nombre;
	private float nota;

	public Nota(String nombre, float nota) {
		this.nombre = nombre;
		this.nota = nota;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String toString() {
		return "CLASE: PROGRAMACIÓN I\nPROFESOR: ROBINSON ARIAS";

	}

}
