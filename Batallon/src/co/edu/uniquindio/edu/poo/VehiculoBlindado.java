package co.edu.uniquindio.edu.poo;

public class VehiculoBlindado extends Vehiculo {
    private int nivelBlindaje;

    public VehiculoBlindado(String identificacion, String modelo, int anio, String kilometraje, EstadoOperativo estadoOperacion,
                            int nivelBlindaje) {
        super(identificacion, modelo, anio, kilometraje, estadoOperacion);
        this.nivelBlindaje = nivelBlindaje;

    }

    public int getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }

}
