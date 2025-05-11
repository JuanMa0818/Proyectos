package co.edu.uniquindio.edu.poo;

public class Vehiculo {
    private String identificacion;
    private String modelo;
    private int anio;
    private String kilometraje;
    private EstadoOperativo estadoOperacion;

    public Vehiculo(String identificacion, String modelo, int anio, String kilometraje, EstadoOperativo estadoOperacion) {
        this.identificacion = identificacion;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.estadoOperacion = estadoOperacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public EstadoOperativo getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(EstadoOperativo estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

}




