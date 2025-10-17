package org.uniquindio.edu.co.poo.parcial02.model;

import org.uniquindio.edu.co.poo.parcial02.controller.Tablacontroller;

public class SistemaInmobiliarioFacade {
    private static SistemaInmobiliarioFacade instance;

    private SistemaInmobiliarioFacade() {
    }

    public static SistemaInmobiliarioFacade getInstance() {
        if (instance == null) {
            instance = new SistemaInmobiliarioFacade();
        }
        return instance;
    }

    public boolean registrarInmueble(String tipo, double precio, String ciudad,
                                     int numHabitaciones, int numPisos) {
        try {
            Inmueble inmueble = crearInmueble(tipo, precio, ciudad, numHabitaciones, numPisos);
            Tablacontroller.agregarInmuebleStatic(inmueble);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Inmueble crearInmueble(String tipo, double precio, String ciudad,
                                   int numHabitaciones, int numPisos) {
        switch (tipo) {
            case "CASA":
                return new Casa(precio, ciudad, numHabitaciones, numPisos);
            case "APARTAMENTO":
                return new Apartamento(precio, ciudad, numHabitaciones, numPisos);
            case "FINCA":
                return new Finca(precio, ciudad, numHabitaciones, numPisos);
            case "LOCAL":
                return new Local(precio, ciudad, numHabitaciones, numPisos);
            default:
                throw new IllegalArgumentException("Tipo de inmueble no válido");
        }
    }
}
