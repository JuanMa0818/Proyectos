package co.edu.uniquindio.edu.poo;

import java.util.ArrayList;

public class Mision {
    private String fecha;
    private String ubicacion;
    private ArrayList<Soldado> listaSoldadosMision;
    private ArrayList<Vehiculo> listaVehiculosMision;

    public Mision(String fecha, String ubicacion) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.listaSoldadosMision = new ArrayList<>();
        this.listaVehiculosMision = new ArrayList<>();

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Soldado> getListaSoldados() {
        return listaSoldadosMision;
    }

    public void setListaSoldados(ArrayList<Soldado> listaSoldados) {
        this.listaSoldadosMision = listaSoldados;
    }

    public ArrayList<Soldado> getListaSoldadosMision() {
        return listaSoldadosMision;
    }

    public void setListaSoldadosMision(ArrayList<Soldado> listaSoldadosMision) {
        this.listaSoldadosMision = listaSoldadosMision;
    }

    public ArrayList<Vehiculo> getListaVehiculosMision() {
        return listaVehiculosMision;
    }

    public void setListaVehiculosMision(ArrayList<Vehiculo> listaVehiculosMision) {
        this.listaVehiculosMision = listaVehiculosMision;
    }

    public void agregarSoldado(Soldado soldado) {
        listaSoldadosMision.add(soldado);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculosMision.add(vehiculo);
    }
}
