package co.edu.uniquindio.edu.poo;

import javax.swing.JOptionPane;

public class TablaMultiplicar {

	public static void main(String[] args) {

		int listaTablas[] = new int[10];

		int numero = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la tabla que desea conocer"));

		String mensaje = "TABLA DE MULTIPLICAR DEL " + numero;

		StringBuilder resultado = new StringBuilder("Tabla de multiplicar del " + numero + ":\n");

		for (int i = 0; i < listaTablas.length; i++) {

			resultado.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
		}

		JOptionPane.showMessageDialog(null, resultado.toString());
	}
}