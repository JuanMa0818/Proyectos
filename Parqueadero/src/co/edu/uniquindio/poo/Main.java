package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int cantidadVehiculos = 0;

		while (cantidadVehiculos < 1 || cantidadVehiculos > 20) {
			cantidadVehiculos = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Ingrese la cantidad de vehículos que desea agregar (Máximo 20)"));

			if (cantidadVehiculos < 1 || cantidadVehiculos > 20) {
				JOptionPane.showMessageDialog(null, "Número inválido. Por favor, ingrese un número entre 1 y 20.");
			}
		}

		Parqueadero parqueadero = new Parqueadero("Parqueadero Piel Roja", "Cl. 22 #17117 17- a, Armenia, Quindío",
				cantidadVehiculos);

		for (int i = 0; i < cantidadVehiculos; i++) {
			String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del carro");
			String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del carro");

			parqueadero.getListaVehiculos()[i] = new Vehiculo(marca, placa);
		}

		JOptionPane.showMessageDialog(null, parqueadero);
	}
}
