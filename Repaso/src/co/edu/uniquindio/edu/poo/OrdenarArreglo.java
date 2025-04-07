package co.edu.uniquindio.edu.poo;

import javax.swing.JOptionPane;

public class OrdenarArreglo {

	public static void main(String[] args) {

		int listaNumeros[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		for (int i = 0; i < listaNumeros.length; i++) {

			for (int j = i+1; j < listaNumeros.length; j++) {
				if (listaNumeros [i] > listaNumeros [j]) {

					int temp = listaNumeros [i];
					listaNumeros [i] = listaNumeros [j];
					listaNumeros [j] = temp;

				}

			}

		}

		StringBuilder resultado = new StringBuilder("Arreglo ordenado:\n");
		for (int num : listaNumeros) {
			resultado.append(num).append(",");
		}

		JOptionPane.showMessageDialog(null, resultado.toString());
	}
}
