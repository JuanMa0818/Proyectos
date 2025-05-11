import javax.swing.*;

public static void main(String[] args) {
    int filas = Integer.parseInt(JOptionPane.showInputDialog("Filas:"));
    int columnas = Integer.parseInt(JOptionPane.showInputDialog("Columnas:"));

    int[][] matriz = new int[filas][columnas];

    // Ingreso de elementos
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            String entrada = JOptionPane.showInputDialog("Elemento [" + i + "][" + j + "]:");
            matriz[i][j] = Integer.parseInt(entrada);
        }
    }

    int giros = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos giros hacia la derecha?"));

    int[][] girada = girar(matriz, giros);

    // Mostrar matriz final
    StringBuilder resultado = new StringBuilder("Matriz girada:\n");
    for (int[] fila : girada) {
        for (int valor : fila) {
            resultado.append(valor).append("\t");
        }
        resultado.append("\n");
    }

    JOptionPane.showMessageDialog(null, resultado.toString());
}

public static int[][] girar(int[][] matriz, int giros) {
    int filas = matriz.length;
    int columnas = matriz[0].length;
    int total = filas * columnas;
    int[] plano = new int[total];
    int index = 0;

    // Pasar a arreglo lineal
    for (int[] fila : matriz) {
        for (int val : fila) {
            plano[index++] = val;
        }
    }

    // Girar
    int[] rotado = new int[total];
    for (int i = 0; i < total; i++) {
        rotado[(i + giros) % total] = plano[i];
    }

    // Devolver a matriz
    int[][] nueva = new int[filas][columnas];
    index = 0;
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            nueva[i][j] = rotado[index++];
        }
    }

    return nueva;
}
