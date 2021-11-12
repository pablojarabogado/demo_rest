/**
 * 
 */
package com.demo.response;

import java.util.UUID;

/**
 * @author Pablo Jara
 *
 */
public class CarritoDetalleResp {

	private UUID idCarrito;

	private UUID itemCarrito;

	private UUID idProducto;

	private Integer cantidad;
	
	public UUID getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(UUID idCarrito) {
		this.idCarrito = idCarrito;
	}

	public UUID getItemCarrito() {
		return itemCarrito;
	}

	public void setItemCarrito(UUID itemCarrito) {
		this.itemCarrito = itemCarrito;
	}

	public UUID getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(UUID idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
