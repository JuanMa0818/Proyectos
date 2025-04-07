package co.edu.uniquindio.edu.poo;

import javax.swing.JOptionPane;

public class NombresReversa {

    public static void main(String[] args) {
        String listaNombres[] = new String[5];
        int contador = 0;

      
        while (contador < 5) {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese un nombre");
            listaNombres[contador] = nombre; 
            contador++;
        }

     
        String mensaje = obtenerNombresEnReversa(listaNombres);
        JOptionPane.showMessageDialog(null, mensaje);
    }

   
    public static String obtenerNombresEnReversa(String listaNombres[]) {
        StringBuilder mensaje = new StringBuilder("NOMBRES EN REVERSA:\n");

        for (int i = listaNombres.length - 1; i >= 0; i--) {  
            mensaje.append(listaNombres[i]).append("\n");
        }

        return mensaje.toString();
    }
}
