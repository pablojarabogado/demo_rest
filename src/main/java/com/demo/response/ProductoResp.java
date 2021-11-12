/**
 * 
 */
package com.demo.response;

import java.util.UUID;

/**
 * @author Pablo Jara
 *
 */
public class ProductoResp {

	private UUID idProducto;

	private String nombre;

	private String sku;

	private String descripcion;

	private Double precio;

	private UUID idTipoProducto;

	public UUID getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(UUID idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public UUID getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(UUID idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
}
