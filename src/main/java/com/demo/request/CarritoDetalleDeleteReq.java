/**
 * 
 */
package com.demo.request;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.demo.config.DemoUuidDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Pablo Jara
 *
 */
public class CarritoDetalleDeleteReq {

	@NotNull(message="El campo idCarrito no puede ser nulo  .")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idCarrito;
	
	@NotNull(message="El campo itemCarrito no puede ser nulo  .")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID itemCarrito;

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
	
	
}
