/**
 * 
 */
package com.demo.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.demo.config.validation.CarritoGroup;

/**
 * @author Pablo Jara
 *
 */
public class CarritoPostReq {

	@NotEmpty(message="El campo Descripcion no puede ser nulo o vacío..",groups = CarritoGroup.class)
	private String descripcion;

	@Valid
	@NotEmpty(message="La lista debe contener al menos un producto.")
	private List<CarritoDetallePostReq> listaProducto = new ArrayList<>();

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CarritoDetallePostReq> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<CarritoDetallePostReq> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
}
