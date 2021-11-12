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
@Table(name = "producto")
public class ProductoEntity {

	@Id
	@GeneratedValue
	@Column(name="id_producto")
	private UUID idProducto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;

	@Column(name="id_tipo_producto")
	private UUID idTipoProducto;

	public UUID getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(UUID idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public UUID getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(UUID idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
}

