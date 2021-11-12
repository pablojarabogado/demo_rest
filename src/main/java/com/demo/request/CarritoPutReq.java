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
public class CarritoPutReq {

	@NotNull(message="El campo IdCarrito no puede ser nulo.")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idCarrito;

	@NotNull(message="El campo Descripcion no puede ser nulo.")
	private String descripcion;

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
}
