/**
 * 
 */
package com.demo.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Pablo Jara
 *
 */
public class TipoProductoPostReq {

	@NotEmpty(message="El campo TipoProducto no puede ser nulo o vacío..")
	private String tipoProducto;

	@NotNull(message="El campo conDescuento no puede ser nulo.")
	private Boolean conDescuento;

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
