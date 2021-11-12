/**
 * 
 */
package com.demo.utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.config.ModelNotFoundExeption;
import com.demo.entity.CarritoEntity;
import com.demo.entity.ProductoEntity;
import com.demo.entity.TipoProductoEntity;
import com.demo.repository.ICarritoRepository;
import com.demo.repository.IProductoRepository;
import com.demo.repository.ITipoProductoRepository;

/**
 * @author Pablo Jara
 *
 */
@Component
public class ValidacionGlobal{

	@Autowired
	private ITipoProductoRepository repoITipoProductoRepository;

	@Autowired
	private IProductoRepository iProductoRepository;

	@Autowired
	private ICarritoRepository iCarritoRepository;

	public TipoProductoEntity buscarTipoProducto(UUID id) {
		return repoITipoProductoRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundExeption("No se encontró Tipo Producto con Id: " + id));
	}

	public ProductoEntity buscarProducto(UUID id) {
		return iProductoRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundExeption("No se encontró Producto con Id: " + id));
	}

	public CarritoEntity buscarCarrito(UUID id) {
		return iCarritoRepository.findById(id)
				.orElseThrow(() -> new ModelNotFoundExeption("No se encontró Carrito con Id: " + id));
	}
	
	

}
