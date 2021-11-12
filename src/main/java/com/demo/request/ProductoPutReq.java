/**
 * 
 */
package com.demo.request;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.demo.config.DemoUuidDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Pablo Jara
 *
 */
public class ProductoPutReq {

	@NotNull(message="El campo IdProducto no puede ser nulo.")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idProducto;

	@NotEmpty(message="El campo Nombre no puede ser nulo o vacío..")
	private String nombre;

	@NotEmpty(message="El campo Sku no puede ser nulo o vacío..")
	private String sku;

	@NotEmpty(message="El campo Descripcion no puede ser nulo o vacío..")
	private String descripcion;

	@NotNull(message="El campo Precio no puede ser nulo..")
	@Positive
	private Double precio;

	@NotNull(message="El campo IdTipoProducto no puede ser nulo.")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
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
