/**
 * 
 */
package com.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pablo Jara
 *
 */
@Entity
@Table(name="carrito")
public class CarritoEntity {

	@Id
	@GeneratedValue
	@Column(name="id_carrito")
	private UUID idCarrito;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio_total")
	private Double precioTotal;
	
	@Column(name="estado")
	private String estado;

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

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
