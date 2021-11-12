/**
 * 
 */
package com.demo.response;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Pablo Jara
 *
 */
public class CarritoResp {

	private UUID idCarrito;
	
	private String descripcion;

	private Double precioTotal;

	private String estado;
	
	private List<CarritoDetalleResp> listaProducto = new ArrayList<>();

	public UUID getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(UUID idCarrito) {
		this.idCarrito = idCarrito;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CarritoDetalleResp> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<CarritoDetalleResp> listaProducto) {
		this.listaProducto = listaProducto;
	}
}
