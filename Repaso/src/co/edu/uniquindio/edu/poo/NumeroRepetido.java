package co.edu.uniquindio.edu.poo;

public class NumeroRepetido {
	public static void main(String[] args) {
		
		int[] numeros = { 1,1,1,1,2,3,4 };

		int numeroRepetido = encontrarMasRepetido(numeros);

		System.out.println("El número que más se repite es el: " + numeroRepetido);
	}

	public static int encontrarMasRepetido(int[] lista) {
		int maxRepeticiones = 0;
		int numeroRepetido = lista[0];

		for (int i = 0; i < lista.length; i++) {
			int contador = 0;

			for (int j = 0; j < lista.length; j++) {
				if (lista[i] == lista[j]) {
					contador++;
				}
			}

			if (contador > maxRepeticiones) {
				maxRepeticiones = contador;
				numeroRepetido = lista[i];
			}
		}

		return numeroRepetido;
	}
}
