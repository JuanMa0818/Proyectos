package co.edu.uniquindio.poo;

public class Estudiante {
	private String nombre;
	private String identificacion;
	private Nota listaNotas[];

	public Estudiante(String nombre, String identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.listaNotas = new Nota[5];

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public String getIdentificacion() {

		return identificacion;
	}

	public void setIdentificacion(String identificacion) {

		this.identificacion = identificacion;
	}

	public Nota[] getNota() {

		return listaNotas;
	}

	public void setNota(Nota[] nota) {

		this.listaNotas = nota;

	}

	public Nota[] ingresarNota(String nombreNota, float valorNota) {

		for (int i = 0; i < listaNotas.length; i++) {

			listaNotas[i] = new Nota(nombreNota, valorNota);

		}

		return listaNotas;

	}

	public Nota[] cambiarNota(String cambiarNombreNota, float valorNota) {

		for (int i = 0; i < listaNotas.length; i++) {
			if (listaNotas[i].getNombre().equalsIgnoreCase(cambiarNombreNota)) {
				listaNotas[i].setNota(valorNota);

			}

		}

		return listaNotas;
	}

	public float calcularPromedio(){
        int sumatoria = 0;
        float definitiva = 0;

        for(Nota notaAux : listaNotas){
            if(notaAux != null){
                sumatoria += notaAux.getNota();
            }
        }
        definitiva = sumatoria / 5;
        return definitiva;
    }
}