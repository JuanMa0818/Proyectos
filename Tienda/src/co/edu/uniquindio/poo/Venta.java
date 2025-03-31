package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Venta {
	private String fechaVenta;
	private String total;
	private int cantidadComprada;
	private ArrayList<DetalleVenta> listaDetallesVentas;

	public Venta(String fechaVenta, String total, int cantidadComprada) {
		this.fechaVenta = fechaVenta;
		this.total = total;
		this.cantidadComprada = cantidadComprada;
		this.listaDetallesVentas = new ArrayList<>();

	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getCantidadComprada() {
		return cantidadComprada;
	}

	public void setCantidadComprada(int cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	public ArrayList<DetalleVenta> getListaDetallesVentas() {
		return listaDetallesVentas;
	}

	public void setListaDetallesVentas(ArrayList<DetalleVenta> listaDetallesVentas) {
		this.listaDetallesVentas = listaDetallesVentas;
	}

}
