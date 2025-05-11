package co.edu.uniquindio.edu.poo;

public class VehiculoApoyo extends Vehiculo {
    private TipoFuncion tipoFuncion;

    public VehiculoApoyo(String identificacion, String modelo, int anio, String kilometraje, EstadoOperativo estadoOperacion,
                         TipoFuncion tipoFuncion) {
        super(identificacion, modelo, anio, kilometraje, estadoOperacion);
        this.tipoFuncion = tipoFuncion;

    }

    public TipoFuncion getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(TipoFuncion tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }



}
