/**
 * 
 */
package com.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

/**
 * @author Pablo Jara
 *
 */
@Entity
@Table(name="carrito_detalle")
public class CarritoDetalleEntity {

	@EmbeddedId
	private CarritoDetalleEntityPK pk;
	
	@Column(name="id_producto")
	private UUID idProducto;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	public CarritoDetalleEntityPK getPk() {
		return pk;
	}

	public void setPk(CarritoDetalleEntityPK pk) {
		this.pk = pk;
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
