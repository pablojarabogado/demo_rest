/**
 * 
 */
package com.demo.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Pablo Jara
 *
 */
@Embeddable
public class CarritoDetalleEntityPK implements Serializable{

	private static final long serialVersionUID = -8108203157938539415L;

	@Column(name="id_carrito")
	private UUID idCarrito;
	
	@Column(name="item_carrito")
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
