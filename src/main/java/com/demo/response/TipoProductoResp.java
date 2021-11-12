/**
 * 
 */
package com.demo.response;

import java.util.UUID;

/**
 * @author Pablo Jara
 *
 */
public class TipoProductoResp {

	private UUID idTipoProducto;

	private String tipoProducto;

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
