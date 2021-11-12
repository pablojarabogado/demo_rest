/**
 * 
 */
package com.demo.service;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.demo.config.ModelNotFoundExeption;
import com.demo.constant.EstadoCarritoEnum;
import com.demo.converter.CarritoDetalleConverter;
import com.demo.entity.CarritoDetalleEntity;
import com.demo.entity.CarritoDetalleEntityPK;
import com.demo.entity.CarritoEntity;
import com.demo.repository.ICarritoDetalleRepository;
import com.demo.request.CarritoDetalleDeleteReq;
import com.demo.request.CarritoDetallePostReq;
import com.demo.request.CarritoDetallePutReq;
import com.demo.response.CarritoDetalleResp;
import com.demo.utils.ValidacionGlobal;

/**
 * @author Pablo Jara
 *
 */
@Service
@Transactional
public class CarritoDetalleService {

	@Autowired
	private ICarritoDetalleRepository repo;
	
	@Autowired
	private CarritoDetalleConverter converter;
	
	@Autowired
	private ValidacionGlobal validacionGlobal;

	public CarritoDetalleResp registrarItem(CarritoDetallePostReq obj) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(obj.getIdCarrito());
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		validacionGlobal.buscarProducto(obj.getIdProducto());
		validarItemNuevo(obj);
		CarritoDetalleResp response = converter.convertToResponse(repo.save(converter.convertirPostToEntity(obj)));
		return response;
	}

	public void modificarItem(CarritoDetallePutReq obj) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(obj.getIdCarrito());
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		CarritoDetalleEntity entityEntrance = buscarDetalle(obj.getIdCarrito(), obj.getItemCarrito());
		repo.save(converter.convertirPutToEntity(entityEntrance,obj));

	}

	public void eliminarItem(CarritoDetalleDeleteReq obj) {
		CarritoEntity carrito = validacionGlobal.buscarCarrito(obj.getIdCarrito());
		EstadoCarritoEnum.isCompleto(carrito.getEstado());
		CarritoDetalleEntity entity = buscarDetalle(obj.getIdCarrito(), obj.getItemCarrito());
		repo.delete(entity);

	}

	private CarritoDetalleEntity buscarDetalle(UUID idCarrito, UUID itemCarrito) {
		CarritoDetalleEntityPK id = new CarritoDetalleEntityPK();
		id.setIdCarrito(idCarrito);
		id.setItemCarrito(itemCarrito);
		return repo.findById(id).orElseThrow(() -> new ModelNotFoundExeption(
				"No existe detalle item: " + itemCarrito + " para el carrito con Id: " + idCarrito));
	}

	private void validarItemNuevo(CarritoDetallePostReq obj) {
		CarritoDetalleEntityPK id = new CarritoDetalleEntityPK();
		id.setIdCarrito(obj.getIdCarrito());
		CarritoDetalleEntity entity = new CarritoDetalleEntity();
		entity.setPk(id);
		entity.setIdProducto(obj.getIdProducto());

		Optional<CarritoDetalleEntity> entityExample = repo.findOne(Example.of(entity));
		if(entityExample.isPresent()) {
			throw new ModelNotFoundExeption("El producto con id: "+obj.getIdProducto()
			+" ya existe en este carrito. Modifíquelo o elimine según el caso.");
		}
	}

}
