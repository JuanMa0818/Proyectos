package co.edu.uniquindio.edu.poo;

public class VehiculoTropa extends Vehiculo {
    private int capacidadSoldados;

    public VehiculoTropa(String identificacion, String modelo, int anio, String kilometraje, EstadoOperativo estadoOperacion, int capacidadSoldados) {
        super (identificacion, modelo, anio, kilometraje, estadoOperacion);
        this.capacidadSoldados = capacidadSoldados;

    }

    public int getCapacidadSoldados() {
        return capacidadSoldados;
    }

    public void setCapacidadSoldados(int capacidadSoldados) {
        this.capacidadSoldados = capacidadSoldados;
    }



}
