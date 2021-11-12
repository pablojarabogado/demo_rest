/**
 * 
 */
package com.demo.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.demo.config.DemoUuidDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Pablo Jara
 *
 */
public class CarritoDetallePutReq {

	@NotNull(message="El campo idCarrito no puede ser nulo.")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idCarrito;
	
	@NotNull(message="El campo itemCarrito no puede ser nulo.")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID itemCarrito;

	@NotNull(message = "El campo cantidad no puede ser nulo.")
	@Positive
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
