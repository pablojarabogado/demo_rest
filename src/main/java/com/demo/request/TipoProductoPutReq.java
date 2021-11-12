/**
 * 
 */
package com.demo.request;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.config.DemoUuidDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Pablo Jara
 *
 */
public class TipoProductoPutReq {

	@NotNull(message="El campo IdTipoProducto no puede ser nulo..")
	@JsonDeserialize(using = DemoUuidDeserializer.class)
	private UUID idTipoProducto;

	@NotEmpty(message="El campo TipoProducto no puede ser nulo o vacío..")
	private String tipoProducto;

	@NotNull(message="El campo conDescuento no puede ser nulo.")
	private Boolean conDescuento;

	public UUID getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(UUID idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Boolean getConDescuento() {
		return conDescuento;
	}

	public void setConDescuento(Boolean conDescuento) {
		this.conDescuento = conDescuento;
	}
}
