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
@Table(name="tipo_producto")
public class TipoProductoEntity {

	@Id
	@GeneratedValue
	@Column(name="id_tipo_producto")
	private UUID idTipoProducto;
	
	@Column(name="tipo_producto")
	private String tipoProducto;
	
	@Column(name="con_descuento")
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
