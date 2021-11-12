/**
 * 
 */
package com.demo.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.demo.config.DemoUuidDeserializer;
import com.demo.config.validation.CarritoDetalleGroup;
import com.demo.config.validation.CarritoGroup;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Pablo Jara
 *
 */
public class CarritoDetallePostReq {

	@NotNull(message="El campo idCarrito no puede ser nulo.",groups = CarritoDetalleGroup.class)
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idCarrito;

	@NotNull(message = "El campo idProducto no puede ser nulo.",groups = {CarritoDetalleGroup.class,CarritoGroup.class})
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idProducto;

	@NotNull(message = "El campo cantidad no puede ser nulo.",groups = {CarritoDetalleGroup.class,CarritoGroup.class})
	@Positive
	private Integer cantidad;

	public UUID getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(UUID idCarrito) {
		this.idCarrito = idCarrito;
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
