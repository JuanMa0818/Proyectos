package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Tienda {

	private String nombre;
	private String ubicacion;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Venta> listaVentas;

	public Tienda(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.listaClientes = new ArrayList<>();
		this.listaProductos = new ArrayList<>();
		this.listaVentas = new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(ArrayList<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}

	public void registrarCliente(String nombre, String identificacion, String direccion, String telefono,
			String email) {
		Cliente encontrado = null;
		Cliente nuevoCliente = null;

		encontrado = buscarCliente(identificacion);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El Cliente" + encontrado.getNombre() + " ya se encuentra registrado en la tienda");

		}

		else {

			nuevoCliente = new Cliente(nombre, identificacion, direccion, telefono, email);
			listaClientes.add(nuevoCliente);
			JOptionPane.showMessageDialog(null, "El Cliente fue registrado exitosamente");

		}
	}

	public Cliente buscarCliente(String identificacion) {

		for (Cliente clienteAux : listaClientes) {
			if (clienteAux.getIdentificacion().equals(identificacion)) {
				return clienteAux;

			}

		}

		return null;

	}

	public ArrayList<Cliente> eliminarCliente(String identificacion) {

		for (Cliente clienteAux : listaClientes) {
			if (clienteAux.getIdentificacion().equals(identificacion)) {
				listaClientes.remove(clienteAux);
				JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado");
				break;

			}

		}

		return listaClientes;
	}

	public void registrarProducto(String nombre, String codigoProducto, double precio, String categoria,
			int stockDisponible) {
		Producto encontrado = null;
		Producto nuevoProducto = null;

		encontrado = buscarProducto(codigoProducto);
		if (encontrado != null) { // Significa que ya existe el usario en el sistema con su identificacion
			JOptionPane.showMessageDialog(null,
					"El Producto" + encontrado.getNombre() + " ya se encuentra registrado en la tienda");

		}

		else {

			nuevoProducto = new Producto(nombre, codigoProducto, precio, categoria, stockDisponible);
			listaProductos.add(nuevoProducto);
			JOptionPane.showMessageDialog(null, "El Producto fue registrado exitosamente");

		}
	}

	public Producto buscarProducto(String codigoProducto) {

		for (Producto productoAux : listaProductos) {
			if (productoAux.getCodigoProducto().equals(codigoProducto)) {
				return productoAux;

			}

		}

		return null;

	}

	public ArrayList<Producto> eliminarProducto(String codigo) {

		for (Producto productoAux : listaProductos) {
			if (productoAux.getCodigoProducto().equals(codigo)) {
				listaProductos.remove(productoAux);
				JOptionPane.showMessageDialog(null, "El producto ha sido eliminado");
				break;

			}

		}
		return listaProductos;
	}

	public void hacerVenta(String identificacionCliente, String codigoProducto, int cantidad) {
		Cliente cliente = buscarCliente(identificacionCliente);
		Producto producto = buscarProducto(codigoProducto);

		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "El cliente no está registrado.");
			return;
		}

		if (producto == null) {
			JOptionPane.showMessageDialog(null, "El producto no está registrado.");
			return;
		}

		if (producto.getStockDisponible() < cantidad) {
			JOptionPane.showMessageDialog(null, "No hay suficiente stock disponible.");
			return;
		}

		LocalDate fechaActual = LocalDate.now();
		String fechaVenta = fechaActual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		double totalVenta = producto.getPrecio() * cantidad;

		DetalleVenta detalle = new DetalleVenta(cantidad, totalVenta);

		Venta nuevaVenta = new Venta("2024-03-30", String.valueOf(totalVenta), cantidad);
		nuevaVenta.getListaDetallesVentas().add(detalle);
		listaVentas.add(nuevaVenta);

		producto.setStockDisponible(producto.getStockDisponible() - cantidad);

		JOptionPane.showMessageDialog(null, "Venta realizada.\nTotal: $" + totalVenta);
	}

	public String toStringVenta() {

		String resultado = "TIENDA: " + nombre + "\nUBICACIÓN: " + ubicacion;
		StringBuilder mensaje = new StringBuilder(
				"VENTAS REGISTRADAS\n--------------------------------------------------------------------------------\n");
		for (Venta venta : getListaVentas()) {
			mensaje.append("FECHA: ").append(venta.getFechaVenta()).append("\nTOTAL: ").append(venta.getTotal())
					.append("\nCANTIDAD COMPRADA: ").append(venta.getCantidadComprada())
					.append("\n--------------------------------------------------------------------------------\n");

		}

		return resultado + mensaje.toString();
	}

	public String toStringProductos() {

		String resultado = "TIENDA: " + nombre + "\nUBICACIÓN: " + ubicacion;
		StringBuilder mensaje = new StringBuilder(
				"PRODUCTOS REGISTRADOS\n--------------------------------------------------------------------------------\n");
		for (Producto productoAux : listaProductos) {
			mensaje.append("NOMBRE: ").append(productoAux.getNombre()).append("\nCODIGO: ")
					.append(productoAux.getCodigoProducto()).append("\nPRECIO: $").append(productoAux.getPrecio())
					.append("\nCATEGORIA: ").append(productoAux.getCategoria()).append("\nSTOCK: ")
					.append(productoAux.getStockDisponible())
					.append("\n--------------------------------------------------------------------------------\n");
		}

		return resultado + mensaje.toString();

	}

	public String toStringCompradores() {

		String resultado = "TIENDA: " + nombre + "\nUBICACIÓN: " + ubicacion;
		StringBuilder mensaje = new StringBuilder(
				"COMPRADORES REGISTRADOS\n--------------------------------------------------------------------------------\n");
		for (Cliente cliente : getListaClientes()) {
			mensaje.append("NOMBRE: ").append(cliente.getNombre()).append("\nIDENTIFICACIÓN: ")
					.append(cliente.getIdentificacion()).append("\nDIRECCIÓN: ").append(cliente.getDireccion())
					.append("\nTELEFONO: ").append(cliente.getTelefono()).append("\nEMAIL: ").append(cliente.getEmail())
					.append("\n--------------------------------------------------------------------------------\n");

		}

		return resultado + mensaje.toString();

	}
}
