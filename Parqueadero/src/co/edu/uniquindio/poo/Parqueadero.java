package co.edu.uniquindio.poo;

public class Parqueadero {

	private String nombre;
	private String ubicacion;
	private Vehiculo listaVehiculos[];

	public Parqueadero(String nombre, String ubicacion, int cantidadVehiculos) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.listaVehiculos = new Vehiculo[cantidadVehiculos];
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

	public Vehiculo[] getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(Vehiculo[] listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public Vehiculo[] ordenarVehiculos() {

		Vehiculo aux;

		for (int i = 0; i < listaVehiculos.length - 1; i++) {
			for (int j = 0; j < listaVehiculos.length - 1; j++) {
				if (listaVehiculos[j] != null && listaVehiculos[j + 1] != null)
					if (listaVehiculos[j].getPlaca().compareTo(listaVehiculos[j + 1].getPlaca()) > 0) {
						aux = listaVehiculos[j];
						listaVehiculos[j] = listaVehiculos[j + 1];
						listaVehiculos[j + 1] = aux;

					}

			}

		}

		return listaVehiculos;

	}

	public String toString() {

		ordenarVehiculos();
		
		String resultado = "PARQUEADERO " + nombre + "\nUBICACIÓN: " + ubicacion + "\n";
		StringBuilder mensaje = new StringBuilder("VEHÍCULOS REGISTRADOS:\n");

		if (listaVehiculos == null) {
			mensaje.append("No hay vehículos registrados.\n");
		} else {
			for (Vehiculo vehiculo : listaVehiculos) {
				if (vehiculo != null) {
					mensaje.append("Marca: ").append(vehiculo.getMarca()).append(", Placa: ")
							.append(vehiculo.getPlaca()).append("\n");
				}
			}
		}

		return resultado + mensaje.toString();
	}
}