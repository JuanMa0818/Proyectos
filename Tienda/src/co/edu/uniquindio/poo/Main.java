package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Tienda tienda = new Tienda("Rindemax", "Barrio Granada de Armenia, Quindío, en la Carrera 23 #10-28\n");

		String nombre = "";
		String identificacion = "";
		String codigoProducto = "";
		int stockDisponible = 0;

		int opcionMenu;

		do {

			opcionMenu = Integer.parseInt(JOptionPane.showInputDialog(null,
					"MENU PRINCIPAL\n" + "1- Registrar comprador\n" + "2- Eliminar comprador\n"
							+ "3- Mostrar lista de compradores registrados \n" + "4- Registrar producto\n"
							+ "5- Eliminar producto\n" + "6- Mostrar lista de productos registrados\n"
							+ "7- Hacer venta\n" + "8- Mostrar lista de ventas\n" + "9- Salir"));

			switch (opcionMenu) {
			case 1:
				nombre = JOptionPane.showInputDialog(null,
						"Ingrese el nombre del comprador que desea registrar en la tienda");
				identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del comprador que desea registrar en la tienda");
				String direccion = JOptionPane.showInputDialog(null,
						"Ingrese la dirección del comprador que desea registrar en la tienda");
				String telefono = JOptionPane.showInputDialog(null,
						"Ingrese el número telefonico del comprador que desea registrar en la tienda");
				String email = JOptionPane.showInputDialog(null,
						"Ingrese el email del comprador que desea registrar en la tienda");
				tienda.registrarCliente(nombre, identificacion, direccion, telefono, email);
				break;
			case 2:
				identificacion = JOptionPane.showInputDialog(null,
						"Ingrese la identificacion del  usuario que desee eliminar");
				tienda.eliminarCliente(identificacion);
				break;
			case 3:
				tienda.getListaClientes();
				JOptionPane.showMessageDialog(null, tienda.toStringCompradores());
				break;
			case 4:
				nombre = JOptionPane.showInputDialog(null,
						"Ingrese el nombre del producto que desea registrar en la tienda");
				codigoProducto = JOptionPane.showInputDialog(null,
						"Ingrese el codigo del producto que desea registrar en la tienda");
				double precio = Double.parseDouble(JOptionPane.showInputDialog(null,
						"Ingrese el precio del producto que desea registrar en la tienda"));
				String categoria = JOptionPane.showInputDialog(null,
						"Ingrese la categoria del producto que desea registrar en la tienda");
				stockDisponible = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Ingrese la cantidad del producto que desea registrar en la tienda"));
				tienda.registrarProducto(nombre, codigoProducto, precio, categoria, stockDisponible);
				break;
			case 5:
				stockDisponible = Integer.parseInt(
						JOptionPane.showInputDialog(null, "Ingrese el codigo del producto que desea eliminar"));
				tienda.eliminarProducto(codigoProducto);

				break;

			case 6:
				tienda.getListaProductos();
				JOptionPane.showMessageDialog(null, tienda.toStringProductos());
				break;

			case 7:
				identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación del cliente:");
				codigoProducto = JOptionPane.showInputDialog(null, "Ingrese el código del producto:");
				int cantidadCompra = Integer
						.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a comprar:"));
				tienda.hacerVenta(identificacion, codigoProducto, cantidadCompra);
				break;

			case 8:
				tienda.getListaVentas();
				JOptionPane.showMessageDialog(null, tienda.toStringVenta());
				break;

			case 9:
				JOptionPane.showMessageDialog(null, "Saliendo del programa, hasta pronto");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Dato ingresado no valido, intentelo de nuevo");

			}

		} while (opcionMenu != 9);
	}
}
