package co.edu.uniquindio.edu.poo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

public class Batallon {
    private String ubicacion;
    private String nombre;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Mision> listaMisiones;
    private ArrayList<Soldado> listaSoldados;

    public Batallon(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.listaVehiculos = new ArrayList<Vehiculo>();
        this.listaMisiones = new ArrayList<Mision>();
        this.listaSoldados = new ArrayList<Soldado>();

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.ubicacion = Ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public ArrayList<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(ArrayList<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }

    public ArrayList<Soldado> getListaSoldados() {
        return listaSoldados;
    }

    public void setListaSoldados(ArrayList<Soldado> listaSoldados) {
        this.listaSoldados = listaSoldados;
    }

    public Optional<Soldado> buscarSoldado(String identificacion) {
        return listaSoldados.stream().filter(soldado -> soldado.identificacion().equals(identificacion)).findFirst();
    }

    public void registrarSoldado(Soldado soldado) {
        Optional<Soldado> existente = buscarSoldado(soldado.identificacion());

        if (existente.isPresent()) {
            JOptionPane.showMessageDialog(null, "El soldado ya está registrado.");
        } else {
            listaSoldados.add(soldado);
            JOptionPane.showMessageDialog(null, "Soldado registrado con éxito.");
        }
    }

    public void eliminarSoldado(String identificacion) {
        Optional<Soldado> existente = buscarSoldado(identificacion);

        if (existente.isPresent()) {
            listaSoldados.remove(existente.get());
            JOptionPane.showMessageDialog(null, "El soldado ha sido eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "El soldado no ha sido encontrado.");
        }
    }

    public ArrayList<Soldado> filtrarSoldadosMisiones() {
        ArrayList<Soldado> listaFiltrada = new ArrayList<>();
        for (Soldado soldado : listaSoldados) {
            if (soldado.listaMisiones().size() > 50) {
                listaFiltrada.add(soldado);
            }
        }
        return listaFiltrada;
    }

    public Optional<Vehiculo> buscarVehiculo(String identificacion) {
        return listaVehiculos.stream().filter(vehiculo -> vehiculo.getIdentificacion().equals(identificacion)).findFirst();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        Optional<Vehiculo> existente = buscarVehiculo(vehiculo.getIdentificacion());

        if (existente.isPresent()) {
            JOptionPane.showMessageDialog(null, "El vehiculo ya está registrado.");
        } else {
            listaVehiculos.add(vehiculo);
            JOptionPane.showMessageDialog(null, "Vehiculo registrado con éxito.");
        }
    }

    public void eliminarVehiculo(String identificacion) {
        Optional<Vehiculo> existente = buscarVehiculo(identificacion);

        if (existente.isPresent()) {
            listaVehiculos.remove(existente.get());
            JOptionPane.showMessageDialog(null, "El vehiculo ha sido eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "El vehiculo no ha sido encontrado.");
        }
    }

    public Optional<Mision> buscarMision(String fecha) {
        return listaMisiones.stream().filter(mision -> mision.getFecha().equals(fecha)).findFirst();
    }

    public void registrarMision(Mision mision, String identificacionSoldado, String identificacionVehiculo) {
        Optional<Mision> misionAux = buscarMision(mision.getFecha());

        if (misionAux.isPresent()) {
            JOptionPane.showMessageDialog(null, "La mision ya está registrada");
        } else {
            Optional<Soldado> soldadoAux = buscarSoldado(identificacionSoldado);
            if (soldadoAux.isPresent()) {
                Soldado soldado = soldadoAux.get();
                mision.agregarSoldado(soldado);
            }
            Optional<Vehiculo> vehiculoAux = buscarVehiculo(identificacionVehiculo);
            if (vehiculoAux.isPresent()) {
                Vehiculo vehiculo = vehiculoAux.get();
                mision.agregarVehiculo(vehiculo);
            }
            listaMisiones.add(mision);
            JOptionPane.showMessageDialog(null, "Mision registrada con exito.");
        }
    }


    public String toStringSoldado() {
        String mensaje = nombre + "\n" + ubicacion;
        StringBuilder resultado = new StringBuilder("\nLISTA DE SOLDADOS\n--------------------------------------------------------------------------------\n");
        for (Soldado soldado : listaSoldados) {
            resultado.append("Nombre: ").append(soldado.nombres()).append("\nApellido: ").append(soldado.apellidos()).append("\nIdentificacion: ").append(soldado.identificacion()).append("\nMisiones Completadas: ").append(soldado.listaMisiones().size()).append("\n--------------------------------------------------------------------------------\n");
        }
        return mensaje + resultado.toString();
    }

    public String toStringSoldadosFiltrado() {
        ArrayList<Soldado> soldadosFiltrados = filtrarSoldadosMisiones();
        String mensaje = nombre + "\n" + ubicacion;
        StringBuilder resultado = new StringBuilder("\nSOLDADOS CON MÁS DE 50 MISIONES\n--------------------------------------------------------------------------------\n");

        for (Soldado soldado : soldadosFiltrados) {
            resultado.append("Nombre: ").append(soldado.nombres()).append("\nApellido: ").append(soldado.apellidos()).append("\nIdentificación: ").append(soldado.identificacion()).append("\nMisiones completadas: ").append(soldado.listaMisiones().size()).append("\n--------------------------------------------------------------------------------\n");
        }
        return mensaje + resultado.toString();
    }

    public String toStringSoldadoMision() {
        StringBuilder resultado = new StringBuilder("\nLISTA DE SOLDADOS\n--------------------------------------------------------------------------------\n");
        for (Soldado soldado : listaSoldados) {
            resultado.append("* ").append(soldado.nombres()).append(" ").append(soldado.apellidos()).append(", ").append(soldado.identificacion()).append("\n--------------------------------------------------------------------------------\n");
        }
        return resultado.toString();
    }

    public String toStringVehiculo() {
        String mensaje = nombre + "\n" + ubicacion;
        StringBuilder resultado = new StringBuilder("\nLISTA DE VEHICULOS\n--------------------------------------------------------------------------------\n");
        for (Vehiculo vehiculo : listaVehiculos) {
            resultado.append("Identificacion: ").append(vehiculo.getIdentificacion()).append("\nModelo: ").append(vehiculo.getModelo()).append("\nAño: ").append(vehiculo.getAnio()).append("\nKilometraje: ").append(vehiculo.getKilometraje()).append("\nESTADO OPERATIVO: ").append(vehiculo.getEstadoOperacion()).append("\n--------------------------------------------------------------------------------");
        }
        return mensaje + resultado.toString();
    }

    public String toStringVehiculoMision() {
        StringBuilder resultado = new StringBuilder("\nLISTA DE VEHICULOS\n--------------------------------------------------------------------------------\n");
        for (Vehiculo vehiculo : listaVehiculos) {
            resultado.append("* ").append(vehiculo.getIdentificacion()).append(", ").append(vehiculo.getModelo()).append(", ").append(vehiculo.getEstadoOperacion()).append("\n--------------------------------------------------------------------------------\n");
        }
        return resultado.toString();
    }

    public String toStringMision() {
        String mensaje = nombre + "\n" + ubicacion;
        StringBuilder resultado = new StringBuilder("\nLISTA DE MISIONES\n--------------------------------------------------------------------------------\n");
        for (Mision mision : listaMisiones) {
            resultado.append("Fecha: ").append(mision.getFecha()).append("\nUbicacion: ").append(mision.getUbicacion()).append("\nSoldado a cargo: ");
            for (Soldado soldado : mision.getListaSoldadosMision()) {
                resultado.append("\nNombre: ").append(soldado.nombres()).append(" ").append(soldado.apellidos()).append("\nIdentificación: ").append(soldado.identificacion()).append("\n--------------------------------------------------------------------------------\nVehiculo destinado: ");
                for (Vehiculo vehiculo : mision.getListaVehiculosMision()) {
                    resultado.append("\nModelo: ").append(vehiculo.getModelo()).append("\nAño: ").append(vehiculo.getAnio()).append("\nKilometraje: ").append(vehiculo.getKilometraje()).append("\n");
                }
            }
        }
        return mensaje + resultado.toString();
    }
}


