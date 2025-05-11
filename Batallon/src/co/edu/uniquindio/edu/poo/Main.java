package co.edu.uniquindio.edu.poo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Batallon batallon = new Batallon("Cl. 26 Nte. #6599, Armenia, Quindío", "Batallón de ASPC No. 8 Cacique Calarcá");

        String identificacion;
        int opcionMenu;
        int opcionSubMenu;


        do {
            opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "MENÚ BATALLÓN\n1- REGISTRAR SOLDADO\n2- ELIMINAR SOLDADO\n3- LISTA DE SOLDADOS REGISTRADOS\n4- LISTA DE SOLDADOS CON MAS DE 50 MISIONES REALIZADAS\n5- REGISTRAR VEHICULO\n6- ELIMINAR VEHICULO\n7- LISTA DE VEHICULOS REGISTRADOS\n8- REGISTRAR MISION\n9- LISTA DE MISIONES\n10- SALIR"));
            switch (opcionMenu) {
                case 1:
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del soldado que desea registrar");
                    String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del soldado que desea registrar");
                    identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificacion del soldado que desea registrar");
                    Soldado soldado = new Soldado(nombre, apellido, identificacion, new ArrayList<>());
                    batallon.registrarSoldado(soldado);
                    break;

                case 2:
                    identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificacion del soldado que desea eliminar");
                    batallon.eliminarSoldado(identificacion);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, batallon.toStringSoldado());
                    break;

                case 4:

                    break;

                case 5:
                    identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del vehiculo que desea registrar");
                    String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo que desea registrar");
                    int anio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año del vehiculo que desea registrar"));
                    String kilometraje = JOptionPane.showInputDialog(null, "Ingrese el kilometraje del vehiculo que desea registrar");
                    EstadoOperativo estadoSeleccionado = (EstadoOperativo) JOptionPane.showInputDialog(null, "Seleccione el estado operativo", "ESTADO OPERATIVO", JOptionPane.QUESTION_MESSAGE, null, EstadoOperativo.values(), EstadoOperativo.DISPONIBLE);

                    do {
                        opcionSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "MENÚ VEHICULOS\n1- VEHICULO BLINDADO\n2- VEHICULO DE APOYO\n3- VEHICULO DE TROPA\n4- SALIR AL MENÚ PRINCIPAL"));
                        switch (opcionSubMenu) {

                            case 1:
                                int nivelBlindaje = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nivel de blindaje del vehiculo que desea registrar"));
                                VehiculoBlindado vehiculoBlindado = new VehiculoBlindado(identificacion, modelo, anio, kilometraje, estadoSeleccionado, nivelBlindaje);
                                batallon.registrarVehiculo(vehiculoBlindado);
                                opcionSubMenu = 4;
                                break;

                            case 2:
                                TipoFuncion tipoSeleccionado = (TipoFuncion) JOptionPane.showInputDialog(null, "Seleccione el tipo de funcion del vehículo", "Función del vehiculo", JOptionPane.QUESTION_MESSAGE, null, TipoFuncion.values(), TipoFuncion.LOGISTICA);
                                VehiculoApoyo vehiculoApoyo = new VehiculoApoyo(identificacion, modelo, anio, kilometraje, estadoSeleccionado, tipoSeleccionado);
                                batallon.registrarVehiculo(vehiculoApoyo);
                                opcionSubMenu = 4;
                                break;

                            case 3:
                                int capacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la capacidad de soldados transportados del vehiculo"));
                                VehiculoTropa vehiculoTropa= new VehiculoTropa(identificacion, modelo, anio, kilometraje, estadoSeleccionado, capacidadSoldados);
                                batallon.registrarVehiculo(vehiculoTropa);
                                opcionSubMenu = 4;
                                break;
                        }

                    } while (opcionSubMenu != 4);

                    break;

                case 6:
                    identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificacion del vehiculo que desea eliminar");
                    batallon.eliminarVehiculo(identificacion);
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, batallon.toStringVehiculo());
                    break;

                case 8:
                    String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de la misión que desea registrar");
                    String ubicacion = JOptionPane.showInputDialog(null, "Ingrese la ubicacion de la mision que desea registrar");
                    String identificacionSoldado = JOptionPane.showInputDialog(null, batallon.toStringSoldadoMision() + "Ingrese la identificacion del soldado que desea agregar a la mision");
                    String identificacionVehiculo = JOptionPane.showInputDialog(null, batallon.toStringVehiculoMision() + "Ingrese la identificacion del vehiculo que desea agregar a la mision");
                    Mision mision = new Mision(fecha, ubicacion);
                    batallon.registrarMision(mision, identificacionSoldado, identificacionVehiculo);
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, batallon.toStringMision());
                    break;

                case 10:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
            }

        } while (opcionMenu != 10);


    }
}